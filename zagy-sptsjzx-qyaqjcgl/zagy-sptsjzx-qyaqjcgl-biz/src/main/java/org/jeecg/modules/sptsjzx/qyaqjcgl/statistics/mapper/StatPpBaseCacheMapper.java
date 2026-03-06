package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.cache.StatPpBaseCache;

import java.util.List;
import java.util.Map;

@Mapper
public interface StatPpBaseCacheMapper {

    /**
     * 批量写入/更新（INSERT ... ON DUPLICATE KEY UPDATE）
     */
    void batchUpsert(@Param("list") List<StatPpBaseCache> list);

    /**
     * 按企业编码列表聚合：接入情况 + 区域数量 + 人员聚集报警数量
     */
    Map<String, Object> queryAggregated(
            @Param("companyCodes") List<String> companyCodes,
            @Param("yqType") Integer yqType,
            @Param("isScqy") Integer isScqy);
}
