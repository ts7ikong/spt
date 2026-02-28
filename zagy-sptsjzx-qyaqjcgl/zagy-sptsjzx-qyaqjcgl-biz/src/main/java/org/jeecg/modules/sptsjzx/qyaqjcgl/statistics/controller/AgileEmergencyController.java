package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.controller;

import io.micrometer.core.instrument.util.StringUtils;
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

import java.util.Collections;
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
            @ApiParam("区县编码") @RequestParam(required = false) String countycode,
            @ApiParam("演练类型") @RequestParam(required = false) String drillType) {

        List<String> yqCodes = Collections.emptyList();

        if (DataScopeHelper.needDataScope()) {
            // ========== 市级平台账号 ==========
            if (StringUtils.isNotBlank(parkCode)) {
                // 优先使用 parkCode，直接查询该园区
                yqCodes = Collections.singletonList(parkCode);
            } else if (StringUtils.isNotBlank(countycode)) {
                // 没传 parkCode，但传了 countycode → 查该区县所有园区
                yqCodes = acceptCompanyService.getYqCodesByCountyCode(countycode);
                if (yqCodes.isEmpty()) {
                    return Result.OK(); // 没数据直接返空
                }
            } else {
                // 两者都没传 → 查所有园区（由 service 层处理）
                yqCodes = acceptCompanyService.getYqCodesByCountyCode(null);
            }

        } else {
            // ========== 区县/园区账号 ==========
            String currentOrgCode = DataScopeHelper.getCurrentUserOrgCode();
            if (StringUtils.isBlank(currentOrgCode)) {
                return Result.OK(); // 无所属区县，无权限
            }

            // 校验 countycode（如果传了，必须等于当前区县）
            if (StringUtils.isNotBlank(countycode) && !currentOrgCode.equals(countycode)) {
                return Result.OK();
            }

            if (StringUtils.isNotBlank(parkCode)) {
                // 指定了具体园区：校验是否属于当前区县
                List<String> allowedYqCodes = acceptCompanyService.getYqCodesByCountyCode(currentOrgCode);
                if (allowedYqCodes == null) {
                    allowedYqCodes = Collections.emptyList();
                }
                if (!allowedYqCodes.contains(parkCode)) {
                    return Result.OK(); // 园区不属于当前区县
                }
                yqCodes = Collections.singletonList(parkCode); // 只查这个园区
            } else {
                // 未指定园区：查当前区县下所有园区
                yqCodes = acceptCompanyService.getYqCodesByCountyCode(currentOrgCode);
                if (yqCodes.isEmpty()) {
                    return Result.OK(); // 无所属区县，无权限
                }
            }
        }

        // companyCodes用于企业表过滤，filterCountycode用于园区表过滤
        AgileEmergencyStatisticsDTO statistics = service.getAgileEmergencyStatistics(yqCodes, drillType);

        return Result.ok(statistics);
    }
}