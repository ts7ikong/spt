-- 注意：该页面对应的前台目录为views/sptsjzx/rydwsj/sbqybjsj文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025062602425580570', NULL, '上报区域报警数据', '/sptsjzx/rydwsj/sbqybjsj/qybjsjList', 'sptsjzx/rydwsj/sbqybjsj/QybjsjList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-26 14:42:57', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062602425580571', '2025062602425580570', '添加上报区域报警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.sbqybjsj:qybjsj:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-26 14:42:57', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062602425580572', '2025062602425580570', '编辑上报区域报警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.sbqybjsj:qybjsj:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-26 14:42:57', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062602425580573', '2025062602425580570', '删除上报区域报警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.sbqybjsj:qybjsj:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-26 14:42:57', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062602425580574', '2025062602425580570', '批量删除上报区域报警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.sbqybjsj:qybjsj:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-26 14:42:57', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062602425580575', '2025062602425580570', '导出excel_上报区域报警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.sbqybjsj:qybjsj:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-26 14:42:57', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062602425580576', '2025062602425580570', '导入excel_上报区域报警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.rydwsj.sbqybjsj:qybjsj:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-26 14:42:57', NULL, NULL, 0, 0, '1', 0);