-- 注意：该页面对应的前台目录为views/sptsjzx/qyaqjcgl/qyjbxx/qylszdhygx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('202506200435990520', NULL, '企业隶属重点行业关系', '/sptsjzx/qyaqjcgl/qyjbxx/qylszdhygx/qylszdhygxList', 'sptsjzx/qyaqjcgl/qyjbxx/qylszdhygx/QylszdhygxList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-20 16:35:52', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004351000521', '202506200435990520', '添加企业隶属重点行业关系', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.qylszdhygx:qylszdhygx:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:35:52', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004351000522', '202506200435990520', '编辑企业隶属重点行业关系', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.qylszdhygx:qylszdhygx:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:35:52', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004351000523', '202506200435990520', '删除企业隶属重点行业关系', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.qylszdhygx:qylszdhygx:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:35:52', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004351000524', '202506200435990520', '批量删除企业隶属重点行业关系', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.qylszdhygx:qylszdhygx:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:35:52', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004351000525', '202506200435990520', '导出excel_企业隶属重点行业关系', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.qylszdhygx:qylszdhygx:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:35:52', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004351000526', '202506200435990520', '导入excel_企业隶属重点行业关系', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.qylszdhygx:qylszdhygx:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:35:52', NULL, NULL, 0, 0, '1', 0);