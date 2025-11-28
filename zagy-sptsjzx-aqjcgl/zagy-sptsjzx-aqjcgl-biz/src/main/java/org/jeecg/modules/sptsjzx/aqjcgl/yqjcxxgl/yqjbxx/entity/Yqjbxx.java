package org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.yqjbxx.entity;

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
 * @Description: 园区基本信息
 * @Author: zagy-cg
 * @Date: 2025-05-29
 * @Version: V1.0
 */
@Data
@TableName("yqjbxx")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "yqjbxx对象", description = "园区基本信息")
public class Yqjbxx implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
    /**
     * 数据id
     */
    @Excel(name = "数据id", width = 15)
    @ApiModelProperty(value = "数据id")
    private java.lang.String uuid;
    /**
     * 园区编码
     */
    @Excel(name = "园区编码", width = 15)
    @ApiModelProperty(value = "园区编码")
    private java.lang.String parkCode;
    /**
     * 园区名称
     */
    @Excel(name = "园区名称", width = 15)
    @ApiModelProperty(value = "园区名称")
    private java.lang.String parkName;
    /**
     * 园区行政区划编码
     */
    @Excel(name = "园区行政区划编码", width = 15)
    @ApiModelProperty(value = "园区行政区划编码")
    private java.lang.String parkAreaCode;
    /**
     * 园区行政区划名称
     */
    @Excel(name = "园区行政区划名称", width = 25)
    @ApiModelProperty(value = "园区行政区划名称")
    private java.lang.String parkAreaName;
    /**
     * 园区地址
     */
    @Excel(name = "园区地址", width = 15)
    @ApiModelProperty(value = "园区地址")
    private java.lang.String address;
    /**
     * 园区负责人
     */
    @Excel(name = "园区负责人", width = 15)
    @ApiModelProperty(value = "园区负责人")
    private java.lang.String responsible;
    /**
     * 园区负责人手机号
     */
    @Excel(name = "园区负责人手机号", width = 15)
    @ApiModelProperty(value = "园区负责人手机号")
    private java.lang.String responsibleMobile;
    /**
     * 园区分管安全负责人
     */
    @Excel(name = "园区分管安全负责人", width = 15)
    @ApiModelProperty(value = "园区分管安全负责人")
    private java.lang.String safetyreSponsible;
    /**
     * 园区分管安全负责人手机号
     */
    @Excel(name = "园区分管安全负责人手机号", width = 15)
    @ApiModelProperty(value = "园区分管安全负责人手机号")
    private java.lang.String safetyreSponsibleMobile;
    /**
     * 园区信息采集经办人
     */
    @Excel(name = "园区信息采集经办人", width = 15)
    @ApiModelProperty(value = "园区信息采集经办人")
    private java.lang.String operatorResponsible;
    /**
     * 园区信息采集经办人手机号
     */
    @Excel(name = "园区信息采集经办人手机号", width = 15)
    @ApiModelProperty(value = "园区信息采集经办人手机号")
    private java.lang.String operatorResponsibleMobile;
    /**
     * 安全风险评估复核等级
     */
    @Excel(name = "安全风险评估复核等级", width = 15)
    @ApiModelProperty(value = "安全风险评估复核等级")
    private java.lang.String safetyRiskLevel;
    /**
     * 安全风险评估复核日期
     */
    @Excel(name = "安全风险评估复核日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "安全风险评估复核日期")
    private java.util.Date safetyRiskDate;
    /**
     * 经度
     */
    @Excel(name = "经度", width = 15)
    @ApiModelProperty(value = "经度")
    private java.lang.Double longitude;
    /**
     * 纬度
     */
    @Excel(name = "纬度", width = 15)
    @ApiModelProperty(value = "纬度")
    private java.lang.Double latitude;
    /**
     * 边界地理信息
     */
    @Excel(name = "边界地理信息", width = 15)
    @ApiModelProperty(value = "边界地理信息")
    private java.lang.String rangeGeometryData;
    /**
     * 删除标志
     */
    @Excel(name = "删除标志", width = 15, dicCode = "scbz")
    @Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标志")
    private java.lang.String status;
    /**
     * 创建日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
    /**
     * 更新日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
    /**
     * 创建日期_企业
     */
    @Excel(name = "创建日期_企业", width = 20, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期_企业")
    private java.util.Date createTimeCompany;
    /**
     * 创建人_企业
     */
    @Excel(name = "创建人_企业", width = 15)
    @ApiModelProperty(value = "创建人_企业")
    private java.lang.String createByCompany;
    /**
     * 更新日期_企业
     */
    @Excel(name = "更新日期_企业", width = 20, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期_企业")
    private java.util.Date updateTimeCompany;
    /**
     * 更新人_企业
     */
    @Excel(name = "更新人_企业", width = 15)
    @ApiModelProperty(value = "更新人_企业")
    private java.lang.String updateByCompany;
}
