-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: donationdb
-- ------------------------------------------------------
-- Server version	5.5.54-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `id_country` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id_country`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'EL SALVADOR');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credit_card`
--

DROP TABLE IF EXISTS `credit_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credit_card` (
  `id_credit_card` int(11) NOT NULL AUTO_INCREMENT,
  `card_number` varchar(45) DEFAULT NULL,
  `security_code` varchar(100) DEFAULT NULL,
  `expiration_month` varchar(45) DEFAULT NULL,
  `expiration_year` varchar(45) DEFAULT NULL,
  `user_user_name` varchar(45) NOT NULL,
  `credit_card_type_id_credit_card_type` int(11) NOT NULL,
  `owner` varchar(90) NOT NULL,
  PRIMARY KEY (`id_credit_card`),
  KEY `fk_credit_card_user_idx` (`user_user_name`),
  KEY `fk_credit_card_credit_card_type1_idx` (`credit_card_type_id_credit_card_type`),
  CONSTRAINT `fk_credit_card_credit_card_type1` FOREIGN KEY (`credit_card_type_id_credit_card_type`) REFERENCES `credit_card_type` (`id_credit_card_type`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_credit_card_user` FOREIGN KEY (`user_user_name`) REFERENCES `user` (`user_name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit_card`
--

LOCK TABLES `credit_card` WRITE;
/*!40000 ALTER TABLE `credit_card` DISABLE KEYS */;
INSERT INTO `credit_card` VALUES (1,'123-456466-666','$2a$10$xZ9Q/iGdHhWeaRSZPTKIUe5/14rFVvM01UM9n7Vyix86p93vdNgJO','02','2019','jonathang',1,'Jonathan '),(2,'123-343333-333333','$2a$10$pJXziuSWVFltrCNYEMjZFukjLAERnjPTLDSQ7saJXcE071dOLB5hK','02','2020','jonathang',1,'Jonathan Alex'),(3,'122-222222-22222','$2a$10$Z5TsYnTxuv6zaoMX93.3m.TH.e4FOR0gEVvawHh01cnBlJUvaIEFC','01','2019','jonathang',2,'jonathan'),(4,'122-222222-222222','$2a$10$pR3Urv6QfgJJaUoPt882f.WBVpl3bcoSj831HQCxi8WOmXjSroav6','02','2018','jonathang',2,'jonathang1'),(5,'122-333333-333','$2a$10$kFlx9eFweiNa.JV6Ls8ObOxGAqLZvtsUwwY4XfUzCB0MfdMUeqGbW','02','2019','jonathang',2,'jonathang'),(6,'111-111111-111111','MTIzNA==','01','2019','jonathang',2,'jonathang'),(7,'111-111111-111112','MTExMQ==','02','2021','jonathang',2,'jonathang'),(8,'111-666666-666666','NjY2Ng==','02','2020','jonathang',1,'jonathang'),(9,'999-999999-999999','OTk5','03','2020','jonathang',2,'jonathang'),(10,'112-221113-333333','MzMz','03','2020','jonathang',1,'jonathang'),(11,'000-000000-000000','MDAw','07','2023','jonathang',1,'jonathan Guardado'),(12,'000-000011-111111','MDEwMQ==','01','2018','jonathang',2,'jonathang'),(13,'122-212255-555555','NTU1','04','2020','jonathang',2,'Jonathan'),(14,'888-888888-888888','ODg4','02','2020','jonathang',2,'jonathan g'),(15,'444-444444-444','NDQ0','02','2019','jonathang',2,'jonathang'),(16,'777-777777-777777','Nzc3','04','2024','jonathang',1,'jonathangm'),(17,'999-999999-999999','OTk5','03','2020','jonathana',1,'jonathan guardado'),(18,'999-999999-999988','OTg4','03','2020','jonathana',1,'jonathan guardado');
/*!40000 ALTER TABLE `credit_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credit_card_type`
--

DROP TABLE IF EXISTS `credit_card_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credit_card_type` (
  `id_credit_card_type` int(11) NOT NULL AUTO_INCREMENT,
  `credit_card_type_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id_credit_card_type`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit_card_type`
--

LOCK TABLES `credit_card_type` WRITE;
/*!40000 ALTER TABLE `credit_card_type` DISABLE KEYS */;
INSERT INTO `credit_card_type` VALUES (1,'Visa'),(2,'Master Card');
/*!40000 ALTER TABLE `credit_card_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id_department` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(45) NOT NULL,
  `country_id_country` int(11) NOT NULL,
  PRIMARY KEY (`id_department`),
  KEY `fk_department_country1_idx` (`country_id_country`),
  CONSTRAINT `fk_department_country1` FOREIGN KEY (`country_id_country`) REFERENCES `country` (`id_country`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'AHUACHAPÁN',1),(2,'CABAÑAS',1),(3,'CHALATENANGO',1),(4,'CUSCATLAN',1),(5,'MORAZAN',1),(6,'LA LIBERTAD',1),(7,'LA PAZ',1),(8,'LA UNIÓN',1),(9,'SAN MIGUEL',1),(10,'SAN SALVADOR',1),(11,'SAN VICENTE',1),(12,'SANTA ANA',1),(13,'SONSONATE',1),(14,'USULUTAN',1);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donation`
--

DROP TABLE IF EXISTS `donation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `donation` (
  `id_donation` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `donation_amount` double NOT NULL,
  `month` varchar(45) NOT NULL,
  `credit_card_id_credit_card` int(11) NOT NULL,
  `institution_id_institution` int(11) NOT NULL,
  PRIMARY KEY (`id_donation`),
  KEY `fk_donation_credit_card1_idx` (`credit_card_id_credit_card`),
  KEY `fk_donation_institution1_idx` (`institution_id_institution`),
  CONSTRAINT `fk_donation_credit_card1` FOREIGN KEY (`credit_card_id_credit_card`) REFERENCES `credit_card` (`id_credit_card`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_donation_institution1` FOREIGN KEY (`institution_id_institution`) REFERENCES `institution` (`id_institution`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donation`
--

LOCK TABLES `donation` WRITE;
/*!40000 ALTER TABLE `donation` DISABLE KEYS */;
INSERT INTO `donation` VALUES (1,'2018-07-08',233,'7-2018',8,2),(2,'2018-07-08',121,'7-2018',18,2);
/*!40000 ALTER TABLE `donation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institution`
--

DROP TABLE IF EXISTS `institution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `institution` (
  `id_institution` int(11) NOT NULL AUTO_INCREMENT,
  `institution_name` varchar(120) DEFAULT NULL,
  `department_id_department` int(11) NOT NULL,
  PRIMARY KEY (`id_institution`),
  KEY `fk_institution_department1_idx` (`department_id_department`),
  CONSTRAINT `fk_institution_department1` FOREIGN KEY (`department_id_department`) REFERENCES `department` (`id_department`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institution`
--

LOCK TABLES `institution` WRITE;
/*!40000 ALTER TABLE `institution` DISABLE KEYS */;
INSERT INTO `institution` VALUES (1,'Asociación H.P.H. El Salvador Hàbitat Para La Humanidad El Salvador',10),(2,'La Gran Logia Cuscatlan El Salvador',10),(3,'Asociacion Corporacion De La Pasion',10),(4,'Funprodes',10);
/*!40000 ALTER TABLE `institution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_name` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surnames` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `id_document` varchar(45) NOT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('jonathana','$2a$10$Vfjfe59tuWEFdhgwiVcNRuz9N7Ks4OPm4eYDBWK/HCSVjv/gR10Gq','Jonathan Guardado','Guardado','jonathan.guardado11@gmail.com',NULL,'14445225541','ROLE_USER'),('jonathang','$2a$10$j1pBpx5jDUh1KuP/hSDP7u1u2./BKZuoLjrvP33jb4w9zIfnnTz3O','Jonathan Guardado','Guardado','jonathan.guardado11@gmail.com',NULL,'jonathang','ROLE_USER'),('jonathangmz','$2a$10$UQTCnl3RJOjGnE0MzlDGneA6PNgG5XQUsFW3xyPg3JR2dabzw.tyi','Jonathan','Guardado','jonathan.guardado11@gmail.com',NULL,'14445225541','ROLE_USER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-08 19:36:34
