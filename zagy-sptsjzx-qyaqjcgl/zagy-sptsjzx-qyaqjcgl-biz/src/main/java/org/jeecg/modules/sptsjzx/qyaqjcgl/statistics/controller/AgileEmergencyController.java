package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.DataScopeHelper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.AgileEmergencyStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IAgileEmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "敏捷应急统计")
@RestController
@RequestMapping("/qyaqjcgl/statistics")
public class AgileEmergencyController {

    @Autowired
    private IAgileEmergencyService service;

    @ApiOperation("获取敏捷应急统计数据")
    @GetMapping("/agileEmergency")
    public Result<AgileEmergencyStatisticsDTO> getAgileEmergencyStatistics(
            @ApiParam("园区编码") @RequestParam(required = false) String parkCode,
            @ApiParam("区县编码") @RequestParam(required = false) String countycode,
            @ApiParam("演练类型") @RequestParam(required = false) String drillType) {

        // 【数据权限过滤】根据登录用户的区县编码过滤数据
        // 敏捷应急模块的表使用countycode字段进行过滤，不使用company_code
        if (DataScopeHelper.needDataScope()) {
            String orgCode = DataScopeHelper.getCurrentUserOrgCode();
            // 县区级账号：使用用户的orgCode作为countycode进行过滤
            countycode = orgCode;
        }
        // 市级账号：使用前端传入的countycode参数（可能为空，表示查询全部）

        AgileEmergencyStatisticsDTO statistics = service.getAgileEmergencyStatistics(
                parkCode, null, countycode, drillType
        );

        return Result.ok(statistics);
    }
}