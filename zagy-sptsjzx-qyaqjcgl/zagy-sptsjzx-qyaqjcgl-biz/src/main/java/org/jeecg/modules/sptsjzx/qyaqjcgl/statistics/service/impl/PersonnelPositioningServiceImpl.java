package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.impl;

import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.cache.StatPpAlarmCacheMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.cache.StatPpBaseCacheMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.cache.StatPpPersonTypeCacheMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.PersonnelPositioningStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.PersonnelPositioningMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IPersonnelPositioningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PersonnelPositioningServiceImpl implements IPersonnelPositioningService {

    private static final String DS_KEY = "zfd";

    @Autowired
    private PersonnelPositioningMapper mapper;

    @Autowired
    private StatPpBaseCacheMapper baseCacheMapper;

    @Autowired
    private StatPpPersonTypeCacheMapper personTypeCacheMapper;

    @Autowired
    private StatPpAlarmCacheMapper alarmCacheMapper;

    @Override
    public PersonnelPositioningStatisticsDTO getPersonnelPositioningStatistics(
            String countycode, Integer yqType, String parkCode,
            List<String> companyCodes, Integer isScqy, String alarmStatus) {

        // 始终优先走缓存（全市/全区/指定企业均可）
        PersonnelPositioningStatisticsDTO cached =
                queryFromCache(companyCodes, countycode, parkCode, yqType, isScqy, alarmStatus);
        if (cached != null) {
            return cached;
        }

        log.warn("[PersonnelPositioning] 缓存未命中，降级为实时查询 companyCodes={}",
                companyCodes == null ? "null" : companyCodes.size());
        return computeRealtime(countycode, yqType, parkCode, companyCodes, isScqy, alarmStatus);
    }

    // -------------------------------------------------------------------------
    // 从缓存表聚合（毫秒级）
    // companyCodes=null 时不限企业范围，通过 countyCode/parkCode 过滤
    // -------------------------------------------------------------------------
    private PersonnelPositioningStatisticsDTO queryFromCache(
            List<String> companyCodes, String countyCode, String parkCode,
            Integer yqType, Integer isScqy, String alarmStatus) {

        Map<String, Object> agg = baseCacheMapper.queryAggregated(companyCodes, countyCode, parkCode, yqType, isScqy);
        if (agg == null) return null;

        List<Map<String, Object>> personTypeStats =
                personTypeCacheMapper.queryPersonTypeStats(companyCodes, countyCode, parkCode, yqType, isScqy);
        List<Map<String, Object>> alarmStats =
                alarmCacheMapper.queryAlarmStats(companyCodes, countyCode, parkCode, yqType, isScqy, alarmStatus);

        PersonnelPositioningStatisticsDTO dto = new PersonnelPositioningStatisticsDTO();

        List<Map<String, Object>> accessList = new ArrayList<>();
        accessList.add(buildItem("全部接入", agg.get("fullAccess")));
        accessList.add(buildItem("部分接入", agg.get("partialAccess")));
        accessList.add(buildItem("未接入",   agg.get("noAccess")));
        dto.setPositioningAccessStats(accessList);

        dto.setPersonnelTypeStats(personTypeStats);
        dto.setTemporaryZoneCount(num(agg.get("temporaryZoneCount")));
        dto.setFixedZoneCount(num(agg.get("fixedZoneCount")));
        dto.setCrowdAlarmCount(num(agg.get("crowdAlarmCount")));
        dto.setAlarmClassificationStats(alarmStats != null ? alarmStats : Collections.emptyList());

        return dto;
    }

    // -------------------------------------------------------------------------
    // 实时并行查询（降级路径，与原有逻辑一致）
    // -------------------------------------------------------------------------
    private PersonnelPositioningStatisticsDTO computeRealtime(
            String countycode, Integer yqType, String parkCode,
            List<String> companyCodes, Integer isScqy, String alarmStatus) {

        CompletableFuture<Map<String, Object>> f1 = onZfd(
                () -> mapper.getPositioningAccessStats(countycode, yqType, parkCode, companyCodes, isScqy));
        CompletableFuture<List<Map<String, Object>>> f2 = onZfd(
                () -> mapper.getPersonnelTypeStats(countycode, yqType, parkCode, companyCodes, isScqy));
        CompletableFuture<Map<String, Object>> f3 = onZfd(
                () -> mapper.getZoneStats(countycode, yqType, parkCode, companyCodes, isScqy));
        CompletableFuture<List<Map<String, Object>>> f4 = onZfd(
                () -> mapper.getUnifiedAlarmStats(countycode, yqType, parkCode, companyCodes, isScqy, alarmStatus));
        CompletableFuture.allOf(f1, f2, f3, f4).join();

        PersonnelPositioningStatisticsDTO dto = new PersonnelPositioningStatisticsDTO();

        Map<String, Object> accessStatsMap = f1.join();
        List<Map<String, Object>> accessStats = new ArrayList<>();
        String[][] mapping = {{"fullAccess", "全部接入"}, {"partialAccess", "部分接入"}, {"noAccess", "未接入"}};
        for (String[] entry : mapping) {
            Map<String, Object> item = new HashMap<>();
            item.put("name", entry[1]);
            item.put("value", accessStatsMap.get(entry[0]) != null ?
                    ((Number) accessStatsMap.get(entry[0])).intValue() : 0);
            accessStats.add(item);
        }
        dto.setPositioningAccessStats(accessStats);

        dto.setPersonnelTypeStats(f2.join());

        Map<String, Object> zoneStats = f3.join();
        dto.setTemporaryZoneCount(((Number) zoneStats.get("temporaryZoneCount")).intValue());
        dto.setFixedZoneCount(((Number) zoneStats.get("fixedZoneCount")).intValue());

        List<Map<String, Object>> unifiedAlarms = f4.join();
        Integer crowdAlarmCount = 0;
        List<Map<String, Object>> filteredAlarms = new ArrayList<>();
        for (Map<String, Object> alarm : unifiedAlarms) {
            String name = (String) alarm.get("name");
            Object valueObj = alarm.get("value");
            Integer value = (valueObj instanceof Number) ? ((Number) valueObj).intValue() : 0;
            if ("人员聚集报警".equals(name)) {
                crowdAlarmCount = value;
            } else {
                Map<String, Object> safeAlarm = new HashMap<>();
                safeAlarm.put("name", name);
                safeAlarm.put("value", value);
                filteredAlarms.add(safeAlarm);
            }
        }
        dto.setCrowdAlarmCount(crowdAlarmCount);
        dto.setAlarmClassificationStats(filteredAlarms.stream()
                .sorted((a, b) -> ((Integer) b.get("value")).compareTo((Integer) a.get("value")))
                .collect(Collectors.toList()));

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

    private int num(Object obj) {
        if (obj == null) return 0;
        if (obj instanceof Number) return ((Number) obj).intValue();
        return 0;
    }
}
