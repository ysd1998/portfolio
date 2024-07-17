-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: employee_db
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `employee_id` int NOT NULL,
  `name` varchar(10) NOT NULL,
  `department_id` int NOT NULL,
  `authority` varchar(8) DEFAULT NULL,
  `password` varchar(256) NOT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `employee_id_UNIQUE` (`employee_id`),
  KEY `department_id_idx` (`department_id`),
  CONSTRAINT `department_id` FOREIGN KEY (`department_id`) REFERENCES `departments` (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (24020801,'テスト',1003,'web販売担当','$2a$10$9DYqyfD7xEbSV6lbdNu87OCh.6OHMIKcYcNMf6pipse5LjAI6QktO'),(24032101,'管理者',1003,'管理者','$2a$10$9DYqyfD7xEbSV6lbdNu87OCh.6OHMIKcYcNMf6pipse5LjAI6QktO'),(24041501,'情報太郎',1003,'web販売担当','$2a$10$9DYqyfD7xEbSV6lbdNu87OCh.6OHMIKcYcNMf6pipse5LjAI6QktO'),(24053001,'佐藤浩紀',1001,'権限無し','$2a$10$9DYqyfD7xEbSV6lbdNu87OCh.6OHMIKcYcNMf6pipse5LjAI6QktO'),(24053002,'佐藤浩紀',1001,'権限無し','$2a$10$9DYqyfD7xEbSV6lbdNu87OCh.6OHMIKcYcNMf6pipse5LjAI6QktO'),(24053003,'松田太郎',1001,'権限無し','$2a$10$9DYqyfD7xEbSV6lbdNu87OCh.6OHMIKcYcNMf6pipse5LjAI6QktO'),(24053004,'伊藤世燈',1001,'権限無し','$2a$10$9DYqyfD7xEbSV6lbdNu87OCh.6OHMIKcYcNMf6pipse5LjAI6QktO'),(24053005,'佐竹直哉',1002,'権限無し','$2a$10$9DYqyfD7xEbSV6lbdNu87OCh.6OHMIKcYcNMf6pipse5LjAI6QktO'),(24053006,'佐竹直哉',1002,'権限無し','$2a$10$9DYqyfD7xEbSV6lbdNu87OCh.6OHMIKcYcNMf6pipse5LjAI6QktO'),(24053007,'伊藤直樹',1002,'権限無し','$2a$10$9DYqyfD7xEbSV6lbdNu87OCh.6OHMIKcYcNMf6pipse5LjAI6QktO'),(24053008,'伊藤直樹',1002,'権限無し','$2a$10$9DYqyfD7xEbSV6lbdNu87OCh.6OHMIKcYcNMf6pipse5LjAI6QktO');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-16 15:18:18
