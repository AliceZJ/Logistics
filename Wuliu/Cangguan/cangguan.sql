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
  `AS_ID` bigint(20) NOT NULL,
  `AS_DATE` datetime NOT NULL,
  `AS_MAN` varchar(20) NOT NULL,
  `AS_STATUS` varchar(20) NOT NULL,
  PRIMARY KEY  (`AS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `applays` */

/*Table structure for table `cangguan_zl` */

DROP TABLE IF EXISTS `cangguan_zl`;

CREATE TABLE `cangguan_zl` (
  `cg_id_zl` int(11) NOT NULL,
  `cg_name_zl` varchar(20) default NULL,
  PRIMARY KEY  (`cg_id_zl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cangguan_zl` */

insert  into `cangguan_zl`(`cg_id_zl`,`cg_name_zl`) values (1048,'张三'),(1049,'王五'),(1050,'赵六'),(1051,'李四');

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

insert  into `customer`(`customer_id`,`customer_name`,`customer_short`,`hangye_id_gjh`,`customer_address`,`customer`,`customer_phone`,`customer_email`,`customer_credit`) values (0,'华威技术有限公司','华为',1001,'陕西省西安市雁塔区','任正非','029—12345678','huawei@163.com',89);

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
  `go_date_zl` date NOT NULL,
  `go_state` varchar(20) NOT NULL,
  PRIMARY KEY  (`go_id_zl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `gointo_zl` */

insert  into `gointo_zl`(`go_id_zl`,`cg_id_zl`,`go_date_zl`,`go_state`) values (3001,1050,'2016-07-07','ruku'),(3002,1048,'2016-07-06','ruku'),(3003,1049,'2016-07-06','shenhe'),(3004,1049,'2016-07-06','shenhe');

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
  KEY `FK_dd_zl` (`dd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goout_zl` */

insert  into `goout_zl`(`gt_id_zl`,`cg_id_zl`,`dd_id`,`cw_id`,`gt_date_zl`,`gt_state_zl`) values (4001,1048,1001,1,'2016-07-02 00:00:00','chuku'),(4002,1050,1001,2,'2016-07-07 00:00:00','shenhe'),(4003,1051,1002,1001,'2016-07-07 00:00:00','xinjian');

/*Table structure for table `hangye` */

DROP TABLE IF EXISTS `hangye`;

CREATE TABLE `hangye` (
  `hangye_id_gjh` int(11) NOT NULL,
  `hangye_name_gjh` varchar(50) default NULL,
  PRIMARY KEY  (`hangye_id_gjh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hangye` */

insert  into `hangye`(`hangye_id_gjh`,`hangye_name_gjh`) values (1000,'农业'),(1001,'计算机服务业'),(1002,'建筑安装业'),(1003,'金融业'),(1004,'通信设备制造'),(1005,'工业'),(1006,'制造业'),(1007,'纺织业'),(1008,'金属制品业');

/*Table structure for table `order_zj` */

DROP TABLE IF EXISTS `order_zj`;

CREATE TABLE `order_zj` (
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
  KEY `FK_cus_order` (`customer_id`),
  CONSTRAINT `FK_cus_order` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `FK_order` FOREIGN KEY (`c_id_hyj`) REFERENCES `company_hyj` (`c_id_hyj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order_zj` */

insert  into `order_zj`(`order_id`,`customer_id`,`order_type`,`order_baoguan`,`pay_type`,`order_status`,`order_date`,`tihuo_date`,`tihuo_type`,`luru_man`,`out_address`,`order_beizhu`,`c_id_hyj`,`caigou_date`,`caigou_man`) values (1001,0,'网上','1','在线','已支付','2016-05-01 00:00:00','2016-05-07 00:00:00','自提','张三','西安','无',1,'2016-05-02 00:00:00','莉莉丝'),(1002,0,'自营','1','现金','以支付','2016-05-07 00:00:00','2016-05-11 00:00:00','送货','李四','山西','无',1,'2016-05-08 00:00:00','艾莉');

/*Table structure for table `pro_num_che` */

DROP TABLE IF EXISTS `pro_num_che`;

CREATE TABLE `pro_num_che` (
  `pc_id` int(11) NOT NULL auto_increment,
  `pc_sname` varchar(20) default NULL,
  `pc_sid` int(11) default NULL,
  `pc_pname` varchar(20) default NULL,
  `pc_pid` int(11) default NULL,
  `pc_num` int(11) default NULL,
  PRIMARY KEY  (`pc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `pro_num_che` */

insert  into `pro_num_che`(`pc_id`,`pc_sname`,`pc_sid`,`pc_pname`,`pc_pid`,`pc_num`) values (5,'仓库1',1,'无尽',1000,67),(6,'兰顿之照',2,'帽子',1001,0),(7,'冥光之用',3,'无尽',1000,67),(8,'时光纸张',4,'帽子',1001,0);

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
  CONSTRAINT `FK_product_check` FOREIGN KEY (`pc_man`) REFERENCES `cangguan_zl` (`cg_id_zl`),
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
  CONSTRAINT `FK_product_reject` FOREIGN KEY (`pr_man`) REFERENCES `cangguan_zl` (`cg_id_zl`)
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
  `sp_id` int(11) NOT NULL auto_increment,
  `sp_seatid` int(11) default NULL,
  `sp_proid` int(11) default NULL,
  `sp_sname` varchar(50) default NULL,
  `sp_pname` varchar(20) default NULL,
  PRIMARY KEY  (`sp_id`),
  KEY `FK_seat_pro` (`sp_seatid`),
  KEY `FK_seat_pro_1` (`sp_proid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `seat_pro` */

insert  into `seat_pro`(`sp_id`,`sp_seatid`,`sp_proid`,`sp_sname`,`sp_pname`) values (1,1,1000,'仓库1','无尽'),(2,2,1001,'兰顿之照','帽子'),(3,3,1000,'冥火之用','无尽'),(4,4,1001,'时光纸张','帽子');

/*Table structure for table `wl_ck_zl` */

DROP TABLE IF EXISTS `wl_ck_zl`;

CREATE TABLE `wl_ck_zl` (
  `wl_id_zl` int(11) NOT NULL,
  `ck_id_zl` int(11) NOT NULL,
  KEY `FK_dd_ck_zl` (`wl_id_zl`),
  KEY `FK_dd_ck1_zl` (`ck_id_zl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wl_ck_zl` */

insert  into `wl_ck_zl`(`wl_id_zl`,`ck_id_zl`) values (10001,4001),(10000,4001),(10003,4001),(10004,4002),(10005,4002);

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

insert  into `wl_rk_zl`(`wl_id_zl`,`go_id_zl`) values (10001,3001),(10000,3001),(10003,3001),(10007,3001),(10008,3001),(10000,3002),(10004,3002),(10005,3002),(10000,3003),(10001,3003),(10004,3003),(10005,3004),(10007,3004),(10008,3004),(10003,3004),(10003,3003);

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

insert  into `wuliao`(`wuliao_id_gjh`,`wuliao_name_gjh`,`wuliao_norms_gjh`,`wuliao_weight_gjh`,`wuliao_unit_gjh`,`wuliao_volume_gjh`,`wuliao_count_gjh`) values (10000,'无尽','1024*2',50,'个',30,25),(10001,'帽子','1024*8',30,'个',12,30),(10003,'中亚','1024*6',25,'个',28,260),(10004,'权杖','1024*2',50,'个',30,100),(10005,'女妖','1024*4',20,'个',35,150),(10007,'红叉','1024*8',30,'个',20,205),(10008,'三相','1024*10',40,'个',25,210);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
