-- 注意：该页面对应的前台目录为views/sptsjzx/fbhgl/mjkkglxxjcxxgl/qtclxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025053004376260420', NULL, '其他车辆信息', '/sptsjzx/fbhgl/mjkkglxxjcxxgl/qtclxx/qtclxxList', 'sptsjzx/fbhgl/mjkkglxxjcxxgl/qtclxx/QtclxxList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-30 16:37:42', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004376270421', '2025053004376260420', '添加其他车辆信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.qtclxx:qtclxx:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:37:42', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004376270422', '2025053004376260420', '编辑其他车辆信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.qtclxx:qtclxx:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:37:42', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004376270423', '2025053004376260420', '删除其他车辆信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.qtclxx:qtclxx:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:37:42', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004376270424', '2025053004376260420', '批量删除其他车辆信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.qtclxx:qtclxx:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:37:42', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004376270425', '2025053004376260420', '导出excel_其他车辆信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.qtclxx:qtclxx:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:37:42', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004376270426', '2025053004376260420', '导入excel_其他车辆信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.qtclxx:qtclxx:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:37:42', NULL, NULL, 0, 0, '1', 0);