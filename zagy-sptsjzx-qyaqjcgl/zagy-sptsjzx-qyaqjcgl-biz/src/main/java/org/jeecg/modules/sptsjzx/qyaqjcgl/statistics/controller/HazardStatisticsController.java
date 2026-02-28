package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.controller;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.DataScopeHelper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IHazardStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Collections;
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
     /**
     * 获取重大危险源管理统计数据
     *
     * @param countycode   区县编码
     * @param companyCode  企业编码（新增）
     * @param yqType       园区类型
     * @param parkCode     园区编码
     * @param isScqy       是否生产企业
     * @return
     */
    @ApiOperation(value = "重大危险源管理统计", notes = "重大危险源管理统计")
    @GetMapping("/hazardManagement")
    public Result<?> getHazardManagementStats(
            @RequestParam(required = false) String countycode,

            @RequestParam(required = false) String companyCode,

            @RequestParam(required = false) Integer yqType,

            @RequestParam(required = false) String parkCode,

            @RequestParam(required = false) Integer isScqy) {

        try {
            String orgCode = DataScopeHelper.getCurrentUserOrgCode();
            List<String> companyCodes = null;
            String filterCountycode = null;

            // 【新增】优先处理 companyCode 精确查询
            if (StringUtils.hasText(companyCode)) {
                companyCode = companyCode.trim();

                // 查询该企业所属区县
                String companyCountyCode = acceptCompanyService.getCompanyCountyCodeByCode(companyCode);
                if (companyCountyCode == null) {
                    // 企业不存在，返回空数据（避免信息泄露）
                    return Result.OK(Collections.emptyMap());
                }

                // 数据权限校验
                if ("500000".equals(orgCode)) {
                    // 市级账号：允许查询
                    companyCodes = Collections.singletonList(companyCode);
                    filterCountycode = companyCountyCode; // 园区按企业所在区县过滤
                } else {
                    // 区县账号：只能查自己辖区
                    if (!orgCode.equals(companyCountyCode)) {
                        return Result.OK(Collections.emptyMap()); // 无权限
                    }
                    companyCodes = Collections.singletonList(companyCode);
                    filterCountycode = orgCode;
                }
            } else {
                // 【原有逻辑】未传 companyCode，走区县权限
                if ("500000".equals(orgCode)) {
                    if (StringUtils.hasText(countycode)) {
                        companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(countycode);
                        filterCountycode = countycode;
                    } else {
                        companyCodes = null;
                        filterCountycode = null;
                    }
                } else {
                    if (StringUtils.hasText(countycode) && !orgCode.equals(countycode)) {
                        return Result.OK(Collections.emptyMap());
                    }
                    companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
                    filterCountycode = orgCode;
                }
            }

            // 调用 service（注意参数顺序，你原方法第一个就是 filterCountycode）
            Map<String, Object> stats = hazardStatisticsService.getHazardManagementStats(
                    filterCountycode,
                    yqType,
                    parkCode,
                    companyCodes,
                    isScqy
            );
            return Result.OK(stats);

        } catch (Exception e) {
            return Result.error("获取重大危险源管理统计数据失败: " + e.getMessage());
        }
    }
}