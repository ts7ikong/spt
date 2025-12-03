package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service;


import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.PersonnelPositioningStatisticsDTO;

import java.util.List;

public interface IPersonnelPositioningService {

    /**
     * 获取人员定位统计数据
     *
     * @param countycode 区县编码
     * @param yqType 园区类型
     * @param parkCode 园区编码
     * @param companyCodes 企业编码列表
     * @param isScqy 是否生产企业
     * @param alarmStatus 报警状态: all-全部, alarming-报警中, dispelled-已消警
     * @return 人员定位统计数据
     */
    PersonnelPositioningStatisticsDTO getPersonnelPositioningStatistics(
        String countycode,
        Integer yqType,
        String parkCode,
        List<String> companyCodes,
        Integer isScqy,
        String alarmStatus
    );
}