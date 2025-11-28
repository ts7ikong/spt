-- 注意：该页面对应的前台目录为views/sptsjzx/tszyaqgk/tszyhdsj文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025062302252530070', NULL, '特殊作业活动（计划）数据', '/sptsjzx/tszyaqgk/tszyhdsj/acceptTicketActivityList', 'sptsjzx/tszyaqgk/tszyhdsj/AcceptTicketActivityList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-23 14:25:07', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062302252530071', '2025062302252530070', '添加特殊作业活动（计划）数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.tszyaqgk.tszyhdsj:accept_ticket_activity:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 14:25:07', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062302252530072', '2025062302252530070', '编辑特殊作业活动（计划）数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.tszyaqgk.tszyhdsj:accept_ticket_activity:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 14:25:07', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062302252530073', '2025062302252530070', '删除特殊作业活动（计划）数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.tszyaqgk.tszyhdsj:accept_ticket_activity:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 14:25:07', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062302252530074', '2025062302252530070', '批量删除特殊作业活动（计划）数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.tszyaqgk.tszyhdsj:accept_ticket_activity:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 14:25:07', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062302252530075', '2025062302252530070', '导出excel_特殊作业活动（计划）数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.tszyaqgk.tszyhdsj:accept_ticket_activity:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 14:25:07', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025062302252530076', '2025062302252530070', '导入excel_特殊作业活动（计划）数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.tszyaqgk.tszyhdsj:accept_ticket_activity:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-23 14:25:07', NULL, NULL, 0, 0, '1', 0);