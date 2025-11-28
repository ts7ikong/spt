-- 注意：该页面对应的前台目录为views/sptsjzx/qyaqjcgl/qyjbxx/ryxxk文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025062004382050290', NULL, '人员信息库', '/sptsjzx/qyaqjcgl/qyjbxx/ryxxk/ryxxkList', 'sptsjzx/qyaqjcgl/qyjbxx/ryxxk/RyxxkList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-20 16:38:29', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004382050291', '2025062004382050290', '添加人员信息库', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.ryxxk:ryxxk:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:38:29', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004382050292', '2025062004382050290', '编辑人员信息库', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.ryxxk:ryxxk:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:38:29', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004382050293', '2025062004382050290', '删除人员信息库', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.ryxxk:ryxxk:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:38:29', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004382050294', '2025062004382050290', '批量删除人员信息库', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.ryxxk:ryxxk:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:38:29', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004382050295', '2025062004382050290', '导出excel_人员信息库', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.ryxxk:ryxxk:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:38:29', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004382050296', '2025062004382050290', '导入excel_人员信息库', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.ryxxk:ryxxk:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:38:29', NULL, NULL, 0, 0, '1', 0);