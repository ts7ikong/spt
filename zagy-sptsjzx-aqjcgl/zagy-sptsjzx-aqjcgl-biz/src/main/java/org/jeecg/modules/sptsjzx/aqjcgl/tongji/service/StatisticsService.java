package org.jeecg.modules.sptsjzx.aqjcgl.tongji.service;

import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.sptsjzx.aqjcgl.tongji.vo.RiskGradeControlResVO;
import org.jeecg.modules.sptsjzx.aqjcgl.tongji.vo.StatisticsVO;

import java.util.List;

/**
 * 数据统计Service接口
 */
public interface StatisticsService {

    /**
     * 获取统计数据
     *
     * @param citycode 城市编码
     * @param countycode 区县编码
     * @param yqType     园区类型
     * @param parkCode   园区编码
     * @param companyCodes 企业编码列表
     * @param isScqy     是否生产企业
     * @return 统计结果
     */
    StatisticsVO getStatistics(String citycode, String countycode, Integer yqType, String parkCode, List<String> companyCodes, Integer isScqy);

    Result<RiskGradeControlResVO> countRiskGradeControl(String countycode, Integer yqType, List<String> companyCodes, Integer isScqy);
}