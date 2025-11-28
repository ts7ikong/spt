-- 注意：该页面对应的前台目录为views/sptsjzx/qyaqjcgl/zysbsssj/jcsbxx/qtxldjcxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025062004433750460', NULL, '气体泄漏点监测信息', '/sptsjzx/qyaqjcgl/zysbsssj/jcsbxx/qtxldjcxx/deviceGasSensorList', 'sptsjzx/qyaqjcgl/zysbsssj/jcsbxx/qtxldjcxx/DeviceGasSensorList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-20 16:43:46', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004433750461', '2025062004433750460', '添加气体泄漏点监测信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.qtxldjcxx:device_gas_sensor:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:43:46', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004433750462', '2025062004433750460', '编辑气体泄漏点监测信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.qtxldjcxx:device_gas_sensor:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:43:46', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004433750463', '2025062004433750460', '删除气体泄漏点监测信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.qtxldjcxx:device_gas_sensor:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:43:46', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004433750464', '2025062004433750460', '批量删除气体泄漏点监测信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.qtxldjcxx:device_gas_sensor:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:43:46', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004433750465', '2025062004433750460', '导出excel_气体泄漏点监测信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.qtxldjcxx:device_gas_sensor:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:43:46', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004433750466', '2025062004433750460', '导入excel_气体泄漏点监测信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.zysbsssj.jcsbxx.qtxldjcxx:device_gas_sensor:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:43:46', NULL, NULL, 0, 0, '1', 0);