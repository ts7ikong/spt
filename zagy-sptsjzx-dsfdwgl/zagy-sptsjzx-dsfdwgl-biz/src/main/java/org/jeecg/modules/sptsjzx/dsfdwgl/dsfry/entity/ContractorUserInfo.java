package org.jeecg.modules.sptsjzx.dsfdwgl.dsfry.entity;

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
 * @Description: 第三方人员
 * @Author: zagy-cg
 * @Date:   2025-06-23
 * @Version: V1.0
 */
@Data
@TableName("contractor_user_info")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="contractor_user_info对象", description="第三方人员")
public class ContractorUserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

	/**自增主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "自增主键")
    private java.lang.Integer id;
	/**UUID*/
	@Excel(name = "UUID", width = 15)
    @ApiModelProperty(value = "UUID")
    private java.lang.String uuid;
	/**第三方单位名称*/
	@Excel(name = "第三方单位名称", width = 15, dictTable = "contractor_basic_info", dicText = "company_name", dicCode = "social_code")
	@Dict(dictTable = "v_contractor_basic_info", dicText = "company_name", dicCode = "social_code")
    @ApiModelProperty(value = "第三方单位名称")
    private java.lang.String sociaCode;
	/**上报企业*/
	@Excel(name = "上报企业", width = 15, dictTable = "v_accept_company", dicText = "name", dicCode = "code")
	@Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @ApiModelProperty(value = "上报企业")
    private java.lang.String reportCompanyCode;
	/**姓名*/
	@Excel(name = "姓名", width = 15)
    @ApiModelProperty(value = "姓名")
    private java.lang.String personName;
	/**人员编码*/
	@Excel(name = "人员编码", width = 15)
    @ApiModelProperty(value = "人员编码")
    private java.lang.String personCode;
	/**身份证号*/
	@Excel(name = "身份证号", width = 15)
    @ApiModelProperty(value = "身份证号")
    private java.lang.String idCode;
	/**年龄*/
	@Excel(name = "年龄", width = 15)
    @ApiModelProperty(value = "年龄")
    private java.lang.Integer age;
	/**状态*/
	@Excel(name = "状态", width = 15, dicCode = "dsfdwzt")
	@Dict(dicCode = "dsfdwzt")
    @ApiModelProperty(value = "状态")
    private java.lang.String status;
	/**黑名单原因*/
	@Excel(name = "黑名单原因", width = 15)
    @ApiModelProperty(value = "黑名单原因")
    private java.lang.String description;
	/**联系电话*/
	@Excel(name = "联系电话", width = 15)
    @ApiModelProperty(value = "联系电话")
    private java.lang.String mobileNumber;
	/**岗位名称*/
	@Excel(name = "岗位名称", width = 15)
    @ApiModelProperty(value = "岗位名称")
    private java.lang.String positionName;
	/**是否高风险岗位*/
	@Excel(name = "是否高风险岗位", width = 15, dicCode = "sfbz")
	@Dict(dicCode = "sfbz")
    @ApiModelProperty(value = "是否高风险岗位")
    private java.lang.String highRiskPosition;
	/**员工照片URL*/
	@Excel(name = "员工照片URL", width = 15)
    @ApiModelProperty(value = "员工照片URL")
    private java.lang.String personPicture;
	/**证书名称*/
	@Excel(name = "证书名称", width = 15)
    @ApiModelProperty(value = "证书名称")
    private java.lang.String certificateName;
	/**证书号码*/
	@Excel(name = "证书号码", width = 15)
    @ApiModelProperty(value = "证书号码")
    private java.lang.String certificateNumber;
	/**证书级别*/
	@Excel(name = "证书级别", width = 15)
    @ApiModelProperty(value = "证书级别")
    private java.lang.String certificateLevel;
	/**证书有效期起*/
	@Excel(name = "证书有效期起", width = 15)
    @ApiModelProperty(value = "证书有效期起")
    private java.lang.String startTime;
	/**证书有效期止*/
	@Excel(name = "证书有效期止", width = 15)
    @ApiModelProperty(value = "证书有效期止")
    private java.lang.String endTime;
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
