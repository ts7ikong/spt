-- 注意：该页面对应的前台目录为views/sptsjzx/scyf/zztyjwxjl文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025062311205480530', NULL, '装置停用/检维修记录', '/sptsjzx/scyf/zztyjwxjl/acceptUnitStopFormalList', 'sptsjzx/scyf/zztyjwxjl/AcceptUnitStopFormalList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-23 11:20:53', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062311205480531', '2025062311205480530', '添加装置停用/检维修记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.scyf.zztyjwxjl:accept_unit_stop_formal:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 11:20:53', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062311205480532', '2025062311205480530', '编辑装置停用/检维修记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.scyf.zztyjwxjl:accept_unit_stop_formal:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 11:20:53', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062311205480533', '2025062311205480530', '删除装置停用/检维修记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.scyf.zztyjwxjl:accept_unit_stop_formal:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 11:20:53', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062311205480534', '2025062311205480530', '批量删除装置停用/检维修记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.scyf.zztyjwxjl:accept_unit_stop_formal:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 11:20:53', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062311205480535', '2025062311205480530', '导出excel_装置停用/检维修记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.scyf.zztyjwxjl:accept_unit_stop_formal:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 11:20:53', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062311205480536', '2025062311205480530', '导入excel_装置停用/检维修记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.scyf.zztyjwxjl:accept_unit_stop_formal:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 11:20:53', NULL, NULL, 0, 0, '1', 0);