package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.controller;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.DataScopeHelper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IQyStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;

@Api(tags="企业统计")
@RestController
@RequestMapping("/qyaqjcgl/statistics")
public class QyStatisticsController {

    @Autowired
    private IQyStatisticsService statisticsService;

    @Autowired
    private IAcceptCompanyService acceptCompanyService;


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
        // 【数据权限过滤】先查询用户有权限的企业列表
        String orgCode = DataScopeHelper.getCurrentUserOrgCode();
        List<String> companyCodes = null;

        if ("500000".equals(orgCode)) {
            // 市级账号
            if (countycode != null && !countycode.isEmpty()) {
                // 前端传了countycode，查询该区县的企业列表
                companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(countycode);
            } else {
                // 前端没传countycode，不过滤（查询所有）
                companyCodes = null;
            }
        } else {
            // 区县账号：查询自己区县的企业列表
            companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);

            // 如果前端传了countycode，验证是否是自己的区县
            if (countycode != null && !countycode.isEmpty()) {
                if (!orgCode.equals(countycode)) {
                    // 不是自己的区县，返回空数据
                    return Result.OK(null);
                }
            }
        }

        // 使用企业列表过滤统计数据
        Map<String, Object> stats = statisticsService.getComprehensiveStats(
                null, null, yqType, parkCode, companyCodes, isScqy
        );
        return Result.OK(stats);
    }


}