package org.jeecg.modules.sptsjzx.tszyaqgk.tszyhdsj.entity;

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
 * @Description: 特殊作业活动（计划）数据
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Data
@TableName("accept_ticket_activity")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="accept_ticket_activity对象", description="特殊作业活动（计划）数据")
public class AcceptTicketActivity implements Serializable {
    private static final long serialVersionUID = 1L;

	/**自增主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "自增主键")
    private java.lang.Integer id;
	/**UUID*/
	@Excel(name = "UUID", width = 15)
    @ApiModelProperty(value = "UUID")
    private java.lang.String uuid;
	/**企业名称*/
	@Excel(name = "企业名称", width = 15, dictTable = "v_accept_company", dicText = "name", dicCode = "code")
	@Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @ApiModelProperty(value = "企业名称")
    private java.lang.String companyCode;
	/**作业类型*/
	@Excel(name = "作业类型", width = 15, dicCode = "zylx")
	@Dict(dicCode = "zylx")
    @ApiModelProperty(value = "作业类型")
    private java.lang.String ticketType;
	/**作业开始时间*/
	@Excel(name = "作业开始时间", width = 15, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "作业开始时间")
    private java.util.Date startTime;
	/**作业结束时间*/
	@Excel(name = "作业结束时间", width = 15, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "作业结束时间")
    private java.util.Date endTime;
	/**作业地点*/
	@Excel(name = "作业地点", width = 15)
    @ApiModelProperty(value = "作业地点")
    private java.lang.String ticketPosition;
	/**作业内容*/
	@Excel(name = "作业内容", width = 15)
    @ApiModelProperty(value = "作业内容")
    private java.lang.String jobContent;
	/**安全监护人员姓名*/
	@Excel(name = "安全监护人员姓名", width = 15)
    @ApiModelProperty(value = "安全监护人员姓名")
    private java.lang.String supervisorName;
	/**施工人员姓名*/
	@Excel(name = "施工人员姓名", width = 15)
    @ApiModelProperty(value = "施工人员姓名")
    private java.lang.String workerName;
	/**施工单位名称*/
	@Excel(name = "施工单位名称", width = 15)
    @ApiModelProperty(value = "施工单位名称")
    private java.lang.String workDepartment;
	/**施工人员编码*/
	@Excel(name = "施工人员编码", width = 15)
    @ApiModelProperty(value = "施工人员编码")
    private java.lang.String personId;
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
	/**负责人联系方式*/
	@Excel(name = "负责人联系方式", width = 15)
    @ApiModelProperty(value = "负责人联系方式")
    private java.lang.String majorPersonMobile;
	/**删除标志*/
	@Excel(name = "删除标志", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标志")
    private java.lang.String deleted;
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
	/**应急部返回batch编码*/
	@Excel(name = "应急部返回batch编码", width = 15)
    @ApiModelProperty(value = "应急部返回batch编码")
    private java.lang.String batchId;
	/**我们返回企业batch编号*/
	@Excel(name = "我们返回企业batch编号", width = 15)
    @ApiModelProperty(value = "我们返回企业batch编号")
    private java.lang.String wbatchId;
	/**创建时间*/
    @ApiModelProperty(value = "创建时间")
    private java.lang.String createTime;
}
