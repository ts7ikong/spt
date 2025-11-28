package org.jeecg.modules.sptsjzx.aqjcgl.tongji.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.sptsjzx.aqjcgl.tongji.service.StatisticsService;
import org.jeecg.modules.sptsjzx.aqjcgl.tongji.vo.StatisticsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据统计Controller
 */
@Api(tags = "数据统计接口-统计总数")
@RestController
@RequestMapping("/api/statistics")
@Slf4j
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    /**
     * 获取统计数据
     */
    @ApiOperation(value = "获取统计数据", notes = "统计区县数、园区数、企业数、生产企业数、重大危险源企业数")
    @GetMapping("/overview")
    public Result<StatisticsVO> getStatistics(
            @ApiParam(value = "区县编码", required = false) @RequestParam(required = false) String countycode,
            @ApiParam(value = "园区类型", required = false) @RequestParam(required = false) Integer yqType,
            @ApiParam(value = "是否生产企业(0-否,1-是)", required = false) @RequestParam(required = false) Integer isScqy) {
        
        try {
            StatisticsVO statistics = statisticsService.getStatistics(countycode, yqType, isScqy);
            return Result.OK(statistics);
        } catch (Exception e) {
            log.error("获取统计数据失败", e);
            return Result.error("获取统计数据失败: " + e.getMessage());
        }
    }
}