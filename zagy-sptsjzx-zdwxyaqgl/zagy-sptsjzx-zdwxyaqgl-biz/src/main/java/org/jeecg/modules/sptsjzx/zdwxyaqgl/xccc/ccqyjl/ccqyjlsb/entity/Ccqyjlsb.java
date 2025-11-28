package org.jeecg.modules.sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyjlsb.entity;

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
 * @Description: 抽查企业记录上报
 * @Author: zagy-cg
 * @Date:   2025-05-30
 * @Version: V1.0
 */
@Data
@TableName("ccqyjlsb")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ccqyjlsb对象", description="抽查企业记录上报")
public class Ccqyjlsb implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**uuid*/
	@Excel(name = "uuid", width = 15)
    @ApiModelProperty(value = "uuid")
    private java.lang.String uuid;
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
	/**生成巡查记录的行政区划*/
	@Excel(name = "生成巡查记录的行政区划", width = 15)
    @ApiModelProperty(value = "生成巡查记录的行政区划")
    private java.lang.String genAreaCode;
	/**抽查日期*/
	@Excel(name = "抽查日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "抽查日期")
    private java.util.Date patrolDate;
	/**抽查记录状态*/
	@Excel(name = "抽查记录状态", width = 15, dicCode = "ccjlzt")
	@Dict(dicCode = "ccjlzt")
    @ApiModelProperty(value = "抽查记录状态")
    private java.lang.String inspectStatus;
	/**是否要求企业反馈离线的原因*/
	@Excel(name = "是否要求企业反馈离线的原因", width = 15)
    @ApiModelProperty(value = "是否要求企业反馈离线的原因")
    private java.lang.String needOnline;
	/**是否在线*/
	@Excel(name = "是否在线", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否在线")
    private java.lang.String online;
	/**是否要求企业反馈视频离线的原因*/
	@Excel(name = "是否要求企业反馈视频离线的原因", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否要求企业反馈视频离线的原因")
    private java.lang.String needVideoOnline;
	/**是否视频在线*/
	@Excel(name = "是否视频在线", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否视频在线")
    private java.lang.String videoOnline;
	/**是否要求企业反馈预警等级高的原因*/
	@Excel(name = "是否要求企业反馈预警等级高的原因", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否要求企业反馈预警等级高的原因")
    private java.lang.String needWarnRank;
	/**预警等级*/
	@Excel(name = "预警等级", width = 15)
    @ApiModelProperty(value = "预警等级")
    private java.lang.String warnRank;
	/**是否要求企业反馈未上报安全承诺的原因*/
	@Excel(name = "是否要求企业反馈未上报安全承诺的原因", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否要求企业反馈未上报安全承诺的原因")
    private java.lang.String needCommitStatus;
	/**是否安全承诺*/
	@Excel(name = "是否安全承诺", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否安全承诺")
    private java.lang.String commitStatus;
	/**是否要求企业反馈报警多的原因*/
	@Excel(name = "是否要求企业反馈报警多的原因", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否要求企业反馈报警多的原因")
    private java.lang.String needAlarmCount;
	/**未销警数量*/
	@Excel(name = "未销警数量", width = 15)
    @ApiModelProperty(value = "未销警数量")
    private java.lang.Integer alarmCount;
	/**是否要求企业反馈最近一周预警等级高的原因*/
	@Excel(name = "是否要求企业反馈最近一周预警等级高的原因", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否要求企业反馈最近一周预警等级高的原因")
    private java.lang.String needLastWeekWarnRank;
	/**最近一周最高的预警等级*/
	@Excel(name = "最近一周最高的预警等级", width = 15, dicCode = "yjdj")
	@Dict(dicCode = "yjdj")
    @ApiModelProperty(value = "最近一周最高的预警等级")
    private java.lang.String lastWeekWarnRank;
	/**其他异常情况*/
	@Excel(name = "其他异常情况", width = 15)
    @ApiModelProperty(value = "其他异常情况")
    private java.lang.String otherContent;
	/**抽查人*/
	@Excel(name = "抽查人", width = 15)
    @ApiModelProperty(value = "抽查人")
    private java.lang.String patrolledBy;
	/**抽查时间*/
	@Excel(name = "抽查时间", width = 15)
    @ApiModelProperty(value = "抽查时间")
    private java.lang.String patrolledTime;
	/**删除标记*/
	@Excel(name = "删除标记", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标记")
    private java.lang.String status;
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
