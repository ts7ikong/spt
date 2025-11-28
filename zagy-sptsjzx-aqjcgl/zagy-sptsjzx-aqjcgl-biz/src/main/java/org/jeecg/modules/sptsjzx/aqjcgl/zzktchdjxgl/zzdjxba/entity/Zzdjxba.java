package org.jeecg.modules.sptsjzx.aqjcgl.zzktchdjxgl.zzdjxba.entity;

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
 * @Description: 装置大检修备案
 * @Author: zagy-cg
 * @Date:   2025-05-29
 * @Version: V1.0
 */
@Data
@TableName("zzdjxba")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="zzdjxba对象", description="装置大检修备案")
public class Zzdjxba implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;
	/**UUID*/
	@Excel(name = "UUID", width = 15)
    @ApiModelProperty(value = "UUID")
    private String uuid;
	/**园区编号*/
	@Excel(name = "园区编号", width = 15, dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
	@Dict(dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @ApiModelProperty(value = "园区编号")
    private String parkCode;
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
	/**装置编号*/
	@Excel(name = "装置编号", width = 15)
    @ApiModelProperty(value = "装置编号")
    private String deviceCode;
	/**装置名称*/
	@Excel(name = "装置名称", width = 15)
    @ApiModelProperty(value = "装置名称")
    private String deviceName;
	/**装置负责人姓名*/
	@Excel(name = "装置负责人姓名", width = 15)
    @ApiModelProperty(value = "装置负责人姓名")
    private String plantPrincipalPersonName;
	/**装置负责人手机号*/
	@Excel(name = "装置负责人手机号", width = 15)
    @ApiModelProperty(value = "装置负责人手机号")
    private String plantPrincipalPersonMobile;
	/**检修名称*/
	@Excel(name = "检修名称", width = 15)
    @ApiModelProperty(value = "检修名称")
    private String maintenanceName;
	/**检修内容*/
	@Excel(name = "检修内容", width = 15)
    @ApiModelProperty(value = "检修内容")
    private String maintenanceContent;
	/**重大危险源编码*/
	@Excel(name = "重大危险源编码", width = 15)
    @ApiModelProperty(value = "重大危险源编码")
    private String hazardCode;
	/**大检修开始时间*/
	@Excel(name = "大检修开始时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "大检修开始时间")
    private Date maintenanceStartTime;
	/**大检修实际结束时间*/
	@Excel(name = "大检修实际结束时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "大检修实际结束时间")
    private Date maintenanceEndTime;
	/**大检修责任人*/
	@Excel(name = "大检修责任人", width = 15)
    @ApiModelProperty(value = "大检修责任人")
    private String maintenancePersonName;
	/**大检修责任人手机号*/
	@Excel(name = "大检修责任人手机号", width = 15)
    @ApiModelProperty(value = "大检修责任人手机号")
    private String maintenancePersonMobile;
	/**大检修计划结束时间*/
	@Excel(name = "大检修计划结束时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "大检修计划结束时间")
    private Date maintenanceExpireTime;
	/**当前状态*/
	@Excel(name = "当前状态", width = 15, dicCode = "zzdjxbadqzz")
	@Dict(dicCode = "zzdjxbadqzz")
    @ApiModelProperty(value = "当前状态")
    private String operationStatus;
	/**删除标志*/
	@Excel(name = "删除标志", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
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
