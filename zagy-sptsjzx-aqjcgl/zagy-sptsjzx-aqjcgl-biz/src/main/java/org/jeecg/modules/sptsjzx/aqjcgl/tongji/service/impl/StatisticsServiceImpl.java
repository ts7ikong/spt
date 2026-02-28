package org.jeecg.modules.sptsjzx.aqjcgl.tongji.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.sptsjzx.aqjcgl.tongji.mapper.TjAcceptCompanyMapper;
import org.jeecg.modules.sptsjzx.aqjcgl.tongji.service.StatisticsService;
import org.jeecg.modules.sptsjzx.aqjcgl.tongji.vo.RiskGradeControlResVO;
import org.jeecg.modules.sptsjzx.aqjcgl.tongji.vo.StatisticsVO;
import org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.yqjbxx.mapper.YqjbxxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 数据统计Service实现类
 */
@Service
@Slf4j
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private YqjbxxMapper yqjbxxMapper;

    @Autowired
    private TjAcceptCompanyMapper tjAcceptCompanyMapper;

    @Override
    public Result<RiskGradeControlResVO> countRiskGradeControl(String countycode, Integer yqType, List<String> companyCodes, Integer isScqy) {
        try {
            RiskGradeControlResVO resVO = new RiskGradeControlResVO();

            // 1. 查询接入情况
            List<Map<String, Object>> accessStatusList = tjAcceptCompanyMapper.countAccessStatus(
                    countycode, yqType, companyCodes, isScqy);

            // 确保返回已接入和未接入两个状态，如果某个状态没有数据，补充为0
            if (accessStatusList == null || accessStatusList.isEmpty()) {
                accessStatusList = new ArrayList<>();
                Map<String, Object> map1 = new HashMap<>();
                map1.put("name", "已接入");
                map1.put("value", 0);
                accessStatusList.add(map1);

                Map<String, Object> map2 = new HashMap<>();
                map2.put("name", "未接入");
                map2.put("value", 0);
                accessStatusList.add(map2);
            } else {
                // 检查是否缺少某个状态
                boolean hasAccessed = false;
                boolean hasNotAccessed = false;
                for (Map<String, Object> map : accessStatusList) {
                    String name = (String) map.get("name");
                    if ("已接入".equals(name)) {
                        hasAccessed = true;
                    } else if ("未接入".equals(name)) {
                        hasNotAccessed = true;
                    }
                }

                if (!hasAccessed) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", "已接入");
                    map.put("value", 0);
                    accessStatusList.add(map);
                }

                if (!hasNotAccessed) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", "未接入");
                    map.put("value", 0);
                    accessStatusList.add(map);
                }
            }
            resVO.setAccessStatus(accessStatusList);

            // 2. 查询运行情况
            Map<String, Object> runLevelMap = tjAcceptCompanyMapper.countRunLevel(
                    countycode, yqType, companyCodes, isScqy);

            RiskGradeControlResVO.RunLevelVO runLevelVO = new RiskGradeControlResVO.RunLevelVO();
            if (runLevelMap != null) {
                runLevelVO.setExcellent(runLevelMap.get("excellent") != null ?
                        ((Number) runLevelMap.get("excellent")).intValue() : 0);
                runLevelVO.setGood(runLevelMap.get("good") != null ?
                        ((Number) runLevelMap.get("good")).intValue() : 0);
                runLevelVO.setMedium(runLevelMap.get("medium") != null ?
                        ((Number) runLevelMap.get("medium")).intValue() : 0);
                runLevelVO.setPoor(runLevelMap.get("poor") != null ?
                        ((Number) runLevelMap.get("poor")).intValue() : 0);
            }
            resVO.setRunLevel(runLevelVO);


            RiskGradeControlResVO.RiskControlVO riskControlVO = new RiskGradeControlResVO.RiskControlVO();
            Integer unitCount = tjAcceptCompanyMapper.countUnit(companyCodes);
            Integer eventCount = tjAcceptCompanyMapper.countEvent(companyCodes);
            Integer measuresCount = tjAcceptCompanyMapper.countMeasures(companyCodes);
            Integer taskCount = tjAcceptCompanyMapper.countTask(companyCodes);

            riskControlVO.setUnitCount(unitCount != null ? unitCount : 0);
            riskControlVO.setEventCount(eventCount != null ? eventCount : 0);
            riskControlVO.setMeasuresCount(measuresCount != null ? measuresCount : 0);
            riskControlVO.setTaskCount(taskCount != null ? taskCount : 0);
            resVO.setRiskControl(riskControlVO);

            // 4. 查询隐患排查治理情况
            RiskGradeControlResVO.DangerInvestigationVO dangerInvestigationVO =
                    new RiskGradeControlResVO.DangerInvestigationVO();

            Map<String, Object> dangerMap = tjAcceptCompanyMapper.countDangerInvestigation(companyCodes);

            if (dangerMap != null) {
                dangerInvestigationVO.setGeneralDanger(dangerMap.get("generalDanger") != null ?
                        ((Number) dangerMap.get("generalDanger")).intValue() : 0);
                dangerInvestigationVO.setMajorDanger(dangerMap.get("majorDanger") != null ?
                        ((Number) dangerMap.get("majorDanger")).intValue() : 0);
                dangerInvestigationVO.setRectifying(dangerMap.get("rectifying") != null ?
                        ((Number) dangerMap.get("rectifying")).intValue() : 0);
                dangerInvestigationVO.setOverdue(dangerMap.get("overdue") != null ?
                        ((Number) dangerMap.get("overdue")).intValue() : 0);
            }
            resVO.setDangerInvestigation(dangerInvestigationVO);

            return Result.OK(resVO);
        } catch (Exception e) {
            log.error("统计风险分级管控数据失败", e);
            return Result.error("统计风险分级管控数据失败: " + e.getMessage());
        }
    }

    @Override
    public StatisticsVO getStatistics(String citycode, String countycode, Integer yqType, String parkCode, List<String> companyCodes, Integer isScqy) {
//        log.info("开始获取统计数据, citycode={}, countycode={}, yqType={}, parkCode={}, companyCodes={}, isScqy={}", citycode, countycode, yqType, parkCode, companyCodes, isScqy);

        StatisticsVO vo = new StatisticsVO();
        // 查询区县数
        Long countyCount = tjAcceptCompanyMapper.countCounties(citycode, countycode, yqType, parkCode, companyCodes, isScqy);
        vo.setCountyCount(countyCount);

        // 查询园区数 这里要把特殊园区筛选掉 不要这个园区 我这里就直接在mapper层里面写死不查询
        Long parkCount = yqjbxxMapper.countParks(parkCode, countycode);
        //这里要求把特殊园区减掉
        vo.setParkCount(parkCount);

        // 查询企业数
        Long companyCount = tjAcceptCompanyMapper.countCompanies(citycode, countycode, yqType, parkCode, companyCodes, isScqy);
        vo.setCompanyCount(companyCount);

        // 查询生产企业数
        Long productionCompanyCount = tjAcceptCompanyMapper.countProductionCompanies(citycode, countycode, yqType, parkCode, companyCodes);
        vo.setProductionCompanyCount(productionCompanyCount);

        // 查询重大危险源企业数
        Long majorHazardCompanyCount = tjAcceptCompanyMapper.countMajorHazardCompanies(citycode, countycode, yqType, parkCode, companyCodes, isScqy);
        vo.setMajorHazardCompanyCount(majorHazardCompanyCount);

        log.info("统计数据获取完成: {}", vo);

        return vo;
    }


}