-- ============================================================
-- 人员定位统计预聚合缓存表
-- 由 PersonnelPositioningCacheJob 每 10 分钟刷新一次
-- ============================================================

-- 表一：每企业一行，存接入情况 + 区域数量 + 人员聚集报警数量
CREATE TABLE IF NOT EXISTS stat_pp_base_cache (
    id                   BIGINT      NOT NULL AUTO_INCREMENT  COMMENT '主键',
    company_code         VARCHAR(50) NOT NULL                 COMMENT '企业编码',
    county_code          VARCHAR(50)                          COMMENT '区县编码（冗余）',
    park_code            VARCHAR(50)                          COMMENT '园区编码（冗余）',
    yq_type              INT                                  COMMENT '园区类型（冗余）',
    is_scqy              INT                                  COMMENT '是否生产企业（冗余）',

    -- 接入情况（来自 all_access_status）
    is_full_access       TINYINT     NOT NULL DEFAULT 0       COMMENT '全部接入(1/0)',
    is_partial_access    TINYINT     NOT NULL DEFAULT 0       COMMENT '部分接入(1/0)',
    is_no_access         TINYINT     NOT NULL DEFAULT 0       COMMENT '未接入(1/0)',

    -- 区域统计（来自 zone_geo）
    temporary_zone_count INT         NOT NULL DEFAULT 0       COMMENT '临时区域数量',
    fixed_zone_count     INT         NOT NULL DEFAULT 0       COMMENT '固定区域数量',

    -- 人员聚集报警（来自 ryjj）
    crowd_alarm_count    INT         NOT NULL DEFAULT 0       COMMENT '人员聚集报警数量',

    updated_at           DATETIME    NOT NULL                 COMMENT '缓存刷新时间',

    PRIMARY KEY (id),
    UNIQUE KEY uk_company (company_code),
    INDEX idx_county (county_code),
    INDEX idx_park   (park_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='人员定位接入&区域&聚集报警统计预聚合缓存';


-- 表二：每企业×每人员类型一行
CREATE TABLE IF NOT EXISTS stat_pp_person_type_cache (
    id           BIGINT       NOT NULL AUTO_INCREMENT  COMMENT '主键',
    company_code VARCHAR(50)  NOT NULL                 COMMENT '企业编码',
    county_code  VARCHAR(50)                           COMMENT '区县编码（冗余）',
    park_code    VARCHAR(50)                           COMMENT '园区编码（冗余）',
    yq_type      INT                                   COMMENT '园区类型（冗余）',
    is_scqy      INT                                   COMMENT '是否生产企业（冗余）',
    person_type  VARCHAR(10)  NOT NULL                 COMMENT '人员类型编码（如 01/02/03/04/05）',
    person_name  VARCHAR(50)  NOT NULL                 COMMENT '人员类型展示名称',
    person_count INT          NOT NULL DEFAULT 0       COMMENT '人员数量',
    updated_at   DATETIME     NOT NULL                 COMMENT '缓存刷新时间',

    PRIMARY KEY (id),
    UNIQUE KEY uk_company_type (company_code, person_type),
    INDEX idx_county (county_code),
    INDEX idx_park   (park_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='人员定位人员类型统计预聚合缓存';


-- 表三：每企业×每报警名称一行，三状态数量分列存储
CREATE TABLE IF NOT EXISTS stat_pp_alarm_cache (
    id              BIGINT       NOT NULL AUTO_INCREMENT  COMMENT '主键',
    company_code    VARCHAR(50)  NOT NULL                 COMMENT '企业编码',
    county_code     VARCHAR(50)                           COMMENT '区县编码（冗余）',
    park_code       VARCHAR(50)                           COMMENT '园区编码（冗余）',
    yq_type         INT                                   COMMENT '园区类型（冗余）',
    is_scqy         INT                                   COMMENT '是否生产企业（冗余）',
    alarm_name      VARCHAR(50)  NOT NULL                 COMMENT '报警名称（如"SOS报警"）',
    total_count     INT          NOT NULL DEFAULT 0       COMMENT '全部报警数量',
    alarming_count  INT          NOT NULL DEFAULT 0       COMMENT '报警中数量',
    dispelled_count INT          NOT NULL DEFAULT 0       COMMENT '已消警数量',
    updated_at      DATETIME     NOT NULL                 COMMENT '缓存刷新时间',

    PRIMARY KEY (id),
    UNIQUE KEY uk_company_alarm (company_code, alarm_name),
    INDEX idx_county (county_code),
    INDEX idx_park   (park_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='人员定位报警分类统计预聚合缓存';
