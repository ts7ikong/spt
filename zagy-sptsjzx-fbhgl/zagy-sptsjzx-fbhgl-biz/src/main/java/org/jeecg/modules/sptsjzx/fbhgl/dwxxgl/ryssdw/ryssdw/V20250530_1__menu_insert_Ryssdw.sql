-- 注意：该页面对应的前台目录为views/sptsjzx/fbhgl/dwxxgl/ryssdw文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025053005191150460', NULL, '人员实时定位', '/sptsjzx/fbhgl/dwxxgl/ryssdw/ryssdwList', 'sptsjzx/fbhgl/dwxxgl/ryssdw/RyssdwList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-30 17:19:46', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053005191150461', '2025053005191150460', '添加人员实时定位', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.dwxxgl.ryssdw:ryssdw:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 17:19:46', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053005191150462', '2025053005191150460', '编辑人员实时定位', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.dwxxgl.ryssdw:ryssdw:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 17:19:46', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053005191150463', '2025053005191150460', '删除人员实时定位', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.dwxxgl.ryssdw:ryssdw:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 17:19:46', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053005191150464', '2025053005191150460', '批量删除人员实时定位', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.dwxxgl.ryssdw:ryssdw:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 17:19:46', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053005191150465', '2025053005191150460', '导出excel_人员实时定位', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.dwxxgl.ryssdw:ryssdw:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 17:19:46', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053005191150466', '2025053005191150460', '导入excel_人员实时定位', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.dwxxgl.ryssdw:ryssdw:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 17:19:46', NULL, NULL, 0, 0, '1', 0);