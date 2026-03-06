package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.impl;

import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.StatSwBaseCacheMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.StatSwTypeCacheMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.SpecialWorkStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.SpecialWorkStatisticsMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.ISpecialWorkStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@Slf4j
@Service
public class SpecialWorkStatisticsServiceImpl implements ISpecialWorkStatisticsService {

    private static final String DS_KEY = "zfd";

    @Autowired
    private SpecialWorkStatisticsMapper mapper;

    @Autowired
    private StatSwBaseCacheMapper baseCacheMapper;

    @Autowired
    private StatSwTypeCacheMapper typeCacheMapper;

    @Override
    public SpecialWorkStatisticsDTO getSpecialWorkStatistics(String countycode,
                                                             Integer yqType,
                                                             String parkCode,
                                                             List<String> companyCodes,
                                                             Integer isScqy) {

        // companyCodes 为空（全市查询）时不走缓存路径（缓存需要明确的 IN 列表）
        if (companyCodes != null && !companyCodes.isEmpty()) {
            long tCache = System.currentTimeMillis();
            SpecialWorkStatisticsDTO cached = queryFromCache(companyCodes, yqType, isScqy);
            log.info("[SpecialWork-timing] queryFromCache: {}ms, hit={}",
                    System.currentTimeMillis() - tCache, cached != null);
            if (cached != null) {
                return cached;
            }
            log.warn("[SpecialWork] 缓存未命中，降级为实时查询 companyCodes.size={}", companyCodes.size());
        }

        long tRt = System.currentTimeMillis();
        SpecialWorkStatisticsDTO result = computeRealtime(countycode, yqType, parkCode, companyCodes, isScqy);
        log.info("[SpecialWork-timing] computeRealtime: {}ms", System.currentTimeMillis() - tRt);
        return result;
    }

    // -------------------------------------------------------------------------
    // 从缓存表聚合（毫秒级）
    // -------------------------------------------------------------------------
    private SpecialWorkStatisticsDTO queryFromCache(List<String> companyCodes,
                                                    Integer yqType, Integer isScqy) {
        long t1 = System.currentTimeMillis();
        Map<String, Object> agg = baseCacheMapper.queryAggregated(companyCodes, yqType, isScqy);
        log.info("[SpecialWork-timing] cache.queryAggregated: {}ms", System.currentTimeMillis() - t1);

        long t2 = System.currentTimeMillis();
        List<Map<String, Object>> typeStats = typeCacheMapper.queryTypeStats(companyCodes, yqType, isScqy);
        log.info("[SpecialWork-timing] cache.queryTypeStats: {}ms", System.currentTimeMillis() - t2);

        if (agg == null) return null;

        SpecialWorkStatisticsDTO dto = new SpecialWorkStatisticsDTO();

        // ticketAccessStats
        List<Map<String, Object>> accessList = new ArrayList<>();
        accessList.add(buildItem("全部接入", agg.get("fullCount")));
        accessList.add(buildItem("部分接入", agg.get("partialCount")));
        accessList.add(buildItem("未接入",   agg.get("notCount")));
        dto.setTicketAccessStats(accessList);

        // ticketStatusStats（只返回数量 > 0 的状态）
        List<Map<String, Object>> statusList = new ArrayList<>();
        addStatusItem(statusList, "未签发", agg.get("status0"));
        addStatusItem(statusList, "已签发", agg.get("status1"));
        addStatusItem(statusList, "已验收", agg.get("status3"));
        addStatusItem(statusList, "作废",   agg.get("status4"));
        addStatusItem(statusList, "撤销",   agg.get("status5"));
        dto.setTicketStatusStats(statusList);

        // ticketTypeStats（直接来自 type cache，已按 value DESC 排序）
        dto.setTicketTypeStats(typeStats);

        return dto;
    }

    // -------------------------------------------------------------------------
    // 实时并行查询（降级路径，与原有逻辑一致）
    // -------------------------------------------------------------------------
    private SpecialWorkStatisticsDTO computeRealtime(String countycode, Integer yqType,
                                                     String parkCode, List<String> companyCodes,
                                                     Integer isScqy) {
        long tParallelStart = System.currentTimeMillis();
        CompletableFuture<Map<String, Object>> f1 = onZfd(
                () -> {
                    long t = System.currentTimeMillis();
                    Map<String, Object> r = mapper.getTicketAccessStats(countycode, yqType, parkCode, companyCodes, isScqy);
                    log.info("[SpecialWork-timing] realtime.getTicketAccessStats: {}ms", System.currentTimeMillis() - t);
                    return r;
                });
        CompletableFuture<List<Map<String, Object>>> f2 = onZfd(
                () -> {
                    long t = System.currentTimeMillis();
                    List<Map<String, Object>> r = mapper.getTicketStatusStats(countycode, yqType, parkCode, companyCodes, isScqy);
                    log.info("[SpecialWork-timing] realtime.getTicketStatusStats: {}ms", System.currentTimeMillis() - t);
                    return r;
                });
        CompletableFuture<List<Map<String, Object>>> f3 = onZfd(
                () -> {
                    long t = System.currentTimeMillis();
                    List<Map<String, Object>> r = mapper.getTicketTypeStats(countycode, yqType, parkCode, companyCodes, isScqy);
                    log.info("[SpecialWork-timing] realtime.getTicketTypeStats: {}ms", System.currentTimeMillis() - t);
                    return r;
                });
        CompletableFuture.allOf(f1, f2, f3).join();
        log.info("[SpecialWork-timing] 3路并行合计耗时(wall): {}ms", System.currentTimeMillis() - tParallelStart);

        SpecialWorkStatisticsDTO dto = new SpecialWorkStatisticsDTO();

        Map<String, Object> accessRaw = f1.join();
        List<Map<String, Object>> ticketAccessStats = new ArrayList<>();
        ticketAccessStats.add(buildItem("全部接入", accessRaw.get("fullCount")));
        ticketAccessStats.add(buildItem("部分接入", accessRaw.get("partialCount")));
        ticketAccessStats.add(buildItem("未接入",   accessRaw.get("notCount")));
        dto.setTicketAccessStats(ticketAccessStats);

        dto.setTicketStatusStats(f2.join());
        dto.setTicketTypeStats(f3.join());

        return dto;
    }

    // -------------------------------------------------------------------------
    // 工具方法
    // -------------------------------------------------------------------------
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

    private Map<String, Object> buildItem(String name, Object countObj) {
        Map<String, Object> item = new HashMap<>();
        item.put("name", name);
        item.put("value", countObj instanceof Number ? ((Number) countObj).intValue() : 0);
        return item;
    }

    private void addStatusItem(List<Map<String, Object>> list, String name, Object countObj) {
        int v = countObj instanceof Number ? ((Number) countObj).intValue() : 0;
        if (v > 0) {
            Map<String, Object> item = new HashMap<>();
            item.put("name", name);
            item.put("value", v);
            list.add(item);
        }
    }
}
