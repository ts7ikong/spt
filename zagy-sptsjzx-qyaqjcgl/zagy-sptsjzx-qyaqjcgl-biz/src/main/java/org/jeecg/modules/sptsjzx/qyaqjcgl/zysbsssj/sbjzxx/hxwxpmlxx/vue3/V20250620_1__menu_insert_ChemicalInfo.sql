-- 注意：该页面对应的前台目录为views/sptsjzx/qyaqjcgl/zysbsssj/sbjzxx/hxwxpmlxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025062004462020030', NULL, '化学危险品目录信息', '/sptsjzx/qyaqjcgl/zysbsssj/sbjzxx/hxwxpmlxx/chemicalInfoList', 'sptsjzx/qyaqjcgl/zysbsssj/sbjzxx/hxwxpmlxx/ChemicalInfoList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-20 16:46:03', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004462020031', '2025062004462020030', '添加化学危险品目录信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.sbjzxx.hxwxpmlxx:chemical_info:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:46:03', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004462020032', '2025062004462020030', '编辑化学危险品目录信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.sbjzxx.hxwxpmlxx:chemical_info:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:46:03', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004462020033', '2025062004462020030', '删除化学危险品目录信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.sbjzxx.hxwxpmlxx:chemical_info:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:46:03', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004462020034', '2025062004462020030', '批量删除化学危险品目录信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.sbjzxx.hxwxpmlxx:chemical_info:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:46:03', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004462020035', '2025062004462020030', '导出excel_化学危险品目录信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.sbjzxx.hxwxpmlxx:chemical_info:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:46:03', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004462020036', '2025062004462020030', '导入excel_化学危险品目录信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.sbjzxx.hxwxpmlxx:chemical_info:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:46:03', NULL, NULL, 0, 0, '1', 0);