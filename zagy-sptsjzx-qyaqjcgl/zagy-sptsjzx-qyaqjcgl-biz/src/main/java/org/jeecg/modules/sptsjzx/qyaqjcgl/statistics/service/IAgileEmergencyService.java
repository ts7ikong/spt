package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service;


import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.AgileEmergencyStatisticsDTO;

import java.util.List;

public interface IAgileEmergencyService {

    /**
     * 获取敏捷应急统计数据
     *
     * @param yqCodes 企业编码列表
     * @param drillType  演练类型(可选)
     * @return 敏捷应急统计数据
     */
    AgileEmergencyStatisticsDTO getAgileEmergencyStatistics(List<String> yqCodes,String drillType);
}