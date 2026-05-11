package org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.zbjcsssj.entity;

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
 * @Description: 指标监测实时数据
 * @Author: zagy-cg
 * @Date:   2026-04-22
 * @Version: V1.0
 */
@Data
@TableName("v_hrmw_target_current_with_company")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="tb_hrmw_moni_target_current对象", description="指标监测实时数据")
public class TbHrmwMoniTargetCurrent implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;

	/**企业编码*/
	@ApiModelProperty(value = "企业编码")
	@Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
	private String companyCode;

	/**区县Code*/
	@TableField(exist = false)
	@ApiModelProperty(value = "区县Code")
	@Dict(dictTable = "v_company_county", dicText = "county_name", dicCode = "code")
	private java.lang.String countyCode;

	/**指标编码*/
	@Excel(name = "指标编码", width = 15)
    @ApiModelProperty(value = "指标编码")
	@Dict(dictTable = "v_hrmw_target_with_company", dicText = "target_name", dicCode = "target_code", source = "pg")
    private java.lang.String targetCode;
	/**是否在线*/
	@Excel(name = "是否在线", width = 15, dicCode = "zbsfzx")
	@Dict(dicCode = "zbsfzx")
    @ApiModelProperty(value = "是否在线")
    private java.lang.String online;
	/**指标最新采集值*/
	@Excel(name = "指标最新采集值", width = 15)
    @ApiModelProperty(value = "指标最新采集值")
    private java.math.BigDecimal lastValue;
	/**指标最新采集时间*/
	@Excel(name = "指标最新采集时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "指标最新采集时间")
    private java.util.Date lastCollectTime;
	/**指标最新值更新时间*/
	@Excel(name = "指标最新值更新时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "指标最新值更新时间")
    private java.util.Date lastValueUpdateTime;
	/**指标当前状态*/
	@Excel(name = "指标当前状态", width = 15, dicCode = "zbdqzt")
	@Dict(dicCode = "zbdqzt")
    @ApiModelProperty(value = "指标当前状态")
    private java.lang.String targetStatus;
	/**最近报警销警值*/
	@Excel(name = "最近报警销警值", width = 15)
    @ApiModelProperty(value = "最近报警销警值")
    private java.math.BigDecimal lastAlarmValue;
	/**最近报警状态*/
	@Excel(name = "最近报警状态", width = 15)
    @ApiModelProperty(value = "最近报警状态")
    private java.lang.String lastAlarmStatus;
	/**最近报销警时间*/
	@Excel(name = "最近报销警时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最近报销警时间")
    private java.util.Date lastAlarmTime;
	/**最近一次报警记录id*/
	@Excel(name = "最近一次报警记录id", width = 15)
    @ApiModelProperty(value = "最近一次报警记录id")
    private java.lang.String lastAlarmId;
	/**指标当前状态更新时间*/
	@Excel(name = "指标当前状态更新时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "指标当前状态更新时间")
    private java.util.Date targetStatusUpdateTime;
	/**指标数据质量状态（是否超量程）*/
	@Excel(name = "指标数据质量状态（是否超量程）", width = 15)
    @ApiModelProperty(value = "指标数据质量状态（是否超量程）")
    private java.lang.String valueQualityStatus;
	/**最近报警起始时间*/
	@Excel(name = "最近报警起始时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最近报警起始时间")
    private java.util.Date lastAlarmStarted;
	/**最近报销警更新时间*/
	@Excel(name = "最近报销警更新时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最近报销警更新时间")
    private java.util.Date lastAlarmUpdateTime;
	/**数据源编码*/
	@Excel(name = "数据源编码", width = 15)
    @ApiModelProperty(value = "数据源编码")
    private java.lang.String dataSourceCode;
	/**是否漏报*/
	@Excel(name = "是否漏报", width = 15, dicCode = "sflb")
	@Dict(dicCode = "sflb")
    @ApiModelProperty(value = "是否漏报")
    private java.lang.String isUnderreporting;
	/**应触发报警状态*/
	@Excel(name = "应触发报警状态", width = 15)
    @ApiModelProperty(value = "应触发报警状态")
    private java.lang.String shouldAlarmStatus;
	/**漏报判定时的指标实时值*/
	@Excel(name = "漏报判定时的指标实时值", width = 15)
    @ApiModelProperty(value = "漏报判定时的指标实时值")
    private java.math.BigDecimal underreportingValue;
	/**漏报判定时的指标阈值*/
	@Excel(name = "漏报判定时的指标阈值", width = 15)
    @ApiModelProperty(value = "漏报判定时的指标阈值")
    private java.math.BigDecimal underreportingBaseValue;
	/**漏报开始时间*/
	@Excel(name = "漏报开始时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "漏报开始时间")
    private java.util.Date underreportingStartTime;
	/**漏报结束时间*/
	@Excel(name = "漏报结束时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "漏报结束时间")
    private java.util.Date underreportingEndTime;
}
