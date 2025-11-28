-- 注意：该页面对应的前台目录为views/sptsjzx/zdwxyaqgl/yjtssj/yjsjsj文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025053011383280030', NULL, '预警事件数据', '/sptsjzx/zdwxyaqgl/yjtssj/yjsjsj/yjsjsjList', 'sptsjzx/zdwxyaqgl/yjtssj/yjsjsj/YjsjsjList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-30 11:38:03', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011383280031', '2025053011383280030', '添加预警事件数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.yjtssj.yjsjsj:yjsjsj:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:38:03', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011383280032', '2025053011383280030', '编辑预警事件数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.yjtssj.yjsjsj:yjsjsj:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:38:03', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011383280033', '2025053011383280030', '删除预警事件数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.yjtssj.yjsjsj:yjsjsj:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:38:03', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011383280034', '2025053011383280030', '批量删除预警事件数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.yjtssj.yjsjsj:yjsjsj:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:38:03', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011383280035', '2025053011383280030', '导出excel_预警事件数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.yjtssj.yjsjsj:yjsjsj:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:38:03', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053011383280036', '2025053011383280030', '导入excel_预警事件数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.yjtssj.yjsjsj:yjsjsj:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 11:38:03', NULL, NULL, 0, 0, '1', 0);