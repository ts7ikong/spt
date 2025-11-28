package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.controller;

import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IHazardStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

@Api(tags="重大危险源管理统计")
@RestController
@RequestMapping("/qyaqjcgl/statistics")
public class HazardStatisticsController {

    @Autowired
    private IHazardStatisticsService hazardStatisticsService;

    /**
     * 获取重大危险源管理统计数据
     * @param countycode 区县编码
     * @param yqType 园区类型
     * @param companyCode 企业编码
     * @param isScqy 是否生产企业
     * @return
     */
    @ApiOperation(value="重大危险源管理统计", notes="重大危险源管理统计")
    @GetMapping("/hazardManagement")
    public Result<?> getHazardManagementStats(@RequestParam(required = false) String countycode,
                                                @RequestParam(required = false) Integer yqType,
                                                @RequestParam(required = false) String companyCode,
                                                @RequestParam(required = false) Integer isScqy) {
        Map<String, Object> stats = hazardStatisticsService.getHazardManagementStats(
            countycode, yqType, companyCode, isScqy
        );
        return Result.OK(stats);
    }
}