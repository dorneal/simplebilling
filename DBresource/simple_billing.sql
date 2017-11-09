/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50557
Source Host           : localhost:3306
Source Database       : simple_billing

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2017-11-09 14:44:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accounts
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `Record_id` int(11) NOT NULL AUTO_INCREMENT,
  `User_id` int(11) NOT NULL,
  `Record_name` varchar(10) NOT NULL,
  `Record_type` varchar(10) NOT NULL,
  `Record_mode` varchar(10) NOT NULL,
  `money` decimal(10,2) NOT NULL DEFAULT '0.00',
  `Record_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Record_remark` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`Record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accounts
-- ----------------------------
INSERT INTO `accounts` VALUES ('2', '1', '收入', '工资收入', '现金', '30000.00', '2017-11-04 20:09:07', '今日工资');
INSERT INTO `accounts` VALUES ('3', '1', '支出', '行车交通', '现金', '30.00', '2017-11-04 20:09:07', '打车了');
INSERT INTO `accounts` VALUES ('4', '1', '收入', '加班收入', '现金', '500.00', '2017-11-04 20:09:07', '加班补助');
INSERT INTO `accounts` VALUES ('5', '1', '收入', '投资收入', '支票', '2000000.00', '2017-11-04 20:09:07', '股票涨了，卖了');
INSERT INTO `accounts` VALUES ('6', '1', '支出', '交流通讯', '微信', '50.00', '2017-11-04 20:09:07', '充话费');
INSERT INTO `accounts` VALUES ('7', '1', '支出', '休闲娱乐', '刷卡', '2000.00', '2017-11-04 20:09:07', '丽江一日游');
INSERT INTO `accounts` VALUES ('8', '1', '收入', '奖金收入', '现金', '6000.00', '2017-11-04 20:09:07', '业绩第一奖金');
INSERT INTO `accounts` VALUES ('9', '1', '支出', '医疗保健', '现金', '600.00', '2017-11-04 20:09:07', '按了个摩');
INSERT INTO `accounts` VALUES ('10', '1', '支出', '食品酒水', '现金', '20.00', '2017-11-04 20:09:09', '吃饭');
INSERT INTO `accounts` VALUES ('11', '1', '收入', '工资收入', '现金', '30000.00', '2017-11-04 20:09:09', '今日工资');
INSERT INTO `accounts` VALUES ('12', '1', '支出', '行车交通', '现金', '30.00', '2017-11-04 20:09:09', '打车了');
INSERT INTO `accounts` VALUES ('13', '1', '收入', '加班收入', '现金', '500.00', '2017-11-04 20:09:09', '加班补助');
INSERT INTO `accounts` VALUES ('14', '1', '收入', '投资收入', '支票', '2000000.00', '2017-11-04 20:09:09', '股票涨了，卖了');
INSERT INTO `accounts` VALUES ('15', '1', '支出', '交流通讯', '微信', '50.00', '2017-11-04 20:09:09', '充话费');
INSERT INTO `accounts` VALUES ('16', '1', '支出', '休闲娱乐', '刷卡', '2000.00', '2017-11-04 20:09:09', '丽江一日游');
INSERT INTO `accounts` VALUES ('17', '1', '收入', '奖金收入', '现金', '6000.00', '2017-11-04 20:09:09', '业绩第一奖金');
INSERT INTO `accounts` VALUES ('18', '1', '支出', '医疗保健', '现金', '600.00', '2017-11-04 20:09:09', '按了个摩');
INSERT INTO `accounts` VALUES ('19', '1', '支出', '食品酒水', '现金', '20.00', '2017-11-04 20:09:10', '吃饭');
INSERT INTO `accounts` VALUES ('20', '1', '收入', '工资收入', '现金', '30000.00', '2017-11-04 20:09:10', '今日工资');
INSERT INTO `accounts` VALUES ('21', '1', '支出', '行车交通', '现金', '30.00', '2017-11-04 20:09:10', '打车了');
INSERT INTO `accounts` VALUES ('22', '1', '收入', '加班收入', '现金', '500.00', '2017-11-04 20:09:10', '加班补助');
INSERT INTO `accounts` VALUES ('23', '1', '收入', '投资收入', '支票', '2000000.00', '2017-11-04 20:09:10', '股票涨了，卖了');
INSERT INTO `accounts` VALUES ('24', '1', '支出', '交流通讯', '微信', '50.00', '2017-11-04 20:09:10', '充话费');
INSERT INTO `accounts` VALUES ('25', '1', '支出', '休闲娱乐', '刷卡', '2000.00', '2017-11-04 20:09:10', '丽江一日游');
INSERT INTO `accounts` VALUES ('26', '1', '收入', '奖金收入', '现金', '6000.00', '2017-11-04 20:09:10', '业绩第一奖金');
INSERT INTO `accounts` VALUES ('27', '1', '支出', '医疗保健', '现金', '600.00', '2017-11-04 20:09:10', '按了个摩');
INSERT INTO `accounts` VALUES ('32', '1', '支出', '食品酒水', '现金', '300.00', '2017-11-04 21:15:00', '日常');
INSERT INTO `accounts` VALUES ('33', '1', '支出', '食品酒水', '现金', '80.00', '2017-11-04 21:17:00', '水果');
INSERT INTO `accounts` VALUES ('34', '1', '支出', '学习进修', '现金', '654.00', '2017-11-04 21:19:00', '考试费');
INSERT INTO `accounts` VALUES ('35', '1', '支出', '食品酒水', '现金', '500.00', '2017-11-04 21:22:00', '朋友聚会');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `User_id` int(11) NOT NULL AUTO_INCREMENT,
  `User_name` varchar(20) NOT NULL,
  `User_password` char(6) NOT NULL,
  `User_sex` char(1) NOT NULL DEFAULT '男',
  `User_phoneNum` varchar(11) NOT NULL,
  `User_signature` varchar(50) NOT NULL DEFAULT '',
  `User_email` varchar(50) NOT NULL,
  `Register_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`User_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'neal', '123456', '男', '13037479765', '我懂得越多，懂我的人越少。', '1061479678@qq.com', '2017-11-06 17:46:31');
INSERT INTO `users` VALUES ('2', 'rose', '775825', '女', '13635363439', '我就是我，不一样的烟火', '2656798470@qq.com', '2017-11-09 11:11:57');
