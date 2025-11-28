-- 注意：该页面对应的前台目录为views/sptsjzx/scyf/gwzzqd文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025062311194500310', NULL, '岗位职责清单', '/sptsjzx/scyf/gwzzqd/acceptDutyFormalList', 'sptsjzx/scyf/gwzzqd/AcceptDutyFormalList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-23 11:19:31', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062311194500311', '2025062311194500310', '添加岗位职责清单', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.scyf.gwzzqd:accept_duty_formal:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 11:19:31', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062311194500312', '2025062311194500310', '编辑岗位职责清单', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.scyf.gwzzqd:accept_duty_formal:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 11:19:31', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062311194500313', '2025062311194500310', '删除岗位职责清单', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.scyf.gwzzqd:accept_duty_formal:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 11:19:31', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062311194500314', '2025062311194500310', '批量删除岗位职责清单', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.scyf.gwzzqd:accept_duty_formal:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 11:19:31', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062311194500315', '2025062311194500310', '导出excel_岗位职责清单', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.scyf.gwzzqd:accept_duty_formal:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 11:19:31', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062311194500316', '2025062311194500310', '导入excel_岗位职责清单', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.scyf.gwzzqd:accept_duty_formal:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 11:19:31', NULL, NULL, 0, 0, '1', 0);