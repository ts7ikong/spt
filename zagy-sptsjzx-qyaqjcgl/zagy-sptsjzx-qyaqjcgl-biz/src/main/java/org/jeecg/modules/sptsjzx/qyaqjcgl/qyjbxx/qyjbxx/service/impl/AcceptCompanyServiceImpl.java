package org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.entity.AcceptCompany;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.mapper.AcceptCompanyMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * @Description: 企业基本信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class AcceptCompanyServiceImpl extends ServiceImpl<AcceptCompanyMapper, AcceptCompany> implements IAcceptCompanyService {

    @Override
    public Map<String, Object> getAccessStats(String countycode, Integer yqType, Integer isScqy) {
        return baseMapper.getAccessStats(countycode, yqType, isScqy);
    }

}
