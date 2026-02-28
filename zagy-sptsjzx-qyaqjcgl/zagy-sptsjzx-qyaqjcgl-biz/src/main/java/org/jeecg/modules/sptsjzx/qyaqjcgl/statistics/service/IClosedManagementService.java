package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service;


import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.ClosedManagementStatisticsDTO;

import java.util.List;

public interface IClosedManagementService {

    /**
     * 获取封闭化管理统计数据
     *
     * @param yqCodes 园区编码列表
     * @param timeRange 时间范围: today-当日, week-近7天, month-近30天
     * @return 封闭化管理统计数据
     */
    ClosedManagementStatisticsDTO getClosedManagementStatistics(
                                                                List<String> yqCodes,
                                                                String timeRange);
}