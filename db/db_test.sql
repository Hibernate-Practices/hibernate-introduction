-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.17 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para test
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test`;


-- Volcando estructura para tabla test.tb_careers
DROP TABLE IF EXISTS `tb_careers`;
CREATE TABLE IF NOT EXISTS `tb_careers` (
  `fl_pk_career` bigint(20) NOT NULL AUTO_INCREMENT,
  `fl_name_career` varchar(50) NOT NULL,
  PRIMARY KEY (`fl_pk_career`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.tb_careers: ~6 rows (aproximadamente)
DELETE FROM `tb_careers`;
/*!40000 ALTER TABLE `tb_careers` DISABLE KEYS */;
INSERT INTO `tb_careers` (`fl_pk_career`, `fl_name_career`) VALUES
	(1, 'TICS'),
	(2, 'MECA'),
	(3, 'ENF'),
	(4, 'PAL'),
	(5, 'ADMIN'),
	(6, 'CONTA');
/*!40000 ALTER TABLE `tb_careers` ENABLE KEYS */;


-- Volcando estructura para tabla test.tb_students
DROP TABLE IF EXISTS `tb_students`;
CREATE TABLE IF NOT EXISTS `tb_students` (
  `fl_pk_row` bigint(20) NOT NULL AUTO_INCREMENT,
  `fl_enrollment` varchar(50) NOT NULL,
  `fl_name_student` varchar(50) NOT NULL,
  `fl_last_name_student` varchar(50) NOT NULL,
  `fl_gender` int(11) NOT NULL,
  `fl_fk_career` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`fl_pk_row`),
  KEY `FK_tb_students_tb_careers` (`fl_fk_career`),
  CONSTRAINT `FK_tb_students_tb_careers` FOREIGN KEY (`fl_fk_career`) REFERENCES `tb_careers` (`fl_pk_career`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.tb_students: ~0 rows (aproximadamente)
DELETE FROM `tb_students`;
/*!40000 ALTER TABLE `tb_students` DISABLE KEYS */;
INSERT INTO `tb_students` (`fl_pk_row`, `fl_enrollment`, `fl_name_student`, `fl_last_name_student`, `fl_gender`, `fl_fk_career`) VALUES
	(1, 'UTS12S-003661', 'Carlos Antonio', 'Escobar Hernadez', 1, 1);
/*!40000 ALTER TABLE `tb_students` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
