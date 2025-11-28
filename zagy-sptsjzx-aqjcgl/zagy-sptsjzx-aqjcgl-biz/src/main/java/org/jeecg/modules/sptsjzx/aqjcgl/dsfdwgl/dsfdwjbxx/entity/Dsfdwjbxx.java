package org.jeecg.modules.sptsjzx.aqjcgl.dsfdwgl.dsfdwjbxx.entity;

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
 * @Description: 第三方单位基本信息
 * @Author: zagy-cg
 * @Date:   2025-05-29
 * @Version: V1.0
 */
@Data
@TableName("dsfdwjbxx")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="dsfdwjbxx对象", description="第三方单位基本信息")
public class Dsfdwjbxx implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**uuid*/
	@Excel(name = "uuid", width = 15)
    @ApiModelProperty(value = "uuid")
    private java.lang.String uuid;
	/**第三方单位社会统一信用代码*/
	@Excel(name = "第三方单位社会统一信用代码", width = 15)
    @ApiModelProperty(value = "第三方单位社会统一信用代码")
    private java.lang.String socialCode;
	/**第三方单位名称*/
	@Excel(name = "第三方单位名称", width = 15)
    @ApiModelProperty(value = "第三方单位名称")
    private java.lang.String companyName;
	/**第三方单位类型*/
	@Excel(name = "第三方单位类型", width = 15, dicCode = "dsfdwlx")
	@Dict(dicCode = "dsfdwlx")
    @ApiModelProperty(value = "第三方单位类型")
    private java.lang.String companyType;
	/**上报企业编码*/
	@Excel(name = "上报企业编码", width = 15)
    @ApiModelProperty(value = "上报企业编码")
    private java.lang.String reportCompanyCode;
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
	/**第三方单位负责人*/
	@Excel(name = "第三方单位负责人", width = 15)
    @ApiModelProperty(value = "第三方单位负责人")
    private java.lang.String responsiblePerson;
	/**负责人联系方式*/
	@Excel(name = "负责人联系方式", width = 15, dicCode = "fzrlxfs")
	@Dict(dicCode = "fzrlxfs")
    @ApiModelProperty(value = "负责人联系方式")
    private java.lang.String responsibleMobile;
	/**地址*/
	@Excel(name = "地址", width = 15)
    @ApiModelProperty(value = "地址")
    private java.lang.String addressregistry;
	/**状态*/
	@Excel(name = "状态", width = 15, dicCode = "lhzt")
	@Dict(dicCode = "lhzt")
    @ApiModelProperty(value = "状态")
    private java.lang.String status;
	/**行政区划编码*/
	@Excel(name = "行政区划编码", width = 15)
    @ApiModelProperty(value = "行政区划编码")
    private java.lang.String areaCode;
	/**黑名单原因*/
	@Excel(name = "黑名单原因", width = 15)
    @ApiModelProperty(value = "黑名单原因")
    private java.lang.String description;
	/**服务期限起*/
	@Excel(name = "服务期限起", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "服务期限起")
    private java.util.Date serviceStart;
	/**服务期限止*/
	@Excel(name = "服务期限止", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "服务期限止")
    private java.util.Date serviceEnd;
	/**营业执照*/
	@Excel(name = "营业执照", width = 15)
    @ApiModelProperty(value = "营业执照")
    private java.lang.String businessLicense;
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
