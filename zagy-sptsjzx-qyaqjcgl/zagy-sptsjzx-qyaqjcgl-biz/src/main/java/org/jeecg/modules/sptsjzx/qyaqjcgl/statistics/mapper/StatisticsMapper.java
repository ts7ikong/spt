package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StatisticsMapper {

    /**
     * 获取企业安全基础管理数据接入情况
     */
    Map<String, Object> getDataAccessStats(@Param("countycode") String countycode,
                                           @Param("yqType") Integer yqType,
                                           @Param("companyCode") String companyCode,
                                           @Param("isScqy") Integer isScqy);

    /**
     * 获取设备类型统计
     */
    List<Map<String, Object>> getDeviceTypeStats(@Param("countycode") String countycode,
                                                 @Param("yqType") Integer yqType,
                                                 @Param("companyCode") String companyCode,
                                                 @Param("isScqy") Integer isScqy);

    /**
     * 获取其他统计项
     */
    Map<String, Object> getOtherStats(@Param("countycode") String countycode,
                                      @Param("yqType") Integer yqType,
                                      @Param("companyCode") String companyCode,
                                      @Param("isScqy") Integer isScqy);
}