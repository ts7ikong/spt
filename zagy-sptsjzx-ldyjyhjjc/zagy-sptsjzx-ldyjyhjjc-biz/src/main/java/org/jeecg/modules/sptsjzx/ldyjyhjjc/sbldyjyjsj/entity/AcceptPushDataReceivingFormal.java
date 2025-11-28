package org.jeecg.modules.sptsjzx.ldyjyhjjc.sbldyjyjsj.entity;

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
 * @Description: 上报雷电预警预警数据
 * @Author: zagy-cg
 * @Date:   2025-06-25
 * @Version: V1.0
 */
@Data
@TableName("accept_push_data_receiving_formal")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="accept_push_data_receiving_formal对象", description="上报雷电预警预警数据")
public class AcceptPushDataReceivingFormal implements Serializable {
    private static final long serialVersionUID = 1L;

	/**序号*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "序号")
    private java.lang.Integer id;
	/**企业名称*/
	@Excel(name = "企业名称", width = 15, dictTable = "v_accept_company", dicText = "name", dicCode = "code")
	@Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @ApiModelProperty(value = "企业名称")
    private java.lang.String companyCode;
	/**设备编码*/
	@Excel(name = "设备编码", width = 15, dictTable = "v_accept_equip_data_receiving_formal", dicText = "equip_name", dicCode = "equip_code")
	@Dict(dictTable = "v_accept_equip_data_receiving_formal", dicText = "equip_name", dicCode = "equip_code")
    @ApiModelProperty(value = "设备编码")
    private java.lang.String equipCode;
	/**预警事件编号*/
	@Excel(name = "预警事件编号", width = 15)
    @ApiModelProperty(value = "预警事件编号")
    private java.lang.String crashNumber;
	/**预警等级*/
	@Excel(name = "预警等级", width = 15, dicCode = "ldyjdj")
	@Dict(dicCode = "ldyjdj")
    @ApiModelProperty(value = "预警等级")
    private java.lang.String level;
	/**预警开始时间*/
	@Excel(name = "预警开始时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "预警开始时间")
    private java.util.Date beginTime;
	/**预警结束时间*/
	@Excel(name = "预警结束时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "预警结束时间")
    private java.util.Date endTime;
	/**推送状态*/
	@Excel(name = "推送状态", width = 15, dicCode = "tszt2")
	@Dict(dicCode = "tszt2")
    @ApiModelProperty(value = "推送状态")
    private java.lang.Integer pushState;
	/**推送次数*/
	@Excel(name = "推送次数", width = 15)
    @ApiModelProperty(value = "推送次数")
    private java.lang.Integer pushNum;
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
	/**应急部返回批次号*/
	@Excel(name = "应急部返回批次号", width = 15)
    @ApiModelProperty(value = "应急部返回批次号")
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
