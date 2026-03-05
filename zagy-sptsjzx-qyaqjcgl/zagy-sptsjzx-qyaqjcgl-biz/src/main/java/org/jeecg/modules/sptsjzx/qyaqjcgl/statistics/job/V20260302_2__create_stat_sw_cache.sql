-- ============================================================
-- 特殊作业统计预聚合缓存表
-- 由 SpecialWorkCacheJob 每 10 分钟刷新一次
-- ============================================================

-- 表一：每企业一行，存接入情况 + 各状态作业票数量
CREATE TABLE IF NOT EXISTS stat_sw_base_cache (
    id              BIGINT          NOT NULL AUTO_INCREMENT  COMMENT '主键',
    company_code    VARCHAR(50)     NOT NULL                 COMMENT '企业编码',
    county_code     VARCHAR(50)                              COMMENT '区县编码（冗余）',
    park_code       VARCHAR(50)                              COMMENT '园区编码（冗余）',
    yq_type         INT                                      COMMENT '园区类型（冗余）',
    is_scqy         INT                                      COMMENT '是否生产企业（冗余）',

    -- ticketAccessStats
    is_full         TINYINT         NOT NULL DEFAULT 0       COMMENT '全部接入(1/0)',
    is_partial      TINYINT         NOT NULL DEFAULT 0       COMMENT '部分接入(1/0)',
    is_not          TINYINT         NOT NULL DEFAULT 0       COMMENT '未接入(1/0)',

    -- ticketStatusStats
    status_0        INT             NOT NULL DEFAULT 0       COMMENT '未签发数量',
    status_1        INT             NOT NULL DEFAULT 0       COMMENT '已签发数量',
    status_3        INT             NOT NULL DEFAULT 0       COMMENT '已验收数量',
    status_4        INT             NOT NULL DEFAULT 0       COMMENT '作废数量',
    status_5        INT             NOT NULL DEFAULT 0       COMMENT '撤销数量',

    updated_at      DATETIME        NOT NULL                 COMMENT '缓存刷新时间',

    PRIMARY KEY (id),
    UNIQUE KEY uk_company (company_code),
    INDEX idx_county (county_code),
    INDEX idx_park   (park_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='特殊作业接入&状态统计预聚合缓存';


-- 表二：每企业×每大类一行，存作业票数量（供 ticketTypeStats 使用）
CREATE TABLE IF NOT EXISTS stat_sw_type_cache (
    id              BIGINT          NOT NULL AUTO_INCREMENT  COMMENT '主键',
    company_code    VARCHAR(50)     NOT NULL                 COMMENT '企业编码',
    county_code     VARCHAR(50)                              COMMENT '区县编码（冗余）',
    park_code       VARCHAR(50)                              COMMENT '园区编码（冗余）',
    yq_type         INT                                      COMMENT '园区类型（冗余）',
    is_scqy         INT                                      COMMENT '是否生产企业（冗余）',
    type_name       VARCHAR(100)    NOT NULL                 COMMENT '作业大类名称',
    type_count      INT             NOT NULL DEFAULT 0       COMMENT '作业票数量',
    updated_at      DATETIME        NOT NULL                 COMMENT '缓存刷新时间',

    PRIMARY KEY (id),
    UNIQUE KEY uk_company_type (company_code, type_name),
    INDEX idx_county (county_code),
    INDEX idx_park   (park_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='特殊作业大类统计预聚合缓存';
