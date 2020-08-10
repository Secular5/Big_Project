/*
Navicat MySQL Data Transfer

Source Server         : 120.78.171.248
Source Server Version : 50725
Source Host           : 120.78.171.248:3306
Source Database       : es

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-11-05 11:37:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for es_book
-- ----------------------------
DROP TABLE IF EXISTS `es_book`;
CREATE TABLE `es_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '书籍编号',
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '书籍名字',
  `price` double DEFAULT NULL COMMENT '书籍价格',
  `author` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '书籍作者',
  `publisher` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '书籍出版社',
  `pubDate` date DEFAULT NULL COMMENT '发布时间',
  `description` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '书籍描述',
  `category_id` int(11) DEFAULT NULL COMMENT '分类id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of es_book
-- ----------------------------
INSERT INTO `es_book` VALUES ('1', '白夜行', '20', '作者张三', '出版社x', '2010-10-07', '文学1类', '8');
INSERT INTO `es_book` VALUES ('2', '天使的翅膀', '20', '作者张三', '出版社x', '2010-10-07', '文学2类', '9');
INSERT INTO `es_book` VALUES ('3', '文学类书3', '20', '作者张三', '出版社x', '2010-10-07', '文学3类', '10');
INSERT INTO `es_book` VALUES ('4', '社会科学书1', '20', '作者张三', '出版社x', '2010-10-07', '社会科学1类', '11');
INSERT INTO `es_book` VALUES ('5', '社会科学书2', '20', '作者张三', '出版社x', '2010-10-07', '社会科学2类', '12');
INSERT INTO `es_book` VALUES ('6', '社会科学书3', '20', '作者张三', '出版社x', '2010-10-07', '社会科学3类', '13');
INSERT INTO `es_book` VALUES ('7', '小说书1', '20', '作者张三', '出版社x', '2010-10-07', '小说1类', '14');
INSERT INTO `es_book` VALUES ('8', '小说书2', '20', '作者张三', '出版社x', '2007-10-07', '小说2类', '15');
INSERT INTO `es_book` VALUES ('9', '小说书3', '20', '作者张三', '出版社x', '2010-10-07', '小说3类', '16');
INSERT INTO `es_book` VALUES ('10', '计算机1书1', '20', '作者张三', '出版社x', '2010-10-07', '计算机1类', '17');
INSERT INTO `es_book` VALUES ('11', '计算机2书2', '20', '作者张三', '出版社x', '2009-10-07', '计算机2类', '18');
INSERT INTO `es_book` VALUES ('12', '计算机3书3', '20', '作者张三', '出版社x', '2010-10-07', '计算机3类', '19');
INSERT INTO `es_book` VALUES ('13', '传记书1', '20', '作者张三', '出版社x', '2010-10-07', '传记1类', '20');
INSERT INTO `es_book` VALUES ('14', '传记书2', '20', '作者张三', '出版社x', '2015-10-07', '传记2类', '21');
INSERT INTO `es_book` VALUES ('15', '传记书3', '20', '作者张三', '出版社x', '2010-10-07', '传记3类', '22');
INSERT INTO `es_book` VALUES ('16', '历史类书1', '20', '作者张三', '出版社x', '2017-10-07', '历史1类', '23');
INSERT INTO `es_book` VALUES ('17', '历史类书2', '20', '作者张三', '出版社x', '2022-10-07', '历史2类', '24');
INSERT INTO `es_book` VALUES ('18', '历史类书3', '20', '作者张三', '出版社x', '2010-10-07', '历史3类', '25');
INSERT INTO `es_book` VALUES ('19', '医学类书1', '20', '作者张三', '出版社x', '2010-10-07', '文学1类', '26');
INSERT INTO `es_book` VALUES ('20', '医学类书2', '20', '作者张三', '出版社x', '2010-10-07', '文学2类', '27');
INSERT INTO `es_book` VALUES ('21', '医学类书3', '20', '作者张三', '出版社x', '2010-10-07', '文学3类', '28');

-- ----------------------------
-- Table structure for es_category
-- ----------------------------
DROP TABLE IF EXISTS `es_category`;
CREATE TABLE `es_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '书籍分类id',
  `name` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '书籍分类名字',
  `description` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '书籍分类描述',
  `parent_id` int(255) DEFAULT NULL COMMENT '父类id',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of es_category
-- ----------------------------
INSERT INTO `es_category` VALUES ('1', '文学', '文学的描述', '0');
INSERT INTO `es_category` VALUES ('2', '社会科学', '社会科学的描述', '0');
INSERT INTO `es_category` VALUES ('3', '计算机与互联网', '计算机与互联网的描述', '0');
INSERT INTO `es_category` VALUES ('4', '小说', '小说的描述', '0');
INSERT INTO `es_category` VALUES ('5', '传记', '传记的描述', '0');
INSERT INTO `es_category` VALUES ('6', '历史', '历史的描述', '0');
INSERT INTO `es_category` VALUES ('7', '医学', '医学的描述', '0');
INSERT INTO `es_category` VALUES ('8', '文学1类', '文学1类的描述', '1');
INSERT INTO `es_category` VALUES ('9', '文学2类', '文学2类的描述', '1');
INSERT INTO `es_category` VALUES ('10', '文学3类', '文学3类的描述', '1');
INSERT INTO `es_category` VALUES ('11', '社会科学1', '社会科学1类的描述', '2');
INSERT INTO `es_category` VALUES ('12', '社会科学2', '社会科学2类的描述', '2');
INSERT INTO `es_category` VALUES ('13', '社会科学3', '社会科学3类的描述', '2');
INSERT INTO `es_category` VALUES ('14', '小说1', '小说1类的描述', '3');
INSERT INTO `es_category` VALUES ('15', '小说2', '小说2类的描述', '3');
INSERT INTO `es_category` VALUES ('16', '小说3', '小说3类的描述', '3');
INSERT INTO `es_category` VALUES ('17', '计算机1', '计算机1类的描述', '4');
INSERT INTO `es_category` VALUES ('18', '计算机2', '计算机2类的描述', '4');
INSERT INTO `es_category` VALUES ('19', '计算机3', '计算机3类的描述', '4');
INSERT INTO `es_category` VALUES ('20', '传记1', '传记1类的描述', '5');
INSERT INTO `es_category` VALUES ('21', '传记2', '传记2类的描述', '5');
INSERT INTO `es_category` VALUES ('22', '传记3', '传记3类的描述', '5');
INSERT INTO `es_category` VALUES ('23', '历史类1', '历史1类的描述', '6');
INSERT INTO `es_category` VALUES ('24', '历史类2', '历史2类的描述', '6');
INSERT INTO `es_category` VALUES ('25', '历史类3', '历史3类的描述', '6');
INSERT INTO `es_category` VALUES ('26', '医学类1', '医学类1的描述', '7');
INSERT INTO `es_category` VALUES ('27', '医学类2', '医学2类的描述', '7');
INSERT INTO `es_category` VALUES ('28', '医学类3', '医学3类的描述', '7');

-- ----------------------------
-- Table structure for es_customer
-- ----------------------------
DROP TABLE IF EXISTS `es_customer`;
CREATE TABLE `es_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `zip` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of es_customer
-- ----------------------------
INSERT INTO `es_customer` VALUES ('11', 'gongmeng', '123456', '1234', null, '123456', '1234@qq.com');
INSERT INTO `es_customer` VALUES ('12', 'gongmeng', '1234', '1234', null, '123456', '1234@qq.com');
INSERT INTO `es_customer` VALUES ('13', 'gongmeng', '1234', '1234', null, '123456', '1234@qq.com');
INSERT INTO `es_customer` VALUES ('14', '123', '123', '123', null, '123', '123');
INSERT INTO `es_customer` VALUES ('15', 'admin', '123456', '12345', null, '1234567', 'qqq@qq.com');
INSERT INTO `es_customer` VALUES ('16', '公萌', '123456', '12345', null, '1234567', 'sdfgh');
INSERT INTO `es_customer` VALUES ('17', 'ZZZ111', '111111', '111111', null, '111111', '111111');
INSERT INTO `es_customer` VALUES ('18', '张三', '333333', '562100', null, '12345678999', '123456789@qq.com');

-- ----------------------------
-- Table structure for es_orderForm
-- ----------------------------
DROP TABLE IF EXISTS `es_orderForm`;
CREATE TABLE `es_orderForm` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `cost` double DEFAULT NULL COMMENT '订单花费',
  `orderDate` date DEFAULT NULL COMMENT '订单时间',
  `shopAddress_id` int(11) DEFAULT NULL COMMENT '收获地址id',
  `customer_id` int(11) DEFAULT NULL COMMENT '客户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of es_orderForm
-- ----------------------------
INSERT INTO `es_orderForm` VALUES ('1', '20', '2019-10-26', null, '16');

-- ----------------------------
-- Table structure for es_orderLine
-- ----------------------------
DROP TABLE IF EXISTS `es_orderLine`;
CREATE TABLE `es_orderLine` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单项id',
  `num` int(11) DEFAULT NULL COMMENT '商品数量',
  `cost` double DEFAULT NULL COMMENT '订单项花费',
  `book_id` int(11) DEFAULT NULL COMMENT '书籍id',
  `orderForm_id` int(11) DEFAULT NULL COMMENT '订单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of es_orderLine
-- ----------------------------

-- ----------------------------
-- Table structure for es_shopAddress
-- ----------------------------
DROP TABLE IF EXISTS `es_shopAddress`;
CREATE TABLE `es_shopAddress` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收货地址id',
  `receiveName` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '收货人姓名',
  `address` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '收获地址',
  `phone` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '收获电话',
  `customer_id` int(11) DEFAULT NULL COMMENT '客户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of es_shopAddress
-- ----------------------------
INSERT INTO `es_shopAddress` VALUES ('1', 'gongmeng', 'wer', '123', '11');
