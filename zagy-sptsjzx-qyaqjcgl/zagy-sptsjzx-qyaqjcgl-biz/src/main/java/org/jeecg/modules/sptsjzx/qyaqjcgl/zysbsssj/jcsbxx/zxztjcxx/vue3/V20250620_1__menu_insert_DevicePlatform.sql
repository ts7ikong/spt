-- 注意：该页面对应的前台目录为views/sptsjzx/qyaqjcgl/zysbsssj/jcsbxx/zxztjcxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025062004442080150', NULL, '装卸站台基础信息', '/sptsjzx/qyaqjcgl/zysbsssj/jcsbxx/zxztjcxx/devicePlatformList', 'sptsjzx/qyaqjcgl/zysbsssj/jcsbxx/zxztjcxx/DevicePlatformList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-20 16:44:15', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004442080151', '2025062004442080150', '添加装卸站台基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zxztjcxx:device_platform:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:44:15', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004442080152', '2025062004442080150', '编辑装卸站台基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zxztjcxx:device_platform:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:44:15', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004442080153', '2025062004442080150', '删除装卸站台基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zxztjcxx:device_platform:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:44:15', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004442080154', '2025062004442080150', '批量删除装卸站台基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zxztjcxx:device_platform:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:44:15', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004442080155', '2025062004442080150', '导出excel_装卸站台基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zxztjcxx:device_platform:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:44:15', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004442080156', '2025062004442080150', '导入excel_装卸站台基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.zxztjcxx:device_platform:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:44:15', NULL, NULL, 0, 0, '1', 0);