package org.jeecg.modules.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 登录表单
 *
 * @Author scott
 * @since 2019-01-18
 */
@ApiModel(value = "鉴权对象", description = "鉴权对象")
@Data
public class SysLoginAuth {
    @ApiModelProperty(value = "园区编码")
    private String yqbm;
    @ApiModelProperty(value = "园区密钥")
    private String yqmy;
}