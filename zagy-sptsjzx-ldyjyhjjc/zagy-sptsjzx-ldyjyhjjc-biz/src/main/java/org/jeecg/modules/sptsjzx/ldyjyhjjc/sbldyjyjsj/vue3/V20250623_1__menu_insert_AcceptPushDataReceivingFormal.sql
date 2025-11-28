-- 注意：该页面对应的前台目录为views/sptsjzx/ldyjyhjjc/sbldyjyjsj文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025062302463550020', NULL, '上报雷电预警预警数据', '/sptsjzx/ldyjyhjjc/sbldyjyjsj/acceptPushDataReceivingFormalList', 'sptsjzx/ldyjyhjjc/sbldyjyjsj/AcceptPushDataReceivingFormalList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-23 14:46:02', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062302463550021', '2025062302463550020', '添加上报雷电预警预警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.ldyjyhjjc.sbldyjyjsj:accept_push_data_receiving_formal:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 14:46:02', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062302463550022', '2025062302463550020', '编辑上报雷电预警预警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.ldyjyhjjc.sbldyjyjsj:accept_push_data_receiving_formal:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 14:46:02', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062302463550023', '2025062302463550020', '删除上报雷电预警预警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.ldyjyhjjc.sbldyjyjsj:accept_push_data_receiving_formal:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 14:46:02', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062302463550024', '2025062302463550020', '批量删除上报雷电预警预警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.ldyjyhjjc.sbldyjyjsj:accept_push_data_receiving_formal:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 14:46:02', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062302463550025', '2025062302463550020', '导出excel_上报雷电预警预警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.ldyjyhjjc.sbldyjyjsj:accept_push_data_receiving_formal:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 14:46:02', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062302463550026', '2025062302463550020', '导入excel_上报雷电预警预警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.ldyjyhjjc.sbldyjyjsj:accept_push_data_receiving_formal:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 14:46:02', NULL, NULL, 0, 0, '1', 0);