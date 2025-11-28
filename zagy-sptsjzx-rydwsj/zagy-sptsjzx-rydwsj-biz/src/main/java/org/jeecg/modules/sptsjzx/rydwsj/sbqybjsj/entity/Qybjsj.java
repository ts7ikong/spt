package org.jeecg.modules.sptsjzx.rydwsj.sbqybjsj.entity;

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
 * @Description: 上报区域报警数据
 * @Author: zagy-cg
 * @Date:   2025-06-26
 * @Version: V1.0
 */
@Data
@TableName("qybjsj")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="qybjsj对象", description="上报区域报警数据")
public class Qybjsj implements Serializable {
    private static final long serialVersionUID = 1L;

	/**序号*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "序号")
    private java.lang.Integer id;
	/**企业名称*/
	@Excel(name = "企业名称", width = 15, dictTable = "v_accept_company", dicText = "name", dicCode = "code")
	@Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @ApiModelProperty(value = "企业名称")
    private java.lang.String companyCode;
	/**人员基础信息id*/
	@Excel(name = "人员基础信息id", width = 15)
    @ApiModelProperty(value = "人员基础信息id")
    private java.lang.String personId;
	/**区域边界*/
	@Excel(name = "区域边界", width = 15, dictTable = "v_zone_geo", dicText = "zone_name", dicCode = "uuid")
	@Dict(dictTable = "v_zone_geo", dicText = "zone_name", dicCode = "uuid")
    @ApiModelProperty(value = "区域边界")
    private java.lang.String zoneId;
	/**报警类型*/
	@Excel(name = "报警类型", width = 15, dicCode = "rydwbjlx")
	@Dict(dicCode = "rydwbjlx")
    @ApiModelProperty(value = "报警类型")
    private java.lang.String alarmType;
	/**报警时间*/
	@Excel(name = "报警时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "报警时间")
    private java.util.Date alarmTime;
	/**销警时间*/
	@Excel(name = "销警时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "销警时间")
    private java.util.Date dispelTime;
	/**报警描述*/
	@Excel(name = "报警描述", width = 15)
    @ApiModelProperty(value = "报警描述")
	@TableField("`describe`")
    private java.lang.String describe;
	/**删除标志*/
	@Excel(name = "删除标志", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标志")
    private java.lang.String deleted;
	/**主键uuid*/
	@Excel(name = "主键uuid", width = 15)
    @ApiModelProperty(value = "主键uuid")
    private java.lang.String uuid;
	/**进表时间*/
    @ApiModelProperty(value = "进表时间")
    private java.lang.String createTime;
	/**应急部返回batch编码*/
	@Excel(name = "应急部返回batch编码", width = 15)
    @ApiModelProperty(value = "应急部返回batch编码")
    private java.lang.String batchId;
	/**我们返回企业的batch编码*/
	@Excel(name = "我们返回企业的batch编码", width = 15)
    @ApiModelProperty(value = "我们返回企业的batch编码")
    private java.lang.String wbatchId;
}
