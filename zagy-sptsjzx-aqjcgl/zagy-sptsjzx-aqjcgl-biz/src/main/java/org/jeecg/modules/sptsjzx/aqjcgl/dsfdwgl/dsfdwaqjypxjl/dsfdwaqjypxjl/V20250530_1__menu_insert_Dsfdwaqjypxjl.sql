-- 注意：该页面对应的前台目录为views/sptsjzx/aqjcgl/dsfdwgl/dsfdwaqjypxjl文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025053010338550090', NULL, '第三方单位安全教育培训记录', '/sptsjzx/aqjcgl/dsfdwgl/dsfdwaqjypxjl/dsfdwaqjypxjlList', 'sptsjzx/aqjcgl/dsfdwgl/dsfdwaqjypxjl/DsfdwaqjypxjlList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-30 10:33:09', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053010338550091', '2025053010338550090', '添加第三方单位安全教育培训记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.dsfdwgl.dsfdwaqjypxjl:dsfdwaqjypxjl:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 10:33:09', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053010338550092', '2025053010338550090', '编辑第三方单位安全教育培训记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.dsfdwgl.dsfdwaqjypxjl:dsfdwaqjypxjl:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 10:33:09', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053010338550093', '2025053010338550090', '删除第三方单位安全教育培训记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.dsfdwgl.dsfdwaqjypxjl:dsfdwaqjypxjl:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 10:33:09', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053010338550094', '2025053010338550090', '批量删除第三方单位安全教育培训记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.dsfdwgl.dsfdwaqjypxjl:dsfdwaqjypxjl:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 10:33:09', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053010338550095', '2025053010338550090', '导出excel_第三方单位安全教育培训记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.dsfdwgl.dsfdwaqjypxjl:dsfdwaqjypxjl:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 10:33:09', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053010338550096', '2025053010338550090', '导入excel_第三方单位安全教育培训记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.dsfdwgl.dsfdwaqjypxjl:dsfdwaqjypxjl:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 10:33:09', NULL, NULL, 0, 0, '1', 0);