package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.impl;

import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.HazardStatisticsMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IHazardStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@Service
public class HazardStatisticsServiceImpl implements IHazardStatisticsService {

    private static final String DS_KEY = "zfd";

    @Autowired
    private HazardStatisticsMapper hazardStatisticsMapper;

    @Override
    public Map<String, Object> getHazardManagementStats(String countycode, Integer yqType,
                                                        String parkCode, List<String> companyCodes, Integer isScqy) {
        String today    = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String tomorrow = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // 4 个查询完全独立，并行执行（手动设置 zfd 数据源，因为 CompletableFuture 不继承 ThreadLocal）
        CompletableFuture<List<Map<String, Object>>> f1 = onZfd(
                () -> hazardStatisticsMapper.getHazardAccessStats(countycode, yqType, parkCode, companyCodes, isScqy));
        CompletableFuture<List<Map<String, Object>>> f2 = onZfd(
                () -> hazardStatisticsMapper.getHazardLevelStats(countycode, yqType, parkCode, companyCodes, isScqy));
        CompletableFuture<Map<String, Object>> f3 = onZfd(
                () -> hazardStatisticsMapper.getTodayCommitmentStats(countycode, yqType, parkCode, companyCodes, isScqy, today, tomorrow));
        CompletableFuture<Map<String, Object>> f4 = onZfd(
                () -> hazardStatisticsMapper.getWarningStats(countycode, yqType, parkCode, companyCodes, isScqy));

        CompletableFuture.allOf(f1, f2, f3, f4).join();

        Map<String, Object> result = new HashMap<>();
        result.put("hazardClassificationStats", f1.join());
        result.put("hazardLevelStats",           f2.join());
        result.put("commitmentStats",            f3.join());
        Map<String, Object> warningStats = f4.join();
        if (warningStats != null) result.putAll(warningStats);

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
}
