-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 04, 2024 at 09:32 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cars`
--

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `id` int(11) NOT NULL,
  `available` bit(1) NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`id`, `available`, `brand`, `image`, `model`, `price`) VALUES
(1, b'0', 'Marque_1', 'https://img.freepik.com/photos-gratuite/voiture-lu…26&ext=jpg&ga=GA1.1.312708135.1704392981&semt=sph', 'Modèle_1', 20000),
(2, b'0', 'Marque_2', 'https://img.freepik.com/photos-gratuite/vue-voitur…26&ext=jpg&ga=GA1.1.312708135.1704392981&semt=sph', 'Modèle_2', 25000),
(3, b'1', 'Marque_2', 'https://img.freepik.com/photos-premium/phare-voitu…26&ext=jpg&ga=GA1.1.312708135.1704392981&semt=sph', 'Modèle_23', 27000),
(4, b'1', 'Marque_3', 'https://img.freepik.com/photos-gratuite/voiture-ja…26&ext=jpg&ga=GA1.1.312708135.1704392981&semt=sph', 'Modèle_23', 30000),
(5, b'1', 'Marque_6', 'https://img.freepik.com/photos-gratuite/voiture-vi…26&ext=jpg&ga=GA1.1.312708135.1704392981&semt=sph', 'Modèle_1', 20000),
(6, b'1', 'Marque_2', 'https://img.freepik.com/photos-premium/rendu-3d-vo…26&ext=jpg&ga=GA1.1.312708135.1704392981&semt=sph', 'Modele_1', 35000);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `id` int(11) NOT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `car_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`id`, `end_date`, `start_date`, `car_id`, `user_id`) VALUES
(1, '2024-01-12 19:00:00.000000', '2024-01-10 09:00:00.000000', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES
(1, 'john@example.com', 'John', 'Doe', 'password1'),
(2, 'alice@example.com', 'Alice', 'Smith', 'password2'),
(3, 'emma@example.com', 'Emma', 'Johnson', 'password3'),
(4, 'michael@example.com', 'Michael', 'Brown', 'password4');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ey3ve4gydpqnlv2gg6muo79xi` (`car_id`),
  ADD KEY `FKm4oimk0l1757o9pwavorj6ljg` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `car`
--
ALTER TABLE `car`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FKgkmbspv7rljixxoxo1af80lpp` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`),
  ADD CONSTRAINT `FKm4oimk0l1757o9pwavorj6ljg` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
