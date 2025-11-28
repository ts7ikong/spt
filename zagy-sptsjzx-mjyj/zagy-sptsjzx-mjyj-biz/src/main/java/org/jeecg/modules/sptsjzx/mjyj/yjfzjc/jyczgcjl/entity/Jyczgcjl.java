package org.jeecg.modules.sptsjzx.mjyj.yjfzjc.jyczgcjl.entity;

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
 * @Description: 救援处置过程记录
 * @Author: zagy-cg
 * @Date:   2025-06-03
 * @Version: V1.0
 */
@Data
@TableName("jyczgcjl")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="jyczgcjl对象", description="救援处置过程记录")
public class Jyczgcjl implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**唯一uuid*/
	@Excel(name = "唯一uuid", width = 15)
    @ApiModelProperty(value = "唯一uuid")
    private java.lang.String uuid;
	/**园区编码*/
	@Excel(name = "园区编码", width = 15, dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
	@Dict(dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @ApiModelProperty(value = "园区编码")
    private java.lang.String parkCode;
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
	/**现场救援行动编号*/
	@Excel(name = "现场救援行动编号", width = 15)
    @ApiModelProperty(value = "现场救援行动编号")
    private java.lang.String rescueCode;
	/**事故名称*/
	@Excel(name = "事故名称", width = 15)
    @ApiModelProperty(value = "事故名称")
    private java.lang.String accidentName;
	/**记录人*/
	@Excel(name = "记录人", width = 15)
    @ApiModelProperty(value = "记录人")
    private java.lang.String rwcordName;
	/**记录时间*/
	@Excel(name = "记录时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "记录时间")
    private java.util.Date rwcordTime;
	/**救援会议纪要*/
	@Excel(name = "救援会议纪要", width = 15)
    @ApiModelProperty(value = "救援会议纪要")
    private java.lang.String summary;
	/**调用物资、人员情况*/
	@Excel(name = "调用物资、人员情况", width = 15)
    @ApiModelProperty(value = "调用物资、人员情况")
    private java.lang.String materialSituation;
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
