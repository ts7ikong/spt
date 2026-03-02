package org.jeecg.modules.sptsjzx.qyaqjcgl.statistics.cache;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 封闭化管理统计预聚合缓存（每园区每时间范围一行）
 * 由 ClosedManagementCacheJob 定时刷新，供查询接口直接读取。
 */
@Data
public class StatClosedManagementCache {

    private Long id;

    /** 园区编码 */
    private String parkCode;

    /** 时间范围: today / week / month */
    private String timeRange;

    // ---- 静态基础数据（来自 kkmjxx/fkxx/whpclxx/qtclxx/whpyscltccxx/ryssdw/whpclssdw 7 张小表） ----

    /** 已接入的静态模块数（0-7） */
    private Integer staticModuleCount;

    /** 卡口门禁数量 */
    private Integer gateCount;

    /** 危化品车辆数量 */
    private Integer hazardousVehicleCount;

    /** 其他车辆数量 */
    private Integer otherVehicleCount;

    /** 访客数量 */
    private Integer visitorCount;

    // ---- 车辆通行（来自 clsstx，时间敏感） ----

    /** 该时间段内是否有车辆通行数据（0/1） */
    private Integer hasClsstx;

    private Integer generalCargoCount;

    private Integer hazardousTransportCount;

    private Integer smallVehicleCount;

    private Integer emergencyVehicleCount;

    // ---- 人员通行（来自 rysstxsj，时间敏感） ----

    /** 该时间段内是否有人员通行数据（0/1） */
    private Integer hasRysstx;

    private Integer registeredPersonnelCount;

    private Integer visitorPersonnelCount;

    // ---- 报警（来自 sbbjsj，无时间过滤） ----

    /** 是否有报警数据（0/1） */
    private Integer hasSbbjsj;

    private Integer alarmIntrusion;

    private Integer alarmSpeed;

    private Integer alarmHelp;

    private Integer alarmStay;

    private Integer alarmOther;

    /** 缓存刷新时间 */
    private LocalDateTime updatedAt;
}
