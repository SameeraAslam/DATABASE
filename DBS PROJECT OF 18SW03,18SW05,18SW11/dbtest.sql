-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 09, 2020 at 01:42 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dbtest`
--

-- --------------------------------------------------------

--
-- Table structure for table `billing`
--

CREATE TABLE IF NOT EXISTS `billing` (
  `bill_id` varchar(200) NOT NULL,
  `booking_id` varchar(200) DEFAULT NULL,
  `bill_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `billing`
--

INSERT INTO `billing` (`bill_id`, `booking_id`, `bill_date`) VALUES
('101', 'BI01', '1999-02-04'),
('102', 'BI02', '1999-09-01'),
('103', 'BI03', '1999-08-04'),
('104', 'BI04', '1999-05-09'),
('105', 'BI05', '1999-03-04');

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE IF NOT EXISTS `booking` (
  `booking_id` varchar(200) NOT NULL,
  `amount` int(20) DEFAULT NULL,
  `pickup_location` varchar(200) DEFAULT NULL,
  `dropoff_location` varchar(200) DEFAULT NULL,
  `registration_no` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`booking_id`, `amount`, `pickup_location`, `dropoff_location`, `registration_no`) VALUES
('BI01', 200, 'ABHAN', 'QASIM', 'TY01'),
('BI02', 500, 'HYDRI', 'ABHAN', 'HW02'),
('BI03', 300, 'ABHAN', 'SIYAL', 'CV03'),
('BI04', 400, 'BADIN', 'HYDRI', 'CL04'),
('BI05', 100, 'CANTT', 'BADIN', 'MH05');

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE IF NOT EXISTS `car` (
  `registration_no` varchar(20) NOT NULL,
  `model_name` varchar(200) DEFAULT NULL,
  `model_year` int(20) DEFAULT NULL,
  `location_id` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`registration_no`, `model_name`, `model_year`, `location_id`) VALUES
('CL04', 'CULTUS', 2018, 'CH04'),
('CV03', 'CIVIC', 2017, 'LT03'),
('HW02', 'HONDA', 2016, 'AB02'),
('MH05', 'MEHRAN', 2019, 'DF05'),
('TY01', 'TOYOTA', 2015, 'QS01');

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE IF NOT EXISTS `driver` (
  `driver_id` varchar(200) NOT NULL,
  `location_id` varchar(200) DEFAULT NULL,
  `driver_name` varchar(200) DEFAULT NULL,
  `driver_phone` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`driver_id`, `location_id`, `driver_name`, `driver_phone`) VALUES
('ALR078', 'DF05', 'ALI RAZA', 2147483647),
('AS003', 'QS01', 'AHSAN SHAIKH', 2147483647),
('AZK456', 'CH04', 'AZEEM KHAN', 2147483647),
('SBR064', 'LT03', 'SABIR SAEED', 2147483647),
('URS056', 'AB02', 'UMAR RAZA', 2147483647);

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE IF NOT EXISTS `location` (
  `location_id` varchar(200) NOT NULL,
  `location_name` varchar(200) DEFAULT NULL,
  `location_city` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`location_id`, `location_name`, `location_city`) VALUES
('AB02', 'AUTOBHAN', 'HYD'),
('CH04', 'ABOTABAD', 'HYD'),
('DF05', 'HIRAABAD', 'HYD'),
('LT03', 'LATIFBAD', 'HYD'),
('QS01', 'QASIMBAD', 'HYD');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `billing`
--
ALTER TABLE `billing`
 ADD PRIMARY KEY (`bill_id`), ADD KEY `booking_id` (`booking_id`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
 ADD PRIMARY KEY (`booking_id`), ADD KEY `registration_no` (`registration_no`);

--
-- Indexes for table `car`
--
ALTER TABLE `car`
 ADD PRIMARY KEY (`registration_no`), ADD KEY `location_id` (`location_id`);

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
 ADD PRIMARY KEY (`driver_id`), ADD KEY `location_id` (`location_id`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
 ADD PRIMARY KEY (`location_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `billing`
--
ALTER TABLE `billing`
ADD CONSTRAINT `billing_ibfk_1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_id`);

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
ADD CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`registration_no`) REFERENCES `car` (`registration_no`);

--
-- Constraints for table `car`
--
ALTER TABLE `car`
ADD CONSTRAINT `car_ibfk_1` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`);

--
-- Constraints for table `driver`
--
ALTER TABLE `driver`
ADD CONSTRAINT `driver_ibfk_1` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
