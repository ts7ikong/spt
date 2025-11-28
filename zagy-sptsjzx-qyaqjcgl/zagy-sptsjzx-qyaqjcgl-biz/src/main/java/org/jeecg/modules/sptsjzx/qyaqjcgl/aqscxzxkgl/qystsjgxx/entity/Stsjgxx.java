package org.jeecg.modules.sptsjzx.qyaqjcgl.aqscxzxkgl.qystsjgxx.entity;

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
 * @Description: 企业三同时监管信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Data
@TableName("stsjgxx")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="stsjgxx对象", description="企业三同时监管信息")
public class Stsjgxx implements Serializable {
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
	/**装置名称*/
	@Excel(name = "装置名称", width = 15)
    @ApiModelProperty(value = "装置名称")
    private java.lang.String plantName;
	/**装置编码*/
	@Excel(name = "装置编码", width = 15)
    @ApiModelProperty(value = "装置编码")
    private java.lang.String plantCode;
	/**项目名称*/
	@Excel(name = "项目名称", width = 15)
    @ApiModelProperty(value = "项目名称")
    private java.lang.String projectName;
	/**项目类型*/
	@Excel(name = "项目类型", width = 15, dicCode = "xmlx")
	@Dict(dicCode = "xmlx")
    @ApiModelProperty(value = "项目类型")
    private java.lang.String projectType;
	/**项目开始日期*/
	@Excel(name = "项目开始日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "项目开始日期")
    private java.util.Date projectBeginDate;
	/**项目结束日期*/
	@Excel(name = "项目结束日期", width = 15)
    @ApiModelProperty(value = "项目结束日期")
    private java.lang.String projectEndDate;
	/**项目描述*/
	@Excel(name = "项目描述", width = 15)
    @ApiModelProperty(value = "项目描述")
    private java.lang.String projectDesc;
	/**项目状态*/
	@Excel(name = "项目状态", width = 15, dicCode = "xmzt")
	@Dict(dicCode = "xmzt")
    @ApiModelProperty(value = "项目状态")
    private java.lang.String projectStatus;
	/**立项申请日期*/
	@Excel(name = "立项申请日期", width = 15)
    @ApiModelProperty(value = "立项申请日期")
    private java.lang.String approvalApplyForDate;
	/**立项通过日期*/
	@Excel(name = "立项通过日期", width = 15)
    @ApiModelProperty(value = "立项通过日期")
    private java.lang.String approvalPassDate;
	/**设计开始日期*/
	@Excel(name = "设计开始日期", width = 15)
    @ApiModelProperty(value = "设计开始日期")
    private java.lang.String designBeginDate;
	/**设计结束日期*/
	@Excel(name = "设计结束日期", width = 15)
    @ApiModelProperty(value = "设计结束日期")
    private java.lang.String designEndDate;
	/**建设施工开始日期*/
	@Excel(name = "建设施工开始日期", width = 15)
    @ApiModelProperty(value = "建设施工开始日期")
    private java.lang.String buildBeginDate;
	/**建设施工结束日期*/
	@Excel(name = "建设施工结束日期", width = 15)
    @ApiModelProperty(value = "建设施工结束日期")
    private java.lang.String buildEndDate;
	/**试生产开始日期*/
	@Excel(name = "试生产开始日期", width = 15)
    @ApiModelProperty(value = "试生产开始日期")
    private java.lang.String testProductionBeginDate;
	/**试生产结束日期*/
	@Excel(name = "试生产结束日期", width = 15)
    @ApiModelProperty(value = "试生产结束日期")
    private java.lang.String testProductionEndDate;
	/**验收开始日期*/
	@Excel(name = "验收开始日期", width = 15)
    @ApiModelProperty(value = "验收开始日期")
    private java.lang.String acceptanceBeginDate;
	/**验收结束日期*/
	@Excel(name = "验收结束日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "验收结束日期")
    private java.util.Date acceptanceEndDate;
	/**立项审批状态*/
	@Excel(name = "立项审批状态", width = 15, dicCode = "stsjgspzt")
	@Dict(dicCode = "stsjgspzt")
    @ApiModelProperty(value = "立项审批状态")
    private java.lang.String approvalStatus;
	/**设计审批状态*/
	@Excel(name = "设计审批状态", width = 15, dicCode = "stsjgspzt")
	@Dict(dicCode = "stsjgspzt")
    @ApiModelProperty(value = "设计审批状态")
    private java.lang.String designStatus;
	/**建设施工审批状态*/
	@Excel(name = "建设施工审批状态", width = 15, dicCode = "stsjgspzt")
	@Dict(dicCode = "stsjgspzt")
    @ApiModelProperty(value = "建设施工审批状态")
    private java.lang.String buildStatus;
	/**试生产审批状态*/
	@Excel(name = "试生产审批状态", width = 15, dicCode = "stsjgspzt")
	@Dict(dicCode = "stsjgspzt")
    @ApiModelProperty(value = "试生产审批状态")
    private java.lang.String testProductionStatus;
	/**验收审批状态*/
	@Excel(name = "验收审批状态", width = 15, dicCode = "stsjgspzt")
	@Dict(dicCode = "stsjgspzt")
    @ApiModelProperty(value = "验收审批状态")
    private java.lang.String acceptanceStatus;
	/**总体项目开始时间*/
	@Excel(name = "总体项目开始时间", width = 15)
    @ApiModelProperty(value = "总体项目开始时间")
    private java.lang.String overallProjectStartTime;
	/**总体项目结束时间*/
	@Excel(name = "总体项目结束时间", width = 15)
    @ApiModelProperty(value = "总体项目结束时间")
    private java.lang.String overallProjectEndTime;
	/**当前阶段*/
	@Excel(name = "当前阶段", width = 15)
    @ApiModelProperty(value = "当前阶段")
    private java.lang.String currentGeneration;
	/**所属阶段开始时间*/
	@Excel(name = "所属阶段开始时间", width = 15)
    @ApiModelProperty(value = "所属阶段开始时间")
    private java.lang.String designPhaseStartTime;
	/**所属阶段结束时间*/
	@Excel(name = "所属阶段结束时间", width = 15)
    @ApiModelProperty(value = "所属阶段结束时间")
    private java.lang.String designPhaseEndTime;
	/**所属阶段资料台账*/
	@Excel(name = "所属阶段资料台账", width = 15)
    @ApiModelProperty(value = "所属阶段资料台账")
    private java.lang.String designPhaseRecordsAccount;
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
