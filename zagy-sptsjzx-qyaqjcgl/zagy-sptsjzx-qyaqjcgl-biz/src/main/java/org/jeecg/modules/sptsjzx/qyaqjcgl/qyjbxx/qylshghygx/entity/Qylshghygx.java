package org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qylshghygx.entity;

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
 * @Description: 企业隶属化工行业关系表
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Data
@TableName("qylshghygx")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="qylshghygx对象", description="企业隶属化工行业关系表")
public class Qylshghygx implements Serializable {
    private static final long serialVersionUID = 1L;

	/**序号*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "序号")
    private java.lang.Integer id;
	/**主键uuid*/
	@Excel(name = "主键uuid", width = 15)
    @ApiModelProperty(value = "主键uuid")
    private java.lang.String uuid;
	/**企业名称*/
	@Excel(name = "企业名称", width = 15, dictTable = "v_accept_company", dicText = "name", dicCode = "code")
	@Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @ApiModelProperty(value = "企业名称")
    private java.lang.String companyCode;
	/**化工行业编码*/
	@Excel(name = "化工行业编码", width = 15)
    @ApiModelProperty(value = "化工行业编码")
    private java.lang.String chemicalIndustryCode;
	/**删除标志*/
	@Excel(name = "删除标志", width = 15, dicCode = "scbz")
	@Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除标志")
    private java.lang.String deleted;
	/**创建时间*/
	@Excel(name = "创建时间", width = 15)
    @ApiModelProperty(value = "创建时间")
    private java.lang.String createDate;
	/**创建人姓名*/
    @ApiModelProperty(value = "创建人姓名")
    private java.lang.String createBy;
	/**修改时间*/
	@Excel(name = "修改时间", width = 15)
    @ApiModelProperty(value = "修改时间")
    private java.lang.String updateDate;
	/**修改人姓名*/
    @ApiModelProperty(value = "修改人姓名")
    private java.lang.String updateBy;
	/**进表时间*/
    @ApiModelProperty(value = "进表时间")
    private java.lang.String createTime;
}
