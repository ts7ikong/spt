package org.jeecg.modules.sptsjzx.scyf.gwyjczk.entity;

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
 * @Description: 应急岗位处置卡
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Data
@TableName("accept_disposal_formal")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="accept_disposal_formal对象", description="应急岗位处置卡")
public class AcceptDisposalFormal implements Serializable {
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
	/**装置唯一uuid*/
	@Excel(name = "装置唯一uuid", width = 15)
    @ApiModelProperty(value = "装置唯一uuid")
    private java.lang.String riskid;
	/**装置名称*/
	@Excel(name = "装置名称", width = 15)
    @ApiModelProperty(value = "装置名称")
    private java.lang.String riskname;
	/**单元唯一uuid*/
	@Excel(name = "单元唯一uuid", width = 15)
    @ApiModelProperty(value = "单元唯一uuid")
    private java.lang.String unitid;
	/**单元名称*/
	@Excel(name = "单元名称", width = 15)
    @ApiModelProperty(value = "单元名称")
    private java.lang.String unitname;
	/**事故类型*/
	@Excel(name = "事故类型", width = 15)
    @ApiModelProperty(value = "事故类型")
    private java.lang.String accidenttype;
	/**危险和有害因素*/
	@Excel(name = "危险和有害因素", width = 15)
    @ApiModelProperty(value = "危险和有害因素")
    private java.lang.String harmful;
	/**风险事件*/
	@Excel(name = "风险事件", width = 15)
    @ApiModelProperty(value = "风险事件")
    private java.lang.String consequence;
	/**现在主要应急物资*/
	@Excel(name = "现在主要应急物资", width = 15)
    @ApiModelProperty(value = "现在主要应急物资")
    private java.lang.String emergency;
	/**处理措施及岗位json数据*/
	@Excel(name = "处理措施及岗位json数据", width = 15)
    @ApiModelProperty(value = "处理措施及岗位json数据")
    private java.lang.String measureJson;
	/**应急处置注意事项*/
	@Excel(name = "应急处置注意事项", width = 15)
    @ApiModelProperty(value = "应急处置注意事项")
    private java.lang.String attention;
	/**推送状态*/
	@Excel(name = "推送状态", width = 15, dicCode = "tszt2")
	@Dict(dicCode = "tszt2")
    @ApiModelProperty(value = "推送状态")
    private java.lang.Integer pushState;
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
	/**顺口溜*/
	@Excel(name = "顺口溜", width = 15)
    @ApiModelProperty(value = "顺口溜")
    private java.lang.String doggerel;
}
