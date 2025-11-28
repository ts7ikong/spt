-- 注意：该页面对应的前台目录为views/sptsjzx/qyaqjcgl/qyjbxx/qylshghygx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025062004358860250', NULL, '企业隶属化工行业关系表', '/sptsjzx/qyaqjcgl/qyjbxx/qylshghygx/qylshghygxList', 'sptsjzx/qyaqjcgl/qyjbxx/qylshghygx/QylshghygxList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-20 16:35:25', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004358860251', '2025062004358860250', '添加企业隶属化工行业关系表', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.qylshghygx:qylshghygx:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:35:25', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004358860252', '2025062004358860250', '编辑企业隶属化工行业关系表', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.qylshghygx:qylshghygx:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:35:25', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004358860253', '2025062004358860250', '删除企业隶属化工行业关系表', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.qylshghygx:qylshghygx:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:35:25', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004358860254', '2025062004358860250', '批量删除企业隶属化工行业关系表', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.qylshghygx:qylshghygx:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:35:25', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004358860255', '2025062004358860250', '导出excel_企业隶属化工行业关系表', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.qylshghygx:qylshghygx:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:35:25', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004358860256', '2025062004358860250', '导入excel_企业隶属化工行业关系表', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.qylshghygx:qylshghygx:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:35:25', NULL, NULL, 0, 0, '1', 0);