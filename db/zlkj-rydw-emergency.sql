/*
 Navicat Premium Data Transfer

 Source Server         : 明蒙能源
 Source Server Type    : MySQL
 Source Server Version : 80041 (8.0.41-0ubuntu0.20.04.1)
 Source Host           : 183.66.29.50:3306
 Source Schema         : zlkj-rydw-emergency

 Target Server Type    : MySQL
 Target Server Version : 80041 (8.0.41-0ubuntu0.20.04.1)
 File Encoding         : 65001

 Date: 07/03/2025 15:08:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for emergency_area_type
-- ----------------------------
DROP TABLE IF EXISTS `emergency_area_type`;
CREATE TABLE `emergency_area_type`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `is_police` int NULL DEFAULT NULL COMMENT '是否报警 0否 1是',
  `police_range` int NULL DEFAULT NULL COMMENT '报警范围 1人员 2车辆 3同时生效',
  `risk_area_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '区域编号',
  `police_remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '报警说明',
  `police_redis_key` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '报警信息redis',
  `area_type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '区域类型名称',
  `create_time` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `is_police`(`is_police` ASC) USING BTREE,
  INDEX `area_type_name`(`area_type_name` ASC) USING BTREE,
  INDEX `create_time`(`create_time` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '区域类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emergency_area_type
-- ----------------------------
INSERT INTO `emergency_area_type` VALUES (4, 1, 1, '104', '越界报警(进入1分钟,离开1分钟);', 'LOCATION:AREATYPE:e9d2830a-ede4-4f75-ae1a-64408c7f3468', 'AD罐区', '2023-03-08 18:27:55');
INSERT INTO `emergency_area_type` VALUES (5, 1, 2, '108', '越界报警(进入1分钟,离开1分钟);滞留报警(滞留1分钟);', 'LOCATION:AREATYPE:e1042aec-91e4-4cd7-9fbc-293014150c58', '趸船', '2023-03-10 14:38:11');

-- ----------------------------
-- Table structure for emergency_car
-- ----------------------------
DROP TABLE IF EXISTS `emergency_car`;
CREATE TABLE `emergency_car`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `company_id` int NULL DEFAULT NULL COMMENT '公司编号',
  `img_type` int NULL DEFAULT NULL COMMENT '显示图片类型1-蓝色帽子 2-红色帽子 3-黄色帽子 4-蓝色车 5-黄色车 6-红色车',
  `car_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '车牌号码',
  `car_brand` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '车辆品牌',
  `car_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '车辆型号',
  `departmentcode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门编号',
  `departmentname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `create_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登记时间',
  `remarks` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '车辆管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emergency_car
-- ----------------------------

-- ----------------------------
-- Table structure for emergency_card
-- ----------------------------
DROP TABLE IF EXISTS `emergency_card`;
CREATE TABLE `emergency_card`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `card` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '卡号',
  `power` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电量信息 1低电量 2充电中 3已充满',
  `status` int NULL DEFAULT NULL COMMENT '标签状态 0全部 1正常 2离线有信号 3离线无信号',
  `area_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最后定位区域',
  `last_time` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最后定位时间',
  `state` int NULL DEFAULT 0 COMMENT '绑定状态0-未绑定1-已绑定',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 82 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '卡片信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emergency_card
-- ----------------------------

-- ----------------------------
-- Table structure for emergency_card_relevance
-- ----------------------------
DROP TABLE IF EXISTS `emergency_card_relevance`;
CREATE TABLE `emergency_card_relevance`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `link_id` int NULL DEFAULT NULL COMMENT '关联id',
  `type` int NULL DEFAULT NULL COMMENT '类型1-员工 2-承包商 3-访客 4-车辆 5-外来车辆',
  `card` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '卡号',
  `remarks` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注 比如姓名',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `card`(`card` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '卡号关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emergency_card_relevance
-- ----------------------------

-- ----------------------------
-- Table structure for emergency_command_accident
-- ----------------------------
DROP TABLE IF EXISTS `emergency_command_accident`;
CREATE TABLE `emergency_command_accident`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `command_basic_info_id` int NULL DEFAULT NULL COMMENT '应急指挥管理编号',
  `accident_name` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '事故点名称',
  `accident_lon` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '经度',
  `accident_lat` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `create_time` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `radius` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '半径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '事故点信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emergency_command_accident
-- ----------------------------
INSERT INTO `emergency_command_accident` VALUES (5, 1, '事故1', '106.31990000000000000000', '29.58863000000000000000', '2024-04-02 17:28:47', '张飞', NULL);
INSERT INTO `emergency_command_accident` VALUES (6, 1, '事故2', '106.99311100000000000000', '29.81068600000000000000', '2024-04-02 17:28:47', '张飞', NULL);

-- ----------------------------
-- Table structure for emergency_command_basic_info
-- ----------------------------
DROP TABLE IF EXISTS `emergency_command_basic_info`;
CREATE TABLE `emergency_command_basic_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `event_name` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '事件名称',
  `create_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `command_status` int NULL DEFAULT NULL COMMENT '指挥状态 1未开始 2正在指挥 3已结束',
  `command_end_time` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '指挥结束时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `command_status`(`command_status` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '应急指挥管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emergency_command_basic_info
-- ----------------------------
INSERT INTO `emergency_command_basic_info` VALUES (1, '测试1', '张飞', '2024-04-02 16:20:47', 2, '2024-04-02 16:40:33');

-- ----------------------------
-- Table structure for emergency_command_count
-- ----------------------------
DROP TABLE IF EXISTS `emergency_command_count`;
CREATE TABLE `emergency_command_count`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `create_time` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '年月日 时分 格式',
  `area_type` int NULL DEFAULT NULL COMMENT '区域类型',
  `command_basic_info_id` int NULL DEFAULT NULL COMMENT '应急指挥管理编号',
  `people_count` int NULL DEFAULT NULL COMMENT '到达人数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 141811 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '应急演练统计' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emergency_command_count
-- ----------------------------

-- ----------------------------
-- Table structure for emergency_command_evacuate_area
-- ----------------------------
DROP TABLE IF EXISTS `emergency_command_evacuate_area`;
CREATE TABLE `emergency_command_evacuate_area`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `area_path` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '以##隔开 经度纬度以逗号隔开 ',
  `area_name` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '撤离区域名称',
  `secure_area_responsible` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '安全区域负责人',
  `secure_area_responsible_phone` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '安全区域负责人电话',
  `urgent_people` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '紧急联系人',
  `urgent_phone` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '紧急联系人电话',
  `command_basic_info_id` int NULL DEFAULT NULL COMMENT '应急指挥管理编号',
  `create_time` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `command_basic_info_id`(`command_basic_info_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '撤离区域' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emergency_command_evacuate_area
-- ----------------------------
INSERT INTO `emergency_command_evacuate_area` VALUES (5, '106.62581,29.6202##106.62642,29.61912##106.62656,29.61902##106.62683,29.61852##106.62709,29.61861##106.62667,29.61944##106.62619,29.62032##106.62603,29.62029', '撤离安全区1', '张飞', '13399845245', 'zahngfei', '18844526985', 1, '2024-04-02 17:28:47', '张飞');
INSERT INTO `emergency_command_evacuate_area` VALUES (6, '106.62581,29.6202##106.62642,29.61912##106.62656,29.61902##106.62683,29.61852##106.62709,29.61861##106.62667,29.61944##106.62619,29.62032##106.62603,29.62029', '撤离安全区2', '张飞', '13399845245', 'zahngfei', '18844526985', 1, '2024-04-02 17:28:47', '张飞');

-- ----------------------------
-- Table structure for emergency_command_security_area
-- ----------------------------
DROP TABLE IF EXISTS `emergency_command_security_area`;
CREATE TABLE `emergency_command_security_area`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `secure_area_path` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '以##隔开 经度纬度以逗号隔开 ',
  `secure_area_name` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '安全区域名称',
  `secure_area_responsible` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '安全区域负责人',
  `secure_area_responsible_phone` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '安全区域负责人电话',
  `urgent_people` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '紧急联系人',
  `urgent_phone` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '紧急联系人电话',
  `command_basic_info_id` int NULL DEFAULT NULL COMMENT '应急指挥管理编号',
  `create_time` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `command_basic_info_id`(`command_basic_info_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emergency_command_security_area
-- ----------------------------
INSERT INTO `emergency_command_security_area` VALUES (4, '106.62581,29.6202##106.62642,29.61912##106.62656,29.61902##106.62683,29.61852##106.62709,29.61861##106.62667,29.61944##106.62619,29.62032##106.62603,29.62029', '安全区域1', '张飞', '13399845245', 'zahngfei', '18844526985', 1, '2024-04-02 17:28:47', '张飞');
INSERT INTO `emergency_command_security_area` VALUES (5, '106.62581,29.6202##106.62642,29.61912##106.62656,29.61902##106.62683,29.61852##106.62709,29.61861##106.62667,29.61944##106.62619,29.62032##106.62603,29.62029', '安全区域2', '张飞', '13399845245', 'ZHANGFEI', '18844526985', 1, '2024-04-05 13:28:47', '张飞');

-- ----------------------------
-- Table structure for emergency_command_security_route
-- ----------------------------
DROP TABLE IF EXISTS `emergency_command_security_route`;
CREATE TABLE `emergency_command_security_route`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `evacuate_route_path` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '撤离路线坐标 以逗号和##隔开',
  `command_basic_info_id` int NULL DEFAULT NULL COMMENT '应急指挥管理编号',
  `create_time` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `command_basic_info_id`(`command_basic_info_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '安全路线' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emergency_command_security_route
-- ----------------------------
INSERT INTO `emergency_command_security_route` VALUES (1, '123,123##456,456', 1, '2024-04-02 17:28:47', '张飞');
INSERT INTO `emergency_command_security_route` VALUES (2, '123,123##789,789', 1, '2024-04-02 17:28:47', '张飞');

-- ----------------------------
-- Table structure for emergency_out_car
-- ----------------------------
DROP TABLE IF EXISTS `emergency_out_car`;
CREATE TABLE `emergency_out_car`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `company_id` int NULL DEFAULT NULL COMMENT '公司id',
  `img_type` int NULL DEFAULT NULL COMMENT '显示图片类型1-蓝色帽子 2-红色帽子 3-黄色帽子 4-蓝色车 5-黄色车 6-红色车',
  `out_car_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '车牌号',
  `out_car_brand` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '车辆品牌',
  `out_car_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '车辆型号',
  `create_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登记时间',
  `remarks` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `driver_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '司机姓名',
  `driver_card` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '司机定位卡号',
  `driver_id_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '司机身份证号',
  `driver_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '司机电话',
  `driver_remarks` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '司机备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '外来车辆' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emergency_out_car
-- ----------------------------

-- ----------------------------
-- Table structure for emergency_police_area_config
-- ----------------------------
DROP TABLE IF EXISTS `emergency_police_area_config`;
CREATE TABLE `emergency_police_area_config`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `police_config_id` int NULL DEFAULT NULL COMMENT '报警规则编号',
  `risk_area_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '区域编号',
  `risk_area_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '区域名称',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `police_config_id`(`police_config_id` ASC) USING BTREE,
  INDEX `risk_area_code`(`risk_area_code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '报警规则区域配置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emergency_police_area_config
-- ----------------------------

-- ----------------------------
-- Table structure for emergency_police_car_log
-- ----------------------------
DROP TABLE IF EXISTS `emergency_police_car_log`;
CREATE TABLE `emergency_police_car_log`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `car_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '车牌号',
  `driver_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '司机姓名',
  `departmentname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `departmentcode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门编号',
  `create_time` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '报警时间',
  `police_message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '报警信息',
  `car_type` int NULL DEFAULT NULL COMMENT '车辆类型 4公司车辆 5外来车辆',
  `police_type` int NULL DEFAULT NULL COMMENT '报警类型',
  `police_type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '报警类型名称',
  `card` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '定位卡号',
  `handle_person_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '处理人员',
  `handle_state` int NULL DEFAULT NULL COMMENT '处理状态 0未处理 1已处理',
  `police_longitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '经度',
  `police_latitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `handle_message` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '处理信息',
  `handle_time` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '处理时间',
  `risk_area_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '区域编号',
  `risk_area_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '区域名称',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `car_number`(`car_number` ASC) USING BTREE,
  INDEX `driver_name`(`driver_name` ASC) USING BTREE,
  INDEX `create_time`(`create_time` ASC) USING BTREE,
  INDEX `departmentcode`(`departmentcode` ASC) USING BTREE,
  INDEX `car_type`(`car_type` ASC) USING BTREE,
  INDEX `police_type`(`police_type` ASC) USING BTREE,
  INDEX `card`(`card` ASC) USING BTREE,
  INDEX `handle_state`(`handle_state` ASC) USING BTREE,
  INDEX `handle_time`(`handle_time` ASC) USING BTREE,
  INDEX `risk_area_code`(`risk_area_code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emergency_police_car_log
-- ----------------------------

-- ----------------------------
-- Table structure for emergency_police_config
-- ----------------------------
DROP TABLE IF EXISTS `emergency_police_config`;
CREATE TABLE `emergency_police_config`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `formwork_name` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模板名称',
  `formwork_type` int NULL DEFAULT NULL COMMENT '模板类型 1人员模板 2车辆模板',
  `create_time` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `formwork_name`(`formwork_name` ASC) USING BTREE,
  INDEX `formwork_type`(`formwork_type` ASC) USING BTREE,
  INDEX `create_time`(`create_time` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '报警规则配置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emergency_police_config
-- ----------------------------

-- ----------------------------
-- Table structure for emergency_police_person_log
-- ----------------------------
DROP TABLE IF EXISTS `emergency_police_person_log`;
CREATE TABLE `emergency_police_person_log`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `police_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `ob_type` int NULL DEFAULT NULL COMMENT '类型类型1-员工 2-承包商 3-访客 4-车辆 5-外来车辆',
  `risk_area_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '区域编号',
  `risk_area_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '区域名称',
  `department_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `department_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门code',
  `card` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '定位卡号',
  `police_message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '报警信息',
  `police_type` int NULL DEFAULT NULL COMMENT '报警类型',
  `police_type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '报警类型名称',
  `create_time` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '报警时间',
  `handle_person_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '处理人员',
  `handle_state` int NULL DEFAULT NULL COMMENT '处理状态 0未处理 1已处理',
  `police_longitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '经度',
  `police_latitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `handle_message` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '处理信息',
  `handle_time` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '处理时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `police_type`(`police_type` ASC) USING BTREE,
  INDEX `ob_type`(`ob_type` ASC) USING BTREE,
  INDEX `police_name`(`police_name` ASC) USING BTREE,
  INDEX `department_code`(`department_code` ASC) USING BTREE,
  INDEX `create_time`(`create_time` ASC) USING BTREE,
  INDEX `handle_time`(`handle_time` ASC) USING BTREE,
  INDEX `handle_state`(`handle_state` ASC) USING BTREE,
  INDEX `handle_person_name`(`handle_person_name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '报警日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emergency_police_person_log
-- ----------------------------

-- ----------------------------
-- Table structure for emergency_visitor
-- ----------------------------
DROP TABLE IF EXISTS `emergency_visitor`;
CREATE TABLE `emergency_visitor`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `company_id` int NULL DEFAULT NULL COMMENT '公司id',
  `visitor_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `visitor_sex` int NULL DEFAULT NULL COMMENT '性别1-男2-女',
  `visitor_id_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '访客身份证号',
  `visitor_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '访客电话号码',
  `visitor_cause` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '拜访事由',
  `remarks` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '拜访时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '访客信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emergency_visitor
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
