package org.jeecg.modules.sptsjzx.dsfdwgl.dsfwgjl.entity;

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
 * @Description: 第三方违规记录
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Data
@TableName("contractor_violation_record")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="contractor_violation_record对象", description="第三方违规记录")
public class ContractorViolationRecord implements Serializable {
    private static final long serialVersionUID = 1L;

	/**自增主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "自增主键")
    private java.lang.Integer id;
	/**UUID*/
	@Excel(name = "UUID", width = 15)
    @ApiModelProperty(value = "UUID")
    private java.lang.String uuid;
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
	/**违规发生地点*/
	@Excel(name = "违规发生地点", width = 15)
    @ApiModelProperty(value = "违规发生地点")
    private java.lang.String place;
	/**违规描述内容*/
	@Excel(name = "违规描述内容", width = 15)
    @ApiModelProperty(value = "违规描述内容")
    private java.lang.String disposeDesc;
	/**处理过程描述*/
	@Excel(name = "处理过程描述", width = 15)
    @ApiModelProperty(value = "处理过程描述")
    private java.lang.String disposeProcess;
	/**违规发生时间*/
	@Excel(name = "违规发生时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "违规发生时间")
    private java.util.Date startTime;
	/**删除标志*/
	@Excel(name = "删除标志", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标志")
    private java.lang.String deleted;
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
	/**数据入库时间*/
	@Excel(name = "数据入库时间", width = 15)
    @ApiModelProperty(value = "数据入库时间")
    private java.lang.String time;
	/**我们返回企业batch编号*/
	@Excel(name = "我们返回企业batch编号", width = 15)
    @ApiModelProperty(value = "我们返回企业batch编号")
    private java.lang.String wbatchId;
}
