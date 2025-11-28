package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.impl;

import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.ClosedManagementStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.ClosedManagementMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IClosedManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClosedManagementServiceImpl implements IClosedManagementService {
    
    @Autowired
    private ClosedManagementMapper mapper;
    
    @Override
    public ClosedManagementStatisticsDTO getClosedManagementStatistics(String parkCode,
                                                                       String countycode,
                                                                       String timeRange) {
        
        ClosedManagementStatisticsDTO dto = new ClosedManagementStatisticsDTO();
        
        // 1. 接入情况统计
        Map<String, Object> accessData = mapper.getClosedAccessStats(parkCode, countycode);
        
        // 判断10张表是否有数据
        int kkmjCount = ((Number) accessData.get("kkmjCount")).intValue();
        int fkxxCount = ((Number) accessData.get("fkxxCount")).intValue();
        int whpclCount = ((Number) accessData.get("whpclCount")).intValue();
        int qtclCount = ((Number) accessData.get("qtclCount")).intValue();
        int tccCount = ((Number) accessData.get("tccCount")).intValue();
        int clsstxCount = ((Number) accessData.get("clsstxCount")).intValue();
        int rysstxCount = ((Number) accessData.get("rysstxCount")).intValue();
        int ryssdwCount = ((Number) accessData.get("ryssdwCount")).intValue();
        int whpclssdwCount = ((Number) accessData.get("whpclssdwCount")).intValue();
        int sbbjsjCount = ((Number) accessData.get("sbbjsjCount")).intValue();
        
        // 计算有数据的表数量
        int hasDataCount = 0;
        if (kkmjCount > 0) hasDataCount++;
        if (fkxxCount > 0) hasDataCount++;
        if (whpclCount > 0) hasDataCount++;
        if (qtclCount > 0) hasDataCount++;
        if (tccCount > 0) hasDataCount++;
        if (clsstxCount > 0) hasDataCount++;
        if (rysstxCount > 0) hasDataCount++;
        if (ryssdwCount > 0) hasDataCount++;
        if (whpclssdwCount > 0) hasDataCount++;
        if (sbbjsjCount > 0) hasDataCount++;
        
        ClosedManagementStatisticsDTO.AccessStats closedAccessStats = 
            new ClosedManagementStatisticsDTO.AccessStats();
        
        if (hasDataCount == 10) {
            // 10张表都有数据 - 全部已接入
            closedAccessStats.setFullAccess(1);
            closedAccessStats.setPartialAccess(0);
            closedAccessStats.setNotAccess(0);
        } else if (hasDataCount > 0) {
            // 部分表有数据 - 部分已接入
            closedAccessStats.setFullAccess(0);
            closedAccessStats.setPartialAccess(1);
            closedAccessStats.setNotAccess(0);
        } else {
            // 10张表都没有数据 - 未接入
            closedAccessStats.setFullAccess(0);
            closedAccessStats.setPartialAccess(0);
            closedAccessStats.setNotAccess(1);
        }
        closedAccessStats.setTotal(1);
        dto.setClosedAccessStats(closedAccessStats);
        
        // 2. 报警类型统计(饼图)
        List<Map<String, Object>> alarmTypeStats = mapper.getAlarmTypeStats(parkCode, countycode);
        dto.setAlarmTypeStats(alarmTypeStats);
        
        // 3. 报警基本信息统计
        Map<String, Object> basicInfo = mapper.getBasicInfoStats(parkCode, countycode);
        ClosedManagementStatisticsDTO.BasicInfoStats basicInfoStats = 
            new ClosedManagementStatisticsDTO.BasicInfoStats();
        basicInfoStats.setGateCount(((Number) basicInfo.get("gateCount")).intValue());
        basicInfoStats.setHazardousVehicleCount(((Number) basicInfo.get("hazardousVehicleCount")).intValue());
        basicInfoStats.setOtherVehicleCount(((Number) basicInfo.get("otherVehicleCount")).intValue());
        basicInfoStats.setVisitorCount(((Number) basicInfo.get("visitorCount")).intValue());
        dto.setBasicInfoStats(basicInfoStats);
        
        // 4. 通行数据统计
        Map<String, Object> vehicleTraffic = mapper.getVehicleTrafficStats(parkCode, countycode, timeRange);
        Map<String, Object> personnelTraffic = mapper.getPersonnelTrafficStats(parkCode, countycode, timeRange);
        
        ClosedManagementStatisticsDTO.TrafficStats trafficStats = 
            new ClosedManagementStatisticsDTO.TrafficStats();
        trafficStats.setGeneralCargoCount(((Number) vehicleTraffic.get("generalCargoCount")).intValue());
        trafficStats.setHazardousTransportCount(((Number) vehicleTraffic.get("hazardousTransportCount")).intValue());
        trafficStats.setSmallVehicleCount(((Number) vehicleTraffic.get("smallVehicleCount")).intValue());
        trafficStats.setEmergencyVehicleCount(((Number) vehicleTraffic.get("emergencyVehicleCount")).intValue());
        trafficStats.setRegisteredPersonnelCount(((Number) personnelTraffic.get("registeredPersonnelCount")).intValue());
        trafficStats.setVisitorPersonnelCount(((Number) personnelTraffic.get("visitorPersonnelCount")).intValue());
        dto.setTrafficStats(trafficStats);
        
        return dto;
    }
}