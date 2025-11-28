-- 注意：该页面对应的前台目录为views/sptsjzx/gygcaqfxgz/gygcsbxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025060305442650470', NULL, '设备信息(化工园区)', '/sptsjzx/gygcaqfxgz/gygcsbxx/gygcsbxxList', 'sptsjzx/gygcaqfxgz/gygcsbxx/GygcsbxxList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-03 17:44:47', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060305442650471', '2025060305442650470', '添加设备信息(化工园区)', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.gygcaqfxgz.gygcsbxx:gygcsbxx:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 17:44:47', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060305442650472', '2025060305442650470', '编辑设备信息(化工园区)', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.gygcaqfxgz.gygcsbxx:gygcsbxx:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 17:44:47', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060305442650473', '2025060305442650470', '删除设备信息(化工园区)', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.gygcaqfxgz.gygcsbxx:gygcsbxx:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 17:44:47', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060305442650474', '2025060305442650470', '批量删除设备信息(化工园区)', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.gygcaqfxgz.gygcsbxx:gygcsbxx:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 17:44:47', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060305442650475', '2025060305442650470', '导出excel_设备信息(化工园区)', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.gygcaqfxgz.gygcsbxx:gygcsbxx:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 17:44:47', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060305442650476', '2025060305442650470', '导入excel_设备信息(化工园区)', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.gygcaqfxgz.gygcsbxx:gygcsbxx:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 17:44:47', NULL, NULL, 0, 0, '1', 0);