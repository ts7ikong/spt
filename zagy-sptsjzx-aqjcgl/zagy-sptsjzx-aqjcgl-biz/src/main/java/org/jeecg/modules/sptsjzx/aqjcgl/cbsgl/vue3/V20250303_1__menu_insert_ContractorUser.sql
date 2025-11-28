-- 注意：该页面对应的前台目录为views/sptsjzx/aqjcgl/cbsgl文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025030305365690010', NULL, '承包商人员', '/sptsjzx/aqjcgl/cbsgl/contractorUserList', 'sptsjzx/aqjcgl/cbsgl/ContractorUserList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-03-03 17:36:01', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305365690011', '2025030305365690010', '添加承包商人员', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_user:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:36:01', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305365690012', '2025030305365690010', '编辑承包商人员', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_user:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:36:01', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305365690013', '2025030305365690010', '删除承包商人员', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_user:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:36:01', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305365690014', '2025030305365690010', '批量删除承包商人员', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_user:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:36:01', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305365690015', '2025030305365690010', '导出excel_承包商人员', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_user:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:36:01', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305365690016', '2025030305365690010', '导入excel_承包商人员', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_user:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:36:01', NULL, NULL, 0, 0, '1', 0);