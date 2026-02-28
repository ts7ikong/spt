package org.jeecg.modules.sptsjzx.rydwsj.rydwsslssj.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class AcceptPersonPosingRealBackDto {

    @ApiModelProperty(value = "主节点")
    private String id;
    @ApiModelProperty(value = "主节点")
    private String uuid;
    @ApiModelProperty(value = "主节点名称")
    private String nodeName;

    @ApiModelProperty(value = "企业总人数")
    private String count;

    @ApiModelProperty(value = "企业在线人数")
    private String onlineCount;

    @ApiModelProperty(value = "企业在线人数")
    private List<AcceptPersonPosingRealBackInfoDto> children;

}