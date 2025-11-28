package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class ClosedManagementStatisticsDTO {
    
    /**
     * 封闭化管理接入情况统计
     */
    private AccessStats closedAccessStats;
    
    /**
     * 报警类型统计(饼图数据)
     */
    private List<Map<String, Object>> alarmTypeStats;
    
    /**
     * 报警基本信息统计
     */
    private BasicInfoStats basicInfoStats;
    
    /**
     * 通行数据统计
     */
    private TrafficStats trafficStats;
    
    /**
     * 接入情况统计内部类
     */
    @Data
    public static class AccessStats {
        /**
         * 全部已接入(10张表都有数据)
         */
        private Integer fullAccess;
        
        /**
         * 部分已接入(至少1张表有数据,但不是全部)
         */
        private Integer partialAccess;
        
        /**
         * 未接入(10张表都没有数据)
         */
        private Integer notAccess;
        
        /**
         * 总数(固定为1,因为是统计整个系统的接入情况)
         */
        private Integer total;
    }
    
    /**
     * 报警基本信息统计内部类
     */
    @Data
    public static class BasicInfoStats {
        /**
         * 卡口门禁数量
         */
        private Integer gateCount;
        
        /**
         * 危化车辆数量
         */
        private Integer hazardousVehicleCount;
        
        /**
         * 其他车辆数量
         */
        private Integer otherVehicleCount;
        
        /**
         * 访客数量
         */
        private Integer visitorCount;
    }
    
    /**
     * 通行数据统计内部类
     */
    @Data
    public static class TrafficStats {
        /**
         * 普货车数量(车辆类型=1)
         */
        private Integer generalCargoCount;
        
        /**
         * 危化运输车数量(车辆类型=2)
         */
        private Integer hazardousTransportCount;
        
        /**
         * 小型车辆数量(车辆类型=3)
         */
        private Integer smallVehicleCount;
        
        /**
         * 应急车辆数量(车辆类型=4)
         */
        private Integer emergencyVehicleCount;
        
        /**
         * 备案人员数量(人员类型=1)
         */
        private Integer registeredPersonnelCount;
        
        /**
         * 访客人员数量(人员类型=2)
         */
        private Integer visitorPersonnelCount;
    }
}