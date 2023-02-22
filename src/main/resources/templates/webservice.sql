/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : webservice

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 22/02/2023 08:20:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for wallet
-- ----------------------------
DROP TABLE IF EXISTS `wallet`;
CREATE TABLE `wallet`  (
  `id` bigint(0) NOT NULL COMMENT '主键',
  `user_id` bigint(0) NULL DEFAULT NULL COMMENT '用户id',
  `money` decimal(20, 2) NULL DEFAULT NULL COMMENT '钱',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `creater` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id_key`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '钱包表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wallet_detail
-- ----------------------------
DROP TABLE IF EXISTS `wallet_detail`;
CREATE TABLE `wallet_detail`  (
  `id` bigint(0) NOT NULL COMMENT '主键',
  `user_id` bigint(0) NULL DEFAULT NULL COMMENT '用户id',
  `wallet_id` bigint(0) NULL DEFAULT NULL COMMENT '钱包id',
  `type` tinyint(1) NULL DEFAULT NULL COMMENT '变动类型',
  `money` decimal(20, 2) NULL DEFAULT NULL COMMENT '变动金额',
  `old_money` decimal(20, 2) NULL DEFAULT NULL COMMENT '变动前金额',
  `new_money` decimal(20, 2) NULL DEFAULT NULL COMMENT '变动后金额',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `creater` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id_key`(`user_id`) USING BTREE,
  INDEX `wallet_id_key`(`wallet_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '钱包明细' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
