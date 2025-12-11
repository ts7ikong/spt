package org.jeecg.modules.sptsjzx.aqjcgl.tongji.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.DataScopeHelper;
import org.jeecg.modules.sptsjzx.aqjcgl.qyjbxx.service.IAqAcceptCompanyService;
import org.jeecg.modules.sptsjzx.aqjcgl.tongji.service.StatisticsService;
import org.jeecg.modules.sptsjzx.aqjcgl.tongji.vo.StatisticsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 获取统计数据
     */
    @ApiOperation(value = "获取统计数据", notes = "统计区县数、园区数、企业数、生产企业数、重大危险源企业数")
    @GetMapping("/overview")
    public Result<StatisticsVO> getStatistics(
            @ApiParam(value = "区县编码", required = false) @RequestParam(required = false) String countycode,
            @ApiParam(value = "园区类型", required = false) @RequestParam(required = false) Integer yqType,
            @ApiParam(value = "园区编码", required = false) @RequestParam(required = false) String parkCode,
            @ApiParam(value = "是否生产企业(0-否,1-是)", required = false) @RequestParam(required = false) Integer isScqy) {

        try {
            // 【数据权限过滤】先查询用户有权限的企业列表
            String orgCode = DataScopeHelper.getCurrentUserOrgCode();
            List<String> companyCodes = null;

            if ("500000".equals(orgCode)) {
                // 市级账号
                if (countycode != null && !countycode.isEmpty()) {
                    // 前端传了countycode，查询该区县的企业列表
                    companyCodes = aqAcceptCompanyService.getCompanyCodesByCountyCode(countycode);
                } else {
                    // 前端没传countycode，不过滤（查询所有）
                    companyCodes = null;
                }
            } else {
                // 区县账号：查询自己区县的企业列表
                companyCodes = aqAcceptCompanyService.getCompanyCodesByCountyCode(orgCode);

                // 如果前端传了countycode，验证是否是自己的区县
                if (countycode != null && !countycode.isEmpty()) {
                    if (!orgCode.equals(countycode)) {
                        // 不是自己的区县，返回空数据
                        return Result.OK(new StatisticsVO());
                    }
                }
            }

            // 使用企业列表过滤统计数据
            StatisticsVO statistics = statisticsService.getStatistics(null, null, yqType, parkCode, companyCodes, isScqy);
            return Result.OK(statistics);
        } catch (Exception e) {
            log.error("获取统计数据失败", e);
            return Result.error("获取统计数据失败: " + e.getMessage());
        }
    }
}