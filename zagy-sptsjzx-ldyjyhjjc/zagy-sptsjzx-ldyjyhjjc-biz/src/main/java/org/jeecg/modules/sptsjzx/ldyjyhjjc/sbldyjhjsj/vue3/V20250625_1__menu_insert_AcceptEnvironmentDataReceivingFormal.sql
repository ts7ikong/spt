-- 注意：该页面对应的前台目录为views/sptsjzx/ldyjyhjjc/sbldyjhjsj文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('202506250436410170', NULL, '上报雷电预警环境数据', '/sptsjzx/ldyjyhjjc/sbldyjhjsj/acceptEnvironmentDataReceivingFormalList', 'sptsjzx/ldyjyhjjc/sbldyjhjsj/AcceptEnvironmentDataReceivingFormalList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-25 16:36:17', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202506250436420171', '202506250436410170', '添加上报雷电预警环境数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.ldyjyhjjc.sbldyjhjsj:accept_environment_data_receiving_formal:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-25 16:36:17', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202506250436420172', '202506250436410170', '编辑上报雷电预警环境数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.ldyjyhjjc.sbldyjhjsj:accept_environment_data_receiving_formal:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-25 16:36:17', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202506250436420173', '202506250436410170', '删除上报雷电预警环境数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.ldyjyhjjc.sbldyjhjsj:accept_environment_data_receiving_formal:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-25 16:36:17', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202506250436420174', '202506250436410170', '批量删除上报雷电预警环境数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.ldyjyhjjc.sbldyjhjsj:accept_environment_data_receiving_formal:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-25 16:36:17', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202506250436420175', '202506250436410170', '导出excel_上报雷电预警环境数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.ldyjyhjjc.sbldyjhjsj:accept_environment_data_receiving_formal:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-25 16:36:17', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202506250436420176', '202506250436410170', '导入excel_上报雷电预警环境数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.ldyjyhjjc.sbldyjhjsj:accept_environment_data_receiving_formal:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-25 16:36:17', NULL, NULL, 0, 0, '1', 0);