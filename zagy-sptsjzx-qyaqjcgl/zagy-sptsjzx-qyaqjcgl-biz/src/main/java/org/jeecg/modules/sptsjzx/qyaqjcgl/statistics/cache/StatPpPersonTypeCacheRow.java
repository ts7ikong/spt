package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.cache;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 人员类型统计缓存（每企业×每人员类型一行）
 * 对应 personnelTypeStats，由 PersonnelPositioningCacheJob 定时刷新。
 */
@Data
public class StatPpPersonTypeCacheRow {

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

    /** 人员类型编码（person_type 原始值，如 01/02/03/04/05） */
    private String personType;

    /** 人员类型展示名称（如"内部人员/员工"） */
    private String personName;

    /** 该企业该类型人员数量 */
    private Integer personCount;

    private LocalDateTime updatedAt;
}
