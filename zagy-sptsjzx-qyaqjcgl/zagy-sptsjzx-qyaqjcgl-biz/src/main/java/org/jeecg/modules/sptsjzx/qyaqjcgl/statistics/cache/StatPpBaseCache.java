package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.cache;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 人员定位基础统计缓存（每企业一行）
 * 对应 positioningAccessStats + temporaryZoneCount/fixedZoneCount + crowdAlarmCount
 * 由 PersonnelPositioningCacheJob 定时刷新。
 */
@Data
public class StatPpBaseCache {

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

    // ---- 接入情况（来自 all_access_status）----
    private Integer isFullAccess;
    private Integer isPartialAccess;
    private Integer isNoAccess;

    // ---- 区域统计（来自 zone_geo）----
    private Integer temporaryZoneCount;
    private Integer fixedZoneCount;

    // ---- 人员聚集报警（来自 ryjj，无 alarmStatus 过滤）----
    private Integer crowdAlarmCount;

    private LocalDateTime updatedAt;
}
