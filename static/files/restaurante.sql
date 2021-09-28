CREATE DATABASE  IF NOT EXISTS `restaurante` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `restaurante`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: restaurante
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `alimento`
--

DROP TABLE IF EXISTS `alimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alimento` (
  `idAlimento` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `imagen` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `descripcion` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `idTipoAlimento` int NOT NULL,
  `descuento` int DEFAULT NULL,
  `precio` decimal(4,2) NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `estatus` tinyint(1) NOT NULL,
  `idRestaurante` int DEFAULT NULL,
  `idMenu` int DEFAULT NULL,
  PRIMARY KEY (`idAlimento`),
  KEY `fk_alimento_tipo_alimento_idx` (`idTipoAlimento`),
  KEY `fk_alimento_restaurante_idx` (`idRestaurante`),
  KEY `fk_alimento_menu_idx` (`idMenu`),
  CONSTRAINT `fk_alimento_menu` FOREIGN KEY (`idMenu`) REFERENCES `menu` (`idMenu`),
  CONSTRAINT `fk_alimento_restaurante` FOREIGN KEY (`idRestaurante`) REFERENCES `restaurante` (`idRestaurante`),
  CONSTRAINT `fk_alimento_tipo_alimento` FOREIGN KEY (`idTipoAlimento`) REFERENCES `tipo_alimento` (`idTipoAlimento`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alimento`
--

LOCK TABLES `alimento` WRITE;
/*!40000 ALTER TABLE `alimento` DISABLE KEYS */;
INSERT INTO `alimento` VALUES (1,'Pozole','pozole_maciza_rojo.png','Puedes pedirlo como se te antoje, con todo, con o sin lechuga, con o sín rábano\r\n\r\nPuede ser con carne:*Maciza, Cabeza de Cerdo, Pollo, Surtido.',8,0,63.00,'2020-05-30 12:00:00','2020-05-31 22:47:48',1,10,2),(3,'Enchiladas verdes','enchiladas_verdes_ct.png','Tres deliciosas tortillas con una buena porción de pollito desmenuzado y bañadas sobre una ola de salsa verde. Obviamente acompañadas de crema y el queso, que no pueden faltar. Con tu orden disfruta de tres enchiladas.  ',2,0,52.00,'2020-05-31 22:51:24','2020-06-01 18:25:52',1,10,NULL),(4,'Enfrijoladas','enfrijoladas_ct.png','Ideal para compartir, tres tortillas perfectamente dobladas y rellenas de pollo desmenuzado y bañadas con una salsa de frijol que muchos imitan pero no se acercan al sabor. \r\n\r\n¡Sabemos que todo se te antoja, por eso lo puedes disfrutar por pieza!',11,NULL,52.00,'2020-05-31 23:10:55',NULL,1,10,2),(5,'Quesadillas','quesadillas_ct.png','Con queso o sin queso, aquí no hay controversia, solo sabor. Puedes pedirlas como se te antojen. Chicharrón, Flor de Calabaza, Hongos, Papa, Pancita, Picadillo, Pollo, Queso, Requesón, Sesos, Tinga, Cochinita, Carne.',7,NULL,31.00,'2020-05-31 23:16:21',NULL,1,10,2),(6,'Enchiladas rojas','enchiladas_rojas_ct.png','Tres deliciosas tortillas con una buena porción de pollito desmenuzado y bañadas sobre una ola de salsa roja. Obviamente acompañadas de crema y el queso, que no pueden faltar. Con tu orden disfruta de tres enchiladas.  ',2,NULL,63.00,'2020-06-01 18:24:28',NULL,1,10,NULL);
/*!40000 ALTER TABLE `alimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `idEmpleado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `primerApellido` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `segundoApellido` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `idSucursal` int DEFAULT NULL,
  `idRol` int NOT NULL,
  `usuario` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `email` varchar(150) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `superadmin` tinyint(1) DEFAULT NULL,
  `superadmingeneral` tinyint(1) DEFAULT NULL,
  `fechaCreacion` datetime NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `estatus` tinyint(1) NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  KEY `fk_empleado_sucursal1_idx` (`idSucursal`),
  KEY `fk_empleado_rol1_idx` (`idRol`),
  CONSTRAINT `fk_empleado_rol1` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (2,'Diego','Paniagua','López',3,2,'diego','12345','diego.paniagua.kanon89@gmail.com',0,0,'2020-05-28 14:40:00',NULL,1),(4,'Gerardo','Guerrero','Gómez',3,2,'gguerrero','12345','guerrerog@gmail.com',0,0,'2020-05-29 19:20:08',NULL,1),(7,'Ruth Ariadna','López','Romero',3,2,'ruthyari','12345','ruthyari@gmail.com',0,0,'2020-05-30 00:04:20','2020-05-30 00:04:57',1),(8,'admin','admin','admin',3,3,'admin','12345','admin@admin.net',1,0,'2020-05-30 13:42:00',NULL,1),(9,'admingeneral','admingeneral','admingeneral',NULL,4,'admingeneral','12345','admingeneral@gmail.com',0,1,'2020-05-30 17:54:00',NULL,1);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `idMenu` int NOT NULL AUTO_INCREMENT,
  `clave` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `descripcion` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `estatus` tinyint(1) NOT NULL,
  PRIMARY KEY (`idMenu`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'MENU_CT','Menú de casa de toño','2020-06-01 16:22:00',NULL,1),(2,'CVE_CTONIO','Menú de restaurante casa de toño','2020-06-01 18:59:37','2020-06-01 19:18:11',1);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurante`
--

DROP TABLE IF EXISTS `restaurante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurante` (
  `idRestaurante` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `imagen` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `slogan` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `idTipoRestaurante` int NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `estatus` tinyint(1) NOT NULL,
  `idMenu` int DEFAULT NULL,
  PRIMARY KEY (`idRestaurante`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  KEY `fk_restaurante_tipo_restaurante1_idx` (`idTipoRestaurante`),
  KEY `fk_restaurant_menu_idx` (`idMenu`),
  CONSTRAINT `fk_restaurant_menu` FOREIGN KEY (`idMenu`) REFERENCES `menu` (`idMenu`),
  CONSTRAINT `fk_restaurante_tipo_restaurante1` FOREIGN KEY (`idTipoRestaurante`) REFERENCES `tipo_restaurante` (`idTipoRestaurante`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurante`
--

LOCK TABLES `restaurante` WRITE;
/*!40000 ALTER TABLE `restaurante` DISABLE KEYS */;
INSERT INTO `restaurante` VALUES (10,'El chilaquilpower','chilaquilpower.png',NULL,1,'2020-05-28 14:37:00',NULL,1,2),(11,'Restaurante Hiroshima','hiroshimares.png',NULL,10,'2020-05-31 11:35:19','2020-05-31 13:15:23',1,NULL),(12,'Restaurante Tokyo','tokyores.png',NULL,10,'2020-05-31 13:08:53','2020-05-31 15:04:34',1,NULL);
/*!40000 ALTER TABLE `restaurante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurante_has_tipo_alimento`
--

DROP TABLE IF EXISTS `restaurante_has_tipo_alimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurante_has_tipo_alimento` (
  `idRestaurante` int NOT NULL,
  `idTipoAlimento` int NOT NULL,
  PRIMARY KEY (`idRestaurante`,`idTipoAlimento`),
  KEY `fk_restaurante_has_tipo_alimento_tipo_alimento1_idx` (`idTipoAlimento`),
  KEY `fk_restaurante_has_tipo_alimento_restaurante1_idx` (`idRestaurante`),
  CONSTRAINT `fk_restaurante_has_tipo_alimento_restaurante1` FOREIGN KEY (`idRestaurante`) REFERENCES `restaurante` (`idRestaurante`),
  CONSTRAINT `fk_restaurante_has_tipo_alimento_tipo_alimento1` FOREIGN KEY (`idTipoAlimento`) REFERENCES `tipo_alimento` (`idTipoAlimento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurante_has_tipo_alimento`
--

LOCK TABLES `restaurante_has_tipo_alimento` WRITE;
/*!40000 ALTER TABLE `restaurante_has_tipo_alimento` DISABLE KEYS */;
INSERT INTO `restaurante_has_tipo_alimento` VALUES (11,1),(10,2),(11,2),(10,4),(10,5),(10,6),(10,7),(10,8),(10,9),(10,10),(10,11);
/*!40000 ALTER TABLE `restaurante_has_tipo_alimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `idRol` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `estatus` tinyint(1) NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (2,'Empleado','2020-05-28 14:35:00',NULL,1),(3,'Administrador','2020-05-30 13:37:00','2020-05-31 16:42:19',1),(4,'SuperAdmin','2020-05-30 17:51:00',NULL,1),(5,'Administrador','2020-11-14 10:44:01',NULL,1);
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sucursal` (
  `idSucursal` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `idRestaurante` int NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `estatus` tinyint(1) NOT NULL,
  PRIMARY KEY (`idSucursal`),
  KEY `fk_sucursal_restaurante1_idx` (`idRestaurante`),
  CONSTRAINT `fk_sucursal_restaurante1` FOREIGN KEY (`idRestaurante`) REFERENCES `restaurante` (`idRestaurante`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
INSERT INTO `sucursal` VALUES (3,'El Chilaquil Power-Del Valle',10,'2020-05-28 14:39:00',NULL,1),(4,'El Chilaquil Power-Polanco',10,'2020-11-26 09:14:55',NULL,1),(5,'ChilaquilPower-Iztapalapa',10,'2020-11-26 09:16:16',NULL,1),(6,'ChilaquilPower-Polanco-M',10,'2020-11-26 09:17:39',NULL,1),(7,'ChilaquilPower-Ecatepec',10,'2020-11-26 09:19:24',NULL,1);
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_alimento`
--

DROP TABLE IF EXISTS `tipo_alimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_alimento` (
  `idTipoAlimento` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fechaCreacion` datetime NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `estatus` tinyint(1) NOT NULL,
  PRIMARY KEY (`idTipoAlimento`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_alimento`
--

LOCK TABLES `tipo_alimento` WRITE;
/*!40000 ALTER TABLE `tipo_alimento` DISABLE KEYS */;
INSERT INTO `tipo_alimento` VALUES (1,'Chilaquiles','2020-05-30 00:00:00',NULL,1),(2,'Enchiladas','2020-05-30 09:50:48',NULL,1),(4,'Tacos','2020-05-31 17:56:00',NULL,1),(5,'Gorditas','2020-05-31 18:09:24',NULL,1),(6,'Sopes','2020-05-31 21:47:47',NULL,1),(7,'Quesadillas','2020-05-31 21:48:05',NULL,1),(8,'Pozole','2020-05-31 21:48:22',NULL,1),(9,'Sopas','2020-05-31 21:48:36',NULL,1),(10,'Postres','2020-05-31 21:48:46',NULL,1),(11,'Enfrijoladas','2020-05-31 23:05:48',NULL,1);
/*!40000 ALTER TABLE `tipo_alimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_restaurante`
--

DROP TABLE IF EXISTS `tipo_restaurante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_restaurante` (
  `idTipoRestaurante` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `fechaCreacion` datetime NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `estatus` tinyint(1) NOT NULL,
  PRIMARY KEY (`idTipoRestaurante`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_restaurante`
--

LOCK TABLES `tipo_restaurante` WRITE;
/*!40000 ALTER TABLE `tipo_restaurante` DISABLE KEYS */;
INSERT INTO `tipo_restaurante` VALUES (1,'Mexicano','2020-05-28 14:37:00',NULL,1),(2,'Italiano','2020-05-30 10:57:35','2020-05-30 10:57:54',1),(4,'Peruano','2020-05-31 21:36:21',NULL,1),(5,'Frances','2020-05-31 21:36:34',NULL,1),(6,'Argentino','2020-05-31 21:36:41','2020-12-07 10:54:19',0),(7,'Brasileño','2020-05-31 21:36:48',NULL,1),(8,'Colombiano','2020-05-31 21:36:56',NULL,1),(9,'Estadounidense','2020-05-31 21:37:16',NULL,1),(10,'Japonés','2020-05-31 21:37:23',NULL,1),(11,'Chino','2020-05-31 21:37:27',NULL,1),(12,'Griego','2020-05-31 21:37:45',NULL,1),(13,'Ruso','2020-05-31 21:37:50',NULL,1),(14,'Indú','2020-05-31 21:37:58',NULL,1);
/*!40000 ALTER TABLE `tipo_restaurante` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-01 23:13:28
