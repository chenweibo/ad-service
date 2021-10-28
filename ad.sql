/*
 Navicat Premium Data Transfer

 Source Server         : my
 Source Server Type    : MySQL
 Source Server Version : 100420
 Source Host           : localhost:3306
 Source Schema         : ad

 Target Server Type    : MySQL
 Target Server Version : 100420
 File Encoding         : 65001

 Date: 28/10/2021 16:54:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `login_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `status` int(1) NULL DEFAULT 1 COMMENT '帐号启用状态：0->禁用；1->启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '62786084', '$2a$10$rQWNW3GUlIEZtnfYzU53O.rVhl7dpBtfXaCF9l5sdgUPpfzE5pOnq', NULL, NULL, NULL, NULL, '2020-07-10 13:50:48', NULL, 1);

-- ----------------------------
-- Table structure for merchant
-- ----------------------------
DROP TABLE IF EXISTS `merchant`;
CREATE TABLE `merchant`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `icon` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `login_time` timestamp(0) NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL,
  `invite` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `momey` decimal(10, 2) NOT NULL DEFAULT 0,
  `is_back` int(5) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of merchant
-- ----------------------------
INSERT INTO `merchant` VALUES (1, '13968782968', '$2a$10$SRgLATjNvw3z3KiOWGVycuMlkOMJUHQt1fiM7QBojC7xhlcYtVjXy', NULL, NULL, NULL, '2021-10-15 16:18:13', NULL, 1, '123', 2.10, 1);

-- ----------------------------
-- Table structure for merchant_momey_log
-- ----------------------------
DROP TABLE IF EXISTS `merchant_momey_log`;
CREATE TABLE `merchant_momey_log`  (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `merchant_id` int(20) NULL DEFAULT NULL,
  `pay` decimal(10, 2) NULL DEFAULT NULL,
  `current_momey` decimal(10, 2) NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `plus_minus` int(2) NULL DEFAULT NULL COMMENT '0为减1为加',
  `note` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `shop_id` int(50) NULL DEFAULT NULL,
  `order_id` int(50) NULL DEFAULT NULL,
  `task_id` int(50) NULL DEFAULT NULL,
  `shop_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of merchant_momey_log
-- ----------------------------
INSERT INTO `merchant_momey_log` VALUES (1, 1, 200.00, 200.00, NULL, 1, '充值200元', NULL, NULL, NULL, '五金');

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop`  (
  `id` bigint(50) NOT NULL AUTO_INCREMENT,
  `shop_type` int(255) NULL DEFAULT NULL,
  `taobao_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `taobao_leader` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `shop_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `is_check` int(2) NULL DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `shop_telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `created_time` timestamp(0) NULL DEFAULT NULL,
  `merchant_id` int(50) NULL DEFAULT NULL,
  `updated_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2147483652 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES (2147483651, 1, '13zzz', '1', 'http://127.0.0.1:9000/yangmao/merchant/54ae093321ac47f3956a62716dfc1549/二维码图片_10月11日15时40分09秒.png', 1, NULL, '13968782968', '2021-10-19 10:07:38', 1, '2021-10-19 10:18:34');

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `shop_id` int(11) NULL DEFAULT NULL,
  `shop_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `task_type` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `back_type` int(10) NULL DEFAULT NULL,
  `task_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `product_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `product_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `product_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `count` int(10) NULL DEFAULT NULL,
  `start_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `end_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `run_type` int(5) NULL DEFAULT NULL,
  `is_tbk` int(5) NULL DEFAULT NULL,
  `extra` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `task_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `created_time` timestamp(0) NULL DEFAULT NULL,
  `updated_time` datetime(0) NULL DEFAULT NULL,
  `status` int(5) NULL DEFAULT NULL,
  `version` int(5) NULL DEFAULT NULL,
  `total` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '邮箱',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '密码',
  `telephone` int(15) NULL DEFAULT NULL COMMENT '电话号码',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` int(1) NULL DEFAULT NULL COMMENT '帐号启用状态：0->禁用；1->启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '123456', '', '$2a$10$8phGvWZFMCHlzi4N4ygSseAOwinYPsq0o1Ot5/rqj9mpOKbaygDeS', NULL, '2020-07-11 14:37:27', 1);

-- ----------------------------
-- Table structure for users_platform
-- ----------------------------
DROP TABLE IF EXISTS `users_platform`;
CREATE TABLE `users_platform`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `users_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `platform_id` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '平台id',
  `platform_token` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '平台access_token',
  `type` int(5) NULL DEFAULT NULL COMMENT '平台类型 0:未知,1:facebook,2:google,3:wechat,4:qq,5:weibo,6:twitter',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '第三方登录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users_platform
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
