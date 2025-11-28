-- 注意：该页面对应的前台目录为views/sptsjzx/zdwxyaqgl/xccc/ccqyjl/ccqyfkjl文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025053004125890260', NULL, '抽查企业反馈记录', '/sptsjzx/zdwxyaqgl/xccc/ccqyjl/ccqyfkjl/ccqyfkjlList', 'sptsjzx/zdwxyaqgl/xccc/ccqyjl/ccqyfkjl/CcqyfkjlList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-30 16:12:26', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004125890261', '2025053004125890260', '添加抽查企业反馈记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyfkjl:ccqyfkjl:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:12:26', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004125890262', '2025053004125890260', '编辑抽查企业反馈记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyfkjl:ccqyfkjl:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:12:26', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004125890263', '2025053004125890260', '删除抽查企业反馈记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyfkjl:ccqyfkjl:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:12:26', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004125890264', '2025053004125890260', '批量删除抽查企业反馈记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyfkjl:ccqyfkjl:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:12:26', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004125890265', '2025053004125890260', '导出excel_抽查企业反馈记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyfkjl:ccqyfkjl:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:12:26', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053004125890266', '2025053004125890260', '导入excel_抽查企业反馈记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.ccqyjl.ccqyfkjl:ccqyfkjl:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:12:26', NULL, NULL, 0, 0, '1', 0);