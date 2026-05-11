package org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.spznfxbjsj.entity;

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
 * @Description: 视频智能分析报警数据
 * @Author: zagy-cg
 * @Date:   2026-04-22
 * @Version: V1.0
 */
@Data
@TableName("v_hrmw_video_alarm_with_company")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="tb_hrmw_moni_video_alarm对象", description="视频智能分析报警数据")
public class TbHrmwMoniVideoAlarm implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private String id;

	/**企业编码*/
	@ApiModelProperty(value = "企业编码")
	@Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
	private String companyCode;

	/**区县Code*/
	@TableField(exist = false)
	@ApiModelProperty(value = "区县Code")
	@Dict(dictTable = "v_company_county", dicText = "county_name", dicCode = "code")
	private java.lang.String countyCode;

	/**视频编码*/
	@Excel(name = "视频编码", width = 15)
    @ApiModelProperty(value = "视频编码")
    private String videoCode;
	/**视频类型*/
	@Excel(name = "视频类型", width = 15, dicCode = "sxtlx")
	@Dict(dicCode = "sxtlx")
    @ApiModelProperty(value = "视频类型")
    private String videoType;
	/**视频报警时间*/
	@Excel(name = "视频报警时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "视频报警时间")
    private Date alarmTime;
	/**视频报警类型*/
	@Excel(name = "视频报警类型", width = 15, dicCode = "spznfxbjlx")
	@Dict(dicCode = "spznfxbjlx")
    @ApiModelProperty(value = "视频报警类型")
    private String alarmType;
	/**视频报警动作*/
	@Excel(name = "视频报警动作", width = 15)
    @ApiModelProperty(value = "视频报警动作")
    private String alarmAction;
	/**视频报警脉冲频率*/
	@Excel(name = "视频报警脉冲频率", width = 15)
    @ApiModelProperty(value = "视频报警脉冲频率")
    private Integer alarmFrequency;
	/**报警截图保存路径*/
	@Excel(name = "报警截图保存路径", width = 15)
    @ApiModelProperty(value = "报警截图保存路径")
    private String picUrl;
	/**图片存储唯一标识*/
	@Excel(name = "图片存储唯一标识", width = 15)
    @ApiModelProperty(value = "图片存储唯一标识")
    private String svrIndexCode;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
	/**报警截图Base64编码*/
	@Excel(name = "报警截图Base64编码", width = 15)
    @ApiModelProperty(value = "报警截图Base64编码")
    private String picBase64;
	/**设备编码，不是视频编码*/
	@Excel(name = "设备编码，不是视频编码", width = 15)
    @ApiModelProperty(value = "设备编码，不是视频编码")
    private String deviceCode;
	/**报警图片文件的绝对路径（含文件名）*/
	@Excel(name = "报警图片文件的绝对路径（含文件名）", width = 15)
    @ApiModelProperty(value = "报警图片文件的绝对路径（含文件名）")
    private String imgUri;
	/**报警视频文件的绝对路径（含文件名）*/
	@Excel(name = "报警视频文件的绝对路径（含文件名）", width = 15)
    @ApiModelProperty(value = "报警视频文件的绝对路径（含文件名）")
    private String videoUri;
	/**是否销警*/
	@Excel(name = "是否销警", width = 15, dicCode = "sfxj")
	@Dict(dicCode = "sfxj")
    @ApiModelProperty(value = "是否销警")
    private String isDispel;
	/**销警时间*/
	@Excel(name = "销警时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "销警时间")
    private Date dispelTime;
	/**是否删除*/
	@Excel(name = "是否删除", width = 15, dicCode = "sfsc")
	@Dict(dicCode = "sfsc")
    @ApiModelProperty(value = "是否删除")
    private String deleted;
}
