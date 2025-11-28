package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jeecg.common.api.vo.Result;
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

        AgileEmergencyStatisticsDTO statistics = service.getAgileEmergencyStatistics(
                parkCode, countycode, drillType
        );

        return Result.ok(statistics);
    }
}