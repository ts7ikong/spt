package org.jeecg.modules.sptsjzx.aqjcgl.tongji.service;

import org.jeecg.modules.sptsjzx.aqjcgl.tongji.vo.StatisticsVO;

/**
 * 数据统计Service接口
 */
public interface StatisticsService {

    /**
     * 获取统计数据
     *
     * @param countycode 区县编码
     * @param yqType     园区类型
     * @param isScqy     是否生产企业
     * @return 统计结果
     */
    StatisticsVO getStatistics(String countycode, Integer yqType, Integer isScqy);
}