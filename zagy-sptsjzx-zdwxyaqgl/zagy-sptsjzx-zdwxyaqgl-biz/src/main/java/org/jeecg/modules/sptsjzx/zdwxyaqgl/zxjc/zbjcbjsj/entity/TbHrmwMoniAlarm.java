package org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.zbjcbjsj.entity;

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
 * @Description: 指标监测报警数据
 * @Author: zagy-cg
 * @Date: 2026-04-22
 * @Version: V1.0
 */
@Data
@TableName("v_hrmw_moni_alarm_with_company")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "tb_hrmw_moni_alarm对象", description = "指标监测报警数据")
public class TbHrmwMoniAlarm implements Serializable {
    private static final long serialVersionUID = 1L;

    /**id*/
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private String id;

    /**企业编码*/
    @ApiModelProperty(value = "企业编码")
    @TableField(exist = false)
    @Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    private String companyCode;

    /**区县Code*/
    @TableField(exist = false)
    @ApiModelProperty(value = "区县Code")
    @Dict(dictTable = "v_company_county", dicText = "county_name", dicCode = "code")
    private java.lang.String countyCode;

    /**指标编码*/
    @Excel(name = "指标编码", width = 15)
    @Dict(dictTable = "v_hrmw_target_with_company", dicText = "target_name", dicCode = "target_code", ds = "pg")
    @ApiModelProperty(value = "指标编码")

    private String targetCode;
    /**指标报警时间*/
    @Excel(name = "指标报警时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "指标报警时间")
    private Date alarmTime;
    /**当前报警值*/
    @Excel(name = "当前报警值", width = 15)
    @ApiModelProperty(value = "当前报警值")
    private BigDecimal alarmValue;
    /**当前报警状态对应的阈值*/
    @Excel(name = "当前报警状态对应的阈值", width = 15)
    @ApiModelProperty(value = "当前报警状态对应的阈值")
    private BigDecimal threshold;
    /**最开始的状态*/
    @Excel(name = "最开始的状态", width = 15)
    @ApiModelProperty(value = "最开始的状态")
    private String startStatus;
    /**最坏的状态*/
    @Excel(name = "最坏的状态", width = 15)
    @ApiModelProperty(value = "最坏的状态")
    private String worstStatus;
    /**当前的状态*/
    @Excel(name = "当前的状态", width = 15)
    @ApiModelProperty(value = "当前的状态")
    private String currentStatus;
    /**销警类型*/
    @Excel(name = "销警类型", width = 15, dicCode = "xjlx")
    @Dict(dicCode = "xjlx")
    @ApiModelProperty(value = "销警类型")
    private String dispelType;
    /**最近的报警状态变更时间*/
    @Excel(name = "最近的报警状态变更时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最近的报警状态变更时间")
    private Date statusChangedTime;
    /**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
    /**创建时间*/
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**更新人*/
    @ApiModelProperty(value = "更新人")
    private String updateBy;
    /**更新时间*/
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    /**是否销警*/
    @Excel(name = "是否销警", width = 15, dicCode = "sfxj")
    @Dict(dicCode = "sfxj")
    @ApiModelProperty(value = "是否销警")
    private String isDispel;
    /**云端阈值2*/
    @Excel(name = "云端阈值2", width = 15)
    @ApiModelProperty(value = "云端阈值2")
    private BigDecimal thresholdBase2;
    /**云端阈值1*/
    @Excel(name = "云端阈值1", width = 15)
    @ApiModelProperty(value = "云端阈值1")
    private BigDecimal thresholdBase;
    /**边缘端阈值1*/
    @Excel(name = "边缘端阈值1", width = 15)
    @ApiModelProperty(value = "边缘端阈值1")
    private BigDecimal thresholdEdge;
    /**边缘端阈值2*/
    @Excel(name = "边缘端阈值2", width = 15)
    @ApiModelProperty(value = "边缘端阈值2")
    private BigDecimal thresholdEdge2;
}
