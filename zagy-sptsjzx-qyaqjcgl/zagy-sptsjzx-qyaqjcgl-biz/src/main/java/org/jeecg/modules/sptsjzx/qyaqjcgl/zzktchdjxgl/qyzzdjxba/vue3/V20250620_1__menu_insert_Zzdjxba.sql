-- 注意：该页面对应的前台目录为views/sptsjzx/qyaqjcgl/zzktchdjxgl/qyzzdjxba文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025062004478600410', NULL, '企业装置大检修备案', '/sptsjzx/qyaqjcgl/zzktchdjxgl/qyzzdjxba/zzdjxbaList', 'sptsjzx/qyaqjcgl/zzktchdjxgl/qyzzdjxba/ZzdjxbaList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-20 16:47:41', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004478600411', '2025062004478600410', '添加企业装置大检修备案', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zzktchdjxgl.qyzzdjxba:zzdjxba:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:47:41', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004478600412', '2025062004478600410', '编辑企业装置大检修备案', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zzktchdjxgl.qyzzdjxba:zzdjxba:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:47:41', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004478600413', '2025062004478600410', '删除企业装置大检修备案', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zzktchdjxgl.qyzzdjxba:zzdjxba:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:47:41', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004478600414', '2025062004478600410', '批量删除企业装置大检修备案', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zzktchdjxgl.qyzzdjxba:zzdjxba:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:47:41', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004478600415', '2025062004478600410', '导出excel_企业装置大检修备案', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zzktchdjxgl.qyzzdjxba:zzdjxba:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:47:41', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004478600416', '2025062004478600410', '导入excel_企业装置大检修备案', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zzktchdjxgl.qyzzdjxba:zzdjxba:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:47:41', NULL, NULL, 0, 0, '1', 0);