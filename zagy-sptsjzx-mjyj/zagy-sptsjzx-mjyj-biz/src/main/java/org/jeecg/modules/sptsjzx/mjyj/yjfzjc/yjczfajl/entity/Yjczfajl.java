package org.jeecg.modules.sptsjzx.mjyj.yjfzjc.yjczfajl.entity;

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
 * @Description: 应急处置方案记录
 * @Author: zagy-cg
 * @Date:   2025-06-03
 * @Version: V1.0
 */
@Data
@TableName("yjczfajl")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="yjczfajl对象", description="应急处置方案记录")
public class Yjczfajl implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;
	/**园区编码*/
	@Excel(name = "园区编码", width = 15, dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
	@Dict(dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @ApiModelProperty(value = "园区编码")
    private String parkCode;
	/**UUID*/
	@Excel(name = "UUID", width = 15)
    @ApiModelProperty(value = "UUID")
    private String uuid;
	/**事故编号*/
	@Excel(name = "事故编号", width = 15)
    @ApiModelProperty(value = "事故编号")
    private String accidentCode;
	/**预案编码*/
	@Excel(name = "预案编码", width = 15, dictTable = "yjyaxx", dicText = "emergence_plan_name", dicCode = "emergence_plan_id")
	@Dict(dictTable = "yjyaxx", dicText = "emergence_plan_name", dicCode = "emergence_plan_id")
    @ApiModelProperty(value = "预案编码")
    private String emergencePlanId;
	/**应急资源编码*/
	@Excel(name = "应急资源编码", width = 15, dictTable = "yjwzjcxx", dicText = "material_name", dicCode = "material_id")
	@Dict(dictTable = "yjwzjcxx", dicText = "material_name", dicCode = "material_id")
    @ApiModelProperty(value = "应急资源编码")
    private String materialId;
	/**应急队伍编码*/
	@Excel(name = "应急队伍编码", width = 15, dictTable = "yjjydwxx", dicText = "unit_name", dicCode = "unit_id")
	@Dict(dictTable = "yjjydwxx", dicText = "unit_name", dicCode = "unit_id")
    @ApiModelProperty(value = "应急队伍编码")
    private String unitId;
	/**避难场所编码*/
	@Excel(name = "避难场所编码", width = 15, dictTable = "yjbncsxx", dicText = "shelter_name", dicCode = "shelter_id")
	@Dict(dictTable = "yjbncsxx", dicText = "shelter_name", dicCode = "shelter_id")
    @ApiModelProperty(value = "避难场所编码")
    private String shelterId;
	/**机构编码*/
	@Excel(name = "机构编码", width = 15, dictTable = "ylzyxx", dicText = "institution_name", dicCode = "institution_id")
	@Dict(dictTable = "ylzyxx", dicText = "institution_name", dicCode = "institution_id")
    @ApiModelProperty(value = "机构编码")
    private String institutionId;
	/**接警编码*/
	@Excel(name = "接警编码", width = 15, dictTable = "jjjl", dicText = "accident_name", dicCode = "serial_code")
	@Dict(dictTable = "jjjl", dicText = "accident_name", dicCode = "serial_code")
    @ApiModelProperty(value = "接警编码")
    private String serialCode;
	/**专家编码*/
	@Excel(name = "专家编码", width = 15, dictTable = "yjzjxx", dicText = "expert_name", dicCode = "expert_id")
	@Dict(dictTable = "yjzjxx", dicText = "expert_name", dicCode = "expert_id")
    @ApiModelProperty(value = "专家编码")
    private String expertId;
	/**事故日期时间*/
	@Excel(name = "事故日期时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "事故日期时间")
    private Date accidentTime;
	/**事故概况*/
	@Excel(name = "事故概况", width = 15)
    @ApiModelProperty(value = "事故概况")
    private String accidentOverview;
	/**现场图片*/
	@Excel(name = "现场图片", width = 15)
    @ApiModelProperty(value = "现场图片")
    private String annex;
	/**总指挥*/
	@Excel(name = "总指挥", width = 15)
    @ApiModelProperty(value = "总指挥")
    private String generalCommander;
	/**副总指挥*/
	@Excel(name = "副总指挥", width = 15)
    @ApiModelProperty(value = "副总指挥")
    private String deputyCommander;
	/**现场指挥长*/
	@Excel(name = "现场指挥长", width = 15)
    @ApiModelProperty(value = "现场指挥长")
    private String onSiteCommander;
	/**现场副指挥长*/
	@Excel(name = "现场副指挥长", width = 15)
    @ApiModelProperty(value = "现场副指挥长")
    private String deputyOnSiteCommander;
	/**现场响应小组*/
	@Excel(name = "现场响应小组", width = 15)
    @ApiModelProperty(value = "现场响应小组")
    private String responseTeam;
	/**现场处置措施建议*/
	@Excel(name = "现场处置措施建议", width = 15)
    @ApiModelProperty(value = "现场处置措施建议")
    private String dispositionGuidance;
	/**个体防护处置建议*/
	@Excel(name = "个体防护处置建议", width = 15)
    @ApiModelProperty(value = "个体防护处置建议")
    private String personalprotectionGuidance;
	/**其他注意事项*/
	@Excel(name = "其他注意事项", width = 15)
    @ApiModelProperty(value = "其他注意事项")
    private String note;
	/**删除标志*/
	@Excel(name = "删除标志", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标志")
    private String deleted;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private Date createTime;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private Date updateTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private String updateBy;
	/**创建日期_企业*/
	@Excel(name = "创建日期_企业", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期_企业")
    private Date createTimeCompany;
	/**创建人_企业*/
	@Excel(name = "创建人_企业", width = 15)
    @ApiModelProperty(value = "创建人_企业")
    private String createByCompany;
	/**更新日期_企业*/
	@Excel(name = "更新日期_企业", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期_企业")
    private Date updateTimeCompany;
	/**更新人_企业*/
	@Excel(name = "更新人_企业", width = 15)
    @ApiModelProperty(value = "更新人_企业")
    private String updateByCompany;
}
