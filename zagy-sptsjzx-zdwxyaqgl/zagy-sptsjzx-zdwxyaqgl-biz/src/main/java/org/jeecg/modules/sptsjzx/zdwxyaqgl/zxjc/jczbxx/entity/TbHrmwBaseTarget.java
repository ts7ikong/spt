package org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.jczbxx.entity;

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
 * @Description: 监测指标信息
 * @Author: zagy-cg
 * @Date: 2026-04-21
 * @Version: V1.0
 */
@Data
@TableName("v_hrmw_target_with_company")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "tb_hrmw_base_target对象", description = "监测指标信息")
public class TbHrmwBaseTarget implements Serializable {
    private static final long serialVersionUID = 1L;

    /**id*/
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
    /**指标编码*/
    @Excel(name = "指标编码", width = 15)
    @ApiModelProperty(value = "指标编码")
    private java.lang.String targetCode;
    /**指标名称*/
    @Excel(name = "指标名称", width = 15)
    @ApiModelProperty(value = "指标名称")
    private java.lang.String targetName;
    /**设备编码*/
    @Excel(name = "设备编码", width = 15)
    @ApiModelProperty(value = "设备编码")
    private java.lang.String equipCode;
    /**指标类型*/
    @Excel(name = "指标类型", width = 15, dicCode = "zblx")
    @Dict(dicCode = "zblx")
    @ApiModelProperty(value = "指标类型")
    private java.lang.String targetType;
    /**二级阈值下限，低低报*/
    @Excel(name = "二级阈值下限，低低报", width = 15)
    @ApiModelProperty(value = "二级阈值下限，低低报")
    private java.math.BigDecimal thresholdDown2;
    /**一级阈值下限，低报*/
    @Excel(name = "一级阈值下限，低报", width = 15)
    @ApiModelProperty(value = "一级阈值下限，低报")
    private java.math.BigDecimal thresholdDown;
    /**一级阈值上限，高报*/
    @Excel(name = "一级阈值上限，高报", width = 15)
    @ApiModelProperty(value = "一级阈值上限，高报")
    private java.math.BigDecimal thresholdUp;
    /**二级阈值上限，高高报*/
    @Excel(name = "二级阈值上限，高高报", width = 15)
    @ApiModelProperty(value = "二级阈值上限，高高报")
    private java.math.BigDecimal thresholdUp2;
    /**量程上限*/
    @Excel(name = "量程上限", width = 15)
    @ApiModelProperty(value = "量程上限")
    private java.math.BigDecimal rangeUp;
    /**量程下限*/
    @Excel(name = "量程下限", width = 15)
    @ApiModelProperty(value = "量程下限")
    private java.math.BigDecimal rangeDown;
    /**计量单位*/
    @Excel(name = "计量单位", width = 15)
    @ApiModelProperty(value = "计量单位")
    private java.lang.String unit;
    /**位号*/
    @Excel(name = "位号", width = 15)
    @ApiModelProperty(value = "位号")
    private java.lang.String localeNo;
    /**上报的数据类型*/
    @Excel(name = "上报的数据类型", width = 15)
    @ApiModelProperty(value = "上报的数据类型")
    private java.lang.String dataType;
    /**描述*/
    @Excel(name = "描述", width = 15)
    @ApiModelProperty(value = "描述")
    private java.lang.String description;
    /**是否删除*/
    @Excel(name = "是否删除", width = 15, dicCode = "zbsfsc")
    @Dict(dicCode = "zbsfsc")
    @ApiModelProperty(value = "是否删除")
    private java.lang.String deleted;
    /**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
    /**创建时间*/
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createTime;
    /**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
    /**更新时间*/
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private java.util.Date updateTime;
    /**指标接入日期，亦是指标首次采集时间*/
    @Excel(name = "指标接入日期，亦是指标首次采集时间", width = 15, format = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "指标接入日期，亦是指标首次采集时间")
    private java.util.Date linkedDate;
    /**接入状态*/
    @Excel(name = "接入状态", width = 15, dicCode = "zbjrzt")
    @Dict(dicCode = "zbjrzt")
    @ApiModelProperty(value = "接入状态")
    private java.lang.String linked;
    /**审核状态*/
    @Excel(name = "审核状态", width = 15, dicCode = "zbshzt")
    @Dict(dicCode = "zbshzt")
    @ApiModelProperty(value = "审核状态")
    private java.lang.String auditStatus;
    /**最后的审核时间*/
    @Excel(name = "最后的审核时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后的审核时间")
    private java.util.Date auditTime;
    /**数据完善状态*/
    @Excel(name = "数据完善状态", width = 15, dicCode = "sjwszt")
    @Dict(dicCode = "sjwszt")
    @ApiModelProperty(value = "数据完善状态")
    private java.lang.String completeStatus;
    /**数据来源*/
    @Excel(name = "数据来源", width = 15, dicCode = "sjly")
    @Dict(dicCode = "sjly")
    @ApiModelProperty(value = "数据来源")
    private java.lang.String dataSource;
    /**量程或阈值是否填写有误*/
    @Excel(name = "量程或阈值是否填写有误", width = 15, dicCode = "lchyzsftxyw")
    @Dict(dicCode = "lchyzsftxyw")
    @ApiModelProperty(value = "量程或阈值是否填写有误")
    private java.lang.Boolean rangeError;
    /**指标信息变更状态*/
    @Excel(name = "指标信息变更状态", width = 15, dicCode = "zbxxbgzt")
    @Dict(dicCode = "zbxxbgzt")
    @ApiModelProperty(value = "指标信息变更状态")
    private java.lang.String targetSubStatus;

    /**企业编码*/
    @ApiModelProperty(value = "企业编码")
    @Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    private String companyCode;

    /**区县Code*/
    @TableField(exist = false)
    @ApiModelProperty(value = "区县Code")
    @Dict(dictTable = "v_company_county", dicText = "county_name", dicCode = "code")
    private java.lang.String countyCode;
}
