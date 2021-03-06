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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `attention` */

insert  into `attention`(`id`,`user_1_id`,`user_2_id`) values 
(3,2,1),
(4,4,1),
(9,2,3),
(10,2,5),
(11,2,4),
(12,3,1),
(13,3,2),
(14,3,4),
(22,1,2),
(25,1,4),
(27,1,3),
(28,1,5),
(29,1,6),
(30,2,3),
(31,2,5),
(32,2,6);

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
  `dynamic_Id` int(11) NOT NULL COMMENT '动态  id',
  `user_Id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

/*Data for the table `collection` */

insert  into `collection`(`id`,`dynamic_Id`,`user_Id`) values 
(1,1,1),
(2,3,2),
(3,4,2),
(4,5,1),
(5,2,4),
(6,4,1),
(9,1,2),
(10,1,4),
(11,1,5),
(12,1,6),
(13,2,3),
(14,2,4),
(15,2,5),
(16,2,6),
(17,2,7),
(18,3,1),
(19,3,3),
(20,3,4),
(21,3,5),
(22,3,6),
(23,3,7),
(24,4,2),
(25,4,3),
(26,4,4),
(27,4,5),
(28,4,6),
(29,4,7),
(30,4,8),
(31,3,2),
(32,3,5),
(33,3,7),
(35,1,6),
(36,1,7),
(37,1,8);

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `dynamic_id` int(11) NOT NULL COMMENT '动态id',
  `content` varchar(100) NOT NULL COMMENT '内容',
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

insert  into `comment`(`id`,`user_id`,`dynamic_id`,`content`,`date`) values 
(2,1,2,'great','2018-06-23 07:19:25'),
(4,1,4,'nice','2018-06-23 07:19:25'),
(5,2,1,'well','2018-06-23 08:13:00'),
(7,1,5,'nice','2018-06-23 07:19:25'),
(8,1,6,'nice','2018-06-23 07:19:25'),
(9,2,3,'great','2018-06-23 07:19:25'),
(10,4,5,'great','2018-06-23 07:19:25'),
(11,3,1,'great','2018-06-23 07:19:25'),
(12,3,2,'great','2018-06-23 07:19:25'),
(13,3,4,'great','2018-06-23 07:19:25'),
(22,1,1,'saca','2018-06-27 10:48:38');

/*Table structure for table `dynamic` */

DROP TABLE IF EXISTS `dynamic`;

CREATE TABLE `dynamic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author_Id` int(11) NOT NULL COMMENT '作者 id',
  `title` varchar(20) NOT NULL DEFAULT 'up主 很懒什么也没有写' COMMENT '标题',
  `image_Url` char(200) NOT NULL COMMENT '封面路径',
  `introduction` varchar(50) NOT NULL DEFAULT 'up主 很懒什么也没有写' COMMENT '简介',
  `video_Url` char(100) NOT NULL COMMENT '内容的路径',
  `praises_Num` int(11) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `kind` varchar(20) NOT NULL DEFAULT '未分类' COMMENT '分类',
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '默认填入系统时间',
  `view_Num` int(11) DEFAULT '0' COMMENT '浏览量',
  `collect_Num` int(11) DEFAULT '0' COMMENT '收藏量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `dynamic` */

insert  into `dynamic`(`id`,`author_Id`,`title`,`image_Url`,`introduction`,`video_Url`,`praises_Num`,`kind`,`date`,`view_Num`,`collect_Num`) values 
(1,1,'Ask','http://140.143.16.51/image/cover/a.jpg','AAAAAAAAAAA','http://140.143.16.51/video/v/ant.mp4',80,'游戏','2018-06-22 16:05:05',50,1),
(2,5,'BBdcscs','http://140.143.16.51/image/cover/z.jpg','up主 很懒什么也没有写','http://140.143.16.51/video/v/ant.mp4',30,'动漫','2018-06-22 19:30:30',30,10),
(3,2,'Cds','http://140.143.16.51/image/cover/c.jpg','up主 很懒什么也没有写','http://140.143.16.51/video/v/ant.mp4',60,'音乐','2018-06-22 19:31:58',40,50),
(4,4,'Dds','http://140.143.16.51/image/cover/d.jpg','up主 很懒什么也没有写','http://140.143.16.51/video/v/ant.mp4',0,'生活','2018-06-22 19:35:23',25,0),
(5,1,'EEE','http://140.143.16.51/image/cover/e.jpg','up主 很懒什么也没有写','http://140.143.16.51/video/v/ant.mp4',0,'时尚','2018-06-22 19:37:58',38,0),
(6,3,'AS','http://140.143.16.51/image/cover/f.jpg','up主 很懒什么也没有写','http://140.143.16.51/video/v/ant.mp4',0,'未知','2018-06-22 19:38:55',20,0),
(7,5,'Gdasd','http://140.143.16.51/image/cover/g.jpg','Ada','http://140.143.16.51/video/v/ant.mp4',0,'未知','2018-06-22 19:39:46',24,0),
(8,1,'Awe','http://140.143.16.51/image/cover/h.jpg','AAAAAAAAAAA','http://140.143.16.51/video/v/ant.mp4',80,'游戏','2018-06-22 16:05:05',50,1),
(9,4,'DDa','http://140.143.16.51/image/cover/i.jpg','up主 很懒什么也没有写','http://140.143.16.51/video/v/ant.mp4',0,'生活','2018-06-22 19:35:23',25,0),
(10,1,'EEE','http://140.143.16.51/image/cover/j.jpg','up主 很懒什么也没有写','http://140.143.16.51/video/v/ant.mp4',0,'时尚','2018-06-22 19:37:58',38,0),
(11,3,'AS','http://140.143.16.51/image/cover/k.jpg','up主 很懒什么也没有写','http://140.143.16.51/video/v/ant.mp4',0,'未知','2018-06-22 19:38:55',30,0),
(12,5,'Gdsd','http://140.143.16.51/image/cover/l.jpg','Ada','http://140.143.16.51/video/v/ant.mp4',0,'未知','2018-06-22 19:39:46',20,0),
(13,5,'BBB','http://140.143.16.51/image/cover/m.jpg','up主 很懒什么也没有写','http://140.143.16.51/video/v/ant.mp4',30,'动漫','2018-06-22 19:30:30',30,10),
(14,2,'Cds','http://140.143.16.51/image/cover/n.jpg','up主 很懒什么也没有写','http://140.143.16.51/video/v/ant.mp4',60,'音乐','2018-06-22 19:31:58',40,50),
(15,1,'Aqa','http://140.143.16.51/image/cover/o.jpg','AAAAAAAAAAA','http://140.143.16.51/video/v/ant.mp4',80,'游戏','2018-06-22 16:05:05',50,1),
(16,5,'BBxx','http://140.143.16.51/image/cover/p.jpg','up主 很懒什么也没有写','http://140.143.16.51/video/v/ant.mp4',30,'动漫','2018-06-22 19:30:30',30,10),
(17,2,'Cxz','http://140.143.16.51/image/cover/q.jpg','up主 很懒什么也没有写','http://140.143.16.51/video/v/ant.mp4',60,'音乐','2018-06-22 19:31:58',40,50),
(18,4,'Dsa','https://img02.sogoucdn.com/app/a/100520093/12400ee0679b6e1e-d3e639ff657519ea-a9d4d43a8f00e80cfae6b8f74af91564.jpg','up主 很懒什么也没有写','http://140.143.16.51/video/v/ant.mp4',0,'生活','2018-06-22 19:35:23',25,0),
(19,1,'EEE','https://img02.sogoucdn.com/app/a/100520093/12400ee0679b6e1e-d3e639ff657519ea-a9d4d43a8f00e80cfae6b8f74af91564.jpg','up主 很懒什么也没有写','http://140.143.16.51/video/v/ant.mp4',0,'时尚','2018-06-22 19:37:58',38,0),
(20,3,'AS','https://img02.sogoucdn.com/app/a/100520093/12400ee0679b6e1e-d3e639ff657519ea-a9d4d43a8f00e80cfae6b8f74af91564.jpg','up主 很懒什么也没有写','http://140.143.16.51/video/v/ant.mp4',0,'未知','2018-06-22 19:38:55',21,0),
(21,5,'Gds','https://img02.sogoucdn.com/app/a/100520093/12400ee0679b6e1e-d3e639ff657519ea-a9d4d43a8f00e80cfae6b8f74af91564.jpg','Ada','http://140.143.16.51/video/v/ant.mp4',0,'未知','2018-06-22 19:39:46',20,0);

/*Table structure for table `muscovyplay` */

DROP TABLE IF EXISTS `muscovyplay`;

CREATE TABLE `muscovyplay` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '番剧',
  `name` varchar(20) NOT NULL,
  `image_Url` varchar(50) NOT NULL,
  `video_Url` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `muscovyplay` */

insert  into `muscovyplay`(`id`,`name`,`image_Url`,`video_Url`) values 
(1,'一人之下','A','A'),
(2,'王牌御史','A','A'),
(3,'妖怪名单','A','B');

/*Table structure for table `studio` */

DROP TABLE IF EXISTS `studio`;

CREATE TABLE `studio` (
  `id` int(11) NOT NULL COMMENT '直播间id  与用户id相同',
  `image_Url` varchar(100) NOT NULL COMMENT '封面  url',
  `title` varchar(50) NOT NULL COMMENT '直播间标题',
  `premiere` int(11) NOT NULL COMMENT '是否开播',
  `studio_Url` varchar(100) NOT NULL COMMENT '直播间 url',
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
  `head_Url` varchar(200) NOT NULL DEFAULT 'http://imgsrc.baidu.com/imgad/pic/item/7c1ed21b0ef41bd52a1399d25bda81cb39db3d57.jpg' COMMENT '头像Url',
  `gender` int(11) DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`tel`,`head_Url`,`gender`) values 
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
