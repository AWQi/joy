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

/*Table structure for table `attention` */

DROP TABLE IF EXISTS `attention`;

CREATE TABLE `attention` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_1_id` int(11) NOT NULL COMMENT '关注者',
  `user_2_id` int(11) NOT NULL COMMENT '被关注者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `attention` */

insert  into `attention`(`id`,`user_1_id`,`user_2_id`) values 
(1,1,3),
(2,1,4),
(3,2,1),
(4,4,1);

/*Table structure for table `barrage` */

DROP TABLE IF EXISTS `barrage`;

CREATE TABLE `barrage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '弹幕id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `barrage` */

/*Table structure for table `collection` */

DROP TABLE IF EXISTS `collection`;

CREATE TABLE `collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收藏  id',
  `dyId` int(11) NOT NULL COMMENT '动态  id',
  `userId` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `collection` */

insert  into `collection`(`id`,`dyId`,`userId`) values 
(1,1,1),
(2,3,2),
(3,4,2),
(4,5,1),
(5,2,4),
(6,4,1);

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `dynamic_id` int(11) NOT NULL COMMENT '动态id',
  `content` varchar(100) NOT NULL COMMENT '内容',
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

insert  into `comment`(`id`,`user_id`,`dynamic_id`,`content`,`date`) values 
(1,1,3,'good','2018-06-23 07:19:25'),
(2,1,2,'great','2018-06-23 07:19:25'),
(3,1,1,'fine','2018-06-23 07:19:25'),
(4,1,4,'nice','2018-06-23 07:19:25'),
(5,2,1,'well','2018-06-23 08:13:00');

/*Table structure for table `dynamic` */

DROP TABLE IF EXISTS `dynamic`;

CREATE TABLE `dynamic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authorId` int(11) NOT NULL COMMENT '作者 id',
  `title` varchar(20) NOT NULL DEFAULT 'up主 很懒什么也没有写' COMMENT '标题',
  `imageUrl` char(200) NOT NULL COMMENT '封面路径',
  `introduction` varchar(50) NOT NULL DEFAULT 'up主 很懒什么也没有写' COMMENT '简介',
  `videoUrl` char(100) NOT NULL COMMENT '内容的路径',
  `praisesNum` int(11) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `kind` varchar(20) NOT NULL DEFAULT '未分类' COMMENT '分类',
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '默认填入系统时间',
  `viewNum` int(11) DEFAULT '0' COMMENT '浏览量',
  `collNum` int(11) DEFAULT '0' COMMENT '收藏量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `dynamic` */

insert  into `dynamic`(`id`,`authorId`,`title`,`imageUrl`,`introduction`,`videoUrl`,`praisesNum`,`kind`,`date`,`viewNum`,`collNum`) values 
(1,1,'AAA','https://img02.sogoucdn.com/app/a/100520093/12400ee0679b6e1e-d3e639ff657519ea-a9d4d43a8f00e80cfae6b8f74af91564.jpg','AAAAAAAAAAA','https://www.bilibili.com/video/av25373581/?spm_id_from=333.334.bili_douga.12',80,'游戏','2018-06-22 16:05:05',50,1),
(2,5,'BBB','https://img02.sogoucdn.com/app/a/100520093/12400ee0679b6e1e-d3e639ff657519ea-a9d4d43a8f00e80cfae6b8f74af91564.jpg','up主 很懒什么也没有写','https://www.bilibili.com/video/av25373581/?spm_id_from=333.334.bili_douga.12',30,'动漫','2018-06-22 19:30:30',30,10),
(3,2,'CCC','https://img02.sogoucdn.com/app/a/100520093/12400ee0679b6e1e-d3e639ff657519ea-a9d4d43a8f00e80cfae6b8f74af91564.jpg','up主 很懒什么也没有写','https://www.bilibili.com/video/av25373581/?spm_id_from=333.334.bili_douga.12',60,'音乐','2018-06-22 19:31:58',40,50),
(4,4,'DDD','https://img02.sogoucdn.com/app/a/100520093/12400ee0679b6e1e-d3e639ff657519ea-a9d4d43a8f00e80cfae6b8f74af91564.jpg','up主 很懒什么也没有写','https://www.bilibili.com/video/av25373581/?spm_id_from=333.334.bili_douga.12',0,'生活','2018-06-22 19:35:23',25,0),
(5,1,'EEE','https://img02.sogoucdn.com/app/a/100520093/12400ee0679b6e1e-d3e639ff657519ea-a9d4d43a8f00e80cfae6b8f74af91564.jpg','up主 很懒什么也没有写','https://www.bilibili.com/video/av25373581/?spm_id_from=333.334.bili_douga.12',0,'时尚','2018-06-22 19:37:58',38,0),
(6,3,'up主 很懒什么也没有写','https://img02.sogoucdn.com/app/a/100520093/12400ee0679b6e1e-d3e639ff657519ea-a9d4d43a8f00e80cfae6b8f74af91564.jpg','up主 很懒什么也没有写','https://www.bilibili.com/video/av25373581/?spm_id_from=333.334.bili_douga.12',0,'未分类','2018-06-22 19:38:55',41,0),
(7,5,'GGG','https://img02.sogoucdn.com/app/a/100520093/12400ee0679b6e1e-d3e639ff657519ea-a9d4d43a8f00e80cfae6b8f74af91564.jpg','Ada','https://www.bilibili.com/video/av25373581/?spm_id_from=333.334.bili_douga.12',0,'未分类','2018-06-22 19:39:46',20,0);

/*Table structure for table `muscovyplay` */

DROP TABLE IF EXISTS `muscovyplay`;

CREATE TABLE `muscovyplay` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '番剧',
  `name` varchar(20) NOT NULL,
  `imageUrl` varchar(50) NOT NULL,
  `video` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `muscovyplay` */

insert  into `muscovyplay`(`id`,`name`,`imageUrl`,`video`) values 
(1,'一人之下','A','A'),
(2,'王牌御史','A','A'),
(3,'妖怪名单','A','B');

/*Table structure for table `studio` */

DROP TABLE IF EXISTS `studio`;

CREATE TABLE `studio` (
  `id` int(11) NOT NULL COMMENT '直播间id  与用户id相同',
  `imageUrl` varchar(100) NOT NULL COMMENT '封面  url',
  `title` varchar(50) NOT NULL COMMENT '直播间标题',
  `premiere` int(11) NOT NULL COMMENT '是否开播',
  `studioUrl` varchar(100) NOT NULL COMMENT '直播间 url',
  PRIMARY KEY (`id`),
  CONSTRAINT `su` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `studio` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT 'user' COMMENT '昵称',
  `password` varchar(20) NOT NULL,
  `tel` varchar(13) NOT NULL,
  `headUrl` varchar(200) NOT NULL DEFAULT 'http://imgsrc.baidu.com/imgad/pic/item/7c1ed21b0ef41bd52a1399d25bda81cb39db3d57.jpg' COMMENT '头像Url',
  `gender` int(11) DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`,`name`,`password`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`tel`,`headUrl`,`gender`) values 
(1,'千彧','000000','18734741443','http://140.143.16.51/image/head/a.jpg',1),
(2,'残阳','000000','16532417413','http://140.143.16.51/image/head/g.jpg',2),
(3,'红尘','000000','18741652310','http://140.143.16.51/image/head/j.jpg',0),
(4,'枉生','000000','13265412314','http://140.143.16.51/image/head/k.jpg',2),
(5,'古拙','000000','14235476895','http://140.143.16.51/image/head/l.jpg',2),
(6,'孑然','000000','13356499599','http://140.143.16.51/image/head/m.jpg',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
