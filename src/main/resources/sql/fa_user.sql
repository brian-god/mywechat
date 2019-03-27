/*
 Navicat Premium Data Transfer

 Source Server         : 本地MySQL
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : my_admin

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 25/03/2019 16:03:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fa_user
-- ----------------------------
DROP TABLE IF EXISTS `fa_user`;
CREATE TABLE `fa_user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '昵称',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '密码',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '电子邮箱',
  `mobile` varchar(22) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '头像',
  `gender` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '性别',
  `birthday` varchar(19) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '生日',
  `jointime` varchar(19) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '加入时间',
  `createtime` varchar(19) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '创建时间',
  `updatetime` varchar(19) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '更新时间',
  `status` int(1) NOT NULL DEFAULT 0 COMMENT '状态',
  `dr` int(1) NOT NULL DEFAULT 0 COMMENT '逻辑标志：0可用，1表示删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE,
  INDEX `email`(`email`) USING BTREE,
  INDEX `mobile`(`mobile`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fa_user
-- ----------------------------
INSERT INTO `fa_user` VALUES (1, 'username', 'code', '123', 'tangxkwork@163.com', '13165766090', '', 0, '2019-01-07', '2019-01-07 16:15:57', '2019-01-07 16:15:57', '2019-01-07 16:15:57', 0, 0);
INSERT INTO `fa_user` VALUES (56, 'tangxk', '唐晓康', '123', 'tangxkwork@aliyun.com', '13681630454', '', 1, '2019-02-19', '2019-02-15 16:20:13', '2019-02-15 16:20:13', '', 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
