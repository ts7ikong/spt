package org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qysgsj.entity;

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
 * @Description: 企业事故事件
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Data
@TableName("qysgsj")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="qysgsj对象", description="企业事故事件")
public class Qysgsj implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**UUID*/
	@Excel(name = "UUID", width = 15)
    @ApiModelProperty(value = "UUID")
    private java.lang.String uuid;
	/**企业名称*/
	@Excel(name = "企业名称", width = 15, dictTable = "v_accept_company", dicText = "name", dicCode = "code")
	@Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @ApiModelProperty(value = "企业名称")
    private java.lang.String companyCode;
	/**事故编号*/
	@Excel(name = "事故编号", width = 15)
    @ApiModelProperty(value = "事故编号")
    private java.lang.String accidentId;
	/**事故名称*/
	@Excel(name = "事故名称", width = 15)
    @ApiModelProperty(value = "事故名称")
    private java.lang.String accidentName;
	/**事故来源*/
	@Excel(name = "事故来源", width = 15)
    @ApiModelProperty(value = "事故来源")
    private java.lang.String accidentSource;
	/**事故类型*/
	@Excel(name = "事故类型", width = 15, dicCode = "sglx")
	@Dict(dicCode = "sglx")
    @ApiModelProperty(value = "事故类型")
    private java.lang.String typeOfAccident;
	/**事故等级*/
	@Excel(name = "事故等级", width = 15, dicCode = "sgdj")
	@Dict(dicCode = "sgdj")
    @ApiModelProperty(value = "事故等级")
    private java.lang.String accidentLevel;
	/**经度*/
	@Excel(name = "经度", width = 15)
    @ApiModelProperty(value = "经度")
    private java.lang.String longitude;
	/**纬度*/
	@Excel(name = "纬度", width = 15)
    @ApiModelProperty(value = "纬度")
    private java.lang.String latitude;
	/**死亡人数*/
	@Excel(name = "死亡人数", width = 15)
    @ApiModelProperty(value = "死亡人数")
    private java.lang.String deathToll;
	/**重伤人数*/
	@Excel(name = "重伤人数", width = 15)
    @ApiModelProperty(value = "重伤人数")
    private java.lang.String seriouslyInjuredNumber;
	/**轻伤人数*/
	@Excel(name = "轻伤人数", width = 15)
    @ApiModelProperty(value = "轻伤人数")
    private java.lang.String minorInjuriesNumber;
	/**事故概况*/
	@Excel(name = "事故概况", width = 15)
    @ApiModelProperty(value = "事故概况")
    private java.lang.String accidentDescription;
	/**处置状态*/
	@Excel(name = "处置状态", width = 15, dicCode = "czzt")
	@Dict(dicCode = "czzt")
    @ApiModelProperty(value = "处置状态")
    private java.lang.String dispositionStatus;
	/**上报状态*/
	@Excel(name = "上报状态", width = 15, dicCode = "sbzt")
	@Dict(dicCode = "sbzt")
    @ApiModelProperty(value = "上报状态")
    private java.lang.String registrationStatus;
	/**上报时间*/
	@Excel(name = "上报时间", width = 15)
    @ApiModelProperty(value = "上报时间")
    private java.lang.String reportionTime;
	/**删除标志*/
	@Excel(name = "删除标志", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标志")
    private java.lang.String deleted;
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
	/**进表时间*/
    @ApiModelProperty(value = "进表时间")
    private java.lang.String createTime;
}
