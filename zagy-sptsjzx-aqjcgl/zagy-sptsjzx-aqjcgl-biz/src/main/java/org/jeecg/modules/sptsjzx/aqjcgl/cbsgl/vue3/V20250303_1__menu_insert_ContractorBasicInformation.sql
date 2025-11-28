-- 注意：该页面对应的前台目录为views/sptsjzx/aqjcgl/cbsgl文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025030305353660490', NULL, '承包商基本信息', '/sptsjzx/aqjcgl/cbsgl/contractorBasicInformationList', 'sptsjzx/aqjcgl/cbsgl/ContractorBasicInformationList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-03-03 17:35:49', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305353660491', '2025030305353660490', '添加承包商基本信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_basic_information:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:35:49', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305353660492', '2025030305353660490', '编辑承包商基本信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_basic_information:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:35:49', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305353660493', '2025030305353660490', '删除承包商基本信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_basic_information:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:35:49', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305353660494', '2025030305353660490', '批量删除承包商基本信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_basic_information:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:35:49', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305353660495', '2025030305353660490', '导出excel_承包商基本信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_basic_information:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:35:49', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305353660496', '2025030305353660490', '导入excel_承包商基本信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_basic_information:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:35:49', NULL, NULL, 0, 0, '1', 0);