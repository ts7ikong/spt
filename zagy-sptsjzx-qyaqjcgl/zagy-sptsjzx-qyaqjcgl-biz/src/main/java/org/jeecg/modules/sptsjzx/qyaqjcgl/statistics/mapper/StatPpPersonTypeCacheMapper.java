package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.cache.StatPpPersonTypeCacheRow;

import java.util.List;
import java.util.Map;

@Mapper
public interface StatPpPersonTypeCacheMapper {

    /**
     * 批量写入/更新（INSERT ... ON DUPLICATE KEY UPDATE）
     */
    void batchUpsert(@Param("list") List<StatPpPersonTypeCacheRow> list);

    /**
     * 按企业编码列表聚合人员类型分布（供 personnelTypeStats 使用）
     */
    List<Map<String, Object>> queryPersonTypeStats(
            @Param("companyCodes") List<String> companyCodes,
            @Param("yqType") Integer yqType,
            @Param("isScqy") Integer isScqy);
}
