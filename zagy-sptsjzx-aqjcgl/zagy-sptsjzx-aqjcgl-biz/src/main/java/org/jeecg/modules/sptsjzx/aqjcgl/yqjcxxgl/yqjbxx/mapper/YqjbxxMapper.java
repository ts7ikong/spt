package org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.yqjbxx.mapper;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.sptsjzx.aqjcgl.yqjcxxgl.yqjbxx.entity.Yqjbxx;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 园区基本信息
 * @Author: zagy-cg
 * @Date:   2025-05-29
 * @Version: V1.0
 */
public interface YqjbxxMapper extends BaseMapper<Yqjbxx> {


    /**
     * 统计园区数量
     * @param countycode 区县编码
     * @return 园区数量
     */
    Long countParks(@Param("countycode") String countycode);
}
