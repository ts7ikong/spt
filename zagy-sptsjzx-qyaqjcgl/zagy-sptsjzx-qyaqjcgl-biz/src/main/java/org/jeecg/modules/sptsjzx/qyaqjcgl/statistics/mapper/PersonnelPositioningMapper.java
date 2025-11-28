package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

@Mapper
public interface PersonnelPositioningMapper {
    
    /**
     * 获取人员定位接入情况统计
     */
    Map<String, Object> getPositioningAccessStats(@Param("countycode") String countycode,
                                                  @Param("yqType") Integer yqType,
                                                  @Param("companyCode") String companyCode,
                                                  @Param("isScqy") Integer isScqy);
    
    /**
     * 获取人员类型统计
     */
    List<Map<String, Object>> getPersonnelTypeStats(@Param("countycode") String countycode,
                                                    @Param("yqType") Integer yqType,
                                                    @Param("companyCode") String companyCode,
                                                    @Param("isScqy") Integer isScqy);
    
    /**
     * 获取区域统计
     */
    Map<String, Object> getZoneStats(@Param("countycode") String countycode,
                                     @Param("yqType") Integer yqType,
                                     @Param("companyCode") String companyCode,
                                     @Param("isScqy") Integer isScqy);
    
    /**
     * 获取人员聚集报警数量
     */
    Integer getCrowdAlarmCount(@Param("countycode") String countycode,
                              @Param("yqType") Integer yqType,
                              @Param("companyCode") String companyCode,
                              @Param("isScqy") Integer isScqy);
    
    /**
     * 获取人员报警统计
     */
    List<Map<String, Object>> getPersonnelAlarmStats(@Param("countycode") String countycode,
                                                     @Param("yqType") Integer yqType,
                                                     @Param("companyCode") String companyCode,
                                                     @Param("isScqy") Integer isScqy,
                                                     @Param("alarmStatus") String alarmStatus);
    
    /**
     * 获取区域报警统计
     */
    List<Map<String, Object>> getZoneAlarmStats(@Param("countycode") String countycode,
                                               @Param("yqType") Integer yqType,
                                               @Param("companyCode") String companyCode,
                                               @Param("isScqy") Integer isScqy,
                                               @Param("alarmStatus") String alarmStatus);
    
    /**
     * 获取人员总数
     */
    Integer getPersonnelTotalCount(@Param("countycode") String countycode,
                                  @Param("yqType") Integer yqType,
                                  @Param("companyCode") String companyCode,
                                  @Param("isScqy") Integer isScqy);
}