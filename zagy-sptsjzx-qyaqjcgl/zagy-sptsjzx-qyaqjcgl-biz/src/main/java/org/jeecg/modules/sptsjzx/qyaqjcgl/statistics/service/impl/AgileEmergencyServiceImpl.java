package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.impl;

import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.AgileEmergencyStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.AgileEmergencyMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IAgileEmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;

@Service
public class AgileEmergencyServiceImpl implements IAgileEmergencyService {

    @Autowired
    private AgileEmergencyMapper mapper;

    @Override
    public AgileEmergencyStatisticsDTO getAgileEmergencyStatistics(List<String> yqCodes,
                                                                   String drillType) {
        // 4 个查询完全独立，并行执行（此 Service 无 @DS，使用默认数据源，CompletableFuture 线程安全）
        CompletableFuture<List<Map<String, Object>>> f1 = CompletableFuture.supplyAsync(
                () -> mapper.getEmergencyAccessStatsByPark(yqCodes));
        CompletableFuture<List<Map<String, Object>>> f2 = CompletableFuture.supplyAsync(
                () -> mapper.getEmergencyPlanLevelStats(yqCodes));
        CompletableFuture<List<Map<String, Object>>> f3 = CompletableFuture.supplyAsync(
                () -> mapper.getEmergencyDrillLevelStats(yqCodes, drillType));
        CompletableFuture<Map<String, Object>> f4 = CompletableFuture.supplyAsync(
                () -> mapper.getEmergencyResourceStats(yqCodes));

        CompletableFuture.allOf(f1, f2, f3, f4).join();

        AgileEmergencyStatisticsDTO dto = new AgileEmergencyStatisticsDTO();

        // ===== 1. 接入情况统计 =====
        List<Map<String, Object>> parkStatsList = f1.join();
        int fullAccessCount = 0;
        int partialAccessCount = 0;
        int notAccessCount = 0;
        if (parkStatsList != null) {
            for (Map<String, Object> row : parkStatsList) {
                int nonZeroCount = getIntValue(row.get("nonZeroCount"));
                if (nonZeroCount == 12) {
                    fullAccessCount++;
                } else if (nonZeroCount > 0) {
                    partialAccessCount++;
                } else {
                    notAccessCount++;
                }
            }
        }
        List<Map<String, Object>> accessStats = new ArrayList<>();
        accessStats.add(createAccessItem("全部已接入", fullAccessCount));
        accessStats.add(createAccessItem("部分已接入", partialAccessCount));
        accessStats.add(createAccessItem("未接入", notAccessCount));
        dto.setEmergencyAccessStats(accessStats);

        // ===== 2. 应急预案等级统计 =====
        List<Map<String, Object>> planLevelRaw = f2.join();
        AgileEmergencyStatisticsDTO.PlanLevelStats planStats = new AgileEmergencyStatisticsDTO.PlanLevelStats();
        planStats.setSuperior(0);
        planStats.setParkLevel(0);
        planStats.setEnterprise(0);
        for (Map<String, Object> row : planLevelRaw) {
            String level = (String) row.get("level");
            int count = getIntValue(row.get("count"));
            if ("1".equals(level)) {
                planStats.setSuperior(count);
            } else if ("2".equals(level)) {
                planStats.setParkLevel(count);
            } else if ("3".equals(level)) {
                planStats.setEnterprise(count);
            }
        }
        dto.setEmergencyPlanLevelStats(planStats);

        // ===== 3. 应急演练级别统计 =====
        List<Map<String, Object>> drillLevelRaw = f3.join();
        AgileEmergencyStatisticsDTO.DrillLevelStats drillStats = new AgileEmergencyStatisticsDTO.DrillLevelStats();
        drillStats.setCity(0);
        drillStats.setPark(0);
        drillStats.setCompany(0);
        drillStats.setWorkshop(0);
        for (Map<String, Object> row : drillLevelRaw) {
            String level = (String) row.get("level");
            int count = getIntValue(row.get("count"));
            if ("01".equals(level)) {
                drillStats.setCity(count);
            } else if ("02".equals(level)) {
                drillStats.setPark(count);
            } else if ("03".equals(level)) {
                drillStats.setCompany(count);
            } else if ("04".equals(level)) {
                drillStats.setWorkshop(count);
            }
        }
        dto.setEmergencyDrillLevelStats(drillStats);

        // ===== 4. 应急资源统计 =====
        Map<String, Object> resourceData = f4.join();
        AgileEmergencyStatisticsDTO.ResourceStats resourceStats = new AgileEmergencyStatisticsDTO.ResourceStats();
        resourceStats.setMaterialCount(getIntValue(resourceData.get("materialCount")));
        resourceStats.setRescueTeamCount(getIntValue(resourceData.get("rescueTeamCount")));
        resourceStats.setExpertCount(getIntValue(resourceData.get("expertCount")));
        resourceStats.setShelterCount(getIntValue(resourceData.get("shelterCount")));
        resourceStats.setMedicalInstitutionCount(getIntValue(resourceData.get("medicalInstitutionCount")));
        dto.setEmergencyResourceStats(resourceStats);

        return dto;
    }

    private int getIntValue(Object obj) {
        if (obj == null) return 0;
        if (obj instanceof Number) return ((Number) obj).intValue();
        try {
            return Integer.parseInt(obj.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private Map<String, Object> createAccessItem(String name, int value) {
        Map<String, Object> item = new HashMap<>();
        item.put("name", name);
        item.put("value", value);
        return item;
    }
}
