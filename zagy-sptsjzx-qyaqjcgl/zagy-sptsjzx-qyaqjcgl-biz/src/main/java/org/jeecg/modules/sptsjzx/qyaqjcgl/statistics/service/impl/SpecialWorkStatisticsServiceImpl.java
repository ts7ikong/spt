package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.SpecialWorkStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.SpecialWorkStatisticsMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.ISpecialWorkStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@DS("zfd")  // 指定数据源
public class SpecialWorkStatisticsServiceImpl implements ISpecialWorkStatisticsService {

    @Autowired
    private SpecialWorkStatisticsMapper mapper;

    @Override
    public SpecialWorkStatisticsDTO getSpecialWorkStatistics(String countycode,
                                                             Integer yqType,
                                                             String parkCode,
                                                             List<String> companyCodes,
                                                             Integer isScqy) {
        SpecialWorkStatisticsDTO dto = new SpecialWorkStatisticsDTO();

        // 1. 接入情况统计：单次扫描返回 {fullCount, partialCount, notCount}，再组装为 name/value 列表
        Map<String, Object> accessRaw = mapper.getTicketAccessStats(countycode, yqType, parkCode, companyCodes, isScqy);
        List<Map<String, Object>> ticketAccessStats = new ArrayList<>();
        ticketAccessStats.add(buildItem("全部接入", accessRaw.get("fullCount")));
        ticketAccessStats.add(buildItem("部分接入", accessRaw.get("partialCount")));
        ticketAccessStats.add(buildItem("未接入",   accessRaw.get("notCount")));
        dto.setTicketAccessStats(ticketAccessStats);

        // 2. 作业票状态统计(饼图)
        List<Map<String, Object>> statusStats = mapper.getTicketStatusStats(countycode, yqType, parkCode, companyCodes, isScqy);
        dto.setTicketStatusStats(statusStats);

        // 3. 作业大类统计(柱状图)
        List<Map<String, Object>> typeStats = mapper.getTicketTypeStats(countycode, yqType, parkCode, companyCodes, isScqy);
        dto.setTicketTypeStats(typeStats);

        return dto;
    }

    private Map<String, Object> buildItem(String name, Object countObj) {
        Map<String, Object> item = new HashMap<>();
        item.put("name", name);
        item.put("value", countObj instanceof Number ? ((Number) countObj).intValue() : 0);
        return item;
    }
}
