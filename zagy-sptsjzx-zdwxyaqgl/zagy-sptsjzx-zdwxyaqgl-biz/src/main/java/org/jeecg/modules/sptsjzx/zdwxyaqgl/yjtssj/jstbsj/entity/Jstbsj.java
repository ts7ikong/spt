package org.jeecg.modules.sptsjzx.zdwxyaqgl.yjtssj.jstbsj.entity;

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
 * @Description: 警示通报数据
 * @Author: zagy-cg
 * @Date:   2025-05-30
 * @Version: V1.0
 */
@Data
@TableName("jstbsj")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="jstbsj对象", description="警示通报数据")
public class Jstbsj implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**UUID*/
	@Excel(name = "UUID", width = 15)
    @ApiModelProperty(value = "UUID")
    private java.lang.String uuid;
	/**园区编号*/
	@Excel(name = "园区编号", width = 15)
    @ApiModelProperty(value = "园区编号")
    private java.lang.String parkCode;
	/**警示通报编码*/
	@Excel(name = "警示通报编码", width = 15)
    @ApiModelProperty(value = "警示通报编码")
    private java.lang.String noticeCode;
	/**预警事件 ID*/
	@Excel(name = "预警事件 ID", width = 15)
    @ApiModelProperty(value = "预警事件 ID")
    private java.lang.String warningId;
	/**警示通报内容*/
	@Excel(name = "警示通报内容", width = 15)
    @ApiModelProperty(value = "警示通报内容")
    private java.lang.String content;
	/**原因*/
	@Excel(name = "原因", width = 15)
    @ApiModelProperty(value = "原因")
    private java.lang.String reason;
	/**处置措施*/
	@Excel(name = "处置措施", width = 15)
    @ApiModelProperty(value = "处置措施")
    private java.lang.String measure;
	/**发送方的组织编码*/
	@Excel(name = "发送方的组织编码", width = 15)
    @ApiModelProperty(value = "发送方的组织编码")
    private java.lang.String fromOrgCode;
	/**接收方的组织编码*/
	@Excel(name = "接收方的组织编码", width = 15)
    @ApiModelProperty(value = "接收方的组织编码")
    private java.lang.String toOrgCode;
	/**删除标志*/
	@Excel(name = "删除标志", width = 15)
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
