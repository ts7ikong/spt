package org.jeecg.modules.sptsjzx.dsfdwgl.dsfpxjl.entity;

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
 * @Description: 第三方培训记录
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Data
@TableName("contractor_training_record")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="contractor_training_record对象", description="第三方培训记录")
public class ContractorTrainingRecord implements Serializable {
    private static final long serialVersionUID = 1L;

	/**自增主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "自增主键")
    private java.lang.Integer id;
	/**主键*/
	@Excel(name = "主键", width = 15)
    @ApiModelProperty(value = "主键")
    private java.lang.String uuid;
	/**第三方单位名称*/
	@Excel(name = "第三方单位名称", width = 15, dictTable = "contractor_basic_info", dicText = "company_name", dicCode = "social_code")
	@Dict(dictTable = "v_contractor_basic_info", dicText = "company_name", dicCode = "social_code")
    @ApiModelProperty(value = "第三方单位名称")
    private java.lang.String socialCode;
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
	/**人员编码*/
	@Excel(name = "人员编码", width = 15)
    @ApiModelProperty(value = "人员编码")
    private java.lang.String personCode;
	/**人员姓名*/
	@Excel(name = "人员姓名", width = 15)
    @ApiModelProperty(value = "人员姓名")
    private java.lang.String name;
	/**身份证号*/
	@Excel(name = "身份证号", width = 15)
    @ApiModelProperty(value = "身份证号")
    private java.lang.String idNumber;
	/**培训类型*/
	@Excel(name = "培训类型", width = 15, dicCode = "pxlx")
	@Dict(dicCode = "pxlx")
    @ApiModelProperty(value = "培训类型")
    private java.lang.String trainingType;
	/**培训名称*/
	@Excel(name = "培训名称", width = 15)
    @ApiModelProperty(value = "培训名称")
    private java.lang.String trainingName;
	/**培训内容*/
	@Excel(name = "培训内容", width = 15)
    @ApiModelProperty(value = "培训内容")
    private java.lang.String trainingContents;
	/**培训时间*/
	@Excel(name = "培训时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "培训时间")
    private java.util.Date trainingTime;
	/**培训成绩*/
	@Excel(name = "培训成绩", width = 15)
    @ApiModelProperty(value = "培训成绩")
    private java.math.BigDecimal trainingResult;
	/**是否合格*/
	@Excel(name = "是否合格", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否合格")
    private java.lang.String qualified;
	/**删除标志*/
	@Excel(name = "删除标志", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标志")
    private java.lang.String deleted;
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
