-- 注意：该页面对应的前台目录为views/sptsjzx/mjyj/yjzysj/yjbncsxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025060210177820410', NULL, '应急避难场所信息', '/sptsjzx/mjyj/yjzysj/yjbncsxx/yjbncsxxList', 'sptsjzx/mjyj/yjzysj/yjbncsxx/YjbncsxxList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-02 22:17:41', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060210177820411', '2025060210177820410', '添加应急避难场所信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjzysj.yjbncsxx:yjbncsxx:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-02 22:17:41', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060210177820412', '2025060210177820410', '编辑应急避难场所信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjzysj.yjbncsxx:yjbncsxx:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-02 22:17:41', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060210177820413', '2025060210177820410', '删除应急避难场所信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjzysj.yjbncsxx:yjbncsxx:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-02 22:17:41', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060210177820414', '2025060210177820410', '批量删除应急避难场所信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjzysj.yjbncsxx:yjbncsxx:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-02 22:17:41', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060210177830415', '2025060210177820410', '导出excel_应急避难场所信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjzysj.yjbncsxx:yjbncsxx:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-02 22:17:41', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060210177830416', '2025060210177820410', '导入excel_应急避难场所信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjzysj.yjbncsxx:yjbncsxx:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-02 22:17:41', NULL, NULL, 0, 0, '1', 0);