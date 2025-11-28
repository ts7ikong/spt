package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class SpecialWorkStatisticsDTO {
    
    /**
     * 作业票接入情况统计
     */
    private AccessStats ticketAccessStats;
    
    /**
     * 作业票状态统计(饼图数据)
     */
    private List<Map<String, Object>> ticketStatusStats;
    
    /**
     * 作业大类统计(柱状图数据)
     */
    private List<Map<String, Object>> ticketTypeStats;
    
    /**
     * 作业票总数
     */
    private Integer ticketTotalCount;
    
    /**
     * 接入情况统计内部类
     */
    @Data
    public static class AccessStats {
        /**
         * 全部已接入企业数(ticket_state=1 且 ticket_activity=1)
         */
        private Integer fullAccess;
        
        /**
         * 部分已接入企业数(其中一个为0)
         */
        private Integer partialAccess;
        
        /**
         * 未接入企业数(都为0)
         */
        private Integer notAccess;
        
        /**
         * 企业总数
         */
        private Integer total;
    }
}