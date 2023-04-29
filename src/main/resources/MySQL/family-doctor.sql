/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : family-doctor

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 29/04/2023 13:51:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for carousel_detail
-- ----------------------------
DROP TABLE IF EXISTS `carousel_detail`;
CREATE TABLE `carousel_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `banner_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片',
  `banner_name` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'banner图名称',
  `banner_status` int(2) NULL DEFAULT 0 COMMENT '状态',
  `banner_link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接',
  `create_user` int(32) NOT NULL COMMENT '创建者',
  `sort_number` int(16) NOT NULL COMMENT '排序号',
  `release_time` datetime(0) NOT NULL COMMENT '文章发布时间',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '轮播图信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carousel_detail
-- ----------------------------
INSERT INTO `carousel_detail` VALUES (1, 'https://pic.ntimg.cn/BannerPic/20220228/original/20220228104453_1.jpg', '春暖花开', 0, 'https://www.baidu.com/', 2, 10, '2022-03-06 00:00:00', '2022-03-06 14:54:57');
INSERT INTO `carousel_detail` VALUES (2, 'https://pic.ntimg.cn/BannerPic/20220228/original/20220228104525_1.jpg', '相约樱花节', 0, 'https://www.baidu.com/', 2, 50, '2022-03-06 00:00:00', '2022-03-06 14:56:18');
INSERT INTO `carousel_detail` VALUES (3, 'https://pic.ntimg.cn/BannerPic/20220228/original/20220228104632_1.jpg', '女王嫁到', 1, 'https://www.baidu.com/', 2, 80, '2022-03-06 00:00:00', '2022-03-06 14:56:51');

-- ----------------------------
-- Table structure for doctor_services_detail
-- ----------------------------
DROP TABLE IF EXISTS `doctor_services_detail`;
CREATE TABLE `doctor_services_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `service_name` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务名称',
  `service_no` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务编号',
  `service_number` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务次数',
  `service_type` int(2) NOT NULL COMMENT '服务类型',
  `service_price` decimal(16, 2) NOT NULL COMMENT '服务价格',
  `service_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '服务介绍',
  `create_user` int(32) NOT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `service_no`(`service_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '服务项目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doctor_services_detail
-- ----------------------------
INSERT INTO `doctor_services_detail` VALUES (1, '高血压随访服务', '30177459', '2次', 1, 0.00, '1.血压测量及记录 2.根据结果提供综合性健康指导', 1, '2022-03-01 20:42:11');
INSERT INTO `doctor_services_detail` VALUES (2, '心脏病随访服务', '30510162', '', 2, 985.26, '', 1, '2022-03-01 20:43:09');
INSERT INTO `doctor_services_detail` VALUES (3, '测试服务', '30621148', '0', 1, 0.00, '1231231231', 1, '2022-03-01 20:44:19');
INSERT INTO `doctor_services_detail` VALUES (4, '测试服务', '30963123', '0', 1, 1025.36, '1231231231', 1, '2022-03-01 20:45:14');

-- ----------------------------
-- Table structure for doctors_detail
-- ----------------------------
DROP TABLE IF EXISTS `doctors_detail`;
CREATE TABLE `doctors_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `doctor_no` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '医生编号',
  `doctor_account` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `doctor_account_status` int(2) NULL DEFAULT 1 COMMENT '账号状态',
  `doctor_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `doctor_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '医生姓名',
  `doctor_role` int(32) NOT NULL COMMENT '角色',
  `doctor_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录密码',
  `doctor_gender` int(2) NULL DEFAULT 1 COMMENT '性别',
  `doctor_introduce` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '医生介绍',
  `doctor_skilful` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '医生擅长',
  `doctor_contract_count` int(55) NULL DEFAULT 0 COMMENT '签约人数',
  `doctor_evaluate_persons` int(55) NULL DEFAULT 0 COMMENT '评价人数',
  `doctor_evaluate_fraction` int(55) NULL DEFAULT 0 COMMENT '评价分数',
  `create_user` int(32) NOT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `doctor_no`(`doctor_no`) USING BTREE,
  UNIQUE INDEX `doctor_account`(`doctor_account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '医生信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doctors_detail
-- ----------------------------
INSERT INTO `doctors_detail` VALUES (1, '2019090009', '13210002000', 1, 'https://bkimg.cdn.bcebos.com/pic/21a4462309f790529822d8e976bac0ca7bcb0b467f98?x-bce-process=image/resize,m_lfit,w_536,limit_1/format,f_jpg', '张峰', 1, '$2a$10$TnHwqOUoL77S/oUoFYTAkO7BTNjlI.64H/Xy7csIzrjj2SjiOadXK', 1, '张峰，主任医师，博士生导师，中国医师协会心血管病分会青年委员会副主任委员，中华心血管病学会腔内影像和生理学组全国委员。', '冠心病、高血压、高血脂、心律失常、心功能不全等心血管疾病的诊治。', 0, 0, 0, 1, '2022-02-20 17:05:33');
INSERT INTO `doctors_detail` VALUES (2, '10867934', '188641368888', 0, 'http://www.srsrmyy.cn/uploads/oldfiles/allimg/151011/1-151011134236457.jpg', '詹凌峰', 2, '$2a$10$OmyvTlcfzOwX6KUecfzeXOEdjIAT70WCqUAs4278UChPuPkWKQ.xa', 1, '詹凌峰，男， 1968年毕业于江西医学院医疗第，主任医师，江西医学院兼职教授，中华医学会江西分会、儿科专业委员会委员，历任上饶市人民医院儿科主任、副院长。1979年－1980年在江西省儿童医院进修儿内科一年，1983年－1984年在上海瑞金医院进修儿内科一年。', '从事儿科临床医疗、科研、教学工作30余年，精通儿科专业的基础理论和专业知识，掌握儿科在国内外的发展现状和发展趋势。具有丰富的临床工作经验和实践能力，能够解决儿科疑难杂症。尤其擅长呼吸、消化、神经及肾脏、泌尿系统疾病', 0, 0, 0, 1, '2022-03-01 20:35:24');
INSERT INTO `doctors_detail` VALUES (4, '10568591', '13616591465', 1, 'http://www.cdyfy.com/upload_new/images/2022/2/15162116313.jpg', '朱萱', 2, '$2a$10$XS5ETqVYRxra0ycL2QpQ3ux4Mx1zKo3u6oxIQdduZvaDEssrc03cm', 1, '擅长脂肪肝、肝硬化、不明原因的慢性肝病、自身免疫性肝病、功能性胃肠病等消化系统疾病的诊治及胃肠镜诊断技术。', '', 0, 0, 0, 2, '2022-03-05 16:44:35');

-- ----------------------------
-- Table structure for doctors_teams
-- ----------------------------
DROP TABLE IF EXISTS `doctors_teams`;
CREATE TABLE `doctors_teams`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `team_id` int(32) NOT NULL COMMENT '团队',
  `doctor_id` int(32) NOT NULL COMMENT '医生',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '医生团队关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doctors_teams
-- ----------------------------
INSERT INTO `doctors_teams` VALUES (1, 1, 1, '2022-03-01 19:10:07');
INSERT INTO `doctors_teams` VALUES (2, 1, 2, '2022-04-04 13:39:53');

-- ----------------------------
-- Table structure for information_detail
-- ----------------------------
DROP TABLE IF EXISTS `information_detail`;
CREATE TABLE `information_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `information_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章标题',
  `information_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章图片',
  `information_type` int(2) NOT NULL COMMENT '文章类型',
  `information_status` int(2) NULL DEFAULT 1 COMMENT '文章发布状态',
  `information_text` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章内容',
  `information_release_time` datetime(0) NOT NULL COMMENT '文章发布时间',
  `sort_number` int(16) NOT NULL COMMENT '排序号',
  `collection_number` int(16) NOT NULL DEFAULT 0 COMMENT '收藏量',
  `share_number` int(16) NOT NULL DEFAULT 0 COMMENT '分享量',
  `create_user` int(32) NOT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资讯信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of information_detail
-- ----------------------------
INSERT INTO `information_detail` VALUES (1, '吞下一根鱼刺，到底能带来多大伤害？', 'https://img1.dxycdn.com/2022/0131/447/9885198750048969253-22.png!w720', 1, 1, '过年防鱼刺卡喉小贴士1. 不吃鱼了（不是）鱼类是优质蛋白质来源，是重要的膳食组成部分，中外膳食指南都强调了吃鱼的重要性。', '2021-12-15 00:00:00', 100, 0, 0, 2, '2022-03-05 20:56:16');
INSERT INTO `information_detail` VALUES (2, '珍珠粉，能不能美白祛痘呢？', 'https://img1.dxycdn.com/2022/0207/617/6927033807532590353-22.jpeg!w720', 2, 1, '一提珍珠粉，总觉得是美颜秘方，不少朋友还认为它可以美白祛痘，不过今天，直接告诉你一个大实话：珍珠粉不能美白，也不能去痘。', '2022-01-24 00:00:00', 98, 0, 0, 2, '2022-03-05 20:59:57');

-- ----------------------------
-- Table structure for lable_detail
-- ----------------------------
DROP TABLE IF EXISTS `lable_detail`;
CREATE TABLE `lable_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `lable_no` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签编号',
  `lable_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名称',
  `create_user` int(32) NOT NULL COMMENT '创建者',
  `lable_status` int(2) NULL DEFAULT 0 COMMENT '标签状态,',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `lable_no`(`lable_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '标签信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lable_detail
-- ----------------------------
INSERT INTO `lable_detail` VALUES (1, '606058', '高血压', 2, 0, '2022-03-05 17:05:20', '2022-03-05 17:05:20');
INSERT INTO `lable_detail` VALUES (2, '601699', '心脏病', 2, 0, '2022-03-05 17:05:47', '2022-03-05 17:05:47');
INSERT INTO `lable_detail` VALUES (3, '609585', '冠心病', 2, 0, '2022-03-05 17:05:55', '2022-03-05 17:05:55');
INSERT INTO `lable_detail` VALUES (4, '607714', '高血糖', 2, 0, '2022-03-05 17:09:01', '2022-03-05 17:09:01');

-- ----------------------------
-- Table structure for organizations_detail
-- ----------------------------
DROP TABLE IF EXISTS `organizations_detail`;
CREATE TABLE `organizations_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `organization_no` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机构编号',
  `organization_name` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机构名称',
  `organization_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构图片',
  `organization_status` int(2) NULL DEFAULT 1 COMMENT '机构状态',
  `organization_contact` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机构联系人',
  `organization_contact_phone` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机构联系电话',
  `organization_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机构地址',
  `organization_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '机构介绍',
  `create_user` int(32) NOT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `organization_no`(`organization_no`) USING BTREE,
  UNIQUE INDEX `organization_name`(`organization_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '机构信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of organizations_detail
-- ----------------------------
INSERT INTO `organizations_detail` VALUES (1, '20180681', '上饶市人民医院', 'https://pimg.39.net/PictureLib/A/f4/c3/20181214/org/7441583.jpg', 1, '张伟', '0793-8100429', '江西省上饶市信州区书院路86号', '西省上饶市人民医院是全市唯一的一所集医疗、教学、科研、急救、预防、保健工作为一体的综合性医院，是上饶市医保、农保定点医疗机构，也是全市的继续医学教育基地，2006年被省卫生厅评为省级“群众满意医院”,2010年被省卫生厅评为三级甲级综合性医院。', 1, '2022-02-21 20:23:35');
INSERT INTO `organizations_detail` VALUES (2, '20614032', '北京市怀柔区洛西社区卫生服务站', 'https://t7.baidu.com/it/u=4227319888,919256531&fm=74&app=80&f=JPEG&size=f121,121?sec=1880279984&t=ff1ddf96f91b06f2500a78dc3d4025a1', 1, '李小明', '188641368888', '北京市怀柔区洛西县建设路990号', '', 1, '2022-02-21 20:24:11');

-- ----------------------------
-- Table structure for permission_detial
-- ----------------------------
DROP TABLE IF EXISTS `permission_detial`;
CREATE TABLE `permission_detial`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `permission_sign` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限签名',
  `permission_name` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称',
  `permission_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限描述',
  `create_user` int(32) NOT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `permission_sign`(`permission_sign`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission_detial
-- ----------------------------
INSERT INTO `permission_detial` VALUES (1, 'DOCTOR_ADD', '新增医生', NULL, 1, '2022-02-20 17:19:13');
INSERT INTO `permission_detial` VALUES (2, 'DOCTOR_SEARCH', '搜索医生', NULL, 1, '2022-02-20 17:20:22');
INSERT INTO `permission_detial` VALUES (3, 'DOCTOR_MODIFY', '修改医生', NULL, 1, '2022-02-20 17:20:43');
INSERT INTO `permission_detial` VALUES (4, 'DOCTOR_DELETE', '删除医生', NULL, 1, '2022-02-20 17:20:56');

-- ----------------------------
-- Table structure for role_detail
-- ----------------------------
DROP TABLE IF EXISTS `role_detail`;
CREATE TABLE `role_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_code` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色代码',
  `role_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `create_user` int(32) NOT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `role_code`(`role_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_detail
-- ----------------------------
INSERT INTO `role_detail` VALUES (1, 'SYSTEM_ADMIN', '系统管理员', '这是超级管理员', 1, '2022-02-20 17:18:12');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` int(32) NOT NULL COMMENT '角色id',
  `permission_id` int(32) NOT NULL COMMENT '权限id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1, 1, 1, '2022-02-20 17:21:07');
INSERT INTO `role_permission` VALUES (2, 2, 2, '2022-02-20 17:21:10');
INSERT INTO `role_permission` VALUES (3, 2, 3, '2022-02-20 17:21:13');
INSERT INTO `role_permission` VALUES (4, 2, 4, '2022-02-20 17:21:16');
INSERT INTO `role_permission` VALUES (5, 2, 1, '2022-02-20 17:28:37');

-- ----------------------------
-- Table structure for service_package_detail
-- ----------------------------
DROP TABLE IF EXISTS `service_package_detail`;
CREATE TABLE `service_package_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `service_package_name` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务包名称',
  `service_package_type` int(2) NOT NULL COMMENT '服务包类型',
  `service_package_price` decimal(16, 2) NOT NULL COMMENT '签约 价格',
  `service_package_persons` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务人群',
  `service_package_labels` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务包标签',
  `service_package_cycle` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务包周期',
  `service_package_renewal` int(2) NOT NULL COMMENT '续约',
  `service_package_status` int(2) NOT NULL COMMENT '服务包状态',
  `service_package_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务包图片',
  `service_package_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务包简介',
  `service_package_services` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务项目',
  `create_user` int(32) NOT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '服务包表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of service_package_detail
-- ----------------------------
INSERT INTO `service_package_detail` VALUES (1, '老人服务包', 1, 1025.10, '55岁以上的老人', '1,2,3', '1年', 1, 0, 'http://mms0.baidu.com/it/u=777157867,2503757273&fm=253&app=138&f=JPEG&fmt=auto&q=75?w=500&h=386', '主要以基本医疗服务和公共卫生服务为主，如部分常见病或 多发病的治疗和用药指导、重症的就医指导和转诊预约、居民健康档案的管理和 慢病管理指导等。', '1,2,3', 1, '2022-02-26 21:04:11');
INSERT INTO `service_package_detail` VALUES (2, '老人服务包', 1, 120.00, '55岁以上的老人', '1,2,3', '1年', 1, 0, 'http://mms0.baidu.com/it/u=777157867,2503757273&fm=253&app=138&f=JPEG&fmt=auto&q=75?w=500&h=386', '主要以基本医疗服务和公共卫生服务为主，如部分常见病或 多发病的治疗和用药指导、重症的就医指导和转诊预约、居民健康档案的管理和 慢病管理指导等。', '1,2,3', 1, '2022-03-01 20:57:34');
INSERT INTO `service_package_detail` VALUES (3, '儿童服务包', 2, 320.00, '0-6岁的儿童', '1,2', '2年', 0, 0, 'http://mms2.baidu.com/it/u=398775109,3449695804&fm=253&app=138&f=JPEG&fmt=auto&q=75?w=500&h=500', '', '1,2,3', 1, '2022-03-01 20:59:36');

-- ----------------------------
-- Table structure for service_package_field_detail
-- ----------------------------
DROP TABLE IF EXISTS `service_package_field_detail`;
CREATE TABLE `service_package_field_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `service_package_id` int(32) NOT NULL COMMENT '服务包id',
  `service_package_field_text` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '提示文本',
  `service_package_field_default_value` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '默认值',
  `service_package_field_unit` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单位',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '服务字段详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of service_package_field_detail
-- ----------------------------
INSERT INTO `service_package_field_detail` VALUES (1, 1, '舒张压', '120', 'mmHg', '2022-02-26 21:04:34');
INSERT INTO `service_package_field_detail` VALUES (2, 2, '舒张压', '120', 'mmHg', '2022-03-01 12:57:34');
INSERT INTO `service_package_field_detail` VALUES (3, 3, '舒张压', '120', 'mmHg', '2022-03-01 12:59:36');

-- ----------------------------
-- Table structure for service_package_record
-- ----------------------------
DROP TABLE IF EXISTS `service_package_record`;
CREATE TABLE `service_package_record`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `service_package_id` int(32) NOT NULL COMMENT '服务包id',
  `service_package_status` int(2) NOT NULL COMMENT '服务包状态',
  `create_user` int(32) NOT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '服务包审核记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of service_package_record
-- ----------------------------
INSERT INTO `service_package_record` VALUES (1, 1, 0, 1, '2022-02-26 21:04:11');
INSERT INTO `service_package_record` VALUES (2, 2, 0, 1, '2022-03-01 20:57:34');
INSERT INTO `service_package_record` VALUES (3, 3, 0, 1, '2022-03-01 20:59:36');

-- ----------------------------
-- Table structure for smbms_user
-- ----------------------------
DROP TABLE IF EXISTS `smbms_user`;
CREATE TABLE `smbms_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_code` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户编码',
  `user_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户名称',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户密码',
  `gender` int(10) NULL DEFAULT NULL COMMENT '性别（1:女、 2:男）',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '手机',
  `address` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  `user_role` bigint(20) NULL DEFAULT NULL COMMENT '用户角色（取自角色表-角色id）',
  `createdBy` bigint(20) NULL DEFAULT 1 COMMENT '创建者（userId）',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_code`(`user_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of smbms_user
-- ----------------------------
INSERT INTO `smbms_user` VALUES (16, '1001975', '张三', '$2a$10$azNjAqgj.uHhWgmvGWIN3OEgwtASKcKpANLFzideFAcgr8NUyiurm', 1, '2022-02-19', '13510002000', '江西省上饶市信州区人民大道10号', 1, 1, '2022-02-19 05:41:15', '2022-02-19 05:41:15');

-- ----------------------------
-- Table structure for system_agreement
-- ----------------------------
DROP TABLE IF EXISTS `system_agreement`;
CREATE TABLE `system_agreement`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `agreement_title` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '协议标题',
  `agreement_text` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '协议内容',
  `create_user` int(32) NOT NULL COMMENT '创建者',
  `update_user` int(32) NOT NULL COMMENT '最后一次修改用户',
  `update_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '协议管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_agreement
-- ----------------------------
INSERT INTO `system_agreement` VALUES (1, '2022-03-06 16:41:07', '用户隐私端协议', '《哔哩哔哩弹幕网用户使用协议》（以下简称“本协议”）是您与哔哩哔哩之间关于使用哔哩哔哩各项服务的法律协议。“哔哩哔哩”是指哔哩哔哩弹幕网的运营公司上海宽娱数码科技有限公司及其关联公司。本协议中与您的权益（可能）存在重大关系的条款（包括免除哔哩哔哩责任的条款、限制您权利的条款、争议解决条款及司法管辖条款等），哔哩哔哩已采用字体加粗的方式来特别提醒您，请您留意重点查阅。请您确保您在使用哔哩哔哩服务前已仔细阅读、充分理解并毫无保留地接受本协议所有条款。', 1, 2, '2022-03-06 08:48:33');
INSERT INTO `system_agreement` VALUES (2, '2022-03-06 16:43:04', '医生端隐私协议', '《哔哩哔哩弹幕网用户使用协议》（以下简称“本协议”）是您与哔哩哔哩之间关于使用哔哩哔哩各项服务的法律协议。“哔哩哔哩”是指哔哩哔哩弹幕网的运营公司上海宽娱数码科技有限公司及其关联公司。本协议中与您的权益（可能）存在重大关系的条款（包括免除哔哩哔哩责任的条款、限制您权利的条款、争议解决条款及司法管辖条款等），哔哩哔哩已采用字体加粗的方式来特别提醒您，请您留意重点查阅。请您确保您在使用哔哩哔哩服务前已仔细阅读、充分理解并毫无保留地接受本协议所有条款。', 1, 2, '2022-03-06 08:48:24');
INSERT INTO `system_agreement` VALUES (3, '2022-03-06 16:43:42', '签约协议', '腾讯严格遵守法律法规，遵循以下隐私保护原则，为您提供更加安全、可靠的服务：', 1, 1, '2022-03-06 16:43:42');

-- ----------------------------
-- Table structure for system_announcement
-- ----------------------------
DROP TABLE IF EXISTS `system_announcement`;
CREATE TABLE `system_announcement`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `announcement_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告标题',
  `announcement_text` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告内容',
  `announcement_status` int(2) NULL DEFAULT 0 COMMENT '状态',
  `create_user` int(32) NOT NULL COMMENT '创建者',
  `announcement_user` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告接受人',
  `release_time` datetime(0) NOT NULL COMMENT '发布时间',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统公告' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_announcement
-- ----------------------------
INSERT INTO `system_announcement` VALUES (1, '大航海升级公告', 'https://i0.hdslb.com/bfs/live/9999df1156bbbc3c2ac9485d31b3ac910ad23b94.png', 0, 2, '1,2,3', '2022-02-06 00:00:00', '2022-03-06 16:13:00');
INSERT INTO `system_announcement` VALUES (2, '手游『春日』扶持计划 资源开放申请！123', '时间：即日起至3月31日 分区：二次元手游+综合手游 要求：所有非素人主播', 1, 2, '1,2,3', '2022-01-16 00:00:00', '2022-03-06 16:18:45');

-- ----------------------------
-- Table structure for system_user_log
-- ----------------------------
DROP TABLE IF EXISTS `system_user_log`;
CREATE TABLE `system_user_log`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(32) NOT NULL COMMENT '操作人',
  `user_ip` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ip',
  `operation_model` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作模块',
  `operation_desc` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作详情',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户行为日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_user_log
-- ----------------------------
INSERT INTO `system_user_log` VALUES (1, 2, '192.168.0.111', '医生管理控制器', '获取医生信息', '2022-03-05 16:41:02');
INSERT INTO `system_user_log` VALUES (2, 2, '192.168.0.111', '医生管理控制器', '新增医生', '2022-03-05 16:44:35');
INSERT INTO `system_user_log` VALUES (3, 2, '192.168.0.111', '医生管理控制器', '医生列表', '2022-03-05 16:44:48');
INSERT INTO `system_user_log` VALUES (4, 2, '192.168.0.111', '标签管理', '新增标签', '2022-03-05 17:05:20');
INSERT INTO `system_user_log` VALUES (5, 2, '192.168.0.111', '标签管理', '新增标签', '2022-03-05 17:05:47');
INSERT INTO `system_user_log` VALUES (6, 2, '192.168.0.111', '标签管理', '新增标签', '2022-03-05 17:05:55');
INSERT INTO `system_user_log` VALUES (7, 2, '192.168.0.111', '标签管理', '新增标签', '2022-03-05 17:09:01');
INSERT INTO `system_user_log` VALUES (8, 2, '192.168.0.111', '标签管理', '新增标签', '2022-03-05 17:09:05');
INSERT INTO `system_user_log` VALUES (9, 2, '192.168.0.111', '标签管理', '修改标签', '2022-03-05 17:09:51');
INSERT INTO `system_user_log` VALUES (10, 2, '192.168.0.111', '标签管理', '修改标签', '2022-03-05 17:10:16');
INSERT INTO `system_user_log` VALUES (11, 2, '192.168.0.111', '标签管理', '修改标签', '2022-03-05 17:11:34');
INSERT INTO `system_user_log` VALUES (12, 2, '192.168.0.111', '标签管理', '删除标签', '2022-03-05 17:12:31');
INSERT INTO `system_user_log` VALUES (13, 2, '192.168.0.111', '', '新增资讯', '2022-03-05 20:51:25');
INSERT INTO `system_user_log` VALUES (14, 2, '192.168.0.111', '', '新增资讯', '2022-03-05 20:52:46');
INSERT INTO `system_user_log` VALUES (15, 2, '192.168.0.111', '', '新增资讯', '2022-03-05 20:53:30');
INSERT INTO `system_user_log` VALUES (16, 2, '192.168.0.111', '', '新增资讯', '2022-03-05 20:56:16');
INSERT INTO `system_user_log` VALUES (17, 2, '192.168.0.111', '', '新增资讯', '2022-03-05 20:59:57');
INSERT INTO `system_user_log` VALUES (18, 2, '192.168.0.111', '', '新增资讯', '2022-03-05 21:02:22');
INSERT INTO `system_user_log` VALUES (19, 2, '192.168.0.111', '', '修改资讯', '2022-03-05 21:03:00');
INSERT INTO `system_user_log` VALUES (20, 2, '192.168.0.111', '', '删除资讯', '2022-03-05 21:03:19');
INSERT INTO `system_user_log` VALUES (21, 2, '192.168.0.111', '', '新增资讯', '2022-03-06 14:54:33');
INSERT INTO `system_user_log` VALUES (22, 2, '192.168.0.111', '', '新增轮播图', '2022-03-06 14:54:56');
INSERT INTO `system_user_log` VALUES (23, 2, '192.168.0.111', '', '新增轮播图', '2022-03-06 14:56:18');
INSERT INTO `system_user_log` VALUES (24, 2, '192.168.0.111', '', '新增轮播图', '2022-03-06 14:56:51');
INSERT INTO `system_user_log` VALUES (25, 2, '192.168.0.111', '', '新增轮播图', '2022-03-06 14:59:09');
INSERT INTO `system_user_log` VALUES (26, 2, '192.168.0.111', '', '修改轮播图', '2022-03-06 15:00:07');
INSERT INTO `system_user_log` VALUES (27, 2, '192.168.0.111', '', '删除资讯', '2022-03-06 15:00:35');
INSERT INTO `system_user_log` VALUES (28, 2, '192.168.0.111', '', '删除轮播图', '2022-03-06 15:00:49');
INSERT INTO `system_user_log` VALUES (29, 2, '192.168.0.111', '', '新增系统公告', '2022-03-06 16:13:00');
INSERT INTO `system_user_log` VALUES (30, 2, '192.168.0.111', '', '新增系统公告', '2022-03-06 16:18:45');
INSERT INTO `system_user_log` VALUES (31, 2, '192.168.0.111', '', '修改系统公告', '2022-03-06 16:19:23');
INSERT INTO `system_user_log` VALUES (32, 2, '192.168.0.111', '', '修改系统公告', '2022-03-06 16:19:34');
INSERT INTO `system_user_log` VALUES (33, 2, '192.168.0.111', '', '修改系统公告', '2022-03-06 16:19:53');
INSERT INTO `system_user_log` VALUES (34, 2, '192.168.0.111', '', '修改协议', '2022-03-06 16:48:23');
INSERT INTO `system_user_log` VALUES (35, 2, '192.168.0.111', '', '修改协议', '2022-03-06 16:48:32');
INSERT INTO `system_user_log` VALUES (36, 2, '192.168.14.1', '', '根据身份证号获取信息', '2022-03-19 17:07:07');
INSERT INTO `system_user_log` VALUES (37, 2, '192.168.14.1', '', '添加用户', '2022-03-19 18:41:43');
INSERT INTO `system_user_log` VALUES (38, 2, '192.168.14.1', '', '添加用户', '2022-03-19 18:42:00');
INSERT INTO `system_user_log` VALUES (39, 2, '192.168.14.1', '', '添加用户', '2022-03-19 18:42:53');
INSERT INTO `system_user_log` VALUES (40, 2, '192.168.14.1', '', '添加用户', '2022-03-19 18:43:56');
INSERT INTO `system_user_log` VALUES (41, 2, '192.168.14.1', '', '添加用户', '2022-03-19 18:49:23');
INSERT INTO `system_user_log` VALUES (42, 2, '192.168.14.1', '', '添加用户', '2022-03-19 18:50:11');
INSERT INTO `system_user_log` VALUES (43, 2, '192.168.14.1', '', '添加用户', '2022-03-19 18:52:32');
INSERT INTO `system_user_log` VALUES (44, 2, '192.168.14.1', '', '添加用户', '2022-03-19 21:13:38');
INSERT INTO `system_user_log` VALUES (45, 2, '192.168.14.1', '', '添加用户详情', '2022-03-19 21:37:56');
INSERT INTO `system_user_log` VALUES (46, 2, '192.168.14.1', '', '添加用户详情', '2022-03-19 21:38:31');
INSERT INTO `system_user_log` VALUES (47, 2, '192.168.14.1', '', '添加用户详情', '2022-03-19 21:39:00');
INSERT INTO `system_user_log` VALUES (48, 2, '192.168.14.1', '', '添加用户', '2022-03-20 13:03:30');
INSERT INTO `system_user_log` VALUES (49, 2, '192.168.14.1', '', '添加用户详情', '2022-03-20 13:03:49');
INSERT INTO `system_user_log` VALUES (50, 2, '192.168.14.1', '健康记录', '新增健康信息', '2022-03-26 21:22:47');
INSERT INTO `system_user_log` VALUES (51, 2, '192.168.14.1', '健康记录', '修改健康信息', '2022-03-26 21:25:36');
INSERT INTO `system_user_log` VALUES (52, 2, '192.168.14.1', '健康记录', '修改健康信息', '2022-03-26 21:26:25');
INSERT INTO `system_user_log` VALUES (53, 2, '192.168.14.1', '健康记录', '修改健康信息', '2022-03-26 21:27:29');
INSERT INTO `system_user_log` VALUES (54, 2, '192.168.14.1', '健康记录', '修改健康信息', '2022-03-26 21:28:13');
INSERT INTO `system_user_log` VALUES (55, 2, '192.168.14.1', '健康记录', '修改健康信息', '2022-03-26 21:28:36');
INSERT INTO `system_user_log` VALUES (56, 2, '192.168.14.1', '健康记录', '修改健康信息', '2022-03-26 21:30:13');
INSERT INTO `system_user_log` VALUES (57, 2, '192.168.14.1', '健康记录', '修改健康信息', '2022-03-26 21:30:52');
INSERT INTO `system_user_log` VALUES (58, 2, '10.0.183.159', '', '添加用户', '2022-03-27 18:01:49');

-- ----------------------------
-- Table structure for team_join_record
-- ----------------------------
DROP TABLE IF EXISTS `team_join_record`;
CREATE TABLE `team_join_record`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `team_id` int(32) NOT NULL COMMENT '医生',
  `doctor_id` int(32) NOT NULL COMMENT '医生',
  `status` int(2) NOT NULL COMMENT '申请状态',
  `create_user` int(32) NOT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '团队申请记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teams_detail
-- ----------------------------
DROP TABLE IF EXISTS `teams_detail`;
CREATE TABLE `teams_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `organizations_id` int(32) NOT NULL COMMENT '所属机构',
  `team_no` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '团队编号',
  `team_name` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '团队名称',
  `team_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '团队头像',
  `team_labels` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '团队标签',
  `service_package` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务包',
  `team_status` int(2) NULL DEFAULT 1 COMMENT '团队状态',
  `team_leader` int(32) NOT NULL COMMENT '团队长',
  `create_user` int(32) NOT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '团队表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teams_detail
-- ----------------------------
INSERT INTO `teams_detail` VALUES (1, 1, '3', '张峰团队1', '1025.36', '', '1,2,3', 1, 1, 2, '2022-03-01 21:12:22');

-- ----------------------------
-- Table structure for user_contract_information
-- ----------------------------
DROP TABLE IF EXISTS `user_contract_information`;
CREATE TABLE `user_contract_information`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `contract_no` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '签约编号',
  `user_id` int(32) NOT NULL COMMENT '用户id',
  `organizations_id` int(32) NOT NULL COMMENT '签约机构',
  `team_id` int(32) NOT NULL COMMENT '签约团队',
  `doctor_id` int(32) NOT NULL COMMENT '签约医生',
  `services_package_id` int(32) NOT NULL COMMENT '服务包',
  `service_package_cycle` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务周期',
  `contract_price` decimal(10, 2) NOT NULL COMMENT '签约价格',
  `contract_status` int(2) NULL DEFAULT 0 COMMENT '签约状态',
  `contract_type` int(2) NULL DEFAULT 0 COMMENT '签约类型',
  `effective_date` datetime(0) NOT NULL COMMENT '生效日期',
  `contract_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `contract_no`(`contract_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户签约表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_contract_record
-- ----------------------------
DROP TABLE IF EXISTS `user_contract_record`;
CREATE TABLE `user_contract_record`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(32) NOT NULL COMMENT '用户id',
  `contract_no` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '签约编号',
  `reviewer_user` int(32) NOT NULL COMMENT '审核人',
  `reviewer_result` int(32) NOT NULL COMMENT '审核结果',
  `reviewer_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '审核备注',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '服务审核表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_family
-- ----------------------------
DROP TABLE IF EXISTS `user_family`;
CREATE TABLE `user_family`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(32) NOT NULL COMMENT '用户Id',
  `user_family_id` int(32) NOT NULL COMMENT '家人id',
  `user_relationship` int(2) NOT NULL COMMENT '关系',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`, `user_family_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户家庭关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_family
-- ----------------------------
INSERT INTO `user_family` VALUES (1, 1, 2, 1, '2022-03-20 15:47:11');
INSERT INTO `user_family` VALUES (2, 2, 1, 1, '2022-03-20 15:47:14');

-- ----------------------------
-- Table structure for user_healthy_detail
-- ----------------------------
DROP TABLE IF EXISTS `user_healthy_detail`;
CREATE TABLE `user_healthy_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(32) NOT NULL COMMENT '用户Id',
  `user_height` int(2) NOT NULL COMMENT '身高',
  `user_weight` int(2) NOT NULL COMMENT '体重',
  `user_blood` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '血型',
  `user_rh` int(2) NOT NULL COMMENT 'RH阴性',
  `user_allergy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '过敏史',
  `user_visit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '就诊史',
  `user_past` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '过往史',
  `user_family_illness` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家族史',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_no`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户健康信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_healthy_detail
-- ----------------------------
INSERT INTO `user_healthy_detail` VALUES (1, 1, 170, 165, 'A', 0, '无', NULL, '无', '无', '2022-03-20 13:03:49');

-- ----------------------------
-- Table structure for user_healthy_record
-- ----------------------------
DROP TABLE IF EXISTS `user_healthy_record`;
CREATE TABLE `user_healthy_record`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(32) NOT NULL COMMENT '用户Id',
  `data_type` int(2) NOT NULL COMMENT '数据类型',
  `measure_date` datetime(0) NOT NULL COMMENT '测量时间',
  `numerical_value` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数值',
  `assessment` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评估',
  `data_source` int(2) NOT NULL COMMENT '数据来源',
  `create_user` int(32) NOT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户健康记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_healthy_record
-- ----------------------------
INSERT INTO `user_healthy_record` VALUES (1, 1, 1, '2022-03-19 00:00:00', '49.2', 'A', 1, 1, '2022-03-26 14:22:05');
INSERT INTO `user_healthy_record` VALUES (2, 1, 1, '2022-03-20 00:00:00', '50.2', 'B', 1, 1, '2022-03-26 14:24:12');
INSERT INTO `user_healthy_record` VALUES (3, 1, 1, '2022-03-21 00:00:00', '48.2', 'A', 1, 1, '2022-03-26 14:24:27');
INSERT INTO `user_healthy_record` VALUES (4, 1, 1, '2022-03-22 00:00:00', '47.2', 'B', 1, 1, '2022-03-26 14:24:46');
INSERT INTO `user_healthy_record` VALUES (5, 1, 1, '2022-03-18 00:00:00', '58.0', 'C', 1, 1, '2022-03-26 14:26:58');
INSERT INTO `user_healthy_record` VALUES (6, 1, 2, '2022-03-18 00:00:00', '4.2', 'A', 1, 1, '2022-03-26 14:27:30');
INSERT INTO `user_healthy_record` VALUES (7, 1, 2, '2022-03-19 00:00:00', '5.0', 'B', 1, 1, '2022-03-26 14:28:36');
INSERT INTO `user_healthy_record` VALUES (8, 1, 2, '2022-03-20 00:00:00', '4.5', 'A', 1, 1, '2022-03-26 14:28:50');
INSERT INTO `user_healthy_record` VALUES (9, 1, 2, '2022-03-21 00:00:00', '5.1', 'C', 1, 1, '2022-03-26 14:29:01');
INSERT INTO `user_healthy_record` VALUES (10, 1, 4, '2022-03-18 00:00:00', '80/120', 'A', 1, 1, '2022-03-26 14:29:22');
INSERT INTO `user_healthy_record` VALUES (11, 1, 4, '2022-03-19 00:00:00', '90/130', 'B', 1, 1, '2022-03-26 19:44:59');
INSERT INTO `user_healthy_record` VALUES (12, 1, 4, '2022-03-20 00:00:00', '80/120', 'A', 1, 2, '2022-03-26 21:22:47');

-- ----------------------------
-- Table structure for user_info_detail
-- ----------------------------
DROP TABLE IF EXISTS `user_info_detail`;
CREATE TABLE `user_info_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(32) NOT NULL COMMENT '用户Id',
  `user_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户头像',
  `user_residence` varchar(555) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户籍地址',
  `user_native_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '籍贯',
  `user_native_type` int(2) NULL DEFAULT NULL COMMENT '户籍类型',
  `user_nation` int(32) NOT NULL COMMENT '民族',
  `user_education` int(2) NOT NULL COMMENT '文化程度',
  `user_marital` int(2) NOT NULL COMMENT '婚姻状况',
  `user_occupation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业',
  `user_word_unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作单位',
  `user_emergency_contact` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '紧急联系人',
  `user_emergency_contact_phone` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '紧急联系人电话',
  `designated_hospitals` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '定点医疗单位',
  `user_pay` int(2) NOT NULL COMMENT '医疗类型',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info_detail
-- ----------------------------
INSERT INTO `user_info_detail` VALUES (1, 1, 'https://img0.baidu.com/it/u=2216119779,653055386&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500', '', '', NULL, 1, 1, 1, '', '', '', '', '', 1, '2022-03-20 13:03:49');

-- ----------------------------
-- Table structure for user_information
-- ----------------------------
DROP TABLE IF EXISTS `user_information`;
CREATE TABLE `user_information`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户姓名',
  `user_no` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户编号',
  `user_identity_card` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户身份证号',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `user_password_salt` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '加密盐',
  `user_gender` int(2) NOT NULL COMMENT '用户性别 0:女,1:男',
  `user_birthday` datetime(0) NOT NULL COMMENT '出生日期',
  `user_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户手机号',
  `user_status` int(2) NULL DEFAULT 0 COMMENT '用户状态',
  `user_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现居地',
  `user_lables` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '居民标签',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_identity_card`(`user_identity_card`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_information
-- ----------------------------
INSERT INTO `user_information` VALUES (1, '秦玉林', '10113012', '340203197902035430', '34512d870a57cdde3a37e5d348bb57c9', '4y8E3mqu', 0, '1979-02-03 00:00:00', '13105719980', 0, '安徽省芜湖市马塘区人民大道10号', '1,2,3', '2022-03-20 13:03:31');
INSERT INTO `user_information` VALUES (2, '黄向荣', '10116628', '230127198402161734', '6ee04661f3b568aff65a94ba51a03901', '2k4zAEJV', 1, '1984-02-16 00:00:00', '13105719981', 0, '安徽省芜湖市马塘区人民大道10号', '1,2', '2022-03-27 18:01:49');

SET FOREIGN_KEY_CHECKS = 1;
