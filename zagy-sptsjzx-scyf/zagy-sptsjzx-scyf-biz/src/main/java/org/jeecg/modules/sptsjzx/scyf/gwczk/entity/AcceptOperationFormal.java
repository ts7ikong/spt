package org.jeecg.modules.sptsjzx.scyf.gwczk.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;
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
 * @Description: 岗位操作卡
 * @Author: zagy-cg
 * @Date: 2025-06-23
 * @Version: V1.0
 */
@Data
@TableName("accept_operation_formal")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "accept_operation_formal对象", description = "岗位操作卡")
public class AcceptOperationFormal implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键id")
    private java.lang.Integer id;
    /**
     * 企业名称
     */
    @Excel(name = "企业名称", width = 15, dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @Dict(dictTable = "v_accept_company", dicText = "name", dicCode = "code")
    @ApiModelProperty(value = "企业名称")
    private java.lang.String companyCode;
    /**
     * 岗位唯一uuid
     */
    @Excel(name = "岗位唯一uuid", width = 15)
    @ApiModelProperty(value = "岗位唯一uuid")
    private java.lang.String positonid;
    /**
     * 岗位名称
     */
    @Excel(name = "岗位名称", width = 15)
    @ApiModelProperty(value = "岗位名称")
    private java.lang.String positon;
    /**
     * 责任部门
     */
    @Excel(name = "责任部门", width = 15)
    @ApiModelProperty(value = "责任部门")
    private java.lang.String hazardDep;
    /**
     * 责任部门负责人姓名
     */
    @Excel(name = "责任部门负责人姓名", width = 15)
    @ApiModelProperty(value = "责任部门负责人姓名")
    private java.lang.String hazardLiablePerson;
    /**
     * 作业程序
     */
    @Excel(name = "作业程序", width = 15)
    @ApiModelProperty(value = "作业程序")
    private java.lang.String program;
    /**
     * 作业标准及注意事项
     */
    @Excel(name = "作业标准及注意事项", width = 15)
    @ApiModelProperty(value = "作业标准及注意事项")
    private java.lang.String attention;
    /**
     * 作业顺序
     */
    @Excel(name = "作业顺序", width = 15)
    @ApiModelProperty(value = "作业顺序")
    @TableField("`index`")
    private java.lang.Integer index;
    /**
     * 推送状态
     */
    @Excel(name = "推送状态", width = 15, dicCode = "tszt2")
    @Dict(dicCode = "tszt2")
    @ApiModelProperty(value = "推送状态")
    private java.lang.Integer pushState;
    /**
     * 删除状态
     */
    @Excel(name = "删除状态", width = 15, dicCode = "scbz")
    @Dict(dicCode = "scbz")
    @ApiModelProperty(value = "删除状态")
    private java.lang.Integer deleted;
    /**
     * 创建人姓名
     */
    @ApiModelProperty(value = "创建人姓名")
    private java.lang.String createBy;
    /**
     * 创建时间
     */
    @Excel(name = "创建时间", width = 15)
    @ApiModelProperty(value = "创建时间")
    private java.lang.String createDate;
    /**
     * 修改人姓名
     */
    @ApiModelProperty(value = "修改人姓名")
    private java.lang.String updateBy;
    /**
     * 修改时间
     */
    @Excel(name = "修改时间", width = 15)
    @ApiModelProperty(value = "修改时间")
    private java.lang.String updateDate;
    /**
     * 岗位操作卡uuid
     */
    @Excel(name = "岗位操作卡uuid", width = 15)
    @ApiModelProperty(value = "岗位操作卡uuid")
    private java.lang.String uuid;
    /**
     * 返回的批次id(应急部返回的)
     */
    @Excel(name = "返回的批次id(应急部返回的)", width = 15)
    @ApiModelProperty(value = "返回的批次id(应急部返回的)")
    private java.lang.String batchId;
    /**
     * 本地uuid
     */
    @Excel(name = "本地uuid", width = 15)
    @ApiModelProperty(value = "本地uuid")
    private java.lang.String localUuid;
    /**
     * 批次id(我们返回企业的)
     */
    @Excel(name = "批次id(我们返回企业的)", width = 15)
    @ApiModelProperty(value = "批次id(我们返回企业的)")
    private java.lang.String wbatchId;
    /**
     * 顺口溜
     */
    @Excel(name = "顺口溜", width = 15)
    @ApiModelProperty(value = "顺口溜")
    private java.lang.String doggerel;
}
