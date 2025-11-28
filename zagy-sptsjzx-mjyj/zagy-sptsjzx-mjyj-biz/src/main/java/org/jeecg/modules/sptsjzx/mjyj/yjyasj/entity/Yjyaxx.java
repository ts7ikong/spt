package org.jeecg.modules.sptsjzx.mjyj.yjyasj.entity;

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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
 * @Description: 应急预案信息
 * @Author: zagy-cg
 * @Date:   2025-03-03
 * @Version: V1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@TableName("yjyaxx")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="yjyaxx对象", description="应急预案信息")
public class Yjyaxx implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private Date updateTime;
	/**预案编码*/
	@Excel(name = "预案编码", width = 15)
    @ApiModelProperty(value = "预案编码")
    private String emergencePlanId;
	/**UUID*/
	@Excel(name = "UUID", width = 15)
    @ApiModelProperty(value = "UUID")
    private String uuid;
	/**园区编码*/
	@Excel(name = "园区编码", width = 15, dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
	@Dict(dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @ApiModelProperty(value = "园区编码")
    private String parkCode;
	/**企业编码*/
	@Excel(name = "企业编码", width = 15)
    @ApiModelProperty(value = "企业编码")
    private String companyCode;
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
	/**行政区划*/
	@Excel(name = "行政区划", width = 15)
    @ApiModelProperty(value = "行政区划")
    private String areaCode;
	/**编制单位*/
	@Excel(name = "编制单位", width = 15)
    @ApiModelProperty(value = "编制单位")
    private String preparationDeparetment;
	/**预案名称*/
	@Excel(name = "预案名称", width = 15)
    @ApiModelProperty(value = "预案名称")
    private String emergencePlanName;
	/**预案类别*/
	@Excel(name = "预案类别", width = 15, dicCode = "yalb")
	@Dict(dicCode = "yalb")
    @ApiModelProperty(value = "预案类别")
    private String emergencePlanType;
	/**预案等级*/
	@Excel(name = "预案等级", width = 15, dicCode = "yadj")
	@Dict(dicCode = "yadj")
    @ApiModelProperty(value = "预案等级")
    private String emergencePlanLevel;
	/**预案评审日期*/
	@Excel(name = "预案评审日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "预案评审日期")
    private Date planReviewDate;
	/**预案评审意见*/
	@Excel(name = "预案评审意见", width = 15)
    @ApiModelProperty(value = "预案评审意见")
    private String planReviewComments;
	/**风险是否告知周边单位*/
	@Excel(name = "风险是否告知周边单位", width = 15, dicCode = "fxsfgzzbdw")
	@Dict(dicCode = "fxsfgzzbdw")
    @ApiModelProperty(value = "风险是否告知周边单位")
    private String riskHasToldYesOrNo;
	/**风险告知周边的其他单位资料*/
	@Excel(name = "风险告知周边的其他单位资料", width = 15)
    @ApiModelProperty(value = "风险告知周边的其他单位资料")
    private String riskHasToldMaterial;
	/**初次发布日期*/
	@Excel(name = "初次发布日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "初次发布日期")
    private Date publishedFirstTimeDate;
	/**初次备案日期*/
	@Excel(name = "初次备案日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "初次备案日期")
    private Date recordFirstTimeDate;
	/**备案部门*/
	@Excel(name = "备案部门", width = 15)
    @ApiModelProperty(value = "备案部门")
    private String recordDepart;
	/**备案部门性质*/
	@Excel(name = "备案部门性质", width = 15, dicCode = "babmxz")
	@Dict(dicCode = "babmxz")
    @ApiModelProperty(value = "备案部门性质")
    private String recordDepartNature;
	/**预案备案登记资料*/
	@Excel(name = "预案备案登记资料", width = 15)
    @ApiModelProperty(value = "预案备案登记资料")
    private String planToRecordMaterial;
	/**最近发布日期*/
	@Excel(name = "最近发布日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "最近发布日期")
    private Date publishedRecentlyDate;
	/**最近定期评估日期*/
	@Excel(name = "最近定期评估日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "最近定期评估日期")
    private Date reviewedRecentlyDate;
	/**最近备案日期*/
	@Excel(name = "最近备案日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "最近备案日期")
    private Date recordedRecentlyDate;
	/**定期评估周期*/
	@Excel(name = "定期评估周期", width = 15)
    @ApiModelProperty(value = "定期评估周期")
    private Integer reviewedRecentlyCycle;
	/**预案评估状态*/
	@Excel(name = "预案评估状态", width = 15, dicCode = "yapgzt")
	@Dict(dicCode = "yapgzt")
    @ApiModelProperty(value = "预案评估状态")
    private String planReviewedState;
	/**评估意见*/
	@Excel(name = "评估意见", width = 15, dicCode = "pgyj")
	@Dict(dicCode = "pgyj")
    @ApiModelProperty(value = "评估意见")
    private String planReviewedComments;
	/**修订状态*/
	@Excel(name = "修订状态", width = 15, dicCode = "xdzt")
	@Dict(dicCode = "xdzt")
    @ApiModelProperty(value = "修订状态")
    private String reviseState;
	/**删除标志*/
	@Excel(name = "删除标志", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标志")
    private String deleted;
}
