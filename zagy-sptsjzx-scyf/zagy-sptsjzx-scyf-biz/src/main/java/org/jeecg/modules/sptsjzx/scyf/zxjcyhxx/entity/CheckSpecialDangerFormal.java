package org.jeecg.modules.sptsjzx.scyf.zxjcyhxx.entity;

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
 * @Description: 专项检查隐患信息
 * @Author: zagy-cg
 * @Date:   2025-06-25
 * @Version: V1.0
 */
@Data
@TableName("check_special_danger_formal")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="check_special_danger_formal对象", description="专项检查隐患信息")
public class CheckSpecialDangerFormal implements Serializable {
    private static final long serialVersionUID = 1L;

	/**序号*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "序号")
    private java.lang.Integer id;
	/**隐患主键id*/
	@Excel(name = "隐患主键id", width = 15)
    @ApiModelProperty(value = "隐患主键id")
    private java.lang.String dangerId;
	/**公司上传uuid*/
	@Excel(name = "公司上传uuid", width = 15)
    @ApiModelProperty(value = "公司上传uuid")
    private java.lang.String uuid;
	/**企业名称*/
	@Excel(name = "企业名称", width = 15, dictTable = "v_accept_company", dicText = "name", dicCode = "code")
	@Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @ApiModelProperty(value = "企业名称")
    private java.lang.String companyCode;
	/**检查任务id*/
	@Excel(name = "检查任务id", width = 15)
    @ApiModelProperty(value = "检查任务id")
    private java.lang.String taskId;
	/**检查类型*/
	@Excel(name = "检查类型", width = 15, dicCode = "jclx")
	@Dict(dicCode = "jclx")
    @ApiModelProperty(value = "检查类型")
    private java.lang.String checkType;
	/**检查项*/
	@Excel(name = "检查项", width = 15)
    @ApiModelProperty(value = "检查项")
    private java.lang.String checkItemId;
	/**检查项评分细则 */
	@Excel(name = "检查项评分细则 ", width = 15)
    @ApiModelProperty(value = "检查项评分细则 ")
    private java.lang.String checkScoreId;
	/**检查时间*/
	@Excel(name = "检查时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "检查时间")
    private java.util.Date checkDate;
	/**罚款金额 单位:元*/
	@Excel(name = "罚款金额 单位:元", width = 15)
    @ApiModelProperty(value = "罚款金额 单位:元")
    private java.math.BigDecimal checkPay;
	/**危害类型*/
	@Excel(name = "危害类型", width = 15, dicCode = "whlx")
	@Dict(dicCode = "whlx")
    @ApiModelProperty(value = "危害类型")
    private java.lang.String harmType;
	/**任务来源*/
	@Excel(name = "任务来源", width = 15, dicCode = "rwly")
	@Dict(dicCode = "rwly")
    @ApiModelProperty(value = "任务来源")
    private java.lang.Integer taskSource;
	/**推送状态*/
	@Excel(name = "推送状态", width = 15, dicCode = "tszt2")
	@Dict(dicCode = "tszt2")
    @ApiModelProperty(value = "推送状态")
    private java.lang.Integer pushState;
	/**推送次数*/
	@Excel(name = "推送次数", width = 15)
    @ApiModelProperty(value = "推送次数")
    private java.lang.Integer pushNum;
	/**删除状态*/
	@Excel(name = "删除状态", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除状态")
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
	/**本地uuid*/
	@Excel(name = "本地uuid", width = 15)
    @ApiModelProperty(value = "本地uuid")
    private java.lang.String localUuid;
	/**批次id(我们返回企业的)*/
	@Excel(name = "批次id(我们返回企业的)", width = 15)
    @ApiModelProperty(value = "批次id(我们返回企业的)")
    private java.lang.String wbatchId;
	/**应急部返回的批次id*/
	@Excel(name = "应急部返回的批次id", width = 15)
    @ApiModelProperty(value = "应急部返回的批次id")
    private java.lang.String batchId;
	/**数据创建时间*/
    @ApiModelProperty(value = "数据创建时间")
    private java.lang.String createTime;
}
