package org.jeecg.modules.sptsjzx.rydwsj.rydwsslssj.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AcceptPersonPosingRealTimeInfoBackDto {

    @ApiModelProperty(value = "人员id")
    private String id;

    @ApiModelProperty(value = "主节点")
    private String uuid;

    @ApiModelProperty(value = "内部人员数量")
    private String personName;

    @ApiModelProperty(value = "人员类型")
    private String personType;

    @ApiModelProperty(value = "人员类型名称")
    private String personTypeName;

    @ApiModelProperty(value = "经度")
    private String longitude;

    @ApiModelProperty(value = "纬度")
    private String latitude;

    @ApiModelProperty(value = "所属部门")
    private String affiliatedDepartment;

    @ApiModelProperty(value = "是否在线,//1 在线，0 离线")
    private String online;

    @ApiModelProperty(value = "岗位名称")
    private String positionName;

    @ApiModelProperty(value = "联系电话")
    private String mobileNumber;

}