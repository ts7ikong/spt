-- 注意：该页面对应的前台目录为views/sptsjzx/qyaqjcgl/aqscxzxkgl/qystsjgxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025062004474440050', NULL, '企业三同时监管信息', '/sptsjzx/qyaqjcgl/aqscxzxkgl/qystsjgxx/stsjgxxList', 'sptsjzx/qyaqjcgl/aqscxzxkgl/qystsjgxx/StsjgxxList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-20 16:47:05', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004474440051', '2025062004474440050', '添加企业三同时监管信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.aqscxzxkgl.qystsjgxx:stsjgxx:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:47:05', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004474440052', '2025062004474440050', '编辑企业三同时监管信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.aqscxzxkgl.qystsjgxx:stsjgxx:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:47:05', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004474440053', '2025062004474440050', '删除企业三同时监管信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.aqscxzxkgl.qystsjgxx:stsjgxx:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:47:05', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004474440054', '2025062004474440050', '批量删除企业三同时监管信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.aqscxzxkgl.qystsjgxx:stsjgxx:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:47:05', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004474440055', '2025062004474440050', '导出excel_企业三同时监管信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.aqscxzxkgl.qystsjgxx:stsjgxx:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:47:05', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004474440056', '2025062004474440050', '导入excel_企业三同时监管信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.aqscxzxkgl.qystsjgxx:stsjgxx:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:47:05', NULL, NULL, 0, 0, '1', 0);