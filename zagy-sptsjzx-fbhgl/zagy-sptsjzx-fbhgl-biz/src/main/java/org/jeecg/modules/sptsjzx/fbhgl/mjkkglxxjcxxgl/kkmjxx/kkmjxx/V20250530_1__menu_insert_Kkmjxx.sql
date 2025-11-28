-- 注意：该页面对应的前台目录为views/sptsjzx/fbhgl/mjkkglxxjcxxgl/kkmjxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('202505300429510230', NULL, '卡口/门禁信息', '/sptsjzx/fbhgl/mjkkglxxjcxxgl/kkmjxx/kkmjxxList', 'sptsjzx/fbhgl/mjkkglxxjcxxgl/kkmjxx/KkmjxxList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-30 16:29:23', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505300429510231', '202505300429510230', '添加卡口/门禁信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.kkmjxx:kkmjxx:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:29:23', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505300429510232', '202505300429510230', '编辑卡口/门禁信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.kkmjxx:kkmjxx:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:29:23', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505300429510233', '202505300429510230', '删除卡口/门禁信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.kkmjxx:kkmjxx:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:29:23', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505300429510234', '202505300429510230', '批量删除卡口/门禁信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.kkmjxx:kkmjxx:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:29:23', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505300429510235', '202505300429510230', '导出excel_卡口/门禁信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.kkmjxx:kkmjxx:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:29:23', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505300429510236', '202505300429510230', '导入excel_卡口/门禁信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.kkmjxx:kkmjxx:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:29:23', NULL, NULL, 0, 0, '1', 0);