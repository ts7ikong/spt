package org.jeecg.modules.sptsjzx.aqjcgl.tongji.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@ApiModel(value = "风险分级管控统计响应VO", description = "风险分级管控统计响应VO")
public class RiskGradeControlResVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "接入情况")
    private List<Map<String, Object>> accessStatus;

    @ApiModelProperty(value = "运行情况")
    private RunLevelVO runLevel;

    @ApiModelProperty(value = "风险分级管控")
    private RiskControlVO riskControl;

    @ApiModelProperty(value = "隐患排查治理")
    private DangerInvestigationVO dangerInvestigation;

    @Data
    public static class RunLevelVO implements Serializable {
        @ApiModelProperty(value = "优")
        private Integer excellent = 0;

        @ApiModelProperty(value = "良")
        private Integer good = 0;

        @ApiModelProperty(value = "中")
        private Integer medium = 0;

        @ApiModelProperty(value = "差")
        private Integer poor = 0;
    }

    @Data
    public static class RiskControlVO implements Serializable {
        @ApiModelProperty(value = "分析单元数量")
        private Integer unitCount = 0;

        @ApiModelProperty(value = "风险事件数量")
        private Integer eventCount = 0;

        @ApiModelProperty(value = "管控措施数量")
        private Integer measuresCount = 0;

        @ApiModelProperty(value = "排查任务数量")
        private Integer taskCount = 0;
    }

    @Data
    public static class DangerInvestigationVO implements Serializable {
        @ApiModelProperty(value = "一般隐患数量")
        private Integer generalDanger = 0;

        @ApiModelProperty(value = "重大隐患数量")
        private Integer majorDanger = 0;

        @ApiModelProperty(value = "整改中数量")
        private Integer rectifying = 0;

        @ApiModelProperty(value = "整改逾期数量")
        private Integer overdue = 0;
    }
}
