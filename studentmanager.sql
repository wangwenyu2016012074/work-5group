/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : 127.0.0.1:3306
Source Database       : studentmanager

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2019-04-22 15:44:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `birDate` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '乔峰', '965', '男');
INSERT INTO `student` VALUES ('2', '杨逍', '1365', '男');
INSERT INTO `student` VALUES ('3', '果郡王', '1750', '男');
INSERT INTO `student` VALUES ('4', '完颜洪烈', '1260', '男');
INSERT INTO `student` VALUES ('5', '林启正', '1989', '男');
INSERT INTO `student` VALUES ('6', '段阿朱', '988', '女');
INSERT INTO `student` VALUES ('7', '纪晓芙', '1375', '女');
INSERT INTO `student` VALUES ('8', '任盈盈', '1468', '女');
INSERT INTO `student` VALUES ('9', '邹雨', '1983', '女');
INSERT INTO `student` VALUES ('10', '甄嬛', '1758', '女');
