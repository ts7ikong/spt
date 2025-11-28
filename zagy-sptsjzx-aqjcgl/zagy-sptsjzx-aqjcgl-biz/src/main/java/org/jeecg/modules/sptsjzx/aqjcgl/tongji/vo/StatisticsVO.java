package org.jeecg.modules.sptsjzx.aqjcgl.tongji.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 统计数据VO
 */
@Data
@ApiModel(value = "StatisticsVO", description = "统计数据返回对象")
public class StatisticsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "区县数")
    private Long countyCount;

    @ApiModelProperty(value = "园区数")
    private Long parkCount;

    @ApiModelProperty(value = "企业数")
    private Long companyCount;

    @ApiModelProperty(value = "生产企业数")
    private Long productionCompanyCount;

    @ApiModelProperty(value = "重大危险源企业数")
    private Long majorHazardCompanyCount;
}