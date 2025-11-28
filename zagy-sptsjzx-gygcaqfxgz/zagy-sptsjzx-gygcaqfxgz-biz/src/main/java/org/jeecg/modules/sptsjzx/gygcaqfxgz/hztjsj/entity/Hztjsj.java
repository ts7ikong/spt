package org.jeecg.modules.sptsjzx.gygcaqfxgz.hztjsj.entity;

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
 * @Description: 汇总统计数据
 * @Author: zagy-cg
 * @Date:   2025-06-03
 * @Version: V1.0
 */
@Data
@TableName("hztjsj")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="hztjsj对象", description="汇总统计数据")
public class Hztjsj implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
    /**园区编码*/
    @Excel(name = "园区编码", width = 15, dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @Dict(dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @ApiModelProperty(value = "园区编码")
    private String parkCode;
	/**uuid*/
	@Excel(name = "uuid", width = 15)
    @ApiModelProperty(value = "uuid")
    private java.lang.String uuid;
	/**机构/企业*/
	@Excel(name = "机构/企业", width = 15)
    @ApiModelProperty(value = "机构/企业")
    private java.lang.String consumptionIspe;
	/**汇总编号*/
	@Excel(name = "汇总编号", width = 15)
    @ApiModelProperty(value = "汇总编号")
    private java.lang.String consumptionCode;
	/**周期*/
	@Excel(name = "周期", width = 15, dicCode = "hztjzq")
	@Dict(dicCode = "hztjzq")
    @ApiModelProperty(value = "周期")
    private java.lang.String scucle;
	/**耗水量/万立方米*/
	@Excel(name = "耗水量/万立方米", width = 15)
    @ApiModelProperty(value = "耗水量/万立方米")
    private java.math.BigDecimal consumptionWater;
	/**耗电量/万千瓦时*/
	@Excel(name = "耗电量/万千瓦时", width = 15)
    @ApiModelProperty(value = "耗电量/万千瓦时")
    private java.math.BigDecimal consumptionWire;
	/**耗煤量/万吨*/
	@Excel(name = "耗煤量/万吨", width = 15)
    @ApiModelProperty(value = "耗煤量/万吨")
    private java.math.BigDecimal consumptionCoal;
	/**耗气量/万立方米*/
	@Excel(name = "耗气量/万立方米", width = 15)
    @ApiModelProperty(value = "耗气量/万立方米")
    private java.math.BigDecimal consumptionGas;
	/**耗热量/万吨*/
	@Excel(name = "耗热量/万吨", width = 15)
    @ApiModelProperty(value = "耗热量/万吨")
    private java.math.BigDecimal consumptionHeat;
	/**能耗(标煤)/万吨*/
	@Excel(name = "能耗(标煤)/万吨", width = 15)
    @ApiModelProperty(value = "能耗(标煤)/万吨")
    private java.math.BigDecimal consumptionEc;
	/**中水回用率（%）*/
	@Excel(name = "中水回用率（%）", width = 15)
    @ApiModelProperty(value = "中水回用率（%）")
    private java.math.BigDecimal consumptionRwater;
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
