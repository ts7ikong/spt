-- 注意：该页面对应的前台目录为views/sptsjzx/qtxljcgkpt/yrybydyhqtxljcgksb文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('202506030318670100', NULL, '易燃易爆有毒有害气体泄漏监测管控设备', '/sptsjzx/qtxljcgkpt/yrybydyhqtxljcgksb/yrybydyhqtxljcgksbList', 'sptsjzx/qtxljcgkpt/yrybydyhqtxljcgksb/YrybydyhqtxljcgksbList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-03 15:18:10', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202506030318680101', '202506030318670100', '添加易燃易爆有毒有害气体泄漏监测管控设备', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qtxljcgkpt.yrybydyhqtxljcgksb:yrybydyhqtxljcgksb:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 15:18:10', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202506030318680102', '202506030318670100', '编辑易燃易爆有毒有害气体泄漏监测管控设备', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qtxljcgkpt.yrybydyhqtxljcgksb:yrybydyhqtxljcgksb:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 15:18:10', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202506030318680103', '202506030318670100', '删除易燃易爆有毒有害气体泄漏监测管控设备', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qtxljcgkpt.yrybydyhqtxljcgksb:yrybydyhqtxljcgksb:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 15:18:10', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202506030318680104', '202506030318670100', '批量删除易燃易爆有毒有害气体泄漏监测管控设备', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qtxljcgkpt.yrybydyhqtxljcgksb:yrybydyhqtxljcgksb:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 15:18:10', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202506030318680105', '202506030318670100', '导出excel_易燃易爆有毒有害气体泄漏监测管控设备', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qtxljcgkpt.yrybydyhqtxljcgksb:yrybydyhqtxljcgksb:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 15:18:10', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202506030318680106', '202506030318670100', '导入excel_易燃易爆有毒有害气体泄漏监测管控设备', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qtxljcgkpt.yrybydyhqtxljcgksb:yrybydyhqtxljcgksb:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 15:18:10', NULL, NULL, 0, 0, '1', 0);