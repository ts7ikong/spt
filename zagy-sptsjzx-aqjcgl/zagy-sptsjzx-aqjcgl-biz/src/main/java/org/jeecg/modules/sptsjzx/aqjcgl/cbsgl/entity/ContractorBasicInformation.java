package org.jeecg.modules.sptsjzx.aqjcgl.cbsgl.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.jeecg.common.constant.ProvinceCityArea;
import org.jeecg.common.util.SpringContextUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
 * @Description: 承包商基本信息
 * @Author: zagy-cg
 * @Date: 2025-03-03
 * @Version: V1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@TableName("contractor_basic_information")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "contractor_basic_information对象", description = "承包商基本信息")
public class ContractorBasicInformation implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createBy;
    /**
     * 创建日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private Date createTime;
    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人")
    private String updateBy;
    /**
     * 更新日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private Date updateTime;
    /**
     * UUID
     */
    @Excel(name = "UUID", width = 15)
    @ApiModelProperty(value = "UUID")
    private String uuid;
    /**
     * 园区编号
     */
    @Excel(name = "园区编号", width = 15, dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @Dict(dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @ApiModelProperty(value = "园区编号")
    private String parkCode;
    /**
     * 统一信用代码
     */
    @Excel(name = "统一信用代码", width = 15)
    @ApiModelProperty(value = "统一信用代码")
    private String socialCode;
    /**
     * 第三方单位名称
     */
    @Excel(name = "第三方单位名称", width = 15)
    @ApiModelProperty(value = "第三方单位名称")
    private String contractorName;
    /**
     * 第三方单位类 型
     */
    @Excel(name = "第三方单位类 型", width = 15, dicCode = "cbslx")
    @Dict(dicCode = "cbslx")
    @ApiModelProperty(value = "第三方单位类 型")
    private String contractorType;
    /**
     * 上报企业编码
     */
    @Excel(name = "上报企业编码", width = 15)
    @ApiModelProperty(value = "上报企业编码")
    private String companyCode;
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
    /**
     * 第三方单位负责人
     */
    @Excel(name = "第三方单位负责人", width = 15)
    @ApiModelProperty(value = "第三方单位负责人")
    private String responsiblePerson;
    /**
     * 负责人联系方式
     */
    @Excel(name = "负责人联系方式", width = 15)
    @ApiModelProperty(value = "负责人联系方式")
    private String responsibleMobile;
    /**
     * 地址
     */
    @Excel(name = "地址", width = 15)
    @ApiModelProperty(value = "地址")
    private String addressregistry;
    /**
     * 状态
     */
    @Excel(name = "状态", width = 15, dicCode = "zt")
    @Dict(dicCode = "zt")
    @ApiModelProperty(value = "状态")
    private String status;
    /**
     * 行政区划编码
     */
    @Excel(name = "行政区划编码", width = 15)
    @ApiModelProperty(value = "行政区划编码")
    private String areaCode;
    /**
     * 黑名单原因
     */
    @Excel(name = "黑名单原因", width = 15)
    @ApiModelProperty(value = "黑名单原因")
    private String description;
    /**
     * 服务期限起
     */
    @Excel(name = "服务期限起", width = 15, format = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "服务期限起")
    private Date serviceStart;
    /**
     * 服务期限止
     */
    @Excel(name = "服务期限止", width = 15, format = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "服务期限止")
    private Date serviceEnd;
    /**
     * 营业执照
     */
    @Excel(name = "营业执照", width = 15)
    @ApiModelProperty(value = "营业执照")
    private String businessLicense;
    /**
     * 删除标志
     */
    @Excel(name = "删除标志", width = 15, dicCode = "scbz")
    @Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标志")
    private String deleted;
}
