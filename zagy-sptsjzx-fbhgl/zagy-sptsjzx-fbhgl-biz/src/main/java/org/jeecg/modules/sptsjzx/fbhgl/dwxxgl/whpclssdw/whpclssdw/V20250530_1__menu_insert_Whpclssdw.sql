-- 注意：该页面对应的前台目录为views/sptsjzx/fbhgl/dwxxgl/whpclssdw文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025053005212550090', NULL, '危化品车辆实时定位', '/sptsjzx/fbhgl/dwxxgl/whpclssdw/whpclssdwList', 'sptsjzx/fbhgl/dwxxgl/whpclssdw/WhpclssdwList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-30 17:21:09', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053005212550091', '2025053005212550090', '添加危化品车辆实时定位', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.dwxxgl.whpclssdw:whpclssdw:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 17:21:09', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053005212550092', '2025053005212550090', '编辑危化品车辆实时定位', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.dwxxgl.whpclssdw:whpclssdw:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 17:21:09', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053005212550093', '2025053005212550090', '删除危化品车辆实时定位', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.dwxxgl.whpclssdw:whpclssdw:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 17:21:09', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053005212550094', '2025053005212550090', '批量删除危化品车辆实时定位', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.dwxxgl.whpclssdw:whpclssdw:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 17:21:09', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053005212550095', '2025053005212550090', '导出excel_危化品车辆实时定位', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.dwxxgl.whpclssdw:whpclssdw:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 17:21:09', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053005212550096', '2025053005212550090', '导入excel_危化品车辆实时定位', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.dwxxgl.whpclssdw:whpclssdw:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 17:21:09', NULL, NULL, 0, 0, '1', 0);