package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.impl;

import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.PersonnelPositioningStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.PersonnelPositioningMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IPersonnelPositioningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class PersonnelPositioningServiceImpl implements IPersonnelPositioningService {

    private static final String DS_KEY = "zfd";

    @Autowired
    private PersonnelPositioningMapper mapper;

    @Override
    public PersonnelPositioningStatisticsDTO getPersonnelPositioningStatistics(
            String countycode, Integer yqType, String parkCode,
            List<String> companyCodes, Integer isScqy, String alarmStatus) {

        // 4 个查询完全独立，并行执行（手动设置 zfd 数据源，因为 CompletableFuture 不继承 ThreadLocal）
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

        // 1. 接入情况统计
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

        // 2. 人员类型统计
        dto.setPersonnelTypeStats(f2.join());

        // 3. 区域统计
        Map<String, Object> zoneStats = f3.join();
        dto.setTemporaryZoneCount(((Number) zoneStats.get("temporaryZoneCount")).intValue());
        dto.setFixedZoneCount(((Number) zoneStats.get("fixedZoneCount")).intValue());

        // 4. 报警分类统计
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

        List<Map<String, Object>> alarmClassificationStats = filteredAlarms.stream()
                .sorted((a, b) -> ((Integer) b.get("value")).compareTo((Integer) a.get("value")))
                .collect(Collectors.toList());

        dto.setCrowdAlarmCount(crowdAlarmCount);
        dto.setAlarmClassificationStats(alarmClassificationStats);

        return dto;
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
}
