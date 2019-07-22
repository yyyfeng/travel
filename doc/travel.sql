/*
MySQL Data Transfer
Source Host: 62.234.133.247
Source Database: travel
Target Host: 62.234.133.247
Target Database: travel
Date: 2018/12/26 16:36:51
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for g_appoint
-- ----------------------------
CREATE TABLE `g_appoint` (
  `appointId` int(11) NOT NULL AUTO_INCREMENT,
  `appointName` varchar(20) NOT NULL,
  `appointTel` varchar(20) NOT NULL,
  `appointDest` varchar(50) DEFAULT NULL,
  `appointDay` varchar(10) NOT NULL,
  `appointTime` date NOT NULL,
  `appointAdult` int(11) NOT NULL,
  `appointChild` int(11) DEFAULT NULL,
  `appointStatus` int(11) DEFAULT '0',
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`appointId`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for g_menu
-- ----------------------------
CREATE TABLE `g_menu` (
  `menuId` int(11) NOT NULL AUTO_INCREMENT,
  `menuDesc` varchar(40) DEFAULT NULL,
  `menuImg` varchar(5000) NOT NULL,
  PRIMARY KEY (`menuId`),
  UNIQUE KEY `menuDesc` (`menuDesc`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for g_order
-- ----------------------------
CREATE TABLE `g_order` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime NOT NULL,
  `startTime` date NOT NULL,
  `adultNum` int(11) NOT NULL,
  `childNum` int(11) DEFAULT NULL,
  `orderStatus` int(11) DEFAULT '0',
  `userId` int(11) NOT NULL,
  `tripId` int(11) NOT NULL,
  `orderCost` double DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for g_trip
-- ----------------------------
CREATE TABLE `g_trip` (
  `tripId` int(11) NOT NULL AUTO_INCREMENT,
  `tripName` varchar(100) NOT NULL,
  `tripDesc` varchar(500) NOT NULL,
  `tripImg` varchar(1000) DEFAULT NULL,
  `tripDest` varchar(200) NOT NULL,
  `experience` varchar(1000) NOT NULL,
  `tripDetail` text NOT NULL,
  `tripHotel` varchar(4000) NOT NULL,
  `tripCost` int(11) NOT NULL,
  `costInclude` varchar(4000) DEFAULT NULL,
  `costUnInclude` varchar(4000) DEFAULT NULL,
  `reserveNote` varchar(4000) DEFAULT NULL,
  `tripDays` int(11) DEFAULT NULL,
  `tripMenu` int(11) DEFAULT NULL,
  PRIMARY KEY (`tripId`)
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for g_user
-- ----------------------------
CREATE TABLE `g_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `nickName` varchar(10) DEFAULT NULL,
  `userName` varchar(10) NOT NULL,
  `userTel` varchar(11) NOT NULL,
  `userPass` varchar(300) NOT NULL,
  `userAge` int(11) NOT NULL,
  `userBirth` date NOT NULL,
  `userEmail` varchar(30) DEFAULT NULL,
  `userStatus` int(11) DEFAULT '0',
  `code` varchar(300) NOT NULL DEFAULT '0',
  `userImg` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userName` (`userName`),
  UNIQUE KEY `nickName` (`nickName`),
  UNIQUE KEY `userEmail` (`userEmail`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `g_appoint` VALUES ('1', '张三', '15656567878', '澳大利亚', '4', '2018-12-18', '2', '0', '1', '29');
INSERT INTO `g_appoint` VALUES ('2', '李四', '12323238989', '非洲', '2', '2018-12-19', '1', '1', '0', '29');
INSERT INTO `g_appoint` VALUES ('3', '王五', '14545457878', '澳大利亚', '3', '2018-12-27', '2', '1', '1', '29');
INSERT INTO `g_appoint` VALUES ('4', 'zhaoliu', '15656564545', '香港', '2', '2018-12-27', '2', '2', '0', '29');
INSERT INTO `g_appoint` VALUES ('5', '悟空', '15623235656', '美国', '2', '2018-12-28', '2', '1', '0', '29');
INSERT INTO `g_appoint` VALUES ('6', '王凯', '1888888888', '厦门', '2', '2019-01-01', '1', '0', '0', '29');
INSERT INTO `g_appoint` VALUES ('7', '影', '188888888', '湖南', '3', '2018-12-13', '1', '1', '0', '29');
INSERT INTO `g_appoint` VALUES ('8', '露娜', '15656567878', '', '2', '2018-12-25', '1', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('9', '凯', '17889895656', '', '3', '2018-12-28', '3', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('17', '凯', '17889895656', '', '3', '2018-12-28', '3', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('48', '工本', '456', '', '2', '2018-12-13', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('49', '残文集', '78', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('50', '大龙', '12323234556', '得瑟', '1', '2018-12-20', '2', '2', '1', '0');
INSERT INTO `g_appoint` VALUES ('51', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('52', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('53', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('54', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('55', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('56', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('57', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('58', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('59', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('60', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('61', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('62', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('63', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('64', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('65', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('66', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('67', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('68', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('69', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('70', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('71', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('72', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('73', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('74', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('75', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('76', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('77', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('78', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('79', 'dd', '15656567878', '', '2', '2018-12-19', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('80', 'lk', '45', '', '2', '2018-12-12', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('81', 'yi', '12323238978', '', '2', '2018-12-12', '3', '1', '0', '0');
INSERT INTO `g_appoint` VALUES ('82', 'yi', '12323238978', '', '2', '2018-12-12', '3', '1', '0', '0');
INSERT INTO `g_appoint` VALUES ('83', 'yi', '12323238978', '', '2', '2018-12-12', '3', '1', '0', '0');
INSERT INTO `g_appoint` VALUES ('84', 'ju', '789', '', '2', '2018-12-12', '2', '2', '0', '0');
INSERT INTO `g_appoint` VALUES ('85', '王五', '18866666666', '无锡', '2', '2018-12-04', '2', '1', '0', '0');
INSERT INTO `g_appoint` VALUES ('86', 'ying', '17356151982', '家里蹲', '3', '2019-12-01', '3', '1', '0', '40');
INSERT INTO `g_appoint` VALUES ('87', 'ying', '17356151982', '家里蹲', '3', '2019-12-01', '3', '1', '0', '40');
INSERT INTO `g_appoint` VALUES ('88', 'lq', '18989897878', '', '2', '2018-12-05', '1', '1', '0', '0');
INSERT INTO `g_menu` VALUES ('1', '定制之旅', 'http://pjnyft8b0.bkt.clouddn.com/FkrnluJi0LcAZGbiSLcRSLSSqY_A?e=1545056768&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:_xLtPIVMQ3i9gHdJxXkDFGpgu9M=');
INSERT INTO `g_menu` VALUES ('11', '健康养生', 'http://pjnyft8b0.bkt.clouddn.com/FquE5rKj25sjvcYXNiX7lv5ZSuNi?e=1545635695&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:YkoY9zyZk3waYBjaJjfFhHDX14Q=');
INSERT INTO `g_menu` VALUES ('13', '文明探索', 'http://pjnyft8b0.bkt.clouddn.com/FuMjiXBRncISkNFNwRt_xoZ9zllX?e=1545052540&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:9rEpxyGiMN-c6-j4qPSPkuUk77E=');
INSERT INTO `g_menu` VALUES ('14', '游轮假期', 'http://pjnyft8b0.bkt.clouddn.com/FvgxdWbcipDBhfefgmfStLChgnrR?e=1545635725&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:1dDYqwpghT46-8cdkrpwWeqfp6M=');
INSERT INTO `g_menu` VALUES ('18', '家庭亲子', 'http://pjnyft8b0.bkt.clouddn.com/Fs_jDlyGNtbkkCuKmgitJB7RZDwR?e=1545052556&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:fJhfreZ32TsAdeJ4QlmZVwnr6Kk=');
INSERT INTO `g_menu` VALUES ('19', '美食购物', 'http://pjnyft8b0.bkt.clouddn.com/FsnCqqaqsiwZRdW2SEWfo6wvUSk2?e=1545052566&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:XMVueqTaaPDyAI2BG80jj75UmL8=');
INSERT INTO `g_menu` VALUES ('21', '轻度探险', 'http://pjnyft8b0.bkt.clouddn.com/FthrjyUJPMXzYrGu8v6MgQyP3sDr?e=1545635756&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:-gjpBq-g0CABuXvP72DaKvZiphQ=');
INSERT INTO `g_menu` VALUES ('42', '婚礼蜜月', 'http://pjnyft8b0.bkt.clouddn.com/FlBfQpv9wY08x6vBvGJwZ9H1LkI1?e=1545052585&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:ltKjo5N7gUNN_cjimWN-VYd3mn0=');
INSERT INTO `g_menu` VALUES ('53', '休闲海岛', 'http://pjnyft8b0.bkt.clouddn.com/Fivw_ri5bt9FAcreekErHDHyVAcl?e=1545635813&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:mMOnGnA42qpaG5FUlLUDPywdW0o=');
INSERT INTO `g_menu` VALUES ('68', '当季旅行', 'http://pjnyft8b0.bkt.clouddn.com/FsYxV7fW7IuogeY8aKzKjdiANshj?e=1545134983&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:JMTewAlqKXeDKptSuJdJE-xAkQo=');
INSERT INTO `g_menu` VALUES ('69', '特价旅行', 'http://pjnyft8b0.bkt.clouddn.com/FsYxV7fW7IuogeY8aKzKjdiANshj?e=1544770138&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:cIcUGqqSYsLMGgkNavs-mUQf8P0=');
INSERT INTO `g_order` VALUES ('1', '2018-12-26 14:23:33', '2018-12-18', '4', '2', '0', '4', '95', '2998');
INSERT INTO `g_order` VALUES ('2', '2019-01-03 13:32:21', '2018-12-19', '1', '1', '1', '2', '4', '1989');
INSERT INTO `g_order` VALUES ('3', '2018-12-12 13:23:47', '2018-12-31', '2', '1', '0', '3', '4', '999');
INSERT INTO `g_order` VALUES ('4', '2018-12-12 14:25:52', '2018-12-07', '3', '1', '1', '2', '94', '8888');
INSERT INTO `g_order` VALUES ('5', '2018-12-12 14:56:24', '2018-12-12', '3', '2', '0', '2', '4', '4343');
INSERT INTO `g_order` VALUES ('6', '2018-12-27 14:13:04', '2018-12-25', '1', '2', '0', '2', '4', '2335');
INSERT INTO `g_order` VALUES ('7', '2018-12-17 14:24:26', '2018-12-22', '2', '1', '1', '1', '9', '7537');
INSERT INTO `g_order` VALUES ('8', '2018-12-21 14:24:29', '2018-11-11', '4', '1', '1', '2', '4', '1444');
INSERT INTO `g_order` VALUES ('9', '2018-12-17 02:41:31', '2018-12-12', '3', '2', '1', '2', '95', '800');
INSERT INTO `g_order` VALUES ('10', '2018-12-22 14:24:36', '2019-11-19', '2', '2', '0', '3', '94', '700');
INSERT INTO `g_order` VALUES ('11', '2019-01-01 05:24:57', '2019-01-01', '3', '2', '0', '2', '94', '10000');
INSERT INTO `g_order` VALUES ('12', '2019-01-16 16:25:04', '2019-12-13', '2', '2', '0', '2', '94', '1000');
INSERT INTO `g_order` VALUES ('13', '2019-01-15 14:02:45', '2018-12-12', '3', '1', '0', '2', '9', '10000');
INSERT INTO `g_order` VALUES ('14', '2018-12-28 19:25:22', '2018-12-12', '4', '2', '0', '1', '4', '5656');
INSERT INTO `g_order` VALUES ('15', '2019-01-02 22:25:55', '2018-11-19', '4', '2', '0', '2', '4', '4000');
INSERT INTO `g_order` VALUES ('16', '2018-12-13 16:43:32', '2019-01-02', '2', '2', '0', '4', '9', '6666');
INSERT INTO `g_order` VALUES ('17', '2019-01-24 15:01:37', '2019-01-03', '4', '2', '0', '4', '94', '1666');
INSERT INTO `g_order` VALUES ('18', '2018-12-26 21:25:46', '2019-01-09', '4', '2', '0', '12', '9', '2000');
INSERT INTO `g_order` VALUES ('19', '2018-12-28 17:26:10', '2019-02-01', '7', '1', '0', '1', '4', '5000');
INSERT INTO `g_order` VALUES ('20', '2018-12-25 14:26:16', '2019-02-05', '6', '4', '0', '1', '95', '7700');
INSERT INTO `g_order` VALUES ('21', '2018-12-02 14:26:19', '2019-03-01', '6', '5', '0', '5', '9', '10000');
INSERT INTO `g_order` VALUES ('22', '2019-01-12 19:26:23', '2019-03-02', '4', '4', '1', '4', '4', '3000');
INSERT INTO `g_order` VALUES ('23', '2018-12-20 10:26:29', '2018-01-03', '4', '2', '0', '29', '4', '10000');
INSERT INTO `g_order` VALUES ('30', '2018-12-17 14:33:07', '2019-01-01', '1', '1', '0', '1', '9', '8565');
INSERT INTO `g_order` VALUES ('31', '2018-12-17 14:42:13', '2019-01-01', '2', '2', '1', '29', '4', '10000');
INSERT INTO `g_order` VALUES ('32', '2018-12-18 14:43:38', '2018-12-18', '6', '1', '0', '29', '124', '10000');
INSERT INTO `g_order` VALUES ('33', '2018-12-18 14:49:07', '2018-12-18', '3', '1', '1', '34', '124', '8888');
INSERT INTO `g_order` VALUES ('34', '2018-12-18 14:49:18', '2018-12-18', '1', '0', '0', '31', '124', '4343');
INSERT INTO `g_order` VALUES ('35', '2018-12-18 15:15:50', '2018-12-18', '1', '0', '1', '29', '126', '10000');
INSERT INTO `g_order` VALUES ('36', '2018-12-18 21:05:58', '2019-01-01', '5', '3', '0', '29', '124', '19999');
INSERT INTO `g_order` VALUES ('37', '2018-12-18 21:20:45', '2018-12-18', '2', '0', '1', '29', '129', '10000');
INSERT INTO `g_order` VALUES ('38', '2018-12-18 21:25:38', '2018-12-18', '1', '0', '0', '31', '131', '7979');
INSERT INTO `g_order` VALUES ('39', '2018-12-18 21:47:25', '2018-12-18', '1', '0', '0', '31', '124', '10000');
INSERT INTO `g_order` VALUES ('40', '2018-12-19 11:00:30', '2018-12-19', '3', '1', '0', '31', '131', '9889');
INSERT INTO `g_order` VALUES ('41', '2018-12-19 11:00:49', '2018-12-19', '1', '0', '0', '31', '130', '5566');
INSERT INTO `g_order` VALUES ('42', '2018-12-19 16:33:16', '2018-12-19', '2', '0', '0', '31', '128', '6363');
INSERT INTO `g_order` VALUES ('43', '2018-12-20 10:54:58', '2019-01-03', '9', '9', '1', '29', '125', '666');
INSERT INTO `g_order` VALUES ('44', '2018-12-20 10:59:33', '2019-01-10', '7', '7', '0', '30', '121', '1111');
INSERT INTO `g_order` VALUES ('45', '2018-12-20 11:11:40', '2018-08-08', '1', '1', '0', '6', '121', '333');
INSERT INTO `g_order` VALUES ('48', '2018-12-21 10:46:46', '2018-12-21', '2', '1', '0', '29', '128', '0');
INSERT INTO `g_order` VALUES ('49', '2018-12-21 10:53:58', '2018-12-21', '3', '2', '0', '29', '125', '6000');
INSERT INTO `g_order` VALUES ('50', '2018-12-21 11:24:24', '2018-12-21', '1', '3', '0', '39', '123', '2500');
INSERT INTO `g_order` VALUES ('51', '2018-12-21 11:30:35', '2018-12-21', '2', '0', '0', '29', '129', '5046');
INSERT INTO `g_order` VALUES ('52', '2018-12-21 11:53:48', '2018-12-21', '1', '1', '0', '29', '126', '2999');
INSERT INTO `g_order` VALUES ('53', '2018-12-21 11:54:42', '2018-12-21', '2', '1', '0', '29', '126', '4997');
INSERT INTO `g_order` VALUES ('54', '2018-12-21 13:43:54', '2019-02-02', '2', '2', '0', '30', '123', '2000');
INSERT INTO `g_order` VALUES ('55', '2018-12-21 13:45:52', '2018-12-29', '3', '3', '0', '30', '121', '2000.5');
INSERT INTO `g_order` VALUES ('56', '2018-12-21 13:48:41', '2018-12-21', '3', '3', '0', '29', '129', '11353.5');
INSERT INTO `g_order` VALUES ('57', '2018-12-21 14:34:35', '2018-12-21', '0', '0', '0', '39', '124', '0');
INSERT INTO `g_order` VALUES ('58', '2018-12-21 14:36:15', '2018-12-21', '0', '0', '0', '40', '130', '0');
INSERT INTO `g_order` VALUES ('59', '2018-12-21 14:36:34', '2018-12-21', '0', '0', '0', '40', '130', '0');
INSERT INTO `g_order` VALUES ('60', '2018-12-21 14:36:41', '2018-12-21', '0', '0', '0', '40', '130', '0');
INSERT INTO `g_order` VALUES ('61', '2018-12-21 14:38:20', '2018-12-21', '2', '1', '0', '29', '127', '18672.5');
INSERT INTO `g_order` VALUES ('62', '2018-12-21 14:38:53', '2018-12-21', '0', '0', '0', '29', '131', '0');
INSERT INTO `g_order` VALUES ('63', '2018-12-21 14:39:43', '2018-12-21', '0', '0', '0', '29', '131', '0');
INSERT INTO `g_order` VALUES ('64', '2018-12-24 18:29:59', '2018-12-24', '1', '1', '0', '29', '127', '11203.5');
INSERT INTO `g_order` VALUES ('65', '2018-12-24 18:30:13', '2018-12-12', '4', '1', '0', '29', '123', '8721');
INSERT INTO `g_order` VALUES ('66', '2018-12-24 20:37:36', '2018-12-24', '1', '1', '0', '29', '128', '3780');
INSERT INTO `g_order` VALUES ('67', '2018-12-24 20:50:38', '2018-12-24', '0', '0', '0', '29', '128', '0');
INSERT INTO `g_trip` VALUES ('123', '海南三亚+海口+天涯海角+分界洲岛5日4晚跟团游', '火热来袭◆度假专线◆畅玩海岛◆浪漫三亚◆拒绝购物团◆与您相约天涯海角', 'http://pjnyft8b0.bkt.clouddn.com/FiELIJij2HQ9tRO-F23LPCyHCa7d?e=1545141888&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:gEXh1aD4uKbiQoDgxwrv91JkfI4=', '海南', '<p><img src=\"http://dimg04.c-ctrip.com/images/300f0x000000lfozgBF14.jpg\" alt=\"undefined\"/></p>', '<p><img src=\"http://dimg04.c-ctrip.com/images/30010x000000lo9v78064.jpg\" alt=\"undefined\"/></p>', '<p><img src=\"http://dimg04.c-ctrip.com/images/300d0x000000l9vap0A6D.jpg\" alt=\"undefined\"/></p>', '1938', '<ul class=\"mod_info_box list-paddingleft-2\"><li><p>费用包含</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>全程旅游巴士</p></li><li><p>行程所列酒店住宿费用</p></li><li><p>酒店标准2人间</p></li><li><p>行程内所列餐食，具体情况请见行程推荐/安排。</p></li><li><p>当地中文导游服务。</p></li></ul></ul><p><br/></p>', '<ul class=\"mod_info_box list-paddingleft-2\"><li><p>自理费用</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>超\n重行李的托运费、保管费; 因交通延阻、罢工、天气、机器故障等不可抗力原因所导致的额外费用: \n酒店内洗衣、理发、电话、传真、收费电视、饮品、烟酒等个人消费; 自由活动期间的用车服务; 提供导游服务的产品在自由活动期间无陪同服务; \n当地参加的自费以及“费用包含”中不包含的其它项目。</p></li><li><p>因景区儿童标准不一样，儿童价不含景区门票费用，如产生儿童门票费用，游客可自行到景区购买门票或由导游代为购买。</p></li><li><p>不包含景区内电瓶车费用。</p></li></ul></ul><p><br/></p>', '<ul class=\"mod_info_box list-paddingleft-2\"><li><p>预订说明</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>请您在预订时务必提供准确、完整的信息（姓名、性别、证件号码、国籍、联系方式、是否成人或儿童等），以免产生预订错误，影响出行。如因客人提供错误个人信息而造成损失，应由客人自行承担因此产生的全部损失。</p></li><li><p>儿童门票不接受预订，请自行在景区购买。</p></li></ul></ul><p><br/></p>', '7', '19');
INSERT INTO `g_trip` VALUES ('124', '日本东京6日5晚私家团', '富士登山缆车·芦之湖·忍野八海', 'http://pjnyft8b0.bkt.clouddn.com/FqIItMOTLCXsQXJw7AlL2mE7Y0RV?e=1545057178&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:QssEcUTull-ylam5WlCFcfWaYtI=', '日本', '<p><strong><img alt=\"undefined\" src=\"http://dimg04.c-ctrip.com/images/300u0t000000ilczgB46D.jpg\"/></strong></p>', '<p><strong><img alt=\"undefined\" src=\"http://dimg04.c-ctrip.com/images/300k0t000000ipkhb201E.jpg\"/></strong></p>', '<p><strong><img alt=\"undefined\" src=\"http://dimg04.c-ctrip.com/images/300k0t000000ipkhc2FFD.jpg\"/></strong></p>', '3999', '<ul class=\" list-paddingleft-2\"><li><p>费用包含</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>往返机票、燃油附加费、机票税</p></li><li><p>行程所列酒店住宿费用</p></li><li><p>酒店标准2人间</p></li></ul></ul><p><br/></p>', '<ul class=\" list-paddingleft-2\"><li><p>自理费用</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>您所支付的费用中不包含输入数字人民币/人的签证价格。请在出入境时自备有效签证，如需代办，请在预订时选择相应附加费用选项。</p></li></ul></ul><p><br/></p>', '<ul class=\"mod_info_box list-paddingleft-2\"><li><p>预订说明</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>请您在预订时务必提供准确、完整的信息（姓名、性别、证件号码、国籍、联系方式、是否成人或儿童等），以免产生预订错误，影响出行。如因客人提供错误个人信息而造成损失，应由客人自行承担因此产生的全部损失。</p></li></ul></ul><p><br/></p>', '1', '68');
INSERT INTO `g_trip` VALUES ('125', '旅游婚礼', '四季酒店花园&沙滩私密浪漫婚礼', 'http://pjnyft8b0.bkt.clouddn.com/FjV2L2fSM_PrbVgN79mA0xPvOFjj?e=1545104055&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:fJsS2ygtc7sYFSNx6tRvJp61ri8=', '巴厘岛', '<p><img src=\"http://dimg04.c-ctrip.com/images/300q0v000000k4t9w2993.jpg\" alt=\"undefined\"/></p>', '<p><img src=\"http://dimg04.c-ctrip.com/images/300p0v000000k2nml5DEA.jpg\" alt=\"undefined\"/></p>', '<p><img src=\"http://dimg04.c-ctrip.com/images/300p0v000000k2nmj3DB0.jpg\" alt=\"undefined\"/></p>', '23610', '<ul class=\" list-paddingleft-2\"><li><p>费用包含</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>往返经济舱机票燃油附加费（以实际收费标准为准）机票税</p></li><li><p>行程所列酒店住宿费用</p></li><li><p>酒店标准2人间</p></li></ul></ul><p><br/></p>', '<ul class=\" list-paddingleft-2\"><li><p>自理费用</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>单房差</p></li><li><p>出入境个人物品海关征税；</p></li></ul></ul><p><br/></p>', '<ul class=\" list-paddingleft-2\"><li><p>签证所需材料</p></li><li><p class=\"visa_filetip\">请根据自身情况选择签证所需材料&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;★为必须提供的材料&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;●为根据个人情况酌情提供</p></li></ul><p><br/></p>', '1', '42');
INSERT INTO `g_trip` VALUES ('126', '昆明+普洱+西双版纳6日5晚跟团游', '三飞·喜来登温泉+傣秀', 'http://pjnyft8b0.bkt.clouddn.com/Fv_P5KWy41jiJeoOpWb0Wr_HnJBf?e=1545635922&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:n-n79gpka8lS36iqpnDfmU_Bt8c=', '昆明', '<p><img src=\"http://dimg04.c-ctrip.com/images/30070w000000l6rsvF798.jpg\" alt=\"undefined\"/></p>', '<p><img src=\"http://dimg04.c-ctrip.com/images/300g0y000000m0ra70040.jpg\" alt=\"undefined\"/></p>', '<p><img src=\"http://dimg04.c-ctrip.com/images/300d0w000000kolwd5246.jpg\" alt=\"undefined\"/></p>', '2054', '<ul class=\" list-paddingleft-2\"><li><p>费用包含</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>往返经济舱机票燃油附加费（以实际收费标准为准）机票税</p></li><li><p>行程所列酒店住宿费用</p></li><li><p>酒店标准2人间</p></li></ul></ul><p><br/></p>', '<ul class=\" list-paddingleft-2\"><li><p>自理费用</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>超重行李的托运费、保管费; 因交通延阻、罢工、天气、机器故障等不可抗力原因所导致的额外费用</p></li></ul></ul><p><br/></p>', '<ul class=\" list-paddingleft-2\"><li><p>预订说明</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>请您在预订时务必提供准确、完整的信息（姓名、性别、证件号码、国籍、联系方式、是否成人或儿童等），以免产生预订错误，影响出行。如因客人提供错误个人信息而造成损失，应由客人自行承担因此产生的全部损失。</p></li></ul></ul><p><br/></p>', '1', '42');
INSERT INTO `g_trip` VALUES ('127', '禅修养生·柬埔寨吴哥窟', '探秘女王宫+吴哥日出+崩密列探险莱佛士养生度假', 'http://pjnyft8b0.bkt.clouddn.com/FiELIJij2HQ9tRO-F23LPCyHCa7d?e=1545104104&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:dLWinHDfx-SW-fV6F9FghY1yKg4=', '柬埔寨', '<p><img src=\"http://dimg04.c-ctrip.com/images/300k0t000000is0sb51FF.jpg\" alt=\"undefined\"/></p>', '<p><img src=\"http://dimg04.c-ctrip.com/images/30060t000000iognm1664.jpg\" alt=\"undefined\"/></p>', '<p><img src=\"http://dimg04.c-ctrip.com/images/30030v000000jor3259A9.jpg\" alt=\"undefined\"/></p>', '7469', '<ul class=\" list-paddingleft-2\"><li><p>费用包含</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>往返`经济舱机票`、`燃油附加费（以实际收费标准为准）`、`</p></li><li><p>往返出发地到出行集合地的联运航班机票。</p></li><li><p>酒店标准2人间</p></li></ul></ul><p><br/></p>', '<ul class=\" list-paddingleft-2\"><li><p>自理费用</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>本产品不包含柬埔寨签证费用，如需代办请于预订时勾选。</p></li><li><p>单房差</p></li></ul></ul><p><br/></p>', '<ul class=\"mod_info_box list-paddingleft-2\"><li><p>产品说明</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>本产品一单一团，最少成团人数2人，订单一经携程旅行网以书面形式确认后均默认发团，若因携程商家原因未发团（除不可抗力外），旅行社将按双方合同约定的违约条款予以赔付。</p></li></ul></ul><p><br/></p>', '1', '11');
INSERT INTO `g_trip` VALUES ('128', '海南三亚5日4晚跟团游', '五大产品福利 享呀诺达景区电瓶车+南山养生素斋+呀诺达药膳', 'http://pjnyft8b0.bkt.clouddn.com/FszGnsP8_-9fmMrDYV2vwH4JgXUT?e=1545057392&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:Slz6s40pQwM0iSMj99CjgG5E5Bg=', '海南', '<p><img src=\"http://dimg04.c-ctrip.com/images/30090y000000m35nd8D8A.jpg\" alt=\"undefined\"/></p>', '<p><img src=\"http://dimg04.c-ctrip.com/images/300e0y000000m3i4741AC.jpg\" alt=\"undefined\"/></p>', '<p><img src=\"http://dimg04.c-ctrip.com/images/300c0z000000mypmpB412.jpg\" alt=\"undefined\"/><img src=\"http://dimg04.c-ctrip.com/images/300t0y000000m0sup758A.jpg\" alt=\"undefined\"/></p>', '2520', '<ul class=\" list-paddingleft-2\"><li><p>费用包含</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>往返机票、燃油附加费、机场建设费</p></li><li><p>行程所列酒店住宿费用</p></li></ul></ul><p><br/></p>', '<ul class=\" list-paddingleft-2\"><li><p>自理费用</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>超重行李的托运费、保管费; 因交通延阻、罢工、天气、机器故障等不可抗力原因所导致的额外费用</p></li></ul></ul><p><br/></p>', '<ul class=\" list-paddingleft-2\"><li><p>预订说明</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>请您在预订时务必提供准确、完整的信息（姓名、性别、证件号码、国籍、联系方式、是否成人或儿童等），以免产生预订错误，影响出行。</p></li></ul></ul><p><br/></p>', '1', '68');
INSERT INTO `g_trip` VALUES ('129', '贵州黄果树+西江千户苗寨+荔波5日4晚跟团游', '真纯玩·进店赔1000元', 'http://pjnyft8b0.bkt.clouddn.com/Fv_P5KWy41jiJeoOpWb0Wr_HnJBf?e=1545057338&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:5CDFkJl1tj33vKFAR9e3rcssXWA=', '贵州', '<p><span style=\"font-size:18px;\"><img src=\"http://dimg04.c-ctrip.com/images/300q0w000000kcn687027.jpg\" alt=\"undefined\"/></span></p>', '<p><span style=\"font-size:18px;\"><img src=\"http://dimg04.c-ctrip.com/images/30070w000000ks1dqAAFF.jpg\" alt=\"undefined\"/></span></p>', '<p><span style=\"font-size:18px;\"><img src=\"http://dimg04.c-ctrip.com/images/300j0w000000kav9j6250.jpg\" alt=\"undefined\"/></span></p>', '1566', '<ul class=\" list-paddingleft-2\"><li><p>费用包含</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>往返机票燃油附加费（以实际收费标准为准）机场建设费</p></li><li><p>行程所列酒店住宿费用</p></li><li><p>酒店标准2人间</p></li></ul></ul><p><br/></p>', '<ul class=\" list-paddingleft-2\"><li><p>自理费用</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>超重行李的托运费、保管费; 因交通延阻、罢工、天气、机器故障等不可抗力原因所导致的额外费用</p></li></ul></ul><p><br/></p>', '<ul class=\" list-paddingleft-2\"><li><p>产品说明</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>本产品最少成团人数10人，如未达到最少成团人数，携程将在出发前7天通知不成团，未通知的视为成团。</p></li></ul></ul><p><br/></p>', '1', '68');
INSERT INTO `g_trip` VALUES ('130', '长沙+张家界+天门山+湘西+凤凰5日4晚跟团游', '心跳双玻【玻璃桥+玻璃栈道】+艳遇凤凰【泛舟沱江】', 'http://pjnyft8b0.bkt.clouddn.com/FjV2L2fSM_PrbVgN79mA0xPvOFjj?e=1545104261&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:fYSh9xyFrrXFTadYJfAriIJnKew=', '长沙、张家界、天门山、湘西、凤凰', '<p><img src=\"http://dimg04.c-ctrip.com/images/300g0y000000ly4hb04B1.jpg\" alt=\"undefined\"/></p>', '<p><img src=\"http://dimg04.c-ctrip.com/images/300n0y000000lwhr669FD.jpg\" alt=\"undefined\"/></p>', '<p><img src=\"http://dimg04.c-ctrip.com/images/30090y000000lzu4bF15A.jpg\" alt=\"undefined\"/></p>', '1761', '<ul class=\" list-paddingleft-2\"><li><p>费用包含</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>往返机票燃油附加费（以实际收费标准为准）机场建设费</p></li><li><p>往返旅游巴士</p></li><li><p>往返出发地到出行集合地的联运航班机票。</p></li></ul></ul><p><br/></p>', '<ul class=\" list-paddingleft-2\"><li><p>自理费用</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>超重行李的托运费、保管费; 因交通延阻、罢工、天气、机器故障等不可抗力原因所导致的额外费用</p></li></ul></ul><p><br/></p>', '<ul class=\" list-paddingleft-2\"><li><p>预订说明</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>请您在预订时务必提供准确、完整的信息（姓名、性别、证件号码、国籍、联系方式、是否成人或儿童等），以免产生预订错误，影响出行。</p></li></ul></ul><p><br/></p>', '1', '11');
INSERT INTO `g_trip` VALUES ('131', '日本大阪+京都6日5晚私家团', '世界遗产清水寺 千本鸟居', 'http://pjnyft8b0.bkt.clouddn.com/FlUXMMXO4CErfDz2ncHEhLsKiKUm?e=1545104284&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:fr_LBCjwdlCLwNkIarJrekle3BA=', '日本', '<p><img src=\"http://dimg04.c-ctrip.com/images/300h0y000000lzv7y2B74.jpg\" alt=\"undefined\"/></p>', '<p><img src=\"http://dimg04.c-ctrip.com/images/300c0y000000m0xud8ADE.jpg\" alt=\"undefined\"/></p>', '<p><img src=\"http://dimg04.c-ctrip.com/images/30010y000000mdyhf2108.jpg\" alt=\"undefined\"/></p>', '7137', '<ul class=\" list-paddingleft-2\"><li><p>费用包含</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>往返机票、燃油附加费、机票税</p></li><li><p>行程所列酒店住宿费用</p></li><li><p>全程入住民宿或酒店式公寓，根据出行人数安排房型</p></li></ul></ul><p><br/></p>', '<ul class=\" list-paddingleft-2\"><li><p>自理费用</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>本产品不包含日本签证费用，如需代办请于预订时勾选。</p></li><li><p>单房差</p></li></ul></ul><p><br/></p>', '<ul class=\" list-paddingleft-2\"><li><p>预订说明</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>请您在预订时务必提供准确、完整的信息（姓名、性别、证件号码、国籍、联系方式、是否成人或儿童等），以免产生预订错误，影响出行。</p></li></ul></ul><p><br/></p>', '1', '13');
INSERT INTO `g_trip` VALUES ('132', '海南海口15日14晚跟团游', '健康养老旅居度假体验 基地慢生活 漫步博鳌小镇 潭门吃海鲜 全方位服务 休闲养生+旅游度假两不误', 'http://pjnyft8b0.bkt.clouddn.com/Fgn9pVyTxZC7fd1hZEwVvPTzBG0B?e=1545105481&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:GN-RUKCWJhJKzQtFThzd5-2jqUM=', '海南海口', '<p>\n    <img src=\"http://dimg04.c-ctrip.com/images/300o0z000000musvvB70C.jpg\" alt=\"undefined\"/>\n</p>', '<p>\n    <img src=\"http://dimg04.c-ctrip.com/images/300u0z000000mvxlf1400.jpg\" alt=\"undefined\"/>\n</p>', '<p>\n    <img src=\"http://dimg04.c-ctrip.com/images/300q0z000000mx8yd97D4.jpg\" alt=\"undefined\"/><img src=\"http://dimg04.c-ctrip.com/images/30050z000000mygs6E886.jpg\" alt=\"undefined\"/><img src=\"http://dimg04.c-ctrip.com/images/300r0z000000mudqo508E.jpg\" alt=\"undefined\"/>\n</p>\n<p>\n    &nbsp; &nbsp;	<img src=\"http://dimg04.c-ctrip.com/images/300c0x000000lixnm6D5E.jpg\" alt=\"undefined\"/>\n</p>\n<p>\n    <br/>\n</p>', '3848', '<ul class=\"mod_info_box list-paddingleft-2\">\n    <li>\n        <p>\n            费用包含\n        </p>\n    </li>\n    <li>\n        <ul class=\"txt_list list-paddingleft-2\">\n            <li>\n                <p>\n                    往返机票、燃油附加费、机场建设费\n                </p>\n            </li>\n            <li>\n                <p>\n                    往返旅游巴士\n                </p>\n            </li>\n            <li>\n                <p>\n                    行程所列酒店住宿费用\n                </p>\n            </li>\n            <li>\n                <p>\n                    行程内所列餐食，具体情况请见行程推荐/安排。\n                </p>\n            </li>\n            <li>\n                <p>\n                    当地中文导游服务。\n                </p>\n            </li>\n            <li>\n                <p>\n                    安排当地专属用车(除部分特殊路段因当地规定及安全考量，则依规定派遣小型车)。\n                </p>\n            </li>\n            <li>\n                <p>\n                    行程中所列景点首道大门票可在此录入景点名称\n                </p>\n            </li>\n            <li>\n                <p>\n                    儿童价特殊说明：本产品不适于儿童。\n                </p>\n            </li>\n        </ul>\n    </li>\n</ul>\n<p>\n    <br/>\n</p>', '', '<ul class=\"mod_info_box list-paddingleft-2\">\n    <li>\n        <p>\n            预订说明\n        </p>\n    </li>\n    <li>\n        <ul class=\"txt_list list-paddingleft-2\">\n            <li>\n                <p>\n                    请您在预订时务必提供准确、完整的信息（姓名、性别、证件号码、国籍、联系方式、是否成人或儿童等），以免产生预订错误，影响出行。如因客人提供错误个人信息而造成损失，应由客人自行承担因此产生的全部损失。\n                </p>\n            </li>\n        </ul>\n    </li>\n</ul>\n<p>\n    <br/>\n</p>', '1', '11');
INSERT INTO `g_trip` VALUES ('133', '广州长隆+珠海长隆5日4晚跟团游', '赏春晚烟花show 你就是宝贝的大树 亲子乐翻天 自营新品 双飞', 'http://pjnyft8b0.bkt.clouddn.com/FkrnluJi0LcAZGbiSLcRSLSSqY_A?e=1545635980&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:v8NiGt9OP7Ioi5gUe48ldxK7wMM=', '广州长隆+珠海', '<p><img src=\"http://dimg04.c-ctrip.com/images/300l0w000000k58pyFF98.jpg\" title=\"2.jpg\"/><br/><strong><span style=\"color:#ff0000;\">备注：水上世界因时令原因已关闭，行程第三天指定游览长隆欢乐世界！</span></strong></p>', '<p><br/></p><p>&nbsp;<img src=\"http://dimg04.c-ctrip.com/images/30080w000000k59so1E05.jpg\" title=\"4.jpg\"/>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<img src=\"http://dimg04.c-ctrip.com/images/30040w000000k427xF265.jpg\" title=\"8.jpg\" height=\"1268\" width=\"900\"/><img src=\"http://dimg04.c-ctrip.com/images/300k0w000000k99ck2731.jpg\" title=\"10.jpg\"/></p><p>&nbsp;<img src=\"http://dimg04.c-ctrip.com/images/300s0w000000kbyggFE8C.jpg\" title=\"11.jpg\"/> </p><p><br/></p>', '<p><img src=\"http://dimg04.c-ctrip.com/images/30020w000000kc5ok8236.jpg\" title=\"5.jpg\"/></p><p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<img src=\"http://dimg04.c-ctrip.com/images/300i0w000000k3w977C4E.jpg\" title=\"7.jpg\"/> <img src=\"http://dimg04.c-ctrip.com/images/300e0w000000k7trw5646.jpg\" title=\"6.jpg\" height=\"1552\" width=\"900\"/></p><p><br/></p>', '3232', '<ul class=\" list-paddingleft-2\"><li><p>费用包含</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>往返机票燃油附加费（以实际收费标准为准）机票税</p></li><li><p>航班选择注意事项：<br/>(1)具体航司及航班时间可在下一步自行选择搭配 <br/>(2)若您选择到春秋航空等廉价航空，请关注其免费行李托运额度，若航司需收取超额行李费用敬请自理；<br/> (3)请各位贵宾至少在飞机起飞前120分钟抵达机场值机、登机，若因个人原因导致误机，损失请自理。</p></li><li><p>行程所列酒店住宿费用<br/>备选酒店注意事项：备选酒店视团队情况均可能安排，不存在优先级，且跟团行程不接受指定酒店，请您谅解。</p></li></ul></ul><p><br/></p>', '<ul class=\"mod_info_box list-paddingleft-2\"><li><p>自理费用</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>超\n重行李的托运费、保管费; 因交通延阻、罢工、天气、机器故障等不可抗力原因所导致的额外费用: \n酒店内洗衣、理发、电话、传真、收费电视、饮品、烟酒等个人消费; 自由活动期间的用车服务; 提供导游服务的产品在自由活动期间无陪同服务; \n当地参加的自费以及“费用包含”中不包含的其它项目。</p></li><li><p>因景区儿童标准不一样，儿童价不含景区门票费用，如产生儿童门票费用，游客可自行到景区购买门票或由导游代为购买。</p></li></ul></ul><p><br/></p>', '<ul class=\" list-paddingleft-2\"><li><p>产品说明</p></li><li><p><br/></p></li><ul class=\"txt_list list-paddingleft-2\" style=\"list-style-type: square;\"><li><p>最晚在出行前1天您将收到出团通知书或导游的确认电话，敬请留意，保持电话畅通。集合时间请参考网站披露信息，具体时间请以出团通知书或导游通知为准。</p></li></ul></ul><p><br/></p>', '1', '18');
INSERT INTO `g_user` VALUES ('1', '一叶知秋', '王五', '12333556677', '123123', '12', '1999-12-12', '132@qq.com', '1', '0', null);
INSERT INTO `g_user` VALUES ('2', '三千痴缠', '张三', '12333556677', '123123', '12', '1999-12-12', '77774@qq.com', '1', '0', null);
INSERT INTO `g_user` VALUES ('4', '空城旧梦', '李四', '15637856677', '789', '15', '1978-12-19', '782@qq.com', '1', '0', null);
INSERT INTO `g_user` VALUES ('6', '李白不喝酒', '李白', '12345454545', '789', '23', '2013-03-14', '9@qq.com', '1', '0', null);
INSERT INTO `g_user` VALUES ('7', '宫本武藏', '宫本', '1245464985', '456', '56', '1960-12-06', '789@qq.com', '0', '0', null);
INSERT INTO `g_user` VALUES ('8', '猴子', '悟空', '1565656589', '132', '30', '1960-12-12', '156@qq.com', '0', '0', null);
INSERT INTO `g_user` VALUES ('9', '月下无限连', '露娜', '23232323234', '563', '21', '2003-12-25', '888@qq.com', '1', '0', null);
INSERT INTO `g_user` VALUES ('10', '牛魔', '牛头', '56789889897', '456', '56', '1977-12-14', '44@qq.com', '1', '0', null);
INSERT INTO `g_user` VALUES ('11', '诸葛', '诸葛亮', '1234567899', '123', '23', '1960-12-12', '666@qq.com', '0', '0', null);
INSERT INTO `g_user` VALUES ('12', '貂蝉', '貂蝉', '12345454545', '456', '12', '1979-12-22', '999@qq.com', '0', '0', null);
INSERT INTO `g_user` VALUES ('13', '猜忌', '菜即', '1234564545', '789', '23', '2015-12-31', '111@qq.com', '0', '0', null);
INSERT INTO `g_user` VALUES ('14', '大清早', '上午', '5656565889', '123', '60', '2017-04-12', '56@qq.com', '0', '0', null);
INSERT INTO `g_user` VALUES ('15', '小垃圾', '垃圾', '15656787878', '789', '26', '1997-12-18', '12@qq.com', '0', '0', null);
INSERT INTO `g_user` VALUES ('16', '凯', '凯', '15689894545', '789', '22', '2018-12-12', '5@qq.com', '0', '0', null);
INSERT INTO `g_user` VALUES ('17', '0', 'liu', 'liu', '123', '0', '2018-12-13', '123@q.com', '1', '0', null);
INSERT INTO `g_user` VALUES ('19', 'hunij', '123', '12345', '456', '0', '2018-12-13', '4562@qq.com', '0', '0', null);
INSERT INTO `g_user` VALUES ('29', 'ying', '影', '15656568989', '202cb962ac59075b964b07152d234b70', '0', '2018-12-17', '778290774@qq.com', '1', 'a32000f70b1049c2b64a324159252795', 'http://pjnyft8b0.bkt.clouddn.com/FsYxV7fW7IuogeY8aKzKjdiANshj?e=1545650965&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:xWtNtfsS02tHIxQO86N3d3xs1rc=');
INSERT INTO `g_user` VALUES ('32', 'youjia', '游家', '1562323478', '202cb962ac59075b964b07152d234b70', '0', '2018-12-20', '12311@qq.com', '0', 'c725b3affd104f9aac497d4f4bddb063', 'http://pjnyft8b0.bkt.clouddn.com/FvSR8pe0L6sIAETEA_gcpFmcykDA?e=1545293873&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:pKb1ZfhNV67goJHVxAJ2dMkieuI=');
INSERT INTO `g_user` VALUES ('37', 'wang', 'wang', '12345457878', '202cb962ac59075b964b07152d234b70', '20', '2018-12-21', '1367183034@qq.com', '1', '805b64f5b01c47be8d898a46a9c64a33', 'http://pjnyft8b0.bkt.clouddn.com/Fgp4-W94O2xN9MZORDyVaRN4Spml?e=1545616575&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:Do-rYmsj2ZgoEtpDwQ16i5EdknM=');
INSERT INTO `g_user` VALUES ('41', '王五', 'wangwu', '18866666666', '202cb962ac59075b964b07152d234b70', '0', '2018-12-24', '2038889247@qq.com', '1', '01cd2d790aba4c11bf93e63a87064940', 'http://pjnyft8b0.bkt.clouddn.com/Fgp4-W94O2xN9MZORDyVaRN4Spml?e=1545616575&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:Do-rYmsj2ZgoEtpDwQ16i5EdknM=');
INSERT INTO `g_user` VALUES ('42', 'y', 'ying', '1565567878', '202cb962ac59075b964b07152d234b70', '0', '2018-12-24', '1220904301@qq.com', '0', 'a4b32cca0b66460fbf7303c7d086295a', 'http://pjnyft8b0.bkt.clouddn.com/FvSR8pe0L6sIAETEA_gcpFmcykDA?e=1545661296&token=DU3BU9etd2tzyBRDXofHCgf8-6FeAApZhxCVi3CB:BHb8_pDSBNGW2VRv5zy6pjAK800=');
