package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.impl;

import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.AgileEmergencyStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.AgileEmergencyMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IAgileEmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AgileEmergencyServiceImpl implements IAgileEmergencyService {

    @Autowired
    private AgileEmergencyMapper mapper;

    @Override
    public AgileEmergencyStatisticsDTO getAgileEmergencyStatistics(String parkCode,
                                                                   String countycode,
                                                                   String drillType) {

        AgileEmergencyStatisticsDTO dto = new AgileEmergencyStatisticsDTO();

        // 1. 接入情况统计
        Map<String, Object> accessData = mapper.getEmergencyAccessStats(parkCode, countycode);

        // 判断12张表是否有数据
        int yjyaCount = ((Number) accessData.get("yjyaCount")).intValue();
        int yjyljhCount = ((Number) accessData.get("yjyljhCount")).intValue();
        int yjylssgcCount = ((Number) accessData.get("yjylssgcCount")).intValue();
        int yjwzCount = ((Number) accessData.get("yjwzCount")).intValue();
        int yjjydwCount = ((Number) accessData.get("yjjydwCount")).intValue();
        int yjzjCount = ((Number) accessData.get("yjzjCount")).intValue();
        int yjbncsCount = ((Number) accessData.get("yjbncsCount")).intValue();
        int ylzyCount = ((Number) accessData.get("ylzyCount")).intValue();
        int jjjlCount = ((Number) accessData.get("jjjlCount")).intValue();
        int xbjlCount = ((Number) accessData.get("xbjlCount")).intValue();
        int jyczgcCount = ((Number) accessData.get("jyczgcCount")).intValue();
        int yjczfaCount = ((Number) accessData.get("yjczfaCount")).intValue();

        // 计算有数据的表数量
        int hasDataCount = 0;
        if (yjyaCount > 0) hasDataCount++;
        if (yjyljhCount > 0) hasDataCount++;
        if (yjylssgcCount > 0) hasDataCount++;
        if (yjwzCount > 0) hasDataCount++;
        if (yjjydwCount > 0) hasDataCount++;
        if (yjzjCount > 0) hasDataCount++;
        if (yjbncsCount > 0) hasDataCount++;
        if (ylzyCount > 0) hasDataCount++;
        if (jjjlCount > 0) hasDataCount++;
        if (xbjlCount > 0) hasDataCount++;
        if (jyczgcCount > 0) hasDataCount++;
        if (yjczfaCount > 0) hasDataCount++;

        AgileEmergencyStatisticsDTO.AccessStats emergencyAccessStats =
                new AgileEmergencyStatisticsDTO.AccessStats();

        if (hasDataCount == 12) {
            // 12张表都有数据 - 全部已接入
            emergencyAccessStats.setFullAccess(1);
            emergencyAccessStats.setPartialAccess(0);
            emergencyAccessStats.setNotAccess(0);
        } else if (hasDataCount > 0) {
            // 部分表有数据 - 部分已接入
            emergencyAccessStats.setFullAccess(0);
            emergencyAccessStats.setPartialAccess(1);
            emergencyAccessStats.setNotAccess(0);
        } else {
            // 12张表都没有数据 - 未接入
            emergencyAccessStats.setFullAccess(0);
            emergencyAccessStats.setPartialAccess(0);
            emergencyAccessStats.setNotAccess(1);
        }
        emergencyAccessStats.setTotal(1);
        dto.setEmergencyAccessStats(emergencyAccessStats);

        // 2. 应急预案等级统计
        List<Map<String, Object>> planLevelStats = mapper.getEmergencyPlanLevelStats(parkCode, countycode);
        dto.setEmergencyPlanLevelStats(planLevelStats);

        // 3. 应急演练级别统计(带演练类型筛选)
        List<Map<String, Object>> drillLevelStats = mapper.getEmergencyDrillLevelStats(parkCode, countycode, drillType);
        dto.setEmergencyDrillLevelStats(drillLevelStats);

        // 4. 应急资源统计
        Map<String, Object> resourceData = mapper.getEmergencyResourceStats(parkCode, countycode);
        AgileEmergencyStatisticsDTO.ResourceStats resourceStats =
                new AgileEmergencyStatisticsDTO.ResourceStats();
        resourceStats.setMaterialCount(((Number) resourceData.get("materialCount")).intValue());
        resourceStats.setRescueTeamCount(((Number) resourceData.get("rescueTeamCount")).intValue());
        resourceStats.setExpertCount(((Number) resourceData.get("expertCount")).intValue());
        resourceStats.setShelterCount(((Number) resourceData.get("shelterCount")).intValue());
        resourceStats.setMedicalInstitutionCount(((Number) resourceData.get("medicalInstitutionCount")).intValue());
        dto.setEmergencyResourceStats(resourceStats);

        return dto;
    }
}