package org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.sbtyjl.entity;

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
 * @Description: 设备停用记录
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Data
@TableName("device_stop_record")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="device_stop_record对象", description="设备停用记录")
public class DeviceStopRecord implements Serializable {
    private static final long serialVersionUID = 1L;

	/**自增主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "自增主键")
    private java.lang.Integer id;
	/**UUID*/
	@Excel(name = "UUID", width = 15)
    @ApiModelProperty(value = "UUID")
    private java.lang.String uuid;
	/**设备名称*/
	@Excel(name = "设备名称", width = 15, dictTable = "v_device_base_info", dicText = " equip_name", dicCode = "equip_code")
	@Dict(dictTable = "v_device_base_info", dicText = " equip_name", dicCode = "equip_code")
    @ApiModelProperty(value = "设备名称")
    private java.lang.String equipCode;
	/**危险源名称*/
	@Excel(name = "危险源名称", width = 15, dictTable = "v_accept_hazard_code", dicText = "hazard_name", dicCode = "hazard_code")
	@Dict(dictTable = "v_accept_hazard_code", dicText = "hazard_name", dicCode = "hazard_code")
    @ApiModelProperty(value = "危险源名称")
    private java.lang.String hazardCode;
	/**停用日期*/
	@Excel(name = "停用日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "停用日期")
    private java.util.Date stopDate;
	/**计划启用日期*/
	@Excel(name = "计划启用日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "计划启用日期")
    private java.util.Date planEnableDate;
	/**实际启用日期，设备启用后更新*/
	@Excel(name = "实际启用日期，设备启用后更新", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "实际启用日期，设备启用后更新")
    private java.util.Date enableDate;
	/**停用类型*/
	@Excel(name = "停用类型", width = 15, dicCode = "tylx")
	@Dict(dicCode = "tylx")
    @ApiModelProperty(value = "停用类型")
    private java.lang.String stopType;
	/**停用原因*/
	@Excel(name = "停用原因", width = 15)
    @ApiModelProperty(value = "停用原因")
    private java.lang.String stopReason;
	/**删除标记*/
	@Excel(name = "删除标记", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标记")
    private java.lang.Integer deleted;
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
