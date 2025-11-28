-- 注意：该页面对应的前台目录为views/sptsjzx/aqjcgl/aqscxzxkgl/stsjgxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('202505290531930540', NULL, '“三同时”监管信息表', '/sptsjzx/aqjcgl/aqscxzxkgl/stsjgxx/stsjgxxList', 'sptsjzx/aqjcgl/aqscxzxkgl/stsjgxx/StsjgxxList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-29 17:31:54', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505290531930541', '202505290531930540', '添加“三同时”监管信息表', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.aqscxzxkgl.stsjgxx:stsjgxx:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-29 17:31:54', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505290531930542', '202505290531930540', '编辑“三同时”监管信息表', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.aqscxzxkgl.stsjgxx:stsjgxx:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-29 17:31:54', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505290531930543', '202505290531930540', '删除“三同时”监管信息表', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.aqscxzxkgl.stsjgxx:stsjgxx:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-29 17:31:54', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505290531930544', '202505290531930540', '批量删除“三同时”监管信息表', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.aqscxzxkgl.stsjgxx:stsjgxx:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-29 17:31:54', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505290531930545', '202505290531930540', '导出excel_“三同时”监管信息表', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.aqscxzxkgl.stsjgxx:stsjgxx:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-29 17:31:54', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505290531930546', '202505290531930540', '导入excel_“三同时”监管信息表', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.aqscxzxkgl.stsjgxx:stsjgxx:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-29 17:31:54', NULL, NULL, 0, 0, '1', 0);