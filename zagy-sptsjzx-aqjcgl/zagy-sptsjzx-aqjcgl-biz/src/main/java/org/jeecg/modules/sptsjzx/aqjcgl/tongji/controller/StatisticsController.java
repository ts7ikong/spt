package org.jeecg.modules.sptsjzx.aqjcgl.tongji.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.DataScopeHelper;
import org.jeecg.modules.sptsjzx.aqjcgl.qyjbxx.service.IAqAcceptCompanyService;
import org.jeecg.modules.sptsjzx.aqjcgl.tongji.service.StatisticsService;
import org.jeecg.modules.sptsjzx.aqjcgl.tongji.vo.RiskGradeControlResVO;
import org.jeecg.modules.sptsjzx.aqjcgl.tongji.vo.StatisticsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * 数据统计Controller
 */
@Api(tags = "数据统计接口-统计总数")
@RestController
@RequestMapping("/api/statistics")
@Slf4j
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private IAqAcceptCompanyService aqAcceptCompanyService;


    @ApiOperation(value = "风险分级管控", notes = "风险分级管控")
    @GetMapping(value = "/countRiskGradeControl")
    public Result<RiskGradeControlResVO> countRiskGradeControl(
            @ApiParam(value = "区县编码", required = false)
            @RequestParam(required = false) String countycode,

            @ApiParam(value = "企业编码", required = false)
            @RequestParam(required = false) String companyCode,

            @ApiParam(value = "园区类型", required = false)
            @RequestParam(required = false) Integer yqType,

            @ApiParam(value = "园区编码", required = false)
            @RequestParam(required = false) String parkCode,

            @ApiParam(value = "是否生产企业(0-否,1-是)", required = false)
            @RequestParam(required = false) Integer isScqy) {

        try {
            String orgCode = DataScopeHelper.getCurrentUserOrgCode();
            List<String> companyCodes = null;
            String filterCountycode = null;

            // 【新增】优先处理 companyCode 精确查询
            if (StringUtils.hasText(companyCode)) {
                companyCode = companyCode.trim();

                // 查询该企业所属区县
                String companyCountyCode = aqAcceptCompanyService.getCompanyCountyCodeByCode(companyCode);
                if (companyCountyCode == null) {
                    // 企业不存在，返回空 VO
                    return Result.OK(new RiskGradeControlResVO());
                }

                // 数据权限校验
                if ("500000".equals(orgCode)) {
                    // 市级账号：允许查询
                    companyCodes = Collections.singletonList(companyCode);
                    filterCountycode = companyCountyCode; // 园区按企业所在区县过滤
                } else {
                    // 区县账号：只能查自己辖区
                    if (!orgCode.equals(companyCountyCode)) {
                        return Result.OK(new RiskGradeControlResVO()); // 无权限
                    }
                    companyCodes = Collections.singletonList(companyCode);
                    filterCountycode = orgCode;
                }
            } else {
                // 【原有逻辑】未传 companyCode，走区县权限
                if ("500000".equals(orgCode)) {
                    if (StringUtils.hasText(countycode)) {
                        companyCodes = aqAcceptCompanyService.getCompanyCodesByCountyCode(countycode);
                        filterCountycode = countycode;
                    } else {
                        companyCodes = null;
                        filterCountycode = null;
                    }
                } else {
                    if (StringUtils.hasText(countycode) && !orgCode.equals(countycode)) {
                        return Result.OK(new RiskGradeControlResVO());
                    }
                    companyCodes = aqAcceptCompanyService.getCompanyCodesByCountyCode(orgCode);
                    filterCountycode = orgCode;
                }
            }

            // 调用 service（注意：parkCode 参数在原方法中未使用，但保留签名一致性）
            return statisticsService.countRiskGradeControl(filterCountycode, yqType, companyCodes, isScqy);

        } catch (Exception e) {
            log.error("获取风险分级管控统计数据失败", e);
            return Result.error("获取风险分级管控统计数据失败: " + e.getMessage());
        }
    }

    /**
     * 获取统计数据
     */
    @ApiOperation(value = "获取统计数据", notes = "统计区县数、园区数、企业数、生产企业数、重大危险源企业数")
    @GetMapping("/overview")
    public Result<StatisticsVO> getStatistics(
            @ApiParam(value = "区县编码", required = false) @RequestParam(required = false) String countycode,
            @ApiParam(value = "企业编码", required = false) @RequestParam(required = false) String companyCode,
            @ApiParam(value = "园区类型", required = false) @RequestParam(required = false) Integer yqType,
            @ApiParam(value = "园区编码", required = false) @RequestParam(required = false) String parkCode,
            @ApiParam(value = "是否生产企业(0-否,1-是)", required = false) @RequestParam(required = false) Integer isScqy) {

        try {
            // 【数据权限过滤】
            String orgCode = DataScopeHelper.getCurrentUserOrgCode();
            List<String> companyCodes = null;
            String filterCountycode = null;

            // 优先处理 companyCode 精确查询
            if (companyCode != null && !companyCode.trim().isEmpty()) {
                companyCode = companyCode.trim();

                // 【关键】查出该企业所属区县
                String companyCountyCode = aqAcceptCompanyService.getCompanyCountyCodeByCode(companyCode);
                if (companyCountyCode == null) {
                    // 企业不存在，返回空统计（不报错，避免信息泄露）
                    return Result.OK(new StatisticsVO());
                }

                // 【关键】数据权限校验
                if ("500000".equals(orgCode)) {
                    // 市级账号：允许查任何企业
                    companyCodes = Collections.singletonList(companyCode);
                    filterCountycode = companyCountyCode; // 园区按企业所在区县过滤
                } else {
                    // 区县账号：只能查自己辖区的企业
                    if (!orgCode.equals(companyCountyCode)) {
                        return Result.OK(new StatisticsVO()); // 无权限
                    }
                    companyCodes = Collections.singletonList(companyCode);
                    filterCountycode = orgCode;
                }
            } else {
                // 没有 companyCode，走原有区县逻辑
                if ("500000".equals(orgCode)) {
                    // 市级账号
                    if (countycode != null && !countycode.isEmpty()) {
                        companyCodes = aqAcceptCompanyService.getCompanyCodesByCountyCode(countycode);
                        filterCountycode = countycode;
                    } else {
                        companyCodes = null;
                        filterCountycode = null;
                    }
                } else {
                    // 区县账号
                    if (countycode != null && !countycode.isEmpty()) {
                        if (!orgCode.equals(countycode)) {
                            return Result.OK(new StatisticsVO());
                        }
                    }
                    companyCodes = aqAcceptCompanyService.getCompanyCodesByCountyCode(orgCode);
                    filterCountycode = orgCode;
                }
            }

            // 调用 service
            StatisticsVO statistics = statisticsService.getStatistics(
                    null,
                    filterCountycode,
                    yqType,
                    parkCode,
                    companyCodes,
                    isScqy
            );
            return Result.OK(statistics);
        } catch (Exception e) {
            log.error("获取统计数据失败", e);
            return Result.error("获取统计数据失败: " + e.getMessage());
        }
    }
}