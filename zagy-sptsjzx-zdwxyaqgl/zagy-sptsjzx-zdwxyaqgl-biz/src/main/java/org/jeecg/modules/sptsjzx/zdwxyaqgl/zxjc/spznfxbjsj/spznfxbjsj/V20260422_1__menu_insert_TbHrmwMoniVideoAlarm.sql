-- 注意：该页面对应的前台目录为views/sptsjzx/zdwxyaqgl/zxjc/spznfxbjsj文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('202604220314260560', NULL, '视频智能分析报警数据', '/sptsjzx/zdwxyaqgl/zxjc/spznfxbjsj/tbHrmwMoniVideoAlarmList', 'sptsjzx/zdwxyaqgl/zxjc/spznfxbjsj/TbHrmwMoniVideoAlarmList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2026-04-22 15:14:56', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202604220314260561', '202604220314260560', '添加视频智能分析报警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.spznfxbjsj:tb_hrmw_moni_video_alarm:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-22 15:14:56', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202604220314260562', '202604220314260560', '编辑视频智能分析报警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.spznfxbjsj:tb_hrmw_moni_video_alarm:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-22 15:14:56', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202604220314260563', '202604220314260560', '删除视频智能分析报警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.spznfxbjsj:tb_hrmw_moni_video_alarm:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-22 15:14:56', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202604220314270564', '202604220314260560', '批量删除视频智能分析报警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.spznfxbjsj:tb_hrmw_moni_video_alarm:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-22 15:14:56', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202604220314270565', '202604220314260560', '导出excel_视频智能分析报警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.spznfxbjsj:tb_hrmw_moni_video_alarm:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-22 15:14:56', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202604220314270566', '202604220314260560', '导入excel_视频智能分析报警数据', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.zdwxyaqgl.zxjc.spznfxbjsj:tb_hrmw_moni_video_alarm:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-04-22 15:14:56', NULL, NULL, 0, 0, '1', 0);