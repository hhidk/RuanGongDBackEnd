-- MySQL dump 10.13  Distrib 8.0.22, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: literaturesys
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Admin`
--

DROP TABLE IF EXISTS `Admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Admin` (
  `adminID` int NOT NULL AUTO_INCREMENT,
  `password` varchar(20) DEFAULT NULL,
  `authority` tinyint DEFAULT NULL,
  PRIMARY KEY (`adminID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Admin`
--

LOCK TABLES `Admin` WRITE;
/*!40000 ALTER TABLE `Admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `Admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Application`
--

DROP TABLE IF EXISTS `Application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Application` (
  `applicationID` int NOT NULL AUTO_INCREMENT,
  `userID` int DEFAULT NULL,
  `adminID` int DEFAULT NULL,
  `status` tinyint DEFAULT NULL,
  PRIMARY KEY (`applicationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Application`
--

LOCK TABLES `Application` WRITE;
/*!40000 ALTER TABLE `Application` DISABLE KEYS */;
/*!40000 ALTER TABLE `Application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Comment`
--

DROP TABLE IF EXISTS `Comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Comment` (
  `postCommentID` int NOT NULL AUTO_INCREMENT,
  `content` text,
  `postID` int DEFAULT NULL,
  `targenCommentID` int DEFAULT NULL,
  `userID` int DEFAULT NULL,
  `type` tinyint DEFAULT NULL,
  `commentTime` datetime DEFAULT NULL,
  PRIMARY KEY (`postCommentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Comment`
--

LOCK TABLES `Comment` WRITE;
/*!40000 ALTER TABLE `Comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `Comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Follow`
--

DROP TABLE IF EXISTS `Follow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Follow` (
  `userID` int DEFAULT NULL,
  `followerID` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Follow`
--

LOCK TABLES `Follow` WRITE;
/*!40000 ALTER TABLE `Follow` DISABLE KEYS */;
/*!40000 ALTER TABLE `Follow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Message`
--

DROP TABLE IF EXISTS `Message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Message` (
  `messageID` int NOT NULL AUTO_INCREMENT,
  `senderID` int DEFAULT NULL,
  `receiverID` int DEFAULT NULL,
  `viewed` tinyint(1) DEFAULT '0',
  `content` text,
  `type` tinyint DEFAULT NULL,
  `sendTime` datetime DEFAULT NULL,
  PRIMARY KEY (`messageID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Message`
--

LOCK TABLES `Message` WRITE;
/*!40000 ALTER TABLE `Message` DISABLE KEYS */;
/*!40000 ALTER TABLE `Message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Post`
--

DROP TABLE IF EXISTS `Post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Post` (
  `postID` int NOT NULL AUTO_INCREMENT,
  `referenceDocID` varchar(50) DEFAULT NULL,
  `postContent` text,
  `posterID` int DEFAULT NULL,
  `tags` int DEFAULT NULL,
  `postTime` datetime DEFAULT NULL,
  PRIMARY KEY (`postID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Post`
--

LOCK TABLES `Post` WRITE;
/*!40000 ALTER TABLE `Post` DISABLE KEYS */;
/*!40000 ALTER TABLE `Post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Report`
--

DROP TABLE IF EXISTS `Report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Report` (
  `reportID` int NOT NULL AUTO_INCREMENT,
  `type` tinyint DEFAULT NULL,
  `content` text,
  `status` tinyint DEFAULT NULL,
  `adminID` int DEFAULT NULL,
  `reply` text,
  `reporteeID` int DEFAULT NULL,
  `reporterID` int DEFAULT NULL,
  PRIMARY KEY (`reportID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Report`
--

LOCK TABLES `Report` WRITE;
/*!40000 ALTER TABLE `Report` DISABLE KEYS */;
/*!40000 ALTER TABLE `Report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Sector`
--

DROP TABLE IF EXISTS `Sector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Sector` (
  `sectorID` int NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `counter` int DEFAULT NULL,
  PRIMARY KEY (`sectorID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sector`
--

LOCK TABLES `Sector` WRITE;
/*!40000 ALTER TABLE `Sector` DISABLE KEYS */;
/*!40000 ALTER TABLE `Sector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SectorPost`
--

DROP TABLE IF EXISTS `SectorPost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SectorPost` (
  `sectorID` int DEFAULT NULL,
  `postID` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SectorPost`
--

LOCK TABLES `SectorPost` WRITE;
/*!40000 ALTER TABLE `SectorPost` DISABLE KEYS */;
/*!40000 ALTER TABLE `SectorPost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `authorID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `useridentity` tinyint NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(16) NOT NULL,
  `phoneNumber` varchar(20) DEFAULT NULL,
  `emailAddress` varchar(50) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  `organization` varchar(50) DEFAULT NULL,
  `introduction` text,
  `realName` varchar(50) DEFAULT NULL,
  `userDegree` tinyint DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserLiterature`
--

DROP TABLE IF EXISTS `UserLiterature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `UserLiterature` (
  `userID` int DEFAULT NULL,
  `literatureID` char(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserLiterature`
--

LOCK TABLES `UserLiterature` WRITE;
/*!40000 ALTER TABLE `UserLiterature` DISABLE KEYS */;
/*!40000 ALTER TABLE `UserLiterature` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-11  6:38:50
