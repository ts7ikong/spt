package org.jeecg.modules.sptsjzx.aqjcgl.cbsgl.entity;

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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
 * @Description: 承包商培训记录
 * @Author: zagy-cg
 * @Date:   2025-03-03
 * @Version: V1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@TableName("contractor_train")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="contractor_train对象", description="承包商培训记录")
public class ContractorTrain implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private Date updateTime;
	/**UUID*/
	@Excel(name = "UUID", width = 15)
    @ApiModelProperty(value = "UUID")
    private String uuid;
	/**园区编号*/
	@Excel(name = "园区编号", width = 15, dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
	@Dict(dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @ApiModelProperty(value = "园区编号")
    private String parkCode;
	/**第三方uuid*/
	@Excel(name = "第三方uuid", width = 15, dictTable = "contractor_basic_information", dicText = "contractor_name", dicCode = "uuid")
	@Dict(dictTable = "contractor_basic_information", dicText = "contractor_name", dicCode = "uuid")
    @ApiModelProperty(value = "第三方uuid")
    private String contractorUuid;
    /**上报企业编码*/
    @Excel(name = "上报企业编码", width = 15)
    @ApiModelProperty(value = "上报企业编码")
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
	/**人员编码*/
	@Excel(name = "人员编码", width = 15)
    @ApiModelProperty(value = "人员编码")
    private String ersonCode;
	/**人员姓名*/
	@Excel(name = "人员姓名", width = 15)
    @ApiModelProperty(value = "人员姓名")
    private String name;
	/**身份证号*/
	@Excel(name = "身份证号", width = 15)
    @ApiModelProperty(value = "身份证号")
    private String idCard;
	/**培训类型*/
	@Excel(name = "培训类型", width = 15, dicCode = "pxlx")
	@Dict(dicCode = "pxlx")
    @ApiModelProperty(value = "培训类型")
    private String trainingType;
	/**培训名称*/
	@Excel(name = "培训名称", width = 15)
    @ApiModelProperty(value = "培训名称")
    private String trainingName;
	/**培训内容*/
	@Excel(name = "培训内容", width = 15)
    @ApiModelProperty(value = "培训内容")
    private String trainingContents;
	/**培训时间*/
	@Excel(name = "培训时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "培训时间")
    private Date trainingTime;
	/**培训成绩*/
	@Excel(name = "培训成绩", width = 15)
    @ApiModelProperty(value = "培训成绩")
    private String trainingResult;
	/**是否合格*/
	@Excel(name = "是否合格", width = 15, dicCode = "sfhg")
	@Dict(dicCode = "sfhg")
    @ApiModelProperty(value = "是否合格")
    private String qualified;
	/**删除标志*/
	@Excel(name = "删除标志", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标志")
    private String deleted;
}
