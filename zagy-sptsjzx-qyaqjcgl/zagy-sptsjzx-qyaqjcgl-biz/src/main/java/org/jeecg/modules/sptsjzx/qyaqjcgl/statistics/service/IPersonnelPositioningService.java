package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service;


import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.PersonnelPositioningStatisticsDTO;

public interface IPersonnelPositioningService {
    
    /**
     * 获取人员定位统计数据
     * 
     * @param countycode 区县编码
     * @param yqType 园区类型
     * @param companyCode 企业编码
     * @param isScqy 是否生产企业
     * @param alarmStatus 报警状态: all-全部, alarming-报警中, dispelled-已消警
     * @return 人员定位统计数据
     */
    PersonnelPositioningStatisticsDTO getPersonnelPositioningStatistics(
        String countycode, 
        Integer yqType,
        String companyCode, 
        Integer isScqy,
        String alarmStatus
    );
}