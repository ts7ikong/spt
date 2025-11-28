package org.jeecg.modules.sptsjzx.aqjcgl.zfjcgl.zfjcjlxx.entity;

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
 * @Description: 执法检查记录信息
 * @Author: zagy-cg
 * @Date:   2025-05-30
 * @Version: V1.0
 */
@Data
@TableName("zfjcjlxx")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="zfjcjlxx对象", description="执法检查记录信息")
public class Zfjcjlxx implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**UUID*/
	@Excel(name = "UUID", width = 15)
    @ApiModelProperty(value = "UUID")
    private java.lang.String uuid;
	/**所属园区*/
	@Excel(name = "所属园区", width = 15, dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
	@Dict(dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @ApiModelProperty(value = "所属园区")
    private java.lang.String parkCode;
	/**关联执法检查计划编号*/
	@Excel(name = "关联执法检查计划编号", width = 15)
    @ApiModelProperty(value = "关联执法检查计划编号")
    private java.lang.String enforcementId;
	/**企业编码*/
	@Excel(name = "企业编码", width = 15)
    @ApiModelProperty(value = "企业编码")
    private java.lang.String companyCode;

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
	/**执法检查人员编号*/
	@Excel(name = "执法检查人员编号", width = 15)
    @ApiModelProperty(value = "执法检查人员编号")
    private java.lang.String lawEnforcementOfficalsId;
	/**执法检查执法检查日期日期*/
	@Excel(name = "执法检查执法检查日期日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "执法检查执法检查日期日期")
    private java.util.Date lawEnforcementDate;
	/**执法检查情况描述*/
	@Excel(name = "执法检查情况描述", width = 15)
    @ApiModelProperty(value = "执法检查情况描述")
    private java.lang.String lawEnforcementContent;
	/**是否执法*/
	@Excel(name = "是否执法", width = 15, dicCode = "sfmcaf")
	@Dict(dicCode = "sfmcaf")
    @ApiModelProperty(value = "是否执法")
    private java.lang.String isLawEnforcement;
	/**是否停产整顿*/
	@Excel(name = "是否停产整顿", width = 15, dicCode = "sfmcaf")
	@Dict(dicCode = "sfmcaf")
    @ApiModelProperty(value = "是否停产整顿")
    private java.lang.String isSuspendReorganization;
	/**是否提请关闭*/
	@Excel(name = "是否提请关闭", width = 15, dicCode = "sfmcaf")
	@Dict(dicCode = "sfmcaf")
    @ApiModelProperty(value = "是否提请关闭")
    private java.lang.String isRequestClose;
	/**是否经济处罚*/
	@Excel(name = "是否经济处罚", width = 15, dicCode = "sfmcaf")
	@Dict(dicCode = "sfmcaf")
    @ApiModelProperty(value = "是否经济处罚")
    private java.lang.String isEconomicPenalty;
	/**罚款金额（元）*/
	@Excel(name = "罚款金额（元）", width = 15)
    @ApiModelProperty(value = "罚款金额（元）")
    private java.math.BigDecimal fineAmount;
	/**查封扣押决定 书（附件）*/
	@Excel(name = "查封扣押决定 书（附件）", width = 15)
    @ApiModelProperty(value = "查封扣押决定 书（附件）")
    private java.lang.String sealConfiscationDecision;
	/**调查询问笔录 （附件）*/
	@Excel(name = "调查询问笔录 （附件）", width = 15)
    @ApiModelProperty(value = "调查询问笔录 （附件）")
    private java.lang.String inquiryRecord;
	/**行政当场处罚 决定书（附件）*/
	@Excel(name = "行政当场处罚 决定书（附件）", width = 15)
    @ApiModelProperty(value = "行政当场处罚 决定书（附件）")
    private java.lang.String onsitePenaltyDecision;
	/**执法检查现场照片*/
	@Excel(name = "执法检查现场照片", width = 15)
    @ApiModelProperty(value = "执法检查现场照片")
    private java.lang.String enforcePicture;
	/**是否立案*/
	@Excel(name = "是否立案", width = 15, dicCode = "sfbz")
	@Dict(dicCode = "sfbz")
    @ApiModelProperty(value = "是否立案")
    private java.lang.String register;
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
