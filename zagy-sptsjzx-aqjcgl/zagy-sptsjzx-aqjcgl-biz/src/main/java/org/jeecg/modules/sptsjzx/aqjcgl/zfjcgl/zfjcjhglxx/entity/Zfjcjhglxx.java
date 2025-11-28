package org.jeecg.modules.sptsjzx.aqjcgl.zfjcgl.zfjcjhglxx.entity;

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
 * @Description: 执法检查计划管理信息
 * @Author: zagy-cg
 * @Date:   2025-05-30
 * @Version: V1.0
 */
@Data
@TableName("zfjcjhglxx")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="zfjcjhglxx对象", description="执法检查计划管理信息")
public class Zfjcjhglxx implements Serializable {
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
	/**执法检查单位*/
	@Excel(name = "执法检查单位", width = 15)
    @ApiModelProperty(value = "执法检查单位")
    private java.lang.String enforcementUnit;
	/**执法检查编号*/
	@Excel(name = "执法检查编号", width = 15)
    @ApiModelProperty(value = "执法检查编号")
    private java.lang.String enforcementId;
	/**执法检查计划类型*/
	@Excel(name = "执法检查计划类型", width = 15, dicCode = "zfjcjhlx")
	@Dict(dicCode = "zfjcjhlx")
    @ApiModelProperty(value = "执法检查计划类型")
    private java.lang.String enforcementType;
	/**执法检查开始时间*/
	@Excel(name = "执法检查开始时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "执法检查开始时间")
    private java.util.Date enforcementStartTime;
	/**执法检查结束时间*/
	@Excel(name = "执法检查结束时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "执法检查结束时间")
    private java.util.Date enforcementEndTime;
	/**是否明察暗访*/
	@Excel(name = "是否明察暗访", width = 15, dicCode = "sfmcaf")
	@Dict(dicCode = "sfmcaf")
    @ApiModelProperty(value = "是否明察暗访")
    private java.lang.String isCovertInspection;
	/**是否举报核实*/
	@Excel(name = "是否举报核实", width = 15, dicCode = "sfmcaf")
	@Dict(dicCode = "sfmcaf")
    @ApiModelProperty(value = "是否举报核实")
    private java.lang.String isReportVerification;
	/**执法检查任务描述*/
	@Excel(name = "执法检查任务描述", width = 15)
    @ApiModelProperty(value = "执法检查任务描述")
    private java.lang.String lawEnTaskDes;
	/**执法检查状态*/
	@Excel(name = "执法检查状态", width = 15, dicCode = "zfjczt")
	@Dict(dicCode = "zfjczt")
    @ApiModelProperty(value = "执法检查状态")
    private java.lang.String lawEnTaskStatus;
	/**执法检查任务附件*/
	@Excel(name = "执法检查任务附件", width = 15)
    @ApiModelProperty(value = "执法检查任务附件")
    private java.lang.String lawEnTaskMission;
	/**发起人姓名*/
	@Excel(name = "发起人姓名", width = 15)
    @ApiModelProperty(value = "发起人姓名")
    private java.lang.String initiatorName;
	/**发起时间*/
	@Excel(name = "发起时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发起时间")
    private java.util.Date nitiatorTime;
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
