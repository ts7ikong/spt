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
            String parkCode,
            List<String> companyCodes,
            Integer isScqy,
            String alarmStatus) {

        PersonnelPositioningStatisticsDTO dto = new PersonnelPositioningStatisticsDTO();

        // 1. 接入情况统计
        Map<String, Object> accessStatsMap = mapper.getPositioningAccessStats(countycode, yqType, parkCode, companyCodes, isScqy);
        List<Map<String, Object>> accessStats = new ArrayList<>();
        String[][] mapping = {
                {"fullAccess", "全部接入"},
                {"partialAccess", "部分接入"},
                {"noAccess", "未接入"}
        };

        for (String[] entry : mapping) {
            Map<String, Object> item = new HashMap<>();
            item.put("name", entry[1]);
            item.put("value", accessStatsMap.get(entry[0]) != null ?
                    ((Number) accessStatsMap.get(entry[0])).intValue() : 0);
            accessStats.add(item);
        }
        dto.setPositioningAccessStats(accessStats);

        // 2. 人员类型统计(饼图)
        List<Map<String, Object>> personnelTypeStats = mapper.getPersonnelTypeStats(countycode, yqType, parkCode, companyCodes, isScqy);
        dto.setPersonnelTypeStats(personnelTypeStats);

        // 4. 区域统计
        Map<String, Object> zoneStats = mapper.getZoneStats(countycode, yqType, parkCode, companyCodes, isScqy);
        dto.setTemporaryZoneCount(((Number) zoneStats.get("temporaryZoneCount")).intValue());
        dto.setFixedZoneCount(((Number) zoneStats.get("fixedZoneCount")).intValue());

        // 5. 报警分类统计（包含人员聚集报警）
        List<Map<String, Object>> unifiedAlarms = mapper.getUnifiedAlarmStats(
                countycode, yqType, parkCode, companyCodes, isScqy, alarmStatus
        );

        // 提取“人员聚集报警”数量，并从列表中过滤掉它
        Integer crowdAlarmCount = 0;
        List<Map<String, Object>> filteredAlarms = new ArrayList<>();

        for (Map<String, Object> alarm : unifiedAlarms) {
            String name = (String) alarm.get("name");
            // 安全转换 value（防止 null）
            Object valueObj = alarm.get("value");
            Integer value = (valueObj instanceof Number) ? ((Number) valueObj).intValue() : 0;

            if ("人员聚集报警".equals(name)) {
                crowdAlarmCount = value; // 单独记录
            } else {
                // 只保留非聚集报警，且确保 value 不为 null（虽然 SQL 不会返回 null）
                Map<String, Object> safeAlarm = new HashMap<>();
                safeAlarm.put("name", name);
                safeAlarm.put("value", value);
                filteredAlarms.add(safeAlarm);
            }
        }

        // 按 value 降序排序（仅对非聚集报警）
        List<Map<String, Object>> alarmClassificationStats = filteredAlarms.stream()
                .sorted((a, b) -> {
                    Integer valA = (Integer) a.get("value");
                    Integer valB = (Integer) b.get("value");
                    return valB.compareTo(valA); // 降序
                })
                .collect(Collectors.toList());

        // 设置到 DTO（crowdAlarmCount 已经是 0 或实际值，无需判 null）
        dto.setCrowdAlarmCount(crowdAlarmCount);
        dto.setAlarmClassificationStats(alarmClassificationStats);

        return dto;
    }
}