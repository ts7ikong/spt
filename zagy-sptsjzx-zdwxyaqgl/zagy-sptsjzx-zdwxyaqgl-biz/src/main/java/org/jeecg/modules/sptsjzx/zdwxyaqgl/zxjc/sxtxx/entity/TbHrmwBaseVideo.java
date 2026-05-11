package org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.sxtxx.entity;

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
 * @Description: 摄像头信息
 * @Author: zagy-cg
 * @Date:   2026-04-22
 * @Version: V1.0
 */
@Data
@TableName("tb_hrmw_base_video")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="tb_hrmw_base_video对象", description="摄像头信息")
public class TbHrmwBaseVideo implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private String id;
	/**视频编码，是第三方的唯一约束*/
	@Excel(name = "视频编码，是第三方的唯一约束", width = 15)
    @ApiModelProperty(value = "视频编码，是第三方的唯一约束")
    private String videoCode;
	/**视频名称*/
	@Excel(name = "视频名称", width = 15)
    @ApiModelProperty(value = "视频名称")
    private String videoName;
    /**企业编码*/
    @ApiModelProperty(value = "企业编码")
    @TableField(exist = false)
    @Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    private String companyCode;

    /**区县Code*/
    @TableField(exist = false)
    @ApiModelProperty(value = "区县Code")
    @Dict(dictTable = "v_company_county", dicText = "county_name", dicCode = "code")
    private java.lang.String countyCode;
	/**视频所在位置的类型*/
	@Excel(name = "视频所在位置的类型", width = 15, dicCode = "spszwzdlx")
	@Dict(dicCode = "spszwzdlx")
    @ApiModelProperty(value = "视频所在位置的类型")
    private String videoLocaleType;
	/**排序*/
	@Excel(name = "排序", width = 15)
    @ApiModelProperty(value = "排序")
    private Integer videoSort;
	/**传输协议*/
	@Excel(name = "传输协议", width = 15)
    @ApiModelProperty(value = "传输协议")
    private String transMode;
	/**码流类型*/
	@Excel(name = "码流类型", width = 15)
    @ApiModelProperty(value = "码流类型")
    private String streamMode;
	/**监控点录像存储位置*/
	@Excel(name = "监控点录像存储位置", width = 15)
    @ApiModelProperty(value = "监控点录像存储位置")
    private String recordLocation;
	/**是否在线*/
	@Excel(name = "是否在线", width = 15, dicCode = "sxtsfzx")
	@Dict(dicCode = "sxtsfzx")
    @ApiModelProperty(value = "是否在线")
    private String online;
	/**视频url*/
	@Excel(name = "视频url", width = 15)
    @ApiModelProperty(value = "视频url")
    private String url;
	/**描述*/
	@Excel(name = "描述", width = 15)
    @ApiModelProperty(value = "描述")
    private String description;
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
	/**提交到部里用的共享国标编码*/
	@Excel(name = "提交到部里用的共享国标编码", width = 15)
    @ApiModelProperty(value = "提交到部里用的共享国标编码")
    private String gbCode;
	/**视频数据来源*/
	@Excel(name = "视频数据来源", width = 15, dicCode = "spsjly")
	@Dict(dicCode = "spsjly")
    @ApiModelProperty(value = "视频数据来源")
    private String dataSource;
	/**第三方视频区域编码*/
	@Excel(name = "第三方视频区域编码", width = 15)
    @ApiModelProperty(value = "第三方视频区域编码")
    private String regionCode;
	/**录像计划启停用状态*/
	@Excel(name = "录像计划启停用状态", width = 15, dicCode = "lxjhqtyzt")
	@Dict(dicCode = "lxjhqtyzt")
    @ApiModelProperty(value = "录像计划启停用状态")
    private String recordPlanStatus;
	/**关联的日常录像计划id*/
	@Excel(name = "关联的日常录像计划id", width = 15)
    @ApiModelProperty(value = "关联的日常录像计划id")
    private String recordPlanId;
	/**最近在线更新时间*/
	@Excel(name = "最近在线更新时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最近在线更新时间")
    private Date onlineUpdateTime;
	/**最近一次填报的离线原因*/
	@Excel(name = "最近一次填报的离线原因", width = 15)
    @ApiModelProperty(value = "最近一次填报的离线原因")
    private String offlineReason;
	/**最近一次填报的计划上线时间*/
	@Excel(name = "最近一次填报的计划上线时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最近一次填报的计划上线时间")
    private Date planOnlineTime;
	/**附件的文件路径*/
	@Excel(name = "附件的文件路径", width = 15)
    @ApiModelProperty(value = "附件的文件路径")
    private String attachFilePath;
	/**附件的文件名*/
	@Excel(name = "附件的文件名", width = 15)
    @ApiModelProperty(value = "附件的文件名")
    private String attachFileName;
	/**附件的文件后缀*/
	@Excel(name = "附件的文件后缀", width = 15)
    @ApiModelProperty(value = "附件的文件后缀")
    private String attachFileFormat;
	/**最近一次离线id*/
	@Excel(name = "最近一次离线id", width = 15)
    @ApiModelProperty(value = "最近一次离线id")
    private String offlineId;
	/**所属园区*/
	@Excel(name = "所属园区", width = 15)
    @ApiModelProperty(value = "所属园区")
    private String parkCode;
	/**离线时间*/
	@Excel(name = "离线时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "离线时间")
    private Date offlineTime;
}
