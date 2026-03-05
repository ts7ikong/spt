package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.cache.StatSwBaseCache;

import java.util.List;
import java.util.Map;

@Mapper
public interface StatSwBaseCacheMapper {

    /**
     * 批量写入/更新（INSERT ... ON DUPLICATE KEY UPDATE）
     */
    void batchUpsert(@Param("list") List<StatSwBaseCache> list);

    /**
     * 按企业编码列表聚合返回接入情况 + 各状态作业票数量（一行汇总）
     */
    Map<String, Object> queryAggregated(
            @Param("companyCodes") List<String> companyCodes,
            @Param("yqType") Integer yqType,
            @Param("isScqy") Integer isScqy);
}
