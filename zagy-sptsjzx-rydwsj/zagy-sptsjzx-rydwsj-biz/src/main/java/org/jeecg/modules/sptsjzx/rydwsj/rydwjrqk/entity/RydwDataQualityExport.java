package org.jeecg.modules.sptsjzx.rydwsj.rydwjrqk.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;
import org.jeecg.common.constant.ProvinceCityArea;
import org.jeecg.common.util.SpringContextUtils;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 人员定位接入情况
 * @Author: zagy-cg
 * @Date: 2026-01-29
 * @Version: V1.0
 */
@Data
@TableName("rydw_data_quality_export")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "rydw_data_quality_export对象", description = "人员定位接入情况")
public class RydwDataQualityExport implements Serializable {
    private static final long serialVersionUID = 1L;

    /**主键ID*/
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键ID")
    private Integer id;
    /**企业编码*/
    @Excel(name = "企业编码", width = 15, dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @ApiModelProperty(value = "企业编码")
    private String companyCode;
    /**企业名称*/
//    @Excel(name = "企业名称", width = 15)
    @ApiModelProperty(value = "企业名称")
    private String companyName;

    /**区县Code*/
    @TableField(exist = false)
    @ApiModelProperty(value = "区县Code")
    @Dict(dictTable = "v_company_county", dicText = "county_name", dicCode = "code")
    @Excel(name = "所属区县", width = 20, dictTable = "v_company_county", dicText = "county_name", dicCode = "code")
    private java.lang.String countyCode;

    /**实时数据*/
    @Excel(name = "实时数据", width = 15, dicCode = "sssjsfjr")
    @Dict(dicCode = "sssjsfjr")
    @ApiModelProperty(value = "实时数据")
    private Integer realTimeSuccess;
    /**历史轨迹*/
    @Excel(name = "历史轨迹", width = 15, dicCode = "lsgjsfjr")
    @Dict(dicCode = "lsgjsfjr")
    @ApiModelProperty(value = "历史轨迹")
    private Integer historyTrackSuccess;
    /**聚集报警*/
    @Excel(name = "聚集报警", width = 15, dicCode = "jjbjsfjr")
    @Dict(dicCode = "jjbjsfjr")
    @ApiModelProperty(value = "聚集报警")
    private Integer crowdAlarmMatch;
    /**区域报警*/
    @Excel(name = "区域报警", width = 15, dicCode = "jjbjsfjr")
    @Dict(dicCode = "jjbjsfjr")
    @ApiModelProperty(value = "区域报警")
    private Integer areaAlarmMatch;
    /**人员报警*/
    @Excel(name = "人员报警", width = 15, dicCode = "jjbjsfjr")
    @Dict(dicCode = "jjbjsfjr")
    @ApiModelProperty(value = "人员报警")
    private Integer personAlarmMatch;
    /**区域边界*/
    @Excel(name = "区域边界", width = 15, dicCode = "jjbjsfjr")
    @Dict(dicCode = "jjbjsfjr")
    @ApiModelProperty(value = "区域边界")
    private Integer geoFormatValid;
    /**检查时间*/
    @Excel(name = "检查时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "检查时间")
    private Date checkTime;


    /**是否重大危险源*/
    @TableField(exist = false)
    @ApiModelProperty(value = "是否重大危险源")
    @Excel(name = "是否重大危险源", width = 10, dictTable = "v_accept_company", dicText = "is_zdwxy", dicCode = "code")
    @Dict(dictTable = "v_accept_company", dicText = "is_zdwxy", dicCode = "code")
    private java.lang.String isZdwxy;
}
