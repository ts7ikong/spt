-- 注意：该页面对应的前台目录为views/sptsjzx/zdwxyaqgl/zxjc/zbjcbjsj文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2026042203088480060', NULL, '指标监测报警数据', '/sptsjzx/zdwxyaqgl/zxjc/zbjcbjsj/tbHrmwMoniAlarmList', 'sptsjzx/zdwxyaqgl/zxjc/zbjcbjsj/TbHrmwMoniAlarmList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2026-04-22 15:08:06', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026042203088480061', '2026042203088480060', '添加指标监测报警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.zbjcbjsj:tb_hrmw_moni_alarm:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-22 15:08:06', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026042203088480062', '2026042203088480060', '编辑指标监测报警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.zbjcbjsj:tb_hrmw_moni_alarm:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-22 15:08:06', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026042203088480063', '2026042203088480060', '删除指标监测报警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.zbjcbjsj:tb_hrmw_moni_alarm:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-22 15:08:06', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026042203088480064', '2026042203088480060', '批量删除指标监测报警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.zbjcbjsj:tb_hrmw_moni_alarm:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-22 15:08:06', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026042203088480065', '2026042203088480060', '导出excel_指标监测报警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.zbjcbjsj:tb_hrmw_moni_alarm:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-22 15:08:06', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026042203088480066', '2026042203088480060', '导入excel_指标监测报警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.zbjcbjsj:tb_hrmw_moni_alarm:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-22 15:08:06', NULL, NULL, 0, 0, '1', 0);