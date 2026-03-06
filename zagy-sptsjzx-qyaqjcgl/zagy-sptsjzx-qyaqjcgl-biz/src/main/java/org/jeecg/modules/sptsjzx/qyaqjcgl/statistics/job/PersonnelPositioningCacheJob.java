package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.job;

import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.boot.starter.lock.client.RedissonLockClient;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.cache.*;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * 人员定位统计缓存刷新定时任务
 *
 * 启动后 60 秒执行首次刷新，之后每 10 分钟刷新一次。
 * 5 个查询并行跑（均在 zfd 数据源），结果写入：
 *   - stat_pp_base_cache       （接入情况 + 区域数量 + 人员聚集报警，每企业一行）
 *   - stat_pp_person_type_cache（人员类型分布，每企业×类型一行）
 *   - stat_pp_alarm_cache      （报警分类，每企业×报警名称一行，含三状态数量）
 */
@Slf4j
@Component
@ConditionalOnBean(RedissonLockClient.class)
public class PersonnelPositioningCacheJob {

    private static final String DS_KEY = "zfd";

    @Autowired
    private PersonnelPositioningMapper ppMapper;

    /** 复用 specialWork 的企业元数据查询 */
    @Autowired
    private SpecialWorkStatisticsMapper swMapper;

    @Autowired
    private StatPpBaseCacheMapper baseCacheMapper;

    @Autowired
    private StatPpPersonTypeCacheMapper personTypeCacheMapper;

    @Autowired
    private StatPpAlarmCacheMapper alarmCacheMapper;

    @Autowired
    private RedissonLockClient redissonLock;

    private static final String LOCK_KEY    = "cache:job:personnelPositioning";
    private static final int    LOCK_EXPIRE = 9 * 60; // 9分钟，小于 fixedRate

    @Scheduled(initialDelay = 60_000, fixedRate = 10 * 60_000)
    public void refresh() {
        if (!redissonLock.tryLock(LOCK_KEY, -1, LOCK_EXPIRE)) {
            log.debug("[PersonnelPositioningCacheJob] 未获取到锁，跳过本次刷新");
            return;
        }
        try {
            doRefresh();
        } finally {
            redissonLock.unlock(LOCK_KEY);
        }
    }

    private void doRefresh() {
        log.info("[PersonnelPositioningCacheJob] 开始刷新...");
        long start = System.currentTimeMillis();

        // 5 个查询并行，均在 zfd 数据源
        CompletableFuture<List<Map<String, Object>>> fMeta       = onZfd(swMapper::getAllCompanyMeta);
        CompletableFuture<List<Map<String, Object>>> fAccess     = onZfd(ppMapper::getPositioningAccessStatsByCompany);
        CompletableFuture<List<Map<String, Object>>> fZone       = onZfd(ppMapper::getZoneStatsByCompany);
        CompletableFuture<List<Map<String, Object>>> fPersonType = onZfd(ppMapper::getPersonnelTypeStatsByCompany);
        CompletableFuture<List<Map<String, Object>>> fAlarm      = onZfd(ppMapper::getAlarmStatsByCompany);
        CompletableFuture<List<Map<String, Object>>> fCrowd      = onZfd(ppMapper::getCrowdAlarmCountByCompany);
        CompletableFuture.allOf(fMeta, fAccess, fZone, fPersonType, fAlarm, fCrowd).join();

        List<Map<String, Object>> metaList = fMeta.join();
        if (metaList == null || metaList.isEmpty()) {
            log.warn("[PersonnelPositioningCacheJob] 企业元数据为空，跳过");
            return;
        }

        // 按 company_code 建索引
        Map<String, Map<String, Object>> metaMap   = toMap(metaList);
        Map<String, Map<String, Object>> accessMap = toMap(fAccess.join());
        Map<String, Map<String, Object>> zoneMap   = toMap(fZone.join());
        Map<String, Map<String, Object>> crowdMap  = toMap(fCrowd.join());

        // ---- 构建 base cache ----
        List<StatPpBaseCache> baseRows = new ArrayList<>(metaList.size());
        for (Map<String, Object> meta : metaList) {
            String cc = str(meta.get("company_code"));
            Map<String, Object> ac = accessMap.getOrDefault(cc, Collections.emptyMap());
            Map<String, Object> zn = zoneMap.getOrDefault(cc, Collections.emptyMap());
            Map<String, Object> cr = crowdMap.getOrDefault(cc, Collections.emptyMap());

            StatPpBaseCache row = new StatPpBaseCache();
            row.setCompanyCode(cc);
            row.setCountyCode(str(meta.get("county_code")));
            row.setParkCode(str(meta.get("park_code")));
            row.setYqType(num(meta.get("yq_type")));
            row.setIsScqy(num(meta.get("is_scqy")));
            row.setIsFullAccess(num(ac.get("is_full_access")));
            row.setIsPartialAccess(num(ac.get("is_partial_access")));
            row.setIsNoAccess(num(ac.get("is_no_access")));
            row.setTemporaryZoneCount(num(zn.get("temporary_zone_count")));
            row.setFixedZoneCount(num(zn.get("fixed_zone_count")));
            row.setCrowdAlarmCount(num(cr.get("crowd_alarm_count")));
            baseRows.add(row);
        }

        // ---- 构建 person type cache ----
        List<Map<String, Object>> personTypeList = fPersonType.join();
        List<StatPpPersonTypeCacheRow> personTypeRows = new ArrayList<>();
        if (personTypeList != null) {
            for (Map<String, Object> pt : personTypeList) {
                String cc = str(pt.get("company_code"));
                Map<String, Object> meta = metaMap.getOrDefault(cc, Collections.emptyMap());

                StatPpPersonTypeCacheRow row = new StatPpPersonTypeCacheRow();
                row.setCompanyCode(cc);
                row.setCountyCode(str(meta.get("county_code")));
                row.setParkCode(str(meta.get("park_code")));
                row.setYqType(num(meta.get("yq_type")));
                row.setIsScqy(num(meta.get("is_scqy")));
                row.setPersonType(str(pt.get("person_type")));
                row.setPersonName(str(pt.get("person_name")));
                row.setPersonCount(num(pt.get("person_count")));
                personTypeRows.add(row);
            }
        }

        // ---- 构建 alarm cache ----
        List<Map<String, Object>> alarmList = fAlarm.join();
        List<StatPpAlarmCacheRow> alarmRows = new ArrayList<>();
        if (alarmList != null) {
            for (Map<String, Object> al : alarmList) {
                String cc = str(al.get("company_code"));
                Map<String, Object> meta = metaMap.getOrDefault(cc, Collections.emptyMap());

                StatPpAlarmCacheRow row = new StatPpAlarmCacheRow();
                row.setCompanyCode(cc);
                row.setCountyCode(str(meta.get("county_code")));
                row.setParkCode(str(meta.get("park_code")));
                row.setYqType(num(meta.get("yq_type")));
                row.setIsScqy(num(meta.get("is_scqy")));
                row.setAlarmName(str(al.get("alarm_name")));
                row.setTotalCount(num(al.get("total_count")));
                row.setAlarmingCount(num(al.get("alarming_count")));
                row.setDispelledCount(num(al.get("dispelled_count")));
                alarmRows.add(row);
            }
        }

        baseCacheMapper.batchUpsert(baseRows);
        if (!personTypeRows.isEmpty()) personTypeCacheMapper.batchUpsert(personTypeRows);
        if (!alarmRows.isEmpty())      alarmCacheMapper.batchUpsert(alarmRows);

        log.info("[PersonnelPositioningCacheJob] 刷新完成，企业: {} 行，人员类型: {} 行，报警: {} 行，耗时 {}ms",
                baseRows.size(), personTypeRows.size(), alarmRows.size(),
                System.currentTimeMillis() - start);
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
