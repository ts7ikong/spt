-- 注意：该页面对应的前台目录为views/sptsjzx/qyaqjcgl/qyjbxx/wxyhxpxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('202506300333810030', NULL, '危险源化学品信息', '/sptsjzx/qyaqjcgl/qyjbxx/wxyhxpxx/wxyhxpxxList', 'sptsjzx/qyaqjcgl/qyjbxx/wxyhxpxx/WxyhxpxxList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-30 15:33:03', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202506300333810031', '202506300333810030', '添加危险源化学品信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.wxyhxpxx:wxyhxpxx:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-30 15:33:03', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202506300333820032', '202506300333810030', '编辑危险源化学品信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.wxyhxpxx:wxyhxpxx:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-30 15:33:03', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202506300333820033', '202506300333810030', '删除危险源化学品信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.wxyhxpxx:wxyhxpxx:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-30 15:33:03', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202506300333820034', '202506300333810030', '批量删除危险源化学品信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.wxyhxpxx:wxyhxpxx:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-30 15:33:03', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202506300333820035', '202506300333810030', '导出excel_危险源化学品信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.wxyhxpxx:wxyhxpxx:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-30 15:33:03', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202506300333820036', '202506300333810030', '导入excel_危险源化学品信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.wxyhxpxx:wxyhxpxx:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-30 15:33:03', NULL, NULL, 0, 0, '1', 0);