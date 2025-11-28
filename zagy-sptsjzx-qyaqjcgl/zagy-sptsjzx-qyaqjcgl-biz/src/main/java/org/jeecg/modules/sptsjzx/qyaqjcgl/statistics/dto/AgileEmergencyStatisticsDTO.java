package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class AgileEmergencyStatisticsDTO {
    
    /**
     * 敏捷应急接入情况统计
     */
    private AccessStats emergencyAccessStats;
    
    /**
     * 应急预案等级统计
     */
    private List<Map<String, Object>> emergencyPlanLevelStats;
    
    /**
     * 应急演练级别统计
     */
    private List<Map<String, Object>> emergencyDrillLevelStats;
    
    /**
     * 应急资源统计
     */
    private ResourceStats emergencyResourceStats;
    
    /**
     * 接入情况统计内部类
     */
    @Data
    public static class AccessStats {
        /**
         * 全部已接入(12张表都有数据)
         */
        private Integer fullAccess;
        
        /**
         * 部分已接入(至少1张表有数据,但不是全部)
         */
        private Integer partialAccess;
        
        /**
         * 未接入(12张表都没有数据)
         */
        private Integer notAccess;
        
        /**
         * 总数(固定为1)
         */
        private Integer total;
    }
    
    /**
     * 应急资源统计内部类
     */
    @Data
    public static class ResourceStats {
        /**
         * 应急物资数量
         */
        private Integer materialCount;
        
        /**
         * 应急救援队伍数量
         */
        private Integer rescueTeamCount;
        
        /**
         * 应急专家数量
         */
        private Integer expertCount;
        
        /**
         * 应急避难场所数量
         */
        private Integer shelterCount;
        
        /**
         * 医疗机构资源数量
         */
        private Integer medicalInstitutionCount;
    }
}