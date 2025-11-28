package org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.zdwxyxx.entity;

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
 * @Description: 重大危险源信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Data
@TableName("accept_hazard_code")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="accept_hazard_code对象", description="重大危险源信息")
public class AcceptHazardCode implements Serializable {
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
	/**危险源名称*/
	@Excel(name = "危险源名称", width = 15)
    @ApiModelProperty(value = "危险源名称")
    private java.lang.String hazardName;
	/**危险源编码*/
	@Excel(name = "危险源编码", width = 15)
    @ApiModelProperty(value = "危险源编码")
    private java.lang.String hazardCode;
	/**危险源等级*/
	@Excel(name = "危险源等级", width = 15, dicCode = "wxydj")
	@Dict(dicCode = "wxydj")
    @ApiModelProperty(value = "危险源等级")
    private java.lang.Integer level;
	/**主要负责人*/
	@Excel(name = "主要负责人", width = 15)
    @ApiModelProperty(value = "主要负责人")
    private java.lang.String charger;
	/**操作负责人*/
	@Excel(name = "操作负责人", width = 15)
    @ApiModelProperty(value = "操作负责人")
    private java.lang.String operater;
	/**技术负责人*/
	@Excel(name = "技术负责人", width = 15)
    @ApiModelProperty(value = "技术负责人")
    private java.lang.String director;
	/**主要负责人电话*/
	@Excel(name = "主要负责人电话", width = 15)
    @ApiModelProperty(value = "主要负责人电话")
    private java.lang.String chargerPhone;
	/**操作负责人电话*/
	@Excel(name = "操作负责人电话", width = 15)
    @ApiModelProperty(value = "操作负责人电话")
    private java.lang.String operaterPhone;
	/**技术负责人电话*/
	@Excel(name = "技术负责人电话", width = 15)
    @ApiModelProperty(value = "技术负责人电话")
    private java.lang.String directorPhone;
	/**危险源简称*/
	@Excel(name = "危险源简称", width = 15)
    @ApiModelProperty(value = "危险源简称")
    private java.lang.String hazardShortName;
	/**R值*/
	@Excel(name = "R值", width = 15)
    @ApiModelProperty(value = "R值")
    private java.lang.String rvalue;
	/**重大危险源分类*/
	@Excel(name = "重大危险源分类", width = 15, dicCode = "zdwxyfl")
	@Dict(dicCode = "zdwxyfl")
    @ApiModelProperty(value = "重大危险源分类")
    private java.lang.String hazardFactility;
	/**行政区域编码*/
	@Excel(name = "行政区域编码", width = 15)
    @ApiModelProperty(value = "行政区域编码")
    private java.lang.String areaCode;
	/**地址*/
	@Excel(name = "地址", width = 15)
    @ApiModelProperty(value = "地址")
    private java.lang.String address;
	/**经度*/
	@Excel(name = "经度", width = 15)
    @ApiModelProperty(value = "经度")
    private java.lang.String longitude;
	/**纬度*/
	@Excel(name = "纬度", width = 15)
    @ApiModelProperty(value = "纬度")
    private java.lang.String latitude;
	/**投用日期*/
	@Excel(name = "投用日期", width = 15)
    @ApiModelProperty(value = "投用日期")
    private java.lang.String establishDate;
	/**周边防护目标最近距离(米)重大危险源与周边重点防护目标最近距离为重大危险源的设备、装置、设施的边缘到周边重点防护目标边缘的最近距离。*/
	@Excel(name = "周边防护目标最近距离(米)重大危险源与周边重点防护目标最近距离为重大危险源的设备、装置、设施的边缘到周边重点防护目标边缘的最近距离。", width = 15)
    @ApiModelProperty(value = "周边防护目标最近距离(米)重大危险源与周边重点防护目标最近距离为重大危险源的设备、装置、设施的边缘到周边重点防护目标边缘的最近距离。")
    private java.lang.String protectionTargetDistance;
	/**外边界500米返回人数估算*/
	@Excel(name = "外边界500米返回人数估算", width = 15)
    @ApiModelProperty(value = "外边界500米返回人数估算")
    private java.lang.String peoplem;
	/**是否在化工园区 */
	@Excel(name = "是否在化工园区 ", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否在化工园区 ")
    private java.lang.String inIndustrialPark;
	/**园区名称*/
	@Excel(name = "园区名称", width = 15)
    @ApiModelProperty(value = "园区名称")
    private java.lang.String industrialParkName;
	/**生产能力*/
	@Excel(name = "生产能力", width = 15)
    @ApiModelProperty(value = "生产能力")
    private java.lang.String produceAbility;
	/**是否涉及重点监管工艺*/
	@Excel(name = "是否涉及重点监管工艺", width = 15, dicCode = "sf")
	@Dict(dicCode = "sf")
    @ApiModelProperty(value = "是否涉及重点监管工艺")
    private java.lang.String isHazardCrafts;
	/**装置去危险源关联的重点监管工艺 用逗号隔开*/
	@Excel(name = "装置去危险源关联的重点监管工艺 用逗号隔开", width = 15)
    @ApiModelProperty(value = "装置去危险源关联的重点监管工艺 用逗号隔开")
    private java.lang.String hazardCrafts;
	/**主要负责人*/
	@Excel(name = "主要负责人", width = 15)
    @ApiModelProperty(value = "主要负责人")
    private java.lang.String responsible;
	/**主要负责人电话*/
	@Excel(name = "主要负责人电话", width = 15)
    @ApiModelProperty(value = "主要负责人电话")
    private java.lang.String responsiblePhone;
	/**主要负责人职务*/
	@Excel(name = "主要负责人职务", width = 15)
    @ApiModelProperty(value = "主要负责人职务")
    private java.lang.String responsiblePost;
	/**技术负责人*/
	@Excel(name = "技术负责人", width = 15)
    @ApiModelProperty(value = "技术负责人")
    private java.lang.String technical;
	/**技术负责人电话*/
	@Excel(name = "技术负责人电话", width = 15)
    @ApiModelProperty(value = "技术负责人电话")
    private java.lang.String technicalPhone;
	/**技术负责人职务*/
	@Excel(name = "技术负责人职务", width = 15)
    @ApiModelProperty(value = "技术负责人职务")
    private java.lang.String technicalPost;
	/**操作负责人*/
	@Excel(name = "操作负责人", width = 15)
    @ApiModelProperty(value = "操作负责人")
    private java.lang.String operation;
	/**操作负责人职务*/
	@Excel(name = "操作负责人职务", width = 15)
    @ApiModelProperty(value = "操作负责人职务")
    private java.lang.String operationPost;
	/**操作负责人电话*/
	@Excel(name = "操作负责人电话", width = 15)
    @ApiModelProperty(value = "操作负责人电话")
    private java.lang.String operationPhone;
	/**生产状态*/
	@Excel(name = "生产状态", width = 15, dicCode = "sczt")
	@Dict(dicCode = "sczt")
    @ApiModelProperty(value = "生产状态")
    private java.lang.String productionStatus;
	/**删除标志*/
	@Excel(name = "删除标志", width = 15)
    @ApiModelProperty(value = "删除标志")
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
	/**主键uuid*/
	@Excel(name = "主键uuid", width = 15)
    @ApiModelProperty(value = "主键uuid")
    private java.lang.String uuid;
	/**进表时间*/
    @ApiModelProperty(value = "进表时间")
    private java.lang.String createTime;
	/**批次编号(我们返给企业的)*/
	@Excel(name = "批次编号(我们返给企业的)", width = 15)
    @ApiModelProperty(value = "批次编号(我们返给企业的)")
    private java.lang.String wbatchId;
	/**应急部返回的批次id*/
	@Excel(name = "应急部返回的批次id", width = 15)
    @ApiModelProperty(value = "应急部返回的批次id")
    private java.lang.String batchId;
}
