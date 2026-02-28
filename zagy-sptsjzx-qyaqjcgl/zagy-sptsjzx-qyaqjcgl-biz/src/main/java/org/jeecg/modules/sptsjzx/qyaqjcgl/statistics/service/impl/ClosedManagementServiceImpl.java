package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.impl;

import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.ClosedManagementStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.ClosedManagementMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IClosedManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;

@Service
public class ClosedManagementServiceImpl implements IClosedManagementService {

    @Autowired
    private ClosedManagementMapper mapper;

    @Override
    public ClosedManagementStatisticsDTO getClosedManagementStatistics(
            List<String> yqCodes,
            String timeRange) {

        // 1. 计算时间范围
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startTime, endTime;
        switch (Optional.ofNullable(timeRange).orElse("today")) {
            case "today":
                startTime = now.toLocalDate().atStartOfDay();
                endTime = startTime.plusDays(1);
                break;
            case "week":
                startTime = now.toLocalDate().minusDays(6).atStartOfDay();
                endTime = now.toLocalDate().plusDays(1).atStartOfDay();
                break;
            case "month":
                startTime = now.toLocalDate().minusDays(29).atStartOfDay();
                endTime = now.toLocalDate().plusDays(1).atStartOfDay();
                break;
            default:
                throw new IllegalArgumentException("不支持的时间范围: " + timeRange);
        }

        // 2. 原来 1 个 10-JOIN 串行 SQL → 4 个独立 SQL 并行执行
        //    无 @DS 注解，使用默认数据源，各线程各取自己的连接，线程安全
        final LocalDateTime st = startTime;
        final LocalDateTime et = endTime;

        CompletableFuture<List<Map<String, Object>>> f1 = CompletableFuture.supplyAsync(
                () -> mapper.getStaticInfoByPark(yqCodes));
        CompletableFuture<List<Map<String, Object>>> f2 = CompletableFuture.supplyAsync(
                () -> mapper.getVehicleTrafficByPark(yqCodes, st, et));
        CompletableFuture<List<Map<String, Object>>> f3 = CompletableFuture.supplyAsync(
                () -> mapper.getPersonnelTrafficByPark(yqCodes, st, et));
        CompletableFuture<List<Map<String, Object>>> f4 = CompletableFuture.supplyAsync(
                () -> mapper.getAlarmStatsByPark(yqCodes));

        CompletableFuture.allOf(f1, f2, f3, f4).join();

        // 3. 按 park_code 建立索引，O(1) 合并
        Map<String, Map<String, Object>> vehicleMap   = toMapByPark(f2.join());
        Map<String, Map<String, Object>> personnelMap = toMapByPark(f3.join());
        Map<String, Map<String, Object>> alarmMap     = toMapByPark(f4.join());

        // === 累加变量 ===
        int fullAccessCount    = 0;
        int partialAccessCount = 0;
        int notAccessCount     = 0;

        long sumGateCount               = 0;
        long sumHazardousVehicleCount   = 0;
        long sumOtherVehicleCount       = 0;
        long sumVisitorCount            = 0;
        long sumGeneralCargoCount       = 0;
        long sumHazardousTransportCount = 0;
        long sumSmallVehicleCount       = 0;
        long sumEmergencyVehicleCount   = 0;
        long sumRegisteredPersonnelCount= 0;
        long sumVisitorPersonnelCount   = 0;
        long sumAlarmIntrusion          = 0;
        long sumAlarmSpeed              = 0;
        long sumAlarmHelp               = 0;
        long sumAlarmStay               = 0;
        long sumAlarmOther              = 0;

        List<Map<String, Object>> staticList = f1.join();
        if (staticList != null) {
            for (Map<String, Object> row : staticList) {
                String parkCode = (String) row.get("park_code");
                Map<String, Object> v = vehicleMap.getOrDefault(parkCode, Collections.emptyMap());
                Map<String, Object> p = personnelMap.getOrDefault(parkCode, Collections.emptyMap());
                Map<String, Object> a = alarmMap.getOrDefault(parkCode, Collections.emptyMap());

                // moduleCount = 7 静态模块 + has_clsstx + has_rysstx + has_sbbjsj（最大值 10）
                int moduleCount = getIntValue(row.get("staticModuleCount"))
                        + getIntValue(v.get("has_clsstx"))
                        + getIntValue(p.get("has_rysstx"))
                        + getIntValue(a.get("has_sbbjsj"));

                if (moduleCount == 10) fullAccessCount++;
                else if (moduleCount > 0) partialAccessCount++;
                else notAccessCount++;

                sumGateCount               += getIntValue(row.get("gateCount"));
                sumHazardousVehicleCount   += getIntValue(row.get("hazardousVehicleCount"));
                sumOtherVehicleCount       += getIntValue(row.get("otherVehicleCount"));
                sumVisitorCount            += getIntValue(row.get("visitorCount"));
                sumGeneralCargoCount       += getIntValue(v.get("generalCargoCount"));
                sumHazardousTransportCount += getIntValue(v.get("hazardousTransportCount"));
                sumSmallVehicleCount       += getIntValue(v.get("smallVehicleCount"));
                sumEmergencyVehicleCount   += getIntValue(v.get("emergencyVehicleCount"));
                sumRegisteredPersonnelCount+= getIntValue(p.get("registeredPersonnelCount"));
                sumVisitorPersonnelCount   += getIntValue(p.get("visitorPersonnelCount"));
                sumAlarmIntrusion          += getIntValue(a.get("alarm_intrusion"));
                sumAlarmSpeed              += getIntValue(a.get("alarm_speed"));
                sumAlarmHelp               += getIntValue(a.get("alarm_help"));
                sumAlarmStay               += getIntValue(a.get("alarm_stay"));
                sumAlarmOther              += getIntValue(a.get("alarm_other"));
            }
        }

        // 4. 组装 DTO
        ClosedManagementStatisticsDTO dto = new ClosedManagementStatisticsDTO();

        List<Map<String, Object>> accessStatusStats = new ArrayList<>();
        accessStatusStats.add(createItem("全部已接入", fullAccessCount));
        accessStatusStats.add(createItem("部分已接入", partialAccessCount));
        accessStatusStats.add(createItem("未接入", notAccessCount));
        dto.setAccessStatusStats(accessStatusStats);

        List<Map<String, Object>> alarmTypeStats = new ArrayList<>();
        addIfPositive(alarmTypeStats, "入侵报警", sumAlarmIntrusion);
        addIfPositive(alarmTypeStats, "超速报警", sumAlarmSpeed);
        addIfPositive(alarmTypeStats, "求救报警", sumAlarmHelp);
        addIfPositive(alarmTypeStats, "滞留报警", sumAlarmStay);
        addIfPositive(alarmTypeStats, "其他",     sumAlarmOther);
        dto.setAlarmTypeStats(alarmTypeStats);

        ClosedManagementStatisticsDTO.BasicInfoStats basic = new ClosedManagementStatisticsDTO.BasicInfoStats();
        basic.setGateCount((int) sumGateCount);
        basic.setHazardousVehicleCount((int) sumHazardousVehicleCount);
        basic.setOtherVehicleCount((int) sumOtherVehicleCount);
        basic.setVisitorCount((int) sumVisitorCount);
        dto.setBasicInfoStats(basic);

        ClosedManagementStatisticsDTO.TrafficStats traffic = new ClosedManagementStatisticsDTO.TrafficStats();
        traffic.setGeneralCargoCount((int) sumGeneralCargoCount);
        traffic.setHazardousTransportCount((int) sumHazardousTransportCount);
        traffic.setSmallVehicleCount((int) sumSmallVehicleCount);
        traffic.setEmergencyVehicleCount((int) sumEmergencyVehicleCount);
        traffic.setRegisteredPersonnelCount((int) sumRegisteredPersonnelCount);
        traffic.setVisitorPersonnelCount((int) sumVisitorPersonnelCount);
        dto.setTrafficStats(traffic);

        return dto;
    }

    private Map<String, Map<String, Object>> toMapByPark(List<Map<String, Object>> list) {
        if (list == null) return Collections.emptyMap();
        Map<String, Map<String, Object>> result = new HashMap<>(list.size() * 2);
        for (Map<String, Object> row : list) {
            Object key = row.get("park_code");
            if (key != null) result.put(key.toString(), row);
        }
        return result;
    }

    private int getIntValue(Object obj) {
        if (obj == null) return 0;
        if (obj instanceof Number) return ((Number) obj).intValue();
        try { return Integer.parseInt(obj.toString()); } catch (NumberFormatException e) { return 0; }
    }

    private void addIfPositive(List<Map<String, Object>> list, String name, long value) {
        if (value > 0) {
            Map<String, Object> item = new HashMap<>();
            item.put("name", name);
            item.put("value", (int) value);
            list.add(item);
        }
    }

    private Map<String, Object> createItem(String name, int value) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("value", value);
        return map;
    }
}
