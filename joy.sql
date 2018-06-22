/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.7.21-log : Database - joy
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`joy` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `joy`;

/*Table structure for table `studio` */

DROP TABLE IF EXISTS `studio`;

CREATE TABLE `studio` (
  `id` int(11) NOT NULL COMMENT '直播间id  与用户id相同',
  `imageUrl` varchar(100) NOT NULL COMMENT '封面  url',
  `title` varchar(50) NOT NULL COMMENT '直播间标题',
  `premiere` int(11) NOT NULL COMMENT '是否开播',
  `studioUrl` varchar(100) NOT NULL COMMENT '直播间 url',
  PRIMARY KEY (`id`),
  CONSTRAINT `su` FOREIGN KEY (`id`) REFERENCES `tb_user` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `studio` */

/*Table structure for table `tb_attention` */

DROP TABLE IF EXISTS `tb_attention`;

CREATE TABLE `tb_attention` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_1_id` int(11) NOT NULL COMMENT '关注者',
  `user_2_id` int(11) NOT NULL COMMENT '被关注者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tb_attention` */

insert  into `tb_attention`(`id`,`user_1_id`,`user_2_id`) values 
(1,1,3),
(2,1,4),
(3,2,1),
(4,4,1);

/*Table structure for table `tb_barrage` */

DROP TABLE IF EXISTS `tb_barrage`;

CREATE TABLE `tb_barrage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '弹幕id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_barrage` */

/*Table structure for table `tb_comment` */

DROP TABLE IF EXISTS `tb_comment`;

CREATE TABLE `tb_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `synamic_id` int(11) NOT NULL COMMENT '动态id',
  `content` varchar(100) NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tb_comment` */

insert  into `tb_comment`(`id`,`user_id`,`synamic_id`,`content`) values 
(1,1,3,'good'),
(2,1,2,'great'),
(3,1,1,'fine'),
(4,1,4,'nice');

/*Table structure for table `tb_dynamic` */

DROP TABLE IF EXISTS `tb_dynamic`;

CREATE TABLE `tb_dynamic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL COMMENT '标题',
  `imageUrl` varbinary(20) DEFAULT NULL COMMENT '封面路径',
  `introduction` varchar(50) DEFAULT NULL COMMENT '简介',
  `videoUrl` varchar(40) NOT NULL COMMENT '内容的路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_dynamic` */

insert  into `tb_dynamic`(`id`,`title`,`imageUrl`,`introduction`,`videoUrl`) values 
(1,'AAA',NULL,'AAAAAAAAAAA','Url');

/*Table structure for table `tb_muscovyplay` */

DROP TABLE IF EXISTS `tb_muscovyplay`;

CREATE TABLE `tb_muscovyplay` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '番剧',
  `name` varchar(20) NOT NULL,
  `imageUrl` varchar(50) NOT NULL,
  `video` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `tb_muscovyplay` */

insert  into `tb_muscovyplay`(`id`,`name`,`imageUrl`,`video`) values 
(1,'一人之下','A','A'),
(2,'王牌御史','A','A'),
(3,'妖怪名单','A','B');

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT 'user' COMMENT '昵称',
  `password` varchar(20) NOT NULL,
  `tel` varchar(13) NOT NULL,
  `headUrl` varchar(200) NOT NULL DEFAULT 'http://imgsrc.baidu.com/imgad/pic/item/7c1ed21b0ef41bd52a1399d25bda81cb39db3d57.jpg' COMMENT '头像Url',
  `gender` int(11) DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`,`name`,`password`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`name`,`password`,`tel`,`headUrl`,`gender`) values 
(1,'千彧','000000','14232457945','http://imgsrc.baidu.com/imgad/pic/item/7c1ed21b0ef41bd52a1399d25bda81cb39db3d57.jpg',1),
(2,'残阳','000000','16532417413','http://imgsrc.baidu.com/imgad/pic/item/7c1ed21b0ef41bd52a1399d25bda81cb39db3d57.jpg',2),
(3,'红尘','000000','18741652310','http://imgsrc.baidu.com/imgad/pic/item/7c1ed21b0ef41bd52a1399d25bda81cb39db3d57.jpg',0),
(4,'枉生','000000','13265412314','http://imgsrc.baidu.com/imgad/pic/item/7c1ed21b0ef41bd52a1399d25bda81cb39db3d57.jpg',2),
(5,'古拙','000000','14235476895','http://imgsrc.baidu.com/imgad/pic/item/7c1ed21b0ef41bd52a1399d25bda81cb39db3d57.jpg',2),
(6,'孑然','000000','13356499599','http://imgsrc.baidu.com/imgad/pic/item/7c1ed21b0ef41bd52a1399d25bda81cb39db3d57.jpg',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
