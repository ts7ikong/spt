package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service;

import java.util.Map;

public interface IStatisticsService {

    /**
     * 获取综合统计数据
     */
    Map<String, Object> getComprehensiveStats(String countycode, Integer yqType,
                                              String companyCode, Integer isScqy);
}