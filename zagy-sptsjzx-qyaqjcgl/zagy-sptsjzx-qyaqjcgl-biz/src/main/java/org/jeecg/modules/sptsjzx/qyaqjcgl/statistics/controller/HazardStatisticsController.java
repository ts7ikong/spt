package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.controller;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.DataScopeHelper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IHazardStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;

@Api(tags="重大危险源管理统计")
@RestController
@RequestMapping("/qyaqjcgl/statistics")
public class HazardStatisticsController {

    @Autowired
    private IHazardStatisticsService hazardStatisticsService;

    @Autowired
    private IAcceptCompanyService acceptCompanyService;

    /**
     * 获取重大危险源管理统计数据
     * @param countycode 区县编码
     * @param yqType 园区类型
     * @param parkCode 园区编码
     * @param companyCode 企业编码
     * @param isScqy 是否生产企业
     * @return
     */
    @ApiOperation(value="重大危险源管理统计", notes="重大危险源管理统计")
    @GetMapping("/hazardManagement")
    public Result<?> getHazardManagementStats(@RequestParam(required = false) String countycode,
                                                @RequestParam(required = false) Integer yqType,
                                                @RequestParam(required = false) String parkCode,
                                                @RequestParam(required = false) String companyCode,
                                                @RequestParam(required = false) Integer isScqy) {

        // 【数据权限过滤】
        // 企业表用 companyCodes 过滤
        // 园区表用 countycode 过滤
        String orgCode = DataScopeHelper.getCurrentUserOrgCode();
        List<String> companyCodes = null;
        String filterCountycode = null;

        if ("500000".equals(orgCode)) {
            // 市级账号
            if (countycode != null && !countycode.isEmpty()) {
                // 前端传了countycode，查询该区县的企业列表和园区
                companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(countycode);
                filterCountycode = countycode;
            } else {
                // 前端没传countycode，不过滤（查询所有）
                companyCodes = null;
                filterCountycode = null;
            }

            // 如果前端指定了companyCode，只查该企业
            if (companyCode != null && !companyCode.isEmpty()) {
                companyCodes = java.util.Collections.singletonList(companyCode);
            }
        } else {
            // 区县账号：查询自己区县的企业列表和园区
            companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
            filterCountycode = orgCode;

            // 如果前端传了countycode，验证是否是自己的区县
            if (countycode != null && !countycode.isEmpty()) {
                if (!orgCode.equals(countycode)) {
                    // 不是自己的区县，返回空数据
                    return Result.OK(null);
                }
            }

            // 如果前端指定了companyCode，验证权限后只查该企业
            if (companyCode != null && !companyCode.isEmpty()) {
                if (!companyCodes.contains(companyCode)) {
                    // 前端传的企业不在权限范围内，返回空数据
                    return Result.OK(null);
                }
                companyCodes = java.util.Collections.singletonList(companyCode);
            }
        }

        // companyCodes用于企业表过滤，filterCountycode用于园区表过滤
        Map<String, Object> stats = hazardStatisticsService.getHazardManagementStats(
            filterCountycode, yqType, parkCode, companyCodes, isScqy
        );
        return Result.OK(stats);
    }
}