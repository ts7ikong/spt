package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class PersonnelPositioningStatisticsDTO {
    
    /**
     * 人员定位接入情况统计
     */
    private AccessStats positioningAccessStats;
    
    /**
     * 人员类型统计(饼图数据)
     */
    private List<Map<String, Object>> personnelTypeStats;
    
    /**
     * 人员总数
     */
    private Integer personnelTotalCount;
    
    /**
     * 临时区域数量
     */
    private Integer temporaryZoneCount;
    
    /**
     * 固定区域数量
     */
    private Integer fixedZoneCount;
    
    /**
     * 区域总数
     */
    private Integer totalZoneCount;
    
    /**
     * 人员聚集报警数量
     */
    private Integer crowdAlarmCount;
    
    /**
     * 报警分类统计
     * 包含: SOS报警, 越界报警, 滞留报警, 静止报警, 离场报警, 超员报警, 缺员报警, 缺岗报警
     */
    private List<Map<String, Object>> alarmClassificationStats;
    
    /**
     * 接入情况统计内部类
     */
    @Data
    public static class AccessStats {
        /**
         * 全部已接入企业数
         * ryxxk=1 且 qybjxx=1 且 ryjjsj=1 且 rybjsj=1 且 qybjsj=1
         */
        private Integer fullAccess;
        
        /**
         * 部分已接入企业数(至少一个为1,但不是全部为1)
         */
        private Integer partialAccess;
        
        /**
         * 未接入企业数(全部为0)
         */
        private Integer notAccess;
        
        /**
         * 企业总数
         */
        private Integer total;
    }
}