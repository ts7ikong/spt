package org.jeecg.modules.sptsjzx.scyf.yhpcrw.entity;

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
 * @Description: 隐患排查任务
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Data
@TableName("accept_measures_task_formal")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="accept_measures_task_formal对象", description="隐患排查任务")
public class AcceptMeasuresTaskFormal implements Serializable {
    private static final long serialVersionUID = 1L;

	/**唯一编码*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "唯一编码")
    private java.lang.Integer id;
	/**企业名称*/
	@Excel(name = "企业名称", width = 15, dictTable = "v_accept_company", dicText = "name", dicCode = "code")
	@Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @ApiModelProperty(value = "企业名称")
    private java.lang.String companyCode;
	/**任务类型*/
	@Excel(name = "任务类型", width = 15, dicCode = "yhrwlx")
	@Dict(dicCode = "yhrwlx")
    @ApiModelProperty(value = "任务类型")
    private java.lang.String workType;
	/**管控措施 ID*/
	@Excel(name = "管控措施 ID", width = 15)
    @ApiModelProperty(value = "管控措施 ID")
    private java.lang.String riskMeasureId;
	/**所属日周月清单id*/
	@Excel(name = "所属日周月清单id", width = 15)
    @ApiModelProperty(value = "所属日周月清单id")
    private java.lang.String qdId;
	/**隐患排查内容*/
	@Excel(name = "隐患排查内容", width = 15)
    @ApiModelProperty(value = "隐患排查内容")
    private java.lang.String troubleshootContent;
	/**巡检周期*/
	@Excel(name = "巡检周期", width = 15)
    @ApiModelProperty(value = "巡检周期")
    private java.lang.Integer checkCycle;
	/**巡检周期单位*/
	@Excel(name = "巡检周期单位", width = 15)
    @ApiModelProperty(value = "巡检周期单位")
    private java.lang.String checkCycleUnit;
	/**任务开始时间*/
	@Excel(name = "任务开始时间", width = 15)
    @ApiModelProperty(value = "任务开始时间")
    private java.lang.String taskStartTime;
	/**工作开始时间*/
	@Excel(name = "工作开始时间", width = 15)
    @ApiModelProperty(value = "工作开始时间")
    private java.lang.String workStartTime;
	/**工作结束时间*/
	@Excel(name = "工作结束时间", width = 15)
    @ApiModelProperty(value = "工作结束时间")
    private java.lang.String workEndTime;
	/**工作日类型*/
	@Excel(name = "工作日类型", width = 15)
    @ApiModelProperty(value = "工作日类型")
    private java.lang.String workDayType;
	/**包保任务对应项*/
	@Excel(name = "包保任务对应项", width = 15)
    @ApiModelProperty(value = "包保任务对应项")
    private java.lang.String taskNum;
	/**推送状态*/
	@Excel(name = "推送状态", width = 15, dicCode = "tszt2")
	@Dict(dicCode = "tszt2")
    @ApiModelProperty(value = "推送状态")
    private java.lang.Integer pushState;
	/**推送次数*/
	@Excel(name = "推送次数", width = 15)
    @ApiModelProperty(value = "推送次数")
    private java.lang.Integer pushNum;
	/**是否激活*/
	@Excel(name = "是否激活", width = 15, dicCode = "sfjh")
	@Dict(dicCode = "sfjh")
    @ApiModelProperty(value = "是否激活")
    private java.lang.Integer isActivation;
	/**是否排查*/
	@Excel(name = "是否排查", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否排查")
    private java.lang.Integer isCheck;
	/**数据是否齐全*/
	@Excel(name = "数据是否齐全", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "数据是否齐全")
    private java.lang.Integer isCompleted;
	/**删除状态*/
	@Excel(name = "删除状态", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除状态")
    private java.lang.Integer deleted;
	/**创建人姓名*/
    @ApiModelProperty(value = "创建人姓名")
    private java.lang.String createBy;
	/**创建时间*/
	@Excel(name = "创建时间", width = 15)
    @ApiModelProperty(value = "创建时间")
    private java.lang.String createDate;
	/**修改人姓名*/
    @ApiModelProperty(value = "修改人姓名")
    private java.lang.String updateBy;
	/**修改时间*/
	@Excel(name = "修改时间", width = 15)
    @ApiModelProperty(value = "修改时间")
    private java.lang.String updateDate;
	/**第三方企业的uuid*/
	@Excel(name = "第三方企业的uuid", width = 15)
    @ApiModelProperty(value = "第三方企业的uuid")
    private java.lang.String uuid;
	/**应急部返回的批次id*/
	@Excel(name = "应急部返回的批次id", width = 15)
    @ApiModelProperty(value = "应急部返回的批次id")
    private java.lang.String batchId;
	/**本地uuid*/
	@Excel(name = "本地uuid", width = 15)
    @ApiModelProperty(value = "本地uuid")
    private java.lang.String localUuid;
	/**批次id(我们返回企业的)*/
	@Excel(name = "批次id(我们返回企业的)", width = 15)
    @ApiModelProperty(value = "批次id(我们返回企业的)")
    private java.lang.String wbatchId;
}
