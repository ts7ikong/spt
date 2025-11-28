package org.jeecg.modules.sptsjzx.ggglaqfxjcyj.gggxjcxx.entity;

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
 * @Description: 公共管线基础信息
 * @Author: zagy-cg
 * @Date:   2025-06-03
 * @Version: V1.0
 */
@Data
@TableName("gggxjcxx")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="gggxjcxx对象", description="公共管线基础信息")
public class Gggxjcxx implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**uuid*/
	@Excel(name = "uuid", width = 15)
    @ApiModelProperty(value = "uuid")
    private java.lang.String uuid;
    /**园区编码*/
    @Excel(name = "园区编码", width = 15, dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @Dict(dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @ApiModelProperty(value = "园区编码")
    private String parkCode;
	/**企业编码*/
	@Excel(name = "企业编码", width = 15)
    @ApiModelProperty(value = "企业编码")
    private java.lang.String companyCode;

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
	/**所在管廊*/
	@Excel(name = "所在管廊", width = 15, dictTable = "gggljcxx", dicText = "pipe_name", dicCode = "pipe_code")
	@Dict(dictTable = "gggljcxx", dicText = "pipe_name", dicCode = "pipe_code")
    @ApiModelProperty(value = "所在管廊")
    private java.lang.String pipeCode;
	/**管线编号*/
	@Excel(name = "管线编号", width = 15)
    @ApiModelProperty(value = "管线编号")
    private java.lang.String pipelineCode;
	/**管线名称*/
	@Excel(name = "管线名称", width = 15)
    @ApiModelProperty(value = "管线名称")
    private java.lang.String pipelineName;
	/**所在层数*/
	@Excel(name = "所在层数", width = 15)
    @ApiModelProperty(value = "所在层数")
    private java.lang.String pipelineCs;
	/**管位*/
	@Excel(name = "管位", width = 15)
    @ApiModelProperty(value = "管位")
    private java.lang.String pipelinePosition;
	/**危化品编号*/
	@Excel(name = "危化品编号", width = 15)
    @ApiModelProperty(value = "危化品编号")
    private java.lang.String chemicalsCode;
	/**介质名称*/
	@Excel(name = "介质名称", width = 15)
    @ApiModelProperty(value = "介质名称")
    private java.lang.String pipelineMedianame;
	/**地理位置信息*/
	@Excel(name = "地理位置信息", width = 15)
    @ApiModelProperty(value = "地理位置信息")
    private java.lang.String pipelineGlocation;
	/**状态*/
	@Excel(name = "状态", width = 15, dicCode = "gxzt")
	@Dict(dicCode = "gxzt")
    @ApiModelProperty(value = "状态")
    private java.lang.String pipelineState;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String pipelineRemarks;
	/**资料附件*/
	@Excel(name = "资料附件", width = 15)
    @ApiModelProperty(value = "资料附件")
    private java.lang.String pipelineInfomation;
	/**删除标志*/
	@Excel(name = "删除标志", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
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
