package org.jeecg.modules.sptsjzx.scyf.rzyqd.entity;

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
 * @Description: 日周月清单
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Data
@TableName("accept_qrcode_list_formal")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="accept_qrcode_list_formal对象", description="日周月清单")
public class AcceptQrcodeListFormal implements Serializable {
    private static final long serialVersionUID = 1L;

	/**唯一uuid*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "唯一uuid")
    private java.lang.Integer id;
	/**企业编码*/
	@Excel(name = "企业编码", width = 15, dictTable = "v_accept_company", dicText = "name", dicCode = "code")
	@Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @ApiModelProperty(value = "企业编码")
    private java.lang.String companyCode;
	/**清单名称*/
	@Excel(name = "清单名称", width = 15)
    @ApiModelProperty(value = "清单名称")
    private java.lang.String name;
	/**责任部门*/
	@Excel(name = "责任部门", width = 15)
    @ApiModelProperty(value = "责任部门")
    private java.lang.String hazardDep;
	/**责任部门负责人姓名*/
	@Excel(name = "责任部门负责人姓名", width = 15)
    @ApiModelProperty(value = "责任部门负责人姓名")
    private java.lang.String hazardLiablePerson;
	/**日周月类型*/
	@Excel(name = "日周月类型", width = 15, dicCode = "rzylx")
	@Dict(dicCode = "rzylx")
    @ApiModelProperty(value = "日周月类型")
    private java.lang.Integer type;
	/**频次*/
	@Excel(name = "频次", width = 15)
    @ApiModelProperty(value = "频次")
    private java.lang.Integer frequency;
	/**频次类型*/
	@Excel(name = "频次类型", width = 15)
    @ApiModelProperty(value = "频次类型")
    private java.lang.Integer frequenceType;
	/**负责人姓名*/
	@Excel(name = "负责人姓名", width = 15)
    @ApiModelProperty(value = "负责人姓名")
    private java.lang.String principalname;
	/**负责人电话*/
	@Excel(name = "负责人电话", width = 15)
    @ApiModelProperty(value = "负责人电话")
    private java.lang.String principalphone;
	/**执行状态*/
	@Excel(name = "执行状态", width = 15, dicCode = "zxzt")
	@Dict(dicCode = "zxzt")
    @ApiModelProperty(value = "执行状态")
    private java.lang.Integer state;
	/**是否开启*/
	@Excel(name = "是否开启", width = 15, dicCode = "sfkq")
	@Dict(dicCode = "sfkq")
    @ApiModelProperty(value = "是否开启")
    private java.lang.Integer showstate;
	/**周末是否开启*/
	@Excel(name = "周末是否开启", width = 15, dicCode = "zmjjrsfkq")
	@Dict(dicCode = "zmjjrsfkq")
    @ApiModelProperty(value = "周末是否开启")
    private java.lang.Integer isWeekendopen;
	/**节假日是否开启*/
	@Excel(name = "节假日是否开启", width = 15, dicCode = "zmjjrsfkq")
	@Dict(dicCode = "zmjjrsfkq")
    @ApiModelProperty(value = "节假日是否开启")
    private java.lang.Integer isHolidayopen;
	/**工作开始时间*/
	@Excel(name = "工作开始时间", width = 15)
    @ApiModelProperty(value = "工作开始时间")
    private java.lang.String workStartTime;
	/**工作结束时间*/
	@Excel(name = "工作结束时间", width = 15)
    @ApiModelProperty(value = "工作结束时间")
    private java.lang.String workEndTime;
	/**负责人类型*/
	@Excel(name = "负责人类型", width = 15, dicCode = "zrrlx")
	@Dict(dicCode = "zrrlx")
    @ApiModelProperty(value = "负责人类型")
    private java.lang.Integer belongType;
	/**推送状态*/
	@Excel(name = "推送状态", width = 15, dicCode = "tszt2")
	@Dict(dicCode = "tszt2")
    @ApiModelProperty(value = "推送状态")
    private java.lang.Integer pushState;
	/**删除状态*/
	@Excel(name = "删除状态", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除状态")
    private java.lang.Integer deleted;
	/**创建人姓名*/
    @ApiModelProperty(value = "创建人姓名")
    private java.lang.String createBy;
	/**创建时间*/
	@Excel(name = "创建时间", width = 15)
    @ApiModelProperty(value = "创建时间")
    private java.lang.String createDate;
	/**修改人姓名*/
    @ApiModelProperty(value = "修改人姓名")
    private java.lang.String updateBy;
	/**修改时间*/
	@Excel(name = "修改时间", width = 15)
    @ApiModelProperty(value = "修改时间")
    private java.lang.String updateDate;
	/**排查清单uuid*/
	@Excel(name = "排查清单uuid", width = 15)
    @ApiModelProperty(value = "排查清单uuid")
    private java.lang.String uuid;
	/**批次id(应急部返回的)*/
	@Excel(name = "批次id(应急部返回的)", width = 15)
    @ApiModelProperty(value = "批次id(应急部返回的)")
    private java.lang.String batchId;
	/**本地uuid*/
	@Excel(name = "本地uuid", width = 15)
    @ApiModelProperty(value = "本地uuid")
    private java.lang.String localUuid;
	/**批次id(我们返回企业的)*/
	@Excel(name = "批次id(我们返回企业的)", width = 15)
    @ApiModelProperty(value = "批次id(我们返回企业的)")
    private java.lang.String wbatchId;
}
