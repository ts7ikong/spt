package org.jeecg.modules.sptsjzx.scyf.yhpcjl.entity;

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
 * @Description: 隐患排查记录
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Data
@TableName("accept_measures_task_record_formal")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="accept_measures_task_record_formal对象", description="隐患排查记录")
public class AcceptMeasuresTaskRecordFormal implements Serializable {
    private static final long serialVersionUID = 1L;

	/**唯一编码id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "唯一编码id")
    private java.lang.Integer id;
	/**企业名称*/
	@Excel(name = "企业名称", width = 15, dictTable = "v_accept_company", dicText = "name", dicCode = "code")
	@Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @ApiModelProperty(value = "企业名称")
    private java.lang.String companyCode;
	/**隐患排查任务ID*/
	@Excel(name = "隐患排查任务ID", width = 15)
    @ApiModelProperty(value = "隐患排查任务ID")
    private java.lang.String checkTaskId;
	/**排查时间*/
	@Excel(name = "排查时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "排查时间")
    private java.util.Date checkTime;
	/**IMEI 码*/
	@Excel(name = "IMEI 码", width = 15)
    @ApiModelProperty(value = "IMEI 码")
    private java.lang.String mobileMe;
	/**是否包保责任人任务*/
	@Excel(name = "是否包保责任人任务", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否包保责任人任务")
    private java.lang.Integer isDefend;
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
	/**创建人姓名*/
    @ApiModelProperty(value = "创建人姓名")
    private java.lang.String createBy;
	/**创建人手机号*/
	@Excel(name = "创建人手机号", width = 15)
    @ApiModelProperty(value = "创建人手机号")
    private java.lang.String createByMobile;
	/**第三方企业的uuid*/
	@Excel(name = "第三方企业的uuid", width = 15)
    @ApiModelProperty(value = "第三方企业的uuid")
    private java.lang.String uuid;
	/**应急部返回的批次id*/
	@Excel(name = "应急部返回的批次id", width = 15)
    @ApiModelProperty(value = "应急部返回的批次id")
    private java.lang.String batchId;
	/**批次id(我们返回企业的)*/
	@Excel(name = "批次id(我们返回企业的)", width = 15)
    @ApiModelProperty(value = "批次id(我们返回企业的)")
    private java.lang.String wbatchId;
	/**本地uuid*/
	@Excel(name = "本地uuid", width = 15)
    @ApiModelProperty(value = "本地uuid")
    private java.lang.String localUuid;
}
