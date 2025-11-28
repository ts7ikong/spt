package org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.wxhxpxx.entity;

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
 * @Description: 危险化学品信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Data
@TableName("wxhxpxx")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="wxhxpxx对象", description="危险化学品信息")
public class Wxhxpxx implements Serializable {
    private static final long serialVersionUID = 1L;

	/**序号*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "序号")
    private java.lang.Integer id;
	/**UUID*/
	@Excel(name = "UUID", width = 15)
    @ApiModelProperty(value = "UUID")
    private java.lang.String uuid;
	/**企业名称*/
	@Excel(name = "企业名称", width = 15, dictTable = "v_accept_company", dicText = "name", dicCode = "code")
	@Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @ApiModelProperty(value = "企业名称")
    private java.lang.String companyCode;
	/**危险源编码*/
	@Excel(name = "危险源编码", width = 15, dictTable = "v_accept_hazard_code", dicText = "hazard_name", dicCode = "hazard_code")
	@Dict(dictTable = "v_accept_hazard_code", dicText = "hazard_name", dicCode = "hazard_code")
    @ApiModelProperty(value = "危险源编码")
    private java.lang.String hazardCode;
	/**中文名*/
	@Excel(name = "中文名", width = 15)
    @ApiModelProperty(value = "中文名")
    private java.lang.String chemicalName;
	/**别名*/
	@Excel(name = "别名", width = 15)
    @ApiModelProperty(value = "别名")
    private java.lang.String chemicalAlias;
	/**化学品类型*/
	@Excel(name = "化学品类型", width = 15, dicCode = "hxplx")
	@Dict(dicCode = "hxplx")
    @ApiModelProperty(value = "化学品类型")
    private java.lang.Integer chemicalType;
	/**cas号*/
	@Excel(name = "cas号", width = 15)
    @ApiModelProperty(value = "cas号")
    private java.lang.String cas;
	/**产品生产能力（吨）*/
	@Excel(name = "产品生产能力（吨）", width = 15)
    @ApiModelProperty(value = "产品生产能力（吨）")
    private java.lang.String capacity;
	/**产品生产能力气体（方）*/
	@Excel(name = "产品生产能力气体（方）", width = 15)
    @ApiModelProperty(value = "产品生产能力气体（方）")
    private java.lang.String capacityGas;
	/**产品最大储量（吨）*/
	@Excel(name = "产品最大储量（吨）", width = 15)
    @ApiModelProperty(value = "产品最大储量（吨）")
    private java.lang.String reserve;
	/**产品最大储量气体（方）*/
	@Excel(name = "产品最大储量气体（方）", width = 15)
    @ApiModelProperty(value = "产品最大储量气体（方）")
    private java.lang.String reserveGas;
	/**删除标志*/
	@Excel(name = "删除标志", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标志")
    private java.lang.String deleted;
	/**创建人姓名*/
    @ApiModelProperty(value = "创建人姓名")
    private java.lang.String createBy;
	/**创建时间*/
	@Excel(name = "创建时间", width = 15)
    @ApiModelProperty(value = "创建时间")
    private java.lang.String createDate;
	/**修改人姓名*/
    @ApiModelProperty(value = "修改人姓名")
    private java.lang.String updateBy;
	/**修改时间*/
	@Excel(name = "修改时间", width = 15)
    @ApiModelProperty(value = "修改时间")
    private java.lang.String updateDate;
	/**进表时间*/
    @ApiModelProperty(value = "进表时间")
    private java.lang.String createTime;
}
