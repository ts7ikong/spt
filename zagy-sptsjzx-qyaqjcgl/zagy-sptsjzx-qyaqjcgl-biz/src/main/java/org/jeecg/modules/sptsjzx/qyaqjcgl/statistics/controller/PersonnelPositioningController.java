package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.dto.PersonnelPositioningStatisticsDTO;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IPersonnelPositioningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "人员定位统计")
@RestController
@RequestMapping("/qyaqjcgl/statistics")
public class PersonnelPositioningController {

    @Autowired
    private IPersonnelPositioningService service;

    @ApiOperation("获取人员定位统计数据")
    @GetMapping("/personnelPositioning")
    public Result<PersonnelPositioningStatisticsDTO> getPersonnelPositioningStatistics(
            @ApiParam("区县编码") @RequestParam(required = false) String countycode,
            @ApiParam("园区类型") @RequestParam(required = false) Integer yqType,
            @ApiParam("企业编码") @RequestParam(required = false) String companyCode,
            @ApiParam("是否生产企业") @RequestParam(required = false) Integer isScqy,
            @ApiParam("报警状态: all-全部, alarming-报警中, dispelled-已消警")
            @RequestParam(required = false, defaultValue = "all") String alarmStatus) {

        PersonnelPositioningStatisticsDTO statistics = service.getPersonnelPositioningStatistics(
                countycode, yqType, companyCode, isScqy, alarmStatus
        );

        return Result.ok(statistics);
    }
}