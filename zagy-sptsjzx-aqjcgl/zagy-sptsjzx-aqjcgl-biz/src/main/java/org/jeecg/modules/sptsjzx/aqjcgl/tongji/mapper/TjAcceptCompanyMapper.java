package org.jeecg.modules.sptsjzx.aqjcgl.tongji.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 企业信息Mapper
 */
@Mapper
@DS("zfd")  // 使用 zfd 数据源 (zlkj_danger_data_accept库)
public interface TjAcceptCompanyMapper {
    
    /**
     * 统计区县数量
     * @param countycode 区县编码
     * @param yqType 园区类型
     * @param isScqy 是否生产企业
     * @return 区县数量
     */
    Long countCounties(@Param("countycode") String countycode,
                       @Param("yqType") Integer yqType,
                       @Param("isScqy") Integer isScqy);
    
    /**
     * 统计企业数量
     * @param countycode 区县编码
     * @param yqType 园区类型
     * @param isScqy 是否生产企业
     * @return 企业数量
     */
    Long countCompanies(@Param("countycode") String countycode,
                        @Param("yqType") Integer yqType,
                        @Param("isScqy") Integer isScqy);
    
    /**
     * 统计生产企业数量
     * @param countycode 区县编码
     * @param yqType 园区类型
     * @return 生产企业数量
     */
    Long countProductionCompanies(@Param("countycode") String countycode,
                                   @Param("yqType") Integer yqType);
    
    /**
     * 统计重大危险源企业数量
     * @param countycode 区县编码
     * @param yqType 园区类型
     * @param isScqy 是否生产企业
     * @return 重大危险源企业数量
     */
    Long countMajorHazardCompanies(@Param("countycode") String countycode,
                                    @Param("yqType") Integer yqType,
                                    @Param("isScqy") Integer isScqy);

    Map<String, Object> getAccessStats(@Param("countycode") String countycode,
                                       @Param("yqType") Integer yqType,
                                       @Param("isScqy") Integer isScqy);
}