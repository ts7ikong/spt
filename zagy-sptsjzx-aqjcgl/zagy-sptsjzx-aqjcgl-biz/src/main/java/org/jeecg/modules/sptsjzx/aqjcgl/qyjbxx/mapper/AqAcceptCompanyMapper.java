package org.jeecg.modules.sptsjzx.aqjcgl.qyjbxx.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jeecg.modules.sptsjzx.aqjcgl.qyjbxx.entity.AcceptCompany;

/**
 * @Description: 企业基本信息
 * @Author: zagy-cg
 * @Date:   2025-06-20
 * @Version: V1.0
 */
public interface AqAcceptCompanyMapper extends BaseMapper<AcceptCompany> {

    Map<String, Object> getAccessStats(@Param("countycode") String countycode,
                                       @Param("yqType") Integer yqType,
                                       @Param("isScqy") Integer isScqy);

}
