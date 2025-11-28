package org.jeecg.modules.sptsjzx.tszyaqgk.tszysj.entity;

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
 * @Description: 特殊作业数据
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Data
@TableName("accept_ticket_formal")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="accept_ticket_formal对象", description="特殊作业数据")
public class AcceptTicketFormal implements Serializable {
    private static final long serialVersionUID = 1L;

	/**序号*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "序号")
    private java.lang.Integer id;
	/**企业编码*/
	@Excel(name = "企业编码", width = 15, dictTable = "v_accept_company", dicText = "name", dicCode = "code")
	@Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @ApiModelProperty(value = "企业编码")
    private java.lang.String companyCode;
	/**作业类型*/
	@Excel(name = "作业类型", width = 15, dicCode = "zylx")
	@Dict(dicCode = "zylx")
    @ApiModelProperty(value = "作业类型")
    private java.lang.String ticketType;
	/**作业开始时间*/
	@Excel(name = "作业开始时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "作业开始时间")
    private java.util.Date startTime;
	/**作业结束时间*/
	@Excel(name = "作业结束时间", width = 15)
    @ApiModelProperty(value = "作业结束时间")
    private java.lang.String endTime;
	/**作业地点*/
	@Excel(name = "作业地点", width = 15)
    @ApiModelProperty(value = "作业地点")
    private java.lang.String ticketPosition;
	/**作业内容*/
	@Excel(name = "作业内容", width = 15)
    @ApiModelProperty(value = "作业内容")
    private java.lang.String ticketContent;
	/**经度*/
	@Excel(name = "经度", width = 15)
    @ApiModelProperty(value = "经度")
    private java.lang.String longitude;
	/**纬度*/
	@Excel(name = "纬度", width = 15)
    @ApiModelProperty(value = "纬度")
    private java.lang.String latitude;
	/**作业状态*/
	@Excel(name = "作业状态", width = 15, dicCode = "zyzt")
	@Dict(dicCode = "zyzt")
    @ApiModelProperty(value = "作业状态")
    private java.lang.String ticketStatus;
	/**安全监管人员姓名*/
	@Excel(name = "安全监管人员姓名", width = 15)
    @ApiModelProperty(value = "安全监管人员姓名")
    private java.lang.String supervisorName;
	/**施工人员姓名*/
	@Excel(name = "施工人员姓名", width = 15)
    @ApiModelProperty(value = "施工人员姓名")
    private java.lang.String workerName;
	/**施工人员id*/
	@Excel(name = "施工人员id", width = 15)
    @ApiModelProperty(value = "施工人员id")
    private java.lang.String personId;
	/**施工单位名称*/
	@Excel(name = "施工单位名称", width = 15)
    @ApiModelProperty(value = "施工单位名称")
    private java.lang.String workDepartment;
	/**施工单位统一社会信用代码*/
	@Excel(name = "施工单位统一社会信用代码", width = 15)
    @ApiModelProperty(value = "施工单位统一社会信用代码")
    private java.lang.String socialCreditCode;
	/**是否承包商作业*/
	@Excel(name = "是否承包商作业", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否承包商作业")
    private java.lang.String isContractorWork;
	/**作业负责人*/
	@Excel(name = "作业负责人", width = 15)
    @ApiModelProperty(value = "作业负责人")
    private java.lang.String ticketResponsName;
	/**负责人联系方式手机号*/
	@Excel(name = "负责人联系方式手机号", width = 15)
    @ApiModelProperty(value = "负责人联系方式手机号")
    private java.lang.String majorPersonMobile;
	/**作业是否变更过*/
	@Excel(name = "作业是否变更过", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "作业是否变更过")
    private java.lang.String isChanged;
	/**作业变更原因*/
	@Excel(name = "作业变更原因", width = 15)
    @ApiModelProperty(value = "作业变更原因")
    private java.lang.String changedCause;
	/**作业是否取消*/
	@Excel(name = "作业是否取消", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "作业是否取消")
    private java.lang.String isCancelled;
	/**作业作废原因*/
	@Excel(name = "作业作废原因", width = 15)
    @ApiModelProperty(value = "作业作废原因")
    private java.lang.String cancelledCause;
	/**作业票唯一编码*/
	@Excel(name = "作业票唯一编码", width = 15)
    @ApiModelProperty(value = "作业票唯一编码")
    private java.lang.String ticketNum;
	/**票证地址*/
	@Excel(name = "票证地址", width = 15)
    @ApiModelProperty(value = "票证地址")
    private java.lang.String ticketPic;
	/**签发时间*/
	@Excel(name = "签发时间", width = 15)
    @ApiModelProperty(value = "签发时间")
    private java.lang.String issueTime;
	/**验收时间*/
	@Excel(name = "验收时间", width = 15)
    @ApiModelProperty(value = "验收时间")
    private java.lang.String chechedTime;
	/**验收时间*/
	@Excel(name = "验收时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "验收时间")
    private java.util.Date acceptanceTime;
	/**活动id*/
	@Excel(name = "活动id", width = 15)
    @ApiModelProperty(value = "活动id")
    private java.lang.String jobId;
	/**推送状态*/
	@Excel(name = "推送状态", width = 15, dicCode = "tszt2")
	@Dict(dicCode = "tszt2")
    @ApiModelProperty(value = "推送状态")
    private java.lang.Integer pushState;
	/**推送次数*/
	@Excel(name = "推送次数", width = 15)
    @ApiModelProperty(value = "推送次数")
    private java.lang.Integer pushNum;
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
	/**第三方企业数据的uuid*/
	@Excel(name = "第三方企业数据的uuid", width = 15)
    @ApiModelProperty(value = "第三方企业数据的uuid")
    private java.lang.String uuid;
	/**应急部返回batch编码*/
	@Excel(name = "应急部返回batch编码", width = 15)
    @ApiModelProperty(value = "应急部返回batch编码")
    private java.lang.String batchId;
	/**本地uuid*/
	@Excel(name = "本地uuid", width = 15)
    @ApiModelProperty(value = "本地uuid")
    private java.lang.String localUuid;
	/**我们返回企业batch编号*/
	@Excel(name = "我们返回企业batch编号", width = 15)
    @ApiModelProperty(value = "我们返回企业batch编号")
    private java.lang.String wbatchId;
	/**进表时间*/
    @ApiModelProperty(value = "进表时间")
    private java.lang.String createTime;
}
