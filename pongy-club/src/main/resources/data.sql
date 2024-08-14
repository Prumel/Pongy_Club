-- --------------------------------------------------------
-- Hôte:                         127.0.0.1
-- Version du serveur:           8.2.0 - MySQL Community Server - GPL
-- SE du serveur:                Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Listage des données de la table pongy.license : ~10 rows (environ)
INSERT INTO `license` (`id`, `end_date`, `payment_date`, `registration_date`, `start_date`, `license_type_id`, `licensed_member_id`) VALUES
	(1, '2025-07-01', '2024-09-01', '2024-09-01', '2024-09-01', 1, 2),
	(2, '2025-07-01', '2024-09-01', '2024-09-01', '2024-09-01', 2, 2),
	(3, NULL, NULL, '2024-09-01', NULL, 1, 1),
	(8, NULL, NULL, '2024-07-29', NULL, 2, 30),
	(13, NULL, NULL, '2024-09-01', NULL, 1, 30);

-- Listage des données de la table pongy.licensed_member : ~3 rows (environ)
INSERT INTO `licensed_member` (`id`, `address`, `birthdate`, `city`, `first_name`, `guardian_name`, `last_name`, `password`, `phone_number`, `registration_date`, `username`, `zip_code`) VALUES
	(1, '16 rue du Dr Marijo', '1999-09-08', 'Paris', 'François', NULL, 'Paloma', '$2a$10$4G1Irs3SxA9RMlT0i9ZacOz4Oif3m74D9EiXyC9PLpH0hE1w3Guyy', '0123456789', '2024-07-26', 'email@email.com', '75000'),
	(2, '15 rue des Pavillons', '1984-06-05', 'Provins', 'Maurice', NULL, 'Gérard', '$10$yOt42689Ty2eOE9q3BKn0.MFxAj641EfbpjvvTuITzb3RohPfTp.W', '0612223242', '2024-07-26', 'admin@email.com', '77160'),
	(30, 'Rue de Pongy', '1999-12-12', 'Serris', 'Admin', NULL, 'Admin', '$2a$10$AFdqdVjga5iWe7SFEUCwyOm.yDqL.QtdXSxNj5Vdy1PxaNDWUznpe', '0605030201', '2024-07-29', 'admin@admin.admin', '77700');

-- Listage des données de la table pongy.licensed_member_role : ~33 rows (environ)
INSERT INTO `licensed_member_role` (`licensed_member_id`, `role_id`) VALUES
	(1, 2),
	(2, 1),
	(2, 2),
	(30, 1),
	(30, 2);

-- Listage des données de la table pongy.license_type : ~2 rows (environ)
INSERT INTO `license_type` (`id`, `deactivation_date`, `description`, `name`, `price`, `registration_date`) VALUES
	(1, NULL, 'Entraînements et compétitions FNSMR', 'FNSMR', 100, '2024-07-26'),
	(2, NULL, 'Entraînements et compétitions FFTT', 'FFTT', 160, '2024-07-26');

-- Listage des données de la table pongy.role : ~2 rows (environ)
INSERT INTO `role` (`id`, `name`) VALUES
	(1, 'USER'),
	(2, 'ADMIN');

-- Listage des données de la table pongy.training : ~2 rows (environ)
INSERT INTO `training` (`id`, `deactivation_date`, `name`, `registration_date`, `schedule`) VALUES
	(1, NULL, 'supervisé', '2024-07-26', '19h-20h'),
	(2, NULL, 'libre', '2024-07-26', 'à partir de 20h');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
