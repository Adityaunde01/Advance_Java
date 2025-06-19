/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19  Distrib 10.11.10-MariaDB, for Linux (x86_64)
--
-- Host: mysql.hostinger.ro    Database: u574849695_25
-- ------------------------------------------------------
-- Server version	10.11.10-MariaDB-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES
(1,'Bridgette','Auer','godfrey51@example.com','02560568717'),
(2,'Jorge','Yundt','manuela35@example.net','086-897-9603x589'),
(3,'Izabella','Treutel','graham.quinton@example.net','566-640-5511'),
(4,'Amy','Leuschke','torp.brennon@example.com','894-172-3734'),
(5,'Vida','Bechtelar','camylle.jones@example.net','06849572653'),
(6,'Kathlyn','Koepp','gibson.emmet@example.net','(463)661-2499x11909'),
(7,'Davon','Upton','rohan.aletha@example.org','525-867-0145'),
(8,'Margret','Jones','hilll.emie@example.org','04147402420'),
(9,'Misty','Gerhold','durgan.zena@example.com','(774)713-2326x34013'),
(10,'Abagail','Deckow','chelsie.grady@example.com','578-557-5318x200'),
(11,'Terrence','Larson','trantow.davon@example.com','(623)575-6264'),
(12,'Orville','Mitchell','xstark@example.com','+45(8)9615702846'),
(13,'Mara','Pagac','wilfredo.powlowski@example.com','118-827-3079'),
(14,'Eulalia','Hansen','jamir07@example.net','(753)205-2953'),
(15,'Sydney','Dickinson','ziemann.nyah@example.org','(496)967-3923'),
(16,'Stanton','Collins','magdalen53@example.org','362.136.0294'),
(17,'Esther','Hammes','rosalind.gorczany@example.com','+54(7)5479327325'),
(18,'Price','Wunsch','sid27@example.org','1-684-136-1717x702'),
(19,'Eliane','Schowalter','marvin.lola@example.com','292-776-1015x6992'),
(20,'Clifton','Kiehn','grant.kaya@example.com','(413)335-6375'),
(21,'Collin','Jenkins','stamm.vita@example.com','342.006.9144x08921'),
(22,'Peggie','Sauer','joesph.o\'connell@example.com','(043)180-7073x86584'),
(23,'Rowan','Krajcik','elena.maggio@example.net','(665)430-3126x7245'),
(24,'Pierce','Bernier','monroe.schmidt@example.com','03158546509'),
(25,'Josue','Hayes','hwintheiser@example.org','274.007.0661'),
(26,'Aimee','Jaskolski','green.hilma@example.com','(583)779-2441'),
(27,'Angelita','Kertzmann','kovacek.brandt@example.org','229-101-4639'),
(28,'Sandy','Wiza','mziemann@example.net','846-502-7295'),
(29,'Deonte','Dibbert','rohan.delilah@example.net','443-068-6856x20909'),
(30,'Simone','Franecki','carissa.jacobs@example.net','05452040143'),
(31,'Robin','Purdy','io\'keefe@example.net','+23(6)3648887868'),
(32,'Annalise','Morissette','gerda75@example.net','1-184-477-1408x84274'),
(33,'Camylle','Lehner','mack.batz@example.net','1-220-983-6767x74076'),
(34,'Nathaniel','Schroeder','ashleigh.mccullough@example.org','+71(7)1994104451'),
(35,'Bert','Turner','jefferey59@example.net','(593)734-9286'),
(36,'Joan','Homenick','nwisoky@example.com','058-637-5691x35567'),
(37,'Elise','Smith','lyda72@example.org','647.729.0488'),
(38,'Hope','Pouros','magdalen.dubuque@example.org','599-172-1630x84610'),
(39,'Cleora','Waelchi','nparker@example.org','02580849124'),
(40,'Dina','Williamson','swaniawski.deshawn@example.org','(294)639-0019'),
(41,'Gustave','Ebert','allie42@example.net','1-437-593-9404'),
(42,'Etha','Lehner','dwunsch@example.com','1-242-854-0181'),
(43,'Alan','Hoppe','hkovacek@example.net','875.845.1794'),
(44,'Ashley','Buckridge','tgibson@example.org','411-848-0856'),
(45,'Lonnie','Sipes','okey04@example.net','01954386205'),
(46,'Karl','Emmerich','pacocha.lenny@example.net','415.737.2978x740'),
(47,'Margarette','Cummings','moore.ocie@example.org','09536809584'),
(48,'Gordon','Rippin','stan24@example.org','+34(8)1222655671'),
(49,'Tod','Jakubowski','elza.cummings@example.com','+66(6)8996110901'),
(50,'Keven','Rutherford','earline.kohler@example.org','+92(1)8854078059'),
(51,'Kody','Cummings','sawayn.eino@example.net','170.813.6870x460'),
(52,'Alyson','Hudson','tbechtelar@example.net','+65(8)0726315479'),
(53,'Mason','Gerlach','ethyl.spinka@example.org','494.697.3626'),
(54,'Kevon','Ernser','johnson57@example.com','1-121-042-5261'),
(55,'Marta','Willms','zpollich@example.com','1-983-728-4988'),
(56,'Ronaldo','Lemke','green.lolita@example.com','1-633-235-9528x59710'),
(57,'Alexane','Robel','qratke@example.org','739.610.6263x59921'),
(58,'Caitlyn','Hirthe','rice.mario@example.net','1-217-043-8179x0406'),
(59,'Scarlett','Lind','swaters@example.com','707.978.9873x478'),
(60,'Joey','Hilpert','njaskolski@example.org','1-347-128-9475x745'),
(61,'Barbara','Grimes','aubree49@example.net','(006)327-2705'),
(62,'Verlie','Shields','jrunte@example.org','+86(9)0110258052'),
(63,'Bette','Stokes','hills.malvina@example.net','(626)593-2607x925'),
(64,'Queenie','Lind','raheem76@example.com','613.105.4300x24718'),
(65,'Ludie','Erdman','braden.witting@example.org','(207)914-1754'),
(66,'Edgardo','Douglas','douglas.jerod@example.net','150.981.9767x9635'),
(67,'Josiane','Borer','anastacio48@example.net','(167)606-0811'),
(68,'Ryleigh','Schamberger','margie11@example.net','110-073-7682x2875'),
(69,'Evert','Harris','fahey.maryam@example.com','719-704-7291x525'),
(70,'Daniela','Nader','kthompson@example.com','04120534284'),
(71,'Brody','Rau','freda.quigley@example.org','(202)115-2584x22795'),
(72,'Herminio','Conroy','davis.patsy@example.com','232.409.3114x636'),
(73,'Taya','Mueller','bruen.gisselle@example.net','447-433-9989'),
(74,'Hilton','Streich','auer.karl@example.com','240-513-2894x18651'),
(75,'Oswald','Mann','little.luna@example.com','482.486.4270'),
(76,'Gunner','Dicki','wwilliamson@example.net','(110)741-5286'),
(77,'Davion','Thompson','velda.pfeffer@example.org','196-714-9243x651'),
(78,'Jalyn','Erdman','lschamberger@example.org','(233)955-6542x182'),
(79,'Fredrick','Hudson','alangworth@example.net','(951)181-3541x927'),
(80,'Tracy','Douglas','dillan.schamberger@example.net','430-236-2700'),
(81,'Willis','Lakin','lmayert@example.com','256-706-9086x4064'),
(82,'Meredith','Hauck','frami.presley@example.org','750.546.6979x759'),
(83,'Kevin','Romaguera','eledner@example.com','770.661.2056x21594'),
(84,'Kariane','Kuhic','dashawn.brown@example.org','+63(4)5715190418'),
(85,'Terrill','DuBuque','keebler.marcelino@example.net','013.685.1584x381'),
(86,'Josephine','Zemlak','mosciski.sigrid@example.org','397-484-6998x167'),
(87,'Afton','Beer','alessia.champlin@example.com','(269)003-1660'),
(88,'Reed','Stark','pterry@example.org','+49(9)8910435985'),
(89,'Carolanne','Wuckert','xolson@example.net','919-895-2185x8200'),
(90,'Jeanette','Spinka','rollin.flatley@example.com','1-680-676-4552'),
(91,'Terrence','Schimmel','cloyd39@example.org','1-044-475-6073x67512'),
(92,'Vena','Mertz','cartwright.haylie@example.net','366-530-3969x532'),
(93,'Candice','Metz','freida37@example.net','755-518-5323x06023'),
(94,'Buford','Lemke','syble40@example.net','00626233206'),
(95,'Meta','Welch','eldred.boyer@example.org','455.181.3771x0784'),
(96,'Lilly','Ziemann','zleffler@example.com','1-144-364-1018x9289'),
(97,'Alta','Botsford','walker41@example.net','817.490.3796x55949'),
(98,'Joyce','Hoppe','ajaskolski@example.com','(722)287-1048'),
(99,'Veda','Kreiger','kstreich@example.org','121.710.6950'),
(100,'Rita','Hamill','npurdy@example.com','616.551.8424x058');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-19  1:28:37
