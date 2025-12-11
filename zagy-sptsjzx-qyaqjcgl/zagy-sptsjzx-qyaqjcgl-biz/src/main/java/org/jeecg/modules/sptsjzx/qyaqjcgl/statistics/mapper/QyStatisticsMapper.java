package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface QyStatisticsMapper {

    /**
     * 获取企业安全基础管理数据接入情况
     */
    Map<String, Object> getDataAccessStats(@Param("citycode") String citycode,
                                           @Param("countycode") String countycode,
                                           @Param("yqType") Integer yqType,
                                           @Param("parkCode") String parkCode,
                                           @Param("companyCodes") List<String> companyCodes,
                                           @Param("isScqy") Integer isScqy);

    /**
     * 获取设备类型统计
     */
    List<Map<String, Object>> getDeviceTypeStats(@Param("citycode") String citycode,
                                                 @Param("countycode") String countycode,
                                                 @Param("yqType") Integer yqType,
                                                 @Param("parkCode") String parkCode,
                                                 @Param("companyCodes") List<String> companyCodes,
                                                 @Param("isScqy") Integer isScqy);

    /**
     * 获取其他统计项
     */
    Map<String, Object> getOtherStats(@Param("citycode") String citycode,
                                      @Param("countycode") String countycode,
                                      @Param("yqType") Integer yqType,
                                      @Param("parkCode") String parkCode,
                                      @Param("companyCodes") List<String> companyCodes,
                                      @Param("isScqy") Integer isScqy);
}