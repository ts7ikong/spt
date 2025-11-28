-- 注意：该页面对应的前台目录为views/sptsjzx/aqjcgl/cbsgl文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025030305361870070', NULL, '承包商资质信息', '/sptsjzx/aqjcgl/cbsgl/contractorQualificationInfoList', 'sptsjzx/aqjcgl/cbsgl/ContractorQualificationInfoList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-03-03 17:36:07', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305361870071', '2025030305361870070', '添加承包商资质信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_qualification_info:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:36:07', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305361870072', '2025030305361870070', '编辑承包商资质信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_qualification_info:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:36:07', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305361870073', '2025030305361870070', '删除承包商资质信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_qualification_info:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:36:07', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305361870074', '2025030305361870070', '批量删除承包商资质信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_qualification_info:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:36:07', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305361870075', '2025030305361870070', '导出excel_承包商资质信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_qualification_info:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:36:07', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025030305361870076', '2025030305361870070', '导入excel_承包商资质信息', NULL, NULL, 0, NULL, NULL, 2, 'sptsjzx.aqjcgl.cbsgl:contractor_qualification_info:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-03-03 17:36:07', NULL, NULL, 0, 0, '1', 0);