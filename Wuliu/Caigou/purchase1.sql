/*
SQLyog Ultimate v8.32 
MySQL - 5.0.96-community-nt : Database - purchase1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`purchase1` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `purchase1`;

/*Table structure for table `applays` */

DROP TABLE IF EXISTS `applays`;

CREATE TABLE `applays` (
  `AS_ID` varchar(20) NOT NULL,
  `AS_DATE` datetime NOT NULL,
  `AS_MAN` varchar(20) NOT NULL,
  `AS_STATUS` varchar(20) default NULL,
  `achieve_date` datetime default NULL,
  `beizhu` varchar(30) default NULL,
  PRIMARY KEY  (`AS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `applays` */

insert  into `applays`(`AS_ID`,`AS_DATE`,`AS_MAN`,`AS_STATUS`,`achieve_date`,`beizhu`) values ('AS00001','2016-07-01 16:05:56','caigou','未审核','2016-07-01 16:05:56','按时完成任务'),('AS00002','2014-06-14 00:00:00','caigou','已审核','2016-07-01 16:05:57','按时完成任务'),('AS00003','2014-06-14 00:00:00','caigou','已审核','2016-07-01 16:05:57','按时完成任务'),('AS06125','2016-07-09 00:00:00','caigou','待审核','2016-07-10 00:00:00','0'),('AS69468','2016-07-05 00:00:00','caigou','待审核','2016-07-06 00:00:00','1');

/*Table structure for table `arrival` */

DROP TABLE IF EXISTS `arrival`;

CREATE TABLE `arrival` (
  `order_id` bigint(20) NOT NULL,
  `re_id` bigint(20) NOT NULL,
  `ar_date` datetime NOT NULL,
  `ar_man` varchar(20) NOT NULL,
  `ar_status` varchar(20) NOT NULL,
  KEY `FK_arrival` (`re_id`),
  CONSTRAINT `FK_arrival` FOREIGN KEY (`re_id`) REFERENCES `ready` (`RE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `arrival` */

/*Table structure for table `purchase` */

DROP TABLE IF EXISTS `purchase`;

CREATE TABLE `purchase` (
  `pur_id` int(11) NOT NULL,
  `pur_com` varchar(20) default NULL,
  `pur_date` datetime default NULL,
  `pur_man` varchar(20) default NULL,
  `pur_status` varchar(20) default NULL,
  `pur_date1` datetime default NULL,
  PRIMARY KEY  (`pur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `purchase` */

insert  into `purchase`(`pur_id`,`pur_com`,`pur_date`,`pur_man`,`pur_status`,`pur_date1`) values (1000,'华为','2016-07-01 16:07:29','caigou','发送','2016-07-01 16:07:29'),(1001,'华为','2015-07-01 16:07:29','caigou','未发送/未接收','2016-07-01 16:07:29'),(1002,'华为','2014-06-14 00:00:00','caigou','已接收','2014-06-14 00:00:00');

/*Table structure for table `ready` */

DROP TABLE IF EXISTS `ready`;

CREATE TABLE `ready` (
  `RE_ID` bigint(20) NOT NULL,
  `RE_DATE` datetime NOT NULL,
  `RE_MAN` varchar(20) NOT NULL,
  PRIMARY KEY  (`RE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ready` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
