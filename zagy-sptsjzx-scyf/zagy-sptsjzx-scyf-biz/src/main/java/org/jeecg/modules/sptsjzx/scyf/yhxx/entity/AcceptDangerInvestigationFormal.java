package org.jeecg.modules.sptsjzx.scyf.yhxx.entity;

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
 * @Description: 隐患信息
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Data
@TableName("accept_danger_investigation_formal")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="accept_danger_investigation_formal对象", description="隐患信息")
public class AcceptDangerInvestigationFormal implements Serializable {
    private static final long serialVersionUID = 1L;

	/**唯一编码*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "唯一编码")
    private java.lang.Integer id;
	/**隐患主键uuid*/
	@Excel(name = "隐患主键uuid", width = 15)
    @ApiModelProperty(value = "隐患主键uuid")
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
	/**管控措施ID*/
	@Excel(name = "管控措施ID", width = 15)
    @ApiModelProperty(value = "管控措施ID")
    private java.lang.String riskMeasureId;
	/**隐患排查记录ID*/
	@Excel(name = "隐患排查记录ID", width = 15)
    @ApiModelProperty(value = "隐患排查记录ID")
    private java.lang.String checkRecordId;
	/**隐患名称*/
	@Excel(name = "隐患名称", width = 15)
    @ApiModelProperty(value = "隐患名称")
    private java.lang.String dangerName;
	/**隐患等级*/
	@Excel(name = "隐患等级", width = 15, dicCode = "yhdj")
	@Dict(dicCode = "yhdj")
    @ApiModelProperty(value = "隐患等级")
    private java.lang.String dangerLevel;
	/**隐患来源*/
	@Excel(name = "隐患来源", width = 15, dicCode = "yhly")
	@Dict(dicCode = "yhly")
    @ApiModelProperty(value = "隐患来源")
    private java.lang.String dangerSrc;
	/**隐患治理类型*/
	@Excel(name = "隐患治理类型", width = 15, dicCode = "yhzllx")
	@Dict(dicCode = "yhzllx")
    @ApiModelProperty(value = "隐患治理类型")
    private java.lang.String dangerManageType;
	/**隐患描述*/
	@Excel(name = "隐患描述", width = 15)
    @ApiModelProperty(value = "隐患描述")
    private java.lang.String dangerDesc;
	/**隐患产生原因*/
	@Excel(name = "隐患产生原因", width = 15)
    @ApiModelProperty(value = "隐患产生原因")
    private java.lang.String dangerReason;
	/**控制措施*/
	@Excel(name = "控制措施", width = 15)
    @ApiModelProperty(value = "控制措施")
    private java.lang.String controlMeasures;
	/**资金*/
	@Excel(name = "资金", width = 15)
    @ApiModelProperty(value = "资金")
    private java.lang.String cost;
	/**隐患治理期限*/
	@Excel(name = "隐患治理期限", width = 15)
    @ApiModelProperty(value = "隐患治理期限")
    private java.lang.String dangerManageDeadline;
	/**隐患状态*/
	@Excel(name = "隐患状态", width = 15, dicCode = "yhzt3")
	@Dict(dicCode = "yhzt3")
    @ApiModelProperty(value = "隐患状态")
    private java.lang.String dangerState;
	/**隐患类型*/
	@Excel(name = "隐患类型", width = 15, dicCode = "yhlx")
	@Dict(dicCode = "yhlx")
    @ApiModelProperty(value = "隐患类型")
    private java.lang.String hazardDangerType;
	/**隐患类别*/
	@Excel(name = "隐患类别", width = 15, dicCode = "yhlb")
	@Dict(dicCode = "yhlb")
    @ApiModelProperty(value = "隐患类别")
    private java.lang.Integer hazardCategory;
	/**登记人姓名*/
	@Excel(name = "登记人姓名", width = 15)
    @ApiModelProperty(value = "登记人姓名")
    private java.lang.String registrant;
	/**登记时间*/
	@Excel(name = "登记时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "登记时间")
    private java.util.Date registTime;
	/**整改责任人姓名*/
	@Excel(name = "整改责任人姓名", width = 15)
    @ApiModelProperty(value = "整改责任人姓名")
    private java.lang.String liablePerson;
	/**验收人*/
	@Excel(name = "验收人", width = 15)
    @ApiModelProperty(value = "验收人")
    private java.lang.String checkAcceptPerson;
	/**验收情况*/
	@Excel(name = "验收情况", width = 15)
    @ApiModelProperty(value = "验收情况")
    private java.lang.String checkAcceptComment;
	/**验收时间*/
	@Excel(name = "验收时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "验收时间")
    private java.util.Date checkAcceptTime;
	/**整改前图片*/
	@Excel(name = "整改前图片", width = 15)
    @ApiModelProperty(value = "整改前图片")
    private java.lang.String pictureBefore;
	/**整改后图片*/
	@Excel(name = "整改后图片", width = 15)
    @ApiModelProperty(value = "整改后图片")
    private java.lang.String pictureAfter;
	/**推送状态 */
	@Excel(name = "推送状态 ", width = 15, dicCode = "tszt2")
	@Dict(dicCode = "tszt2")
    @ApiModelProperty(value = "推送状态 ")
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
	/**批次id(我们返回企业的)*/
	@Excel(name = "批次id(我们返回企业的)", width = 15)
    @ApiModelProperty(value = "批次id(我们返回企业的)")
    private java.lang.String wbatchId;
	/**本地uuid*/
	@Excel(name = "本地uuid", width = 15)
    @ApiModelProperty(value = "本地uuid")
    private java.lang.String localUuid;
}
