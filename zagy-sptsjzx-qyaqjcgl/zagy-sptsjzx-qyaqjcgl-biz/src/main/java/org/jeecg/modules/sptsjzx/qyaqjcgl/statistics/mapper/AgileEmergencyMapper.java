package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AgileEmergencyMapper {

    List<Map<String, Object>> getEmergencyAccessStatsByPark(@Param("parkCodes") List<String> parkCodes);

    List<Map<String, Object>> getEmergencyPlanLevelStats(@Param("parkCodes") List<String> parkCodes);

    List<Map<String, Object>> getEmergencyDrillLevelStats(@Param("parkCodes") List<String> parkCodes,
                                                          @Param("drillType") String drillType);

    Map<String, Object> getEmergencyResourceStats(@Param("parkCodes") List<String> parkCodes);
}