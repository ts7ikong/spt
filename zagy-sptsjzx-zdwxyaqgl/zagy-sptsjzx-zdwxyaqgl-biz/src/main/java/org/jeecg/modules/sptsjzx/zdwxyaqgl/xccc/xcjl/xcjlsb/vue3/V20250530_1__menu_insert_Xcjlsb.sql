-- 注意：该页面对应的前台目录为views/sptsjzx/zdwxyaqgl/xccc/xcjl/xcjlsb文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025053003373940530', NULL, '巡查记录上报', '/sptsjzx/zdwxyaqgl/xccc/xcjl/xcjlsb/xcjlsbList', 'sptsjzx/zdwxyaqgl/xccc/xcjl/xcjlsb/XcjlsbList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-30 15:37:53', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053003373940531', '2025053003373940530', '添加巡查记录上报', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.xcjl.xcjlsb:xcjlsb:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 15:37:53', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053003373940532', '2025053003373940530', '编辑巡查记录上报', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.xcjl.xcjlsb:xcjlsb:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 15:37:53', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053003373940533', '2025053003373940530', '删除巡查记录上报', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.xcjl.xcjlsb:xcjlsb:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 15:37:53', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053003373940534', '2025053003373940530', '批量删除巡查记录上报', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.xcjl.xcjlsb:xcjlsb:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 15:37:53', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053003373940535', '2025053003373940530', '导出excel_巡查记录上报', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.xcjl.xcjlsb:xcjlsb:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 15:37:53', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053003373940536', '2025053003373940530', '导入excel_巡查记录上报', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.xcjl.xcjlsb:xcjlsb:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 15:37:53', NULL, NULL, 0, 0, '1', 0);