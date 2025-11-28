package org.jeecg.modules.sptsjzx.ggglaqfxjcyj.gggljcxx.entity;

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
 * @Description: 公共管廊基础信息
 * @Author: zagy-cg
 * @Date:   2025-06-03
 * @Version: V1.0
 */
@Data
@TableName("gggljcxx")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="gggljcxx对象", description="公共管廊基础信息")
public class Gggljcxx implements Serializable {
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
	/**管理单位编码*/
	@Excel(name = "管理单位编码", width = 15)
    @ApiModelProperty(value = "管理单位编码")
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
	/**管理单位*/
	@Excel(name = "管理单位", width = 15)
    @ApiModelProperty(value = "管理单位")
    private java.lang.String companyName;
	/**管廊编号*/
	@Excel(name = "管廊编号", width = 15)
    @ApiModelProperty(value = "管廊编号")
    private java.lang.String pipeCode;
	/**管廊名称*/
	@Excel(name = "管廊名称", width = 15)
    @ApiModelProperty(value = "管廊名称")
    private java.lang.String pipeName;
	/**管廊分类*/
	@Excel(name = "管廊分类", width = 15, dicCode = "glfl")
	@Dict(dicCode = "glfl")
    @ApiModelProperty(value = "管廊分类")
    private java.lang.String pipeType;
	/**空间位置*/
	@Excel(name = "空间位置", width = 15, dicCode = "kjwz")
	@Dict(dicCode = "kjwz")
    @ApiModelProperty(value = "空间位置")
    private java.lang.Integer pipeSpaceaddress;
	/**管廊层数*/
	@Excel(name = "管廊层数", width = 15)
    @ApiModelProperty(value = "管廊层数")
    private java.lang.Integer pipePcs;
	/**管廊宽度（m）*/
	@Excel(name = "管廊宽度（m）", width = 15)
    @ApiModelProperty(value = "管廊宽度（m）")
    private java.math.BigDecimal pipeWidth;
	/**管廊长度（M）*/
	@Excel(name = "管廊长度（M）", width = 15)
    @ApiModelProperty(value = "管廊长度（M）")
    private java.math.BigDecimal pipeLength;
	/**管控距离（m）*/
	@Excel(name = "管控距离（m）", width = 15)
    @ApiModelProperty(value = "管控距离（m）")
    private java.math.BigDecimal pipeDistance;
	/**建设单位*/
	@Excel(name = "建设单位", width = 15)
    @ApiModelProperty(value = "建设单位")
    private java.lang.String pipeJunit;
	/**投用日期*/
	@Excel(name = "投用日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "投用日期")
    private java.util.Date pipeUdate;
	/**地理位置信息*/
	@Excel(name = "地理位置信息", width = 15)
    @ApiModelProperty(value = "地理位置信息")
    private java.lang.String pipeGlocation;
	/**状态*/
	@Excel(name = "状态", width = 15, dicCode = "glzt")
	@Dict(dicCode = "glzt")
    @ApiModelProperty(value = "状态")
    private java.lang.String pipeState;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String pipeRemarks;
	/**资料附件*/
	@Excel(name = "资料附件", width = 15)
    @ApiModelProperty(value = "资料附件")
    private java.lang.String pipeInfomation;
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
	/**删除标志*/
	@Excel(name = "删除标志", width = 15)
    @ApiModelProperty(value = "删除标志")
    private java.lang.String deleted;
}
