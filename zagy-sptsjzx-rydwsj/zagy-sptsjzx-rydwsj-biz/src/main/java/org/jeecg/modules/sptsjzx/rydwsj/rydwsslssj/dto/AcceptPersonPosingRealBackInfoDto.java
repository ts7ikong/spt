package org.jeecg.modules.sptsjzx.rydwsj.rydwsslssj.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class AcceptPersonPosingRealBackInfoDto {

    @ApiModelProperty(value = "主节点")
    private String id;

    @ApiModelProperty(value = "主节点")
    private String uuid;

    @ApiModelProperty(value = "内部人员数量")
    private String nodeName;

    @ApiModelProperty(value = "内部总人数")
    private String count;

    @ApiModelProperty(value = "内部在线人数")
    private String onlineCount;

    @ApiModelProperty(value = "人员类型")
    private String personType;

    @ApiModelProperty(value = "在线人员基本信息")
    private List<AcceptPersonPosingRealTimeInfoBackDto> children;

}