package org.jeecg.modules.sptsjzx.scyf.aqfxdy.entity;

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
 * @Description: 安全风险单元
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Data
@TableName("accept_unit_formal")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="accept_unit_formal对象", description="安全风险单元")
public class AcceptUnitFormal implements Serializable {
    private static final long serialVersionUID = 1L;

	/**唯一编码*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "唯一编码")
    private java.lang.Integer id;
	/**第三方企业的uuid*/
	@Excel(name = "第三方企业的uuid", width = 15)
    @ApiModelProperty(value = "第三方企业的uuid")
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
	/**风险分析单元名称*/
	@Excel(name = "风险分析单元名称", width = 15)
    @ApiModelProperty(value = "风险分析单元名称")
    private java.lang.String riskUnitName;
	/**责任部门*/
	@Excel(name = "责任部门", width = 15)
    @ApiModelProperty(value = "责任部门")
    private java.lang.String hazardDep;
	/**责任部门负责人姓名*/
	@Excel(name = "责任部门负责人姓名", width = 15)
    @ApiModelProperty(value = "责任部门负责人姓名")
    private java.lang.String hazardLiablePerson;
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
	/**是否检维修*/
	@Excel(name = "是否检维修", width = 15, dicCode = "sfjwx")
	@Dict(dicCode = "sfjwx")
    @ApiModelProperty(value = "是否检维修")
    private java.lang.Integer isVverhaul;
	/**经度*/
	@Excel(name = "经度", width = 15)
    @ApiModelProperty(value = "经度")
    private java.lang.String longitude;
	/**纬度*/
	@Excel(name = "纬度", width = 15)
    @ApiModelProperty(value = "纬度")
    private java.lang.String latitude;
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
	/**批次id(我们返回企业的)*/
	@Excel(name = "批次id(我们返回企业的)", width = 15)
    @ApiModelProperty(value = "批次id(我们返回企业的)")
    private java.lang.String wbatchId;
	/**应急部返回的批次id*/
	@Excel(name = "应急部返回的批次id", width = 15)
    @ApiModelProperty(value = "应急部返回的批次id")
    private java.lang.String batchId;
	/**本地uuid*/
	@Excel(name = "本地uuid", width = 15)
    @ApiModelProperty(value = "本地uuid")
    private java.lang.String localUuid;
}
