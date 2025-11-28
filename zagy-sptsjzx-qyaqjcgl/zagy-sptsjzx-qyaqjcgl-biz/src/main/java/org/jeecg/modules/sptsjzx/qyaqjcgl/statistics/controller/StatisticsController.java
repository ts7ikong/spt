package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.controller;

import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

@Api(tags="企业统计")
@RestController
@RequestMapping("/qyaqjcgl/statistics")
public class StatisticsController {

    @Autowired
    private IStatisticsService statisticsService;


    /**
     * 获取综合统计数据
     * @param countycode 区县编码
     * @param yqType 园区类型
     * @param companyCode 企业编码
     * @param isScqy 是否生产企业
     * @return
     */
    @GetMapping("/comprehensive")
    @ApiOperation("企业安全基础管理数据接入情况")
    public Result<?> getComprehensiveStats(@RequestParam(required = false) String countycode,
                                           @RequestParam(required = false) Integer yqType,
                                           @RequestParam(required = false) String companyCode,
                                           @RequestParam(required = false) Integer isScqy) {
        Map<String, Object> stats = statisticsService.getComprehensiveStats(
                countycode, yqType, companyCode, isScqy
        );
        return Result.OK(stats);
    }


}