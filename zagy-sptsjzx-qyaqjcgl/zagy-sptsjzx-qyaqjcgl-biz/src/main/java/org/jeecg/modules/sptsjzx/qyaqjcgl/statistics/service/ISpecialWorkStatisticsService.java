package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service;


import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.SpecialWorkStatisticsDTO;

import java.util.List;

public interface ISpecialWorkStatisticsService {

    /**
     * 获取特殊作业安全管控统计数据
     */
    SpecialWorkStatisticsDTO getSpecialWorkStatistics(String countycode,
                                                      Integer yqType,
                                                      String parkCode,
                                                      List<String> companyCodes,
                                                      Integer isScqy);
}