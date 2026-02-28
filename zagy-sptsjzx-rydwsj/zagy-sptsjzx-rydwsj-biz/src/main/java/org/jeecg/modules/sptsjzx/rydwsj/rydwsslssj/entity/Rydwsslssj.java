package org.jeecg.modules.sptsjzx.rydwsj.rydwsslssj.entity;

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
 * @Description: 人员定位接收地址
 * @Author: zagy-cg
 * @Date: 2026-02-03
 * @Version: V1.0
 */
@Data
@TableName("rydwsslssj")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "rydwsslssj对象", description = "人员定位接收地址")
public class Rydwsslssj implements Serializable {
    private static final long serialVersionUID = 1L;

    /**序号*/
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "序号")
    private Integer id;
    /**主键uuid*/
    @Excel(name = "主键uuid", width = 15)
    @ApiModelProperty(value = "主键uuid")
    private String uuid;
    /**企业*/
    @Excel(name = "企业", width = 15, dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @ApiModelProperty(value = "企业")
    private String companyCode;
    /**实时数据接口地址*/
    @Excel(name = "实时数据接口地址", width = 15)
    @ApiModelProperty(value = "实时数据接口地址")
    private String rydwSssj;
    /**历史定位数据接口地址*/
    @Excel(name = "历史定位数据接口地址", width = 15)
    @ApiModelProperty(value = "历史定位数据接口地址")
    private String rydwLssj;
    /**创建时间*/
    @ApiModelProperty(value = "创建时间")
    private String createTime;
    /**应急部返回batch编码*/
    @Excel(name = "应急部返回batch编码", width = 15)
    @ApiModelProperty(value = "应急部返回batch编码")
    private String batchId;
    /**我们返回企业的batch编码*/
    @Excel(name = "我们返回企业的batch编码", width = 15)
    @ApiModelProperty(value = "我们返回企业的batch编码")
    private String wbatchId;

    /**区县Code*/
    @TableField(exist = false)
    @ApiModelProperty(value = "区县Code")
    @Dict(dictTable = "v_company_county", dicText = "county_name", dicCode = "code")
    private java.lang.String countyCode;
}
