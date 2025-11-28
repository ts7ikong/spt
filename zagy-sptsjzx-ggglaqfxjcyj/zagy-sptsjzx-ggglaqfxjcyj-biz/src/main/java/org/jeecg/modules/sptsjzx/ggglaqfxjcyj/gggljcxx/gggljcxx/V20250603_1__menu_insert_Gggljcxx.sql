-- 注意：该页面对应的前台目录为views/sptsjzx/ggglaqfxjcyj/gggljcxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025060303437120240', NULL, '公共管廊基础信息', '/sptsjzx/ggglaqfxjcyj/gggljcxx/gggljcxxList', 'sptsjzx/ggglaqfxjcyj/gggljcxx/GggljcxxList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-03 15:43:24', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060303437120241', '2025060303437120240', '添加公共管廊基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.ggglaqfxjcyj.gggljcxx:gggljcxx:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 15:43:24', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060303437120242', '2025060303437120240', '编辑公共管廊基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.ggglaqfxjcyj.gggljcxx:gggljcxx:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 15:43:24', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060303437120243', '2025060303437120240', '删除公共管廊基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.ggglaqfxjcyj.gggljcxx:gggljcxx:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 15:43:24', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060303437120244', '2025060303437120240', '批量删除公共管廊基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.ggglaqfxjcyj.gggljcxx:gggljcxx:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 15:43:24', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060303437120245', '2025060303437120240', '导出excel_公共管廊基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.ggglaqfxjcyj.gggljcxx:gggljcxx:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 15:43:24', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060303437120246', '2025060303437120240', '导入excel_公共管廊基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.ggglaqfxjcyj.gggljcxx:gggljcxx:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 15:43:24', NULL, NULL, 0, 0, '1', 0);