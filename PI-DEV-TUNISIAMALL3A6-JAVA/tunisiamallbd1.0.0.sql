-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 11 Mai 2016 à 17:17
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `tunisiamallbdf`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresses`
--

CREATE TABLE IF NOT EXISTS `adresses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idclient` int(11) DEFAULT NULL,
  `pays` varchar(50) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `adresse` text NOT NULL,
  `zip` int(5) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_adresses_cli` (`idclient`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `adresses`
--

INSERT INTO `adresses` (`id`, `idclient`, `pays`, `ville`, `adresse`, `zip`) VALUES
(6, 15, 'NL', '36, Ibn sina''s street', 'zzzertzeryu', 5100),
(7, 15, 'AF', 'FVBNJ?K', 'FVBNJ?K', 3322),
(8, 15, 'AF', 'zajkaz', 'rzrrzaa', 123),
(9, 18, 'AF', 'rrrr', 'VVNB ?JIO', 123),
(10, 20, 'TW', 'tunis', 'azer ff', 1121),
(11, 20, 'TN', 'RTFTFF', 'FJFV? UYIRTYIUVB JIOM', 5100),
(12, 29, 'AZ', 'tunis', 'yyuy oio', 5100),
(13, 20, 'AC', 'ffff', 'fffffff', 1111);

-- --------------------------------------------------------

--
-- Structure de la table `boutique`
--

CREATE TABLE IF NOT EXISTS `boutique` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_MARQUE` int(11) DEFAULT NULL,
  `ID_LOCAL` int(11) DEFAULT NULL,
  `LOGO` blob NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_BOUTIQUE_MARQUE` (`ID_MARQUE`),
  KEY `FK_BOUTIQUE_LOCAL` (`ID_LOCAL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `carte_fidilite`
--

CREATE TABLE IF NOT EXISTS `carte_fidilite` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_MARQUE` int(11) DEFAULT NULL,
  `ID_CLIENT` int(11) DEFAULT NULL,
  `NOMBRE_POINT` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CARTE_FIDILITE_MARQUE` (`ID_MARQUE`),
  KEY `FK_CARTE_FIDILITE_USER` (`ID_CLIENT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `catalogue`
--

CREATE TABLE IF NOT EXISTS `catalogue` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_MARQUE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CATALOGUE_MARQUE` (`ID_MARQUE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `commandes`
--

CREATE TABLE IF NOT EXISTS `commandes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `utilisateur_id` int(11) DEFAULT NULL,
  `valider` tinyint(1) NOT NULL,
  `date` datetime NOT NULL,
  `reference` int(11) NOT NULL,
  `commande` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '(DC2Type:array)',
  PRIMARY KEY (`id`),
  KEY `IDX_35D4282CFB88E14F` (`utilisateur_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=33 ;

--
-- Contenu de la table `commandes`
--

INSERT INTO `commandes` (`id`, `utilisateur_id`, `valider`, `date`, `reference`, `commande`) VALUES
(6, 15, 1, '2016-03-30 22:22:47', 1, 'a:7:{s:9:"reduction";a:1:{s:2:"%2";d:4.21999999999999975131004248396493494510650634765625;}s:7:"produit";a:1:{i:14;a:6:{s:3:"nom";s:7:"Baskets";s:8:"quantite";i:1;s:4:"prix";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:13:"tauxreduction";d:2;s:5:"photo";s:9:"img/2.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:11:"facturation";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:9:"prixtotal";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:5:"token";s:40:"17d1304ffba9a39fa7a140727b762249ea6b7430";}'),
(7, 15, 1, '2016-03-30 22:29:09', 2, 'a:7:{s:9:"reduction";a:1:{s:2:"%0";d:0;}s:7:"produit";a:1:{i:13;a:6:{s:3:"nom";s:20:"jegging en jean brut";s:8:"quantite";i:1;s:4:"prix";d:298;s:9:"prixreduc";d:298;s:13:"tauxreduction";d:0;s:5:"photo";s:9:"img/4.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:11:"facturation";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:9:"prixtotal";d:298;s:9:"prixreduc";d:298;s:5:"token";s:40:"ceba2408dfb1c6f8fc71415e2c5c14ad02c5b90b";}'),
(8, 18, 1, '2016-03-30 23:59:27', 3, 'a:7:{s:9:"reduction";a:1:{s:2:"%2";d:4.21999999999999975131004248396493494510650634765625;}s:7:"produit";a:1:{i:15;a:6:{s:3:"nom";s:33:"Blouson noir fermeture a pression";s:8:"quantite";i:1;s:4:"prix";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:13:"tauxreduction";d:2;s:5:"photo";s:9:"img/1.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";N;s:3:"nom";N;s:7:"adresse";s:9:"VVNB ?JIO";s:3:"zip";i:123;s:5:"ville";s:4:"rrrr";s:4:"pays";s:2:"AF";}s:11:"facturation";a:6:{s:6:"prenom";N;s:3:"nom";N;s:7:"adresse";s:9:"VVNB ?JIO";s:3:"zip";i:123;s:5:"ville";s:4:"rrrr";s:4:"pays";s:2:"AF";}s:9:"prixtotal";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:5:"token";s:40:"93ea24c23f76fb1d75fcecaa815a274f99d78816";}'),
(9, 15, 1, '2016-03-31 01:18:28', 4, 'a:7:{s:9:"reduction";a:1:{s:2:"%2";d:4.21999999999999975131004248396493494510650634765625;}s:7:"produit";a:1:{i:15;a:6:{s:3:"nom";s:33:"Blouson noir fermeture a pression";s:8:"quantite";i:1;s:4:"prix";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:13:"tauxreduction";d:2;s:5:"photo";s:9:"img/1.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:11:"facturation";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:9:"prixtotal";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:5:"token";s:40:"c558dd68885df95696b1b9b2c0e7e860b45d1e57";}'),
(10, 15, 1, '2016-04-02 08:50:59', 5, 'a:7:{s:9:"reduction";a:1:{s:2:"%2";d:21.099999999999997868371792719699442386627197265625;}s:7:"produit";a:2:{i:17;a:6:{s:3:"nom";s:47:"foulard imprimé cachemire écru et bleu marine";s:8:"quantite";s:1:"4";s:4:"prix";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:13:"tauxreduction";d:2;s:5:"photo";s:9:"img/5.jpg";}i:18;a:6:{s:3:"nom";s:25:"bottines à franges camel";s:8:"quantite";i:1;s:4:"prix";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:13:"tauxreduction";d:2;s:5:"photo";s:9:"img/6.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:11:"facturation";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:9:"prixtotal";d:1055;s:9:"prixreduc";d:1033.90000000000009094947017729282379150390625;s:5:"token";s:40:"204499b0aeed76c4a935972fb19a255f34eb066c";}'),
(11, 15, 1, '2016-04-02 22:12:56', 6, 'a:7:{s:9:"reduction";a:1:{s:2:"%2";d:12.660000000000000142108547152020037174224853515625;}s:7:"produit";a:1:{i:15;a:6:{s:3:"nom";s:33:"Blouson noir fermeture a pression";s:8:"quantite";s:1:"3";s:4:"prix";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:13:"tauxreduction";d:2;s:5:"photo";s:9:"img/1.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:11:"facturation";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:9:"prixtotal";d:633;s:9:"prixreduc";d:620.3400000000000318323145620524883270263671875;s:5:"token";s:40:"4f6c34eadfbf9f7397c411bcc9495f89ec3f0e83";}'),
(12, 15, 0, '2016-04-02 22:30:15', 0, 'a:7:{s:9:"reduction";a:1:{s:2:"%2";d:4.21999999999999975131004248396493494510650634765625;}s:7:"produit";a:1:{i:14;a:6:{s:3:"nom";s:7:"Baskets";s:8:"quantite";s:1:"1";s:4:"prix";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:13:"tauxreduction";d:2;s:5:"photo";s:9:"img/2.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:11:"facturation";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:9:"prixtotal";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:5:"token";s:40:"3dc405cd2421e00cdf0dc8d679c854105efd02e7";}'),
(13, 15, 1, '2016-04-02 22:43:13', 7, 'a:7:{s:9:"reduction";a:1:{s:2:"%2";d:4.21999999999999975131004248396493494510650634765625;}s:7:"produit";a:1:{i:14;a:6:{s:3:"nom";s:7:"Baskets";s:8:"quantite";i:1;s:4:"prix";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:13:"tauxreduction";d:2;s:5:"photo";s:9:"img/2.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:11:"facturation";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:9:"prixtotal";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:5:"token";s:40:"315aff90141a05954b16bf3aab1450b9a49b3963";}'),
(14, 15, 1, '2016-04-02 23:10:09', 8, 'a:7:{s:9:"reduction";a:1:{s:2:"%0";d:0;}s:7:"produit";a:1:{i:13;a:6:{s:3:"nom";s:20:"jegging en jean brut";s:8:"quantite";i:1;s:4:"prix";d:298;s:9:"prixreduc";d:298;s:13:"tauxreduction";d:0;s:5:"photo";s:9:"img/4.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:11:"facturation";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:9:"prixtotal";d:298;s:9:"prixreduc";d:298;s:5:"token";s:40:"789899b93ed1555b70f4c0a4c9e15cb01662a454";}'),
(15, 15, 1, '2016-04-02 23:20:08', 9, 'a:7:{s:9:"reduction";a:1:{s:2:"%2";d:4.21999999999999975131004248396493494510650634765625;}s:7:"produit";a:1:{i:15;a:6:{s:3:"nom";s:33:"Blouson noir fermeture a pression";s:8:"quantite";i:1;s:4:"prix";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:13:"tauxreduction";d:2;s:5:"photo";s:9:"img/1.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:11:"facturation";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:9:"prixtotal";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:5:"token";s:40:"95f03a08de63684625697c4a3590c8bbe0f5d3fc";}'),
(16, 15, 1, '2016-04-02 23:26:34', 10, 'a:7:{s:9:"reduction";a:1:{s:2:"%2";d:4.21999999999999975131004248396493494510650634765625;}s:7:"produit";a:1:{i:14;a:6:{s:3:"nom";s:7:"Baskets";s:8:"quantite";i:1;s:4:"prix";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:13:"tauxreduction";d:2;s:5:"photo";s:9:"img/2.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:11:"facturation";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:9:"prixtotal";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:5:"token";s:40:"d4bead35d35bb25dfa73a722ef76834d9a1d8ef9";}'),
(17, 15, 1, '2016-04-02 23:29:01', 11, 'a:7:{s:9:"reduction";a:1:{s:2:"%0";d:0;}s:7:"produit";a:1:{i:13;a:6:{s:3:"nom";s:20:"jegging en jean brut";s:8:"quantite";i:1;s:4:"prix";d:298;s:9:"prixreduc";d:298;s:13:"tauxreduction";d:0;s:5:"photo";s:9:"img/4.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:11:"facturation";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:9:"prixtotal";d:298;s:9:"prixreduc";d:298;s:5:"token";s:40:"0d1b6bbff6c649a1ff84219cc3b86bd0af378f9d";}'),
(18, 15, 1, '2016-04-02 23:31:27', 12, 'a:7:{s:9:"reduction";a:1:{s:2:"%2";d:4.21999999999999975131004248396493494510650634765625;}s:7:"produit";a:1:{i:18;a:6:{s:3:"nom";s:25:"bottines à franges camel";s:8:"quantite";i:1;s:4:"prix";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:13:"tauxreduction";d:2;s:5:"photo";s:9:"img/6.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:11:"facturation";a:6:{s:6:"prenom";s:5:"Saida";s:3:"nom";s:6:"Khouja";s:7:"adresse";s:11:"zzzertzeryu";s:3:"zip";i:5100;s:5:"ville";s:21:"36, Ibn sina''s street";s:4:"pays";s:2:"NL";}s:9:"prixtotal";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:5:"token";s:40:"fc6a1666fb69adef45a61a6285b90c9e65e2d430";}'),
(19, 20, 1, '2016-04-05 11:33:39', 13, 'a:7:{s:9:"reduction";a:1:{s:2:"%0";d:0;}s:7:"produit";a:1:{i:13;a:6:{s:3:"nom";s:20:"jegging en jean brut";s:8:"quantite";s:1:"3";s:4:"prix";d:298;s:9:"prixreduc";d:298;s:13:"tauxreduction";d:0;s:5:"photo";s:9:"img/4.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";N;s:3:"nom";N;s:7:"adresse";s:7:"azer ff";s:3:"zip";i:1121;s:5:"ville";s:5:"tunis";s:4:"pays";s:2:"TW";}s:11:"facturation";a:6:{s:6:"prenom";N;s:3:"nom";N;s:7:"adresse";s:7:"azer ff";s:3:"zip";i:1121;s:5:"ville";s:5:"tunis";s:4:"pays";s:2:"TW";}s:9:"prixtotal";d:894;s:9:"prixreduc";d:894;s:5:"token";s:40:"886ea770fc0d364d8983b51922822ba0fd5bf48e";}'),
(20, 20, 1, '2016-04-05 11:42:17', 14, 'a:7:{s:9:"reduction";a:1:{s:2:"%2";d:8.4399999999999995026200849679298698902130126953125;}s:7:"produit";a:1:{i:15;a:6:{s:3:"nom";s:33:"Blouson noir fermeture a pression";s:8:"quantite";s:1:"2";s:4:"prix";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:13:"tauxreduction";d:2;s:5:"photo";s:9:"img/1.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";N;s:3:"nom";N;s:7:"adresse";s:7:"azer ff";s:3:"zip";i:1121;s:5:"ville";s:5:"tunis";s:4:"pays";s:2:"TW";}s:11:"facturation";a:6:{s:6:"prenom";N;s:3:"nom";N;s:7:"adresse";s:7:"azer ff";s:3:"zip";i:1121;s:5:"ville";s:5:"tunis";s:4:"pays";s:2:"TW";}s:9:"prixtotal";d:422;s:9:"prixreduc";d:413.56000000000000227373675443232059478759765625;s:5:"token";s:40:"75a05b50c9c68c56d36bdd0cc57ead8676e0e652";}'),
(21, 20, 1, '2016-04-17 10:15:14', 15, 'a:7:{s:9:"reduction";a:1:{s:2:"%0";d:0;}s:7:"produit";a:1:{i:13;a:6:{s:3:"nom";s:20:"jegging en jean brut";s:8:"quantite";s:1:"1";s:4:"prix";d:298;s:9:"prixreduc";d:298;s:13:"tauxreduction";d:0;s:5:"photo";s:9:"img/4.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:7:"azer ff";s:3:"zip";i:1121;s:5:"ville";s:5:"tunis";s:4:"pays";s:2:"TW";}s:11:"facturation";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:7:"azer ff";s:3:"zip";i:1121;s:5:"ville";s:5:"tunis";s:4:"pays";s:2:"TW";}s:9:"prixtotal";d:298;s:9:"prixreduc";d:298;s:5:"token";s:40:"45c156953d6dd3e4fbe2b0ed69301f22611cf9f5";}'),
(22, 20, 1, '2016-04-17 10:24:38', 16, 'a:7:{s:9:"reduction";a:1:{s:2:"%2";d:4.21999999999999975131004248396493494510650634765625;}s:7:"produit";a:1:{i:14;a:6:{s:3:"nom";s:7:"Baskets";s:8:"quantite";i:1;s:4:"prix";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:13:"tauxreduction";d:2;s:5:"photo";s:9:"img/2.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:21:"FJFV? UYIRTYIUVB JIOM";s:3:"zip";i:5100;s:5:"ville";s:6:"RTFTFF";s:4:"pays";s:2:"TN";}s:11:"facturation";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:7:"azer ff";s:3:"zip";i:1121;s:5:"ville";s:5:"tunis";s:4:"pays";s:2:"TW";}s:9:"prixtotal";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:5:"token";s:40:"15b4bf5f85285c550122c23be65c701c3fcd0e54";}'),
(23, 29, 1, '2016-05-09 17:47:10', 17, 'a:7:{s:9:"reduction";a:1:{s:2:"%2";d:2.45999999999999996447286321199499070644378662109375;}s:7:"produit";a:1:{i:72;a:6:{s:3:"nom";s:30:"PANTALON REGULAR TOUCHER DOUX ";s:8:"quantite";i:1;s:4:"prix";d:123;s:9:"prixreduc";d:120.5400000000000062527760746888816356658935546875;s:13:"tauxreduction";d:2;s:5:"photo";s:10:"img/12.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:8:"yyuy oio";s:3:"zip";i:5100;s:5:"ville";s:5:"tunis";s:4:"pays";s:2:"AZ";}s:11:"facturation";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:8:"yyuy oio";s:3:"zip";i:5100;s:5:"ville";s:5:"tunis";s:4:"pays";s:2:"AZ";}s:9:"prixtotal";d:123;s:9:"prixreduc";d:120.5400000000000062527760746888816356658935546875;s:5:"token";s:40:"663e54176ef843531b4e5196db10b4d7e126b1c6";}'),
(24, 29, 1, '2016-05-09 17:50:03', 18, 'a:7:{s:9:"reduction";a:1:{s:3:"%30";d:29.699999999999999289457264239899814128875732421875;}s:7:"produit";a:1:{i:65;a:6:{s:3:"nom";s:25:"bottines à franges camel";s:8:"quantite";i:1;s:4:"prix";d:99;s:9:"prixreduc";d:69.2999999999999971578290569595992565155029296875;s:13:"tauxreduction";d:30;s:5:"photo";s:9:"img/6.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:8:"yyuy oio";s:3:"zip";i:5100;s:5:"ville";s:5:"tunis";s:4:"pays";s:2:"AZ";}s:11:"facturation";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:8:"yyuy oio";s:3:"zip";i:5100;s:5:"ville";s:5:"tunis";s:4:"pays";s:2:"AZ";}s:9:"prixtotal";d:99;s:9:"prixreduc";d:69.2999999999999971578290569595992565155029296875;s:5:"token";s:40:"17a45770ebf80c61d09a5584bd3e8d335ae42d9a";}'),
(25, 29, 1, '2016-05-09 17:54:20', 19, 'a:7:{s:9:"reduction";a:1:{s:3:"%20";d:20;}s:7:"produit";a:1:{i:60;a:6:{s:3:"nom";s:7:"baskets";s:8:"quantite";s:1:"2";s:4:"prix";d:50;s:9:"prixreduc";d:40;s:13:"tauxreduction";d:20;s:5:"photo";s:9:"img/2.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:8:"yyuy oio";s:3:"zip";i:5100;s:5:"ville";s:5:"tunis";s:4:"pays";s:2:"AZ";}s:11:"facturation";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:8:"yyuy oio";s:3:"zip";i:5100;s:5:"ville";s:5:"tunis";s:4:"pays";s:2:"AZ";}s:9:"prixtotal";d:100;s:9:"prixreduc";d:80;s:5:"token";s:40:"2a519494647b3c282fef2f8ab72f8b6e3e1e4c22";}'),
(26, 29, 1, '2016-05-10 08:30:34', 20, 'a:7:{s:9:"reduction";a:1:{s:2:"%0";d:0;}s:7:"produit";a:1:{i:13;a:6:{s:3:"nom";s:20:"jegging en jean brut";s:8:"quantite";i:1;s:4:"prix";d:298;s:9:"prixreduc";d:298;s:13:"tauxreduction";d:0;s:5:"photo";s:9:"img/4.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:8:"yyuy oio";s:3:"zip";i:5100;s:5:"ville";s:5:"tunis";s:4:"pays";s:2:"AZ";}s:11:"facturation";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:8:"yyuy oio";s:3:"zip";i:5100;s:5:"ville";s:5:"tunis";s:4:"pays";s:2:"AZ";}s:9:"prixtotal";d:298;s:9:"prixreduc";d:298;s:5:"token";s:40:"cbc3ba3a9de8d38a7799e9a2f0ce2bc37cbd8066";}'),
(27, 29, 1, '2016-05-10 08:45:07', 21, 'a:7:{s:9:"reduction";a:2:{s:2:"%2";d:4.21999999999999975131004248396493494510650634765625;s:2:"%5";d:6;}s:7:"produit";a:2:{i:15;a:6:{s:3:"nom";s:33:"Blouson noir fermeture a pression";s:8:"quantite";i:1;s:4:"prix";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:13:"tauxreduction";d:2;s:5:"photo";s:9:"img/1.jpg";}i:62;a:6:{s:3:"nom";s:35:"sweat imprimé boudeuse gris chiné";s:8:"quantite";s:1:"4";s:4:"prix";d:30;s:9:"prixreduc";d:28.5;s:13:"tauxreduction";d:5;s:5:"photo";s:9:"img/3.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:8:"yyuy oio";s:3:"zip";i:5100;s:5:"ville";s:5:"tunis";s:4:"pays";s:2:"AZ";}s:11:"facturation";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:8:"yyuy oio";s:3:"zip";i:5100;s:5:"ville";s:5:"tunis";s:4:"pays";s:2:"AZ";}s:9:"prixtotal";d:331;s:9:"prixreduc";d:320.779999999999972715158946812152862548828125;s:5:"token";s:40:"a2702e5aa38bd5b0a473d81cc5949c4ecf1d577d";}'),
(28, 29, 1, '2016-05-10 08:46:14', 22, 'a:7:{s:9:"reduction";a:1:{s:2:"%0";d:0;}s:7:"produit";a:1:{i:73;a:6:{s:3:"nom";s:18:"Yves Saint Laurent";s:8:"quantite";i:1;s:4:"prix";d:200;s:9:"prixreduc";d:200;s:13:"tauxreduction";d:0;s:5:"photo";s:10:"img/15.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:8:"yyuy oio";s:3:"zip";i:5100;s:5:"ville";s:5:"tunis";s:4:"pays";s:2:"AZ";}s:11:"facturation";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:8:"yyuy oio";s:3:"zip";i:5100;s:5:"ville";s:5:"tunis";s:4:"pays";s:2:"AZ";}s:9:"prixtotal";d:200;s:9:"prixreduc";d:200;s:5:"token";s:40:"f9caea065566bcb25b2f50554e8aad1ec7b3fb3f";}'),
(29, 20, 1, '2016-05-10 08:49:16', 23, 'a:7:{s:9:"reduction";a:1:{s:3:"%10";d:6;}s:7:"produit";a:1:{i:63;a:6:{s:3:"nom";s:27:"jegging en jean medium blue";s:8:"quantite";i:1;s:4:"prix";d:60;s:9:"prixreduc";d:54;s:13:"tauxreduction";d:10;s:5:"photo";s:9:"img/2.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:7:"azer ff";s:3:"zip";i:1121;s:5:"ville";s:5:"tunis";s:4:"pays";s:2:"TW";}s:11:"facturation";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:21:"FJFV? UYIRTYIUVB JIOM";s:3:"zip";i:5100;s:5:"ville";s:6:"RTFTFF";s:4:"pays";s:2:"TN";}s:9:"prixtotal";d:60;s:9:"prixreduc";d:54;s:5:"token";s:40:"effdd7fdde89aa91335eda80fff64cc32f5a4fc7";}'),
(30, 20, 1, '2016-05-10 09:50:39', 24, 'a:7:{s:9:"reduction";a:2:{s:2:"%9";d:8.0999999999999996447286321199499070644378662109375;s:2:"%3";d:1.8000000000000000444089209850062616169452667236328125;}s:7:"produit";a:2:{i:64;a:6:{s:3:"nom";s:47:"foulard imprimé cachemire écru et bleu marine";s:8:"quantite";s:1:"9";s:4:"prix";d:10;s:9:"prixreduc";d:9.0999999999999996447286321199499070644378662109375;s:13:"tauxreduction";d:9;s:5:"photo";s:9:"img/5.jpg";}i:70;a:6:{s:3:"nom";s:21:"JEAN SLIM EFFET NEIGE";s:8:"quantite";i:1;s:4:"prix";d:60;s:9:"prixreduc";d:58.2000000000000028421709430404007434844970703125;s:13:"tauxreduction";d:3;s:5:"photo";s:10:"img/10.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:7:"azer ff";s:3:"zip";i:1121;s:5:"ville";s:5:"tunis";s:4:"pays";s:2:"TW";}s:11:"facturation";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:21:"FJFV? UYIRTYIUVB JIOM";s:3:"zip";i:5100;s:5:"ville";s:6:"RTFTFF";s:4:"pays";s:2:"TN";}s:9:"prixtotal";d:150;s:9:"prixreduc";d:140.099999999999994315658113919198513031005859375;s:5:"token";s:40:"5c6b1ccc98cab7edf99d7d3d0c68aad12166f9fe";}'),
(31, 20, 1, '2016-05-10 10:42:08', 25, 'a:7:{s:9:"reduction";a:1:{s:2:"%2";d:11.5999999999999996447286321199499070644378662109375;}s:7:"produit";a:2:{i:16;a:6:{s:3:"nom";s:35:"sweat imprimé boudeuse gris chiné";s:8:"quantite";i:1;s:4:"prix";d:211;s:9:"prixreduc";d:206.780000000000001136868377216160297393798828125;s:13:"tauxreduction";d:2;s:5:"photo";s:9:"img/3.jpg";}i:72;a:6:{s:3:"nom";s:30:"PANTALON REGULAR TOUCHER DOUX ";s:8:"quantite";s:1:"3";s:4:"prix";d:123;s:9:"prixreduc";d:120.5400000000000062527760746888816356658935546875;s:13:"tauxreduction";d:2;s:5:"photo";s:10:"img/12.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:21:"FJFV? UYIRTYIUVB JIOM";s:3:"zip";i:5100;s:5:"ville";s:6:"RTFTFF";s:4:"pays";s:2:"TN";}s:11:"facturation";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:7:"fffffff";s:3:"zip";i:1111;s:5:"ville";s:4:"ffff";s:4:"pays";s:2:"AC";}s:9:"prixtotal";d:580;s:9:"prixreduc";d:568.3999999999999772626324556767940521240234375;s:5:"token";s:40:"2df340d4a7399624256318a290e1ec62e29ef7a3";}'),
(32, 20, 1, '2016-05-10 10:43:00', 26, 'a:7:{s:9:"reduction";a:1:{s:2:"%2";d:4.9000000000000003552713678800500929355621337890625;}s:7:"produit";a:1:{i:75;a:6:{s:3:"nom";s:32:"PARKA MI-SAISON STYLE COUPE-VENT";s:8:"quantite";i:1;s:4:"prix";d:245;s:9:"prixreduc";d:240.099999999999994315658113919198513031005859375;s:13:"tauxreduction";d:2;s:5:"photo";s:10:"img/18.jpg";}}s:9:"livraison";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:21:"FJFV? UYIRTYIUVB JIOM";s:3:"zip";i:5100;s:5:"ville";s:6:"RTFTFF";s:4:"pays";s:2:"TN";}s:11:"facturation";a:6:{s:6:"prenom";s:0:"";s:3:"nom";s:0:"";s:7:"adresse";s:21:"FJFV? UYIRTYIUVB JIOM";s:3:"zip";i:5100;s:5:"ville";s:6:"RTFTFF";s:4:"pays";s:2:"TN";}s:9:"prixtotal";d:245;s:9:"prixreduc";d:240.099999999999994315658113919198513031005859375;s:5:"token";s:40:"2f0855a42ed17da95f8d9aea1a46b74fd1377b2f";}');

-- --------------------------------------------------------

--
-- Structure de la table `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `thread_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `author_id` int(11) DEFAULT NULL,
  `body` longtext COLLATE utf8_unicode_ci NOT NULL,
  `ancestors` varchar(1024) COLLATE utf8_unicode_ci NOT NULL,
  `depth` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `state` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_5BC96BF0E2904019` (`thread_id`),
  KEY `IDX_5BC96BF0F675F31B` (`author_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=46 ;

--
-- Contenu de la table `comment`
--

INSERT INTO `comment` (`id`, `thread_id`, `author_id`, `body`, `ancestors`, `depth`, `created_at`, `state`, `score`) VALUES
(44, '13', 20, 'rtf', '', 0, '2016-04-11 21:18:42', 0, 0),
(45, '13', NULL, 'azerty', '', 0, '2016-04-12 15:20:08', 0, 3);

-- --------------------------------------------------------

--
-- Structure de la table `commentaires`
--

CREATE TABLE IF NOT EXISTS `commentaires` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `idclient` int(11) DEFAULT NULL,
  `idproduit` int(11) NOT NULL,
  `commentaire` text NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `idclient` (`idclient`,`idproduit`),
  KEY `idclient_2` (`idclient`),
  KEY `fk_pr` (`idproduit`),
  KEY `FK_CARTE_com_client` (`idclient`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `correspondance_produit`
--

CREATE TABLE IF NOT EXISTS `correspondance_produit` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `REFERENCE` varchar(50) NOT NULL,
  `ID_MARQUE` int(11) NOT NULL,
  `NOM` varchar(50) NOT NULL,
  `TYPE` varchar(50) NOT NULL,
  `PRIX` float NOT NULL,
  `TAUX_REDUCTION` float NOT NULL,
  `NOMBRE_POINT` int(11) NOT NULL,
  `PHOTO` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(100) NOT NULL,
  `QUANTITE` int(11) NOT NULL,
  `QUANTITE_VENDU` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `REFERENCE` (`REFERENCE`),
  KEY `FK_MARQUE` (`ID_MARQUE`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `correspondance_produit`
--

INSERT INTO `correspondance_produit` (`ID`, `REFERENCE`, `ID_MARQUE`, `NOM`, `TYPE`, `PRIX`, `TAUX_REDUCTION`, `NOMBRE_POINT`, `PHOTO`, `DESCRIPTION`, `QUANTITE`, `QUANTITE_VENDU`) VALUES
(1, 'EAN-13:6194009710443', 1, 'THE - VERT', 'HACHICH', 0, 0, 0, 'D:\\PI-DEV\\PI-DEV_safwene\\src\\edu\\esprit\\tunisiamall\\images\\lipton.jpg', 'DU THE VERT BU ET DEGUSTE PAR SAFWENE', 0, 0),
(3, 'EAN-8:61940024', 1, 'MARS - LEGERE', 'TABAC', 0, 0, 0, 'D:\\PI-DEV\\PI-DEV_safwene\\src\\edu\\esprit\\tunisiamall\\images\\mars_inter_legere.jpg', 'DOKHAN', 0, 0),
(4, 'EAN-13:6192008320434', 1, 'KLAMROMIN', 'ANTIBIOTIQUE', 0, 0, 0, 'D:\\PI-DEV\\PI-DEV_safwene\\src\\edu\\esprit\\tunisiamall\\images\\Klaromin.jpg', 'De l''antibiotique !', 0, 0),
(5, 'EAN-13:9109012829706', 1, 'Clefs de la voiture de mouna', 'Clefs', 0, 0, 0, 'src\\edu\\esprit\\tunisiamall\\images\\carrefour.jpg', 'carte fidilite carrefour', 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `espace_publicitaire`
--

CREATE TABLE IF NOT EXISTS `espace_publicitaire` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_MARQUE` int(11) DEFAULT NULL,
  `DATE_DEBUT` date NOT NULL,
  `DATE_FIN` date NOT NULL,
  `AFFICHE` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ESPACE_PUBLICITAIRE_MARQUE` (`ID_MARQUE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `livraison`
--

CREATE TABLE IF NOT EXISTS `livraison` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PANIER` int(11) DEFAULT NULL,
  `DATE_LIVRAISON` date NOT NULL,
  `ADRESSE` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ID_PANIER` (`ID_PANIER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `local`
--

CREATE TABLE IF NOT EXISTS `local` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ADRESSE` varchar(50) NOT NULL,
  `ETAT` int(11) NOT NULL,
  `EMPLACEMENT` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ADRESSE` (`ADRESSE`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `local`
--

INSERT INTO `local` (`ID`, `ADRESSE`, `ETAT`, `EMPLACEMENT`) VALUES
(1, 'ADRESSE_LOCAL', 1, 'EMPLACEMENT_LOCAL'),
(2, 'ADRESSE_LOCAL_2', 0, 'EMPLACEMENT_LOCAL_2');

-- --------------------------------------------------------

--
-- Structure de la table `marque`
--

CREATE TABLE IF NOT EXISTS `marque` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) NOT NULL,
  `seuilAchat` float NOT NULL,
  `ID_RESPONSABLE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Nom` (`Nom`),
  KEY `FK_CARTE_FIDILITE_USER` (`ID_RESPONSABLE`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Contenu de la table `marque`
--

INSERT INTO `marque` (`ID`, `Nom`, `seuilAchat`, `ID_RESPONSABLE`) VALUES
(10, 'Zara', 120, 30),
(11, 'Jennyfer', 120, 16),
(12, 'Bershka', 150, 17);

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

CREATE TABLE IF NOT EXISTS `panier` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CLIENT` int(11) DEFAULT NULL,
  `ID_PRODUIT` int(11) DEFAULT NULL,
  `QUANTITE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PANIER_CLIENT` (`ID_CLIENT`),
  KEY `FK_PANIER_PRODUIT` (`ID_PRODUIT`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=47 ;

--
-- Contenu de la table `panier`
--

INSERT INTO `panier` (`ID`, `ID_CLIENT`, `ID_PRODUIT`, `QUANTITE`) VALUES
(4, 15, 16, 1),
(9, 15, 16, 1),
(16, 15, 17, 4),
(17, 15, 18, 1),
(25, 15, 18, 1),
(31, 20, 20, 1),
(34, 29, 72, 1),
(35, 29, 65, 1),
(36, 29, 60, 2),
(39, 29, 62, 4),
(40, 29, 73, 1),
(41, 20, 63, 1),
(42, 20, 64, 9),
(43, 20, 70, 1),
(44, 20, 72, 3),
(45, 20, 16, 1),
(46, 20, 75, 1);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE IF NOT EXISTS `produit` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `REFERENCE` varchar(50) NOT NULL,
  `ID_MARQUE` int(11) DEFAULT NULL,
  `NOM` varchar(50) NOT NULL,
  `TYPE` varchar(255) NOT NULL,
  `PRIX` float NOT NULL,
  `TAUX_REDUCTION` float NOT NULL,
  `NOMBRE_POINT` int(11) NOT NULL,
  `PHOTO` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(100) NOT NULL,
  `QUANTITE` int(11) NOT NULL,
  `QUANTITE_VENDU` int(11) NOT NULL,
  `Taille` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `REFERENCE` (`REFERENCE`),
  KEY `FK_MARQUE` (`ID_MARQUE`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=79 ;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`ID`, `REFERENCE`, `ID_MARQUE`, `NOM`, `TYPE`, `PRIX`, `TAUX_REDUCTION`, `NOMBRE_POINT`, `PHOTO`, `DESCRIPTION`, `QUANTITE`, `QUANTITE_VENDU`, `Taille`) VALUES
(16, 'REF321222', 11, 'sweat imprimé boudeuse gris chiné', 'Femme sweat-shirts', 211, 2, 2, 'img/3.jpg', 'Sweat femme, gris chiné, imprimé boudeuse, loose, col rond, manches 3/4.matière : polyester 33 %,', 23, 21, 's'),
(17, 'REF321091', 11, 'foulard imprimé cachemire écru et bleu marine', 'Femme accessoires', 211, 2, 2, 'img/5.jpg', 'foulard imprimé cachemire écru et bleu marine', 23, 20, 's'),
(18, 'REF3287', 11, 'bottines à franges camel', 'Femme chaussures bottines', 211, 2, 2, 'img/6.jpg', 'Bottines à talons femme, camel, suédine, franges œillets doré, fermeture zip, talons 7 cm.matière ', 23, 21, 's'),
(19, 'REF31', 11, 'escarpins suédine noirs', 'Femme chaussures escarpins', 211, 2, 2, 'img/9.jpg', 'Bottines à talons femme, camel, suédine, franges œillets doré, fermeture zip, talons 7 cm.matière ', 23, 20, 's'),
(20, 'ref14424', 10, 'za', 'Femme jeans', 21, 1, 2, 'img/2.jpg', 'd,,fefreroitr', 2, 1, 'S'),
(59, 'REF1223', 10, 'Blouson noir fermeture a pression', 'Femme vestes', 120, 10, 9, 'img/1.jpg', 'DESCRIPTION : refdekfdnfdkj', 29, 22, 's'),
(60, 'REF2234', 11, 'baskets', 'Femme chaussures baskets', 50, 20, 3, 'img/2.jpg', 'DSDSF', 33, 5, 'm'),
(61, 'REF2213', 10, 'jegging en jean brut', 'Femme jeans', 50, 60, 3, 'img/4.jpg', 'Jegging en jean femme basic, brut, 2 fausses poches avant, 2 poches dos, fermeture zippée boutonnée.', 35, 2, 'l'),
(62, 'REF2235', 12, 'sweat imprimé boudeuse gris chiné', 'Femme sweat-shirts', 30, 5, 3, 'img/3.jpg', 'Sweat femme, gris chiné, imprimé boudeuse, loose, col rond, manches 3/4.\r\nmatière : polyester 33 %, ', 65, 8, 'm'),
(63, 'REF3343', 11, 'jegging en jean medium blue', 'Femme pantalons', 60, 10, 3, 'img/2.jpg', 'Jegging en jean femme basic, medium blue, 2 fausses poches avant, 2 poches dos, fermeture zippée bou', 98, 5, 'l'),
(64, 'REF2323', 11, 'foulard imprimé cachemire écru et bleu marine', 'Femme pantalons', 10, 9, 2, 'img/5.jpg', 'Foulard femme, écru, imprimé cachemire et arabesque, bleu marine et rose, finitions petits pompons.\r', 437, 21, 's'),
(65, 'REF3244', 10, 'bottines à franges camel', 'Femme chaussures bottines', 99, 30, 3, 'img/6.jpg', 'Bottines à talons femme, camel, suédine, franges œillets doré, fermeture zip, talons 7 cm.\r\nmatière ', 43, 34, 'S'),
(66, 'REF2366', 12, 'escarpins suédine noirs', 'Femme chaussures escarpins', 100, 0, 10, 'img/9.jpg', 'Chaussures escarpins femme, noir, effet suédine, talons 10 cm.\r\nmatière : textile 100 %', 43, 21, 's'),
(67, 'REF323234', 10, 'baskets', 'Femme combinaisons', 29, 10, 2, 'img/1.jpg', 'EJK FJEKFE FDJEKL', 324, 21, 'L'),
(68, 'REF677', 12, 'JKJKJ', 'Homme jeans', 120, 0, 3, 'img/2.jpg', 'JKLJLKJ JOJ', 22, 22, 'm'),
(69, 'REF37782', 12, 'TEE-SHIRT COTON IMPRIMÉ', 'Enfant t-shirts', 45, 9, 9, 'img/1.jpg', 'vetements pour enfants', 55, 21, 'S'),
(70, 'REF7832', 12, 'JEAN SLIM EFFET NEIGE', 'Enfant jeans', 60, 3, 3, 'img/10.jpg', 'Le jean slim des petites modeuses ! \r\n- Jean slim / coupe ajustée ', 67, 5, 'l'),
(71, 'REF22134', 11, 'ROBE SALOPETTE EN DENIM', 'Enfant robes', 32, 3, 3, 'img/11.jpg', 'Ouverture boucle métallique sur bretelles', 120, 2, 'M'),
(72, 'REF324', 10, 'PANTALON REGULAR TOUCHER DOUX ', 'Homme pantalons', 123, 2, 2, 'img/12.jpg', 'Pantalon 5 poches ', 45, 28, 'S'),
(73, 'REF343', 10, 'Yves Saint Laurent', 'Femme accessoires', 200, 0, 0, 'img/15.jpg', 'Black Opium, le nouveau parfum féminin par Yves Saint Laurent. Une dose d''adrénaline, pour une héroï', 10, 4, '200'),
(74, 'REF3232345', 10, 'Ciaté', 'Femme accessoires', 23, 0, 0, 'img/16.jpg', 'Ce masque de nuit pour les ongles est une petite merveille et va révolutionner votre routine de beau', 234, 2, 's'),
(75, 'REF356', 11, 'PARKA MI-SAISON STYLE COUPE-VENT', 'Femme manteau', 245, 2, 1, 'img/18.jpg', '- Parka mi-saison', 25, 3, 'm'),
(76, 'REF5665', 11, 'SAHARIENNE FLUIDE EFFET PEAU DE PÊCHE', 'Femme vestes', 456, 3, 0, 'img/19.jpg', 'Veste style saharienne ', 356, 23, 'm'),
(77, 'REF435', 11, 'I LOVE SHOES Kizup', 'Femme chaussures escarpins', 298, 2, 2, 'img/20.jpg', 'DSDS', 324, 32, 'S'),
(78, 'EAN-8:61940024', 10, 'MARS - LEGERE', 'TABAC', 2.7, 20, 15, 'D:\\PI-DEV\\PI-DEV_safwene\\src\\edu\\esprit\\tunisiamall\\images\\mars_inter_legere.jpg', 'DOKHAN', 3000, 0, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `rating`
--

CREATE TABLE IF NOT EXISTS `rating` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `num_votes` int(11) NOT NULL,
  `rate` decimal(4,1) NOT NULL,
  `security_role` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `permalink` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `rating`
--

INSERT INTO `rating` (`id`, `num_votes`, `rate`, `security_role`, `permalink`, `created_at`) VALUES
('14', 1, '4.0', 'IS_AUTHENTICATED_FULLY', 'http://localhost/TunisiaMallLebes/web/app_dev.php/produits/14', '2016-04-19 15:40:44'),
('29', 1, '2.0', 'IS_AUTHENTICATED_FULLY', 'http://localhost/TunisiaMallLebes/web/app_dev.php/produits/76', '2016-04-19 15:28:58'),
('60', 0, '0.0', 'IS_AUTHENTICATED_FULLY', 'http://localhost/TunisiaMallLebes/web/app_dev.php/produits/60', '2016-05-09 21:53:44'),
('70', 0, '0.0', 'IS_AUTHENTICATED_FULLY', 'http://localhost/TunisiaMallLebes/web/app_dev.php/produits/70', '2016-04-19 15:42:11'),
('76', 2, '2.0', '''ROLE_USER''', 'http://localhost/TunisiaMallLebes/web/app_dev.php/produits/76', '2016-04-19 15:02:54');

-- --------------------------------------------------------

--
-- Structure de la table `thread`
--

CREATE TABLE IF NOT EXISTS `thread` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `permalink` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `is_commentable` tinyint(1) NOT NULL,
  `num_comments` int(11) NOT NULL,
  `last_comment_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `thread`
--

INSERT INTO `thread` (`id`, `permalink`, `is_commentable`, `num_comments`, `last_comment_at`) VALUES
('13', 'http://localhost/TunisiaMallLebes/web/app_dev.php/produits/13', 1, 2, '2016-04-12 15:20:08'),
('14', 'http://localhost/TunisiaMallLebes/web/app_dev.php/produits/14', 1, 0, NULL),
('15', 'http://localhost/TunisiaMallLebes/web/app_dev.php/produits/15', 1, 0, NULL),
('16', 'http://localhost/TunisiaMallLebes/web/app_dev.php/produits/16', 1, 0, NULL),
('70', 'http://localhost/TunisiaMallLebes/web/app_dev.php/produits/70', 1, 0, NULL),
('76', 'http://localhost/TunisiaMallLebes/web/app_dev.php/produits/76', 1, 0, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `twitter`
--

CREATE TABLE IF NOT EXISTS `twitter` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CONSUMER_KEY` varchar(200) NOT NULL,
  `CONSUMER_SECRET` varchar(200) NOT NULL,
  `ACCESS_TOKEN` varchar(200) NOT NULL,
  `ACCESS_TOKEN_SECRET` varchar(200) NOT NULL,
  `ID_RESPONSABLE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CONSUMER_KEY` (`CONSUMER_KEY`,`CONSUMER_SECRET`,`ACCESS_TOKEN`,`ACCESS_TOKEN_SECRET`),
  KEY `FK_TWITTER_RESPONSABLE_ENSEIGNE` (`ID_RESPONSABLE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CIN` varchar(50) DEFAULT NULL,
  `NOM` varchar(50) NOT NULL,
  `PRENOM` varchar(50) NOT NULL,
  `SEXE` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `QRCODE` varchar(100) DEFAULT NULL,
  `TELEPHONE` varchar(50) DEFAULT NULL,
  `IMAGE` varchar(500) DEFAULT NULL,
  `ADRESSE` varchar(300) NOT NULL,
  `ROLE` varchar(50) NOT NULL,
  `ETAT` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `username_canonical` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `email_canonical` varchar(255) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `salt` varchar(255) NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `locked` tinyint(1) NOT NULL,
  `expired` tinyint(1) NOT NULL,
  `expires_at` datetime DEFAULT NULL,
  `confirmation_token` varchar(255) DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext NOT NULL COMMENT '(DC2Type:array)',
  `credentials_expired` tinyint(1) NOT NULL,
  `credentials_expire_at` datetime DEFAULT NULL,
  `facebook_id` varchar(255) DEFAULT NULL,
  `facebook_access_token` varchar(255) DEFAULT NULL,
  `google_id` varchar(255) DEFAULT NULL,
  `google_access_token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNIQ_8D93D64992FC23A8` (`username_canonical`),
  UNIQUE KEY `UNIQ_8D93D649A0D96FBF` (`email_canonical`),
  UNIQUE KEY `CIN` (`CIN`,`TELEPHONE`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=59 ;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`ID`, `CIN`, `NOM`, `PRENOM`, `SEXE`, `password`, `QRCODE`, `TELEPHONE`, `IMAGE`, `ADRESSE`, `ROLE`, `ETAT`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `last_login`, `locked`, `expired`, `expires_at`, `confirmation_token`, `password_requested_at`, `roles`, `credentials_expired`, `credentials_expire_at`, `facebook_id`, `facebook_access_token`, `google_id`, `google_access_token`) VALUES
(1, NULL, '', '', '', 'v+0fflmB840rFk2QOixBM+pLpq1XgzPdCQ8iCbK44qjIzErEbMaewDvRMNW7v61dwJ3Q2+mwz1m3W4EfgFt6aQ==', NULL, NULL, NULL, '', '', 0, 'fatmaR', 'fatmaR', 'fatma.jaafarT@esprit.tn', 'fatma.jaafart@esprit.tn', 1, 'duc5vu5rlu044o8cg8css4gwc40wgo0', '2016-03-28 15:41:12', 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL, NULL, NULL, NULL, NULL),
(2, NULL, '', '', '', 'VWxeUtYExAV2LRSvpfv3qq1278PIRRjGlWXUhvFRD1ieu3jR7wkAi+6/GqcGb1SzGYQ4ahtzI0+vdUQ03gs6rg==', NULL, NULL, NULL, '', '', 0, 'mohamed', 'mohamed', 'mohamet.jaafar@gmail.com', 'mohamet.jaafar@gmail.com', 1, 'aj8lvwo8hs000ko0o8008gcgok8sws4', '2016-03-28 12:46:07', 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL, NULL, NULL, NULL, NULL),
(3, NULL, '', '', '', '5twgOyDqToYfxik9XJvgAvoIex3URe0i7TUxuam7LmkoR+SbD64g9oMteXZNrok2KA0qbdUqE3UF3q91pqgbpQ==', NULL, NULL, NULL, '', '', 0, 'aaaaa', 'aaaaa', 'fatma.jaafr@esprit.tn', 'fatma.jaafr@esprit.tn', 1, '5lqf2pbpsbggwkc0oo0s4wsg8cc40g4', '2016-03-28 15:45:04', 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL, NULL, NULL, NULL, NULL),
(15, '121221', 'Khouja', 'Saida', 'Femme', 'd02af1bea6b820ad52b8804c249f0cfa0cb1a4c8761fd63987c6a1319bfe1e2c6116f03ba9d5c69569d7442732a06e2a77e357a209d18378cdb8838069613f26', NULL, NULL, NULL, '', 'CLIENT', 1, 'Saida', 'saida', 'fatma.jaa@esprit.tn', 'fatma.jaa@esprit.tn', 1, 'muehuva9ro0c8cskswcc84gsso808os', '2016-04-05 15:35:34', 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL, NULL, NULL, NULL, NULL),
(16, '2223223', 'Jaf', 'Taipon', 'Homme', 'e5lge2/XbDwC0uw2bG0WJYU6V4iMTVycL4XUr/djU/hO8GwbywZwlnISoJvMizEJIMlxIOe60ZcX98N9nu65OQ==', NULL, NULL, NULL, '', 'CLIENT', 1, 'Taipon', 'taipon', 'Tibou@gmail.com', 'tibou@gmail.com', 1, 'c5lopbfqh7so0ooksokwgw48ksc08gg', NULL, 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL, NULL, NULL, NULL, NULL),
(17, '22288983', 'Jaf', 'Stoufaaa', 'Homme', 'ofFTpS9CP5kqrNDb8ZX+54jzDGUWkw4Ftso2NZ+XskTAWx8Pra+lI2gqFomZEprB7uLx1pDs7eLZw4I/6BZxig==', NULL, NULL, NULL, '', 'CLIENT', 1, 'stoufa', 'stoufa', 'stoufa@gmail.com', 'stoufa@gmail.com', 1, 'o677aor7h8g0k88wccc80swogw0wgok', NULL, 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL, NULL, NULL, NULL, NULL),
(18, NULL, '', '', '', 'iIgXuVxYw929hqxP1u9hc7mF8K5wWO3RE6AoEw+fUpi34w3FLHDTLpkfPIiev4m6gR4lCA4xjiM6rn6GfZ9d/g==', NULL, NULL, NULL, '', '', 0, 'azerty', 'azerty', 'rttrrt.ooii@jj.kko', 'rttrrt.ooii@jj.kko', 1, '4gzyjq1jbk4kc4ooscosowogckks0k4', '2016-03-31 03:58:26', 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL, NULL, NULL, NULL, NULL),
(19, NULL, '', '', '', 'KzM2Qvs80qHqkGUD8MzWrSI6ipSbFZe7D5sW7A6Fioo0tus3xj0zMAMY5fiKKjO52pHwy6tekB/gPCrSNarvWg==', NULL, NULL, NULL, '', '', 0, 'moha', 'moha', 'mohamed.jaafar@gmail.com', 'mohamed.jaafar@gmail.com', 1, 'qho3tfvniv4w0g4wg8kc0k0gwc4swso', '2016-04-03 04:52:47', 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL, NULL, NULL, NULL, NULL),
(20, NULL, '', '', '', 'ms5TBNe40PDHGCZ8DiwuacGSbTNZfgmkHJaLI0HAPEzubMGMF+2mwWfNqcHRbNZnDIdkOLKz1WW+QNmxIbGJgg==', NULL, NULL, NULL, '', '', 0, 'fatma', 'fatma', 'fatma.jaafar404@gmail.com', 'fatma.jaafar404@gmail.com', 1, '3wmu1pbnqhoggsk0wgok408c04gkw40', '2016-05-10 12:48:46', 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL, NULL, NULL, NULL, NULL),
(21, NULL, '', '', '0', 'NfrA4BfUtxgoao4jU3TNV/8mkSvVajoQxxY/c8WDuQqZaGEdonyL276bdKiteOYz7fEzPc9xM/IwvKIw6R1j+Q==', NULL, NULL, NULL, '', '', 0, 'taiponN', 'taiponn', 'taipon.jaf@gmail.com', 'taipon.jaf@gmail.com', 1, '7ryai5o9jq0w80gg0gook8o80gowkg0', '2016-04-17 15:03:36', 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL, NULL, NULL, NULL, NULL),
(22, NULL, '', '', '1', '9gZzJ6M2/bZZxtSHQzYqjQr4WsdlevSOic11B/Z3kW4KOnc7kjNy+qsyCUt4h0X5pouPM7xPxt2fGF2HOAIRFg==', NULL, NULL, NULL, '', '', 0, 'taiponIUOJ', 'taiponiuoj', 'taipoJKn.jaf@gmail.com', 'taipojkn.jaf@gmail.com', 1, '47zzpv6d7ao0o48ccs880ogo8sk8s84', '2016-04-17 15:08:42', 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL, NULL, NULL, NULL, NULL),
(23, NULL, '', '', 'Femme', 'w9wqZ22aEFP9/BSauPoCfUeRaQZ4Qx/lfr0mgjPN3kbd27ACjl/LyT+Z6rr6NLR1xdQ88/9tETQa8OZiFVa50A==', NULL, NULL, NULL, '', '', 0, 'taiponIUOJ,ji,iik,;ji', 'taiponiuoj,ji,iik,;ji', 'taipcfyvcbufynvbnbjon.jaf@gmail.com', 'taipcfyvcbufynvbnbjon.jaf@gmail.com', 1, 'ky6ffv9ngxcsgow8s40cgowsscc4c8g', '2016-04-17 15:11:18', 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL, NULL, NULL, NULL, NULL),
(25, NULL, 'Jaaf', 'Fat', 'Femme', 'EJXU+XRk6WrK4NEG7ZbYkgftq3y82hSHZ9xmnujWf07G6wV5P+T+1sM6RWtJYYv390OUVCYrSNuVQkSqo04c1g==', NULL, NULL, NULL, '', '', 0, 'fatt', 'fatt', 'fat.dsds@dsds.ds', 'fat.dsds@dsds.ds', 1, '9j9gzr1qqvwg44g4c040sc8wksos4ss', '2016-04-17 16:00:49', 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL, NULL, NULL, NULL, NULL),
(26, NULL, 'rere', 'fd', 'Femme', 'QMxlBFyLk3ZzCac76rR3lwq3eUcPVA0ZhrqwqsZm/xDm4JMxoHa1e9q8d3VaIy1ulvSfuv7brWbS6+O8B21xvA==', NULL, NULL, NULL, '', '', 0, 'fedfd', 'fedfd', 'bdfbfvb.ikyikyu@ujtyjy.ky', 'bdfbfvb.ikyikyu@ujtyjy.ky', 1, 'aitb82yku40s8ss4kosw4wwsoc8w4w8', '2016-04-17 16:06:25', 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL, NULL, NULL, NULL, NULL),
(27, NULL, 'ttt', 'ttt', 'Femme', '5KZYwF9zwtpgr2FKny6vCdyX6nBLZ/WdoycK5qWeT7Yn3/ZIE266EthBgA9a1OmoLKRUmrUmh0SAZZW/ePxLNg==', NULL, NULL, NULL, '', '', 0, 'tttr', 'tttr', 'bdfbfvb.ikyikyu@ujtytrdft.oi', 'bdfbfvb.ikyikyu@ujtytrdft.oi', 1, 'qf6ltqlesyog0sk40ww4cwookg0wk4k', '2016-04-17 16:13:25', 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL, NULL, NULL, NULL, NULL),
(28, NULL, '', '', '', '106709881391563232490', NULL, NULL, NULL, '', '', 0, '106709881391563232490', '106709881391563232490', '106709881391563232490', '106709881391563232490', 1, 'al67j0r89nkk8kgcs80o08ggw8ogw8o', '2016-04-19 03:14:30', 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL, NULL, NULL, '106709881391563232490', 'ya29..yQKkqwA04568wedJYrfjhme1skhgle5VpCiQa50r820lt3Iv0PUUETA0nsbThD04oA'),
(29, NULL, '', '', '', '794847800659179', NULL, NULL, NULL, '', '', 0, '794847800659179', '794847800659179', '794847800659179', '794847800659179', 1, 'go9g0guyyigwsk40w440gwcgoskgkww', '2016-04-19 13:59:48', 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL, '794847800659179', 'CAAUfCHYo72sBABnQg5nzGkTK6TIrA9Td5NThDyFi4A1q5pRLiTKXLasgsGPydpC6sRgNYRoJZC6YBC3ntgJ3qi7xUZBTJBS7apLvCgvtKSiV6WyOEZBcDb5qFmcl2e5ZBO15HKkY7mdfvescbYuax6ZCQyPVAeZBkvLXcZC6Rsl6dbpYeIdULvko9KnlGc19BZAWluXhidZC1faSSJ72Dq5Mr', NULL, NULL),
(30, '11379025', 'Ben Aich', 'Safwene', 'Homme', '4cc9891557b28bedfe7ab972e35c099b11f8047207a247de5cb42c052e140ff29c1c70ad09557362c2d98965abcf3f36250b370724501def02fea6a386ed988f', 'http://www.esprit.tn', '0021692657478', 'src\\edu\\esprit\\tunisiamall\\images\\safwene_benaich.jpg', 'Maison 38 Rue de Zeryeb, Résidence Al-nasim, El Bhira, Bizerte, Tunis', 'RESPONSABLE', 1, '1111', '1111a', 'safwene.benaich@esprit.tn', 'safwene.benaich@esprit.tn', 2, '4qdr7dmqwcg0kgkww0gsc040cckgc44', NULL, 2, 2, NULL, NULL, NULL, '0', 1, NULL, NULL, NULL, NULL, NULL),
(31, '11379841', 'Boughanmi', 'Mohamed Ali', 'Homme', '4cc9891557b28bedfe7ab972e35c099b11f8047207a247de5cb42c052e140ff29c1c70ad09557362c2d98965abcf3f36250b370724501def02fea6a386ed988f', NULL, NULL, NULL, 'ADRESSE TEST', 'ADMIN', 1, '2222', '2222a', 'mail@mail.com', 'mail@mail.coma', 2, '4qdr7dmqwcg0kgkww0gsc040cckgc44', NULL, 2, 2, NULL, NULL, NULL, '', 1, NULL, NULL, NULL, NULL, NULL),
(45, 'fqlksfjlk', 'kl', 'j', 'HOMME', 'sfqfq', 'fqsfqf', 'kjl', 'ljl', 'jlj', 'RESPONSABLE', 2, 'fqsfsq', 'fqsfsqcanonical', 'fqsfq', 'fqsfqcanonincal', 1, 'SALT', NULL, 0, 0, NULL, NULL, NULL, '0', 0, NULL, NULL, NULL, NULL, NULL),
(51, 'qsjlkfhsqkjjk', 'khk', 'jh', 'HOMME', 'khk', 'hjkj', 'hjk', 'kjh', 'hj', 'RESPONSABLE', 2, 'khj', 'khjcanonical', 'h', 'hcanonincal', 1, 'SALT', NULL, 0, 0, NULL, NULL, NULL, '0', 0, NULL, NULL, NULL, NULL, NULL),
(54, 'fqslkjfsqlkjfljl', 'llkjlkj', 'lkjlj', 'HOMME', 'lj', 'klj', 'lkj', 'lkj', 'jl', 'RESPONSABLE', 2, 'lj', 'ljcanonical', 'lj', 'ljcanonincal', 1, 'BFF8060918939E1B21E5796CC617A827', NULL, 0, 0, NULL, NULL, NULL, '0', 0, NULL, NULL, NULL, NULL, NULL),
(55, 'flqksflkjfslkjqflkj', 'lkjljk', 'lkj', 'HOMME', 'a41f14b87d958d0cd26951a10e88b2eda8acbaaa12a730dea25ac39e8612de5ea64bd7a1e03693a8a3bf0c35cd1adcf0553cadca8d5c10e9e359729e78d705f1', 'kjlj', 'lkj', 'lj', 'lkj', 'RESPONSABLE', 2, 'jlj', 'jljcanonical', 'kfs', 'kfscanonincal', 1, '52A65DD3663C43570A0ADA82816B5E62', NULL, 0, 0, NULL, NULL, NULL, '0', 0, NULL, NULL, NULL, NULL, NULL),
(56, 'lfk)lkfsqjlksfjlk', 'jlkjljlj', 'kjljlj', 'HOMME', '', 'jlkjfsqlkj', 'lkjljlj', 'ljlkjljkl', 'lkjl', 'RESPONSABLE', 2, 'lkjlkjl', 'lkjlkjlcanonical', 'kljlqskjflkqjf', 'kljlqskjflkqjfcanonincal', 1, '90CAAE0B3501A71B870160F379D9C257', NULL, 0, 0, NULL, NULL, NULL, '0', 0, NULL, NULL, NULL, NULL, NULL),
(58, '1134654', 'jlkjsqflkqkj', 'jlkjlkjlkj', 'HOMME', '94a1f51af54bad9fac84a784a051d2717c709bd3bfa24faddc2e81eebaa1bfb2f68124b1a66b1f542c44d7f56bcc9de5ef2cdb54db830408267c6981febffef7', 'klsjflkqsfj', 'jlkjlkjlkj', 'jkljljl', 'flsqkjflkjk', 'RESPONSABLE', 1, 'lksfqlkjflkj', 'lksfqlkjflkjcanonical', 'fatma.jaafar@esprit.tn', 'fatma.jaafar@esprit.tncanonincal', 1, 'C8E61C386ECBE0101DAFCF7B82BBDA01', NULL, 0, 0, NULL, NULL, NULL, '0', 0, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `user_modification`
--

CREATE TABLE IF NOT EXISTS `user_modification` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CIN` varchar(50) NOT NULL,
  `NOM` varchar(50) NOT NULL,
  `PRENOM` varchar(50) NOT NULL,
  `SEXE` varchar(255) NOT NULL,
  `LOGIN` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `QRCODE` varchar(100) NOT NULL,
  `MAIL` varchar(50) NOT NULL,
  `ADRESSE` varchar(300) NOT NULL,
  `TELEPHONE` varchar(50) NOT NULL,
  `IMAGE` varchar(500) NOT NULL,
  `ROLE` varchar(50) NOT NULL,
  `ETAT` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Contenu de la table `user_modification`
--

INSERT INTO `user_modification` (`ID`, `CIN`, `NOM`, `PRENOM`, `SEXE`, `LOGIN`, `PASSWORD`, `QRCODE`, `MAIL`, `ADRESSE`, `TELEPHONE`, `IMAGE`, `ROLE`, `ETAT`) VALUES
(30, '11379025', 'Ben Aich', 'Safwene', 'Homme', 'Snizer', 'Crypté', 'http://www.esprit.tn', 'safwene.benaich@esprit.tn', 'Maison 38 Rue de Zeryeb, Résidence Al-nasim, El Bhira, Bizerte, Tunis', '0021692657478', 'src\\edu\\esprit\\tunisiamall\\images\\safwene_benaich.jpg', 'RESPONSABLE', 1);

-- --------------------------------------------------------

--
-- Structure de la table `vote`
--

CREATE TABLE IF NOT EXISTS `vote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_id` int(11) DEFAULT NULL,
  `voter_id` int(11) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `value` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_FA222A5AF8697D13` (`comment_id`),
  KEY `IDX_FA222A5AEBB4B8AD` (`voter_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Contenu de la table `vote`
--

INSERT INTO `vote` (`id`, `comment_id`, `voter_id`, `created_at`, `value`) VALUES
(1, 45, NULL, '2016-04-18 19:14:55', 1),
(2, 45, NULL, '2016-04-18 19:15:11', 1),
(3, 45, NULL, '2016-04-18 19:15:41', 1),
(4, 45, NULL, '2016-04-18 20:17:07', 1),
(5, 45, NULL, '2016-04-18 21:08:40', -1);

-- --------------------------------------------------------

--
-- Structure de la table `voterating`
--

CREATE TABLE IF NOT EXISTS `voterating` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rating_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `voter_id` int(11) DEFAULT NULL,
  `value` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_4C85ABA5A32EFC6` (`rating_id`),
  KEY `IDX_4C85ABA5EBB4B8AD` (`voter_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Contenu de la table `voterating`
--

INSERT INTO `voterating` (`id`, `rating_id`, `voter_id`, `value`, `created_at`) VALUES
(1, '76', 16, 2, '2016-04-14 00:00:00'),
(2, '29', 29, 2, '2016-04-19 15:29:09'),
(3, '14', 29, 4, '2016-04-19 16:22:48');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `adresses`
--
ALTER TABLE `adresses`
  ADD CONSTRAINT `fk_adresses_cli` FOREIGN KEY (`idclient`) REFERENCES `user` (`ID`);

--
-- Contraintes pour la table `boutique`
--
ALTER TABLE `boutique`
  ADD CONSTRAINT `FK_BOUTIQUE_LOCAL` FOREIGN KEY (`ID_LOCAL`) REFERENCES `local` (`ID`),
  ADD CONSTRAINT `FK_BOUTIQUE_MARQUE` FOREIGN KEY (`ID_MARQUE`) REFERENCES `marque` (`ID`);

--
-- Contraintes pour la table `carte_fidilite`
--
ALTER TABLE `carte_fidilite`
  ADD CONSTRAINT `FK_CARTE_FIDILITE_CLIENT` FOREIGN KEY (`ID_CLIENT`) REFERENCES `user` (`ID`),
  ADD CONSTRAINT `FK_CARTE_FIDILITE_MARQUE` FOREIGN KEY (`ID_MARQUE`) REFERENCES `marque` (`ID`);

--
-- Contraintes pour la table `catalogue`
--
ALTER TABLE `catalogue`
  ADD CONSTRAINT `FK_CATALOGUE_MARQUE` FOREIGN KEY (`ID_MARQUE`) REFERENCES `marque` (`ID`);

--
-- Contraintes pour la table `commandes`
--
ALTER TABLE `commandes`
  ADD CONSTRAINT `FK_35D4282CFB88E14F` FOREIGN KEY (`utilisateur_id`) REFERENCES `user` (`ID`);

--
-- Contraintes pour la table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FK_5BC96BF0E2904019` FOREIGN KEY (`thread_id`) REFERENCES `thread` (`id`),
  ADD CONSTRAINT `FK_5BC96BF0F675F31B` FOREIGN KEY (`author_id`) REFERENCES `user` (`ID`);

--
-- Contraintes pour la table `commentaires`
--
ALTER TABLE `commentaires`
  ADD CONSTRAINT `FK_D9BEC0C4A3F9A9F9` FOREIGN KEY (`idclient`) REFERENCES `user` (`ID`);

--
-- Contraintes pour la table `espace_publicitaire`
--
ALTER TABLE `espace_publicitaire`
  ADD CONSTRAINT `FK_ESPACE_PUBLICITAIRE_MARQUE` FOREIGN KEY (`ID_MARQUE`) REFERENCES `marque` (`ID`);

--
-- Contraintes pour la table `livraison`
--
ALTER TABLE `livraison`
  ADD CONSTRAINT `FK_ID_PANIER` FOREIGN KEY (`ID_PANIER`) REFERENCES `panier` (`ID`);

--
-- Contraintes pour la table `marque`
--
ALTER TABLE `marque`
  ADD CONSTRAINT `FK_5A6F91CEB9596135` FOREIGN KEY (`ID_RESPONSABLE`) REFERENCES `user` (`ID`);

--
-- Contraintes pour la table `panier`
--
ALTER TABLE `panier`
  ADD CONSTRAINT `FK_PANIER_PRODUIT` FOREIGN KEY (`ID_PRODUIT`) REFERENCES `produit` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_PANIER_CLIENT` FOREIGN KEY (`ID_CLIENT`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `FK_PRODUIT_MARQUE` FOREIGN KEY (`ID_MARQUE`) REFERENCES `marque` (`ID`);

--
-- Contraintes pour la table `twitter`
--
ALTER TABLE `twitter`
  ADD CONSTRAINT `FK_TWITTER_RESPONSABLE_ENSEIGNE` FOREIGN KEY (`ID_RESPONSABLE`) REFERENCES `user` (`ID`);

--
-- Contraintes pour la table `vote`
--
ALTER TABLE `vote`
  ADD CONSTRAINT `FK_FA222A5AEBB4B8AD` FOREIGN KEY (`voter_id`) REFERENCES `user` (`ID`),
  ADD CONSTRAINT `FK_FA222A5AF8697D13` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`id`);

--
-- Contraintes pour la table `voterating`
--
ALTER TABLE `voterating`
  ADD CONSTRAINT `FK_4C85ABA5A32EFC6` FOREIGN KEY (`rating_id`) REFERENCES `rating` (`id`),
  ADD CONSTRAINT `FK_4C85ABA5EBB4B8AD` FOREIGN KEY (`voter_id`) REFERENCES `user` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
