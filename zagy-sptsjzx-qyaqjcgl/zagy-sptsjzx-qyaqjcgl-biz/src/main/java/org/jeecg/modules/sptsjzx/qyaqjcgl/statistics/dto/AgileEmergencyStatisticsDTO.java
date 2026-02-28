package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;


@Data
public class AgileEmergencyStatisticsDTO {


    /**
     * 敏捷应急接入情况统计 —— 和封闭化管理一致，用 List<Map>
     */
    private List<Map<String, Object>> emergencyAccessStats;

    /**
     * 应急预案等级统计 —— 用 DTO
     */
    private PlanLevelStats emergencyPlanLevelStats;

    /**
     * 应急演练级别统计 —— 用 DTO
     */
    private DrillLevelStats emergencyDrillLevelStats;

    /**
     * 应急资源统计 —— 用 DTO
     */
    private ResourceStats emergencyResourceStats;

    // --- 以下是三个内部 DTO 类 ---

    @Data
    public static class PlanLevelStats {
        private Integer superior;     // 上级（市级）
        private Integer parkLevel;    // 园区级
        private Integer enterprise;   // 企业级
    }

    @Data
    public static class DrillLevelStats {
        private Integer city;         // 市级
        private Integer park;         // 园区级
        private Integer company;      // 公司级
        private Integer workshop;     // 车间级
    }

    @Data
    public static class ResourceStats {
        private Integer materialCount;
        private Integer rescueTeamCount;
        private Integer expertCount;
        private Integer shelterCount;
        private Integer medicalInstitutionCount;
    }
}