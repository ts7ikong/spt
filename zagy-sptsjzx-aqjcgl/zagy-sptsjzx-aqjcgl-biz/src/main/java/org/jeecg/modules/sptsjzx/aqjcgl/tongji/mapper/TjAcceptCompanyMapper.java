package org.jeecg.modules.sptsjzx.aqjcgl.tongji.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 企业信息Mapper
 */
@Mapper
@DS("zfd")  // 使用 zfd 数据源 (zlkj_danger_data_accept库)
public interface TjAcceptCompanyMapper {
    
    /**
     * 统计区县数量
     * @param citycode 城市编码
     * @param countycode 区县编码
     * @param yqType 园区类型
     * @param parkCode 园区编码
     * @param companyCodes 企业编码列表
     * @param isScqy 是否生产企业
     * @return 区县数量
     */
    Long countCounties(@Param("citycode") String citycode,
                       @Param("countycode") String countycode,
                       @Param("yqType") Integer yqType,
                       @Param("parkCode") String parkCode,
                       @Param("companyCodes") List<String> companyCodes,
                       @Param("isScqy") Integer isScqy);

    /**
     * 统计企业数量
     * @param citycode 城市编码
     * @param countycode 区县编码
     * @param yqType 园区类型
     * @param parkCode 园区编码
     * @param companyCodes 企业编码列表
     * @param isScqy 是否生产企业
     * @return 企业数量
     */
    Long countCompanies(@Param("citycode") String citycode,
                        @Param("countycode") String countycode,
                        @Param("yqType") Integer yqType,
                        @Param("parkCode") String parkCode,
                        @Param("companyCodes") List<String> companyCodes,
                        @Param("isScqy") Integer isScqy);

    /**
     * 统计生产企业数量
     * @param citycode 城市编码
     * @param countycode 区县编码
     * @param yqType 园区类型
     * @param parkCode 园区编码
     * @param companyCodes 企业编码列表
     * @return 生产企业数量
     */
    Long countProductionCompanies(@Param("citycode") String citycode,
                                   @Param("countycode") String countycode,
                                   @Param("yqType") Integer yqType,
                                   @Param("parkCode") String parkCode,
                                   @Param("companyCodes") List<String> companyCodes);

    /**
     * 统计重大危险源企业数量
     * @param citycode 城市编码
     * @param countycode 区县编码
     * @param yqType 园区类型
     * @param parkCode 园区编码
     * @param companyCodes 企业编码列表
     * @param isScqy 是否生产企业
     * @return 重大危险源企业数量
     */
    Long countMajorHazardCompanies(@Param("citycode") String citycode,
                                    @Param("countycode") String countycode,
                                    @Param("yqType") Integer yqType,
                                    @Param("parkCode") String parkCode,
                                    @Param("companyCodes") List<String> companyCodes,
                                    @Param("isScqy") Integer isScqy);

    Map<String, Object> getAccessStats(@Param("countycode") String countycode,
                                       @Param("yqType") Integer yqType,
                                       @Param("isScqy") Integer isScqy);


    /**
     * 统计接入情况
     */
    List<Map<String, Object>> countAccessStatus(@Param("countycode") String countycode,
                                                @Param("yqType") Integer yqType,
                                                @Param("companyCodes") List<String> companyCodes,
                                                @Param("isScqy") Integer isScqy);

    /**
     * 统计运行情况
     */
    Map<String, Object> countRunLevel(@Param("countycode") String countycode,
                                      @Param("yqType") Integer yqType,
                                      @Param("companyCodes") List<String> companyCodes,
                                      @Param("isScqy") Integer isScqy);

    /**
     * 统计分析单元数量
     */
    Integer countUnit(@Param("companyCodes") List<String> companyCodes);

    /**
     * 统计风险事件数量
     */
    Integer countEvent(@Param("companyCodes") List<String> companyCodes);

    /**
     * 统计管控措施数量
     */
    Integer countMeasures(@Param("companyCodes") List<String> companyCodes);

    /**
     * 统计排查任务数量
     */
    Integer countTask(@Param("companyCodes") List<String> companyCodes);

    /**
     * 统计隐患排查治理情况
     */
    Map<String, Object> countDangerInvestigation(@Param("companyCodes") List<String> companyCodes);

}