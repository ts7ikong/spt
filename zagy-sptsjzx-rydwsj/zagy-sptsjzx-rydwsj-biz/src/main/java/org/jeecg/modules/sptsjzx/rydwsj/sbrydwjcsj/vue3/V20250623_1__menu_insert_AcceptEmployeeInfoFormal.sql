-- 注意：该页面对应的前台目录为views/sptsjzx/rydwsj/sbrydwjcsj文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025062302397170290', NULL, '上报人员定位基础数据', '/sptsjzx/rydwsj/sbrydwjcsj/acceptEmployeeInfoFormalList', 'sptsjzx/rydwsj/sbrydwjcsj/AcceptEmployeeInfoFormalList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-23 14:39:29', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062302397170291', '2025062302397170290', '添加上报人员定位基础数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.sbrydwjcsj:accept_employee_info_formal:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 14:39:29', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062302397170292', '2025062302397170290', '编辑上报人员定位基础数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.sbrydwjcsj:accept_employee_info_formal:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 14:39:29', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062302397170293', '2025062302397170290', '删除上报人员定位基础数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.sbrydwjcsj:accept_employee_info_formal:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 14:39:29', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062302397170294', '2025062302397170290', '批量删除上报人员定位基础数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.sbrydwjcsj:accept_employee_info_formal:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 14:39:29', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062302397170295', '2025062302397170290', '导出excel_上报人员定位基础数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.sbrydwjcsj:accept_employee_info_formal:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 14:39:29', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062302397170296', '2025062302397170290', '导入excel_上报人员定位基础数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.sbrydwjcsj:accept_employee_info_formal:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 14:39:29', NULL, NULL, 0, 0, '1', 0);