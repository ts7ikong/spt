package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

@Mapper
public interface SpecialWorkStatisticsMapper {
    
    /**
     * 获取作业票接入情况统计
     */
    Map<String, Object> getTicketAccessStats(@Param("countycode") String countycode,
                                             @Param("yqType") Integer yqType,
                                             @Param("companyCode") String companyCode,
                                             @Param("isScqy") Integer isScqy);
    
    /**
     * 获取作业票状态统计
     */
    List<Map<String, Object>> getTicketStatusStats(@Param("countycode") String countycode,
                                                   @Param("yqType") Integer yqType,
                                                   @Param("companyCode") String companyCode,
                                                   @Param("isScqy") Integer isScqy);
    
    /**
     * 获取作业大类统计
     */
    List<Map<String, Object>> getTicketTypeStats(@Param("countycode") String countycode,
                                                 @Param("yqType") Integer yqType,
                                                 @Param("companyCode") String companyCode,
                                                 @Param("isScqy") Integer isScqy);
    
    /**
     * 获取作业票总数
     */
    Integer getTicketTotalCount(@Param("countycode") String countycode,
                               @Param("yqType") Integer yqType,
                               @Param("companyCode") String companyCode,
                               @Param("isScqy") Integer isScqy);
}