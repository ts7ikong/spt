-- 注意：该页面对应的前台目录为views/sptsjzx/zdwxyaqgl/xccc/xtsyqk/xtyhdljl文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('202505300416490220', NULL, '系统用户登录记录', '/sptsjzx/zdwxyaqgl/xccc/xtsyqk/xtyhdljl/xtyhdljlList', 'sptsjzx/zdwxyaqgl/xccc/xtsyqk/xtyhdljl/XtyhdljlList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-05-30 16:16:22', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505300416490221', '202505300416490220', '添加系统用户登录记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.xtsyqk.xtyhdljl:xtyhdljl:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:16:22', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505300416490222', '202505300416490220', '编辑系统用户登录记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.xtsyqk.xtyhdljl:xtyhdljl:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:16:22', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505300416490223', '202505300416490220', '删除系统用户登录记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.xtsyqk.xtyhdljl:xtyhdljl:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:16:22', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505300416490224', '202505300416490220', '批量删除系统用户登录记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.xtsyqk.xtyhdljl:xtyhdljl:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:16:22', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505300416490225', '202505300416490220', '导出excel_系统用户登录记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.xtsyqk.xtyhdljl:xtyhdljl:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:16:22', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202505300416490226', '202505300416490220', '导入excel_系统用户登录记录', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.xccc.xtsyqk.xtyhdljl:xtyhdljl:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-05-30 16:16:22', NULL, NULL, 0, 0, '1', 0);