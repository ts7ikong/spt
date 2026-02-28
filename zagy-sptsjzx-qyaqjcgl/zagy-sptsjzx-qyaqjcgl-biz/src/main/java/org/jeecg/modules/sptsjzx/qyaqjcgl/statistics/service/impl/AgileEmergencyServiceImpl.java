package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.AgileEmergencyStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.AgileEmergencyMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IAgileEmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AgileEmergencyServiceImpl implements IAgileEmergencyService {

    @Autowired
    private AgileEmergencyMapper mapper;

    @Override
    public AgileEmergencyStatisticsDTO getAgileEmergencyStatistics(List<String> yqCodes,
                                                                   String drillType) {
        AgileEmergencyStatisticsDTO dto = new AgileEmergencyStatisticsDTO();

        // ===== 1. 接入情况统计（List<Map>，name/value，仅 value>0）=====
        List<Map<String, Object>> parkStatsList = mapper.getEmergencyAccessStatsByPark(yqCodes);

        int fullAccessCount = 0;   // 全部已接入园区数
        int partialAccessCount = 0;// 部分已接入园区数
        int notAccessCount = 0;    // 未接入园区数

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

        // 2. 组装结果
        List<Map<String, Object>> accessStats = new ArrayList<>();
        accessStats.add(createAccessItem("全部已接入", fullAccessCount));
        accessStats.add(createAccessItem("部分已接入", partialAccessCount));
        accessStats.add(createAccessItem("未接入", notAccessCount));

        dto.setEmergencyAccessStats(accessStats);


        // ===== 2. 应急预案等级统计（DTO）=====
        List<Map<String, Object>> planLevelRaw = mapper.getEmergencyPlanLevelStats(yqCodes);
        AgileEmergencyStatisticsDTO.PlanLevelStats planStats = new AgileEmergencyStatisticsDTO.PlanLevelStats();
        // 初始化为 0（避免 null）
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
            // 忽略其他级别
        }
        dto.setEmergencyPlanLevelStats(planStats);

        // ===== 3. 应急演练级别统计（DTO，支持 drillType 筛选）=====
        List<Map<String, Object>> drillLevelRaw = mapper.getEmergencyDrillLevelStats(yqCodes, drillType);
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

        // ===== 4. 应急资源统计（DTO）=====
        Map<String, Object> resourceData = mapper.getEmergencyResourceStats(yqCodes);
        AgileEmergencyStatisticsDTO.ResourceStats resourceStats = new AgileEmergencyStatisticsDTO.ResourceStats();
        resourceStats.setMaterialCount(getIntValue(resourceData.get("materialCount")));
        resourceStats.setRescueTeamCount(getIntValue(resourceData.get("rescueTeamCount")));
        resourceStats.setExpertCount(getIntValue(resourceData.get("expertCount")));
        resourceStats.setShelterCount(getIntValue(resourceData.get("shelterCount")));
        resourceStats.setMedicalInstitutionCount(getIntValue(resourceData.get("medicalInstitutionCount")));
        dto.setEmergencyResourceStats(resourceStats);

        return dto;
    }

    // 辅助方法：安全转 int
    private int getIntValue(Object obj) {
        if (obj == null) return 0;
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
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