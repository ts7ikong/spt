-- 注意：该页面对应的前台目录为views/sptsjzx/mjyj/yjzysj/yjwzjcxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025053006494370140', NULL, '应急物资基础信息', '/sptsjzx/mjyj/yjzysj/yjwzjcxx/yjwzjcxxList', 'sptsjzx/mjyj/yjzysj/yjwzjcxx/YjwzjcxxList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-30 18:49:14', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053006494370141', '2025053006494370140', '添加应急物资基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjzysj.yjwzjcxx:yjwzjcxx:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 18:49:14', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053006494370142', '2025053006494370140', '编辑应急物资基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjzysj.yjwzjcxx:yjwzjcxx:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 18:49:14', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053006494370143', '2025053006494370140', '删除应急物资基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjzysj.yjwzjcxx:yjwzjcxx:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 18:49:14', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053006494370144', '2025053006494370140', '批量删除应急物资基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjzysj.yjwzjcxx:yjwzjcxx:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 18:49:14', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053006494370145', '2025053006494370140', '导出excel_应急物资基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjzysj.yjwzjcxx:yjwzjcxx:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 18:49:14', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025053006494370146', '2025053006494370140', '导入excel_应急物资基础信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.mjyj.yjzysj.yjwzjcxx:yjwzjcxx:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 18:49:14', NULL, NULL, 0, 0, '1', 0);