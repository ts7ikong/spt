package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.QyStatisticsMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IQyStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@DS("zfd")
public class QyStatisticsServiceImpl implements IQyStatisticsService {

    @Autowired
    private QyStatisticsMapper qyStatisticsMapper;

    @Override
    public Map<String, Object> getComprehensiveStats(String citycode, String countycode, Integer yqType,
                                                     String parkCode, List<String> companyCodes, Integer isScqy) {
        Map<String, Object> result = new HashMap<>();

        // 1. 企业安全基础管理数据接入情况：单次扫描返回 {fullCount, partialCount, notCount}，再组装 name/value 列表
        Map<String, Object> accessRaw = qyStatisticsMapper.getDataAccessStats(
                citycode, countycode, yqType, parkCode, companyCodes, isScqy
        );
        List<Map<String, Object>> dataAccess = new ArrayList<>();
        dataAccess.add(buildItem("全部接入", accessRaw.get("fullCount")));
        dataAccess.add(buildItem("部分接入", accessRaw.get("partialCount")));
        dataAccess.add(buildItem("未接入",   accessRaw.get("notCount")));
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

    private Map<String, Object> buildItem(String name, Object countObj) {
        Map<String, Object> item = new HashMap<>();
        item.put("name", name);
        item.put("value", countObj instanceof Number ? ((Number) countObj).intValue() : 0);
        return item;
    }
}
