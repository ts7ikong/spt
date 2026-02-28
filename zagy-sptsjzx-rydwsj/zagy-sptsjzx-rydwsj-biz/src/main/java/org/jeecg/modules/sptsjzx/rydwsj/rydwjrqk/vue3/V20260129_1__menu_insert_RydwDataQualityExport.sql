-- 注意：该页面对应的前台目录为views/rydwsj/rydwjrqk文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2026012906094520100', NULL, '人员定位接入情况', '/rydwsj/rydwjrqk/rydwDataQualityExportList', 'rydwsj/rydwjrqk/RydwDataQualityExportList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2026-01-29 18:09:10', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026012906094520101', '2026012906094520100', '添加人员定位接入情况', NULL, NULL, 0, NULL, NULL, 2, 'rydwsj.rydwjrqk:rydw_data_quality_export:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-01-29 18:09:10', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026012906094520102', '2026012906094520100', '编辑人员定位接入情况', NULL, NULL, 0, NULL, NULL, 2, 'rydwsj.rydwjrqk:rydw_data_quality_export:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-01-29 18:09:10', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026012906094520103', '2026012906094520100', '删除人员定位接入情况', NULL, NULL, 0, NULL, NULL, 2, 'rydwsj.rydwjrqk:rydw_data_quality_export:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-01-29 18:09:10', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026012906094520104', '2026012906094520100', '批量删除人员定位接入情况', NULL, NULL, 0, NULL, NULL, 2, 'rydwsj.rydwjrqk:rydw_data_quality_export:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-01-29 18:09:10', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026012906094520105', '2026012906094520100', '导出excel_人员定位接入情况', NULL, NULL, 0, NULL, NULL, 2, 'rydwsj.rydwjrqk:rydw_data_quality_export:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-01-29 18:09:10', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026012906094530106', '2026012906094520100', '导入excel_人员定位接入情况', NULL, NULL, 0, NULL, NULL, 2, 'rydwsj.rydwjrqk:rydw_data_quality_export:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-01-29 18:09:10', NULL, NULL, 0, 0, '1', 0);