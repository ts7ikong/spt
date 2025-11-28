package org.jeecg.modules.sptsjzx.rydwsj.rydwsssj.entity;

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
 * @Description: 人员定位实时数据企业在线状态
 * @Author: zagy-cg
 * @Date:   2025-11-28
 * @Version: V1.0
 */
@Data
@TableName("rydwqyzxzt")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="rydwqyzxzt对象", description="人员定位实时数据企业在线状态")
public class Rydwqyzxzt implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private Integer id;
	/**公司名称*/
	@Excel(name = "公司名称", width = 15)
    @ApiModelProperty(value = "公司名称")
    private String companyName;
	/**企业编码*/
	@Excel(name = "企业编码", width = 15)
    @ApiModelProperty(value = "企业编码")
    private String companyCode;
	/**所属区县编码*/
	@Excel(name = "所属区县编码", width = 15)
    @ApiModelProperty(value = "所属区县编码")
    private String countycode;
	/**区县名称*/
	@Excel(name = "区县名称", width = 15)
    @ApiModelProperty(value = "区县名称")
    private String countryname;
	/**离线状态*/
	@Excel(name = "离线状态", width = 15, dicCode = "rydwlxzt")
	@Dict(dicCode = "rydwlxzt")
    @ApiModelProperty(value = "离线状态")
    private String offlineState;
	/**最新数据上报时间*/
	@Excel(name = "最新数据上报时间", width = 15)
    @ApiModelProperty(value = "最新数据上报时间")
    private String pushTime;
}
