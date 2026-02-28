-- 注意：该页面对应的前台目录为views/rydwsj/rydwsslssj文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2026020304244040430', NULL, '人员定位接收地址', '/rydwsj/rydwsslssj/rydwsslssjList', 'rydwsj/rydwsslssj/RydwsslssjList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2026-02-03 16:24:43', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026020304244040431', '2026020304244040430', '添加人员定位接收地址', NULL, NULL, 0, NULL, NULL, 2, 'rydwsj.rydwsslssj:rydwsslssj:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-02-03 16:24:43', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026020304244040432', '2026020304244040430', '编辑人员定位接收地址', NULL, NULL, 0, NULL, NULL, 2, 'rydwsj.rydwsslssj:rydwsslssj:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-02-03 16:24:43', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026020304244040433', '2026020304244040430', '删除人员定位接收地址', NULL, NULL, 0, NULL, NULL, 2, 'rydwsj.rydwsslssj:rydwsslssj:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-02-03 16:24:43', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026020304244040434', '2026020304244040430', '批量删除人员定位接收地址', NULL, NULL, 0, NULL, NULL, 2, 'rydwsj.rydwsslssj:rydwsslssj:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-02-03 16:24:43', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026020304244040435', '2026020304244040430', '导出excel_人员定位接收地址', NULL, NULL, 0, NULL, NULL, 2, 'rydwsj.rydwsslssj:rydwsslssj:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-02-03 16:24:43', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026020304244040436', '2026020304244040430', '导入excel_人员定位接收地址', NULL, NULL, 0, NULL, NULL, 2, 'rydwsj.rydwsslssj:rydwsslssj:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-02-03 16:24:43', NULL, NULL, 0, 0, '1', 0);