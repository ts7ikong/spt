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
     * 聚合各大类作业票数量（供 ticketTypeStats 使用）
     * companyCodes 为 null 时不限制企业范围（全市/全区查询走此路径）
     */
    List<Map<String, Object>> queryTypeStats(
            @Param("companyCodes") List<String> companyCodes,
            @Param("countyCode") String countyCode,
            @Param("parkCode") String parkCode,
            @Param("yqType") Integer yqType,
            @Param("isScqy") Integer isScqy);
}
