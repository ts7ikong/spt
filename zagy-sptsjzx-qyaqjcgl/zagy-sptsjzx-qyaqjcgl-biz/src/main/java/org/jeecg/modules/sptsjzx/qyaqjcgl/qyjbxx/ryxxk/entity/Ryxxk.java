package org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.ryxxk.entity;

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
 * @Description: 人员信息库
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Data
@TableName("ryxxk")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ryxxk对象", description="人员信息库")
public class Ryxxk implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.Integer id;
	/**企业名称*/
	@Excel(name = "企业名称", width = 15, dictTable = "v_accept_company", dicText = "name", dicCode = "code")
	@Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @ApiModelProperty(value = "企业名称")
    private java.lang.String companyCode;
	/**姓名*/
	@Excel(name = "姓名", width = 15)
    @ApiModelProperty(value = "姓名")
    private java.lang.String personName;
	/**工号*/
	@Excel(name = "工号", width = 15)
    @ApiModelProperty(value = "工号")
    private java.lang.String jobCode;
	/**人员类型*/
	@Excel(name = "人员类型", width = 15, dicCode = "rylx")
	@Dict(dicCode = "rylx")
    @ApiModelProperty(value = "人员类型")
    private java.lang.String personType;
	/**出生日期*/
	@Excel(name = "出生日期", width = 15)
    @ApiModelProperty(value = "出生日期")
    private java.lang.String birthDate;
	/**性别*/
	@Excel(name = "性别", width = 15)
    @ApiModelProperty(value = "性别")
    private java.lang.String gender;
	/**岗位名称*/
	@Excel(name = "岗位名称", width = 15)
    @ApiModelProperty(value = "岗位名称")
    private java.lang.String positionName;
	/**联系电话*/
	@Excel(name = "联系电话", width = 15)
    @ApiModelProperty(value = "联系电话")
    private java.lang.String mobileNumber;
	/**删除标志*/
	@Excel(name = "删除标志", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标志")
    private java.lang.String deleted;
	/**最后毕业院校*/
	@Excel(name = "最后毕业院校", width = 15)
    @ApiModelProperty(value = "最后毕业院校")
    private java.lang.String lastGradCollege;
	/**专业*/
	@Excel(name = "专业", width = 15)
    @ApiModelProperty(value = "专业")
    private java.lang.String major;
	/**职称*/
	@Excel(name = "职称", width = 15)
    @ApiModelProperty(value = "职称")
    private java.lang.String title;
	/**是否具备化工 学历背景*/
	@Excel(name = "是否具备化工 学历背景", width = 15, dicCode = "sfbz")
	@Dict(dicCode = "sfbz")
    @ApiModelProperty(value = "是否具备化工 学历背景")
    private java.lang.String chemicalDiploma;
	/**是否取得注册 安全工程师资 格*/
	@Excel(name = "是否取得注册 安全工程师资 格", width = 15, dicCode = "sfbz")
	@Dict(dicCode = "sfbz")
    @ApiModelProperty(value = "是否取得注册 安全工程师资 格")
    private java.lang.String certifiedSafetyEngineer;
	/**证书名称*/
	@Excel(name = "证书名称", width = 15)
    @ApiModelProperty(value = "证书名称")
    private java.lang.String certiName;
	/**证书编号*/
	@Excel(name = "证书编号", width = 15)
    @ApiModelProperty(value = "证书编号")
    private java.lang.String certiNum;
	/**证书初领时间*/
	@Excel(name = "证书初领时间", width = 15)
    @ApiModelProperty(value = "证书初领时间")
    private java.lang.String firstIssuDate;
	/**证书有效期起*/
	@Excel(name = "证书有效期起", width = 15)
    @ApiModelProperty(value = "证书有效期起")
    private java.lang.String effStime;
	/**证书有效期止*/
	@Excel(name = "证书有效期止", width = 15)
    @ApiModelProperty(value = "证书有效期止")
    private java.lang.String effEtime;
	/**所属部门*/
	@Excel(name = "所属部门", width = 15)
    @ApiModelProperty(value = "所属部门")
    private java.lang.String affiliatedDepartment;
	/**UUID*/
	@Excel(name = "UUID", width = 15)
    @ApiModelProperty(value = "UUID")
    private java.lang.String uuid;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
    @ApiModelProperty(value = "创建日期")
    private java.lang.String createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@Excel(name = "更新日期", width = 15)
    @ApiModelProperty(value = "更新日期")
    private java.lang.String updateDate;
}
