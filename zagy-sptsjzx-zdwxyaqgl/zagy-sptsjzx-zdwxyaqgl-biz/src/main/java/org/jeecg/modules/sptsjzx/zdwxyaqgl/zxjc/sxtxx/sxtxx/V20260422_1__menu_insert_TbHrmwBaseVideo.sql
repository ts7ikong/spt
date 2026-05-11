-- 注意：该页面对应的前台目录为views/sptsjzx/zdwxyaqgl/zxjc/sxtxx文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2026042203091180320', NULL, '摄像头信息', '/sptsjzx/zdwxyaqgl/zxjc/sxtxx/tbHrmwBaseVideoList', 'sptsjzx/zdwxyaqgl/zxjc/sxtxx/TbHrmwBaseVideoList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2026-04-22 15:09:32', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026042203091180321', '2026042203091180320', '添加摄像头信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.sxtxx:tb_hrmw_base_video:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-22 15:09:32', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026042203091180322', '2026042203091180320', '编辑摄像头信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.sxtxx:tb_hrmw_base_video:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-22 15:09:32', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026042203091180323', '2026042203091180320', '删除摄像头信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.sxtxx:tb_hrmw_base_video:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-22 15:09:32', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026042203091180324', '2026042203091180320', '批量删除摄像头信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.sxtxx:tb_hrmw_base_video:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-22 15:09:32', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026042203091180325', '2026042203091180320', '导出excel_摄像头信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.sxtxx:tb_hrmw_base_video:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-22 15:09:32', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2026042203091180326', '2026042203091180320', '导入excel_摄像头信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.sxtxx:tb_hrmw_base_video:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-22 15:09:32', NULL, NULL, 0, 0, '1', 0);