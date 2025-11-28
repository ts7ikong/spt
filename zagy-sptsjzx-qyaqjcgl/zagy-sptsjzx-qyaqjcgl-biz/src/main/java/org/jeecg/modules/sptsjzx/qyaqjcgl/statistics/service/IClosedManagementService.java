package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service;


import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.ClosedManagementStatisticsDTO;

public interface IClosedManagementService {
    
    /**
     * 获取封闭化管理统计数据
     * 
     * @param parkCode 园区编码
     * @param countycode 区县编码
     * @param timeRange 时间范围: today-当日, week-近7天, month-近30天
     * @return 封闭化管理统计数据
     */
    ClosedManagementStatisticsDTO getClosedManagementStatistics(String parkCode,
                                                                String countycode,
                                                                String timeRange);
}