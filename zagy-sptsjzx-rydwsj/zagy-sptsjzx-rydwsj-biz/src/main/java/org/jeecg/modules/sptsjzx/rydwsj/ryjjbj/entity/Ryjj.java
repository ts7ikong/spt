package org.jeecg.modules.sptsjzx.rydwsj.ryjjbj.entity;

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
 * @Description: 人员聚集报警
 * @Author: zagy-cg
 * @Date:   2025-11-28
 * @Version: V1.0
 */
@Data
@TableName("ryjj")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ryjj对象", description="人员聚集报警")
public class Ryjj implements Serializable {
    private static final long serialVersionUID = 1L;

	/**序号*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "序号")
    private Integer id;
	/**企业编码*/
	@Excel(name = "企业名称", width = 15)
    @ApiModelProperty(value = "企业名称")
    @Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    private String companyCode;
	/**创建时间*/
	@Excel(name = "创建时间", width = 15)
    @ApiModelProperty(value = "创建时间")
    private String timeStamp;
	/**人员聚集报警uuid*/
	@Excel(name = "人员聚集报警uuid", width = 15)
    @ApiModelProperty(value = "人员聚集报警uuid")
    private String uuid;
	/**进表时间*/
    @ApiModelProperty(value = "进表时间")
    private String createTime;
	/**应急部返回batch编码*/
	@Excel(name = "应急部返回batch编码", width = 15)
    @ApiModelProperty(value = "应急部返回batch编码")
    private String batchId;
	/**我们返回企业的batch编码*/
	@Excel(name = "我们返回企业的batch编码", width = 15)
    @ApiModelProperty(value = "我们返回企业的batch编码")
    private String wbatchId;
}
