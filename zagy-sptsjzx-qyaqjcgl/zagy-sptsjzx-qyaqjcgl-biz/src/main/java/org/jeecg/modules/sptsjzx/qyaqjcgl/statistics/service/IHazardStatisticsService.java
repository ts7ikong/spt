package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service;

import java.util.List;
import java.util.Map;

public interface IHazardStatisticsService {

    Map<String, Object> getHazardManagementStats(String countycode, Integer yqType,
                                                   String parkCode, List<String> companyCodes, Integer isScqy);
}