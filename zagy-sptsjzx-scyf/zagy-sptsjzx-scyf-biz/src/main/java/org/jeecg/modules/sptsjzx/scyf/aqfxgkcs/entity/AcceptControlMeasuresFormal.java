package org.jeecg.modules.sptsjzx.scyf.aqfxgkcs.entity;

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
 * @Description: 安全风险管控措施
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Data
@TableName("accept_control_measures_formal")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="accept_control_measures_formal对象", description="安全风险管控措施")
public class AcceptControlMeasuresFormal implements Serializable {
    private static final long serialVersionUID = 1L;

	/**唯一编码*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "唯一编码")
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
	/**风险事件
ID*/
	@Excel(name = "风险事件 ID", width = 15)
    @ApiModelProperty(value = "风险事件 ID")
    private java.lang.String riskEventId;
	/**管控方式*/
	@Excel(name = "管控方式", width = 15, dicCode = "gkfs")
	@Dict(dicCode = "gkfs")
    @ApiModelProperty(value = "管控方式")
    private java.lang.String dataSrc;
	/**管控措施描述*/
	@Excel(name = "管控措施描述", width = 15)
    @ApiModelProperty(value = "管控措施描述")
    private java.lang.String riskMeasureDesc;
	/**隐患排查内容*/
	@Excel(name = "隐患排查内容", width = 15)
    @ApiModelProperty(value = "隐患排查内容")
    private java.lang.String troubleshootContent;
	/**管控措施分类1*/
	@Excel(name = "管控措施分类1", width = 15, dicCode = "gkcsfl1")
	@Dict(dicCode = "gkcsfl1")
    @ApiModelProperty(value = "管控措施分类1")
    private java.lang.String classify1;
	/**管控措施分类2*/
	@Excel(name = "管控措施分类2", width = 15, dicCode = "gkcsfl2")
	@Dict(dicCode = "gkcsfl2")
    @ApiModelProperty(value = "管控措施分类2")
    private java.lang.String classify2;
	/**管控措施分类3*/
	@Excel(name = "管控措施分类3", width = 15)
    @ApiModelProperty(value = "管控措施分类3")
    private java.lang.String classify3;
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
