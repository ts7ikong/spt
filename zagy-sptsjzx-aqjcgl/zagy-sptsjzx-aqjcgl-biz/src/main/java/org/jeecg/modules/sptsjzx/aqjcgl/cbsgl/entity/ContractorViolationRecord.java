package org.jeecg.modules.sptsjzx.aqjcgl.cbsgl.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
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
import com.baomidou.mybatisplus.annotation.*;

/**
 * @Description: 承包商违规记录
 * @Author: zagy-cg
 * @Date:   2025-03-03
 * @Version: V1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@TableName("contractor_violation_record")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="contractor_violation_record对象", description="承包商违规记录")
public class ContractorViolationRecord implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;

    /**UUID*/
    @Excel(name = "UUID", width = 15)
    @ApiModelProperty(value = "UUID")
    private String uuid;

    /**第三方单位名称*/
    @Excel(name = "第三方单位名称", width = 15, dictTable = "contractor_basic_info", dicText = "company_name", dicCode = "social_code")
    @Dict(dictTable = "v_contractor_basic_info", dicText = "company_name", dicCode = "social_code")
    @ApiModelProperty(value = "第三方单位名称")
    private java.lang.String socialCode;

    /**上报企业*/
    @Excel(name = "上报企业", width = 15, dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @ApiModelProperty(value = "上报企业")
    private java.lang.String reportCompanyCode;

    /**违规描述*/
    @Excel(name = "违规描述", width = 15)
    @ApiModelProperty(value = "违规描述")
    private String disposeDesc;

    /**处理过程*/
    @Excel(name = "处理过程", width = 15)
    @ApiModelProperty(value = "处理过程")
    private String disposeProcess;

    /**发生时间*/
    @Excel(name = "发生时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发生时间")
    private Date startTime;
    /**删除标志*/
    @Excel(name = "删除标志", width = 15, dicCode = "scbz")
    @Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标志")
    private String deleted;

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

    /**数据入库时间*/
    @Excel(name = "数据入库时间", width = 15)
    @ApiModelProperty(value = "数据入库时间")
    private java.lang.String time;

    /**区县Code*/
    @TableField(exist = false)
    @ApiModelProperty(value = "区县Code")
    @Dict(dictTable = "v_company_county", dicText = "county_name", dicCode = "code")
    private java.lang.String countyCode;
}
