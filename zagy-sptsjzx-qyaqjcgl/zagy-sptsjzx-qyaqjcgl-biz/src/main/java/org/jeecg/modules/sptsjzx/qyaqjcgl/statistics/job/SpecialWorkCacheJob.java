package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.job;

import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.boot.starter.lock.client.RedissonLockClient;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.cache.StatSwBaseCache;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.StatSwBaseCacheMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.cache.StatSwTypeCacheRow;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.StatSwTypeCacheMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.SpecialWorkStatisticsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * 特殊作业统计缓存刷新定时任务
 *
 * 启动后 40 秒执行首次刷新，之后每 10 分钟刷新一次。
 * 4 个查询并行跑（均在 zfd 数据源），结果写入：
 *   - stat_sw_base_cache（接入情况 + 状态数量，每企业一行）
 *   - stat_sw_type_cache（大类数量，每企业×每大类一行）
 */
@Slf4j
@Component
public class SpecialWorkCacheJob {

    private static final String DS_KEY = "zfd";

    @Autowired
    private SpecialWorkStatisticsMapper swMapper;

    @Autowired
    private StatSwBaseCacheMapper baseCacheMapper;

    @Autowired
    private StatSwTypeCacheMapper typeCacheMapper;

    @Autowired
    private RedissonLockClient redissonLock;

    private static final String LOCK_KEY = "cache:job:specialWork";
    private static final int    LOCK_EXPIRE = 9 * 60; // 9分钟，小于 fixedRate

    @Scheduled(initialDelay = 40_000, fixedRate = 10 * 60_000)
    public void refresh() {
        if (!redissonLock.tryLock(LOCK_KEY, -1, LOCK_EXPIRE)) {
            log.debug("[SpecialWorkCacheJob] 未获取到锁，跳过本次刷新");
            return;
        }
        try {
            doRefresh();
        } finally {
            redissonLock.unlock(LOCK_KEY);
        }
    }

    private void doRefresh() {
        log.info("[SpecialWorkCacheJob] 开始刷新...");
        long start = System.currentTimeMillis();

        // 4 个查询全部在 zfd 数据源，并行执行
        CompletableFuture<List<Map<String, Object>>> fMeta   = onZfd(swMapper::getAllCompanyMeta);
        CompletableFuture<List<Map<String, Object>>> fAccess = onZfd(swMapper::getTicketAccessStatsByCompany);
        CompletableFuture<List<Map<String, Object>>> fStatus = onZfd(swMapper::getTicketStatusStatsByCompany);
        CompletableFuture<List<Map<String, Object>>> fType   = onZfd(swMapper::getTicketTypeStatsByCompany);
        CompletableFuture.allOf(fMeta, fAccess, fStatus, fType).join();

        // 按 company_code 建索引，方便 O(1) 合并
        Map<String, Map<String, Object>> accessMap = toMap(fAccess.join());
        Map<String, Map<String, Object>> statusMap = toMap(fStatus.join());

        List<Map<String, Object>> metaList = fMeta.join();
        if (metaList == null || metaList.isEmpty()) {
            log.warn("[SpecialWorkCacheJob] 企业元数据为空，跳过");
            return;
        }

        List<StatSwBaseCache> baseRows = new ArrayList<>(metaList.size());
        for (Map<String, Object> meta : metaList) {
            String companyCode = str(meta.get("company_code"));
            Map<String, Object> ac = accessMap.getOrDefault(companyCode, Collections.emptyMap());
            Map<String, Object> st = statusMap.getOrDefault(companyCode, Collections.emptyMap());

            StatSwBaseCache row = new StatSwBaseCache();
            row.setCompanyCode(companyCode);
            row.setCountyCode(str(meta.get("county_code")));
            row.setParkCode(str(meta.get("park_code")));
            row.setYqType(num(meta.get("yq_type")));
            row.setIsScqy(num(meta.get("is_scqy")));
            row.setIsFull(num(ac.get("is_full")));
            row.setIsPartial(num(ac.get("is_partial")));
            row.setIsNot(num(ac.get("is_not")));
            row.setStatus0(num(st.get("status_0")));
            row.setStatus1(num(st.get("status_1")));
            row.setStatus3(num(st.get("status_3")));
            row.setStatus4(num(st.get("status_4")));
            row.setStatus5(num(st.get("status_5")));
            baseRows.add(row);
        }

        // 构建类型缓存行：需要把企业元数据冗余进去
        Map<String, Map<String, Object>> metaMap = toMap(metaList);
        List<Map<String, Object>> typeList = fType.join();
        List<StatSwTypeCacheRow> typeRows = new ArrayList<>();
        if (typeList != null) {
            for (Map<String, Object> t : typeList) {
                String companyCode = str(t.get("company_code"));
                Map<String, Object> meta = metaMap.getOrDefault(companyCode, Collections.emptyMap());

                StatSwTypeCacheRow row = new StatSwTypeCacheRow();
                row.setCompanyCode(companyCode);
                row.setCountyCode(str(meta.get("county_code")));
                row.setParkCode(str(meta.get("park_code")));
                row.setYqType(num(meta.get("yq_type")));
                row.setIsScqy(num(meta.get("is_scqy")));
                row.setTypeName(str(t.get("type_name")));
                row.setTypeCount(num(t.get("type_count")));
                typeRows.add(row);
            }
        }

        baseCacheMapper.batchUpsert(baseRows);
        if (!typeRows.isEmpty()) {
            typeCacheMapper.batchUpsert(typeRows);
        }

        log.info("[SpecialWorkCacheJob] 刷新完成，企业: {} 行，大类: {} 行，耗时 {}ms",
                baseRows.size(), typeRows.size(), System.currentTimeMillis() - start);
    }

    private <T> CompletableFuture<T> onZfd(Supplier<T> supplier) {
        return CompletableFuture.supplyAsync(() -> {
            DynamicDataSourceContextHolder.push(DS_KEY);
            try {
                return supplier.get();
            } finally {
                DynamicDataSourceContextHolder.poll();
            }
        });
    }

    private Map<String, Map<String, Object>> toMap(List<Map<String, Object>> list) {
        if (list == null) return Collections.emptyMap();
        Map<String, Map<String, Object>> result = new HashMap<>(list.size() * 2);
        for (Map<String, Object> row : list) {
            Object key = row.get("company_code");
            if (key != null) result.put(key.toString(), row);
        }
        return result;
    }

    private int num(Object obj) {
        if (obj == null) return 0;
        if (obj instanceof Number) return ((Number) obj).intValue();
        try { return Integer.parseInt(obj.toString()); } catch (NumberFormatException e) { return 0; }
    }

    private String str(Object obj) {
        return obj == null ? null : obj.toString();
    }
}
