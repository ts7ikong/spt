package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.cache;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 特殊作业统计预聚合缓存（每企业一行）
 * 存储：作业票接入状态 + 各状态作业票数量
 * 由 SpecialWorkCacheJob 定时刷新。
 */
@Data
public class StatSwBaseCache {

    private Long id;

    /** 企业编码（主键） */
    private String companyCode;

    /** 区县编码（冗余，支持区县筛选） */
    private String countyCode;

    /** 园区编码（冗余，支持园区筛选） */
    private String parkCode;

    /** 园区类型（冗余，支持 yqType 筛选） */
    private Integer yqType;

    /** 是否生产企业（冗余，支持 isScqy 筛选） */
    private Integer isScqy;

    // ---- ticketAccessStats（来自 all_access_status） ----

    /** 是否全部接入（tickek_state=1 AND ticket_activity=1）*/
    private Integer isFull;

    /** 是否部分接入（一个为1，另一个为0）*/
    private Integer isPartial;

    /** 是否未接入（tickek_state=0 AND ticket_activity=0）*/
    private Integer isNot;

    // ---- ticketStatusStats（来自 accept_ticket_formal） ----

    /** 未签发（ticket_status='0'）*/
    private Integer status0;

    /** 已签发（ticket_status='1'）*/
    private Integer status1;

    /** 已验收（ticket_status='3'）*/
    private Integer status3;

    /** 作废（ticket_status='4'）*/
    private Integer status4;

    /** 撤销（ticket_status='5'）*/
    private Integer status5;

    private LocalDateTime updatedAt;
}
