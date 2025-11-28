package org.jeecg.modules.sptsjzx.zdwxyaqgl.zxjc.jczbxx.entity;

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
 * @Description: 监测指标信息
 * @Author: zagy-cg
 * @Date:   2025-05-30
 * @Version: V1.0
 */
@Data
@TableName("jczbxx")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="jczbxx对象", description="监测指标信息")
public class Jczbxx implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;
	/**uuid*/
	@Excel(name = "uuid", width = 15)
    @ApiModelProperty(value = "uuid")
    private String uuid;
	/**指标编码*/
	@Excel(name = "指标编码", width = 15)
    @ApiModelProperty(value = "指标编码")
    private String targetCode;
	/**所属设备编码*/
	@Excel(name = "所属设备编码", width = 15)
    @ApiModelProperty(value = "所属设备编码")
    private String equipCode;
	/**指标名称*/
	@Excel(name = "指标名称", width = 15)
    @ApiModelProperty(value = "指标名称")
    private String targetName;
	/**指标类型*/
	@Excel(name = "指标类型", width = 15, dicCode = "zblx")
	@Dict(dicCode = "zblx")
    @ApiModelProperty(value = "指标类型")
    private String targetType;
	/**计量单位*/
	@Excel(name = "计量单位", width = 15)
    @ApiModelProperty(value = "计量单位")
    private String unit;
	/**指标描述*/
	@Excel(name = "指标描述", width = 15)
    @ApiModelProperty(value = "指标描述")
    private String parameterDesc;
	/**一级阈值上限*/
	@Excel(name = "一级阈值上限", width = 15)
    @ApiModelProperty(value = "一级阈值上限")
    private BigDecimal thresholdUp;
	/**二级阈值上限*/
	@Excel(name = "二级阈值上限", width = 15)
    @ApiModelProperty(value = "二级阈值上限")
    private BigDecimal thresholdUp2;
	/**一级阈值下限*/
	@Excel(name = "一级阈值下限", width = 15)
    @ApiModelProperty(value = "一级阈值下限")
    private BigDecimal thresholdDown;
	/**二级阈值下限*/
	@Excel(name = "二级阈值下限", width = 15)
    @ApiModelProperty(value = "二级阈值下限")
    private BigDecimal thresholdDown2;
	/**量程上限*/
	@Excel(name = "量程上限", width = 15)
    @ApiModelProperty(value = "量程上限")
    private BigDecimal rangeUp;
	/**量程下限*/
	@Excel(name = "量程下限", width = 15)
    @ApiModelProperty(value = "量程下限")
    private BigDecimal rangeDown;
	/**删除标记*/
	@Excel(name = "删除标记", width = 15)
    @ApiModelProperty(value = "删除标记")
    private String status;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private Date createTime;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private Date updateTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private String updateBy;
	/**创建日期_企业*/
	@Excel(name = "创建日期_企业", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期_企业")
    private Date createTimeCompany;
	/**创建人_企业*/
	@Excel(name = "创建人_企业", width = 15)
    @ApiModelProperty(value = "创建人_企业")
    private String createByCompany;
	/**更新日期_企业*/
	@Excel(name = "更新日期_企业", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期_企业")
    private Date updateTimeCompany;
	/**更新人_企业*/
	@Excel(name = "更新人_企业", width = 15)
    @ApiModelProperty(value = "更新人_企业")
    private String updateByCompany;
    /**园区编码*/
    @Excel(name = "园区编码", width = 15, dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @Dict(dictTable = "yqjbxx", dicText = "park_name", dicCode = "park_code")
    @ApiModelProperty(value = "园区编码")
    private String parkCode;

}
