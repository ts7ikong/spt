package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.SpecialWorkStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.ISpecialWorkStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.jeecg.common.api.vo.Result;

@Api(tags = "特殊作业安全管控统计")
@RestController
@RequestMapping("/qyaqjcgl/statistics")
public class SpecialWorkStatisticsController {

    @Autowired
    private ISpecialWorkStatisticsService service;

    @ApiOperation("获取特殊作业安全管控统计数据")
    @GetMapping("/specialWork")
    public Result<SpecialWorkStatisticsDTO> getSpecialWorkStatistics(
            @ApiParam("区县编码") @RequestParam(required = false) String countycode,
            @ApiParam("园区类型") @RequestParam(required = false) Integer yqType,
            @ApiParam("企业编码") @RequestParam(required = false) String companyCode,
            @ApiParam("是否生产企业") @RequestParam(required = false) Integer isScqy) {

        SpecialWorkStatisticsDTO statistics = service.getSpecialWorkStatistics(
                countycode, yqType, companyCode, isScqy
        );

        return Result.ok(statistics);
    }
}