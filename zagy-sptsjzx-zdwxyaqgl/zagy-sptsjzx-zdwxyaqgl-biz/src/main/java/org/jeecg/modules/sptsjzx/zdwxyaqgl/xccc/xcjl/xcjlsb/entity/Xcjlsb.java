package org.jeecg.modules.sptsjzx.zdwxyaqgl.xccc.xcjl.xcjlsb.entity;

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
 * @Description: 巡查记录上报
 * @Author: zagy-cg
 * @Date:   2025-05-30
 * @Version: V1.0
 */
@Data
@TableName("xcjlsb")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="xcjlsb对象", description="巡查记录上报")
public class Xcjlsb implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**uuid*/
	@Excel(name = "uuid", width = 15)
    @ApiModelProperty(value = "uuid")
    private java.lang.String uuid;
	/**巡查记录日期*/
	@Excel(name = "巡查记录日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "巡查记录日期")
    private java.util.Date inspectDate;
	/**巡查记录编码*/
	@Excel(name = "巡查记录编码", width = 15)
    @ApiModelProperty(value = "巡查记录编码")
    private java.lang.String inspectCode;
	/**巡查记录状态*/
	@Excel(name = "巡查记录状态", width = 15, dicCode = "xcjlzt")
	@Dict(dicCode = "xcjlzt")
    @ApiModelProperty(value = "巡查记录状态")
    private java.lang.String inspectStatus;
	/**生成巡查记录的行政区划*/
	@Excel(name = "生成巡查记录的行政区划", width = 15)
    @ApiModelProperty(value = "生成巡查记录的行政区划")
    private java.lang.String genAreaCode;
	/**接受巡查的行政区划*/
	@Excel(name = "接受巡查的行政区划", width = 15)
    @ApiModelProperty(value = "接受巡查的行政区划")
    private java.lang.String areaCode;
	/**是否需要下级单位反馈视频在线情况*/
	@Excel(name = "是否需要下级单位反馈视频在线情况", width = 15)
    @ApiModelProperty(value = "是否需要下级单位反馈视频在线情况")
    private java.lang.String needOnline;
	/**在线率*/
	@Excel(name = "在线率", width = 15)
    @ApiModelProperty(value = "在线率")
    private java.math.BigDecimal onlineRate;
	/**在线率排名*/
	@Excel(name = "在线率排名", width = 15)
    @ApiModelProperty(value = "在线率排名")
    private java.lang.Integer onlineSort;
	/**是否需要下级单位反馈安全承诺情况*/
	@Excel(name = "是否需要下级单位反馈安全承诺情况", width = 15)
    @ApiModelProperty(value = "是否需要下级单位反馈安全承诺情况")
    private java.lang.String needVideoOnline;
	/**视频在线率*/
	@Excel(name = "视频在线率", width = 15)
    @ApiModelProperty(value = "视频在线率")
    private java.math.BigDecimal videoOnlineRate;
	/**视频在线率 排名*/
	@Excel(name = "视频在线率 排名", width = 15)
    @ApiModelProperty(value = "视频在线率 排名")
    private java.lang.Integer videoOnlineSort;
	/**是否需要下级单位反馈 安全承诺情况*/
	@Excel(name = "是否需要下级单位反馈 安全承诺情况", width = 15)
    @ApiModelProperty(value = "是否需要下级单位反馈 安全承诺情况")
    private java.lang.String needPromise;
	/**安全承诺率*/
	@Excel(name = "安全承诺率", width = 15)
    @ApiModelProperty(value = "安全承诺率")
    private java.math.BigDecimal promiseRate;
	/**安全承诺排名*/
	@Excel(name = "安全承诺排名", width = 15)
    @ApiModelProperty(value = "安全承诺排名")
    private java.lang.Integer promiseSort;
	/**是否需要下级单位反馈未销警情况*/
	@Excel(name = "是否需要下级单位反馈未销警情况", width = 15)
    @ApiModelProperty(value = "是否需要下级单位反馈未销警情况")
    private java.lang.String needLatestAlarm;
	/**近24小时未销警指标 数*/
	@Excel(name = "近24小时未销警指标 数", width = 15)
    @ApiModelProperty(value = "近24小时未销警指标 数")
    private java.lang.Integer latestAlarmTargetCount;
	/**近24小时未销警时长*/
	@Excel(name = "近24小时未销警时长", width = 15)
    @ApiModelProperty(value = "近24小时未销警时长")
    private java.lang.String latestAlarmTargetInterval;
	/**是否需要下级单位反馈预警情况*/
	@Excel(name = "是否需要下级单位反馈预警情况", width = 15)
    @ApiModelProperty(value = "是否需要下级单位反馈预警情况")
    private java.lang.String needWarn;
	/**预警未销警数量*/
	@Excel(name = "预警未销警数量", width = 15)
    @ApiModelProperty(value = "预警未销警数量")
    private java.lang.Integer warnCount;
	/**预警未反馈数量*/
	@Excel(name = "预警未反馈数量", width = 15)
    @ApiModelProperty(value = "预警未反馈数量")
    private java.lang.Integer warnNoRespCount;
	/**警示通报未反馈数量*/
	@Excel(name = "警示通报未反馈数量", width = 15)
    @ApiModelProperty(value = "警示通报未反馈数量")
    private java.lang.Integer warnNoticeNoRespCount;
	/**其他巡查内容*/
	@Excel(name = "其他巡查内容", width = 15)
    @ApiModelProperty(value = "其他巡查内容")
    private java.lang.String otherContent;
	/**反馈时间*/
	@Excel(name = "反馈时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "反馈时间")
    private java.util.Date feedbackTime;
	/**联系人*/
	@Excel(name = "联系人", width = 15)
    @ApiModelProperty(value = "联系人")
    private java.lang.String contactor;
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
	/**最后修改时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后修改时间")
    private java.util.Date updateTime;
	/**最后修改人*/
    @ApiModelProperty(value = "最后修改人")
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
