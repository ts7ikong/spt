-- 注意：该页面对应的前台目录为views/sptsjzx/zdwxyaqgl/yjtssj/jstbsj文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025053011403920420', NULL, '警示通报数据', '/sptsjzx/zdwxyaqgl/yjtssj/jstbsj/jstbsjList', 'sptsjzx/zdwxyaqgl/yjtssj/jstbsj/JstbsjList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-30 11:40:42', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011403920421', '2025053011403920420', '添加警示通报数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.yjtssj.jstbsj:jstbsj:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:40:42', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011403920422', '2025053011403920420', '编辑警示通报数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.yjtssj.jstbsj:jstbsj:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:40:42', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011403920423', '2025053011403920420', '删除警示通报数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.yjtssj.jstbsj:jstbsj:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:40:42', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011403920424', '2025053011403920420', '批量删除警示通报数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.yjtssj.jstbsj:jstbsj:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:40:42', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011403920425', '2025053011403920420', '导出excel_警示通报数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.yjtssj.jstbsj:jstbsj:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:40:42', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011403920426', '2025053011403920420', '导入excel_警示通报数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.yjtssj.jstbsj:jstbsj:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:40:42', NULL, NULL, 0, 0, '1', 0);