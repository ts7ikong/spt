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
     * @param companyCode 企业编码
     * @param isScqy 是否生产企业
     * @return
     */
    @GetMapping("/comprehensive")
    @ApiOperation("企业安全基础管理数据接入情况")
    public Result<?> getComprehensiveStats(@RequestParam(required = false) String countycode,
                                           @RequestParam(required = false) Integer yqType,
                                           @RequestParam(required = false) String parkCode,
                                           @RequestParam(required = false) String companyCode,
                                           @RequestParam(required = false) Integer isScqy) {
        // 【数据权限过滤】根据登录用户的区县编码获取企业列表
        List<String> companyCodes = null;
        if (DataScopeHelper.needDataScope()) {
            String orgCode = DataScopeHelper.getCurrentUserOrgCode();
            companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
            // 如果前端传了companyCode,验证是否在权限范围内
            if (companyCode != null && !companyCode.isEmpty()) {
                if (!companyCodes.contains(companyCode)) {
                    // 前端传的企业不在权限范围内,返回空数据
                    return Result.OK(null);
                }
                // 前端传的企业在权限范围内,只查询该企业
                companyCodes = java.util.Collections.singletonList(companyCode);
            }
        } else if (companyCode != null && !companyCode.isEmpty()) {
            // 市级账号且指定了企业,只查询该企业
            companyCodes = java.util.Collections.singletonList(companyCode);
        }

        Map<String, Object> stats = statisticsService.getComprehensiveStats(
                countycode, yqType, parkCode, companyCodes, isScqy
        );
        return Result.OK(stats);
    }


}