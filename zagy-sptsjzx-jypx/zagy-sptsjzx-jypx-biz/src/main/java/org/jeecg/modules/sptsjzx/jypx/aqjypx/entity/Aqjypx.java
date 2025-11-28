package org.jeecg.modules.sptsjzx.jypx.aqjypx.entity;

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
 * @Description: 安全教育培训
 * @Author: zagy-cg
 * @Date:   2025-06-03
 * @Version: V1.0
 */
@Data
@TableName("aqjypx")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="aqjypx对象", description="安全教育培训")
public class Aqjypx implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**uuid*/
	@Excel(name = "uuid", width = 15)
    @ApiModelProperty(value = "uuid")
    private java.lang.String uuid;
    /**园区编码*/
    @Excel(name = "园区编码", width = 15, dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @Dict(dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @ApiModelProperty(value = "园区编码")
    private String parkCode;
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
	/**培训名称*/
	@Excel(name = "培训名称", width = 15)
    @ApiModelProperty(value = "培训名称")
    private java.lang.String trainName;
	/**培训类型*/
	@Excel(name = "培训类型", width = 15, dicCode = "aqjypxlx")
	@Dict(dicCode = "aqjypxlx")
    @ApiModelProperty(value = "培训类型")
    private java.lang.String trainType;
	/**培训方式*/
	@Excel(name = "培训方式", width = 15, dicCode = "pxfs")
	@Dict(dicCode = "pxfs")
    @ApiModelProperty(value = "培训方式")
    private java.lang.String trainMethod;
	/**培训途径*/
	@Excel(name = "培训途径", width = 15, dicCode = "pxtj")
	@Dict(dicCode = "pxtj")
    @ApiModelProperty(value = "培训途径")
    private java.lang.String trainApproach;
	/**培训学时*/
	@Excel(name = "培训学时", width = 15)
    @ApiModelProperty(value = "培训学时")
    private java.lang.String trainPeriod;
	/**培训开始日期*/
	@Excel(name = "培训开始日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "培训开始日期")
    private java.util.Date trainDateStart;
	/**培训结束日期*/
	@Excel(name = "培训结束日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "培训结束日期")
    private java.util.Date trainDateEnd;
	/**培训级别*/
	@Excel(name = "培训级别", width = 15)
    @ApiModelProperty(value = "培训级别")
    private java.lang.String trainLevel;
	/**培训组织单位（部门）*/
	@Excel(name = "培训组织单位（部门）", width = 15)
    @ApiModelProperty(value = "培训组织单位（部门）")
    private java.lang.String trainOrgnizeDepart;
	/**培训地点*/
	@Excel(name = "培训地点", width = 15)
    @ApiModelProperty(value = "培训地点")
    private java.lang.String trainLocate;
	/**参加人数*/
	@Excel(name = "参加人数", width = 15)
    @ApiModelProperty(value = "参加人数")
    private java.lang.Integer participantNum;
	/**培训合格人数*/
	@Excel(name = "培训合格人数", width = 15)
    @ApiModelProperty(value = "培训合格人数")
    private java.lang.Integer qualifyTrainNum;
	/**培训不合格人数*/
	@Excel(name = "培训不合格人数", width = 15)
    @ApiModelProperty(value = "培训不合格人数")
    private java.lang.Integer unqualifyTrainNum;
	/**培训资料附件*/
	@Excel(name = "培训资料附件", width = 15)
    @ApiModelProperty(value = "培训资料附件")
    private java.lang.String trainMaterialDocument;
	/**考核结果*/
	@Excel(name = "考核结果", width = 15)
    @ApiModelProperty(value = "考核结果")
    private java.lang.String exameResult;
	/**考核人*/
	@Excel(name = "考核人", width = 15)
    @ApiModelProperty(value = "考核人")
    private java.lang.String assessor;
	/**考核日期*/
	@Excel(name = "考核日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "考核日期")
    private java.util.Date exameDate;
	/**删除标记*/
	@Excel(name = "删除标记", width = 15)
    @ApiModelProperty(value = "删除标记")
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
