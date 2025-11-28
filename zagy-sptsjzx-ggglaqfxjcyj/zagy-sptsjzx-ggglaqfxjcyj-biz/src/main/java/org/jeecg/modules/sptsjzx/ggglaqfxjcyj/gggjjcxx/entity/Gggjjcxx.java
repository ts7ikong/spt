package org.jeecg.modules.sptsjzx.ggglaqfxjcyj.gggjjcxx.entity;

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
 * @Description: 公共管架基础信息
 * @Author: zagy-cg
 * @Date:   2025-06-03
 * @Version: V1.0
 */
@Data
@TableName("gggjjcxx")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="gggjjcxx对象", description="公共管架基础信息")
public class Gggjjcxx implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;
	/**企业编码*/
	@Excel(name = "企业编码", width = 15)
    @ApiModelProperty(value = "企业编码")
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
    /**园区编码*/
    @Excel(name = "园区编码", width = 15, dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @Dict(dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @ApiModelProperty(value = "园区编码")
    private String parkCode;
	/**管架编号*/
	@Excel(name = "管架编号", width = 15)
    @ApiModelProperty(value = "管架编号")
    private String pipeframeCode;
	/**管架名称*/
	@Excel(name = "管架名称", width = 15)
    @ApiModelProperty(value = "管架名称")
    private String pipeframeName;
	/**管架类型*/
	@Excel(name = "管架类型", width = 15, dicCode = "gjlx")
	@Dict(dicCode = "gjlx")
    @ApiModelProperty(value = "管架类型")
    private String pipeframeType;
	/**投用日期*/
	@Excel(name = "投用日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "投用日期")
    private Date pipeframeUdate;
	/**地理位置信息*/
	@Excel(name = "地理位置信息", width = 15)
    @ApiModelProperty(value = "地理位置信息")
    private String pipeframeGlocation;
	/**状态*/
	@Excel(name = "状态", width = 15, dicCode = "gjzt")
	@Dict(dicCode = "gjzt")
    @ApiModelProperty(value = "状态")
    private String pipeframeState;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private String pipeframeRemarks;
	/**资料附件*/
	@Excel(name = "资料附件", width = 15)
    @ApiModelProperty(value = "资料附件")
    private String pipeframeInfomation;
	/**删除标志*/
	@Excel(name = "删除标志", width = 15)
    @ApiModelProperty(value = "删除标志")
    private String deleted;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private Date createTime;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private Date updateTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private String updateBy;
	/**创建日期_企业*/
	@Excel(name = "创建日期_企业", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期_企业")
    private Date createTimeCompany;
	/**创建人_企业*/
	@Excel(name = "创建人_企业", width = 15)
    @ApiModelProperty(value = "创建人_企业")
    private String createByCompany;
	/**更新日期_企业*/
	@Excel(name = "更新日期_企业", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期_企业")
    private Date updateTimeCompany;
	/**更新人_企业*/
	@Excel(name = "更新人_企业", width = 15)
    @ApiModelProperty(value = "更新人_企业")
    private String updateByCompany;
}
