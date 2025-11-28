-- 注意：该页面对应的前台目录为views/sptsjzx/fbhgl/mjkkglxxjcxxgl/whpclxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025053004347630420', NULL, '危化品车辆信息', '/sptsjzx/fbhgl/mjkkglxxjcxxgl/whpclxx/whpclxxList', 'sptsjzx/fbhgl/mjkkglxxjcxxgl/whpclxx/WhpclxxList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-30 16:34:42', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004347630421', '2025053004347630420', '添加危化品车辆信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.whpclxx:whpclxx:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:34:42', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004347630422', '2025053004347630420', '编辑危化品车辆信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.whpclxx:whpclxx:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:34:42', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004347630423', '2025053004347630420', '删除危化品车辆信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.whpclxx:whpclxx:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:34:42', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004347640424', '2025053004347630420', '批量删除危化品车辆信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.whpclxx:whpclxx:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:34:42', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004347640425', '2025053004347630420', '导出excel_危化品车辆信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.whpclxx:whpclxx:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:34:42', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004347640426', '2025053004347630420', '导入excel_危化品车辆信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.whpclxx:whpclxx:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:34:42', NULL, NULL, 0, 0, '1', 0);