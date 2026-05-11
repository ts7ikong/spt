package org.jeecg.modules.sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyjl.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;
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
 * @Description: 企业抽查记录详情反馈
 * @Author: zagy-cg
 * @Date:   2026-04-22
 * @Version: V1.0
 */
@Data
@TableName("v_tb_hrmw_base_inspect_company_reply")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="tb_hrmw_base_inspect_company_reply对象", description="企业抽查记录详情反馈")
public class TbHrmwBaseInspectCompanyReply implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private String id;
	/**抽查记录详情id*/
	@Excel(name = "抽查记录详情id", width = 15)
    @ApiModelProperty(value = "抽查记录详情id")
    private String inspectCompanyId;
	/**反馈类型*/
	@Excel(name = "反馈类型", width = 15, dicCode = "qyxcccjlfklx")
	@Dict(dicCode = "qyxcccjlfklx")
    @ApiModelProperty(value = "反馈类型")
    private String replyType;
	/**情况说明*/
	@Excel(name = "情况说明", width = 15)
    @ApiModelProperty(value = "情况说明")
    private String situation;
	/**处置措施*/
	@Excel(name = "处置措施", width = 15)
    @ApiModelProperty(value = "处置措施")
    private String measure;
	/**延期说明*/
	@Excel(name = "延期说明", width = 15)
    @ApiModelProperty(value = "延期说明")
    private String delayInfo;
	/**延期完成时间*/
	@Excel(name = "延期完成时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "延期完成时间")
    private Date delayDate;
	/**计划完成时间*/
	@Excel(name = "计划完成时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "计划完成时间")
    private Date planDate;
	/**是否完成*/
	@Excel(name = "是否完成", width = 15, dicCode = "sfwc")
	@Dict(dicCode = "sfwc")
    @ApiModelProperty(value = "是否完成")
    private String isFinish;
	/**是否删除*/
	@Excel(name = "是否删除", width = 15, dicCode = "sfsc")
	@Dict(dicCode = "sfsc")
    @ApiModelProperty(value = "是否删除")
    private String deleted;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private String updateBy;
	/**更新时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**企业编码*/
    @ApiModelProperty(value = "企业编码")
    @Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    private String companyCode;

    /**区县Code*/
    @TableField(exist = false)
    @ApiModelProperty(value = "区县Code")
    @Dict(dictTable = "v_company_county", dicText = "county_name", dicCode = "code")
    private java.lang.String countyCode;
}
