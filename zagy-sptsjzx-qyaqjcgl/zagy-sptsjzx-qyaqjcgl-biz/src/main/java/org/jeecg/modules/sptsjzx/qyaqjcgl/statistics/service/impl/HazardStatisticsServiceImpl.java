package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper.HazardStatisticsMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.service.IHazardStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@DS("zfd")
public class HazardStatisticsServiceImpl implements IHazardStatisticsService {

    @Autowired
    private HazardStatisticsMapper hazardStatisticsMapper;

    @Override
    public Map<String, Object> getHazardManagementStats(String countycode, Integer yqType,
                                                        String companyCode, Integer isScqy) {
        Map<String, Object> result = new HashMap<>();

        // 1. 获取危险源接入情况统计（企业数量）(饼图)
        List<Map<String, Object>> classificationStats = hazardStatisticsMapper.getHazardAccessStats(
                countycode, yqType, companyCode, isScqy
        );
        result.put("hazardClassificationStats", classificationStats);

        // 2. 获取危险源等级统计(柱状图)
        List<Map<String, Object>> levelStats = hazardStatisticsMapper.getHazardLevelStats(
                countycode, yqType, companyCode, isScqy
        );
        result.put("hazardLevelStats", levelStats);

        // 3. 获取当日安全承诺统计
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Map<String, Object> commitmentStats = hazardStatisticsMapper.getTodayCommitmentStats(
                countycode, yqType, companyCode, isScqy, today
        );
        result.put("commitmentStats", commitmentStats);

        // 4. 获取预警和警示统计
        Map<String, Object> warningStats = hazardStatisticsMapper.getWarningStats(
                countycode, yqType, companyCode, isScqy
        );
        result.putAll(warningStats);

        return result;
    }
}