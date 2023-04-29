/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : medical

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 29/04/2023 13:51:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrators_info
-- ----------------------------
DROP TABLE IF EXISTS `administrators_info`;
CREATE TABLE `administrators_info`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `administrator_name` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `administrator_account` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `role_id` int(32) NOT NULL COMMENT '所属角色',
  `administrator_phone` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `administrator_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `administrator_password_salt` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码盐',
  `administrator_status` int(2) NULL DEFAULT 0 COMMENT '用户状态',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `administrator_account`(`administrator_account`) USING BTREE,
  UNIQUE INDEX `administrator_phone`(`administrator_phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administrators_info
-- ----------------------------
INSERT INTO `administrators_info` VALUES (1, 'admin', 'ad1347890@163.com', 1, '16789009090', 'bd7ef55372cfa6cd17385c6741556fbd', 'l6Yk12Jr', 0, '2023-04-12 21:20:26');

-- ----------------------------
-- Table structure for announcement_info
-- ----------------------------
DROP TABLE IF EXISTS `announcement_info`;
CREATE TABLE `announcement_info`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `announcement_title` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息标题',
  `upload_person` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上传人',
  `announcement_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '公告内容',
  `announcement_status` int(2) NULL DEFAULT 0 COMMENT '公告状态',
  `upload_date` datetime(0) NOT NULL COMMENT '上传时间时间',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `announcement_title`(`announcement_title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '消息公告信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for professional_title_info
-- ----------------------------
DROP TABLE IF EXISTS `professional_title_info`;
CREATE TABLE `professional_title_info`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `professional_title_name` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职称名称',
  `registration_fee` decimal(16, 2) NOT NULL COMMENT '挂号费',
  `professional_title_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职称描述',
  `status` int(2) NULL DEFAULT 0 COMMENT '职称状态',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '职称信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of professional_title_info
-- ----------------------------
INSERT INTO `professional_title_info` VALUES (1, '主任医师', 60.00, '职称描述职称描述', 0, '2023-04-09 16:23:11');
INSERT INTO `professional_title_info` VALUES (2, '主任医师2312311', 600.00, '职称描述', 0, '2023-04-09 16:55:44');

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_name` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色描述',
  `permissions` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '权限集合',
  `role_status` int(2) NULL DEFAULT 0 COMMENT '角色状态',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `role_name`(`role_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES (1, '超级管理员', '这是超级管理员', NULL, 0, '2023-04-12 21:09:52');

SET FOREIGN_KEY_CHECKS = 1;
