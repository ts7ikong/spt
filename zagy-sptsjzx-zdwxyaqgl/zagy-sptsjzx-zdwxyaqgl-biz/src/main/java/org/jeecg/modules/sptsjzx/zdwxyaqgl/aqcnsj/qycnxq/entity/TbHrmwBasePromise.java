package org.jeecg.modules.sptsjzx.zdwxyaqgl.aqcnsj.qycnxq.entity;

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
 * @Description: 企业安全承诺
 * @Author: zagy-cg
 * @Date:   2026-04-22
 * @Version: V1.0
 */
@Data
@TableName("tb_hrmw_base_promise")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="tb_hrmw_base_promise对象", description="企业安全承诺")
public class TbHrmwBasePromise implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
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
	/**承诺日期*/
	@Excel(name = "承诺日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "承诺日期")
    private Date commitDate;
	/**生产装置套数*/
	@Excel(name = "生产装置套数", width = 15)
    @ApiModelProperty(value = "生产装置套数")
    private Integer unitsNumber;
	/**运行套数*/
	@Excel(name = "运行套数", width = 15)
    @ApiModelProperty(value = "运行套数")
    private Integer runNumber;
	/**停车套数*/
	@Excel(name = "停车套数", width = 15)
    @ApiModelProperty(value = "停车套数")
    private Integer parkNumber;
	/**断路作业数量*/
	@Excel(name = "断路作业数量", width = 15)
    @ApiModelProperty(value = "断路作业数量")
    private Integer roadworkNumber;
	/**动土作业数量*/
	@Excel(name = "动土作业数量", width = 15)
    @ApiModelProperty(value = "动土作业数量")
    private Integer soilworkNumber;
	/**高处作业数量*/
	@Excel(name = "高处作业数量", width = 15)
    @ApiModelProperty(value = "高处作业数量")
    private Integer highworkNumber;
	/**临时用电作业数量*/
	@Excel(name = "临时用电作业数量", width = 15)
    @ApiModelProperty(value = "临时用电作业数量")
    private Integer electricityworkNumber;
	/**吊装作业数量*/
	@Excel(name = "吊装作业数量", width = 15)
    @ApiModelProperty(value = "吊装作业数量")
    private Integer liftingworkNumber;
	/**盲板作业数量*/
	@Excel(name = "盲板作业数量", width = 15)
    @ApiModelProperty(value = "盲板作业数量")
    private Integer blindplateNumber;
	/**二级动火作业数量*/
	@Excel(name = "二级动火作业数量", width = 15)
    @ApiModelProperty(value = "二级动火作业数量")
    private Integer fire2Number;
	/**一级动火作业数量*/
	@Excel(name = "一级动火作业数量", width = 15)
    @ApiModelProperty(value = "一级动火作业数量")
    private Integer fire1Number;
	/**受限空间作业数量*/
	@Excel(name = "受限空间作业数量", width = 15)
    @ApiModelProperty(value = "受限空间作业数量")
    private Integer spaceworkNumber;
	/**检维修作业数量*/
	@Excel(name = "检维修作业数量", width = 15)
    @ApiModelProperty(value = "检维修作业数量")
    private Integer inspectionNumber;
	/**特级动火作业数量*/
	@Excel(name = "特级动火作业数量", width = 15)
    @ApiModelProperty(value = "特级动火作业数量")
    private Integer firesNumber;
	/**重点监管危险工艺数量*/
	@Excel(name = "重点监管危险工艺数量", width = 15)
    @ApiModelProperty(value = "重点监管危险工艺数量")
    private Integer dangerProcessNumber;
	/**一级危险源数量*/
	@Excel(name = "一级危险源数量", width = 15)
    @ApiModelProperty(value = "一级危险源数量")
    private Integer hazardRank1;
	/**二级危险源数量*/
	@Excel(name = "二级危险源数量", width = 15)
    @ApiModelProperty(value = "二级危险源数量")
    private Integer hazardRank2;
	/**三级危险源数量*/
	@Excel(name = "三级危险源数量", width = 15)
    @ApiModelProperty(value = "三级危险源数量")
    private Integer hazardRank3;
	/**四级危险源数量*/
	@Excel(name = "四级危险源数量", width = 15)
    @ApiModelProperty(value = "四级危险源数量")
    private Integer hazardRank4;
	/**五级危险源数量*/
	@Excel(name = "五级危险源数量", width = 15)
    @ApiModelProperty(value = "五级危险源数量")
    private Integer hazardRank5;
	/**是否有承包商作业*/
	@Excel(name = "是否有承包商作业", width = 15, dicCode = "sfycbszy")
	@Dict(dicCode = "sfycbszy")
    @ApiModelProperty(value = "是否有承包商作业")
    private String contractor;
	/**是否处于试生产期*/
	@Excel(name = "是否处于试生产期", width = 15, dicCode = "sfcysscq")
	@Dict(dicCode = "sfcysscq")
    @ApiModelProperty(value = "是否处于试生产期")
    private String trialProduction;
	/**是否处于开停车状态*/
	@Excel(name = "是否处于开停车状态", width = 15, dicCode = "sfcyktczt")
	@Dict(dicCode = "sfcyktczt")
    @ApiModelProperty(value = "是否处于开停车状态")
    private String openParking;
	/**是否开展中（扩）试*/
	@Excel(name = "是否开展中（扩）试", width = 15, dicCode = "sfkzzks")
	@Dict(dicCode = "sfkzzks")
    @ApiModelProperty(value = "是否开展中（扩）试")
    private String test;
	/**有无重大隐患*/
	@Excel(name = "有无重大隐患", width = 15, dicCode = "ywzdyh")
	@Dict(dicCode = "m_hazards")
    @ApiModelProperty(value = "有无重大隐患")
	@TableField("m_hazards")
    private String mmHazards;
	/**风险级别*/
	@Excel(name = "风险级别", width = 15, dicCode = "jsfjscdfxjb")
	@Dict(dicCode = "jsfjscdfxjb")
    @ApiModelProperty(value = "风险级别")
    private String promiseRiskRank;
	/**风险分值*/
	@Excel(name = "风险分值", width = 15)
    @ApiModelProperty(value = "风险分值")
    private Integer promiseRiskValue;
	/**承诺人*/
	@Excel(name = "承诺人", width = 15)
    @ApiModelProperty(value = "承诺人")
    private String commitment;
	/**承诺公告*/
	@Excel(name = "承诺公告", width = 15)
    @ApiModelProperty(value = "承诺公告")
    private String commitmentNotice;
	/**当日企业承诺状态*/
	@Excel(name = "当日企业承诺状态", width = 15, dicCode = "drqycnzt")
	@Dict(dicCode = "drqycnzt")
    @ApiModelProperty(value = "当日企业承诺状态")
    private String commitStatus;
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
	/**正在开停车装置数*/
	@Excel(name = "正在开停车装置数", width = 15)
    @ApiModelProperty(value = "正在开停车装置数")
    private Integer openParkingNumber;
	/**试生产装置数*/
	@Excel(name = "试生产装置数", width = 15)
    @ApiModelProperty(value = "试生产装置数")
    private Integer testNumber;
	/**检维修套数*/
	@Excel(name = "检维修套数", width = 15)
    @ApiModelProperty(value = "检维修套数")
    private Integer overhaulWorkNumber;
	/**企业离线的原因*/
	@Excel(name = "企业离线的原因", width = 15)
    @ApiModelProperty(value = "企业离线的原因")
    private String offlineReason;
	/**倒灌作业数量*/
	@Excel(name = "倒灌作业数量", width = 15)
    @ApiModelProperty(value = "倒灌作业数量")
    private Integer pourOutNumber;
	/**清罐作业数量*/
	@Excel(name = "清罐作业数量", width = 15)
    @ApiModelProperty(value = "清罐作业数量")
    private Integer cleanTankNumber;
	/**切水作业数量*/
	@Excel(name = "切水作业数量", width = 15)
    @ApiModelProperty(value = "切水作业数量")
    private Integer drainingNumber;
	/**承包商作业数量*/
	@Excel(name = "承包商作业数量", width = 15)
    @ApiModelProperty(value = "承包商作业数量")
    private Integer contractorNumber;
	/**变更作业数量*/
	@Excel(name = "变更作业数量", width = 15)
    @ApiModelProperty(value = "变更作业数量")
    private Integer changedTaskNumber;
	/**承诺时间*/
	@Excel(name = "承诺时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "承诺时间")
    private Date commitTime;
	/**开车装置数*/
	@Excel(name = "开车装置数", width = 15)
    @ApiModelProperty(value = "开车装置数")
    private Integer workNumber;
	/**停车装置数*/
	@Excel(name = "停车装置数", width = 15)
    @ApiModelProperty(value = "停车装置数")
    private Integer notWorkNumber;
	/**是否双边*/
	@Excel(name = "是否双边", width = 15, dicCode = "sfsb")
	@Dict(dicCode = "sfsb")
    @ApiModelProperty(value = "是否双边")
    private String isBilateral;
}
