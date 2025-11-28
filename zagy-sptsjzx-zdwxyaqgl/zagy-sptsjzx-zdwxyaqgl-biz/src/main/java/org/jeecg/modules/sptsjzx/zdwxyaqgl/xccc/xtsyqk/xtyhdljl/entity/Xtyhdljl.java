package org.jeecg.modules.sptsjzx.zdwxyaqgl.xccc.xtsyqk.xtyhdljl.entity;

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
 * @Description: 系统用户登录记录
 * @Author: zagy-cg
 * @Date:   2025-05-30
 * @Version: V1.0
 */
@Data
@TableName("xtyhdljl")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="xtyhdljl对象", description="系统用户登录记录")
public class Xtyhdljl implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**uuid*/
	@Excel(name = "uuid", width = 15)
    @ApiModelProperty(value = "uuid")
    private java.lang.String uuid;
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
	/**请求类型*/
	@Excel(name = "请求类型", width = 15, dicCode = "qqlx")
	@Dict(dicCode = "qqlx")
    @ApiModelProperty(value = "请求类型")
    private java.lang.String requestType;
	/**请求方 IP*/
	@Excel(name = "请求方 IP", width = 15)
    @ApiModelProperty(value = "请求方 IP")
    private java.lang.String clientIp;
	/**账号名称*/
	@Excel(name = "账号名称", width = 15)
    @ApiModelProperty(value = "账号名称")
    private java.lang.String username;
	/**用户类型*/
	@Excel(name = "用户类型", width = 15, dicCode = "dlyhlx")
	@Dict(dicCode = "dlyhlx")
    @ApiModelProperty(value = "用户类型")
    private java.lang.String personType;
	/**客户端类型*/
	@Excel(name = "客户端类型", width = 15, dicCode = "khdlx")
	@Dict(dicCode = "khdlx")
    @ApiModelProperty(value = "客户端类型")
    private java.lang.String clientType;
	/**行政区划编码*/
	@Excel(name = "行政区划编码", width = 15)
    @ApiModelProperty(value = "行政区划编码")
    private java.lang.String areaCode;
	/**删除标记*/
	@Excel(name = "删除标记", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标记")
    private java.lang.String status;
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
	@Excel(name = "创建日期_企业", width = 15)
    @ApiModelProperty(value = "创建日期_企业")
    private java.lang.String createTimeCompany;
	/**创建人_企业*/
	@Excel(name = "创建人_企业", width = 15)
    @ApiModelProperty(value = "创建人_企业")
    private java.lang.String createByCompany;
	/**更新日期_企业*/
	@Excel(name = "更新日期_企业", width = 15)
    @ApiModelProperty(value = "更新日期_企业")
    private java.lang.String updateTimeCompany;
	/**更新人_企业*/
	@Excel(name = "更新人_企业", width = 15)
    @ApiModelProperty(value = "更新人_企业")
    private java.lang.String updateByCompany;
}
