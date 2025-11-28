-- 注意：该页面对应的前台目录为views/sptsjzx/mjyj/yjfzjc/yjczfajl文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025060312536230020', NULL, '应急处置方案记录', '/sptsjzx/mjyj/yjfzjc/yjczfajl/yjczfajlList', 'sptsjzx/mjyj/yjfzjc/yjczfajl/YjczfajlList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-03 00:53:02', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060312536230021', '2025060312536230020', '添加应急处置方案记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjfzjc.yjczfajl:yjczfajl:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 00:53:02', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060312536230022', '2025060312536230020', '编辑应急处置方案记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjfzjc.yjczfajl:yjczfajl:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 00:53:02', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060312536230023', '2025060312536230020', '删除应急处置方案记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjfzjc.yjczfajl:yjczfajl:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 00:53:02', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060312536230024', '2025060312536230020', '批量删除应急处置方案记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjfzjc.yjczfajl:yjczfajl:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 00:53:02', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060312536230025', '2025060312536230020', '导出excel_应急处置方案记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjfzjc.yjczfajl:yjczfajl:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 00:53:02', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060312536230026', '2025060312536230020', '导入excel_应急处置方案记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjfzjc.yjczfajl:yjczfajl:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-03 00:53:02', NULL, NULL, 0, 0, '1', 0);