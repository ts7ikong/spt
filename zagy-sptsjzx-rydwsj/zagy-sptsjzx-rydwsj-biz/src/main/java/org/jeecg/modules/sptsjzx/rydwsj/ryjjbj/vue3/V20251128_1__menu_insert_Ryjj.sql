-- 注意：该页面对应的前台目录为views/sptsjzx/rydwsj/ryjjbj文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025112811166910280', NULL, '人员聚集报警', '/sptsjzx/rydwsj/ryjjbj/ryjjList', 'sptsjzx/rydwsj/ryjjbj/RyjjList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-11-28 11:16:28', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025112811166910281', '2025112811166910280', '添加人员聚集报警', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.ryjjbj:ryjj:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-11-28 11:16:28', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025112811166910282', '2025112811166910280', '编辑人员聚集报警', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.ryjjbj:ryjj:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-11-28 11:16:28', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025112811166910283', '2025112811166910280', '删除人员聚集报警', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.ryjjbj:ryjj:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-11-28 11:16:28', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025112811166910284', '2025112811166910280', '批量删除人员聚集报警', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.ryjjbj:ryjj:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-11-28 11:16:28', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025112811166910285', '2025112811166910280', '导出excel_人员聚集报警', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.ryjjbj:ryjj:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-11-28 11:16:28', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025112811166910286', '2025112811166910280', '导入excel_人员聚集报警', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.ryjjbj:ryjj:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-11-28 11:16:28', NULL, NULL, 0, 0, '1', 0);