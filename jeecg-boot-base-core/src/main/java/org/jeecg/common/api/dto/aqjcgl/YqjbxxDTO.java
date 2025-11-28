package org.jeecg.common.api.dto.aqjcgl;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jeecg.common.aspect.annotation.Dict;
import org.jeecgframework.poi.excel.annotation.Excel;

@Data
public class YqjbxxDTO {

    /**
     * 数据id
     */
    private String uuid;
    /**
     * 园区编码
     */
    private String parkCode;
    /**
     * 园区名称
     */
    private String parkName;
    /**
     * 园区行政区划 编码
     */
    private String parkAreaCode;
    /**
     * 园区地址
     */
    private String parkAddress;
    /**
     * 园区负责人
     */
    private String parkMananger;
    /**
     * 园区负责人联系方式
     */
    private String manangerPhone;
    /**
     * 安全负责人
     */
    private String safetyResponsiblePerson;
    /**
     * 安全负责人手机
     */
    private String safetyResponsibleMobile;
    /**
     * 园区地理信息边界
     */
    private String parkBorder;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 删除标志
     */
    @Dict(dicCode = "scbz")
    private String deleted;
}
