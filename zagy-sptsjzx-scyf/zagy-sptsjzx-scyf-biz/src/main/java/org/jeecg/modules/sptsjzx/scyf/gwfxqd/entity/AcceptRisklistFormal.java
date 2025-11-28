package org.jeecg.modules.sptsjzx.scyf.gwfxqd.entity;

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
 * @Description: 岗位风险清单
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Data
@TableName("accept_risklist_formal")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="accept_risklist_formal对象", description="岗位风险清单")
public class AcceptRisklistFormal implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键id")
    private java.lang.Integer id;
	/**企业名称*/
	@Excel(name = "企业名称", width = 15, dictTable = "v_accept_company", dicText = "name", dicCode = "code")
	@Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @ApiModelProperty(value = "企业名称")
    private java.lang.String companyCode;
	/**风险点名称*/
	@Excel(name = "风险点名称", width = 15)
    @ApiModelProperty(value = "风险点名称")
    private java.lang.String risklistName;
	/**风险等级*/
	@Excel(name = "风险等级", width = 15, dicCode = "fxdj")
	@Dict(dicCode = "fxdj")
    @ApiModelProperty(value = "风险等级")
    private java.lang.Integer risklistLevel;
	/**风险标志完整图片地址*/
	@Excel(name = "风险标志完整图片地址", width = 15)
    @ApiModelProperty(value = "风险标志完整图片地址")
    private java.lang.String risklistSafetymark;
	/**防控级别*/
	@Excel(name = "防控级别", width = 15, dicCode = "fkjb")
	@Dict(dicCode = "fkjb")
    @ApiModelProperty(value = "防控级别")
    private java.lang.Integer risklistPreventionlevel;
	/**岗位唯一uuid*/
	@Excel(name = "岗位唯一uuid", width = 15)
    @ApiModelProperty(value = "岗位唯一uuid")
    private java.lang.String positonid;
	/**岗位名称*/
	@Excel(name = "岗位名称", width = 15)
    @ApiModelProperty(value = "岗位名称")
    private java.lang.String positon;
	/**责任部门*/
	@Excel(name = "责任部门", width = 15)
    @ApiModelProperty(value = "责任部门")
    private java.lang.String hazardDep;
	/**责任部门负责人姓名*/
	@Excel(name = "责任部门负责人姓名", width = 15)
    @ApiModelProperty(value = "责任部门负责人姓名")
    private java.lang.String hazardLiablePerson;
	/**危险和有害因素*/
	@Excel(name = "危险和有害因素", width = 15)
    @ApiModelProperty(value = "危险和有害因素")
    private java.lang.String risklistHarmful;
	/**风险事件*/
	@Excel(name = "风险事件", width = 15)
    @ApiModelProperty(value = "风险事件")
    private java.lang.String risklistConsequence;
	/**管控措施*/
	@Excel(name = "管控措施", width = 15)
    @ApiModelProperty(value = "管控措施")
    private java.lang.String risklistMeasure;
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
	/**岗位风险主键uuid*/
	@Excel(name = "岗位风险主键uuid", width = 15)
    @ApiModelProperty(value = "岗位风险主键uuid")
    private java.lang.String uuid;
	/**返回批次id(应急部返回的)*/
	@Excel(name = "返回批次id(应急部返回的)", width = 15)
    @ApiModelProperty(value = "返回批次id(应急部返回的)")
    private java.lang.String batchId;
	/**本地uuid*/
	@Excel(name = "本地uuid", width = 15)
    @ApiModelProperty(value = "本地uuid")
    private java.lang.String localUuid;
	/**批次id(我们返回企业的)*/
	@Excel(name = "批次id(我们返回企业的)", width = 15)
    @ApiModelProperty(value = "批次id(我们返回企业的)")
    private java.lang.String wbatchId;
	/**顺口溜*/
	@Excel(name = "顺口溜", width = 15)
    @ApiModelProperty(value = "顺口溜")
    private java.lang.String doggerel;
}
