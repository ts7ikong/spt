-- 注意：该页面对应的前台目录为views/sptsjzx/aqjcgl/dsfdwgl/dsfdwzzxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025053010311950460', NULL, '第三方单位资质信息', '/sptsjzx/aqjcgl/dsfdwgl/dsfdwzzxx/dsfdwzzxxList', 'sptsjzx/aqjcgl/dsfdwgl/dsfdwzzxx/DsfdwzzxxList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-30 10:31:46', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053010311950461', '2025053010311950460', '添加第三方单位资质信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.dsfdwgl.dsfdwzzxx:dsfdwzzxx:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 10:31:46', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053010311950462', '2025053010311950460', '编辑第三方单位资质信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.dsfdwgl.dsfdwzzxx:dsfdwzzxx:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 10:31:46', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053010311950463', '2025053010311950460', '删除第三方单位资质信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.dsfdwgl.dsfdwzzxx:dsfdwzzxx:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 10:31:46', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053010311950464', '2025053010311950460', '批量删除第三方单位资质信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.dsfdwgl.dsfdwzzxx:dsfdwzzxx:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 10:31:46', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053010311950465', '2025053010311950460', '导出excel_第三方单位资质信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.dsfdwgl.dsfdwzzxx:dsfdwzzxx:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 10:31:46', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053010311950466', '2025053010311950460', '导入excel_第三方单位资质信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.dsfdwgl.dsfdwzzxx:dsfdwzzxx:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 10:31:46', NULL, NULL, 0, 0, '1', 0);