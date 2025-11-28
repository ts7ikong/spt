-- 注意：该页面对应的前台目录为views/sptsjzx/qyaqjcgl/qyjbxx/qyzdjggyxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025062004365490210', NULL, '企业重点监管工艺信息', '/sptsjzx/qyaqjcgl/qyjbxx/qyzdjggyxx/qyzdjggyxxList', 'sptsjzx/qyaqjcgl/qyjbxx/qyzdjggyxx/QyzdjggyxxList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-20 16:36:21', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004365490211', '2025062004365490210', '添加企业重点监管工艺信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.qyzdjggyxx:qyzdjggyxx:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:36:21', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004365490212', '2025062004365490210', '编辑企业重点监管工艺信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.qyzdjggyxx:qyzdjggyxx:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:36:21', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004365490213', '2025062004365490210', '删除企业重点监管工艺信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.qyzdjggyxx:qyzdjggyxx:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:36:21', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004365490214', '2025062004365490210', '批量删除企业重点监管工艺信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.qyzdjggyxx:qyzdjggyxx:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:36:21', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004365490215', '2025062004365490210', '导出excel_企业重点监管工艺信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.qyzdjggyxx:qyzdjggyxx:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:36:21', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062004365490216', '2025062004365490210', '导入excel_企业重点监管工艺信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.qyaqjcgl.qyjbxx.qyzdjggyxx:qyzdjggyxx:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-20 16:36:21', NULL, NULL, 0, 0, '1', 0);