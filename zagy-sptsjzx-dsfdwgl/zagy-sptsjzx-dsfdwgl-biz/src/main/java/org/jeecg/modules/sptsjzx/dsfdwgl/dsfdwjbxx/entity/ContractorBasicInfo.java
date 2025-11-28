package org.jeecg.modules.sptsjzx.dsfdwgl.dsfdwjbxx.entity;

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
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Data
@TableName("contractor_basic_info")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="contractor_basic_info对象", description="第三方单位基本信息")
public class ContractorBasicInfo implements Serializable {
    private static final long serialVersionUID = 1L;

	/**自增主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "自增主键")
    private java.lang.Integer id;
	/**UUID*/
	@Excel(name = "UUID", width = 15)
    @ApiModelProperty(value = "UUID")
    private java.lang.String uuid;
	/**第三方单位统一社会信用代码*/
	@Excel(name = "第三方单位统一社会信用代码", width = 15)
    @ApiModelProperty(value = "第三方单位统一社会信用代码")
    private java.lang.String socialCode;
	/**第三方单位名称*/
	@Excel(name = "第三方单位名称", width = 15)
    @ApiModelProperty(value = "第三方单位名称")
    private java.lang.String companyName;
	/**类型*/
	@Excel(name = "类型", width = 15, dicCode = "dsfdwlx")
	@Dict(dicCode = "dsfdwlx")
    @ApiModelProperty(value = "类型")
    private java.lang.String companyType;
	/**上报企业*/
	@Excel(name = "上报企业", width = 15, dictTable = "v_accept_company", dicText = "name", dicCode = "code")
	@Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @ApiModelProperty(value = "上报企业")
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
	/**负责人姓名*/
	@Excel(name = "负责人姓名", width = 15)
    @ApiModelProperty(value = "负责人姓名")
    private java.lang.String responsiblePerson;
	/**负责人联系方式*/
	@Excel(name = "负责人联系方式", width = 15)
    @ApiModelProperty(value = "负责人联系方式")
    private java.lang.String responsibleMobile;
	/**地址*/
	@Excel(name = "地址", width = 15)
    @ApiModelProperty(value = "地址")
    private java.lang.String addressRegistry;
	/**状态*/
	@Excel(name = "状态", width = 15, dicCode = "dsfdwzt")
	@Dict(dicCode = "dsfdwzt")
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
	@Excel(name = "服务期限起", width = 15)
    @ApiModelProperty(value = "服务期限起")
    private java.lang.String serviceStart;
	/**服务期限止*/
	@Excel(name = "服务期限止", width = 15)
    @ApiModelProperty(value = "服务期限止")
    private java.lang.String serviceEnd;
	/**营业执照URL*/
	@Excel(name = "营业执照URL", width = 15)
    @ApiModelProperty(value = "营业执照URL")
    private java.lang.String businessLicense;
	/**删除标志*/
	@Excel(name = "删除标志", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标志")
    private java.lang.Integer deleted;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建时间*/
	@Excel(name = "创建时间", width = 15)
    @ApiModelProperty(value = "创建时间")
    private java.lang.String createDate;
	/**最后修改人*/
    @ApiModelProperty(value = "最后修改人")
    private java.lang.String updateBy;
	/**最后修改时间*/
	@Excel(name = "最后修改时间", width = 15)
    @ApiModelProperty(value = "最后修改时间")
    private java.lang.String updateDate;
	/**应急部返回batch编码*/
	@Excel(name = "应急部返回batch编码", width = 15)
    @ApiModelProperty(value = "应急部返回batch编码")
    private java.lang.String batchId;
	/**数据入库时间*/
	@Excel(name = "数据入库时间", width = 15)
    @ApiModelProperty(value = "数据入库时间")
    private java.lang.String time;
	/**我们返回企业batch编号*/
	@Excel(name = "我们返回企业batch编号", width = 15)
    @ApiModelProperty(value = "我们返回企业batch编号")
    private java.lang.String wbatchId;
}
