package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.cache.StatSwTypeCacheRow;

import java.util.List;
import java.util.Map;

@Mapper
public interface StatSwTypeCacheMapper {

    /**
     * 批量写入/更新（INSERT ... ON DUPLICATE KEY UPDATE）
     */
    void batchUpsert(@Param("list") List<StatSwTypeCacheRow> list);

    /**
     * 按企业编码列表聚合，返回各大类的作业票数量（供 ticketTypeStats 使用）
     */
    List<Map<String, Object>> queryTypeStats(
            @Param("companyCodes") List<String> companyCodes,
            @Param("yqType") Integer yqType,
            @Param("isScqy") Integer isScqy);
}
