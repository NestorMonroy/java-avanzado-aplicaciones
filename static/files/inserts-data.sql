-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: tienda_musical
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
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` VALUES (9,'Hardwired...to Self-Destruct','hardwire.png','Es el décimo álbum de estudio de la banda estadounidense de thrash metal Metallica. Salió a la venta el 18 de noviembre de 2016 bajo su propio sello Blackened Recordings. Es el primer álbum de la banda en el que todos los temas tienen un vídeo music...',2016,'CD',199.99,12,6,NULL,'2020-11-16 00:00:00',NULL,1),(10,'Master of Puppets','metallica-puppets.jpg','Es el tercer álbum de estudio de la banda de thrash metal estadounidense Metallica. Fue lanzado al mercado el 3 de marzo de 1986, bajo el sello de Elektra Records, alcanzando el puesto 292​ en el Billboard 200. El álbum fue el primer disco de oro de ...',1986,'CD',99.99,11,6,NULL,'2020-11-16 00:00:00',NULL,1),(11,'The Number Of The Beast','ironmaiden-numberbeast.jpg','Es el tercer álbum de estudio de la banda británica de heavy metal Iron Maiden, publicado el 22 de marzo de 1982. Este trabajo supone el primero con el vocalista Bruce Dickinson y el último con el percusionista Clive Burr. Es considerado uno de los me...',1982,'Vinyl',199.99,13,7,NULL,'2020-11-16 00:00:00',NULL,1),(12,'Resistance','resistance.png','Es el nombre del quinto álbum de estudio de la banda británica Muse, publicado en Europa el 14 de septiembre de 2009 y en América del Norte el 15 de septiembre de 2009. El álbum fue producido por la banda y mezclado por Mark Stent. Fue grabado en el ...',2009,'CD',140.00,14,10,NULL,'2020-11-16 00:00:00',NULL,1),(13,'AM','am.png','Es el quinto álbum de estudio de la banda inglesa de Indie Rock, Arctic Monkeys. Fue lanzado el 6 de septiembre de 2013, bajo el sello Domino Records.7​ El 15 de julio de 2013, revelaron la portada del álbum.8​ El disco cuenta con las colaboracione...',2013,'CD',189.99,16,8,NULL,'2020-11-16 00:00:00',NULL,1),(14,'Highway to Hell','highwaytohell.png','Es el sexto álbum de estudio de la banda de hard rock australiana AC/DC que salió a la venta en 1979. También es el quinto álbum de estudio internacional de la banda y todas sus canciones fueron escritas por Angus Young, Malcolm Young, y Bon Scott, entre las que se destacan \"Highway to Hell\", \"Touch Too Much\", \"Walk All Over You\", \"Shot Down in Flames\", \"If You Want Blood (You\'ve Got It)\" y el oscuro blues \"Night Prowler\".',1979,'Vinyl',380.00,15,9,NULL,'2020-11-16 00:00:00',NULL,1);
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `artista`
--

LOCK TABLES `artista` WRITE;
/*!40000 ALTER TABLE `artista` DISABLE KEYS */;
INSERT INTO `artista` VALUES (6,'Metallica','metallica.png',3,9,'2020-11-16 00:00:00',NULL,1),(7,'Iron Maiden','ironmaiden.png',2,9,'2020-11-16 00:00:00',NULL,1),(8,'Arctic Monkeys','articmonkeys.png',2,13,'2020-11-16 00:00:00',NULL,1),(9,'AC-DC','acdc.png',4,10,'2020-11-16 00:00:00',NULL,1),(10,'Muse','muse.png',2,6,'2020-11-16 00:00:00',NULL,1);
/*!40000 ALTER TABLE `artista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `disquera`
--

LOCK TABLES `disquera` WRITE;
/*!40000 ALTER TABLE `disquera` DISABLE KEYS */;
INSERT INTO `disquera` VALUES (10,'MegaForce','2020-10-22 17:15:03',NULL,1),(11,'Elektra Recording','2020-10-22 17:15:20',NULL,1),(12,'Blackened Recordings','2020-11-16 00:00:00',NULL,1),(13,'EMI','2020-11-16 00:00:00',NULL,1),(14,'Warner Bros., Helium-3','2020-11-16 00:00:00',NULL,1),(15,'Atlantic Records','2020-11-16 00:00:00',NULL,1),(16,'Domino','2020-11-16 00:00:00',NULL,1);
/*!40000 ALTER TABLE `disquera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (2,'Rock','2020-10-31 00:00:00','2020-10-31 00:00:00',1),(4,'Metal','2020-11-15 00:00:00',NULL,1);
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `nacionalidad`
--

LOCK TABLES `nacionalidad` WRITE;
/*!40000 ALTER TABLE `nacionalidad` DISABLE KEYS */;
INSERT INTO `nacionalidad` VALUES (2,'Britanica','ING','2020-11-15 00:00:00',NULL,1),(3,'Estadounidense','USA','2020-11-15 00:00:00',NULL,1),(4,'Australiana','AUS','2020-11-16 00:00:00',NULL,1);
/*!40000 ALTER TABLE `nacionalidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `subgenero`
--

LOCK TABLES `subgenero` WRITE;
/*!40000 ALTER TABLE `subgenero` DISABLE KEYS */;
INSERT INTO `subgenero` VALUES (6,'Rock Alternativo',2,'2020-10-31 00:00:00','2020-10-31 00:00:00',1),(8,'Trash Metal',4,'2020-11-15 00:00:00',NULL,1),(9,'Heavy Metal',4,'2020-11-15 00:00:00',NULL,1),(10,'Hard Rock',2,'2020-11-15 00:00:00',NULL,1),(13,'Indie Rock',2,'2020-11-15 00:00:00',NULL,1);
/*!40000 ALTER TABLE `subgenero` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-16  8:48:14
