package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.cache;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 特殊作业大类统计缓存（每企业×每大类一行）
 * 对应 ticketTypeStats，由 SpecialWorkCacheJob 定时刷新。
 */
@Data
public class StatSwTypeCacheRow {

    private Long id;

    /** 企业编码 */
    private String companyCode;

    /** 区县编码（冗余，支持区县筛选） */
    private String countyCode;

    /** 园区编码（冗余，支持园区筛选） */
    private String parkCode;

    /** 园区类型（冗余） */
    private Integer yqType;

    /** 是否生产企业（冗余） */
    private Integer isScqy;

    /** 作业大类名称（zydl，如"动火作业"；NULL 时存"未分类"） */
    private String typeName;

    /** 该企业该大类的作业票数量 */
    private Integer typeCount;

    private LocalDateTime updatedAt;
}
