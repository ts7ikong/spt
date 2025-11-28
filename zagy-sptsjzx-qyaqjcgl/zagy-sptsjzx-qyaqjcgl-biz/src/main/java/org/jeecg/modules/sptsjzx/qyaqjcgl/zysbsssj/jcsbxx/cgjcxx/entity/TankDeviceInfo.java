package org.jeecg.modules.sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.cgjcxx.entity;

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
 * @Description: 储罐基础信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Data
@TableName("tank_device_info")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="tank_device_info对象", description="储罐基础信息")
public class TankDeviceInfo implements Serializable {
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
	@Excel(name = "设备名称", width = 15, dictTable = "v_device_base_info", dicText = "equip_name", dicCode = "equip_code")
	@Dict(dictTable = "v_device_base_info", dicText = "equip_name", dicCode = "equip_code")
    @ApiModelProperty(value = "设备名称")
    private java.lang.String equipCode;
	/**罐类型*/
	@Excel(name = "罐类型", width = 15, dicCode = "glx")
	@Dict(dicCode = "glx")
    @ApiModelProperty(value = "罐类型")
    private java.lang.String tankType;
	/**压力类型*/
	@Excel(name = "压力类型", width = 15, dicCode = "yllx")
	@Dict(dicCode = "yllx")
    @ApiModelProperty(value = "压力类型")
    private java.lang.String pressureType;
	/**设计压力*/
	@Excel(name = "设计压力", width = 15)
    @ApiModelProperty(value = "设计压力")
    private java.lang.String pressureDesign;
	/**最高工作压力*/
	@Excel(name = "最高工作压力", width = 15)
    @ApiModelProperty(value = "最高工作压力")
    private java.lang.String pressureMax;
	/**温度类型*/
	@Excel(name = "温度类型", width = 15, dicCode = "wdlx")
	@Dict(dicCode = "wdlx")
    @ApiModelProperty(value = "温度类型")
    private java.lang.String temperatureType;
	/**设计温度低限*/
	@Excel(name = "设计温度低限", width = 15)
    @ApiModelProperty(value = "设计温度低限")
    private java.lang.String temperatureMin;
	/**设计温度高限*/
	@Excel(name = "设计温度高限", width = 15)
    @ApiModelProperty(value = "设计温度高限")
    private java.lang.String temperatureMax;
	/**存储介质*/
	@Excel(name = "存储介质", width = 15)
    @ApiModelProperty(value = "存储介质")
    private java.lang.String medium;
	/**介质形态*/
	@Excel(name = "介质形态", width = 15, dicCode = "jzxt")
	@Dict(dicCode = "jzxt")
    @ApiModelProperty(value = "介质形态")
    private java.lang.String mediumStatus;
	/**储量*/
	@Excel(name = "储量", width = 15)
    @ApiModelProperty(value = "储量")
    private java.lang.String reserves;
	/**液位最高值*/
	@Excel(name = "液位最高值", width = 15)
    @ApiModelProperty(value = "液位最高值")
    private java.lang.String liquidLevel;
	/**建造日期*/
	@Excel(name = "建造日期", width = 15)
    @ApiModelProperty(value = "建造日期")
    private java.lang.String buildDate;
	/**投用日期*/
	@Excel(name = "投用日期", width = 15)
    @ApiModelProperty(value = "投用日期")
    private java.lang.String useDate;
	/**最近检维修日期*/
	@Excel(name = "最近检维修日期", width = 15)
    @ApiModelProperty(value = "最近检维修日期")
    private java.lang.String maintenanceDate;
	/**删除标记*/
	@Excel(name = "删除标记", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标记")
    private java.lang.Integer deleted;
	/**创建时间*/
	@Excel(name = "创建时间", width = 15)
    @ApiModelProperty(value = "创建时间")
    private java.lang.String createDate;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**最后修改时间*/
	@Excel(name = "最后修改时间", width = 15)
    @ApiModelProperty(value = "最后修改时间")
    private java.lang.String updateDate;
	/**最后修改人*/
    @ApiModelProperty(value = "最后修改人")
    private java.lang.String updateBy;
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
