package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.DataScopeHelper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.PersonnelPositioningStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IPersonnelPositioningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@Api(tags = "人员定位统计")
@RestController
@RequestMapping("/qyaqjcgl/statistics")
public class PersonnelPositioningController {

    @Autowired
    private IPersonnelPositioningService service;

    @Autowired
    private IAcceptCompanyService acceptCompanyService;

    @ApiOperation("获取人员定位统计数据")
    @GetMapping("/personnelPositioning")
    public Result<PersonnelPositioningStatisticsDTO> getPersonnelPositioningStatistics(
            @ApiParam("区县编码") @RequestParam(required = false) String countycode,

            @ApiParam("企业编码") @RequestParam(required = false) String companyCode,

            @ApiParam("园区类型") @RequestParam(required = false) Integer yqType,
            @ApiParam("园区编码") @RequestParam(required = false) String parkCode,
            @ApiParam("是否生产企业") @RequestParam(required = false) Integer isScqy,
            @ApiParam("报警状态: all-全部, alarming-报警中, dispelled-已消警")
            @RequestParam(required = false, defaultValue = "all") String alarmStatus) {

//        try {
        String orgCode = DataScopeHelper.getCurrentUserOrgCode();
        List<String> companyCodes = null;
        String filterCountycode = null;

        // 【新增】优先处理 companyCode 精确查询
        if (StringUtils.hasText(companyCode)) {
            companyCode = companyCode.trim();

            // 查询该企业所属区县
            String companyCountyCode = acceptCompanyService.getCompanyCountyCodeByCode(companyCode);
            if (companyCountyCode == null) {
                // 企业不存在，返回 null（或可改为 new PersonnelPositioningStatisticsDTO()）
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
                    companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(countycode);
                    filterCountycode = countycode;
                } else {
                    companyCodes = null;
                    filterCountycode = null;
                }
            } else {
                if (StringUtils.hasText(countycode) && !orgCode.equals(countycode)) {
                    return Result.ok(null);
                }
                companyCodes = acceptCompanyService.getCompanyCodesByCountyCode(orgCode);
                filterCountycode = orgCode;
            }
        }

        // 调用 service（保留原有参数顺序，新增 companyCodes 已包含）
        PersonnelPositioningStatisticsDTO statistics = service.getPersonnelPositioningStatistics(
                filterCountycode,
                yqType,
                parkCode,
                companyCodes,
                isScqy,
                alarmStatus
        );

        return Result.ok(statistics);

//        } catch (Exception e) {
//            return Result.error("获取人员定位统计数据失败: " + e.getMessage());
//        }
    }
}