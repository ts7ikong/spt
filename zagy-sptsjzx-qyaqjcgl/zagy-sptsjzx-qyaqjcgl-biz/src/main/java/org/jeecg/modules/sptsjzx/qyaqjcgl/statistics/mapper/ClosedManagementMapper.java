package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface ClosedManagementMapper {
    
    /**
     * 获取封闭化管理接入情况统计
     */
    Map<String, Object> getClosedAccessStats(@Param("parkCode") String parkCode,
                                             @Param("companyCodes") List<String> companyCodes,
                                             @Param("countycode") String countycode);

    /**
     * 获取报警类型统计
     */
    List<Map<String, Object>> getAlarmTypeStats(@Param("parkCode") String parkCode,
                                                @Param("companyCodes") List<String> companyCodes,
                                                @Param("countycode") String countycode);

    /**
     * 获取报警基本信息统计
     */
    Map<String, Object> getBasicInfoStats(@Param("parkCode") String parkCode,
                                          @Param("companyCodes") List<String> companyCodes,
                                          @Param("countycode") String countycode);

    /**
     * 获取车辆通行数据统计
     */
    Map<String, Object> getVehicleTrafficStats(@Param("parkCode") String parkCode,
                                               @Param("companyCodes") List<String> companyCodes,
                                               @Param("countycode") String countycode,
                                               @Param("timeRange") String timeRange);

    /**
     * 获取人员通行数据统计
     */
    Map<String, Object> getPersonnelTrafficStats(@Param("parkCode") String parkCode,
                                                 @Param("companyCodes") List<String> companyCodes,
                                                 @Param("countycode") String countycode,
                                                 @Param("timeRange") String timeRange);


    Map<String, Object> getClosedManagementAllInOne(
            @Param("parkCodes") List<String> parkCodes,
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime
    );


    /** 静态基础数据（kkmj/fkxx/whpcl/qtcl/tcc/ryssdw/whpclssdw 7 张小表） */
    List<Map<String, Object>> getStaticInfoByPark(@Param("parkCodes") List<String> parkCodes);

    /** 车辆通行（clsstx 大表，带时间过滤，与其他 3 个查询并行） */
    List<Map<String, Object>> getVehicleTrafficByPark(@Param("parkCodes") List<String> parkCodes,
                                                      @Param("startTime") LocalDateTime startTime,
                                                      @Param("endTime") LocalDateTime endTime);

    /** 人员通行（rysstxsj 大表，带时间过滤，与其他 3 个查询并行） */
    List<Map<String, Object>> getPersonnelTrafficByPark(@Param("parkCodes") List<String> parkCodes,
                                                        @Param("startTime") LocalDateTime startTime,
                                                        @Param("endTime") LocalDateTime endTime);

    /** 报警数据（sbbjsj，与其他 3 个查询并行） */
    List<Map<String, Object>> getAlarmStatsByPark(@Param("parkCodes") List<String> parkCodes);

    List<Map<String, Object>> countGroupByPark(@Param("tableName") String tableName,
                                               @Param("parkCodes") List<String> parkCodes);
}