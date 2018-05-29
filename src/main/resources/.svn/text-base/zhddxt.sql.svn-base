/*
Navicat MySQL Data Transfer

Source Server         : zzm
Source Server Version : 50522
Source Host           : 127.0.0.1:3306
Source Database       : zhddxt

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2018-05-11 11:03:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dis_feedback
-- ----------------------------
DROP TABLE IF EXISTS `dis_feedback`;
CREATE TABLE `dis_feedback` (
  `fb_id` varchar(32) NOT NULL,
  `r_id` varchar(32) DEFAULT NULL,
  `info_id` varchar(32) DEFAULT NULL,
  `fb_person` varchar(24) DEFAULT NULL,
  `fb_tel` varchar(24) DEFAULT NULL,
  `fb_date` datetime DEFAULT NULL,
  `fb_details` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fb_id`),
  KEY `FK_Reference_2` (`r_id`),
  KEY `FK_Reference_5` (`info_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`info_id`) REFERENCES `res_information` (`res_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`r_id`) REFERENCES `dis_report` (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dis_feedback
-- ----------------------------

-- ----------------------------
-- Table structure for dis_renewal
-- ----------------------------
DROP TABLE IF EXISTS `dis_renewal`;
CREATE TABLE `dis_renewal` (
  `rs_id` varchar(32) NOT NULL,
  `r_id` varchar(32) DEFAULT NULL,
  `rs_person` varchar(24) DEFAULT NULL,
  `rs_tel` varchar(24) DEFAULT NULL,
  `rs_grade` varchar(24) DEFAULT NULL,
  `rs_area` varchar(24) DEFAULT NULL,
  `rs_date` datetime DEFAULT NULL,
  `rs_desc` varchar(255) DEFAULT NULL,
  `rs_casualties` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`rs_id`),
  KEY `FK_Reference_3` (`r_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`r_id`) REFERENCES `dis_report` (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dis_renewal
-- ----------------------------

-- ----------------------------
-- Table structure for dis_report
-- ----------------------------
DROP TABLE IF EXISTS `dis_report`;
CREATE TABLE `dis_report` (
  `r_id` varchar(32) NOT NULL,
  `r_code` varchar(32) DEFAULT NULL,
  `plan_id` varchar(32) DEFAULT NULL,
  `r_name` varchar(24) DEFAULT NULL,
  `r_region` varchar(24) DEFAULT NULL,
  `r_address` varchar(100) DEFAULT NULL,
  `r_grade` varchar(24) DEFAULT NULL,
  `r_type` varchar(24) DEFAULT NULL,
  `r_date` datetime DEFAULT NULL,
  `r_reporter` varchar(24) DEFAULT NULL,
  `r_report_tel` varchar(24) DEFAULT NULL,
  `r_initial_loss` varchar(24) DEFAULT NULL,
  `r_final_loss` varchar(24) DEFAULT NULL,
  `r_initial_casualties` varchar(24) DEFAULT NULL,
  `r_final_casualties` varchar(24) DEFAULT NULL,
  `r_area` varchar(24) DEFAULT NULL,
  `r_image` varchar(100) DEFAULT NULL,
  `r_desc` varchar(255) DEFAULT NULL,
  `r_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`r_id`),
  KEY `FK_Reference_4` (`plan_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`plan_id`) REFERENCES `eme_planning` (`plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dis_report
-- ----------------------------

-- ----------------------------
-- Table structure for dis_scheduling
-- ----------------------------
DROP TABLE IF EXISTS `dis_scheduling`;
CREATE TABLE `dis_scheduling` (
  `sch_id` varchar(32) NOT NULL,
  `r_id` varchar(32) DEFAULT NULL,
  `info_id` varchar(32) DEFAULT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `sch_car` int(11) DEFAULT NULL,
  `sch_person` int(11) DEFAULT NULL,
  `sch_date` datetime DEFAULT NULL,
  `sch_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`sch_id`),
  KEY `FK_Reference_1` (`r_id`),
  KEY `FK_Reference_11` (`user_id`),
  KEY `FK_Reference_6` (`info_id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`info_id`) REFERENCES `res_information` (`res_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`r_id`) REFERENCES `dis_report` (`r_id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dis_scheduling
-- ----------------------------

-- ----------------------------
-- Table structure for eme_planning
-- ----------------------------
DROP TABLE IF EXISTS `eme_planning`;
CREATE TABLE `eme_planning` (
  `plan_id` varchar(32) NOT NULL,
  `plan_name` varchar(24) DEFAULT NULL,
  `plan_type` varchar(24) DEFAULT NULL,
  `plan_grade` varchar(24) DEFAULT NULL,
  `plan_describe` varchar(255) DEFAULT NULL,
  `plan_people_num` int(11) DEFAULT NULL,
  `plan_car_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eme_planning
-- ----------------------------

-- ----------------------------
-- Table structure for his_report
-- ----------------------------
DROP TABLE IF EXISTS `his_report`;
CREATE TABLE `his_report` (
  `rh_id` varchar(32) NOT NULL,
  `rh_code` varchar(32) DEFAULT NULL,
  `plan_name` varchar(32) DEFAULT NULL,
  `rh_name` varchar(24) DEFAULT NULL,
  `rh_region` varchar(24) DEFAULT NULL,
  `rh_address` varchar(100) DEFAULT NULL,
  `rh_grade` varchar(24) DEFAULT NULL,
  `rh_type` varchar(24) DEFAULT NULL,
  `rh_start_date` datetime DEFAULT NULL,
  `rh_end_date` datetime DEFAULT NULL,
  `r_reporter` varchar(24) DEFAULT NULL,
  `r_report_tel` varchar(24) DEFAULT NULL,
  `r_initial_loss` varchar(24) DEFAULT NULL,
  `r_final_loss` varchar(24) DEFAULT NULL,
  `r_initial_casualties` varchar(24) DEFAULT NULL,
  `r_final_casualties` varchar(24) DEFAULT NULL,
  `r_area` varchar(24) DEFAULT NULL,
  `r_image` varchar(100) DEFAULT NULL,
  `r_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rh_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of his_report
-- ----------------------------

-- ----------------------------
-- Table structure for res_information
-- ----------------------------
DROP TABLE IF EXISTS `res_information`;
CREATE TABLE `res_information` (
  `res_id` varchar(32) NOT NULL,
  `res_name` varchar(24) DEFAULT NULL,
  `res_type` varchar(24) DEFAULT NULL,
  `res_region` varchar(24) DEFAULT NULL,
  `res_person` varchar(24) DEFAULT NULL,
  `res_tel` varchar(24) DEFAULT NULL,
  `res_code` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`res_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of res_information
-- ----------------------------

-- ----------------------------
-- Table structure for sys_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_data`;
CREATE TABLE `sys_data` (
  `data_id` varchar(32) NOT NULL,
  `data_type` varchar(24) DEFAULT NULL,
  `data_key` varchar(24) DEFAULT NULL,
  `data_value` varchar(24) DEFAULT NULL,
  `data_desc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`data_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_data
-- ----------------------------
INSERT INTO `sys_data` VALUES ('1', '武侯区', 'WHQ', 'QY', '武侯区');
INSERT INTO `sys_data` VALUES ('10', '双流区', 'SLQ', 'QY', '双流区');
INSERT INTO `sys_data` VALUES ('11', '郫都区', 'PDQ', 'QY', '郫都区');
INSERT INTO `sys_data` VALUES ('12', '金堂县', 'JTX', 'QY', '金堂县');
INSERT INTO `sys_data` VALUES ('13', '新津县', 'XJX', 'QY', '新津县');
INSERT INTO `sys_data` VALUES ('14', '大邑县', 'DYX', 'QY', '大邑县');
INSERT INTO `sys_data` VALUES ('15', '蒲江县', 'PJX', 'QY', '蒲江县');
INSERT INTO `sys_data` VALUES ('16', '都江堰市', 'DJYS', 'QY', '都江堰市');
INSERT INTO `sys_data` VALUES ('17', '邛崃市', 'QLS', 'QY', '邛崃市');
INSERT INTO `sys_data` VALUES ('18', '崇明市', 'CMS', 'QY', '崇明市');
INSERT INTO `sys_data` VALUES ('19', '简阳市', 'JYS', 'QY', '简阳市');
INSERT INTO `sys_data` VALUES ('2', '青羊区', 'QYQ', 'QY', '青羊区');
INSERT INTO `sys_data` VALUES ('20', '高新区', 'GXQ', 'QY', '高新区');
INSERT INTO `sys_data` VALUES ('21', '天府新区', 'TFXQ', 'QY', '天府新区');
INSERT INTO `sys_data` VALUES ('22', '消防车', 'XFC', 'CLLX', '消防车');
INSERT INTO `sys_data` VALUES ('23', '救护车', 'JHC', 'CLLX', '救护车');
INSERT INTO `sys_data` VALUES ('24', '小客车', 'XKC', 'CLLX', '小客车');
INSERT INTO `sys_data` VALUES ('25', '铲车', 'CC', 'CLLX', '铲车');
INSERT INTO `sys_data` VALUES ('26', '吊车', 'DC', 'CLLX', '吊车');
INSERT INTO `sys_data` VALUES ('27', '警车', 'JC', 'CLLX', '警车');
INSERT INTO `sys_data` VALUES ('28', '摩托车', 'MTC', 'CLLX', '摩托车');
INSERT INTO `sys_data` VALUES ('29', '拖车', 'TC', 'CLLX', '拖车');
INSERT INTO `sys_data` VALUES ('3', '成华区', 'CHQ', 'QY', '成华区');
INSERT INTO `sys_data` VALUES ('30', '已出发', '1', 'XXLX', '已出发');
INSERT INTO `sys_data` VALUES ('31', '需反馈', '2', 'XXLX', '需反馈');
INSERT INTO `sys_data` VALUES ('32', '已归队', '3', 'XXLX', '已归队');
INSERT INTO `sys_data` VALUES ('33', '消防部门', 'XFBM', 'JGLX', '消防部门');
INSERT INTO `sys_data` VALUES ('34', '医院', 'YY', 'JGLX', '医院');
INSERT INTO `sys_data` VALUES ('35', '交警大队', 'JJDD', 'JGLX', '交警大队');
INSERT INTO `sys_data` VALUES ('36', '打人', 'DR', 'RWLX', '打人');
INSERT INTO `sys_data` VALUES ('37', '破坏公物', 'PHGW', 'RWLX', '破坏公物');
INSERT INTO `sys_data` VALUES ('38', '抢劫', 'QJ', 'RWLX', '抢劫');
INSERT INTO `sys_data` VALUES ('39', '着火', 'ZH', 'RWLX', '着火');
INSERT INTO `sys_data` VALUES ('4', '锦江区', 'JJQ', 'QY', '锦江区');
INSERT INTO `sys_data` VALUES ('40', '偷', 'T', 'RWLX', '偷');
INSERT INTO `sys_data` VALUES ('402880e9634ce0ff01634ce101e10000', 'DQ', 'CD', '成都', '');
INSERT INTO `sys_data` VALUES ('402880e9634ce2bb01634ce2bd9b0000', 'DQ', 'CD', '武汉', '');
INSERT INTO `sys_data` VALUES ('41', '救援', 'JY', 'RWLX', '救援');
INSERT INTO `sys_data` VALUES ('42', '一级', '1', 'RWDJ', '一级');
INSERT INTO `sys_data` VALUES ('43', '二级', '2', 'RWDJ', '二级');
INSERT INTO `sys_data` VALUES ('44', '三级', '3', 'RWDJ', '三级');
INSERT INTO `sys_data` VALUES ('45', '四级', '4', 'RWDJ', '四级');
INSERT INTO `sys_data` VALUES ('5', '金牛区', 'JNQ', 'QY', '金牛区');
INSERT INTO `sys_data` VALUES ('6', '龙泉驿区', 'LQYQ', 'QY', '龙泉驿区');
INSERT INTO `sys_data` VALUES ('7', '青白江区', 'QBJQ', 'QY', '青白江区');
INSERT INTO `sys_data` VALUES ('8', '新都区', 'XDQ', 'QY', '新都区');
INSERT INTO `sys_data` VALUES ('9', '温江区', 'WJQ', 'QY', '温江区');

-- ----------------------------
-- Table structure for sys_power
-- ----------------------------
DROP TABLE IF EXISTS `sys_power`;
CREATE TABLE `sys_power` (
  `power_id` varchar(32) NOT NULL,
  `power_name` varchar(100) DEFAULT NULL,
  `power_desc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`power_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_power
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` varchar(32) NOT NULL,
  `role_name` varchar(32) DEFAULT NULL,
  `role_desc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_power
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_power`;
CREATE TABLE `sys_role_power` (
  `rp_id` varchar(32) NOT NULL,
  `role_id` varchar(32) DEFAULT NULL,
  `power_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`rp_id`),
  KEY `FK_Reference_10` (`role_id`),
  KEY `FK_Reference_12` (`power_id`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`power_id`) REFERENCES `sys_power` (`power_id`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_power
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` varchar(32) NOT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `user_password` varchar(32) DEFAULT NULL,
  `user_rname` varchar(32) DEFAULT NULL,
  `user_gender` varchar(10) DEFAULT NULL,
  `user_birth` date DEFAULT NULL,
  `user_tel` varchar(15) DEFAULT NULL,
  `user_address` varchar(100) DEFAULT NULL,
  `user_email` varchar(50) DEFAULT NULL,
  `user_date` datetime DEFAULT NULL,
  `user_status` int(11) DEFAULT NULL,
  `user_pic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `ur_id` varchar(32) NOT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `role_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ur_id`),
  KEY `FK_Reference_8` (`user_id`),
  KEY `FK_Reference_9` (`role_id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
