package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

@Mapper
public interface AgileEmergencyMapper {
    
    /**
     * 获取敏捷应急接入情况统计
     */
    Map<String, Object> getEmergencyAccessStats(@Param("parkCode") String parkCode,
                                                @Param("countycode") String countycode);
    
    /**
     * 获取应急预案等级统计
     */
    List<Map<String, Object>> getEmergencyPlanLevelStats(@Param("parkCode") String parkCode,
                                                         @Param("countycode") String countycode);
    
    /**
     * 获取应急演练级别统计
     */
    List<Map<String, Object>> getEmergencyDrillLevelStats(@Param("parkCode") String parkCode,
                                                          @Param("countycode") String countycode,
                                                          @Param("drillType") String drillType);
    
    /**
     * 获取应急资源统计
     */
    Map<String, Object> getEmergencyResourceStats(@Param("parkCode") String parkCode,
                                                  @Param("countycode") String countycode);
}