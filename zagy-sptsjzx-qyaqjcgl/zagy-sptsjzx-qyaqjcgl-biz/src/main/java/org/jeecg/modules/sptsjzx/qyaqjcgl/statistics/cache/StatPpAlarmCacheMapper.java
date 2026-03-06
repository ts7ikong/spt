package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.cache;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface StatPpAlarmCacheMapper {

    /**
     * 批量写入/更新（INSERT ... ON DUPLICATE KEY UPDATE）
     */
    void batchUpsert(@Param("list") List<StatPpAlarmCacheRow> list);

    /**
     * 按企业编码列表聚合报警分类统计（根据 alarmStatus 选择对应的 count 列）
     */
    List<Map<String, Object>> queryAlarmStats(
            @Param("companyCodes") List<String> companyCodes,
            @Param("yqType") Integer yqType,
            @Param("isScqy") Integer isScqy,
            @Param("alarmStatus") String alarmStatus);
}
