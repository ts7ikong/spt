-- ============================================================
-- 封闭化管理统计预聚合缓存表
-- 由 ClosedManagementCacheJob 每 10 分钟刷新一次
-- 每个园区 × 每个时间范围（today/week/month）存一行
-- ============================================================
CREATE TABLE IF NOT EXISTS stat_closed_management_cache (
    id                          BIGINT          NOT NULL AUTO_INCREMENT COMMENT '主键',
    park_code                   VARCHAR(50)     NOT NULL                COMMENT '园区编码',
    time_range                  VARCHAR(10)     NOT NULL                COMMENT '时间范围: today/week/month',

    -- 静态基础数据（来自 kkmjxx/fkxx/whpclxx/qtclxx/whpyscltccxx/ryssdw/whpclssdw）
    static_module_count         INT             NOT NULL DEFAULT 0      COMMENT '已接入静态模块数(0-7)',
    gate_count                  INT             NOT NULL DEFAULT 0      COMMENT '卡口门禁数量',
    hazardous_vehicle_count     INT             NOT NULL DEFAULT 0      COMMENT '危化品车辆数量',
    other_vehicle_count         INT             NOT NULL DEFAULT 0      COMMENT '其他车辆数量',
    visitor_count               INT             NOT NULL DEFAULT 0      COMMENT '访客数量',

    -- 车辆通行（来自 clsstx，时间敏感）
    has_clsstx                  TINYINT         NOT NULL DEFAULT 0      COMMENT '该时段是否有车辆通行(0/1)',
    general_cargo_count         INT             NOT NULL DEFAULT 0      COMMENT '普货车数量',
    hazardous_transport_count   INT             NOT NULL DEFAULT 0      COMMENT '危化运输车数量',
    small_vehicle_count         INT             NOT NULL DEFAULT 0      COMMENT '小型车辆数量',
    emergency_vehicle_count     INT             NOT NULL DEFAULT 0      COMMENT '应急车辆数量',

    -- 人员通行（来自 rysstxsj，时间敏感）
    has_rysstx                  TINYINT         NOT NULL DEFAULT 0      COMMENT '该时段是否有人员通行(0/1)',
    registered_personnel_count  INT             NOT NULL DEFAULT 0      COMMENT '备案人员数量',
    visitor_personnel_count     INT             NOT NULL DEFAULT 0      COMMENT '访客人员数量',

    -- 报警（来自 sbbjsj，无时间过滤）
    has_sbbjsj                  TINYINT         NOT NULL DEFAULT 0      COMMENT '是否有报警数据(0/1)',
    alarm_intrusion             INT             NOT NULL DEFAULT 0      COMMENT '入侵报警数量',
    alarm_speed                 INT             NOT NULL DEFAULT 0      COMMENT '超速报警数量',
    alarm_help                  INT             NOT NULL DEFAULT 0      COMMENT '求救报警数量',
    alarm_stay                  INT             NOT NULL DEFAULT 0      COMMENT '滞留报警数量',
    alarm_other                 INT             NOT NULL DEFAULT 0      COMMENT '其他报警数量',

    updated_at                  DATETIME        NOT NULL                COMMENT '缓存刷新时间',

    PRIMARY KEY (id),
    UNIQUE KEY uk_park_timerange (park_code, time_range),
    INDEX idx_timerange (time_range)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='封闭化管理统计预聚合缓存';
