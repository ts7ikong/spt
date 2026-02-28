package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.impl;

import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.QyStatisticsMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IQyStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@Service
public class QyStatisticsServiceImpl implements IQyStatisticsService {

    private static final String DS_KEY = "zfd";

    @Autowired
    private QyStatisticsMapper qyStatisticsMapper;

    @Override
    public Map<String, Object> getComprehensiveStats(String citycode, String countycode, Integer yqType,
                                                     String parkCode, List<String> companyCodes, Integer isScqy) {
        // 3 个查询完全独立，并行执行（手动设置 zfd 数据源，因为 CompletableFuture 不继承 ThreadLocal）
        CompletableFuture<Map<String, Object>> f1 = onZfd(
                () -> qyStatisticsMapper.getDataAccessStats(citycode, countycode, yqType, parkCode, companyCodes, isScqy));
        CompletableFuture<List<Map<String, Object>>> f2 = onZfd(
                () -> qyStatisticsMapper.getDeviceTypeStats(citycode, countycode, yqType, parkCode, companyCodes, isScqy));
        CompletableFuture<Map<String, Object>> f3 = onZfd(
                () -> qyStatisticsMapper.getOtherStats(citycode, countycode, yqType, parkCode, companyCodes, isScqy));

        CompletableFuture.allOf(f1, f2, f3).join();

        // 接入情况：单次扫描结果 {fullCount, partialCount, notCount} → name/value 列表
        Map<String, Object> accessRaw = f1.join();
        List<Map<String, Object>> dataAccess = new ArrayList<>();
        dataAccess.add(buildItem("全部接入", accessRaw.get("fullCount")));
        dataAccess.add(buildItem("部分接入", accessRaw.get("partialCount")));
        dataAccess.add(buildItem("未接入",   accessRaw.get("notCount")));

        Map<String, Object> result = new HashMap<>();
        result.put("dataAccess",  dataAccess);
        result.put("deviceTypes", f2.join());
        Map<String, Object> otherStats = f3.join();
        if (otherStats != null) result.putAll(otherStats);

        return result;
    }

    private <T> CompletableFuture<T> onZfd(Supplier<T> supplier) {
        return CompletableFuture.supplyAsync(() -> {
            DynamicDataSourceContextHolder.push(DS_KEY);
            try {
                return supplier.get();
            } finally {
                DynamicDataSourceContextHolder.poll();
            }
        });
    }

    private Map<String, Object> buildItem(String name, Object countObj) {
        Map<String, Object> item = new HashMap<>();
        item.put("name", name);
        item.put("value", countObj instanceof Number ? ((Number) countObj).intValue() : 0);
        return item;
    }
}
