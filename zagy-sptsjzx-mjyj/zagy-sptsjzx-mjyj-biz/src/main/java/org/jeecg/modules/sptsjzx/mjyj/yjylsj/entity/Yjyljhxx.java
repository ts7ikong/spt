package org.jeecg.modules.sptsjzx.mjyj.yjylsj.entity;

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
 * @Description: 应急演练计划信息
 * @Author: zagy-cg
 * @Date:   2025-03-03
 * @Version: V1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@TableName("yjyljhxx")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="yjyljhxx对象", description="应急演练计划信息")
public class Yjyljhxx implements Serializable {
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
	/**UUID*/
	@Excel(name = "UUID", width = 15)
    @ApiModelProperty(value = "UUID")
    private String uuid;
	/**园区编码*/
	@Excel(name = "园区编码", width = 15, dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
	@Dict(dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @ApiModelProperty(value = "园区编码")
    private String parkCode;
	/**编制单位编码*/
	@Excel(name = "编制单位编码", width = 15)
    @ApiModelProperty(value = "编制单位编码")
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
	/**计划编码*/
	@Excel(name = "计划编码", width = 15)
    @ApiModelProperty(value = "计划编码")
    private String planId;
	/**计划名称*/
	@Excel(name = "计划名称", width = 15)
    @ApiModelProperty(value = "计划名称")
    private String planName;
	/**演练类型*/
	@Excel(name = "演练类型", width = 15, dicCode = "yjyllx")
	@Dict(dicCode = "yjyllx")
    @ApiModelProperty(value = "演练类型")
    private String drillType;
	/**预案编码*/
	@Excel(name = "预案编码", width = 15)
    @ApiModelProperty(value = "预案编码")
    private String associatePlanId;
	/**演练级别*/
	@Excel(name = "演练级别", width = 15, dicCode = "yljb")
	@Dict(dicCode = "yljb")
    @ApiModelProperty(value = "演练级别")
    private String drillLevel;
	/**演练场景*/
	@Excel(name = "演练场景", width = 15)
    @ApiModelProperty(value = "演练场景")
    private String drillScene;
	/**演练地点*/
	@Excel(name = "演练地点", width = 15)
    @ApiModelProperty(value = "演练地点")
    private String drillPlace;
	/**预计完成日期*/
	@Excel(name = "预计完成日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "预计完成日期")
    private Date finishDate;
	/**参与人数*/
	@Excel(name = "参与人数", width = 15)
    @ApiModelProperty(value = "参与人数")
    private Integer particNum;
	/**附件*/
	@Excel(name = "附件", width = 15)
    @ApiModelProperty(value = "附件")
    private String attach;
	/**计划状态*/
	@Excel(name = "计划状态", width = 15, dicCode = "jhzt")
	@Dict(dicCode = "jhzt")
    @ApiModelProperty(value = "计划状态")
    private String planState;
	/**编制人*/
	@Excel(name = "编制人", width = 15)
    @ApiModelProperty(value = "编制人")
    private String writerByName;
	/**审核人*/
	@Excel(name = "审核人", width = 15)
    @ApiModelProperty(value = "审核人")
    private String checkByName;
	/**批准时间*/
	@Excel(name = "批准时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "批准时间")
    private Date authorizeTime;
	/**删除标志*/
	@Excel(name = "删除标志", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标志")
    private String deleted;
}
