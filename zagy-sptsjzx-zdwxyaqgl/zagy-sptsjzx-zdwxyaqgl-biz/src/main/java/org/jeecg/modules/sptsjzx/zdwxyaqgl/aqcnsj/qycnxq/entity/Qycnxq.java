package org.jeecg.modules.sptsjzx.zdwxyaqgl.aqcnsj.qycnxq.entity;

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
 * @Description: 企业承诺详情表
 * @Author: zagy-cg
 * @Date:   2025-05-30
 * @Version: V1.0
 */
@Data
@TableName("qycnxq")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="qycnxq对象", description="企业承诺详情表")
public class Qycnxq implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**UUID*/
	@Excel(name = "UUID", width = 15)
    @ApiModelProperty(value = "UUID")
    private java.lang.String uuid;
	/**园区编号*/
	@Excel(name = "园区编号", width = 15, dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
	@Dict(dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @ApiModelProperty(value = "园区编号")
    private java.lang.String parkCode;
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
	/**承诺日期*/
	@Excel(name = "承诺日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "承诺日期")
    private java.util.Date commitDate;
	/**生产装置套数*/
	@Excel(name = "生产装置套数", width = 15)
    @ApiModelProperty(value = "生产装置套数")
    private java.lang.Integer unitsNumber;
	/**运行套数*/
	@Excel(name = "运行套数", width = 15)
    @ApiModelProperty(value = "运行套数")
    private java.lang.Integer runNumber;
	/**停车套数*/
	@Excel(name = "停车套数", width = 15)
    @ApiModelProperty(value = "停车套数")
    private java.lang.Integer parkNumber;
	/**特级动火作业*/
	@Excel(name = "特级动火作业", width = 15)
    @ApiModelProperty(value = "特级动火作业")
    private java.lang.Integer firesNumber;
	/**一级动火作业*/
	@Excel(name = "一级动火作业", width = 15)
    @ApiModelProperty(value = "一级动火作业")
    private java.lang.Integer fire1Number;
	/**二级动火作业*/
	@Excel(name = "二级动火作业", width = 15)
    @ApiModelProperty(value = "二级动火作业")
    private java.lang.Integer fire2Number;
	/**断路作业*/
	@Excel(name = "断路作业", width = 15)
    @ApiModelProperty(value = "断路作业")
    private java.lang.Integer roadworkNumber;
	/**动土作业*/
	@Excel(name = "动土作业", width = 15)
    @ApiModelProperty(value = "动土作业")
    private java.lang.Integer soilworkNumber;
	/**高处作业*/
	@Excel(name = "高处作业", width = 15)
    @ApiModelProperty(value = "高处作业")
    private java.lang.Integer highworkNumber;
	/**临时用电作业*/
	@Excel(name = "临时用电作业", width = 15)
    @ApiModelProperty(value = "临时用电作业")
    private java.lang.Integer electricityworkNumber;
	/**吊装作业*/
	@Excel(name = "吊装作业", width = 15)
    @ApiModelProperty(value = "吊装作业")
    private java.lang.Integer liftingworkNumber;
	/**盲板作业*/
	@Excel(name = "盲板作业", width = 15)
    @ApiModelProperty(value = "盲板作业")
    private java.lang.Integer blindplateNumber;
	/**受限空间作业*/
	@Excel(name = "受限空间作业", width = 15)
    @ApiModelProperty(value = "受限空间作业")
    private java.lang.Integer spaceworkNumber;
	/**检维修作业*/
	@Excel(name = "检维修作业", width = 15)
    @ApiModelProperty(value = "检维修作业")
    private java.lang.Integer inspectionNumber;
	/**倒罐作业*/
	@Excel(name = "倒罐作业", width = 15)
    @ApiModelProperty(value = "倒罐作业")
    private java.lang.Integer pourOutNumber;
	/**清罐作业*/
	@Excel(name = "清罐作业", width = 15)
    @ApiModelProperty(value = "清罐作业")
    private java.lang.Integer cleanTankNumber;
	/**切水作业*/
	@Excel(name = "切水作业", width = 15)
    @ApiModelProperty(value = "切水作业")
    private java.lang.Integer drainingNumber;
	/**承包商作业*/
	@Excel(name = "承包商作业", width = 15)
    @ApiModelProperty(value = "承包商作业")
    private java.lang.Integer contractorNumber;
	/**变更作业*/
	@Excel(name = "变更作业", width = 15)
    @ApiModelProperty(value = "变更作业")
    private java.lang.Integer changedTaskNumber;
	/**是否有承包商作业*/
	@Excel(name = "是否有承包商作业", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否有承包商作业")
    private java.lang.String contractor;
	/**是否处于试生产期*/
	@Excel(name = "是否处于试生产期", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否处于试生产期")
    private java.lang.String trialProduction;
	/**是否处于开停车状态*/
	@Excel(name = "是否处于开停车状态", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否处于开停车状态")
    private java.lang.String openParking;
	/**正在开停车装置数*/
	@Excel(name = "正在开停车装置数", width = 15)
    @ApiModelProperty(value = "正在开停车装置数")
    private java.lang.Integer openParkingNumber;
	/**开车装置数*/
	@Excel(name = "开车装置数", width = 15)
    @ApiModelProperty(value = "开车装置数")
    private java.lang.Integer workNumber;
	/**停车装置数*/
	@Excel(name = "停车装置数", width = 15)
    @ApiModelProperty(value = "停车装置数")
    private java.lang.Integer notWorkNumber;
	/**是否开展中（扩）试*/
	@Excel(name = "是否开展中（扩）试", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否开展中（扩）试")
    private java.lang.String test;
	/**试生产装置 数*/
	@Excel(name = "试生产装置 数", width = 15)
    @ApiModelProperty(value = "试生产装置 数")
    private java.lang.Integer testNumber;
	/**检维修套数*/
	@Excel(name = "检维修套数", width = 15)
    @ApiModelProperty(value = "检维修套数")
    private java.lang.Integer overhaulWorkNumber;
	/**重点监管危险工艺数量*/
	@Excel(name = "重点监管危险工艺数量", width = 15)
    @ApiModelProperty(value = "重点监管危险工艺数量")
    private java.lang.Integer dangerProcessNumber;
	/**有无重大隐 患*/
	@Excel(name = "有无重大隐 患", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "有无重大隐 患")
    private java.lang.String mmHazards;
	/**风险级别*/
	@Excel(name = "风险级别", width = 15, dicCode = "fxjb")
	@Dict(dicCode = "fxjb")
    @ApiModelProperty(value = "风险级别")
    private java.lang.String riskGrade;
	/**承诺人*/
	@Excel(name = "承诺人", width = 15)
    @ApiModelProperty(value = "承诺人")
    private java.lang.String commitment;
	/**承诺内容*/
	@Excel(name = "承诺内容", width = 15)
    @ApiModelProperty(value = "承诺内容")
    private java.lang.String commitContent;
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
