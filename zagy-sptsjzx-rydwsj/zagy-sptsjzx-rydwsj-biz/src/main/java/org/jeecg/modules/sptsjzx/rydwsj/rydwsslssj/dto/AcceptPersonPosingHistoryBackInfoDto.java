package org.jeecg.modules.sptsjzx.rydwsj.rydwsslssj.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AcceptPersonPosingHistoryBackInfoDto {

    @ApiModelProperty(value = "定位时间 yyyy-MM-dd HH:mm:ss")
    private String timeStamp;

    @ApiModelProperty(value = "经度")
    private String longitude;

    @ApiModelProperty(value = "纬度")
    private String latitude;

}