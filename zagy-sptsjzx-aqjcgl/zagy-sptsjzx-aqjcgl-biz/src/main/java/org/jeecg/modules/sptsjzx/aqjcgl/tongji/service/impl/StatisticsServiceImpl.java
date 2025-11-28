package org.jeecg.modules.sptsjzx.aqjcgl.tongji.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.jeecg.modules.sptsjzx.aqjcgl.tongji.mapper.TjAcceptCompanyMapper;
import org.jeecg.modules.sptsjzx.aqjcgl.tongji.service.StatisticsService;
import org.jeecg.modules.sptsjzx.aqjcgl.tongji.vo.StatisticsVO;
import org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.yqjbxx.mapper.YqjbxxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public StatisticsVO getStatistics(String countycode, Integer yqType, Integer isScqy) {
        log.info("开始获取统计数据, countycode={}, yqType={}, isScqy={}", countycode, yqType, isScqy);
        
        StatisticsVO vo = new StatisticsVO();
        
        // 查询区县数
        Long countyCount = tjAcceptCompanyMapper.countCounties(countycode, yqType, isScqy);
        vo.setCountyCount(countyCount);
        
        // 查询园区数
        Long parkCount = yqjbxxMapper.countParks(countycode);
        vo.setParkCount(parkCount);
        
        // 查询企业数
        Long companyCount = tjAcceptCompanyMapper.countCompanies(countycode, yqType, isScqy);
        vo.setCompanyCount(companyCount);
        
        // 查询生产企业数
        Long productionCompanyCount = tjAcceptCompanyMapper.countProductionCompanies(countycode, yqType);
        vo.setProductionCompanyCount(productionCompanyCount);
        
        // 查询重大危险源企业数
        Long majorHazardCompanyCount = tjAcceptCompanyMapper.countMajorHazardCompanies(countycode, yqType, isScqy);
        vo.setMajorHazardCompanyCount(majorHazardCompanyCount);
        
        log.info("统计数据获取完成: {}", vo);
        
        return vo;
    }
}