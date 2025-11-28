package org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.sptsjzx.qyaqjcgl.qyjbxx.qyjbxx.entity.AcceptCompany;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 企业基本信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
public interface AcceptCompanyMapper extends BaseMapper<AcceptCompany> {

    Map<String, Object> getAccessStats(@Param("countycode") String countycode,
                                       @Param("yqType") Integer yqType,
                                       @Param("isScqy") Integer isScqy);

}
