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
                                                  @Param("parkCode") String parkCode,
                                                  @Param("companyCodes") List<String> companyCodes,
                                                  @Param("isScqy") Integer isScqy);

    /**
     * 获取人员类型统计
     */
    List<Map<String, Object>> getPersonnelTypeStats(@Param("countycode") String countycode,
                                                    @Param("yqType") Integer yqType,
                                                    @Param("parkCode") String parkCode,
                                                    @Param("companyCodes") List<String> companyCodes,
                                                    @Param("isScqy") Integer isScqy);

    /**
     * 获取区域统计
     */
    Map<String, Object> getZoneStats(@Param("countycode") String countycode,
                                     @Param("yqType") Integer yqType,
                                     @Param("parkCode") String parkCode,
                                     @Param("companyCodes") List<String> companyCodes,
                                     @Param("isScqy") Integer isScqy);

    /**
     * 获取人员聚集报警数量
     */
    Integer getCrowdAlarmCount(@Param("countycode") String countycode,
                              @Param("yqType") Integer yqType,
                              @Param("parkCode") String parkCode,
                              @Param("companyCodes") List<String> companyCodes,
                              @Param("isScqy") Integer isScqy);

    /**
     * 获取人员报警统计
     */
    List<Map<String, Object>> getPersonnelAlarmStats(@Param("countycode") String countycode,
                                                     @Param("yqType") Integer yqType,
                                                     @Param("parkCode") String parkCode,
                                                     @Param("companyCodes") List<String> companyCodes,
                                                     @Param("isScqy") Integer isScqy,
                                                     @Param("alarmStatus") String alarmStatus);

    /**
     * 获取区域报警统计
     */
    List<Map<String, Object>> getZoneAlarmStats(@Param("countycode") String countycode,
                                               @Param("yqType") Integer yqType,
                                               @Param("parkCode") String parkCode,
                                               @Param("companyCodes") List<String> companyCodes,
                                               @Param("isScqy") Integer isScqy,
                                               @Param("alarmStatus") String alarmStatus);

    /**
     * 获取人员总数
     */
    Integer getPersonnelTotalCount(@Param("countycode") String countycode,
                                  @Param("yqType") Integer yqType,
                                  @Param("parkCode") String parkCode,
                                  @Param("companyCodes") List<String> companyCodes,
                                  @Param("isScqy") Integer isScqy);

    /**
     * 获取统一报警分类统计（含人员报警、区域报警、人员聚集报警）
     */
    List<Map<String, Object>> getUnifiedAlarmStats(
            @Param("countycode") String countycode,
            @Param("yqType") Integer yqType,
            @Param("parkCode") String parkCode,
            @Param("companyCodes") List<String> companyCodes,
            @Param("isScqy") Integer isScqy,
            @Param("alarmStatus") String alarmStatus
    );

    // ---- 以下方法供 PersonnelPositioningCacheJob 使用，全量扫描，按企业分组 ----

    /**
     * 按企业分组统计人员定位接入情况（全量）
     */
    List<Map<String, Object>> getPositioningAccessStatsByCompany();

    /**
     * 按企业分组统计区域数量（全量）
     */
    List<Map<String, Object>> getZoneStatsByCompany();

    /**
     * 按企业+人员类型分组统计人员数量（全量）
     */
    List<Map<String, Object>> getPersonnelTypeStatsByCompany();

    /**
     * 按企业+报警名称分组统计报警数量（全量，三种状态分列存储）
     * 包含人员报警(rybjsj) + 区域报警(qybjsj)
     */
    List<Map<String, Object>> getAlarmStatsByCompany();

    /**
     * 按企业分组统计人员聚集报警数量（全量，来自 ryjj，无 alarmStatus 过滤）
     */
    List<Map<String, Object>> getCrowdAlarmCountByCompany();
}