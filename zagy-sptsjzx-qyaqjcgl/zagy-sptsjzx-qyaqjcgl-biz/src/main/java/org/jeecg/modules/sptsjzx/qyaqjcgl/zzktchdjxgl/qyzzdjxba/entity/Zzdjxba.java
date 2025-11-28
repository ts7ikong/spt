package org.jeecg.modules.sptsjzx.qyaqjcgl.zzktchdjxgl.qyzzdjxba.entity;

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
 * @Description: 企业装置大检修备案
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Data
@TableName("zzdjxba")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="zzdjxba对象", description="企业装置大检修备案")
public class Zzdjxba implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
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
	/**装置名称*/
	@Excel(name = "装置名称", width = 15)
    @ApiModelProperty(value = "装置名称")
    private java.lang.String deviceName;
	/**装置编号*/
	@Excel(name = "装置编号", width = 15)
    @ApiModelProperty(value = "装置编号")
    private java.lang.String deviceCode;
	/**装置负责人姓名*/
	@Excel(name = "装置负责人姓名", width = 15)
    @ApiModelProperty(value = "装置负责人姓名")
    private java.lang.String plantPrincipalPersonName;
	/**装置负责人手机号*/
	@Excel(name = "装置负责人手机号", width = 15)
    @ApiModelProperty(value = "装置负责人手机号")
    private java.lang.String plantPrincipalPersonMobile;
	/**检修名称*/
	@Excel(name = "检修名称", width = 15)
    @ApiModelProperty(value = "检修名称")
    private java.lang.String maintenanceName;
	/**检修内容*/
	@Excel(name = "检修内容", width = 15)
    @ApiModelProperty(value = "检修内容")
    private java.lang.String maintenanceContent;
	/**重大危险源编码*/
	@Excel(name = "重大危险源编码", width = 15)
    @ApiModelProperty(value = "重大危险源编码")
    private java.lang.String hazardCode;
	/**大检修开始时间*/
	@Excel(name = "大检修开始时间", width = 15)
    @ApiModelProperty(value = "大检修开始时间")
    private java.lang.String maintenanceStartTime;
	/**大检修计划结束时间*/
	@Excel(name = "大检修计划结束时间", width = 15)
    @ApiModelProperty(value = "大检修计划结束时间")
    private java.lang.String maintenanceExpireTime;
	/**大检修实际结束时间*/
	@Excel(name = "大检修实际结束时间", width = 15)
    @ApiModelProperty(value = "大检修实际结束时间")
    private java.lang.String maintenanceEndTime;
	/**大检修责任人*/
	@Excel(name = "大检修责任人", width = 15)
    @ApiModelProperty(value = "大检修责任人")
    private java.lang.String maintenancePersonName;
	/**大检修责任人手机号*/
	@Excel(name = "大检修责任人手机号", width = 15)
    @ApiModelProperty(value = "大检修责任人手机号")
    private java.lang.String maintenancePersonMobile;
	/**当前状态*/
	@Excel(name = "当前状态", width = 15, dicCode = "jxzt")
	@Dict(dicCode = "jxzt")
    @ApiModelProperty(value = "当前状态")
    private java.lang.String operationStatus;
	/**删除标志*/
	@Excel(name = "删除标志", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标志")
    private java.lang.String deleted;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
    @ApiModelProperty(value = "创建日期")
    private java.lang.String createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
    @ApiModelProperty(value = "更新日期")
    private java.lang.String updateTime;
	/**进表时间*/
	@Excel(name = "进表时间", width = 15)
    @ApiModelProperty(value = "进表时间")
    private java.lang.String createDate;
}
