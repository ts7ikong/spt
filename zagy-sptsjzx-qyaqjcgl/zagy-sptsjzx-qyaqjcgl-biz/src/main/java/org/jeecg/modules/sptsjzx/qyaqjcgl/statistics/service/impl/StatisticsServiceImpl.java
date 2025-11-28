package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.mapper.AcceptCompanyMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.sbxx.mapper.DeviceBaseInfoMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.StatisticsMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@DS("zfd")
public class StatisticsServiceImpl implements IStatisticsService {



    @Autowired
    private StatisticsMapper statisticsMapper;

    @Override
    public Map<String, Object> getComprehensiveStats(String countycode, Integer yqType,
                                                     String companyCode, Integer isScqy) {
        Map<String, Object> result = new HashMap<>();

        // 1. 企业安全基础管理数据接入情况
        Map<String, Object> dataAccess = statisticsMapper.getDataAccessStats(
                countycode, yqType, companyCode, isScqy
        );
        result.put("dataAccess", dataAccess);

        // 2. 设备类型统计
        List<Map<String, Object>> deviceTypes = statisticsMapper.getDeviceTypeStats(
                countycode, yqType, companyCode, isScqy
        );
        result.put("deviceTypes", deviceTypes);

        // 3. 其他统计项
        Map<String, Object> otherStats = statisticsMapper.getOtherStats(
                countycode, yqType, companyCode, isScqy
        );
        result.putAll(otherStats);

        return result;
    }
}