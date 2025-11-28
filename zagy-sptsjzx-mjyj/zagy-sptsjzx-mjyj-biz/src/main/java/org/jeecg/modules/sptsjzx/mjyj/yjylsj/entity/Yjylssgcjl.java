package org.jeecg.modules.sptsjzx.mjyj.yjylsj.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import org.jeecg.common.constant.ProvinceCityArea;
import org.jeecg.common.util.SpringContextUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
 * @Description: 应急演练实施过程记录
 * @Author: zagy-cg
 * @Date:   2025-03-03
 * @Version: V1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@TableName("yjylssgcjl")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="yjylssgcjl对象", description="应急演练实施过程记录")
public class Yjylssgcjl implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private Date updateTime;
	/**UUID*/
	@Excel(name = "UUID", width = 15)
    @ApiModelProperty(value = "UUID")
    private String uuid;
	/**园区编码*/
	@Excel(name = "园区编码", width = 15, dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
	@Dict(dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @ApiModelProperty(value = "园区编码")
    private String parkCode;
	/**记录编码*/
	@Excel(name = "记录编码", width = 15)
    @ApiModelProperty(value = "记录编码")
    private String recordId;
	/**演练名称*/
	@Excel(name = "演练名称", width = 15)
    @ApiModelProperty(value = "演练名称")
    private String emergenceDrillName;
	/**演练类型*/
	@Excel(name = "演练类型", width = 15, dicCode = "yjyllx")
	@Dict(dicCode = "yjyllx")
    @ApiModelProperty(value = "演练类型")
    private String drillType;
	/**关联计划编码*/
	@Excel(name = "关联计划编码", width = 15)
    @ApiModelProperty(value = "关联计划编码")
    private String planId;
	/**演练开始时间*/
	@Excel(name = "演练开始时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "演练开始时间")
    private Date drillStart;
	/**演练结束时间*/
	@Excel(name = "演练结束时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "演练结束时间")
    private Date drillEnd;
	/**参与人数*/
	@Excel(name = "参与人数", width = 15)
    @ApiModelProperty(value = "参与人数")
    private Integer particNum;
	/**演练过程*/
	@Excel(name = "演练过程", width = 15)
    @ApiModelProperty(value = "演练过程")
    private String drillProcess;
	/**演练效果评估*/
	@Excel(name = "演练效果评估", width = 15)
    @ApiModelProperty(value = "演练效果评估")
    private String drillEstimate;
	/**存在问题*/
	@Excel(name = "存在问题", width = 15)
    @ApiModelProperty(value = "存在问题")
    private String problem;
	/**改进措施*/
	@Excel(name = "改进措施", width = 15)
    @ApiModelProperty(value = "改进措施")
    private String improveMeansure;
	/**演练方案*/
	@Excel(name = "演练方案", width = 15)
    @ApiModelProperty(value = "演练方案")
    private String drillPlan;
	/**演练评估报告*/
	@Excel(name = "演练评估报告", width = 15)
    @ApiModelProperty(value = "演练评估报告")
    private String drillAssementReport;
	/**演练脚本*/
	@Excel(name = "演练脚本", width = 15)
    @ApiModelProperty(value = "演练脚本")
    private String drillScript;
	/**删除标志*/
	@Excel(name = "删除标志", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标志")
    private String deleted;
}
