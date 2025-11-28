-- 注意：该页面对应的前台目录为views/sptsjzx/rydwsj/rydwsssj文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025112805502550070', NULL, '人员定位实时数据企业在线状态', '/sptsjzx/rydwsj/rydwsssj/rydwqyzxztList', 'sptsjzx/rydwsj/rydwsssj/RydwqyzxztList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-11-28 17:50:07', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025112805502550071', '2025112805502550070', '添加人员定位实时数据企业在线状态', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.rydwsssj:rydwqyzxzt:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-11-28 17:50:07', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025112805502550072', '2025112805502550070', '编辑人员定位实时数据企业在线状态', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.rydwsssj:rydwqyzxzt:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-11-28 17:50:07', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025112805502550073', '2025112805502550070', '删除人员定位实时数据企业在线状态', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.rydwsssj:rydwqyzxzt:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-11-28 17:50:07', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025112805502550074', '2025112805502550070', '批量删除人员定位实时数据企业在线状态', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.rydwsssj:rydwqyzxzt:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-11-28 17:50:07', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025112805502550075', '2025112805502550070', '导出excel_人员定位实时数据企业在线状态', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.rydwsssj:rydwqyzxzt:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-11-28 17:50:07', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025112805502550076', '2025112805502550070', '导入excel_人员定位实时数据企业在线状态', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.rydwsssj:rydwqyzxzt:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-11-28 17:50:07', NULL, NULL, 0, 0, '1', 0);