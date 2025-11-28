-- 注意：该页面对应的前台目录为views/sptsjzx/zdwxyaqgl/xccc/ccqyjl/ccqyjl文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025053004118470580', NULL, '抽查企业记录', '/sptsjzx/zdwxyaqgl/xccc/ccqyjl/ccqyjl/ccqyjlList', 'sptsjzx/zdwxyaqgl/xccc/ccqyjl/ccqyjl/CcqyjlList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-30 16:11:58', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004118470581', '2025053004118470580', '添加抽查企业记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyjl:ccqyjl:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:11:58', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004118480582', '2025053004118470580', '编辑抽查企业记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyjl:ccqyjl:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:11:58', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004118480583', '2025053004118470580', '删除抽查企业记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyjl:ccqyjl:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:11:58', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004118480584', '2025053004118470580', '批量删除抽查企业记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyjl:ccqyjl:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:11:58', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004118480585', '2025053004118470580', '导出excel_抽查企业记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyjl:ccqyjl:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:11:58', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004118480586', '2025053004118470580', '导入excel_抽查企业记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyjl:ccqyjl:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:11:58', NULL, NULL, 0, 0, '1', 0);