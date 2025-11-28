package org.jeecg.modules.sptsjzx.ldyjyhjjc.sbldyjsbjcsj.entity;

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
 * @Description: 上报雷电预警设备基础数据
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Data
@TableName("accept_equip_data_receiving_formal")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="accept_equip_data_receiving_formal对象", description="上报雷电预警设备基础数据")
public class AcceptEquipDataReceivingFormal implements Serializable {
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
	/**设备名称*/
	@Excel(name = "设备名称", width = 15)
    @ApiModelProperty(value = "设备名称")
    private java.lang.String equipName;
	/**设备编码*/
	@Excel(name = "设备编码", width = 15)
    @ApiModelProperty(value = "设备编码")
    private java.lang.String equipCode;
	/**监控半径 单位KM*/
	@Excel(name = "监控半径 单位KM", width = 15)
    @ApiModelProperty(value = "监控半径 单位KM")
    private java.lang.String radius;
	/**设备经度*/
	@Excel(name = "设备经度", width = 15)
    @ApiModelProperty(value = "设备经度")
    private java.lang.String longitude;
	/**设备纬度*/
	@Excel(name = "设备纬度", width = 15)
    @ApiModelProperty(value = "设备纬度")
    private java.lang.String latitude;
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
	/**创建时间*/
	@Excel(name = "创建时间", width = 15)
    @ApiModelProperty(value = "创建时间")
    private java.lang.String createDate;
	/**创建人姓名*/
    @ApiModelProperty(value = "创建人姓名")
    private java.lang.String createBy;
	/**修改时间*/
	@Excel(name = "修改时间", width = 15)
    @ApiModelProperty(value = "修改时间")
    private java.lang.String updateDate;
	/**修改人姓名*/
    @ApiModelProperty(value = "修改人姓名")
    private java.lang.String updateBy;
	/**第三方企业数据的uuid*/
	@Excel(name = "第三方企业数据的uuid", width = 15)
    @ApiModelProperty(value = "第三方企业数据的uuid")
    private java.lang.String uuid;
	/**本地uuid*/
	@Excel(name = "本地uuid", width = 15)
    @ApiModelProperty(value = "本地uuid")
    private java.lang.String localUuid;
	/**应急部返回批次号*/
	@Excel(name = "应急部返回批次号", width = 15)
    @ApiModelProperty(value = "应急部返回批次号")
    private java.lang.String batchId;
	/**批次id(我们返回企业的)*/
	@Excel(name = "批次id(我们返回企业的)", width = 15)
    @ApiModelProperty(value = "批次id(我们返回企业的)")
    private java.lang.String wbatchId;
}
