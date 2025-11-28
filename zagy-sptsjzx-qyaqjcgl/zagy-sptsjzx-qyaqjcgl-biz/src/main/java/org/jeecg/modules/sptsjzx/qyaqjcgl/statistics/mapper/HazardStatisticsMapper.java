package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface HazardStatisticsMapper {

    // 获取危险源分类统计
    List<Map<String, Object>> getHazardAccessStats(@Param("countycode") String countycode,
                                                             @Param("yqType") Integer yqType,
                                                             @Param("companyCode") String companyCode,
                                                             @Param("isScqy") Integer isScqy);
    
    // 获取危险源等级统计
    List<Map<String, Object>> getHazardLevelStats(@Param("countycode") String countycode,
                                                    @Param("yqType") Integer yqType,
                                                    @Param("companyCode") String companyCode,
                                                    @Param("isScqy") Integer isScqy);
    
    // 获取当日安全承诺统计
    Map<String, Object> getTodayCommitmentStats(@Param("countycode") String countycode,
                                                 @Param("yqType") Integer yqType,
                                                 @Param("companyCode") String companyCode,
                                                 @Param("isScqy") Integer isScqy,
                                                 @Param("today") String today);
    
    // 获取预警和警示统计
    Map<String, Object> getWarningStats(@Param("countycode") String countycode,
                                         @Param("yqType") Integer yqType,
                                         @Param("companyCode") String companyCode,
                                         @Param("isScqy") Integer isScqy);
}