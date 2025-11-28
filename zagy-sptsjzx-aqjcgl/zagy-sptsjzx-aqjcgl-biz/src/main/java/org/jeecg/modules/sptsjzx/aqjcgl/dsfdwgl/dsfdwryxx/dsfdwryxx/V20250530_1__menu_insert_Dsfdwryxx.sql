-- 注意：该页面对应的前台目录为views/sptsjzx/aqjcgl/dsfdwgl/dsfdwryxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025053010308650130', NULL, '第三方单位人员信息', '/sptsjzx/aqjcgl/dsfdwgl/dsfdwryxx/dsfdwryxxList', 'sptsjzx/aqjcgl/dsfdwgl/dsfdwryxx/DsfdwryxxList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-30 10:30:13', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053010308650131', '2025053010308650130', '添加第三方单位人员信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.dsfdwgl.dsfdwryxx:dsfdwryxx:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 10:30:13', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053010308650132', '2025053010308650130', '编辑第三方单位人员信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.dsfdwgl.dsfdwryxx:dsfdwryxx:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 10:30:13', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053010308650133', '2025053010308650130', '删除第三方单位人员信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.dsfdwgl.dsfdwryxx:dsfdwryxx:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 10:30:13', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053010308650134', '2025053010308650130', '批量删除第三方单位人员信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.dsfdwgl.dsfdwryxx:dsfdwryxx:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 10:30:13', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053010308650135', '2025053010308650130', '导出excel_第三方单位人员信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.dsfdwgl.dsfdwryxx:dsfdwryxx:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 10:30:13', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053010308650136', '2025053010308650130', '导入excel_第三方单位人员信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.dsfdwgl.dsfdwryxx:dsfdwryxx:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 10:30:13', NULL, NULL, 0, 0, '1', 0);