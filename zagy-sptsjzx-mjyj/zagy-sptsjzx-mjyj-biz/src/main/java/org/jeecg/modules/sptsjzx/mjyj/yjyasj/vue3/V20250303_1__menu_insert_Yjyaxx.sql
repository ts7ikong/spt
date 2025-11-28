-- 注意：该页面对应的前台目录为views/sptsjzx/mjyj/yjyasj文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025030306218510180', NULL, '应急预案信息', '/sptsjzx/mjyj/yjyasj/yjyaxxList', 'sptsjzx/mjyj/yjyasj/YjyaxxList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-03-03 18:21:18', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030306218510181', '2025030306218510180', '添加应急预案信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjyasj:yjyaxx:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 18:21:18', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030306218510182', '2025030306218510180', '编辑应急预案信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjyasj:yjyaxx:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 18:21:18', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030306218510183', '2025030306218510180', '删除应急预案信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjyasj:yjyaxx:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 18:21:18', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030306218510184', '2025030306218510180', '批量删除应急预案信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjyasj:yjyaxx:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 18:21:18', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030306218510185', '2025030306218510180', '导出excel_应急预案信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjyasj:yjyaxx:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 18:21:18', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030306218510186', '2025030306218510180', '导入excel_应急预案信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjyasj:yjyaxx:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 18:21:18', NULL, NULL, 0, 0, '1', 0);