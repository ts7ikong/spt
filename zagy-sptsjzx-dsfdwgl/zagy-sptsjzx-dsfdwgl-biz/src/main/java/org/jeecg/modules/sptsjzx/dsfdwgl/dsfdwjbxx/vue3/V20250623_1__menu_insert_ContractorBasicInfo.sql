-- 注意：该页面对应的前台目录为views/sptsjzx/dsfdwgl/dsfdwjbxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025062304483970150', NULL, '第三方单位基本信息', '/sptsjzx/dsfdwgl/dsfdwjbxx/contractorBasicInfoList', 'sptsjzx/dsfdwgl/dsfdwjbxx/ContractorBasicInfoList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-23 16:48:15', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062304483970151', '2025062304483970150', '添加第三方单位基本信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.dsfdwgl.dsfdwjbxx:contractor_basic_info:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 16:48:15', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062304483970152', '2025062304483970150', '编辑第三方单位基本信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.dsfdwgl.dsfdwjbxx:contractor_basic_info:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 16:48:15', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062304483970153', '2025062304483970150', '删除第三方单位基本信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.dsfdwgl.dsfdwjbxx:contractor_basic_info:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 16:48:15', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062304483970154', '2025062304483970150', '批量删除第三方单位基本信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.dsfdwgl.dsfdwjbxx:contractor_basic_info:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 16:48:15', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062304483970155', '2025062304483970150', '导出excel_第三方单位基本信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.dsfdwgl.dsfdwjbxx:contractor_basic_info:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 16:48:15', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062304483970156', '2025062304483970150', '导入excel_第三方单位基本信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.dsfdwgl.dsfdwjbxx:contractor_basic_info:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 16:48:15', NULL, NULL, 0, 0, '1', 0);