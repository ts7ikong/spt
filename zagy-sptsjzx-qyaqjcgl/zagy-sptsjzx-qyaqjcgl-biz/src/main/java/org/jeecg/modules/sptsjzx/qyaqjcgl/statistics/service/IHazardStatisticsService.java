package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service;

import java.util.Map;

public interface IHazardStatisticsService {
    
    Map<String, Object> getHazardManagementStats(String countycode, Integer yqType, 
                                                   String companyCode, Integer isScqy);
}