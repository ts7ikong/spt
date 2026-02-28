package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.impl;

import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.ClosedManagementStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.ClosedManagementMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IClosedManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

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

        // 2. 调用新 Mapper，获取每个园区的明细数据
        List<Map<String, Object>> parkStatsList = mapper.getClosedManagementStatsByPark(yqCodes, startTime, endTime);

        // === 初始化累加变量 ===
        int fullAccessCount = 0;   // 全部已接入园区数
        int partialAccessCount = 0;// 部分已接入园区数
        int notAccessCount = 0;    // 未接入园区数

        // 业务数值累加器 (全区总和)
        long sumGateCount = 0;
        long sumHazardousVehicleCount = 0;
        long sumOtherVehicleCount = 0;
        long sumVisitorCount = 0;

        long sumGeneralCargoCount = 0;
        long sumHazardousTransportCount = 0;
        long sumSmallVehicleCount = 0;
        long sumEmergencyVehicleCount = 0;
        long sumRegisteredPersonnelCount = 0;
        long sumVisitorPersonnelCount = 0;

        long sumAlarmIntrusion = 0;
        long sumAlarmSpeed = 0;
        long sumAlarmHelp = 0;
        long sumAlarmStay = 0;
        long sumAlarmOther = 0;

        if (parkStatsList != null) {
            for (Map<String, Object> row : parkStatsList) {
                // --- A. 处理接入状态 (按园区判断) ---
                int moduleCount = getIntValue(row.get("moduleCount")); // 0 ~ 10

                if (moduleCount == 10) {
                    fullAccessCount++;
                } else if (moduleCount > 0) {
                    partialAccessCount++;
                } else {
                    notAccessCount++;
                }

                // --- B. 处理业务数值 (累加全区总和) ---
                sumGateCount += getIntValue(row.get("gateCount"));
                sumHazardousVehicleCount += getIntValue(row.get("hazardousVehicleCount"));
                sumOtherVehicleCount += getIntValue(row.get("otherVehicleCount"));
                sumVisitorCount += getIntValue(row.get("visitorCount"));

                sumGeneralCargoCount += getIntValue(row.get("generalCargoCount"));
                sumHazardousTransportCount += getIntValue(row.get("hazardousTransportCount"));
                sumSmallVehicleCount += getIntValue(row.get("smallVehicleCount"));
                sumEmergencyVehicleCount += getIntValue(row.get("emergencyVehicleCount"));
                sumRegisteredPersonnelCount += getIntValue(row.get("registeredPersonnelCount"));
                sumVisitorPersonnelCount += getIntValue(row.get("visitorPersonnelCount"));

                sumAlarmIntrusion += getIntValue(row.get("alarm_intrusion"));
                sumAlarmSpeed += getIntValue(row.get("alarm_speed"));
                sumAlarmHelp += getIntValue(row.get("alarm_help"));
                sumAlarmStay += getIntValue(row.get("alarm_stay"));
                sumAlarmOther += getIntValue(row.get("alarm_other"));
            }
        }

        // === 3. 组装 DTO ===
        ClosedManagementStatisticsDTO dto = new ClosedManagementStatisticsDTO();

        // 3.1 接入状态统计 (基于园区数量的统计)
        List<Map<String, Object>> accessStatusStats = new ArrayList<>();
        accessStatusStats.add(createItem("全部已接入", fullAccessCount));
        accessStatusStats.add(createItem("部分已接入", partialAccessCount));
        accessStatusStats.add(createItem("未接入", notAccessCount));
        dto.setAccessStatusStats(accessStatusStats);

        // 3.2 报警类型统计 (基于全区总和)
        List<Map<String, Object>> alarmTypeStats = new ArrayList<>();
        addIfPositive(alarmTypeStats, "入侵报警", sumAlarmIntrusion);
        addIfPositive(alarmTypeStats, "超速报警", sumAlarmSpeed);
        addIfPositive(alarmTypeStats, "求救报警", sumAlarmHelp);
        addIfPositive(alarmTypeStats, "滞留报警", sumAlarmStay);
        addIfPositive(alarmTypeStats, "其他", sumAlarmOther);
        dto.setAlarmTypeStats(alarmTypeStats);

        // 3.3 基本信息统计 (基于全区总和)
        ClosedManagementStatisticsDTO.BasicInfoStats basic = new ClosedManagementStatisticsDTO.BasicInfoStats();
        basic.setGateCount((int) sumGateCount);
        basic.setHazardousVehicleCount((int) sumHazardousVehicleCount);
        basic.setOtherVehicleCount((int) sumOtherVehicleCount);
        basic.setVisitorCount((int) sumVisitorCount);
        dto.setBasicInfoStats(basic);

        // 3.4 通行数据统计 (基于全区总和)
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

    // 辅助方法：安全获取整数
    private int getIntValue(Object obj) {
        if (obj == null) return 0;
        if (obj instanceof Number) return ((Number) obj).intValue();
        try {
            return Integer.parseInt(obj.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    // 辅助方法：添加非零项
    private void addIfPositive(List<Map<String, Object>> list, String name, long value) {
        if (value > 0) {
            Map<String, Object> item = new HashMap<>();
            item.put("name", name);
            item.put("value", (int)value); // 注意类型转换
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