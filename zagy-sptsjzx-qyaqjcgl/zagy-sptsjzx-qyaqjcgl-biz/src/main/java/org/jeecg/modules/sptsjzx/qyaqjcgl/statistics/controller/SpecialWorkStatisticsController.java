package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jeecg.common.util.DataScopeHelper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.SpecialWorkStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.ISpecialWorkStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.jeecg.common.api.vo.Result;

import java.util.List;

@Api(tags = "特殊作业安全管控统计")
@RestController
@RequestMapping("/qyaqjcgl/statistics")
public class SpecialWorkStatisticsController {

    @Autowired
    private ISpecialWorkStatisticsService service;

    @Autowired
    private IAcceptCompanyService acceptCompanyService;

    @ApiOperation("获取特殊作业安全管控统计数据")
    @GetMapping("/specialWork")
    public Result<SpecialWorkStatisticsDTO> getSpecialWorkStatistics(
            @ApiParam("区县编码") @RequestParam(required = false) String countycode,
            @ApiParam("园区类型") @RequestParam(required = false) Integer yqType,
            @ApiParam("园区编码") @RequestParam(required = false) String parkCode,
            @ApiParam("是否生产企业") @RequestParam(required = false) Integer isScqy) {

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
        } else {
            // 区县账号：查询自己区县的企业列表和园区
            companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
            filterCountycode = orgCode;

            // 如果前端传了countycode，验证是否是自己的区县
            if (countycode != null && !countycode.isEmpty()) {
                if (!orgCode.equals(countycode)) {
                    // 不是自己的区县，返回空数据
                    return Result.ok(null);
                }
            }
        }

        // companyCodes用于企业表过滤，filterCountycode用于园区表过滤
        SpecialWorkStatisticsDTO statistics = service.getSpecialWorkStatistics(
                filterCountycode, yqType, parkCode, companyCodes, isScqy
        );

        return Result.ok(statistics);
    }
}