-- 注意：该页面对应的前台目录为views/sptsjzx/scyf/yhpcrw文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025062311184710150', NULL, '隐患排查任务', '/sptsjzx/scyf/yhpcrw/acceptMeasuresTaskFormalList', 'sptsjzx/scyf/yhpcrw/AcceptMeasuresTaskFormalList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-23 11:18:15', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062311184710151', '2025062311184710150', '添加隐患排查任务', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.scyf.yhpcrw:accept_measures_task_formal:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 11:18:15', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062311184710152', '2025062311184710150', '编辑隐患排查任务', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.scyf.yhpcrw:accept_measures_task_formal:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 11:18:15', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062311184710153', '2025062311184710150', '删除隐患排查任务', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.scyf.yhpcrw:accept_measures_task_formal:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 11:18:15', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062311184710154', '2025062311184710150', '批量删除隐患排查任务', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.scyf.yhpcrw:accept_measures_task_formal:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 11:18:15', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062311184710155', '2025062311184710150', '导出excel_隐患排查任务', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.scyf.yhpcrw:accept_measures_task_formal:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 11:18:15', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062311184710156', '2025062311184710150', '导入excel_隐患排查任务', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.scyf.yhpcrw:accept_measures_task_formal:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 11:18:15', NULL, NULL, 0, 0, '1', 0);