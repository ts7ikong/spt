package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.impl;

import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.SpecialWorkStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.SpecialWorkStatisticsMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.ISpecialWorkStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

// 注意：@DS("zfd") 保留在类上，但并行线程需要手动通过 DynamicDataSourceContextHolder 设置数据源
@Service
public class SpecialWorkStatisticsServiceImpl implements ISpecialWorkStatisticsService {

    private static final String DS_KEY = "zfd";

    @Autowired
    private SpecialWorkStatisticsMapper mapper;

    @Override
    public SpecialWorkStatisticsDTO getSpecialWorkStatistics(String countycode,
                                                             Integer yqType,
                                                             String parkCode,
                                                             List<String> companyCodes,
                                                             Integer isScqy) {
        // 3 个查询完全独立，并行执行（手动设置数据源，因为 CompletableFuture 线程不继承 ThreadLocal）
        CompletableFuture<Map<String, Object>> f1 = onZfd(
                () -> mapper.getTicketAccessStats(countycode, yqType, parkCode, companyCodes, isScqy));
        CompletableFuture<List<Map<String, Object>>> f2 = onZfd(
                () -> mapper.getTicketStatusStats(countycode, yqType, parkCode, companyCodes, isScqy));
        CompletableFuture<List<Map<String, Object>>> f3 = onZfd(
                () -> mapper.getTicketTypeStats(countycode, yqType, parkCode, companyCodes, isScqy));

        CompletableFuture.allOf(f1, f2, f3).join();

        SpecialWorkStatisticsDTO dto = new SpecialWorkStatisticsDTO();

        // 接入情况：单次扫描返回 {fullCount, partialCount, notCount}，组装为 name/value 列表
        Map<String, Object> accessRaw = f1.join();
        List<Map<String, Object>> ticketAccessStats = new ArrayList<>();
        ticketAccessStats.add(buildItem("全部接入", accessRaw.get("fullCount")));
        ticketAccessStats.add(buildItem("部分接入", accessRaw.get("partialCount")));
        ticketAccessStats.add(buildItem("未接入",   accessRaw.get("notCount")));
        dto.setTicketAccessStats(ticketAccessStats);

        dto.setTicketStatusStats(f2.join());
        dto.setTicketTypeStats(f3.join());

        return dto;
    }

    /** 在 zfd 数据源上异步执行任务（CompletableFuture 线程不继承 ThreadLocal，需手动设置） */
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
