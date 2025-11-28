package org.jeecg.modules.sptsjzx.mjyj.yjfzjc.jjjl.entity;

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
 * @Description: 接警记录
 * @Author: zagy-cg
 * @Date:   2025-06-03
 * @Version: V1.0
 */
@Data
@TableName("jjjl")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="jjjl对象", description="接警记录")
public class Jjjl implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**UUID*/
	@Excel(name = "UUID", width = 15)
    @ApiModelProperty(value = "UUID")
    private java.lang.String uuid;
	/**园区编码*/
	@Excel(name = "园区编码", width = 15, dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
	@Dict(dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @ApiModelProperty(value = "园区编码")
    private java.lang.String parkCode;
    /**
     * 区县名称
     */
    @Excel(name = "区县名称", width = 15, dictTable = "j_position_county", dicText = "county_name", dicCode = "county_id")
    @Dict(dictTable = "j_position_county", dicText = "county_name", dicCode = "county_id")
    @ApiModelProperty(value = "区县名称")
    private java.lang.String countyname;
    /**
     * 所属区县区县编码
     */
    @Excel(name = "所属区县区县编码", width = 15)
    @ApiModelProperty(value = "所属区县区县编码")
    private java.lang.String countycode;
	/**接警编码*/
	@Excel(name = "接警编码", width = 15)
    @ApiModelProperty(value = "接警编码")
    private java.lang.String serialCode;
	/**事故名称*/
	@Excel(name = "事故名称", width = 15)
    @ApiModelProperty(value = "事故名称")
    private java.lang.String accidentName;
	/**接警人*/
	@Excel(name = "接警人", width = 15)
    @ApiModelProperty(value = "接警人")
    private java.lang.String pickUpPerson;
	/**报警人*/
	@Excel(name = "报警人", width = 15)
    @ApiModelProperty(value = "报警人")
    private java.lang.String callThePolice;
	/**报警电话*/
	@Excel(name = "报警电话", width = 15)
    @ApiModelProperty(value = "报警电话")
    private java.lang.String policeCall;
	/**事故类型*/
	@Excel(name = "事故类型", width = 15, dicCode = "sglx")
	@Dict(dicCode = "sglx")
    @ApiModelProperty(value = "事故类型")
    private java.lang.String typeOfAccident;
	/**事故装置*/
	@Excel(name = "事故装置", width = 15)
    @ApiModelProperty(value = "事故装置")
    private java.lang.String accidentDevice;
	/**涉及危险化学品*/
	@Excel(name = "涉及危险化学品", width = 15)
    @ApiModelProperty(value = "涉及危险化学品")
    private java.lang.String hazardousChemicals;
	/**关联企业编码*/
	@Excel(name = "关联企业编码", width = 15)
    @ApiModelProperty(value = "关联企业编码")
    private java.lang.String affiliates;
	/**接警时间*/
	@Excel(name = "接警时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "接警时间")
    private java.util.Date policeTime;
	/**事故发生时间*/
	@Excel(name = "事故发生时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "事故发生时间")
    private java.util.Date startTime;
	/**死亡人数*/
	@Excel(name = "死亡人数", width = 15)
    @ApiModelProperty(value = "死亡人数")
    private java.lang.Integer deathToll;
	/**重伤人数*/
	@Excel(name = "重伤人数", width = 15)
    @ApiModelProperty(value = "重伤人数")
    private java.lang.Integer seriouslyInjuredNumber;
	/**轻伤人数*/
	@Excel(name = "轻伤人数", width = 15)
    @ApiModelProperty(value = "轻伤人数")
    private java.lang.Integer minorInjuriesNumber;
	/**已采取措施*/
	@Excel(name = "已采取措施", width = 15)
    @ApiModelProperty(value = "已采取措施")
    private java.lang.String accidentOverview;
	/**处置状态*/
	@Excel(name = "处置状态", width = 15, dicCode = "jjczzt")
	@Dict(dicCode = "jjczzt")
    @ApiModelProperty(value = "处置状态")
    private java.lang.String dispositionStatus;
	/**事故现场图片*/
	@Excel(name = "事故现场图片", width = 15)
    @ApiModelProperty(value = "事故现场图片")
    private java.lang.String accidentSceneImg;
	/**删除标志*/
	@Excel(name = "删除标志", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标志")
    private java.lang.String deleted;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**创建日期_企业*/
	@Excel(name = "创建日期_企业", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期_企业")
    private java.util.Date createTimeCompany;
	/**创建人_企业*/
	@Excel(name = "创建人_企业", width = 15)
    @ApiModelProperty(value = "创建人_企业")
    private java.lang.String createByCompany;
	/**更新日期_企业*/
	@Excel(name = "更新日期_企业", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期_企业")
    private java.util.Date updateTimeCompany;
	/**更新人_企业*/
	@Excel(name = "更新人_企业", width = 15)
    @ApiModelProperty(value = "更新人_企业")
    private java.lang.String updateByCompany;
}
