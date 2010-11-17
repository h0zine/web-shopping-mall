/*
SQLyog Ultimate v8.55 
MySQL - 5.1.50-community : Database - store
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`store` /*!40100 DEFAULT CHARACTER SET euckr COLLATE euckr_bin */;

USE `store`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(120) CHARACTER SET euckr DEFAULT NULL,
  `category_depth` int(11) NOT NULL,
  `category_parent` int(11) NOT NULL,
  `category_order` int(11) NOT NULL,
  `category_thread` int(11) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

/*Data for the table `category` */

insert  into `category`(`category_id`,`category_name`,`category_depth`,`category_parent`,`category_order`,`category_thread`) values (2,'Rock fishing',0,0,0,2),(10,'Fishing Rod',1,2,1,2),(5,'Boat Fishing',0,0,0,5),(13,'Korean Style',2,10,2,2),(23,'Expert',3,13,3,2),(17,'Beginner',3,13,4,2),(21,'Lure Fishing',0,0,0,21),(22,'Accessories',0,0,0,22);

/*Table structure for table `event` */

DROP TABLE IF EXISTS `event`;

CREATE TABLE `event` (
  `event_id` int(11) NOT NULL AUTO_INCREMENT,
  `event_name` varchar(120) NOT NULL,
  `event_order` int(11) NOT NULL,
  PRIMARY KEY (`event_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `event` */

insert  into `event`(`event_id`,`event_name`,`event_order`) values (2,'test event 2',0),(3,'test event 1',0),(4,'test event 3',0);

/*Table structure for table `feedback` */

DROP TABLE IF EXISTS `feedback`;

CREATE TABLE `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) DEFAULT NULL,
  `writer_name` varchar(80) DEFAULT NULL,
  `writer_id` varchar(80) DEFAULT NULL,
  `comment` text,
  `point` int(11) DEFAULT NULL,
  `reg_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=euckr;

/*Data for the table `feedback` */

insert  into `feedback`(`id`,`item_id`,`writer_name`,`writer_id`,`comment`,`point`,`reg_date`) values (1,1,'buyer','buyer_id','Very light and strong. This is very good rod for almost every purpose of fishing',2,'2010-11-06');

/*Table structure for table `invoice` */

DROP TABLE IF EXISTS `invoice`;

CREATE TABLE `invoice` (
  `invoice_id` int(11) NOT NULL AUTO_INCREMENT,
  `issue_date` date DEFAULT NULL,
  `last_update` date DEFAULT NULL,
  `buyer_id` varchar(30) DEFAULT NULL,
  `buyer_name` varchar(50) DEFAULT NULL,
  `buyer_email` varchar(50) DEFAULT NULL,
  `buyer_phone` varchar(20) DEFAULT NULL,
  `receiver_name` varchar(50) DEFAULT NULL,
  `receiver_email` varchar(50) DEFAULT NULL,
  `receiver_phone` varchar(20) DEFAULT NULL,
  `postcode` varchar(10) DEFAULT NULL,
  `address1` varchar(80) DEFAULT NULL,
  `address2` varchar(80) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `country` varchar(30) DEFAULT NULL,
  `product_cost` varchar(10) DEFAULT NULL,
  `delivery_cost` varchar(10) DEFAULT NULL,
  `paymethod` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `memo` text,
  PRIMARY KEY (`invoice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=euckr;

/*Data for the table `invoice` */

insert  into `invoice`(`invoice_id`,`issue_date`,`last_update`,`buyer_id`,`buyer_name`,`buyer_email`,`buyer_phone`,`receiver_name`,`receiver_email`,`receiver_phone`,`postcode`,`address1`,`address2`,`state`,`country`,`product_cost`,`delivery_cost`,`paymethod`,`status`,`memo`) values (1,'2010-10-11','2010-10-11','buyer_id','buyer_name','buyer_email','buyer_phone','receiver_name','receiver_email','receiver_phone','2232','address 1','address 2','NSW',NULL,'20000','10.00','card','payed','memo'),(40,'2010-11-02','2010-11-02',NULL,NULL,NULL,'0423','Betti','ksy@gmail','0433','2000','146','Sydney','NSW',NULL,NULL,NULL,NULL,'Received',NULL),(41,'2010-11-02','2010-11-02',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(42,'2010-11-02','2010-11-02',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(43,'2010-11-02','2010-11-02',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(44,'2010-11-02','2010-11-02',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(45,'2010-11-02','2010-11-02','','??¸§','??¸Þ??','???­¹ø??','name','email','phone',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'card',NULL,'1000'),(46,'2010-11-02','2010-11-02','','??¸§','??¸Þ??','???­¹ø??','name','email','phone',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'card',NULL,'1000'),(47,'2010-11-02','2010-11-02','','2','2','2','3','3','3','3','3','3','3',NULL,NULL,NULL,'4',NULL,'4'),(48,'2010-11-02','2010-11-02','','name','nemail','n','n','n','n','11','addr1','addr2','nsw',NULL,'2020','100','1',NULL,'1'),(49,'2010-11-02','2010-11-02','n','n','n','n','n','n','n','n','n','n','n',NULL,'2020','100','n',NULL,'n'),(50,'2010-11-04','2010-11-04',NULL,NULL,'n','n','k','k','k','k','k','k','k',NULL,NULL,NULL,NULL,'Posted',NULL),(51,'2010-11-03','2010-11-03','','','','','','','','','','','',NULL,'2020','100','',NULL,''),(52,'2010-11-03','2010-11-03','','','','','','','','','','','',NULL,'2020','100','',NULL,''),(53,'2010-11-03','2010-11-03','','','','','','','','','','','',NULL,'2020','100','',NULL,''),(54,'2010-11-03','2010-11-03','','','','','','','','','','','',NULL,'2020','100','',NULL,''),(55,'2010-11-03','2010-11-03','n','n','n','n','n','n','n','n','n','n','n',NULL,'1010','100','n',NULL,'n'),(56,'2010-11-03','2010-11-03','n','n','n','n','n','n','n','n','n','n','n',NULL,'2020','100','n',NULL,'n'),(57,'2010-11-04','2010-11-04','n','n','e','p','n','e','p','p','a1','a2','s',NULL,'1010','100','p',NULL,'m'),(58,'2010-11-05','2010-11-05',',','','','','','','','','','','',NULL,'2020','100','',NULL,''),(59,'2010-11-05','2010-11-05',',22','name','email','11','name','email','11','22','addr1','addr2','nsw',NULL,'10000','100','card',NULL,'asdf');

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(120) CHARACTER SET latin1 NOT NULL,
  `price` int(11) NOT NULL,
  `description` text NOT NULL,
  `picture_url` varchar(120) CHARACTER SET latin1 NOT NULL,
  `visit` int(11) NOT NULL DEFAULT '0',
  `sold` int(11) NOT NULL DEFAULT '0',
  `amount` int(11) NOT NULL DEFAULT '0',
  `last_sold` datetime NOT NULL,
  `last_visit` datetime NOT NULL,
  `last_update` datetime NOT NULL,
  `category_id_1` int(11) NOT NULL,
  `category_id_2` int(11) NOT NULL,
  `category_id_3` int(11) NOT NULL,
  `event_id_1` int(11) NOT NULL,
  `event_id_2` int(11) NOT NULL,
  `event_id_3` int(11) NOT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=euckr;

/*Data for the table `item` */

insert  into `item`(`item_id`,`item_name`,`price`,`description`,`picture_url`,`visit`,`sold`,`amount`,`last_sold`,`last_visit`,`last_update`,`category_id_1`,`category_id_2`,`category_id_3`,`event_id_1`,`event_id_2`,`event_id_3`) values (1,'Type 1',1010,'dsadf','/store/thumbs/thumb8.jpg',0,0,10,'2010-10-05 00:00:00','2010-10-05 00:00:00','2010-10-05 00:00:00',23,0,0,2,3,0),(2,'Product Ver.2',10000,'asfasdfsadfasdfsadf\r\nasfsadfsaf\r\nsdfsadf\r\n<b>afasdf</b>','/store/thumbs/thumb7.jpg',0,0,1,'2010-11-04 00:00:00','2010-11-04 00:00:00','2010-11-04 00:00:00',2,17,0,2,3,4);

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `content` text,
  `reg_date` date DEFAULT NULL,
  `popup` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=euckr;

/*Data for the table `notice` */

insert  into `notice`(`notice_id`,`title`,`content`,`reg_date`,`popup`) values (2,'title','content','2010-10-16',0),(3,'title','content','2010-10-16',0),(5,'123asdfsadfasdfsadfa','<S>test</S>','2010-11-05',0),(6,'2222','<s>asdfasdf</s>','2010-11-04',0);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `invoice_id` int(11) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  `product_name` varchar(200) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `last_update` date DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=euckr;

/*Data for the table `orders` */

insert  into `orders`(`order_id`,`invoice_id`,`item_id`,`product_name`,`amount`,`price`,`status`,`create_date`,`last_update`) values (1,1,3,'product_name..',1000,'payed','payed','2010-10-11','2010-10-12'),(2,50,NULL,'product',1,'1010','CART','2010-11-01','2010-11-01'),(3,50,NULL,'product',1,'1010','CART','2010-11-01','2010-11-01'),(4,50,NULL,'product',1,'1010','CART','2010-11-01','2010-11-01'),(5,50,NULL,'product',1,'1010','CART','2010-11-01','2010-11-01'),(6,50,NULL,'product',1,'1010','CART','2010-11-01','2010-11-01'),(7,50,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(8,50,NULL,'product',2,'1010','CART','2010-11-02','2010-11-02'),(9,50,NULL,'product',2,'1010','CART','2010-11-02','2010-11-02'),(10,50,NULL,'product',10,'1010','CART','2010-11-02','2010-11-02'),(11,50,NULL,'product',10,'1010','CART','2010-11-02','2010-11-02'),(12,50,NULL,'product',10,'1010','CART','2010-11-02','2010-11-02'),(13,50,NULL,'product',10,'1010','CART','2010-11-02','2010-11-02'),(14,50,NULL,'product',10,'1010','CART','2010-11-02','2010-11-02'),(15,50,NULL,'product',10,'1010','CART','2010-11-02','2010-11-02'),(16,50,NULL,'product',10,'1010','CART','2010-11-02','2010-11-02'),(17,50,NULL,'product',10,'1010','CART','2010-11-02','2010-11-02'),(18,50,NULL,'product',10,'1010','CART','2010-11-02','2010-11-02'),(19,50,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(20,22,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(21,23,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(22,24,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(23,25,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(24,26,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(25,27,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(26,28,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(27,29,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(28,30,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(29,31,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(30,32,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(31,33,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(32,34,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(33,35,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(34,36,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(35,37,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(36,38,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(37,39,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(38,40,NULL,'product',1,'1010','Prepared','2010-11-02','2010-11-04'),(39,41,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(40,42,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(41,43,NULL,'product',1,'1010','Prepared','2010-11-02','2010-11-04'),(42,44,NULL,'product',1,'1010','CART','2010-11-02','2010-11-02'),(43,45,NULL,'product',12,'1010','CART','2010-11-02','2010-11-02'),(44,46,NULL,'product',12,'1010','CART','2010-11-02','2010-11-02'),(45,47,NULL,'product',2,'1010','CART','2010-11-02','2010-11-02'),(46,48,NULL,'product',2,'1010','CART','2010-11-02','2010-11-02'),(47,49,NULL,'product',2,'1010','CART','2010-11-02','2010-11-02'),(48,50,NULL,'product',2,'1010','CART','2010-11-03','2010-11-03'),(49,51,NULL,'product',2,'1010','CART','2010-11-03','2010-11-03'),(50,52,NULL,'product',2,'1010','CART','2010-11-03','2010-11-03'),(51,53,NULL,'product',2,'1010','CART','2010-11-03','2010-11-03'),(52,54,NULL,'product',2,'1010','CART','2010-11-03','2010-11-03'),(53,55,NULL,'product',1,'1010','CART','2010-11-03','2010-11-03'),(54,56,NULL,'product',2,'1010','CART','2010-11-03','2010-11-03'),(55,57,NULL,'product',1,'1010','CART','2010-11-04','2010-11-04'),(56,58,NULL,'product',2,'1010','CART','2010-11-05','2010-11-05'),(57,59,NULL,'Product Ver.2',1,'10000','CART','2010-11-05','2010-11-05');

/*Table structure for table `qna` */

DROP TABLE IF EXISTS `qna`;

CREATE TABLE `qna` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `thread` int(11) DEFAULT NULL,
  `depth` int(11) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `writer_name` varchar(80) DEFAULT NULL,
  `writer_id` varchar(80) DEFAULT NULL,
  `reg_date` date DEFAULT NULL,
  `visit` int(11) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `content` text,
  `passwd` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=euckr;

/*Data for the table `qna` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
