package org.jeecg.modules.sptsjzx.zdwxyaqgl.yjtssj.yjsjsj.entity;

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
 * @Description: 预警事件数据
 * @Author: zagy-cg
 * @Date: 2026-04-22
 * @Version: V1.0
 */
@Data
@TableName("tb_hrmw_rws_risk_warning")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "tb_hrmw_rws_risk_warning对象", description = "预警事件数据")
public class TbHrmwRwsRiskWarning implements Serializable {
    private static final long serialVersionUID = 1L;

    /**id*/
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private String id;
    /**预警趋势*/
    @Excel(name = "预警趋势", width = 15)
    @ApiModelProperty(value = "预警趋势")
    private String riskType;
    /**当前的风险等级，新的动态风险值*/
    @Excel(name = "当前的风险等级，新的动态风险值", width = 15)
    @ApiModelProperty(value = "当前的风险等级，新的动态风险值")
    private String rank;
    /**旧的动态风险值*/
    @Excel(name = "旧的动态风险值", width = 15)
    @ApiModelProperty(value = "旧的动态风险值")
    private String lastRank;
    /**若有对应的应急事故，则其应急事故id*/
    @Excel(name = "若有对应的应急事故，则其应急事故id", width = 15)
    @ApiModelProperty(value = "若有对应的应急事故，则其应急事故id")
    private String crashId;
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
    /**风险等级risk或预警等级 warn*/
    @Excel(name = "风险等级risk或预警等级 warn", width = 15)
    @ApiModelProperty(value = "风险等级risk或预警等级 warn")
    private String type;
    /**第一次风险等级变更id*/
    @Excel(name = "第一次风险等级变更id", width = 15)
    @ApiModelProperty(value = "第一次风险等级变更id")
    private String firstChangeRankRiskId;
    /**当前风险结束时间*/
    @Excel(name = "当前风险结束时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "当前风险结束时间")
    private Date endTime;
    /**企业风险值*/
    @Excel(name = "企业风险值", width = 15)
    @ApiModelProperty(value = "企业风险值")
    private BigDecimal riskValue;
    /**重复报警点位数*/
    @Excel(name = "重复报警点位数", width = 15)
    @ApiModelProperty(value = "重复报警点位数")
    private BigDecimal duplicateAlarmTarget;
    /**平均报警次数*/
    @Excel(name = "平均报警次数", width = 15)
    @ApiModelProperty(value = "平均报警次数")
    private BigDecimal avgAlarm;
    /**平均消警时长*/
    @Excel(name = "平均消警时长", width = 15)
    @ApiModelProperty(value = "平均消警时长")
    private BigDecimal avgDispelTime;
    /**最长报警时间*/
    @Excel(name = "最长报警时间", width = 15)
    @ApiModelProperty(value = "最长报警时间")
    private BigDecimal maxAlarmTime;
    /**重复报警次数*/
    @Excel(name = "重复报警次数", width = 15)
    @ApiModelProperty(value = "重复报警次数")
    private BigDecimal duplicateAlarmCount;
    /**扰动率得分*/
    @Excel(name = "扰动率得分", width = 15)
    @ApiModelProperty(value = "扰动率得分")
    private BigDecimal disturbanceRateScore;
    /**重复报警次数得分*/
    @Excel(name = "重复报警次数得分", width = 15)
    @ApiModelProperty(value = "重复报警次数得分")
    private BigDecimal duplicateAlarmScore;
    /**平均报警次数得分*/
    @Excel(name = "平均报警次数得分", width = 15)
    @ApiModelProperty(value = "平均报警次数得分")
    private BigDecimal avgAlarmScore;
    /**平均消警时长得分*/
    @Excel(name = "平均消警时长得分", width = 15)
    @ApiModelProperty(value = "平均消警时长得分")
    private BigDecimal avgDispelTimeScore;
    /**最长报警时间得分*/
    @Excel(name = "最长报警时间得分", width = 15)
    @ApiModelProperty(value = "最长报警时间得分")
    private BigDecimal maxAlarmTimeScore;
    /**动态风险经函数计算后的值*/
    @Excel(name = "动态风险经函数计算后的值", width = 15)
    @ApiModelProperty(value = "动态风险经函数计算后的值")
    private BigDecimal riskValueF;
    /**动态风险详情json*/
    @Excel(name = "动态风险详情json", width = 15)
    @ApiModelProperty(value = "动态风险详情json")
    private String riskData;
}
