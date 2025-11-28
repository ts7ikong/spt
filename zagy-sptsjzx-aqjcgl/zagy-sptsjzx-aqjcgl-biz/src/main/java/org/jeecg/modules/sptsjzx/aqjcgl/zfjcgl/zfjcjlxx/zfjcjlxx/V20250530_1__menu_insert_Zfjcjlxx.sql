-- 注意：该页面对应的前台目录为views/sptsjzx/aqjcgl/zfjcgl/zfjcjlxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025053011032940540', NULL, '执法检查记录信息', '/sptsjzx/aqjcgl/zfjcgl/zfjcjlxx/zfjcjlxxList', 'sptsjzx/aqjcgl/zfjcgl/zfjcjlxx/ZfjcjlxxList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-30 11:03:54', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011032940541', '2025053011032940540', '添加执法检查记录信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.zfjcgl.zfjcjlxx:zfjcjlxx:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:03:54', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011032940542', '2025053011032940540', '编辑执法检查记录信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.zfjcgl.zfjcjlxx:zfjcjlxx:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:03:54', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011032940543', '2025053011032940540', '删除执法检查记录信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.zfjcgl.zfjcjlxx:zfjcjlxx:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:03:54', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011032940544', '2025053011032940540', '批量删除执法检查记录信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.zfjcgl.zfjcjlxx:zfjcjlxx:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:03:54', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011032940545', '2025053011032940540', '导出excel_执法检查记录信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.zfjcgl.zfjcjlxx:zfjcjlxx:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:03:54', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011032940546', '2025053011032940540', '导入excel_执法检查记录信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.zfjcgl.zfjcjlxx:zfjcjlxx:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:03:54', NULL, NULL, 0, 0, '1', 0);