/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.26 : Database - 2023_2_13course
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`2023_2_13course` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `2023_2_13course`;

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `OrderID` int NOT NULL AUTO_INCREMENT,
  `UserID` int DEFAULT NULL,
  `RoomID` int DEFAULT NULL,
  `Days` int DEFAULT NULL,
  PRIMARY KEY (`OrderID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `orders` */

insert  into `orders`(`OrderID`,`UserID`,`RoomID`,`Days`) values 
(1,99999999,12023,998);

/*Table structure for table `rooms` */

DROP TABLE IF EXISTS `rooms`;

CREATE TABLE `rooms` (
  `RoomID` int NOT NULL,
  `Storey` int DEFAULT NULL,
  `RoomCategory` varchar(100) DEFAULT NULL,
  `RoomInfo` text,
  `RoomClass` varchar(20) DEFAULT NULL,
  `Price` float DEFAULT NULL,
  PRIMARY KEY (`RoomID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `rooms` */

insert  into `rooms`(`RoomID`,`Storey`,`RoomCategory`,`RoomInfo`,`RoomClass`,`Price`) values 
(1001,1,'Single Room',NULL,'Normal',1085),
(1002,1,'Single Room',NULL,'Class',750),
(1003,1,'Double Room',NULL,'Normal',1800),
(1004,1,'Double Room',NULL,'Cheap',1400),
(2001,2,'Triple Room',NULL,'Normal',2200),
(2002,2,'Single Room',NULL,'Class',750),
(2003,2,'Single Room',NULL,'Class',755),
(2004,2,'Double Room',NULL,'Class',1505),
(2005,2,'Double Room',NULL,'Normal',1855),
(2006,2,'Single Room',NULL,'Class',725),
(3002,3,'Trible Room',NULL,'Normal',2250),
(3003,3,'Single Room',NULL,'Normal',1105),
(3004,3,'Extravagant Suite',NULL,'Special',5800),
(3005,3,'Extravagant Suite',NULL,'Special',7200),
(4001,4,'Single Room',NULL,'Normal',1200),
(4002,4,'Double Room',NULL,'Normal',2200),
(4003,4,'Double Room',NULL,'Normal',2200),
(4004,4,'Single Room',NULL,'Normal',1200),
(4005,4,'Single Room',NULL,'Normal',1200),
(4006,4,'Single Room',NULL,'Normal',1200),
(5001,5,'Double Room',NULL,'Normal',2200),
(5002,5,'Single Room',NULL,'Normal',1200),
(9001,9,'Extravagant Suite',NULL,'Special',8700),
(9010,9,'Extravagant Suite',NULL,'Special',9500),
(9022,9,'Extravagant Suite',NULL,'Special',9000),
(9023,9,'President Suite',NULL,'Ultimate',11000),
(10017,10,'President Suite',NULL,'Ultimate',12000),
(12023,12,'President Suite',NULL,'Ultimate',18000);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `UserName` varchar(100) DEFAULT NULL,
  `UserPassword` varchar(100) DEFAULT NULL,
  `Identify` varchar(20) DEFAULT NULL,
  `Info` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=100000002 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `users` */

insert  into `users`(`ID`,`UserName`,`UserPassword`,`Identify`,`Info`) values 
(1,'name','pwd','1','1'),
(2,'ss','','',''),
(20,'admin','admin','admin','admin'),
(21,'ff','ff','First','First People! Unique Identify!'),
(22,'sd','21',NULL,NULL),
(115,'admin2','admin','',''),
(116,'n','p','i',NULL),
(117,'n2','p','i',NULL),
(7777,'ss','','',''),
(2420439,'MERCURY_9ED2','222','User',NULL),
(30266276,'Metallica','metallica','Vip3','This is the Most Famous Metal Band---Metallica!!!'),
(93933340,'Megadeth','megadeth','Vip3',NULL),
(97050671,'Slayer','slayer','Vip3','This is a famous Thrash Metal Band---SSSSSSLLLLLLLLLLLLAAAAAAAAAYYYYYYYYYEEEEEEEEERRRRRRRRR!!!!!!!'),
(99999999,'Special Guest','President','Special Guest','This is a Special Guest! Please pay attention to the safty!');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
