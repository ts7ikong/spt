package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.ClosedManagementStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IClosedManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "封闭化管理统计")
@RestController
@RequestMapping("/qyaqjcgl/statistics")
public class ClosedManagementController {

    @Autowired
    private IClosedManagementService service;

    @ApiOperation("获取封闭化管理统计数据")
    @GetMapping("/closedManagement")
    public Result<ClosedManagementStatisticsDTO> getClosedManagementStatistics(
            @ApiParam("园区编码") @RequestParam(required = false) String parkCode,
            @ApiParam("区县编码") @RequestParam(required = false) String countycode,
            @ApiParam("时间范围: today-当日, week-近7天, month-近30天")
            @RequestParam(required = false, defaultValue = "today") String timeRange) {

        ClosedManagementStatisticsDTO statistics = service.getClosedManagementStatistics(
                parkCode, countycode, timeRange
        );

        return Result.ok(statistics);
    }
}