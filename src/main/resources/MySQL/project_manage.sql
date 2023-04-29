/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : project_manage

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 29/04/2023 13:51:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for authority_detail
-- ----------------------------
DROP TABLE IF EXISTS `authority_detail`;
CREATE TABLE `authority_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `authority_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限代码',
  `authority_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称',
  `parent_id` int(32) NULL DEFAULT 0 COMMENT '父权限id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of authority_detail
-- ----------------------------
INSERT INTO `authority_detail` VALUES (1, 'SYSTEM_MANAGE', '系统管理', 0, '2023-03-11 14:57:09');
INSERT INTO `authority_detail` VALUES (2, 'BASIC_MANAGE', '基础维护', 0, '2023-03-11 14:57:25');
INSERT INTO `authority_detail` VALUES (3, 'OPERATE_LOG', '操作日志', 1, '2023-03-11 14:57:42');
INSERT INTO `authority_detail` VALUES (7, 'ROLE_MANAGE', '角色管理', 1, '2023-03-11 14:58:49');
INSERT INTO `authority_detail` VALUES (8, 'AUTHORITY_MANAGE', '权限管理', 1, '2023-03-11 15:31:40');
INSERT INTO `authority_detail` VALUES (9, 'ENTERPRISE_MANAGE', '企业管理', 1, '2023-03-11 15:32:18');
INSERT INTO `authority_detail` VALUES (10, 'ROLE_MANAGE_ADD', '新增角色', 7, '2023-03-11 21:39:41');
INSERT INTO `authority_detail` VALUES (11, 'OPERATE_LOG_ADD', '新增日志', 3, '2023-03-11 21:39:59');
INSERT INTO `authority_detail` VALUES (12, 'ENTERPRISE_MANAGE_ADD', '新增企业', 9, '2023-03-11 22:17:07');
INSERT INTO `authority_detail` VALUES (13, 'ENTERPRISE_MANAGE_EDIT', '修改企业', 9, '2023-03-11 22:17:15');
INSERT INTO `authority_detail` VALUES (14, 'ENTERPRISE_MANAGE_DEl', '删除企业', 9, '2023-03-11 22:17:20');
INSERT INTO `authority_detail` VALUES (15, 'SECTION_MANAGE', '科室维护', 2, '2023-03-12 14:20:42');
INSERT INTO `authority_detail` VALUES (16, 'SECTION_MANAGE_ADD', '新增科室', 15, '2023-03-12 14:20:55');
INSERT INTO `authority_detail` VALUES (17, 'SECTION_MANAGE_EDIT', '修改科室', 15, '2023-03-12 14:21:05');
INSERT INTO `authority_detail` VALUES (18, 'SECTION_MANAGE_DEL', '删除科室', 15, '2023-03-12 14:21:11');
INSERT INTO `authority_detail` VALUES (19, 'DEPARTMENT_MANAGE', '部门维护', 2, '2023-03-12 14:36:21');
INSERT INTO `authority_detail` VALUES (20, 'DEPARTMENT_MANAGE_ADD', '新增部门', 19, '2023-03-12 14:36:31');
INSERT INTO `authority_detail` VALUES (21, 'DEPARTMENT_MANAGE_EDIT', '修改部门', 19, '2023-03-12 14:36:39');
INSERT INTO `authority_detail` VALUES (22, 'DEPARTMENT_MANAGE_DEL', '删除部门', 19, '2023-03-12 14:36:47');
INSERT INTO `authority_detail` VALUES (23, 'SUSTAIN_MANAGE', '方式维护', 2, '2023-03-12 14:48:09');
INSERT INTO `authority_detail` VALUES (24, 'SUSTAIN_MANAGE_ADD', '新增方式', 23, '2023-03-12 14:48:19');
INSERT INTO `authority_detail` VALUES (25, 'SUSTAIN_MANAGE_EDIT', '修改方式', 23, '2023-03-12 14:48:27');
INSERT INTO `authority_detail` VALUES (26, 'SUSTAIN_MANAGE_DEL', '删除方式', 23, '2023-03-12 14:48:34');
INSERT INTO `authority_detail` VALUES (27, 'ANNOUNCEMENT_MANAGE', '公告发布', 0, '2023-03-13 21:35:36');
INSERT INTO `authority_detail` VALUES (28, 'PROJECT_PUBLISH', '项目发布', 27, '2023-03-13 21:36:01');

-- ----------------------------
-- Table structure for company_detail
-- ----------------------------
DROP TABLE IF EXISTS `company_detail`;
CREATE TABLE `company_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `company_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公司名称',
  `company_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '公司备注',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公司信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company_detail
-- ----------------------------
INSERT INTO `company_detail` VALUES (1, '上海寻梦信息技术有限公司', '上海寻梦信息技术有限公司，成立于2014年，位于上海市，是一家以从事软件和信息技术服务业为主的企业。', '2023-02-28 15:20:42');
INSERT INTO `company_detail` VALUES (2, '上海寻梦信息技术有限公司', '', '2023-02-28 15:22:05');
INSERT INTO `company_detail` VALUES (3, '上海寻梦信息技术有限公司', '', '2023-03-05 18:35:17');

-- ----------------------------
-- Table structure for department_detail
-- ----------------------------
DROP TABLE IF EXISTS `department_detail`;
CREATE TABLE `department_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `department_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '科室名称',
  `department_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '科室备注',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department_detail
-- ----------------------------
INSERT INTO `department_detail` VALUES (1, '部门一', '', '2023-03-12 15:00:56');
INSERT INTO `department_detail` VALUES (2, '测试部门', '这是测试部门', '2023-03-12 15:01:03');
INSERT INTO `department_detail` VALUES (3, '部门三', '', '2023-03-12 15:01:06');

-- ----------------------------
-- Table structure for enterprise_detail
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_detail`;
CREATE TABLE `enterprise_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `enterprise_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '企业名称',
  `enterprise_corporate` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '企业法人',
  `enterprise_properties` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '企业性质',
  `enterprise_director` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '企业负责人名称',
  `enterprise_director_phone` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '企业负责人联系电话',
  `enterprise_bank` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户银行',
  `enterprise_bank_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户银行账号',
  `enterprise_shareholder` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '股权结构',
  `scope_business` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '经营范围',
  `taxpayer_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '纳税人识别号',
  `taxpayer_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '社会信用代码证',
  `enterprise_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业简介',
  `logon_time` datetime(0) NOT NULL COMMENT '注册时间',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `taxpayer_no`(`taxpayer_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '企业信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of enterprise_detail
-- ----------------------------
INSERT INTO `enterprise_detail` VALUES (1, '南京浦荣装饰工程有限公司', '刘成材', '13027039997', '刘成材', '13027039997', '中国建设银行', '123445698', '', '室内外装修装饰工程、房屋建筑工程、管道安装工程、防腐保温工程、园林绿化工程、计算机网络工程、钢结构工程、幕墙工程、古园林建筑工程、市政公用工程设计、施工；空调设备销售、安装及售后服务；金属防盗门窗安装；五金电器、电子产品、建筑材料、仪器仪表、计算机、建筑材料、装饰材料销售；提供劳务服务（不含涉外）。（依法须经批准的项目，经相关部门批准后方可开展经营活动）', '91320111771281998N', 'https://gimg2.baidu.com/image_search/src=https%3A%2F%2Fp8.itc.cn%2Fimages01%2F20210831%2Fcde09a9ce07e412c88024cb2d51b8a10.png&refer=http%3A%2F%2Fp8.itc.cn&app=2002&size=f10000,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1681136652&t=d77395e249f31db08944cffcf2851f00', 'https://www.tianyancha.com/company/2350270375', '2023-03-11 15:32:18', '2023-03-11 22:28:21');
INSERT INTO `enterprise_detail` VALUES (4, '合肥三只狼电子商务有限公司', '于天奇', '有限责任公司（非自然人投资或控股的法人独资）', '于天奇', '13027039597', '中国农业银行', 'MA8Q04BL-8', '', '一般项目：互联网销售（除销售需要许可的商品）；技术服务、技术开发、技术咨询、技术交流、技术转让、技术推广；信息技术咨询服务；', '91340100MA8Q04BL8Q', 'https://gimg2.baidu.com/image_search/src=https%3A%2F%2Fp8.itc.cn%2Fimages01%2F20210831%2Fcde09a9ce07e412c88024cb2d51b8a10.png&refer=http%3A%2F%2Fp8.itc.cn&app=2002&size=f10000,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1681136652&t=d77395e249f31db08944cffcf2851f00', 'https://www.tianyancha.com/company/5907821443', '2023-02-08 00:00:00', '2023-03-11 22:32:49');

-- ----------------------------
-- Table structure for fund_project
-- ----------------------------
DROP TABLE IF EXISTS `fund_project`;
CREATE TABLE `fund_project`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `project_fund_status` int(2) NULL DEFAULT 0 COMMENT '项目状态',
  `project_publish_id` int(32) NOT NULL COMMENT '所属项目公告',
  `project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名称',
  `report_time` datetime(0) NOT NULL COMMENT '申报时间',
  `project_body` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目主体',
  `project_build_properties` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目建设性质',
  `project_build_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '项目建设主体',
  `project_build_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目建设地点',
  `project_start_date` datetime(0) NOT NULL COMMENT '项目开工时间',
  `project_end_date` datetime(0) NOT NULL COMMENT '项目竣工时间',
  `create_user` int(32) NOT NULL COMMENT '创建者',
  `department_id` int(32) NOT NULL COMMENT '项目主管部门',
  `section_id` int(32) NOT NULL COMMENT '主管科室',
  `sustain_id` int(32) NOT NULL COMMENT '支持方式',
  `project_level` int(2) NOT NULL COMMENT '项目级别',
  `project_approval` int(2) NOT NULL COMMENT '是否立项',
  `record_put` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备案',
  `project_eia` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '环评',
  `project_gmp` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '能评',
  `project_land` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '土地',
  `project_plan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规划',
  `project_other` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其他',
  `project_appendix` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资金类项目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fund_project
-- ----------------------------
INSERT INTO `fund_project` VALUES (1, 0, 1, '某某某公司大数据建设', '2022-12-30 16:00:00', '某某某子公司', '\r\n\r\n建设大数据中心平台网络改造及采集终端。开发管理系统、企业生产过程执行管理系统、信息化服务平台系统、电子商务公共服务平台系统等各类管理、生产、销售软件10套，购置设备1000台。\r\n建设大数据中心平台网络改造及采集终端。', '', '某某省某某市某某区', '2023-01-02 16:00:00', '2023-03-24 16:00:00', 1, 1, 1, 1, 1, 1, '2023318220400000024', '', '', '', '', '', 'http://cssmobanobs.obs.cn-east-3.myhuaweicloud.com/d_res/20229558.docx', '2023-03-25 19:03:14');
INSERT INTO `fund_project` VALUES (3, 0, 2, '项目', '2023-02-01 00:00:00', '项目主题', 'XXXX项目建设性质', 'XXXX项目主要建设内容', '北京市南城区150号', '2023-03-15 00:00:00', '2023-08-15 00:00:00', 1, 1, 2, 1, 2, 0, '', '', '', '', '', '', '', '2023-03-25 20:53:58');

-- ----------------------------
-- Table structure for fund_project_detail
-- ----------------------------
DROP TABLE IF EXISTS `fund_project_detail`;
CREATE TABLE `fund_project_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `project_fund_id` int(32) NOT NULL COMMENT '资金类项目id',
  `project_fund_quota` decimal(16, 2) NOT NULL COMMENT '拟申请资金额度',
  `project_total_investment` decimal(16, 2) NOT NULL COMMENT '项目总投资',
  `project_center_investment` decimal(16, 2) NOT NULL COMMENT '中央预算内投资',
  `project_part_investment` decimal(16, 2) NOT NULL COMMENT '地方预算内投资',
  `bank_credit` decimal(16, 2) NULL DEFAULT NULL COMMENT '银行贷款',
  `enterprise_self_finance` decimal(16, 2) NULL DEFAULT NULL COMMENT '企业自筹',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资金类项目详细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fund_project_detail
-- ----------------------------
INSERT INTO `fund_project_detail` VALUES (1, 1, 0.00, 1000.00, 900.00, 0.00, 1200.00, 1100.00, '2023-03-25 19:03:14');
INSERT INTO `fund_project_detail` VALUES (2, 3, 10000.00, 10000.00, 500.00, 500.00, 0.00, 9000.00, '2023-03-25 20:53:58');

-- ----------------------------
-- Table structure for honour_project
-- ----------------------------
DROP TABLE IF EXISTS `honour_project`;
CREATE TABLE `honour_project`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `project_publish_id` int(32) NOT NULL COMMENT '项目公告',
  `project_status` int(2) NULL DEFAULT 0 COMMENT '项目状态',
  `honour_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '荣誉名称',
  `project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名称',
  `project_body` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目主体',
  `report_time` datetime(0) NOT NULL COMMENT '申报时间',
  `report_condition` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '申报条件',
  `department_id` int(32) NOT NULL COMMENT '项目主管部门',
  `project_level` int(2) NOT NULL COMMENT '项目级别',
  `section_id` int(32) NOT NULL COMMENT '主管科室',
  `project_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `project_appendix` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '项目附件',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '荣誉类项目' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of honour_project
-- ----------------------------
INSERT INTO `honour_project` VALUES (1, 1, 0, '某某某荣誉', '某某某项目', '某某某公司', '2023-03-24 16:00:00', '条件1,条件2,条件3', 1, 1, 1, '', '', '2023-03-26 15:45:44');
INSERT INTO `honour_project` VALUES (2, 1, 0, '***荣誉', '***项目', '***公司', '2023-01-01 00:00:00', '条件1,条件2', 1, 2, 1, '', '', '2023-03-26 17:15:28');

-- ----------------------------
-- Table structure for operate_log_detail
-- ----------------------------
DROP TABLE IF EXISTS `operate_log_detail`;
CREATE TABLE `operate_log_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(32) NOT NULL COMMENT '操作者id',
  `operate_function` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作功能',
  `ip_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'IP地址',
  `operate_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作日志记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operate_log_detail
-- ----------------------------
INSERT INTO `operate_log_detail` VALUES (1, 1, '新增角色', '192.168.1.108', '新增角色', '2023-03-08 21:06:24');
INSERT INTO `operate_log_detail` VALUES (2, 1, '修改角色', '192.168.1.108', '修改角色', '2023-03-08 21:07:28');
INSERT INTO `operate_log_detail` VALUES (3, 1, '修改角色', '192.168.1.108', '修改角色', '2023-03-08 21:08:01');
INSERT INTO `operate_log_detail` VALUES (4, 1, '修改角色', '192.168.1.108', '修改角色', '2023-03-08 21:08:51');
INSERT INTO `operate_log_detail` VALUES (5, 1, '删除角色', '192.168.1.108', '删除角色', '2023-03-08 21:09:11');
INSERT INTO `operate_log_detail` VALUES (6, 1, '新增企业', '192.168.1.108', '张三在新增企业', '2023-03-11 22:28:21');
INSERT INTO `operate_log_detail` VALUES (7, 1, '新增企业', '192.168.1.108', '张三在新增企业', '2023-03-11 22:30:29');
INSERT INTO `operate_log_detail` VALUES (8, 1, '新增企业', '192.168.1.108', '张三在新增企业', '2023-03-11 22:32:01');
INSERT INTO `operate_log_detail` VALUES (9, 1, '新增企业', '192.168.1.108', '张三在新增企业', '2023-03-11 22:32:49');
INSERT INTO `operate_log_detail` VALUES (10, 1, '修改角色', '192.168.1.108', '张三在修改角色', '2023-03-11 22:36:01');
INSERT INTO `operate_log_detail` VALUES (11, 1, '新增', '192.168.1.108', '张三在新增', '2023-03-12 14:53:11');
INSERT INTO `operate_log_detail` VALUES (12, 1, '新增', '192.168.1.108', '张三在新增', '2023-03-12 14:53:55');
INSERT INTO `operate_log_detail` VALUES (13, 1, '修改', '192.168.1.108', '张三在修改', '2023-03-12 14:54:51');
INSERT INTO `operate_log_detail` VALUES (14, 1, '新增', '192.168.1.108', '张三在新增', '2023-03-12 14:55:02');
INSERT INTO `operate_log_detail` VALUES (15, 1, '新增', '192.168.1.108', '张三在新增', '2023-03-12 14:55:48');
INSERT INTO `operate_log_detail` VALUES (16, 1, '删除', '192.168.1.108', '张三在删除', '2023-03-12 14:56:14');
INSERT INTO `operate_log_detail` VALUES (17, 2, '新增', '192.168.1.108', '李四12123在新增', '2023-03-12 14:56:51');
INSERT INTO `operate_log_detail` VALUES (18, 1, '新增', '192.168.1.108', '张三在新增', '2023-03-12 15:00:56');
INSERT INTO `operate_log_detail` VALUES (19, 1, '新增', '192.168.1.108', '张三在新增', '2023-03-12 15:01:03');
INSERT INTO `operate_log_detail` VALUES (20, 1, '新增', '192.168.1.108', '张三在新增', '2023-03-12 15:01:06');
INSERT INTO `operate_log_detail` VALUES (21, 1, '新增', '192.168.1.108', '张三在新增', '2023-03-12 15:01:12');
INSERT INTO `operate_log_detail` VALUES (22, 1, '修改', '192.168.1.108', '张三在修改', '2023-03-12 15:02:05');
INSERT INTO `operate_log_detail` VALUES (23, 1, '修改', '192.168.1.108', '张三在修改', '2023-03-12 15:02:16');
INSERT INTO `operate_log_detail` VALUES (24, 1, '删除', '192.168.1.108', '张三在删除', '2023-03-12 15:02:52');
INSERT INTO `operate_log_detail` VALUES (25, 1, '新增', '192.168.1.108', '张三在新增', '2023-03-12 15:03:50');
INSERT INTO `operate_log_detail` VALUES (26, 1, '新增', '192.168.1.108', '张三在新增', '2023-03-12 15:03:54');
INSERT INTO `operate_log_detail` VALUES (27, 1, '新增', '192.168.1.108', '张三在新增', '2023-03-12 15:03:59');
INSERT INTO `operate_log_detail` VALUES (28, 1, '新增', '192.168.1.108', '张三在新增', '2023-03-12 15:04:04');
INSERT INTO `operate_log_detail` VALUES (29, 1, '修改', '192.168.1.108', '张三在修改', '2023-03-12 15:04:32');
INSERT INTO `operate_log_detail` VALUES (30, 1, '修改', '192.168.1.108', '张三在修改', '2023-03-12 15:05:18');
INSERT INTO `operate_log_detail` VALUES (31, 1, '删除', '192.168.1.108', '张三在删除', '2023-03-12 15:05:26');
INSERT INTO `operate_log_detail` VALUES (32, 1, '新增', '192.168.1.108', '张三在新增', '2023-03-13 21:42:37');
INSERT INTO `operate_log_detail` VALUES (33, 1, '新增', '192.168.1.108', '张三在新增', '2023-03-13 21:48:56');
INSERT INTO `operate_log_detail` VALUES (34, 1, '修改', '192.168.1.108', '张三在修改', '2023-03-13 22:07:10');
INSERT INTO `operate_log_detail` VALUES (35, 1, '新增', '192.168.1.108', '张三在新增', '2023-03-25 20:51:57');
INSERT INTO `operate_log_detail` VALUES (36, 1, '新增', '192.168.1.108', '张三在新增', '2023-03-25 20:53:07');
INSERT INTO `operate_log_detail` VALUES (37, 1, '新增', '192.168.1.108', '张三在新增', '2023-03-25 20:53:58');
INSERT INTO `operate_log_detail` VALUES (38, 1, '修改', '192.168.1.108', '张三在修改', '2023-03-25 20:56:14');
INSERT INTO `operate_log_detail` VALUES (39, 1, '修改', '192.168.1.108', '张三在修改', '2023-03-25 20:56:35');
INSERT INTO `operate_log_detail` VALUES (40, 1, '修改', '192.168.1.108', '张三在修改', '2023-03-25 20:57:17');
INSERT INTO `operate_log_detail` VALUES (41, 1, '修改', '192.168.1.108', '张三在修改', '2023-03-25 20:57:48');
INSERT INTO `operate_log_detail` VALUES (42, 1, '新增', '192.168.1.108', '张三在新增', '2023-03-26 17:15:28');

-- ----------------------------
-- Table structure for project_publish
-- ----------------------------
DROP TABLE IF EXISTS `project_publish`;
CREATE TABLE `project_publish`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名称',
  `project_type` int(2) NOT NULL COMMENT '项目类型',
  `publish_date` datetime(0) NOT NULL COMMENT '发布日期',
  `project_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '项目描述',
  `project_appendix` varchar(555) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目附件',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目发布信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project_publish
-- ----------------------------
INSERT INTO `project_publish` VALUES (1, '关于举办创新创业大赛', 1, '2021-09-08 00:00:00', '1、发文单位：省商务厅', 'http://cssmobanobs.obs.cn-east-3.myhuaweicloud.com/d_res/20229558.docx', '2023-03-13 21:42:37');
INSERT INTO `project_publish` VALUES (2, '关于举办创新创业大赛', 2, '2021-09-08 00:00:00', '1、发文单位：省商务厅 2、文件名称：申报国家外贸基地 3、文件要求：见附件（项目管理信息系统内下载） 4、上报时间：请于10月10日下班前发送至战略发展部', 'http://cssmobanobs.obs.cn-east-3.myhuaweicloud.com/d_res/20229558.docx', '2023-03-13 21:48:57');

-- ----------------------------
-- Table structure for role_detail
-- ----------------------------
DROP TABLE IF EXISTS `role_detail`;
CREATE TABLE `role_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '角色描述',
  `authoritys` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '权限枚举集',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_detail
-- ----------------------------
INSERT INTO `role_detail` VALUES (1, '超级管理员', '这是超级管理员', 'SYSTEM_MANAGE,BASIC_MANAGE,OPERATE_LOG,ROLE_MANAGE,AUTHORITY_MANAGE,ENTERPRISE_MANAGE,ROLE_MANAGE_ADD,OPERATE_LOG_ADD,ENTERPRISE_MANAGE_ADD,ENTERPRISE_MANAGE_EDIT,ENTERPRISE_MANAGE_DEl,SECTION_MANAGE,SECTION_MANAGE_ADD,SECTION_MANAGE_EDIT,SECTION_MANAGE_DEL,DEPARTMENT_MANAGE,DEPARTMENT_MANAGE_ADD,DEPARTMENT_MANAGE_EDIT,DEPARTMENT_MANAGE_DEL,SUSTAIN_MANAGE,SUSTAIN_MANAGE_ADD,SUSTAIN_MANAGE_EDIT,SUSTAIN_MANAGE_DEL,ANNOUNCEMENT_MANAGE,PROJECT_PUBLISH', '2023-03-07 21:53:16');
INSERT INTO `role_detail` VALUES (2, '领导', '', 'SYSTEM_MANAGE', '2023-03-08 21:04:16');
INSERT INTO `role_detail` VALUES (4, '领导1231', '', 'SYSTEM_MANAGE', '2023-03-08 21:06:24');

-- ----------------------------
-- Table structure for science_project
-- ----------------------------
DROP TABLE IF EXISTS `science_project`;
CREATE TABLE `science_project`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `project_publish_id` int(32) NOT NULL COMMENT '项目公告',
  `project_status` int(2) NULL DEFAULT 0 COMMENT '项目状态',
  `project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名称',
  `project_course` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目所属学科',
  `project_specialized` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目所属专业',
  `budget_funds` decimal(16, 2) NULL DEFAULT NULL COMMENT '预算经费',
  `project_start_date` datetime(0) NULL DEFAULT NULL COMMENT '年限（起）',
  `project_end_date` datetime(0) NULL DEFAULT NULL COMMENT '年限（止）',
  `expected_results` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预期成果',
  `host_unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申报主持单位',
  `unit_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申报主持单位',
  `person_charge` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人姓名',
  `person_charge_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人电话',
  `person_charge_identity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `person_charge_work` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作单位',
  `create_user` int(32) NOT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '科技类项目' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for science_project_units
-- ----------------------------
DROP TABLE IF EXISTS `science_project_units`;
CREATE TABLE `science_project_units`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `science_id` int(32) NOT NULL COMMENT '所属科技类项目',
  `unit_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申报单位名称',
  `unit_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申报单位所在地',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '参加申报单位' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for section_detail
-- ----------------------------
DROP TABLE IF EXISTS `section_detail`;
CREATE TABLE `section_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `section_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '科室名称',
  `section_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '科室备注',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '科室信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of section_detail
-- ----------------------------
INSERT INTO `section_detail` VALUES (1, '科室一', '', '2023-03-12 14:53:11');
INSERT INTO `section_detail` VALUES (2, '科室二', '这是科室二', '2023-03-12 14:53:55');
INSERT INTO `section_detail` VALUES (3, '科室三', '', '2023-03-12 14:55:02');
INSERT INTO `section_detail` VALUES (5, '测试科室', '', '2023-03-12 14:56:51');

-- ----------------------------
-- Table structure for sustain_detail
-- ----------------------------
DROP TABLE IF EXISTS `sustain_detail`;
CREATE TABLE `sustain_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `sustain_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '科室名称',
  `sustain_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '科室备注',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '支持信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sustain_detail
-- ----------------------------
INSERT INTO `sustain_detail` VALUES (1, '支持方式一', '', '2023-03-12 15:03:50');
INSERT INTO `sustain_detail` VALUES (2, '支持方式二', '', '2023-03-12 15:03:54');
INSERT INTO `sustain_detail` VALUES (3, '支持方式三', '', '2023-03-12 15:04:00');

-- ----------------------------
-- Table structure for user_detail
-- ----------------------------
DROP TABLE IF EXISTS `user_detail`;
CREATE TABLE `user_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `user_account` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账户',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `user_password_salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码盐',
  `gender` int(2) NOT NULL COMMENT '性别',
  `user_company` int(32) NOT NULL COMMENT '所属公司',
  `user_role` int(32) NOT NULL COMMENT '所属角色',
  `user_state` int(2) NULL DEFAULT 0 COMMENT '账户状态(0:启用,1:禁用)',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_account`(`user_account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_detail
-- ----------------------------
INSERT INTO `user_detail` VALUES (1, '张三', '13010669997', 'a1be41372fdaaf64340e410cf1a08bad', 'QMonBI6O', 1, 1, 1, 0, '2023-03-05 17:42:48');
INSERT INTO `user_detail` VALUES (2, '李四12123', '13010669998', '3fb450649cbc83b3683ca3ae8e1af4ea', 'SS1CVnI5', 2, 1, 2, 0, '2023-03-07 21:48:33');

SET FOREIGN_KEY_CHECKS = 1;
