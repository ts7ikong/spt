-- 注意：该页面对应的前台目录为views/sptsjzx/aqjcgl/zzktchdjxgl/zzktcgl文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025052905546880270', NULL, '装置开停车管理', '/sptsjzx/aqjcgl/zzktchdjxgl/zzktcgl/zzktcglList', 'sptsjzx/aqjcgl/zzktchdjxgl/zzktcgl/ZzktcglList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-29 17:54:27', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025052905546890271', '2025052905546880270', '添加装置开停车管理', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.zzktchdjxgl.zzktcgl:zzktcgl:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-29 17:54:27', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025052905546890272', '2025052905546880270', '编辑装置开停车管理', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.zzktchdjxgl.zzktcgl:zzktcgl:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-29 17:54:27', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025052905546890273', '2025052905546880270', '删除装置开停车管理', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.zzktchdjxgl.zzktcgl:zzktcgl:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-29 17:54:27', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025052905546890274', '2025052905546880270', '批量删除装置开停车管理', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.zzktchdjxgl.zzktcgl:zzktcgl:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-29 17:54:27', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025052905546890275', '2025052905546880270', '导出excel_装置开停车管理', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.zzktchdjxgl.zzktcgl:zzktcgl:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-29 17:54:27', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025052905546890276', '2025052905546880270', '导入excel_装置开停车管理', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.zzktchdjxgl.zzktcgl:zzktcgl:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-29 17:54:27', NULL, NULL, 0, 0, '1', 0);