package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.cache;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 报警分类统计缓存（每企业×每报警名称一行）
 * 对应 alarmClassificationStats（人员报警 + 区域报警），由 PersonnelPositioningCacheJob 定时刷新。
 *
 * 三种 alarmStatus 分别存列：
 *   totalCount     → alarmStatus=all
 *   alarmingCount  → alarmStatus=alarming（有报警时间、无销警时间）
 *   dispelledCount → alarmStatus=dispelled（有销警时间）
 */
@Data
public class StatPpAlarmCacheRow {

    private Long id;

    /** 企业编码 */
    private String companyCode;

    /** 区县编码（冗余） */
    private String countyCode;

    /** 园区编码（冗余） */
    private String parkCode;

    /** 园区类型（冗余） */
    private Integer yqType;

    /** 是否生产企业（冗余） */
    private Integer isScqy;

    /** 报警展示名称（如"SOS报警"、"超员报警"） */
    private String alarmName;

    /** 全部报警数量 */
    private Integer totalCount;

    /** 报警中数量 */
    private Integer alarmingCount;

    /** 已消警数量 */
    private Integer dispelledCount;

    private LocalDateTime updatedAt;
}
