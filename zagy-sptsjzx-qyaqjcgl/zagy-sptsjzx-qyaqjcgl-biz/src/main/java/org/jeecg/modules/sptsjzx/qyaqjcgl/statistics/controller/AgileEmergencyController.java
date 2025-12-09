package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.DataScopeHelper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.AgileEmergencyStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IAgileEmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "敏捷应急统计")
@RestController
@RequestMapping("/qyaqjcgl/statistics")
public class AgileEmergencyController {

    @Autowired
    private IAgileEmergencyService service;

    @Autowired
    private IAcceptCompanyService acceptCompanyService;

    @ApiOperation("获取敏捷应急统计数据")
    @GetMapping("/agileEmergency")
    public Result<AgileEmergencyStatisticsDTO> getAgileEmergencyStatistics(
            @ApiParam("园区编码") @RequestParam(required = false) String parkCode,
            @ApiParam("企业编码") @RequestParam(required = false) String companyCode,
            @ApiParam("区县编码") @RequestParam(required = false) String countycode,
            @ApiParam("演练类型") @RequestParam(required = false) String drillType) {

        // 【数据权限过滤】根据登录用户的区县编码获取企业列表
        List<String> companyCodes = null;
        if (DataScopeHelper.needDataScope()) {
            String orgCode = DataScopeHelper.getCurrentUserOrgCode();
            companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
            // 如果前端传了companyCode,验证是否在权限范围内
            if (companyCode != null && !companyCode.isEmpty()) {
                if (!companyCodes.contains(companyCode)) {
                    // 前端传的企业不在权限范围内,返回空数据
                    return Result.ok(null);
                }
                // 前端传的企业在权限范围内,只查询该企业
                companyCodes = java.util.Collections.singletonList(companyCode);
            }
        } else if (companyCode != null && !companyCode.isEmpty()) {
            // 市级账号且指定了企业,只查询该企业
            companyCodes = java.util.Collections.singletonList(companyCode);
        }

        AgileEmergencyStatisticsDTO statistics = service.getAgileEmergencyStatistics(
                parkCode, companyCodes, countycode, drillType
        );

        return Result.ok(statistics);
    }
}