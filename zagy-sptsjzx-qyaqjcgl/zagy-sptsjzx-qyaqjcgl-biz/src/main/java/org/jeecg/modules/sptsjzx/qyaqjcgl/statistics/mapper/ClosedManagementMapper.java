package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

@Mapper
public interface ClosedManagementMapper {
    
    /**
     * 获取封闭化管理接入情况统计
     */
    Map<String, Object> getClosedAccessStats(@Param("parkCode") String parkCode,
                                             @Param("countycode") String countycode);
    
    /**
     * 获取报警类型统计
     */
    List<Map<String, Object>> getAlarmTypeStats(@Param("parkCode") String parkCode,
                                                @Param("countycode") String countycode);
    
    /**
     * 获取报警基本信息统计
     */
    Map<String, Object> getBasicInfoStats(@Param("parkCode") String parkCode,
                                          @Param("countycode") String countycode);
    
    /**
     * 获取车辆通行数据统计
     */
    Map<String, Object> getVehicleTrafficStats(@Param("parkCode") String parkCode,
                                               @Param("countycode") String countycode,
                                               @Param("timeRange") String timeRange);
    
    /**
     * 获取人员通行数据统计
     */
    Map<String, Object> getPersonnelTrafficStats(@Param("parkCode") String parkCode,
                                                 @Param("countycode") String countycode,
                                                 @Param("timeRange") String timeRange);
}