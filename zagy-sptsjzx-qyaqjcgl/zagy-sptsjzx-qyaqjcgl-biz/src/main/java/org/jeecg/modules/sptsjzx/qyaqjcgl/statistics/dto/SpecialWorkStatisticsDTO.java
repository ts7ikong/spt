package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class SpecialWorkStatisticsDTO {

    /**
     * 作业票接入情况统计（返回 name/value 列表）
     * [{name: '全部接入', value: 6}, {name: '部分接入', value: 0}, {name: '未接入', value: 0}]
     */
    private List<Map<String, Object>> ticketAccessStats;

    /**
     * 作业票状态统计(饼图数据)
     */
    private List<Map<String, Object>> ticketStatusStats;

    /**
     * 作业大类统计(柱状图数据)
     */
    private List<Map<String, Object>> ticketTypeStats;

}