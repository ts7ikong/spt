package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.SpecialWorkStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.SpecialWorkStatisticsMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.ISpecialWorkStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@DS("zfd")  // 指定数据源
public class SpecialWorkStatisticsServiceImpl implements ISpecialWorkStatisticsService {
    
    @Autowired
    private SpecialWorkStatisticsMapper mapper;
    
    @Override
    public SpecialWorkStatisticsDTO getSpecialWorkStatistics(String countycode,
                                                             Integer yqType,
                                                             String companyCode,
                                                             Integer isScqy) {
        SpecialWorkStatisticsDTO dto = new SpecialWorkStatisticsDTO();
        
        // 1. 接入情况统计
        Map<String, Object> accessStats = mapper.getTicketAccessStats(countycode, yqType, companyCode, isScqy);
        SpecialWorkStatisticsDTO.AccessStats ticketAccessStats = new SpecialWorkStatisticsDTO.AccessStats();
        ticketAccessStats.setFullAccess(((Number) accessStats.get("fullAccess")).intValue());
        ticketAccessStats.setPartialAccess(((Number) accessStats.get("partialAccess")).intValue());
        ticketAccessStats.setNotAccess(((Number) accessStats.get("notAccess")).intValue());
        ticketAccessStats.setTotal(((Number) accessStats.get("total")).intValue());
        dto.setTicketAccessStats(ticketAccessStats);
        
        // 2. 作业票状态统计(饼图)
        List<Map<String, Object>> statusStats = mapper.getTicketStatusStats(countycode, yqType, companyCode, isScqy);
        dto.setTicketStatusStats(statusStats);
        
        // 3. 作业大类统计(柱状图)
        List<Map<String, Object>> typeStats = mapper.getTicketTypeStats(countycode, yqType, companyCode, isScqy);
        dto.setTicketTypeStats(typeStats);
        
        // 4. 作业票总数
        Integer totalCount = mapper.getTicketTotalCount(countycode, yqType, companyCode, isScqy);
        dto.setTicketTotalCount(totalCount != null ? totalCount : 0);
        
        return dto;
    }
}