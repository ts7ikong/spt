-- 注意：该页面对应的前台目录为views/sptsjzx/qyaqjcgl/zysbsssj/jcsbxx/cgjcxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025062004437260210', NULL, '储罐基础信息', '/sptsjzx/qyaqjcgl/zysbsssj/jcsbxx/cgjcxx/tankDeviceInfoList', 'sptsjzx/qyaqjcgl/zysbsssj/jcsbxx/cgjcxx/TankDeviceInfoList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-20 16:43:21', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004437260211', '2025062004437260210', '添加储罐基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.cgjcxx:tank_device_info:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:43:21', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004437260212', '2025062004437260210', '编辑储罐基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.cgjcxx:tank_device_info:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:43:21', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004437260213', '2025062004437260210', '删除储罐基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.cgjcxx:tank_device_info:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:43:21', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004437260214', '2025062004437260210', '批量删除储罐基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.cgjcxx:tank_device_info:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:43:21', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004437260215', '2025062004437260210', '导出excel_储罐基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.cgjcxx:tank_device_info:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:43:21', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004437260216', '2025062004437260210', '导入excel_储罐基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.cgjcxx:tank_device_info:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:43:21', NULL, NULL, 0, 0, '1', 0);