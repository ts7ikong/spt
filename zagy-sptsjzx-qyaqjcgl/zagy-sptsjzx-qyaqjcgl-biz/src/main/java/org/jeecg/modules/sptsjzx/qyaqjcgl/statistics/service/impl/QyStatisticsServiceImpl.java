package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.QyStatisticsMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IQyStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@DS("zfd")
public class QyStatisticsServiceImpl implements IQyStatisticsService {



    @Autowired
    private QyStatisticsMapper qyStatisticsMapper;

    @Override
    public Map<String, Object> getComprehensiveStats(String citycode, String countycode, Integer yqType,
                                                     String parkCode, List<String> companyCodes, Integer isScqy) {
        Map<String, Object> result = new HashMap<>();

        // 1. 企业安全基础管理数据接入情况
        Map<String, Object> dataAccess = qyStatisticsMapper.getDataAccessStats(
                citycode, countycode, yqType, parkCode, companyCodes, isScqy
        );
        result.put("dataAccess", dataAccess);

        // 2. 设备类型统计
        List<Map<String, Object>> deviceTypes = qyStatisticsMapper.getDeviceTypeStats(
                citycode, countycode, yqType, parkCode, companyCodes, isScqy
        );
        result.put("deviceTypes", deviceTypes);

        // 3. 其他统计项
        Map<String, Object> otherStats = qyStatisticsMapper.getOtherStats(
                citycode, countycode, yqType, parkCode, companyCodes, isScqy
        );
        result.putAll(otherStats);

        return result;
    }
}