-- 注意：该页面对应的前台目录为views/sptsjzx/zdwxyaqgl/zxjc/jczbxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025053011329410290', NULL, '监测指标信息', '/sptsjzx/zdwxyaqgl/zxjc/jczbxx/jczbxxList', 'sptsjzx/zdwxyaqgl/zxjc/jczbxx/JczbxxList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-30 11:32:29', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011329410291', '2025053011329410290', '添加监测指标信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.jczbxx:jczbxx:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:32:29', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011329410292', '2025053011329410290', '编辑监测指标信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.jczbxx:jczbxx:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:32:29', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011329410293', '2025053011329410290', '删除监测指标信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.jczbxx:jczbxx:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:32:29', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011329410294', '2025053011329410290', '批量删除监测指标信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.jczbxx:jczbxx:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:32:29', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011329410295', '2025053011329410290', '导出excel_监测指标信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.jczbxx:jczbxx:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:32:29', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011329410296', '2025053011329410290', '导入excel_监测指标信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.jczbxx:jczbxx:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:32:29', NULL, NULL, 0, 0, '1', 0);