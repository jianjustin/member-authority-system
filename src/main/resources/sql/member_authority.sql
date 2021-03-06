/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50168
 Source Host           : localhost:3306
 Source Schema         : member

 Target Server Type    : MySQL
 Target Server Version : 50168
 File Encoding         : 65001

 Date: 12/05/2018 22:01:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for member_authority
-- ----------------------------
DROP TABLE IF EXISTS `member_authority`;
CREATE TABLE `member_authority`  (
  `PK_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `MEMBER_AUTHORITY_CODE` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限对照编号',
  `MEMBER_AUTHORITY_ROLE_CODE` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编号',
  `MEMBER_AUTHORITY_RESOURCE_CODE` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源编号',
  `MEMBER_AUTHORITY_CREATE_DATE` datetime NULL DEFAULT NULL COMMENT '记录创建时间',
  `MEMBER_AUTHORITY_ORDER_BY` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '记录排序号',
  PRIMARY KEY (`PK_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
