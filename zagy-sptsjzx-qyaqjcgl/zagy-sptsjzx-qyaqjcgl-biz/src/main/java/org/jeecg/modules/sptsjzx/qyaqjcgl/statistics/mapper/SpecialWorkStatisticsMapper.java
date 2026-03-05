package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

@Mapper
public interface SpecialWorkStatisticsMapper {

    /**
     * 获取作业票接入情况统计（单次扫描，返回 fullCount/partialCount/notCount）
     */
    Map<String, Object> getTicketAccessStats(@Param("countycode") String countycode,
                                             @Param("yqType") Integer yqType,
                                             @Param("parkCode") String parkCode,
                                             @Param("companyCodes") List<String> companyCodes,
                                             @Param("isScqy") Integer isScqy);

    /**
     * 获取作业票状态统计
     */
    List<Map<String, Object>> getTicketStatusStats(@Param("countycode") String countycode,
                                                   @Param("yqType") Integer yqType,
                                                   @Param("parkCode") String parkCode,
                                                   @Param("companyCodes") List<String> companyCodes,
                                                   @Param("isScqy") Integer isScqy);

    /**
     * 获取作业大类统计
     */
    List<Map<String, Object>> getTicketTypeStats(@Param("countycode") String countycode,
                                                 @Param("yqType") Integer yqType,
                                                 @Param("parkCode") String parkCode,
                                                 @Param("companyCodes") List<String> companyCodes,
                                                 @Param("isScqy") Integer isScqy);

    // ---- 以下方法供 SpecialWorkCacheJob 使用，全量扫描不带过滤，按企业分组 ----

    /**
     * 获取所有企业的元数据（编码、区县、园区、类型、是否生产企业）
     */
    List<Map<String, Object>> getAllCompanyMeta();

    /**
     * 按企业分组统计作业票接入情况（全量，不带过滤）
     */
    List<Map<String, Object>> getTicketAccessStatsByCompany();

    /**
     * 按企业分组统计各状态作业票数量（全量，不带过滤）
     */
    List<Map<String, Object>> getTicketStatusStatsByCompany();

    /**
     * 按企业+大类分组统计作业票数量（全量，不带过滤）
     */
    List<Map<String, Object>> getTicketTypeStatsByCompany();
}