-- 注意：该页面对应的前台目录为views/sptsjzx/fbhgl/mjkkglxxjcxxgl/whpyscltccxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('202505300446000370', NULL, '危化品运输车辆停车场信息', '/sptsjzx/fbhgl/mjkkglxxjcxxgl/whpyscltccxx/whpyscltccxxList', 'sptsjzx/fbhgl/mjkkglxxjcxxgl/whpyscltccxx/WhpyscltccxxList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-30 16:46:37', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505300446010371', '202505300446000370', '添加危化品运输车辆停车场信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.whpyscltccxx:whpyscltccxx:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:46:37', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505300446010372', '202505300446000370', '编辑危化品运输车辆停车场信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.whpyscltccxx:whpyscltccxx:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:46:37', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505300446010373', '202505300446000370', '删除危化品运输车辆停车场信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.whpyscltccxx:whpyscltccxx:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:46:37', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505300446010374', '202505300446000370', '批量删除危化品运输车辆停车场信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.whpyscltccxx:whpyscltccxx:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:46:37', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505300446010375', '202505300446000370', '导出excel_危化品运输车辆停车场信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.whpyscltccxx:whpyscltccxx:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:46:37', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505300446010376', '202505300446000370', '导入excel_危化品运输车辆停车场信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.fbhgl.mjkkglxxjcxxgl.whpyscltccxx:whpyscltccxx:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:46:37', NULL, NULL, 0, 0, '1', 0);