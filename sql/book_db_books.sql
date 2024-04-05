-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: book_db
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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `book_id` varchar(10) NOT NULL,
  `title` varchar(10) NOT NULL,
  `auther` varchar(10) DEFAULT NULL,
  `price` int NOT NULL,
  `type_id` int NOT NULL,
  `publisher` varchar(8) NOT NULL,
  `year` date NOT NULL,
  `ex` varchar(1000) NOT NULL,
  `other` varchar(1000) DEFAULT NULL,
  `delete_flag` int NOT NULL DEFAULT '0',
  `insert_id` int NOT NULL,
  `insert_day` date NOT NULL,
  `update_id` int DEFAULT NULL,
  `update_day` date DEFAULT NULL,
  `delete_id` int DEFAULT NULL,
  `delete_day` date DEFAULT NULL,
  PRIMARY KEY (`book_id`),
  UNIQUE KEY `title_UNIQUE` (`title`),
  KEY `type_id_idx` (`type_id`),
  CONSTRAINT `type_id` FOREIGN KEY (`type_id`) REFERENCES `types` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES ('BK022801','テスト','テスト',1000,305,'テスト','2024-02-28','更新テストaaaaaaaaa','aa',0,24020801,'2024-03-18',24032101,'2024-03-28',NULL,NULL),('BK031301','テスト2','テスト2',1000,301,'テスト','2024-03-13','aaaaa',NULL,0,24020801,'2024-03-13',NULL,NULL,NULL,NULL),('BK031302','テスト3','テスト3',10000,301,'テスト','2024-03-13','更新テスト','',0,24020801,'2024-03-18',24020801,'2024-03-18',NULL,NULL),('BK031303','テスト4','テスト3',10000,301,'テスト','2024-03-13','aaaaaa','',0,24020801,'2024-03-18',NULL,NULL,NULL,NULL),('BK031304','追加テスト','追加テスト',20000,301,'パブリッシュ','2024-03-08','aaaa','aaaaa',0,24020801,'2024-03-13',NULL,NULL,NULL,NULL),('BK031305','追加テスト2','追加テスト',20000,301,'パブリッシュ','2024-03-08','aaaaaa','',0,24020801,'2024-03-18',24020801,'2024-03-18',NULL,NULL),('BK031306','追加テスト３','ああああ',2000,301,'ああああ','2024-03-08','更新テスト\r\naaaaaaaaaa','',0,24020801,'2024-03-14',NULL,NULL,NULL,NULL),('BK031401','aaaa','aaa',222,301,'aaaa','2024-03-08','','',0,24020801,'2024-03-14',NULL,NULL,NULL,NULL),('BK031501','確認画面テスト','確認者',20000,301,'パブリッシュ','2024-03-08','','',0,24020801,'2024-03-15',NULL,NULL,NULL,NULL),('BK24031501','ページングテスト１','ページ',11111,301,'パブリッシュ','2024-03-13','','',0,24020801,'2024-03-18',NULL,NULL,NULL,NULL),('BK24031502','ページングテスト３','追加テスト',20000,301,'パブリッシュ','2024-03-13','','',0,24020801,'2024-03-15',NULL,NULL,NULL,NULL),('BK24031801','aaaaaaa','aaaa',20000,301,'あああああ','2024-03-08','test','',0,24020801,'2024-03-18',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-01 11:47:46
