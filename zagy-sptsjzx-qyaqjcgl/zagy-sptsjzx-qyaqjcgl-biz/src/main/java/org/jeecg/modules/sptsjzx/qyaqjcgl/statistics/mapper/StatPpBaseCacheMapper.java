package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.cache.StatPpBaseCache;

import java.util.List;
import java.util.Map;

@Mapper
public interface StatPpBaseCacheMapper {

    void batchUpsert(@Param("list") List<StatPpBaseCache> list);

    /**
     * companyCodes 为 null 时不限制企业范围（全市/全区查询走此路径）
     */
    Map<String, Object> queryAggregated(
            @Param("companyCodes") List<String> companyCodes,
            @Param("countyCode") String countyCode,
            @Param("parkCode") String parkCode,
            @Param("yqType") Integer yqType,
            @Param("isScqy") Integer isScqy);
}
