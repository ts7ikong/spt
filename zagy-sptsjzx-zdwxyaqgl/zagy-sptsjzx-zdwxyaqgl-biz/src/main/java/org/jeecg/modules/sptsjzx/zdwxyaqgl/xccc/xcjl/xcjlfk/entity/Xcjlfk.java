package org.jeecg.modules.sptsjzx.zdwxyaqgl.xccc.xcjl.xcjlfk.entity;

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
 * @Description: 巡查记录反馈
 * @Author: zagy-cg
 * @Date:   2025-05-30
 * @Version: V1.0
 */
@Data
@TableName("xcjlfk")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="xcjlfk对象", description="巡查记录反馈")
public class Xcjlfk implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**uuid*/
	@Excel(name = "uuid", width = 15)
    @ApiModelProperty(value = "uuid")
    private java.lang.String uuid;
	/**巡查记录ID*/
	@Excel(name = "巡查记录ID", width = 15)
    @ApiModelProperty(value = "巡查记录ID")
    private java.lang.String inspectId;
	/**巡查记录反馈的类型*/
	@Excel(name = "巡查记录反馈的类型", width = 15, dicCode = "xcjlfkdlx")
	@Dict(dicCode = "xcjlfkdlx")
    @ApiModelProperty(value = "巡查记录反馈的类型")
    private java.lang.String replyType;
	/**情况说明*/
	@Excel(name = "情况说明", width = 15)
    @ApiModelProperty(value = "情况说明")
    private java.lang.String situation;
	/**处置措施*/
	@Excel(name = "处置措施", width = 15)
    @ApiModelProperty(value = "处置措施")
    private java.lang.String measure;
	/**补充信息*/
	@Excel(name = "补充信息", width = 15)
    @ApiModelProperty(value = "补充信息")
    private java.lang.String otherInfo;
	/**延期说明*/
	@Excel(name = "延期说明", width = 15)
    @ApiModelProperty(value = "延期说明")
    private java.lang.String delayInfo;
	/**延期日期*/
	@Excel(name = "延期日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "延期日期")
    private java.util.Date delayDate;
	/**计划完成日期*/
	@Excel(name = "计划完成日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "计划完成日期")
    private java.util.Date planDate;
	/**是否已完成*/
	@Excel(name = "是否已完成", width = 15, dicCode = "sfywc")
	@Dict(dicCode = "sfywc")
    @ApiModelProperty(value = "是否已完成")
    private java.lang.String isFinish;
	/**删除标记*/
	@Excel(name = "删除标记", width = 15)
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
