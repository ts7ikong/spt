-- 注意：该页面对应的前台目录为views/sptsjzx/aqjcgl/cbsgl文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025030305369390130', NULL, '承包商培训记录', '/sptsjzx/aqjcgl/cbsgl/contractorTrainList', 'sptsjzx/aqjcgl/cbsgl/ContractorTrainList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-03-03 17:36:13', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305369390131', '2025030305369390130', '添加承包商培训记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_train:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:36:13', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305369390132', '2025030305369390130', '编辑承包商培训记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_train:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:36:13', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305369390133', '2025030305369390130', '删除承包商培训记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_train:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:36:13', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305369390134', '2025030305369390130', '批量删除承包商培训记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_train:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:36:13', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305369390135', '2025030305369390130', '导出excel_承包商培训记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_train:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:36:13', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305369390136', '2025030305369390130', '导入excel_承包商培训记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_train:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:36:13', NULL, NULL, 0, 0, '1', 0);