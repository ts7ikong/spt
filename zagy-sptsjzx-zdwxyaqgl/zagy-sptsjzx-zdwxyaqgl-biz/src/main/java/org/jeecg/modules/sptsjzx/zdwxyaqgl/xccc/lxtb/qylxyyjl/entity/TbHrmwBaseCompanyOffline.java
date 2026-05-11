package org.jeecg.modules.sptsjzx.zdwxyaqgl.xccc.lxtb.qylxyyjl.entity;

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
 * @Description: 企业离线原因记录
 * @Author: zagy-cg
 * @Date:   2026-04-22
 * @Version: V1.0
 */
@Data
@TableName("tb_hrmw_base_company_offline")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="tb_hrmw_base_company_offline对象", description="企业离线原因记录")
public class TbHrmwBaseCompanyOffline implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键ID*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键ID")
    private String id;
    /**企业编码*/
    @ApiModelProperty(value = "企业编码")
    @Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    private String companyCode;

    /**区县Code*/
    @TableField(exist = false)
    @ApiModelProperty(value = "区县Code")
    @Dict(dictTable = "v_company_county", dicText = "county_name", dicCode = "code")
    private java.lang.String countyCode;
	/**离线类型*/
	@Excel(name = "离线类型", width = 15, dicCode = "lxlx")
	@Dict(dicCode = "lxlx")
    @ApiModelProperty(value = "离线类型")
    private String offlineType;
	/**离线原因*/
	@Excel(name = "离线原因", width = 15)
    @ApiModelProperty(value = "离线原因")
    private String offlineReason;
	/**离线时间点*/
	@Excel(name = "离线时间点", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "离线时间点")
    private Date offlineTime;
	/**计划上线时间*/
	@Excel(name = "计划上线时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "计划上线时间")
    private Date planOnlineTime;
	/**附件的文件路径*/
	@Excel(name = "附件的文件路径", width = 15)
    @ApiModelProperty(value = "附件的文件路径")
    private String attachFilePath;
	/**附件的文件名*/
	@Excel(name = "附件的文件名", width = 15)
    @ApiModelProperty(value = "附件的文件名")
    private String attachFileName;
	/**附件的文件后缀*/
	@Excel(name = "附件的文件后缀", width = 15)
    @ApiModelProperty(value = "附件的文件后缀")
    private String attachFileFormat;
	/**批次填写报备内容的时间戳*/
	@Excel(name = "批次填写报备内容的时间戳", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "批次填写报备内容的时间戳")
    private Date batchTime;
	/**是否删除*/
	@Excel(name = "是否删除", width = 15, dicCode = "sfsc")
	@Dict(dicCode = "sfsc")
    @ApiModelProperty(value = "是否删除")
    private String deleted;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private String updateBy;
	/**更新时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
