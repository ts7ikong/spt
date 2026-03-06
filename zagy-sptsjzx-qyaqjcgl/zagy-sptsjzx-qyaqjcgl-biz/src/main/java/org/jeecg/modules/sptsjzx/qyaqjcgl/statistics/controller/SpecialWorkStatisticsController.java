package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jeecg.common.util.DataScopeHelper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.SpecialWorkStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.ISpecialWorkStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.jeecg.common.api.vo.Result;

import java.util.Collections;
import java.util.List;

@Slf4j
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

            @ApiParam("企业编码") @RequestParam(required = false) String companyCode,

            @ApiParam("园区类型") @RequestParam(required = false) Integer yqType,
            @ApiParam("园区编码") @RequestParam(required = false) String parkCode,
            @ApiParam("是否生产企业") @RequestParam(required = false) Integer isScqy) {

        try {
            long t0 = System.currentTimeMillis();
            String orgCode = DataScopeHelper.getCurrentUserOrgCode();
            List<String> companyCodes = null;
            String filterCountycode = null;

            // 【新增】优先处理 companyCode 精确查询
            if (StringUtils.hasText(companyCode)) {
                companyCode = companyCode.trim();

                // 查询该企业所属区县
                long tq1 = System.currentTimeMillis();
                String companyCountyCode = acceptCompanyService.getCompanyCountyCodeByCode(companyCode);
                log.info("[SpecialWork-timing] getCompanyCountyCodeByCode: {}ms", System.currentTimeMillis() - tq1);
                if (companyCountyCode == null) {
                    // 企业不存在，返回 null（或可改为 new SpecialWorkStatisticsDTO()）
                    return Result.ok(null);
                }

                // 数据权限校验
                if ("500000".equals(orgCode)) {
                    // 市级账号：允许查询
                    companyCodes = Collections.singletonList(companyCode);
                    filterCountycode = companyCountyCode; // 园区按企业所在区县过滤
                } else {
                    // 区县账号：只能查自己辖区
                    if (!orgCode.equals(companyCountyCode)) {
                        return Result.ok(null); // 无权限
                    }
                    companyCodes = Collections.singletonList(companyCode);
                    filterCountycode = orgCode;
                }
            } else {
                // 【原有逻辑】未传 companyCode，走区县权限
                if ("500000".equals(orgCode)) {
                    if (StringUtils.hasText(countycode)) {
                        long tq2 = System.currentTimeMillis();
                        companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(countycode);
                        log.info("[SpecialWork-timing] getCompanyCodesByCountyCode(countycode): {}ms, size={}",
                                System.currentTimeMillis() - tq2, companyCodes == null ? 0 : companyCodes.size());
                        filterCountycode = countycode;
                    } else {
                        companyCodes = null;
                        filterCountycode = null;
                    }
                } else {
                    if (StringUtils.hasText(countycode) && !orgCode.equals(countycode)) {
                        return Result.ok(null);
                    }
                    long tq3 = System.currentTimeMillis();
                    companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
                    log.info("[SpecialWork-timing] getCompanyCodesByCountyCode(orgCode): {}ms, size={}",
                            System.currentTimeMillis() - tq3, companyCodes == null ? 0 : companyCodes.size());
                    filterCountycode = orgCode;
                }
            }

            long tController = System.currentTimeMillis() - t0;
            // 调用 service
            long tSvc = System.currentTimeMillis();
            SpecialWorkStatisticsDTO statistics = service.getSpecialWorkStatistics(
                    filterCountycode, yqType, parkCode, companyCodes, isScqy
            );
            log.info("[SpecialWork-timing] controller权限处理: {}ms | service: {}ms | 总计: {}ms",
                    tController, System.currentTimeMillis() - tSvc, System.currentTimeMillis() - t0);
            return Result.ok(statistics);

        } catch (Exception e) {
            return Result.error("获取特殊作业安全管控统计数据失败: " + e.getMessage());
        }
    }
}