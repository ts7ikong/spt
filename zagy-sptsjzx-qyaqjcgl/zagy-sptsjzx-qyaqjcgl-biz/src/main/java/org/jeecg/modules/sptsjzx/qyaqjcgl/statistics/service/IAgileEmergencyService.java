package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service;


import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.AgileEmergencyStatisticsDTO;

public interface IAgileEmergencyService {

    /**
     * 获取敏捷应急统计数据
     *
     * @param parkCode   园区编码
     * @param countycode 区县编码
     * @param drillType  演练类型(可选)
     * @return 敏捷应急统计数据
     */
    AgileEmergencyStatisticsDTO getAgileEmergencyStatistics(String parkCode,
                                                            String countycode,
                                                            String drillType);
}