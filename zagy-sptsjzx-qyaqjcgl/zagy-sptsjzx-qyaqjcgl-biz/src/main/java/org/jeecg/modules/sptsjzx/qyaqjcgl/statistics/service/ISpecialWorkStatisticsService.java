package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service;


import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.SpecialWorkStatisticsDTO;

public interface ISpecialWorkStatisticsService {
    
    /**
     * 获取特殊作业安全管控统计数据
     */
    SpecialWorkStatisticsDTO getSpecialWorkStatistics(String countycode,
                                                      Integer yqType,
                                                      String companyCode,
                                                      Integer isScqy);
}