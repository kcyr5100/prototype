-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  sam. 27 mars 2021 à 00:56
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `jee_project_ged`
--

-- --------------------------------------------------------

--
-- Structure de la table `documents`
--

DROP TABLE IF EXISTS `documents`;
CREATE TABLE IF NOT EXISTS `documents` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `fileName` varchar(50) NOT NULL,
  `productionDate` varchar(50) NOT NULL,
  `createdAt` varchar(50) NOT NULL,
  `format` int(11) NOT NULL,
  `documentType` int(11) NOT NULL,
  `faculty` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `format` (`format`),
  KEY `documentType` (`documentType`),
  KEY `faculty` (`faculty`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `documents`
--

INSERT INTO `documents` (`id`, `title`, `fileName`, `productionDate`, `createdAt`, `format`, `documentType`, `faculty`) VALUES
(2, 'devoir', 'devoirjee.pdf', '10-10-2021', '16-03-2021 18:55:31', 3, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `document_type`
--

DROP TABLE IF EXISTS `document_type`;
CREATE TABLE IF NOT EXISTS `document_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `document_type`
--

INSERT INTO `document_type` (`id`, `type`) VALUES
(1, 'document-scolaire'),
(2, 'document-administratif');

-- --------------------------------------------------------

--
-- Structure de la table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
CREATE TABLE IF NOT EXISTS `faculty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `faculty` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `faculty`
--

INSERT INTO `faculty` (`id`, `faculty`) VALUES
(1, 'genie logiciel'),
(2, 'reseaux informatique'),
(3, 'reseaux telecom');

-- --------------------------------------------------------

--
-- Structure de la table `format`
--

DROP TABLE IF EXISTS `format`;
CREATE TABLE IF NOT EXISTS `format` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `format` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `format`
--

INSERT INTO `format` (`id`, `format`) VALUES
(1, 'png'),
(2, 'jpg'),
(3, 'pdf');

-- --------------------------------------------------------

--
-- Structure de la table `search`
--

DROP TABLE IF EXISTS `search`;
CREATE TABLE IF NOT EXISTS `search` (
  `user_code` int(11) NOT NULL,
  `document_code` int(11) NOT NULL,
  `created_at` date NOT NULL,
  PRIMARY KEY (`user_code`,`document_code`),
  KEY `document_code` (`document_code`),
  KEY `user_code` (`user_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `user_role_code` int(11) NOT NULL,
  `profile_picture` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_role_code` (`user_role_code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `email`, `username`, `password`, `user_role_code`, `profile_picture`) VALUES
(1, 'admin@amin.com', 'admin', 'admin', 1, 'profile.png');

-- --------------------------------------------------------

--
-- Structure de la table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `user_role`
--

INSERT INTO `user_role` (`id`, `role`) VALUES
(1, 'admin'),
(2, 'archiviste'),
(3, 'utilisateur');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `documents`
--
ALTER TABLE `documents`
  ADD CONSTRAINT `documents_ibfk_1` FOREIGN KEY (`documentType`) REFERENCES `document_type` (`id`),
  ADD CONSTRAINT `documents_ibfk_2` FOREIGN KEY (`faculty`) REFERENCES `faculty` (`id`),
  ADD CONSTRAINT `documents_ibfk_3` FOREIGN KEY (`format`) REFERENCES `format` (`id`);

--
-- Contraintes pour la table `search`
--
ALTER TABLE `search`
  ADD CONSTRAINT `search_ibfk_1` FOREIGN KEY (`user_code`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `search_ibfk_2` FOREIGN KEY (`document_code`) REFERENCES `documents` (`id`);

--
-- Contraintes pour la table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`user_role_code`) REFERENCES `user_role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
