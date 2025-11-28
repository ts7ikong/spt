-- 注意：该页面对应的前台目录为views/sptsjzx/aqjcgl/zfjcgl/zfjcyhxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025053011045110030', NULL, '执法检查隐患信息', '/sptsjzx/aqjcgl/zfjcgl/zfjcyhxx/zfjcyhxxList', 'sptsjzx/aqjcgl/zfjcgl/zfjcyhxx/ZfjcyhxxList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-30 11:04:03', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011045110031', '2025053011045110030', '添加执法检查隐患信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.zfjcgl.zfjcyhxx:zfjcyhxx:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:04:03', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011045110032', '2025053011045110030', '编辑执法检查隐患信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.zfjcgl.zfjcyhxx:zfjcyhxx:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:04:03', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011045110033', '2025053011045110030', '删除执法检查隐患信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.zfjcgl.zfjcyhxx:zfjcyhxx:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:04:03', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011045110034', '2025053011045110030', '批量删除执法检查隐患信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.zfjcgl.zfjcyhxx:zfjcyhxx:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:04:03', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011045110035', '2025053011045110030', '导出excel_执法检查隐患信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.zfjcgl.zfjcyhxx:zfjcyhxx:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:04:03', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011045110036', '2025053011045110030', '导入excel_执法检查隐患信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.zfjcgl.zfjcyhxx:zfjcyhxx:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:04:03', NULL, NULL, 0, 0, '1', 0);