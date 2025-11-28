package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.PersonnelPositioningStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.PersonnelPositioningMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IPersonnelPositioningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@DS("zfd")
public class PersonnelPositioningServiceImpl implements IPersonnelPositioningService {
    
    @Autowired
    private PersonnelPositioningMapper mapper;
    
    @Override
    public PersonnelPositioningStatisticsDTO getPersonnelPositioningStatistics(
            String countycode, 
            Integer yqType,
            String companyCode, 
            Integer isScqy,
            String alarmStatus) {
        
        PersonnelPositioningStatisticsDTO dto = new PersonnelPositioningStatisticsDTO();
        
        // 1. 接入情况统计
        Map<String, Object> accessStats = mapper.getPositioningAccessStats(countycode, yqType, companyCode, isScqy);
        PersonnelPositioningStatisticsDTO.AccessStats positioningAccessStats = 
            new PersonnelPositioningStatisticsDTO.AccessStats();
        positioningAccessStats.setFullAccess(((Number) accessStats.get("fullAccess")).intValue());
        positioningAccessStats.setPartialAccess(((Number) accessStats.get("partialAccess")).intValue());
        positioningAccessStats.setNotAccess(((Number) accessStats.get("notAccess")).intValue());
        positioningAccessStats.setTotal(((Number) accessStats.get("total")).intValue());
        dto.setPositioningAccessStats(positioningAccessStats);
        
        // 2. 人员类型统计(饼图)
        List<Map<String, Object>> personnelTypeStats = mapper.getPersonnelTypeStats(countycode, yqType, companyCode, isScqy);
        dto.setPersonnelTypeStats(personnelTypeStats);
        
        // 3. 人员总数
        Integer personnelTotalCount = mapper.getPersonnelTotalCount(countycode, yqType, companyCode, isScqy);
        dto.setPersonnelTotalCount(personnelTotalCount != null ? personnelTotalCount : 0);
        
        // 4. 区域统计
        Map<String, Object> zoneStats = mapper.getZoneStats(countycode, yqType, companyCode, isScqy);
        dto.setTemporaryZoneCount(((Number) zoneStats.get("temporaryZoneCount")).intValue());
        dto.setFixedZoneCount(((Number) zoneStats.get("fixedZoneCount")).intValue());
        dto.setTotalZoneCount(((Number) zoneStats.get("totalZoneCount")).intValue());
        
        // 5. 人员聚集报警数量
        Integer crowdAlarmCount = mapper.getCrowdAlarmCount(countycode, yqType, companyCode, isScqy);
        dto.setCrowdAlarmCount(crowdAlarmCount != null ? crowdAlarmCount : 0);
        
        // 6. 报警分类统计 - 合并人员报警和区域报警
        // 人员报警(rybjsj): SOS报警, 越界报警, 滞留报警, 静止报警, 离场报警
        List<Map<String, Object>> personnelAlarms = mapper.getPersonnelAlarmStats(
            countycode, yqType, companyCode, isScqy, alarmStatus);
        
        // 区域报警(qybjsj): 超员报警, 缺员报警, 缺岗报警
        List<Map<String, Object>> zoneAlarms = mapper.getZoneAlarmStats(
            countycode, yqType, companyCode, isScqy, alarmStatus);
        
        // 合并报警统计,按报警类型名称分组求和
        Map<String, Integer> alarmMap = new HashMap<>();
        
        for (Map<String, Object> alarm : personnelAlarms) {
            String name = (String) alarm.get("name");
            Integer value = ((Number) alarm.get("value")).intValue();
            alarmMap.put(name, alarmMap.getOrDefault(name, 0) + value);
        }
        
        for (Map<String, Object> alarm : zoneAlarms) {
            String name = (String) alarm.get("name");
            Integer value = ((Number) alarm.get("value")).intValue();
            alarmMap.put(name, alarmMap.getOrDefault(name, 0) + value);
        }
        
        // 转换为列表格式并按数量降序排序
        List<Map<String, Object>> alarmClassificationStats = alarmMap.entrySet().stream()
            .map(entry -> {
                Map<String, Object> map = new HashMap<>();
                map.put("name", entry.getKey());
                map.put("value", entry.getValue());
                return map;
            })
            .sorted((a, b) -> ((Integer)b.get("value")).compareTo((Integer)a.get("value")))
            .collect(Collectors.toList());
        
        dto.setAlarmClassificationStats(alarmClassificationStats);
        
        return dto;
    }
}