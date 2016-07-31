/*
SQLyog Ultimate v8.32 
MySQL - 5.0.96-community-nt : Database - juanjuan
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`juanjuan` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `juanjuan`;

/*Table structure for table `applays` */

DROP TABLE IF EXISTS `applays`;

CREATE TABLE `applays` (
  `AS_ID` int(11) NOT NULL,
  `AS_DATE` datetime NOT NULL,
  `AS_MAN` varchar(20) NOT NULL,
  `AS_STATUS` varchar(20) NOT NULL,
  PRIMARY KEY  (`AS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `applays` */

/*Table structure for table `arrival` */

DROP TABLE IF EXISTS `arrival`;

CREATE TABLE `arrival` (
  `order_id` int(11) NOT NULL,
  `re_id` int(11) NOT NULL,
  `ar_date` datetime NOT NULL,
  `ar_man` varchar(20) NOT NULL,
  `ar_status` varchar(20) NOT NULL,
  KEY `FK_arrival` (`re_id`),
  KEY `FK_arrival1` (`order_id`),
  CONSTRAINT `FK_arrival1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`),
  CONSTRAINT `FK_arrival_reday` FOREIGN KEY (`re_id`) REFERENCES `ready` (`RE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `arrival` */

/*Table structure for table `cangguanz-zl` */

DROP TABLE IF EXISTS `cangguanz-zl`;

CREATE TABLE `cangguanz-zl` (
  `cg_id_zl` int(11) NOT NULL,
  `cg_name_zl` varchar(20) default NULL,
  PRIMARY KEY  (`cg_id_zl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cangguanz-zl` */

insert  into `cangguanz-zl`(`cg_id_zl`,`cg_name_zl`) values (1048,'张三'),(1049,'王五');

/*Table structure for table `company_hyj` */

DROP TABLE IF EXISTS `company_hyj`;

CREATE TABLE `company_hyj` (
  `c_id_hyj` int(11) NOT NULL,
  `c_name_hyj` varchar(20) NOT NULL,
  `c_hyid_hyj` int(11) NOT NULL,
  `c_time_hyj` datetime NOT NULL,
  `c_legal_hyj` varchar(20) NOT NULL,
  PRIMARY KEY  (`c_id_hyj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `company_hyj` */

insert  into `company_hyj`(`c_id_hyj`,`c_name_hyj`,`c_hyid_hyj`,`c_time_hyj`,`c_legal_hyj`) values (0,'暴走雪莉',1001,'2016-06-18 00:00:00','金二思'),(1,'冰雪女巫',1001,'2016-06-20 00:00:00','司桑卓'),(2,'虚空行者',1002,'2016-06-25 00:00:00','卡萨丁'),(3,'圣枪游侠',1003,'2016-06-30 00:00:00','卢锡安'),(4,'蜘蛛女皇',1004,'2016-07-01 00:00:00','伊利斯'),(5,'皮城女警',1005,'2016-07-01 00:00:00','凯特琳'),(7,'皎月女神',1006,'2016-07-01 00:00:00','戴安娜');

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `customer_name` varchar(50) NOT NULL,
  `customer_short` varchar(25) default NULL,
  `hangye_id_gjh` int(11) NOT NULL,
  `customer_address` varchar(100) default NULL,
  `customer` varchar(50) NOT NULL,
  `customer_phone` varchar(20) NOT NULL,
  `customer_email` varchar(20) default NULL,
  `customer_credit` bigint(20) NOT NULL,
  PRIMARY KEY  (`customer_id`),
  KEY `FK_customer` (`hangye_id_gjh`),
  CONSTRAINT `FK_customer` FOREIGN KEY (`hangye_id_gjh`) REFERENCES `hangye` (`hangye_id_gjh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`customer_id`,`customer_name`,`customer_short`,`hangye_id_gjh`,`customer_address`,`customer`,`customer_phone`,`customer_email`,`customer_credit`) values (0,'华威技术有限公司','华为',1001,'陕西省西安市雁塔区','任正非','029—12345678','huawei@163.com',89),(1,'富士康科技集团','富士康',1000,'广东省深圳市宝安区龙华街道东环二路二号富士康科技集团','郭台铭','029-45156423','fushikang@163.com',80),(15,'hhhhhhh','hh',1008,'fdbgd','sdafgvdf','hdsf','fsdavd',67),(40,'kkkkkk','kk',1005,'dbzfg','asrg','fhds','degfrd',67),(52,'bfdbfe','bfev',1007,'sVDfdgb','dfsv','bswdg','dbz',78),(71,'xbzccf','dfbdfrgh',1000,'saeb','def','dbzf','dbf',12),(87,'hhhhh','hh',1007,'dfbgrd','dsf','fdhds','bvgse',78),(95,'ä¹æ¯å®','ÃÂ¥ÃÂ°ÃÂÃÂ¤ÃÂ¹ÃÂ',1003,'ÃÂ¦ÃÂÃÂÃÂ©ÃÂÃÂ³ÃÂ¥ÃÂÃÂº','123456789','987654321','987654321',99);

/*Table structure for table `dd_ck_zl` */

DROP TABLE IF EXISTS `dd_ck_zl`;

CREATE TABLE `dd_ck_zl` (
  `dd_id_zl` int(11) NOT NULL,
  `ck_id_zl` int(11) NOT NULL,
  KEY `FK_dd_ck_zl` (`dd_id_zl`),
  KEY `FK_dd_ck1_zl` (`ck_id_zl`),
  CONSTRAINT `FK_dd_ck1_zl` FOREIGN KEY (`ck_id_zl`) REFERENCES `goout_zl` (`gt_id_zl`),
  CONSTRAINT `FK_dd_ck_zl` FOREIGN KEY (`dd_id_zl`) REFERENCES `order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dd_ck_zl` */

/*Table structure for table `depot_hyj` */

DROP TABLE IF EXISTS `depot_hyj`;

CREATE TABLE `depot_hyj` (
  `d_id_hyj` int(11) NOT NULL auto_increment,
  `d_name_hyj` varchar(20) NOT NULL,
  `d_area_hyj` int(11) NOT NULL,
  `d_type_hyj` varchar(20) NOT NULL,
  `d_addr_hyj` varchar(30) NOT NULL,
  PRIMARY KEY  (`d_id_hyj`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `depot_hyj` */

insert  into `depot_hyj`(`d_id_hyj`,`d_name_hyj`,`d_area_hyj`,`d_type_hyj`,`d_addr_hyj`) values (1,'仓库1',500,'平方库','西安市东七路仓库'),(2,'三相之力',2000,'平房库','德玛西亚'),(3,'无尽之刃',4000,'楼房库','诺克萨斯');

/*Table structure for table `gointo_zl` */

DROP TABLE IF EXISTS `gointo_zl`;

CREATE TABLE `gointo_zl` (
  `go_id_zl` int(11) NOT NULL,
  `cg_id_zl` int(11) NOT NULL,
  `go_date_zl` datetime NOT NULL,
  `go_state` varchar(20) NOT NULL,
  PRIMARY KEY  (`go_id_zl`),
  KEY `FK_gointo_zl` (`cg_id_zl`),
  CONSTRAINT `FK_gointo_zl` FOREIGN KEY (`cg_id_zl`) REFERENCES `cangguanz-zl` (`cg_id_zl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `gointo_zl` */

insert  into `gointo_zl`(`go_id_zl`,`cg_id_zl`,`go_date_zl`,`go_state`) values (3001,1048,'2016-06-18 00:00:00','入库'),(3002,1049,'2016-06-27 00:00:00','未审核');

/*Table structure for table `goout_zl` */

DROP TABLE IF EXISTS `goout_zl`;

CREATE TABLE `goout_zl` (
  `gt_id_zl` int(11) NOT NULL,
  `cg_id_zl` int(11) NOT NULL,
  `dd_id` int(11) NOT NULL,
  `cw_id` int(11) NOT NULL,
  `gt_date_zl` datetime NOT NULL,
  `gt_state_zl` varchar(20) NOT NULL,
  PRIMARY KEY  (`gt_id_zl`),
  KEY `FK_goout_zl` (`cg_id_zl`),
  KEY `FK_cw_zl` (`cw_id`),
  KEY `FK_dd_zl` (`dd_id`),
  CONSTRAINT `FK_cw_zl` FOREIGN KEY (`cw_id`) REFERENCES `seat_hyj` (`s_id_hyj`),
  CONSTRAINT `FK_dd_zl` FOREIGN KEY (`dd_id`) REFERENCES `order` (`order_id`),
  CONSTRAINT `FK_goout_zl` FOREIGN KEY (`cg_id_zl`) REFERENCES `cangguanz-zl` (`cg_id_zl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goout_zl` */

/*Table structure for table `hangye` */

DROP TABLE IF EXISTS `hangye`;

CREATE TABLE `hangye` (
  `hangye_id_gjh` int(11) NOT NULL,
  `hangye_name_gjh` varchar(50) default NULL,
  PRIMARY KEY  (`hangye_id_gjh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hangye` */

insert  into `hangye`(`hangye_id_gjh`,`hangye_name_gjh`) values (1000,'农业'),(1001,'计算机服务业'),(1002,'建筑安装业'),(1003,'金融业'),(1004,'通信设备制造'),(1005,'工业'),(1006,'制造业'),(1007,'纺织业'),(1008,'金属制品业');

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `order_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `order_type` varchar(20) NOT NULL,
  `order_baoguan` varchar(20) NOT NULL,
  `pay_type` varchar(20) NOT NULL,
  `order_status` varchar(20) NOT NULL,
  `order_date` datetime NOT NULL,
  `tihuo_date` datetime NOT NULL,
  `tihuo_type` varchar(20) NOT NULL,
  `luru_man` varchar(20) NOT NULL,
  `out_address` varchar(50) NOT NULL,
  `order_beizhu` varchar(50) NOT NULL,
  `c_id_hyj` int(11) NOT NULL,
  `caigou_date` datetime NOT NULL,
  `caigou_man` varchar(20) NOT NULL,
  PRIMARY KEY  (`order_id`),
  KEY `FK_order` (`c_id_hyj`),
  KEY `FK_cus_order` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order` */

/*Table structure for table `ordertable` */

DROP TABLE IF EXISTS `ordertable`;

CREATE TABLE `ordertable` (
  `order_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `order_type` varchar(20) NOT NULL,
  `order_baoguan` varchar(20) NOT NULL,
  `pay_type` varchar(20) NOT NULL,
  `order_status` varchar(20) NOT NULL,
  `order_date` varchar(50) NOT NULL,
  `tihuo_date` varchar(50) NOT NULL,
  `tihuo_type` varchar(20) default NULL,
  `luru_man` varchar(20) NOT NULL,
  `out_address` varchar(50) default NULL,
  `order_beizhu` varchar(50) default NULL,
  `c_id_hyj` int(11) default NULL,
  `caigou_date` datetime default NULL,
  `caigou_man` varchar(20) default NULL,
  PRIMARY KEY  (`order_id`),
  KEY `FK_order` (`c_id_hyj`),
  KEY `FK_cus_order` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ordertable` */

insert  into `ordertable`(`order_id`,`customer_id`,`order_type`,`order_baoguan`,`pay_type`,`order_status`,`order_date`,`tihuo_date`,`tihuo_type`,`luru_man`,`out_address`,`order_beizhu`,`c_id_hyj`,`caigou_date`,`caigou_man`) values (0,0,'国内','自报','预付','待签收','2015-07-07 00:00:00','2015-07-09 00:00:00','自提','伊泽瑞尔','西安','备注...',7,'2015-07-06 00:00:00','雎尔'),(1,1,'国外','自报','预付','待签收','2015-07-07 00:00:00','2015-07-07 00:00:00','自提','随便叫吧','杭州','备注2...',0,'2015-07-07 00:00:00','蒹葭'),(3,0,'国外','自报','预付','待签收','2015-07-07 00:00:00','2015-07-07 00:00:00','自提','乱七八糟','扬州','备注3...',1,'2015-07-07 00:00:00','白露'),(26,26,'bbbbbbbb','ccccccc','dddddddd','rrrrrrr','20170707','20170707',NULL,'hhhhhhhhh',NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `product_check` */

DROP TABLE IF EXISTS `product_check`;

CREATE TABLE `product_check` (
  `pc_id` int(11) NOT NULL auto_increment,
  `pc_seatid` int(11) NOT NULL,
  `pc_man` int(11) NOT NULL,
  `pc_date` datetime NOT NULL,
  `pc_number` int(11) default NULL,
  PRIMARY KEY  (`pc_id`),
  KEY `FK_product_check` (`pc_man`),
  KEY `FK_product_check_seat` (`pc_seatid`),
  CONSTRAINT `FK_product_check` FOREIGN KEY (`pc_man`) REFERENCES `cangguanz-zl` (`cg_id_zl`),
  CONSTRAINT `FK_product_check_seat` FOREIGN KEY (`pc_seatid`) REFERENCES `seat_hyj` (`s_id_hyj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product_check` */

/*Table structure for table `product_reject` */

DROP TABLE IF EXISTS `product_reject`;

CREATE TABLE `product_reject` (
  `pr_id` int(11) NOT NULL auto_increment,
  `pr_man` int(11) NOT NULL,
  `pr_date` datetime NOT NULL,
  `pr_reason` text NOT NULL,
  PRIMARY KEY  (`pr_id`),
  KEY `FK_product_reject` (`pr_man`),
  CONSTRAINT `FK_product_reject` FOREIGN KEY (`pr_man`) REFERENCES `cangguanz-zl` (`cg_id_zl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product_reject` */

/*Table structure for table `ready` */

DROP TABLE IF EXISTS `ready`;

CREATE TABLE `ready` (
  `RE_ID` int(11) NOT NULL,
  `RE_DATE` datetime NOT NULL,
  `RE_MAN` varchar(20) NOT NULL,
  PRIMARY KEY  (`RE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ready` */

/*Table structure for table `regions_hyj` */

DROP TABLE IF EXISTS `regions_hyj`;

CREATE TABLE `regions_hyj` (
  `r_id_hyj` int(11) NOT NULL auto_increment,
  `r_name_hyj` varchar(20) NOT NULL,
  `r_did_hyj` int(11) NOT NULL,
  `r_area_hyj` int(11) NOT NULL,
  PRIMARY KEY  (`r_id_hyj`),
  KEY `FK_regions_hyj` (`r_did_hyj`),
  CONSTRAINT `FK_regions_hyj` FOREIGN KEY (`r_did_hyj`) REFERENCES `depot_hyj` (`d_id_hyj`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `regions_hyj` */

insert  into `regions_hyj`(`r_id_hyj`,`r_name_hyj`,`r_did_hyj`,`r_area_hyj`) values (1,'区域1',1,100),(2,'水银弯刀',2,150),(3,'冰霜之锤',2,350),(4,'中亚沙漏',2,200);

/*Table structure for table `seat_hyj` */

DROP TABLE IF EXISTS `seat_hyj`;

CREATE TABLE `seat_hyj` (
  `s_id_hyj` int(11) NOT NULL,
  `s_name_hyj` varchar(20) NOT NULL,
  `s_rid_hyj` int(11) NOT NULL,
  `s_area` int(11) NOT NULL,
  PRIMARY KEY  (`s_id_hyj`),
  KEY `FK_seat_hyj` (`s_rid_hyj`),
  CONSTRAINT `FK_seat_hyj` FOREIGN KEY (`s_rid_hyj`) REFERENCES `regions_hyj` (`r_id_hyj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `seat_hyj` */

insert  into `seat_hyj`(`s_id_hyj`,`s_name_hyj`,`s_rid_hyj`,`s_area`) values (1,'仓位1',1,50),(2,'兰顿之照',2,70),(3,'冥火之用',2,50),(4,'时光纸张',2,30);

/*Table structure for table `seat_pro` */

DROP TABLE IF EXISTS `seat_pro`;

CREATE TABLE `seat_pro` (
  `sp_seatid` int(11) NOT NULL,
  `sp_proid` int(11) NOT NULL,
  KEY `FK_seat_pro` (`sp_seatid`),
  KEY `FK_seat_pro_1` (`sp_proid`),
  CONSTRAINT `FK_seat_pro` FOREIGN KEY (`sp_seatid`) REFERENCES `seat_hyj` (`s_id_hyj`),
  CONSTRAINT `FK_seat_pro_1` FOREIGN KEY (`sp_proid`) REFERENCES `wuliao` (`wuliao_id_gjh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `seat_pro` */

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `su_id` double default NULL,
  `su_name` varchar(60) default NULL,
  `su_roleid` double default NULL,
  `su_pass` varchar(60) default NULL,
  `state` double default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`su_id`,`su_name`,`su_roleid`,`su_pass`,`state`) values (1,'admin',1000,'admin',1),(3,'cangguan',1001,'cangguan',1),(4,'fff',1000,'fdffd',1),(5,'rtfgvg',10004,'dfdsfsa',0),(6,'gggg',10254,'fgfg',1),(8,'gg',45625,'ffgggre',1),(10,'pooi',10111,'jjjj',1),(11,'ddd',1000,'c',0),(13,'cdc',333,'ded',0),(15,'ffff',1004,'fsdaf',0),(22,'ffdf',1004,NULL,1),(25,'fdf',1001,NULL,1),(26,'ghjk',1004,NULL,1),(29,'wer',1004,NULL,1),(41,'gggg',1000,NULL,1),(45,'fgyjh00',1001,NULL,1),(185,'fdsa',1000,NULL,1),(1111,'dfsf',1000,NULL,1);

/*Table structure for table `wl_rk_zl` */

DROP TABLE IF EXISTS `wl_rk_zl`;

CREATE TABLE `wl_rk_zl` (
  `wl_id_zl` int(11) default NULL,
  `go_id_zl` int(11) default NULL,
  KEY `FK_wl_rk_zl` (`wl_id_zl`),
  KEY `FK_go_rk_zl` (`go_id_zl`),
  CONSTRAINT `FK_go_rk_zl` FOREIGN KEY (`go_id_zl`) REFERENCES `gointo_zl` (`go_id_zl`),
  CONSTRAINT `FK_wl_rk_zl` FOREIGN KEY (`wl_id_zl`) REFERENCES `wuliao` (`wuliao_id_gjh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wl_rk_zl` */

insert  into `wl_rk_zl`(`wl_id_zl`,`go_id_zl`) values (10001,3001),(10000,3001);

/*Table structure for table `wuliao` */

DROP TABLE IF EXISTS `wuliao`;

CREATE TABLE `wuliao` (
  `wuliao_id_gjh` int(11) NOT NULL,
  `wuliao_name_gjh` varchar(50) NOT NULL,
  `wuliao_norms_gjh` varchar(50) default NULL,
  `wuliao_weight_gjh` double NOT NULL,
  `wuliao_unit_gjh` varchar(20) NOT NULL,
  `wuliao_volume_gjh` double NOT NULL,
  `wuliao_count_gjh` int(11) NOT NULL,
  PRIMARY KEY  (`wuliao_id_gjh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wuliao` */

insert  into `wuliao`(`wuliao_id_gjh`,`wuliao_name_gjh`,`wuliao_norms_gjh`,`wuliao_weight_gjh`,`wuliao_unit_gjh`,`wuliao_volume_gjh`,`wuliao_count_gjh`) values (10000,'无尽','1024*2',50,'个',30,25),(10001,'帽子','1024*8',30,'个',12,30);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
