package org.jeecg.modules.sptsjzx.rydwsj.rydwsslssj.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class AcceptPersonPosingHitoryBackDto {

    @ApiModelProperty(value = "人员id")
    private String personId;

    @ApiModelProperty(value = "人员名称")
    private String personName;

    @ApiModelProperty(value = "人员类型")
    private String personType;

    @ApiModelProperty(value = "是否在线,//1 在线，0 离线")
    private Integer online;

    @ApiModelProperty(value = "历史轨迹时间经纬度")
    private List<AcceptPersonPosingHistoryBackInfoDto> traceList;

}