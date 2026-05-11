-- 注意：该页面对应的前台目录为views/sptsjzx/zdwxyaqgl/zxjc/jczbxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('202604231138200220', NULL, '监测指标信息', '/sptsjzx/zdwxyaqgl/zxjc/jczbxx/tbHrmwBaseTargetList', 'sptsjzx/zdwxyaqgl/zxjc/jczbxx/TbHrmwBaseTargetList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2026-04-23 11:38:22', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202604231138200221', '202604231138200220', '添加监测指标信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.jczbxx:tb_hrmw_base_target:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-23 11:38:22', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202604231138200222', '202604231138200220', '编辑监测指标信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.jczbxx:tb_hrmw_base_target:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-23 11:38:22', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202604231138200223', '202604231138200220', '删除监测指标信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.jczbxx:tb_hrmw_base_target:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-23 11:38:22', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202604231138200224', '202604231138200220', '批量删除监测指标信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.jczbxx:tb_hrmw_base_target:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-23 11:38:22', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202604231138200225', '202604231138200220', '导出excel_监测指标信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.jczbxx:tb_hrmw_base_target:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-23 11:38:22', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202604231138200226', '202604231138200220', '导入excel_监测指标信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.jczbxx:tb_hrmw_base_target:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-23 11:38:22', NULL, NULL, 0, 0, '1', 0);