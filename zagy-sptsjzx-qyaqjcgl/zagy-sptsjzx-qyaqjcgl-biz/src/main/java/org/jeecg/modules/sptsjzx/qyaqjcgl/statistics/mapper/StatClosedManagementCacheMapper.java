package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.cache.StatClosedManagementCache;

import java.util.List;

@Mapper
public interface StatClosedManagementCacheMapper {

    /**
     * 批量写入/更新缓存（INSERT ... ON DUPLICATE KEY UPDATE）
     */
    void batchUpsert(@Param("list") List<StatClosedManagementCache> list);

    /**
     * 按园区编码列表 + 时间范围查询缓存行
     */
    List<StatClosedManagementCache> queryByFilter(
            @Param("parkCodes") List<String> parkCodes,
            @Param("timeRange") String timeRange);
}
