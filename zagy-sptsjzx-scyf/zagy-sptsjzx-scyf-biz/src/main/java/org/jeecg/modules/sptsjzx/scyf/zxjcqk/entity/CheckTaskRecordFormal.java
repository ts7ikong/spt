package org.jeecg.modules.sptsjzx.scyf.zxjcqk.entity;

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
 * @Description: 专项检查情况
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Data
@TableName("check_task_record_formal")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="check_task_record_formal对象", description="专项检查情况")
public class CheckTaskRecordFormal implements Serializable {
    private static final long serialVersionUID = 1L;

	/**序号*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "序号")
    private java.lang.Integer id;
	/**公司上传uuid*/
	@Excel(name = "公司上传uuid", width = 15)
    @ApiModelProperty(value = "公司上传uuid")
    private java.lang.String uuid;
	/**企业名称*/
	@Excel(name = "企业名称", width = 15, dictTable = "v_accept_company", dicText = "name", dicCode = "code")
	@Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @ApiModelProperty(value = "企业名称")
    private java.lang.String companyCode;
	/**风险分析对象*/
	@Excel(name = "风险分析对象", width = 15, dictTable = "v_accept_hazard_code", dicText = "hazard_name", dicCode = "hazard_code")
	@Dict(dictTable = "v_accept_hazard_code", dicText = "hazard_name", dicCode = "hazard_code")
    @ApiModelProperty(value = "风险分析对象")
    private java.lang.String hazardCode;
	/**任务编号*/
	@Excel(name = "任务编号", width = 15)
    @ApiModelProperty(value = "任务编号")
    private java.lang.String taskId;
	/**检查类型*/
	@Excel(name = "检查类型", width = 15, dicCode = "jclx")
	@Dict(dicCode = "jclx")
    @ApiModelProperty(value = "检查类型")
    private java.lang.String checkType;
	/**检查日期*/
	@Excel(name = "检查日期", width = 15)
    @ApiModelProperty(value = "检查日期")
    private java.lang.String checkDate;
	/**是否停产整顿*/
	@Excel(name = "是否停产整顿", width = 15, dicCode = "sftczd")
	@Dict(dicCode = "sftczd")
    @ApiModelProperty(value = "是否停产整顿")
    private java.lang.String resultStatus;
	/**任务来源*/
	@Excel(name = "任务来源", width = 15, dicCode = "rwly")
	@Dict(dicCode = "rwly")
    @ApiModelProperty(value = "任务来源")
    private java.lang.Integer taskSource;
	/**推送状态*/
	@Excel(name = "推送状态", width = 15, dicCode = "tszt2")
	@Dict(dicCode = "tszt2")
    @ApiModelProperty(value = "推送状态")
    private java.lang.Integer pushState;
	/**推送次数*/
	@Excel(name = "推送次数", width = 15)
    @ApiModelProperty(value = "推送次数")
    private java.lang.Integer pushNum;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建时间*/
	@Excel(name = "创建时间", width = 15)
    @ApiModelProperty(value = "创建时间")
    private java.lang.String createDate;
	/**最后修改人*/
    @ApiModelProperty(value = "最后修改人")
    private java.lang.String updateBy;
	/**最后修改时间*/
	@Excel(name = "最后修改时间", width = 15)
    @ApiModelProperty(value = "最后修改时间")
    private java.lang.String updateDate;
	/**本地uuid*/
	@Excel(name = "本地uuid", width = 15)
    @ApiModelProperty(value = "本地uuid")
    private java.lang.String localUuid;
	/**批次id(我们返回企业的)*/
	@Excel(name = "批次id(我们返回企业的)", width = 15)
    @ApiModelProperty(value = "批次id(我们返回企业的)")
    private java.lang.String wbatchId;
	/**应急部返回的批次id*/
	@Excel(name = "应急部返回的批次id", width = 15)
    @ApiModelProperty(value = "应急部返回的批次id")
    private java.lang.String batchId;
	/**数据创建时间*/
    @ApiModelProperty(value = "数据创建时间")
    private java.lang.String createTime;
}
