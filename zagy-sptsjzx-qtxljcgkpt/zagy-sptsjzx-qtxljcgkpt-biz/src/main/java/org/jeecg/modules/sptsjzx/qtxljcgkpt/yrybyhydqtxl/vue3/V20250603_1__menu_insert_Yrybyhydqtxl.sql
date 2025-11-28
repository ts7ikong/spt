-- 注意：该页面对应的前台目录为views/sptsjzx/qtxljcgkpt/yrybyhydqtxl文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025060303181360280', NULL, '易燃易爆有毒有害气体泄漏', '/sptsjzx/qtxljcgkpt/yrybyhydqtxl/yrybyhydqtxlList', 'sptsjzx/qtxljcgkpt/yrybyhydqtxl/YrybyhydqtxlList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-03 15:18:28', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060303181360281', '2025060303181360280', '添加易燃易爆有毒有害气体泄漏', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qtxljcgkpt.yrybyhydqtxl:yrybyhydqtxl:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 15:18:28', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060303181360282', '2025060303181360280', '编辑易燃易爆有毒有害气体泄漏', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qtxljcgkpt.yrybyhydqtxl:yrybyhydqtxl:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 15:18:28', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060303181360283', '2025060303181360280', '删除易燃易爆有毒有害气体泄漏', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qtxljcgkpt.yrybyhydqtxl:yrybyhydqtxl:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 15:18:28', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060303181360284', '2025060303181360280', '批量删除易燃易爆有毒有害气体泄漏', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qtxljcgkpt.yrybyhydqtxl:yrybyhydqtxl:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 15:18:28', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060303181360285', '2025060303181360280', '导出excel_易燃易爆有毒有害气体泄漏', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qtxljcgkpt.yrybyhydqtxl:yrybyhydqtxl:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 15:18:28', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060303181360286', '2025060303181360280', '导入excel_易燃易爆有毒有害气体泄漏', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qtxljcgkpt.yrybyhydqtxl:yrybyhydqtxl:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 15:18:28', NULL, NULL, 0, 0, '1', 0);