package org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.service;

import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.entity.AcceptCompany;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * @Description: 企业基本信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
public interface IAcceptCompanyService extends IService<AcceptCompany> {

    Map<String, Object> getAccessStats(String countycode, Integer yqType, Integer isScqy);

    /**
     * 根据区县编码获取企业编码列表
     * @param countycode 区县编码
     * @return 企业编码列表
     */
    List<String> getCompanyCodesByCountyCode(String countycode);
}
