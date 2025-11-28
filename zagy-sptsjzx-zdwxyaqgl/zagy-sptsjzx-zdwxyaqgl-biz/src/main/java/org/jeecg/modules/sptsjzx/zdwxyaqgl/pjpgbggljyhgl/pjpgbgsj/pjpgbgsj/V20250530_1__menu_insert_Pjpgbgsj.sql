-- 注意：该页面对应的前台目录为views/sptsjzx/zdwxyaqgl/pjpgbggljyhgl/pjpgbgsj文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025053002376070550', NULL, '评价/评估报告数据', '/sptsjzx/zdwxyaqgl/pjpgbggljyhgl/pjpgbgsj/pjpgbgsjList', 'sptsjzx/zdwxyaqgl/pjpgbggljyhgl/pjpgbgsj/PjpgbgsjList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-30 14:37:55', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053002376070551', '2025053002376070550', '添加评价/评估报告数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.pjpgbggljyhgl.pjpgbgsj:pjpgbgsj:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 14:37:55', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053002376070552', '2025053002376070550', '编辑评价/评估报告数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.pjpgbggljyhgl.pjpgbgsj:pjpgbgsj:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 14:37:55', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053002376070553', '2025053002376070550', '删除评价/评估报告数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.pjpgbggljyhgl.pjpgbgsj:pjpgbgsj:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 14:37:55', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053002376070554', '2025053002376070550', '批量删除评价/评估报告数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.pjpgbggljyhgl.pjpgbgsj:pjpgbgsj:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 14:37:55', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053002376070555', '2025053002376070550', '导出excel_评价/评估报告数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.pjpgbggljyhgl.pjpgbgsj:pjpgbgsj:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 14:37:55', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053002376070556', '2025053002376070550', '导入excel_评价/评估报告数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.pjpgbggljyhgl.pjpgbgsj:pjpgbgsj:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 14:37:55', NULL, NULL, 0, 0, '1', 0);