package org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.entity.AcceptCompany;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.mapper.AcceptCompanyMapper;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service.IAcceptCompanyService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
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
public class AcceptCompanyServiceImpl extends ServiceImpl<AcceptCompanyMapper, AcceptCompany> implements IAcceptCompanyService {

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

    @Override
    public List<String> getYqCodesByCountyCode(String orgCode) {
        return baseMapper.getYqCodesByCountyCode(orgCode);
    }

    @Override
    public AcceptCompany getByCompanyCode(String companyCode) {
        LambdaQueryWrapper<AcceptCompany> acceptCompanyQueryWrapper = new LambdaQueryWrapper<>();
        acceptCompanyQueryWrapper.eq(AcceptCompany::getCode, companyCode);
        return baseMapper.selectOne(acceptCompanyQueryWrapper);
    }

    @Override
    public String getCompanyCountyCodeByCode(String companyCode) {
        if (companyCode == null || companyCode.isEmpty()) {
            return null;
        }

        QueryWrapper<AcceptCompany> wrapper = new QueryWrapper<>();
        wrapper.eq("code", companyCode);
        wrapper.select("countycode"); // 只查 countycode 字段，提高性能

        List<AcceptCompany> companies = this.list(wrapper);
        if (companies != null && !companies.isEmpty()) {
            AcceptCompany company = companies.get(0);
            return company.getCountycode(); // 注意：如果数据库字段是 countycode，实体类属性应为 countycode 或有 @TableField
        }
        return null;
    }

}
