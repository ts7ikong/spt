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
public class SysLoginAuthToQlt {
    @ApiModelProperty(value = "用户名")
    private String yhm;

    @ApiModelProperty(value = "密码")
    private String mm;
}