package org.jeecg.modules.sptsjzx.aqjcgl.qyjbxx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.jeecg.modules.sptsjzx.aqjcgl.qyjbxx.entity.AcceptCompany;
import org.jeecg.modules.sptsjzx.aqjcgl.qyjbxx.mapper.AqAcceptCompanyMapper;
import org.jeecg.modules.sptsjzx.aqjcgl.qyjbxx.service.IAqAcceptCompanyService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: 企业基本信息
 * @Author: zagy-cg
 * @Date: 2025-06-20
 * @Version: V1.0
 */
@Service
@DS("zfd")
public class AqAcceptCompanyServiceImpl extends ServiceImpl<AqAcceptCompanyMapper, AcceptCompany> implements IAqAcceptCompanyService {

    @Override
    public Map<String, Object> getAccessStats(String countycode, Integer yqType, Integer isScqy) {
        return baseMapper.getAccessStats(countycode, yqType, isScqy);
    }

    @Override
    public List<String> getCompanyCodesByCountyCode(String countycode) {
        if (countycode == null || countycode.isEmpty()) {
            return new ArrayList<>();
        }

        QueryWrapper<AcceptCompany> wrapper = new QueryWrapper<>();
        wrapper.eq("countycode", countycode);
        wrapper.select("code");

        List<AcceptCompany> companies = this.list(wrapper);
        return companies.stream()
                .map(AcceptCompany::getCode)
                .filter(code -> code != null && !code.isEmpty())
                .collect(Collectors.toList());
    }

}
