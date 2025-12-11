package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.controller;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.DataScopeHelper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IQyStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

@Api(tags="企业统计")
@RestController
@RequestMapping("/qyaqjcgl/statistics")
public class QyStatisticsController {

    @Autowired
    private IQyStatisticsService statisticsService;


    /**
     * 获取综合统计数据
     * @param countycode 区县编码
     * @param yqType 园区类型
     * @param parkCode 园区编码
     * @param isScqy 是否生产企业
     * @return
     */
    @GetMapping("/comprehensive")
    @ApiOperation("企业安全基础管理数据接入情况")
    public Result<?> getComprehensiveStats(@RequestParam(required = false) String countycode,
                                           @RequestParam(required = false) Integer yqType,
                                           @RequestParam(required = false) String parkCode,
                                           @RequestParam(required = false) Integer isScqy) {
        // 【数据权限过滤】
        String citycode = null;
        String orgCode = DataScopeHelper.getCurrentUserOrgCode();

        if ("500000".equals(orgCode)) {
            // 市级账号
            if (countycode != null && !countycode.isEmpty()) {
                // 前端传了countycode，查询该区县的数据
                // countycode使用前端传入的值
            } else {
                // 前端没传countycode，查询全市数据
                citycode = "500000";
            }
        } else {
            // 区县账号
            if (countycode != null && !countycode.isEmpty()) {
                // 前端传了countycode，验证是否是自己的区县
                if (!orgCode.equals(countycode)) {
                    // 不是自己的区县，返回空数据
                    return Result.OK(null);
                }
            } else {
                // 前端没传countycode，使用自己的区县code
                countycode = orgCode;
            }
        }

        Map<String, Object> stats = statisticsService.getComprehensiveStats(
                citycode, countycode, yqType, parkCode, null, isScqy
        );
        return Result.OK(stats);
    }


}