CREATE DATABASE  IF NOT EXISTS `ejercicio3` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ejercicio3`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: ejercicio3
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudad` (
  `codigoCiudad` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codigoCiudad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,'La Plata'),(2,'Berisso'),(3,'Córdoba'),(4,'Mar del Plata');
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `club`
--

DROP TABLE IF EXISTS `club`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `club` (
  `codigoClub` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `anioFundacion` int DEFAULT NULL,
  `codigoCiudad` int DEFAULT NULL,
  PRIMARY KEY (`codigoClub`),
  KEY `codigoCiudad` (`codigoCiudad`),
  CONSTRAINT `club_ibfk_1` FOREIGN KEY (`codigoCiudad`) REFERENCES `ciudad` (`codigoCiudad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `club`
--

LOCK TABLES `club` WRITE;
/*!40000 ALTER TABLE `club` DISABLE KEYS */;
INSERT INTO `club` VALUES (101,'GELP',1950,1),(102,'CABJ',1960,1),(103,'EDELP',1970,2),(104,'CARP',1980,3),(105,'CAI',1990,3),(106,'CARC',2000,1),(107,'CAT',2002,1),(108,'CASLA',1543,4),(1234,'Estrella de Berisso',1921,2);
/*!40000 ALTER TABLE `club` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clubjugador`
--

DROP TABLE IF EXISTS `clubjugador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clubjugador` (
  `codigoClub` int NOT NULL,
  `DNI` int NOT NULL,
  `desde` date DEFAULT NULL,
  `hasta` date DEFAULT NULL,
  PRIMARY KEY (`codigoClub`,`DNI`),
  KEY `DNI` (`DNI`),
  CONSTRAINT `clubjugador_ibfk_1` FOREIGN KEY (`codigoClub`) REFERENCES `club` (`codigoClub`),
  CONSTRAINT `clubjugador_ibfk_2` FOREIGN KEY (`DNI`) REFERENCES `jugador` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clubjugador`
--

LOCK TABLES `clubjugador` WRITE;
/*!40000 ALTER TABLE `clubjugador` DISABLE KEYS */;
INSERT INTO `clubjugador` VALUES (101,1001,'2020-01-01','2022-12-31'),(101,1002,'2021-01-01','2022-12-31'),(101,1006,NULL,NULL),(102,1001,'2010-01-01','2018-12-31'),(102,1006,NULL,NULL),(103,1003,'2019-01-01','2020-12-31'),(103,1006,NULL,NULL),(104,1004,'2018-01-01','2032-12-31'),(104,1006,NULL,NULL),(105,1005,'2020-01-01','2022-12-31'),(105,1006,NULL,NULL),(106,1006,NULL,NULL),(107,1006,NULL,NULL),(108,1006,NULL,NULL);
/*!40000 ALTER TABLE `clubjugador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadio`
--

DROP TABLE IF EXISTS `estadio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estadio` (
  `codigoEstadio` int NOT NULL,
  `codigoClub` int DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codigoEstadio`),
  KEY `codigoClub` (`codigoClub`),
  CONSTRAINT `estadio_ibfk_1` FOREIGN KEY (`codigoClub`) REFERENCES `club` (`codigoClub`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadio`
--

LOCK TABLES `estadio` WRITE;
/*!40000 ALTER TABLE `estadio` DISABLE KEYS */;
INSERT INTO `estadio` VALUES (201,101,'Estadio A','Calle 1, La Plata'),(202,102,'Estadio B','Calle 2, La Plata'),(203,103,'Estadio C','Calle 3, Berisso');
/*!40000 ALTER TABLE `estadio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugador`
--

DROP TABLE IF EXISTS `jugador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugador` (
  `DNI` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `codigoCiudad` int DEFAULT NULL,
  PRIMARY KEY (`DNI`),
  KEY `codigoCiudad` (`codigoCiudad`),
  CONSTRAINT `jugador_ibfk_1` FOREIGN KEY (`codigoCiudad`) REFERENCES `ciudad` (`codigoCiudad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugador`
--

LOCK TABLES `jugador` WRITE;
/*!40000 ALTER TABLE `jugador` DISABLE KEYS */;
INSERT INTO `jugador` VALUES (1001,'Jugador1','Apellido1',25,1),(1002,'Jugador2','Apellido2',30,1),(1003,'Jugador3','Apellido3',28,2),(1004,'Jugador4','Apellido4',32,2),(1005,'Jugador5','Apellido5',27,4),(1006,'Jugador 6','Apellido6',231,2);
/*!40000 ALTER TABLE `jugador` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-24 12:22:23
CREATE DATABASE  IF NOT EXISTS `ejercicio1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ejercicio1`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: ejercicio1
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` int NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `DNI` varchar(10) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Jorge','Pérez','123456789','111-111-1111','Calle A #123'),(2,'María','López','234567890','222-222-2222','Calle B #456'),(3,'Pedro','González','345678901','333-333-3333','Calle C #789'),(4,'Ana','Martínez','456789012','444-444-4444','Calle D #012'),(5,'Luis','Hernández','567890123','555-555-5555','Calle E #345'),(6,'Laura','Ramírez','678901234','666-666-6666','Calle F #678'),(7,'Carlos','Torres','789012345','777-777-7777','Calle G #901'),(8,'Sofía','Sánchez','890123456','888-888-8888','Calle H #234'),(9,'Javier','Rodríguez','901234567','999-999-9999','Calle I #567'),(10,'Marcela','Díaz','012345678','101-010-1010','Calle J #890'),(11,'Eduardo','Moreno','112233445','111-111-1122','Calle K #123'),(12,'Isabel','Fernández','223344556','222-222-2233','Calle L #234'),(13,'Ricardo','Pardo','334455667','333-333-3344','Calle M #345'),(14,'Camila','Peralta','45789456','444-444-4455','Calle N #456'),(15,'Fernando','Lara','556677889','555-555-5566','Calle O #567'),(16,'José','García','123123112','221-123-1233','Calle P #890'),(500002,'Jorge Luis','Castor','40578999','221-4400789','11 entre 500 y 501 nro: 2587');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle`
--

DROP TABLE IF EXISTS `detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle` (
  `nroTicket` int NOT NULL,
  `idProducto` int NOT NULL,
  `cantidad` int DEFAULT NULL,
  `precioUnitario` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`nroTicket`,`idProducto`),
  KEY `idProducto` (`idProducto`),
  CONSTRAINT `detalle_ibfk_1` FOREIGN KEY (`nroTicket`) REFERENCES `factura` (`nroTicket`),
  CONSTRAINT `detalle_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle`
--

LOCK TABLES `detalle` WRITE;
/*!40000 ALTER TABLE `detalle` DISABLE KEYS */;
INSERT INTO `detalle` VALUES (1,1,2,50.00),(1,2,34,234.00),(1,999,5,234234.00),(2,3,1,150.50),(2,11,1,123.00),(2,12,3,345.00),(2,13,23,4532.00),(3,2,3,25.08),(4,4,2,100.37),(5,1,1,50.00),(6,5,4,43.88),(6,11,23,53.00),(6,12,46,3.00),(7,3,2,45.38),(7,11,46,8.00),(8,6,1,300.25),(8,12,79,4.00),(9,2,2,62.50),(10,1,3,83.50),(11,7,1,110.25),(12,5,1,43.88),(13,9,2,80.25),(14,4,3,61.83),(14,7,3,123.00),(15,8,2,88.50),(16,7,1,111.00),(16,38,3,45764.00);
/*!40000 ALTER TABLE `detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factura` (
  `nroTicket` int NOT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `idCliente` int DEFAULT NULL,
  PRIMARY KEY (`nroTicket`),
  KEY `idCliente` (`idCliente`),
  CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (1,100.00,'2017-01-14','08:30:00',1),(2,150.50,'2023-01-02','09:15:00',2),(3,75.25,'2017-01-14','10:00:00',3),(4,200.75,'2023-01-04','11:30:00',4),(5,50.00,'2017-01-14','12:45:00',5),(6,175.50,'2023-01-06','14:00:00',6),(7,90.75,'2023-01-07','15:15:00',7),(8,300.25,'2023-01-08','16:30:00',8),(9,125.00,'2023-01-09','17:45:00',9),(10,250.50,'2023-01-10','18:00:00',10),(11,110.25,'2023-01-11','19:15:00',11),(12,90.00,'2023-01-12','20:30:00',12),(13,160.75,'2019-01-13','21:45:00',13),(14,185.50,'2023-01-14','22:00:00',14),(15,220.25,'2023-01-15','23:15:00',1),(16,10000000.00,'2017-02-12','12:12:12',16),(17,1.00,'2021-01-01','12:12:12',16);
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idProducto` int NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `nombreP` varchar(50) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Producto 1',50.00,'ProductoA',100),(2,'Producto 2',25.08,'ProductoB',200),(3,'Producto 3',150.50,'ProductoC',150),(4,'Producto 4',100.37,'ProductoD',50),(5,'Producto 5',43.88,'ProductoE',75),(6,'Producto 6',300.25,'ProductoF',25),(7,'Producto 7',110.25,'ProductoG',80),(8,'Producto 8',88.50,'ProductoH',120),(9,'Producto 9',80.25,'ProductoI',60),(10,'Producto 10',83.50,'ProductoJ',90),(11,'asd',232.00,'prod1',123),(12,'qwe',123.00,'prod2',234),(13,'wer',124.00,'prod3',456),(38,'234',1234.00,'prod38',2345),(999,'234',342.00,'Z',234);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-24 12:22:23
CREATE DATABASE  IF NOT EXISTS `ejercicio2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ejercicio2`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: ejercicio2
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `agencia`
--

DROP TABLE IF EXISTS `agencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agencia` (
  `razon_social` varchar(255) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telef` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`razon_social`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agencia`
--

LOCK TABLES `agencia` WRITE;
/*!40000 ALTER TABLE `agencia` DISABLE KEYS */;
INSERT INTO `agencia` VALUES ('Agencia 1','Calle 123','123-456-7890','agencia1@example.com'),('Agencia 10','Calle S','777-555-3333','agencia10@example.com'),('Agencia 2','Calle 456','987-654-3210','agencia2@example.com'),('Agencia 3','Avenida X','111-222-3333','agencia3@example.com'),('Agencia 4','Calle Y','444-555-6666','agencia4@jmail.com'),('Agencia 5','Avenida Z','777-888-9999','agencia5@example.com'),('Agencia 6','Calle W','123-321-4567','agencia6@example.com'),('Agencia 7','Avenida V','999-888-7777','agencia7@example.com'),('Agencia 8','Calle U','654-321-1234','agencia8@example.com'),('Agencia 9','Avenida T','123-987-6543','agencia9@example.com'),('TAXI Y','342','234','234');
/*!40000 ALTER TABLE `agencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudad` (
  `CODIGOPOSTAL` int NOT NULL,
  `nombreCiudad` varchar(255) DEFAULT NULL,
  `añoCreacion` int DEFAULT NULL,
  PRIMARY KEY (`CODIGOPOSTAL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,'La Plata',1852),(2,'Coronel Brandsen',1800),(3,'Villa Elisa',1900),(4,'Berisso',1871),(5,'Ensenada',1811),(6,'Cityville',2000),(7,'Pueblito',1990),(8,'Otro Lugar',2005),(9,'Nueva Ciudad',2010),(10,'Ciudad Feliz',1985);
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `DNI` varchar(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('12345678','Juan','Roma','221-111-1111','Calle A'),('23456789','Sofía','Pérez','226-666-6666','Calle F'),('34567890','Laura','Torres','220-000-0000','Calle J'),('38495444','Pedro','López','223-333-3333','Calle C'),('45678901','Carlos','González','227-777-7777','Calle G'),('56789012','Luis','Fernández','225-555-5555','Calle E'),('67890123','Federico','Díaz','229-999-9999','Calle I'),('78901234','Ana','Martínez','224-444-4444','Calle D'),('87654321','María','Gómez','222-222-2222','Calle B'),('90123456','Lorena','Hernández','228-888-8888','Calle H');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `consulta`
--

DROP TABLE IF EXISTS `consulta`;
/*!50001 DROP VIEW IF EXISTS `consulta`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `consulta` AS SELECT 
 1 AS `dni`,
 1 AS `CANT`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `viaje`
--

DROP TABLE IF EXISTS `viaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `viaje` (
  `FECHA` date NOT NULL,
  `HORA` time DEFAULT NULL,
  `DNI` varchar(20) NOT NULL,
  `cpOrigen` int DEFAULT NULL,
  `cpDestino` int DEFAULT NULL,
  `razon_social` varchar(255) DEFAULT NULL,
  `descripcion` text,
  PRIMARY KEY (`DNI`,`FECHA`),
  KEY `cpOrigen` (`cpOrigen`),
  KEY `cpDestino` (`cpDestino`),
  KEY `razon_social` (`razon_social`),
  CONSTRAINT `viaje_ibfk_1` FOREIGN KEY (`cpOrigen`) REFERENCES `ciudad` (`CODIGOPOSTAL`),
  CONSTRAINT `viaje_ibfk_2` FOREIGN KEY (`cpDestino`) REFERENCES `ciudad` (`CODIGOPOSTAL`),
  CONSTRAINT `viaje_ibfk_3` FOREIGN KEY (`razon_social`) REFERENCES `agencia` (`razon_social`),
  CONSTRAINT `viaje_ibfk_4` FOREIGN KEY (`DNI`) REFERENCES `cliente` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viaje`
--

LOCK TABLES `viaje` WRITE;
/*!40000 ALTER TABLE `viaje` DISABLE KEYS */;
INSERT INTO `viaje` VALUES ('2015-01-10','08:40:00','12345678',1,2,'Agencia 9','Viaje a la costa atlantica'),('2015-01-11','08:40:00','12345678',1,2,'Agencia 10','Viaje a la costa atlantica'),('2015-01-12','08:40:00','12345678',1,2,'TAXI Y','Viaje a la costa atlantica'),('2015-01-15','08:40:00','12345678',1,2,'Agencia 6','Viaje a la costa atlantica'),('2015-01-16','08:40:00','12345678',1,2,'Agencia 4','Viaje a la costa atlantica'),('2015-01-17','08:40:00','12345678',1,2,'Agencia 5','Viaje a la costa atlantica'),('2015-01-18','08:40:00','12345678',1,2,'Agencia 7','Viaje a la costa atlantica'),('2015-01-19','08:40:00','12345678',1,2,'Agencia 8','Viaje a la costa atlantica'),('2019-01-15','08:30:00','12345678',1,2,'Agencia 1','Viaje demorado a Coronel Brandsen'),('2019-03-15','09:30:00','12345678',1,2,'Agencia 3','Viaje demorado a Cordoba'),('2020-01-15','20:30:00','12345678',2,2,'Agencia 2','Viaje sin problemas'),('2019-01-25','18:00:00','23456789',6,7,'Agencia 6','Viaje navideño demorado a Pueblito'),('2018-08-08','03:00:00','38495444',10,1,'Agencia 10','Viaje a La Plata'),('2019-03-20','12:45:00','38495444',3,2,'Agencia 3','Viaje rápido a Berisso'),('2020-04-12','20:00:00','45678901',7,8,'Agencia 7','Viaje sorpresa a Otro Lugar'),('2021-11-30','16:15:00','56789012',5,6,'Agencia 5','Viaje a Cityville'),('2022-09-01','01:00:00','67890123',9,10,'Agencia 9','Viaje nocturno a Ciudad Feliz'),('2020-05-10','14:30:00','78901234',4,5,'Agencia 4','Viaje tranquilo a Ensenada'),('2019-02-05','10:00:00','87654321',2,3,'Agencia 2','Viaje a Villa Elisa'),('2019-07-07','22:00:00','90123456',8,9,'Agencia 8','Viaje a la costa atlantica'),('2020-01-01','21:21:21','90123456',4,3,'TAXI Y','Viaje Taxi Y'),('2020-01-02','21:21:21','90123456',4,3,'TAXI Y','Viaje Taxi Y');
/*!40000 ALTER TABLE `viaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `consulta`
--

/*!50001 DROP VIEW IF EXISTS `consulta`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `consulta` (`dni`,`CANT`) AS select `viaje`.`DNI` AS `DNI`,count(`viaje`.`DNI`) AS `CANT` from `viaje` group by `viaje`.`DNI` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-24 12:22:23
