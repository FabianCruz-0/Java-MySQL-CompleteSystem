-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 04-06-2020 a las 00:33:11
-- Versión del servidor: 8.0.13-4
-- Versión de PHP: 7.2.24-0ubuntu0.18.04.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `zSuTM1gvH0`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Asiento`
--

CREATE TABLE `Asiento` (
  `ID_Asiento` int(110) NOT NULL,
  `Asiento` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `Num_Sala` smallint(30) NOT NULL,
  `Disponibilidad` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `Asiento`
--

INSERT INTO `Asiento` (`ID_Asiento`, `Asiento`, `Num_Sala`, `Disponibilidad`) VALUES
(1, 'A1', 1, 1),
(2, 'A2', 1, 1),
(3, 'A3', 1, 1),
(4, 'A4', 1, 1),
(5, 'A5', 1, 1),
(6, 'A6', 1, 1),
(7, 'A7', 1, 1),
(8, 'A8', 1, 1),
(9, 'A9', 1, 1),
(10, 'A10', 1, 1),
(11, 'B1', 1, 1),
(12, 'B2', 1, 1),
(13, 'B3', 1, 1),
(14, 'B4', 1, 1),
(15, 'B5', 1, 1),
(16, 'B6', 1, 1),
(17, 'B7', 1, 1),
(18, 'B8', 1, 1),
(19, 'B9', 1, 1),
(20, 'B10', 1, 1),
(21, 'C1', 1, 1),
(22, 'C2', 1, 1),
(23, 'C3', 1, 1),
(24, 'C4', 1, 1),
(25, 'C5', 1, 1),
(26, 'C6', 1, 1),
(27, 'C7', 1, 1),
(28, 'C8', 1, 1),
(29, 'C9', 1, 1),
(30, 'C10', 1, 1),
(31, 'D1', 1, 1),
(32, 'D2', 1, 1),
(33, 'D3', 1, 1),
(34, 'D4', 1, 1),
(35, 'D5', 1, 1),
(36, 'D6', 1, 1),
(37, 'D7', 1, 1),
(38, 'D8', 1, 1),
(39, 'D9', 1, 1),
(40, 'D10', 1, 1),
(41, 'E1', 1, 1),
(42, 'E2', 1, 1),
(43, 'E3', 1, 1),
(44, 'E4', 1, 1),
(45, 'E5', 1, 1),
(46, 'E6', 1, 1),
(47, 'E7', 1, 1),
(48, 'E8', 1, 1),
(49, 'E9', 1, 1),
(50, 'E10', 1, 1),
(51, 'F1', 1, 1),
(52, 'F2', 1, 1),
(53, 'F3', 1, 1),
(54, 'F4', 1, 1),
(55, 'F5', 1, 1),
(56, 'F6', 1, 1),
(57, 'F7', 1, 1),
(58, 'F8', 1, 1),
(59, 'F9', 1, 1),
(60, 'F10', 1, 1),
(61, 'G1', 1, 1),
(62, 'G2', 1, 1),
(63, 'G3', 1, 1),
(64, 'G4', 1, 1),
(65, 'G5', 1, 1),
(66, 'G6', 1, 1),
(67, 'G7', 1, 1),
(68, 'G8', 1, 1),
(69, 'G9', 1, 1),
(70, 'G10', 1, 1),
(71, 'H1', 1, 1),
(72, 'H2', 1, 1),
(73, 'H3', 1, 1),
(74, 'H4', 1, 1),
(75, 'H5', 1, 1),
(76, 'H6', 1, 1),
(77, 'H7', 1, 1),
(78, 'H8', 1, 1),
(79, 'H9', 1, 1),
(80, 'H10', 1, 1),
(81, 'I1', 1, 1),
(82, 'I2', 1, 1),
(83, 'I3', 1, 1),
(84, 'I4', 1, 1),
(85, 'I5', 1, 1),
(86, 'I6', 1, 1),
(87, 'I7', 1, 1),
(88, 'I8', 1, 1),
(89, 'I9', 1, 1),
(90, 'I10', 1, 1),
(91, 'J1', 1, 1),
(92, 'J2', 1, 1),
(93, 'J3', 1, 1),
(94, 'J4', 1, 1),
(95, 'J5', 1, 1),
(96, 'J6', 1, 1),
(97, 'J7', 1, 1),
(98, 'J8', 1, 1),
(99, 'J9', 1, 1),
(100, 'J10', 1, 1),
(101, 'A1', 2, 1),
(102, 'A2', 2, 1),
(103, 'A3', 2, 1),
(104, 'A4', 2, 1),
(105, 'A5', 2, 1),
(106, 'A6', 2, 1),
(107, 'A7', 2, 1),
(108, 'A8', 2, 1),
(109, 'A9', 2, 1),
(110, 'A10', 2, 1),
(111, 'B1', 2, 1),
(112, 'B2', 2, 1),
(113, 'B3', 2, 1),
(114, 'B4', 2, 1),
(115, 'B5', 2, 1),
(116, 'B6', 2, 1),
(117, 'B7', 2, 1),
(118, 'B8', 2, 1),
(119, 'B9', 2, 1),
(120, 'B10', 2, 1),
(121, 'C1', 2, 1),
(122, 'C2', 2, 1),
(123, 'C3', 2, 1),
(124, 'C4', 2, 1),
(125, 'C5', 2, 1),
(126, 'C6', 2, 1),
(127, 'C7', 2, 1),
(128, 'C8', 2, 1),
(129, 'C9', 2, 1),
(130, 'C10', 2, 1),
(131, 'D1', 2, 1),
(132, 'D2', 2, 1),
(133, 'D3', 2, 1),
(134, 'D4', 2, 1),
(135, 'D5', 2, 1),
(136, 'D6', 2, 1),
(137, 'D7', 2, 1),
(138, 'D8', 2, 1),
(139, 'D9', 2, 1),
(140, 'D10', 2, 1),
(141, 'E1', 2, 1),
(142, 'E2', 2, 1),
(143, 'E3', 2, 1),
(144, 'E4', 2, 1),
(145, 'E5', 2, 1),
(146, 'E6', 2, 1),
(147, 'E7', 2, 1),
(148, 'E8', 2, 1),
(149, 'E9', 2, 1),
(150, 'E10', 2, 1),
(151, 'F1', 2, 1),
(152, 'F2', 2, 1),
(153, 'F3', 2, 1),
(154, 'F4', 2, 1),
(155, 'F5', 2, 1),
(156, 'F6', 2, 1),
(157, 'F7', 2, 1),
(158, 'F8', 2, 1),
(159, 'F9', 2, 1),
(160, 'F10', 2, 1),
(161, 'G1', 2, 1),
(162, 'G2', 2, 1),
(163, 'G3', 2, 1),
(164, 'G4', 2, 1),
(165, 'G5', 2, 1),
(166, 'G6', 2, 1),
(167, 'G7', 2, 1),
(168, 'G8', 2, 1),
(169, 'G9', 2, 1),
(170, 'G10', 2, 1),
(171, 'H1', 2, 1),
(172, 'H2', 2, 1),
(173, 'H3', 2, 1),
(174, 'H4', 2, 1),
(175, 'H5', 2, 1),
(176, 'H6', 2, 1),
(177, 'H7', 2, 1),
(178, 'H8', 2, 1),
(179, 'H9', 2, 1),
(180, 'H10', 2, 1),
(181, 'I1', 2, 1),
(182, 'I2', 2, 1),
(183, 'I3', 2, 1),
(184, 'I4', 2, 1),
(185, 'I5', 2, 1),
(186, 'I6', 2, 1),
(187, 'I7', 2, 1),
(188, 'I8', 2, 1),
(189, 'I9', 2, 1),
(190, 'I10', 2, 1),
(191, 'J1', 2, 1),
(192, 'J2', 2, 1),
(193, 'J3', 2, 1),
(194, 'J4', 2, 1),
(195, 'J5', 2, 1),
(196, 'J6', 2, 1),
(197, 'J7', 2, 1),
(198, 'J8', 2, 1),
(199, 'J9', 2, 1),
(200, 'J10', 2, 1),
(201, 'A1', 3, 1),
(202, 'A2', 3, 1),
(203, 'A3', 3, 1),
(204, 'A4', 3, 1),
(205, 'A5', 3, 1),
(206, 'A6', 3, 1),
(207, 'A7', 3, 1),
(208, 'A8', 3, 1),
(209, 'A9', 3, 1),
(210, 'A10', 3, 1),
(211, 'B1', 3, 1),
(212, 'B2', 3, 1),
(213, 'B3', 3, 1),
(214, 'B4', 3, 1),
(215, 'B5', 3, 1),
(216, 'B6', 3, 1),
(217, 'B7', 3, 1),
(218, 'B8', 3, 1),
(219, 'B9', 3, 1),
(220, 'B10', 3, 1),
(221, 'C1', 3, 1),
(222, 'C2', 3, 1),
(223, 'C3', 3, 1),
(224, 'C4', 3, 1),
(225, 'C5', 3, 1),
(226, 'C6', 3, 1),
(227, 'C7', 3, 1),
(228, 'C8', 3, 1),
(229, 'C9', 3, 1),
(230, 'C10', 3, 1),
(231, 'D1', 3, 1),
(232, 'D2', 3, 1),
(233, 'D3', 3, 1),
(234, 'D4', 3, 1),
(235, 'D5', 3, 1),
(236, 'D6', 3, 1),
(237, 'D7', 3, 1),
(238, 'D8', 3, 1),
(239, 'D9', 3, 1),
(240, 'D10', 3, 1),
(241, 'E1', 3, 1),
(242, 'E2', 3, 1),
(243, 'E3', 3, 1),
(244, 'E4', 3, 1),
(245, 'E5', 3, 1),
(246, 'E6', 3, 1),
(247, 'E7', 3, 1),
(248, 'E8', 3, 1),
(249, 'E9', 3, 1),
(250, 'E10', 3, 1),
(251, 'F1', 3, 1),
(252, 'F2', 3, 1),
(253, 'F3', 3, 1),
(254, 'F4', 3, 1),
(255, 'F5', 3, 1),
(256, 'F6', 3, 1),
(257, 'F7', 3, 1),
(258, 'F8', 3, 1),
(259, 'F9', 3, 1),
(260, 'F10', 3, 1),
(261, 'G1', 3, 1),
(262, 'G2', 3, 1),
(263, 'G3', 3, 1),
(264, 'G4', 3, 1),
(265, 'G5', 3, 1),
(266, 'G6', 3, 1),
(267, 'G7', 3, 1),
(268, 'G8', 3, 1),
(269, 'G9', 3, 1),
(270, 'G10', 3, 1),
(271, 'H1', 3, 1),
(272, 'H2', 3, 1),
(273, 'H3', 3, 1),
(274, 'H4', 3, 1),
(275, 'H5', 3, 1),
(276, 'H6', 3, 1),
(277, 'H7', 3, 1),
(278, 'H8', 3, 1),
(279, 'H9', 3, 1),
(280, 'H10', 3, 1),
(281, 'I1', 3, 1),
(282, 'I2', 3, 1),
(283, 'I3', 3, 1),
(284, 'I4', 3, 1),
(285, 'I5', 3, 1),
(286, 'I6', 3, 1),
(287, 'I7', 3, 1),
(288, 'I8', 3, 1),
(289, 'I9', 3, 1),
(290, 'I10', 3, 1),
(291, 'J1', 3, 1),
(292, 'J2', 3, 1),
(293, 'J3', 3, 1),
(294, 'J4', 3, 1),
(295, 'J5', 3, 1),
(296, 'J6', 3, 1),
(297, 'J7', 3, 1),
(298, 'J8', 3, 1),
(299, 'J9', 3, 1),
(300, 'J10', 3, 1),
(301, 'A1', 4, 1),
(302, 'A2', 4, 1),
(303, 'A3', 4, 1),
(304, 'A4', 4, 1),
(305, 'A5', 4, 1),
(306, 'A6', 4, 1),
(307, 'A7', 4, 1),
(308, 'A8', 4, 1),
(309, 'A9', 4, 1),
(310, 'A10', 4, 1),
(311, 'B1', 4, 1),
(312, 'B2', 4, 1),
(313, 'B3', 4, 1),
(314, 'B4', 4, 1),
(315, 'B5', 4, 1),
(316, 'B6', 4, 1),
(317, 'B7', 4, 1),
(318, 'B8', 4, 1),
(319, 'B9', 4, 1),
(320, 'B10', 4, 1),
(321, 'C1', 4, 1),
(322, 'C2', 4, 1),
(323, 'C3', 4, 1),
(324, 'C4', 4, 1),
(325, 'C5', 4, 1),
(326, 'C6', 4, 1),
(327, 'C7', 4, 1),
(328, 'C8', 4, 1),
(329, 'C9', 4, 1),
(330, 'C10', 4, 1),
(331, 'D1', 4, 1),
(332, 'D2', 4, 1),
(333, 'D3', 4, 1),
(334, 'D4', 4, 1),
(335, 'D5', 4, 1),
(336, 'D6', 4, 1),
(337, 'D7', 4, 1),
(338, 'D8', 4, 1),
(339, 'D9', 4, 1),
(340, 'D10', 4, 1),
(341, 'E1', 4, 1),
(342, 'E2', 4, 1),
(343, 'E3', 4, 1),
(344, 'E4', 4, 1),
(345, 'E5', 4, 1),
(346, 'E6', 4, 1),
(347, 'E7', 4, 1),
(348, 'E8', 4, 1),
(349, 'E9', 4, 1),
(350, 'E10', 4, 1),
(351, 'F1', 4, 1),
(352, 'F2', 4, 1),
(353, 'F3', 4, 1),
(354, 'F4', 4, 1),
(355, 'F5', 4, 1),
(356, 'F6', 4, 1),
(357, 'F7', 4, 1),
(358, 'F8', 4, 1),
(359, 'F9', 4, 1),
(360, 'F10', 4, 1),
(361, 'G1', 4, 1),
(362, 'G2', 4, 1),
(363, 'G3', 4, 1),
(364, 'G4', 4, 1),
(365, 'G5', 4, 1),
(366, 'G6', 4, 1),
(367, 'G7', 4, 1),
(368, 'G8', 4, 1),
(369, 'G9', 4, 1),
(370, 'G10', 4, 1),
(371, 'H1', 4, 1),
(372, 'H2', 4, 1),
(373, 'H3', 4, 1),
(374, 'H4', 4, 1),
(375, 'H5', 4, 1),
(376, 'H6', 4, 1),
(377, 'H7', 4, 1),
(378, 'H8', 4, 1),
(379, 'H9', 4, 1),
(380, 'H10', 4, 1),
(381, 'I1', 4, 1),
(382, 'I2', 4, 1),
(383, 'I3', 4, 1),
(384, 'I4', 4, 1),
(385, 'I5', 4, 1),
(386, 'I6', 4, 1),
(387, 'I7', 4, 1),
(388, 'I8', 4, 1),
(389, 'I9', 4, 1),
(390, 'I10', 4, 1),
(391, 'J1', 4, 1),
(392, 'J2', 4, 1),
(393, 'J3', 4, 1),
(394, 'J4', 4, 1),
(395, 'J5', 4, 1),
(396, 'J6', 4, 1),
(397, 'J7', 4, 1),
(398, 'J8', 4, 1),
(399, 'J9', 4, 1),
(400, 'J10', 4, 1),
(401, 'A1', 5, 1),
(402, 'A2', 5, 1),
(403, 'A3', 5, 1),
(404, 'A4', 5, 1),
(405, 'A5', 5, 1),
(406, 'A6', 5, 1),
(407, 'A7', 5, 1),
(408, 'A8', 5, 1),
(409, 'A9', 5, 1),
(410, 'A10', 5, 1),
(411, 'B1', 5, 1),
(412, 'B2', 5, 1),
(413, 'B3', 5, 1),
(414, 'B4', 5, 1),
(415, 'B5', 5, 1),
(416, 'B6', 5, 1),
(417, 'B7', 5, 1),
(418, 'B8', 5, 1),
(419, 'B9', 5, 1),
(420, 'B10', 5, 1),
(421, 'C1', 5, 1),
(422, 'C2', 5, 1),
(423, 'C3', 5, 1),
(424, 'C4', 5, 1),
(425, 'C5', 5, 1),
(426, 'C6', 5, 1),
(427, 'C7', 5, 1),
(428, 'C8', 5, 1),
(429, 'C9', 5, 1),
(430, 'C10', 5, 1),
(431, 'D1', 5, 1),
(432, 'D2', 5, 1),
(433, 'D3', 5, 1),
(434, 'D4', 5, 1),
(435, 'D5', 5, 1),
(436, 'D6', 5, 1),
(437, 'D7', 5, 1),
(438, 'D8', 5, 1),
(439, 'D9', 5, 1),
(440, 'D10', 5, 1),
(441, 'E1', 5, 1),
(442, 'E2', 5, 1),
(443, 'E3', 5, 1),
(444, 'E4', 5, 1),
(445, 'E5', 5, 1),
(446, 'E6', 5, 1),
(447, 'E7', 5, 1),
(448, 'E8', 5, 1),
(449, 'E9', 5, 1),
(450, 'E10', 5, 1),
(451, 'F1', 5, 1),
(452, 'F2', 5, 1),
(453, 'F3', 5, 1),
(454, 'F4', 5, 1),
(455, 'F5', 5, 1),
(456, 'F6', 5, 1),
(457, 'F7', 5, 1),
(458, 'F8', 5, 1),
(459, 'F9', 5, 1),
(460, 'F10', 5, 1),
(461, 'G1', 5, 1),
(462, 'G2', 5, 1),
(463, 'G3', 5, 1),
(464, 'G4', 5, 1),
(465, 'G5', 5, 1),
(466, 'G6', 5, 1),
(467, 'G7', 5, 1),
(468, 'G8', 5, 1),
(469, 'G9', 5, 1),
(470, 'G10', 5, 1),
(471, 'H1', 5, 1),
(472, 'H2', 5, 1),
(473, 'H3', 5, 1),
(474, 'H4', 5, 1),
(475, 'H5', 5, 1),
(476, 'H6', 5, 1),
(477, 'H7', 5, 1),
(478, 'H8', 5, 1),
(479, 'H9', 5, 1),
(480, 'H10', 5, 1),
(481, 'I1', 5, 1),
(482, 'I2', 5, 1),
(483, 'I3', 5, 1),
(484, 'I4', 5, 1),
(485, 'I5', 5, 1),
(486, 'I6', 5, 1),
(487, 'I7', 5, 1),
(488, 'I8', 5, 1),
(489, 'I9', 5, 1),
(490, 'I10', 5, 1),
(491, 'J1', 5, 1),
(492, 'J2', 5, 1),
(493, 'J3', 5, 1),
(494, 'J4', 5, 1),
(495, 'J5', 5, 1),
(496, 'J6', 5, 1),
(497, 'J7', 5, 1),
(498, 'J8', 5, 1),
(499, 'J9', 5, 1),
(500, 'J10', 5, 1),
(501, 'A1', 6, 1),
(502, 'A2', 6, 1),
(503, 'A3', 6, 1),
(504, 'A4', 6, 1),
(505, 'A5', 6, 1),
(506, 'A6', 6, 1),
(507, 'A7', 6, 1),
(508, 'A8', 6, 1),
(509, 'A9', 6, 1),
(510, 'A10', 6, 1),
(511, 'B1', 6, 1),
(512, 'B2', 6, 1),
(513, 'B3', 6, 1),
(514, 'B4', 6, 1),
(515, 'B5', 6, 1),
(516, 'B6', 6, 1),
(517, 'B7', 6, 1),
(518, 'B8', 6, 1),
(519, 'B9', 6, 1),
(520, 'B10', 6, 1),
(521, 'C1', 6, 1),
(522, 'C2', 6, 1),
(523, 'C3', 6, 1),
(524, 'C4', 6, 1),
(525, 'C5', 6, 1),
(526, 'C6', 6, 1),
(527, 'C7', 6, 1),
(528, 'C8', 6, 1),
(529, 'C9', 6, 1),
(530, 'C10', 6, 1),
(531, 'D1', 6, 1),
(532, 'D2', 6, 1),
(533, 'D3', 6, 1),
(534, 'D4', 6, 1),
(535, 'D5', 6, 1),
(536, 'D6', 6, 1),
(537, 'D7', 6, 1),
(538, 'D8', 6, 1),
(539, 'D9', 6, 1),
(540, 'D10', 6, 1),
(541, 'E1', 6, 1),
(542, 'E2', 6, 1),
(543, 'E3', 6, 1),
(544, 'E4', 6, 1),
(545, 'E5', 6, 1),
(546, 'E6', 6, 1),
(547, 'E7', 6, 1),
(548, 'E8', 6, 1),
(549, 'E9', 6, 1),
(550, 'E10', 6, 1),
(551, 'F1', 6, 1),
(552, 'F2', 6, 1),
(553, 'F3', 6, 1),
(554, 'F4', 6, 1),
(555, 'F5', 6, 1),
(556, 'F6', 6, 1),
(557, 'F7', 6, 1),
(558, 'F8', 6, 1),
(559, 'F9', 6, 1),
(560, 'F10', 6, 1),
(561, 'G1', 6, 1),
(562, 'G2', 6, 1),
(563, 'G3', 6, 1),
(564, 'G4', 6, 1),
(565, 'G5', 6, 1),
(566, 'G6', 6, 1),
(567, 'G7', 6, 1),
(568, 'G8', 6, 1),
(569, 'G9', 6, 1),
(570, 'G10', 6, 1),
(571, 'H1', 6, 1),
(572, 'H2', 6, 1),
(573, 'H3', 6, 1),
(574, 'H4', 6, 1),
(575, 'H5', 6, 1),
(576, 'H6', 6, 1),
(577, 'H7', 6, 1),
(578, 'H8', 6, 1),
(579, 'H9', 6, 1),
(580, 'H10', 6, 1),
(581, 'I1', 6, 1),
(582, 'I2', 6, 1),
(583, 'I3', 6, 1),
(584, 'I4', 6, 1),
(585, 'I5', 6, 1),
(586, 'I6', 6, 1),
(587, 'I7', 6, 1),
(588, 'I8', 6, 1),
(589, 'I9', 6, 1),
(590, 'I10', 6, 1),
(591, 'J1', 6, 1),
(592, 'J2', 6, 1),
(593, 'J3', 6, 1),
(594, 'J4', 6, 1),
(595, 'J5', 6, 1),
(596, 'J6', 6, 1),
(597, 'J7', 6, 1),
(598, 'J8', 6, 1),
(599, 'J9', 6, 1),
(600, 'J10', 6, 1),
(601, 'A1', 7, 1),
(602, 'A2', 7, 1),
(603, 'A3', 7, 1),
(604, 'A4', 7, 1),
(605, 'A5', 7, 1),
(606, 'A6', 7, 1),
(607, 'A7', 7, 1),
(608, 'A8', 7, 1),
(609, 'A9', 7, 1),
(610, 'A10', 7, 1),
(611, 'B1', 7, 1),
(612, 'B2', 7, 1),
(613, 'B3', 7, 1),
(614, 'B4', 7, 1),
(615, 'B5', 7, 1),
(616, 'B6', 7, 1),
(617, 'B7', 7, 1),
(618, 'B8', 7, 1),
(619, 'B9', 7, 1),
(620, 'B10', 7, 1),
(621, 'C1', 7, 1),
(622, 'C2', 7, 1),
(623, 'C3', 7, 1),
(624, 'C4', 7, 1),
(625, 'C5', 7, 1),
(626, 'C6', 7, 1),
(627, 'C7', 7, 1),
(628, 'C8', 7, 1),
(629, 'C9', 7, 1),
(630, 'C10', 7, 1),
(631, 'D1', 7, 1),
(632, 'D2', 7, 1),
(633, 'D3', 7, 1),
(634, 'D4', 7, 1),
(635, 'D5', 7, 1),
(636, 'D6', 7, 1),
(637, 'D7', 7, 1),
(638, 'D8', 7, 1),
(639, 'D9', 7, 1),
(640, 'D10', 7, 1),
(641, 'E1', 7, 1),
(642, 'E2', 7, 1),
(643, 'E3', 7, 1),
(644, 'E4', 7, 1),
(645, 'E5', 7, 1),
(646, 'E6', 7, 1),
(647, 'E7', 7, 1),
(648, 'E8', 7, 1),
(649, 'E9', 7, 1),
(650, 'E10', 7, 1),
(651, 'F1', 7, 1),
(652, 'F2', 7, 1),
(653, 'F3', 7, 1),
(654, 'F4', 7, 1),
(655, 'F5', 7, 1),
(656, 'F6', 7, 1),
(657, 'F7', 7, 1),
(658, 'F8', 7, 1),
(659, 'F9', 7, 1),
(660, 'F10', 7, 1),
(661, 'G1', 7, 1),
(662, 'G2', 7, 1),
(663, 'G3', 7, 1),
(664, 'G4', 7, 1),
(665, 'G5', 7, 1),
(666, 'G6', 7, 1),
(667, 'G7', 7, 1),
(668, 'G8', 7, 1),
(669, 'G9', 7, 1),
(670, 'G10', 7, 1),
(671, 'H1', 7, 1),
(672, 'H2', 7, 1),
(673, 'H3', 7, 1),
(674, 'H4', 7, 1),
(675, 'H5', 7, 1),
(676, 'H6', 7, 1),
(677, 'H7', 7, 1),
(678, 'H8', 7, 1),
(679, 'H9', 7, 1),
(680, 'H10', 7, 1),
(681, 'I1', 7, 1),
(682, 'I2', 7, 1),
(683, 'I3', 7, 1),
(684, 'I4', 7, 1),
(685, 'I5', 7, 1),
(686, 'I6', 7, 1),
(687, 'I7', 7, 1),
(688, 'I8', 7, 1),
(689, 'I9', 7, 1),
(690, 'I10', 7, 1),
(691, 'J1', 7, 1),
(692, 'J2', 7, 1),
(693, 'J3', 7, 1),
(694, 'J4', 7, 1),
(695, 'J5', 7, 1),
(696, 'J6', 7, 1),
(697, 'J7', 7, 1),
(698, 'J8', 7, 1),
(699, 'J9', 7, 1),
(700, 'J10', 7, 1),
(701, 'A1', 8, 1),
(702, 'A2', 8, 1),
(703, 'A3', 8, 1),
(704, 'A4', 8, 1),
(705, 'A5', 8, 1),
(706, 'A6', 8, 1),
(707, 'A7', 8, 1),
(708, 'A8', 8, 1),
(709, 'A9', 8, 1),
(710, 'A10', 8, 1),
(711, 'B1', 8, 1),
(712, 'B2', 8, 1),
(713, 'B3', 8, 1),
(714, 'B4', 8, 1),
(715, 'B5', 8, 1),
(716, 'B6', 8, 1),
(717, 'B7', 8, 1),
(718, 'B8', 8, 1),
(719, 'B9', 8, 1),
(720, 'B10', 8, 1),
(721, 'C1', 8, 1),
(722, 'C2', 8, 1),
(723, 'C3', 8, 1),
(724, 'C4', 8, 1),
(725, 'C5', 8, 1),
(726, 'C6', 8, 1),
(727, 'C7', 8, 1),
(728, 'C8', 8, 1),
(729, 'C9', 8, 1),
(730, 'C10', 8, 1),
(731, 'D1', 8, 1),
(732, 'D2', 8, 1),
(733, 'D3', 8, 1),
(734, 'D4', 8, 1),
(735, 'D5', 8, 1),
(736, 'D6', 8, 1),
(737, 'D7', 8, 1),
(738, 'D8', 8, 1),
(739, 'D9', 8, 1),
(740, 'D10', 8, 1),
(741, 'E1', 8, 1),
(742, 'E2', 8, 1),
(743, 'E3', 8, 1),
(744, 'E4', 8, 1),
(745, 'E5', 8, 1),
(746, 'E6', 8, 1),
(747, 'E7', 8, 1),
(748, 'E8', 8, 1),
(749, 'E9', 8, 1),
(750, 'E10', 8, 1),
(751, 'F1', 8, 1),
(752, 'F2', 8, 1),
(753, 'F3', 8, 1),
(754, 'F4', 8, 1),
(755, 'F5', 8, 1),
(756, 'F6', 8, 1),
(757, 'F7', 8, 1),
(758, 'F8', 8, 1),
(759, 'F9', 8, 1),
(760, 'F10', 8, 1),
(761, 'G1', 8, 1),
(762, 'G2', 8, 1),
(763, 'G3', 8, 1),
(764, 'G4', 8, 1),
(765, 'G5', 8, 1),
(766, 'G6', 8, 1),
(767, 'G7', 8, 1),
(768, 'G8', 8, 1),
(769, 'G9', 8, 1),
(770, 'G10', 8, 1),
(771, 'H1', 8, 1),
(772, 'H2', 8, 1),
(773, 'H3', 8, 1),
(774, 'H4', 8, 1),
(775, 'H5', 8, 1),
(776, 'H6', 8, 1),
(777, 'H7', 8, 1),
(778, 'H8', 8, 1),
(779, 'H9', 8, 1),
(780, 'H10', 8, 1),
(781, 'I1', 8, 1),
(782, 'I2', 8, 1),
(783, 'I3', 8, 1),
(784, 'I4', 8, 1),
(785, 'I5', 8, 1),
(786, 'I6', 8, 1),
(787, 'I7', 8, 1),
(788, 'I8', 8, 1),
(789, 'I9', 8, 1),
(790, 'I10', 8, 1),
(791, 'J1', 8, 1),
(792, 'J2', 8, 1),
(793, 'J3', 8, 1),
(794, 'J4', 8, 1),
(795, 'J5', 8, 1),
(796, 'J6', 8, 1),
(797, 'J7', 8, 1),
(798, 'J8', 8, 1),
(799, 'J9', 8, 1),
(800, 'J10', 8, 1),
(801, 'A1', 9, 1),
(802, 'A2', 9, 1),
(803, 'A3', 9, 1),
(804, 'A4', 9, 1),
(805, 'A5', 9, 1),
(806, 'A6', 9, 1),
(807, 'A7', 9, 1),
(808, 'A8', 9, 1),
(809, 'A9', 9, 1),
(810, 'A10', 9, 1),
(811, 'B1', 9, 1),
(812, 'B2', 9, 1),
(813, 'B3', 9, 1),
(814, 'B4', 9, 1),
(815, 'B5', 9, 1),
(816, 'B6', 9, 1),
(817, 'B7', 9, 1),
(818, 'B8', 9, 1),
(819, 'B9', 9, 1),
(820, 'B10', 9, 1),
(821, 'C1', 9, 1),
(822, 'C2', 9, 1),
(823, 'C3', 9, 1),
(824, 'C4', 9, 1),
(825, 'C5', 9, 1),
(826, 'C6', 9, 1),
(827, 'C7', 9, 1),
(828, 'C8', 9, 1),
(829, 'C9', 9, 1),
(830, 'C10', 9, 1),
(831, 'D1', 9, 1),
(832, 'D2', 9, 1),
(833, 'D3', 9, 1),
(834, 'D4', 9, 1),
(835, 'D5', 9, 1),
(836, 'D6', 9, 1),
(837, 'D7', 9, 1),
(838, 'D8', 9, 1),
(839, 'D9', 9, 1),
(840, 'D10', 9, 1),
(841, 'E1', 9, 1),
(842, 'E2', 9, 1),
(843, 'E3', 9, 1),
(844, 'E4', 9, 1),
(845, 'E5', 9, 1),
(846, 'E6', 9, 1),
(847, 'E7', 9, 1),
(848, 'E8', 9, 1),
(849, 'E9', 9, 1),
(850, 'E10', 9, 1),
(851, 'F1', 9, 1),
(852, 'F2', 9, 1),
(853, 'F3', 9, 1),
(854, 'F4', 9, 1),
(855, 'F5', 9, 1),
(856, 'F6', 9, 1),
(857, 'F7', 9, 1),
(858, 'F8', 9, 1),
(859, 'F9', 9, 1),
(860, 'F10', 9, 1),
(861, 'G1', 9, 1),
(862, 'G2', 9, 1),
(863, 'G3', 9, 1),
(864, 'G4', 9, 1),
(865, 'G5', 9, 1),
(866, 'G6', 9, 1),
(867, 'G7', 9, 1),
(868, 'G8', 9, 1),
(869, 'G9', 9, 1),
(870, 'G10', 9, 1),
(871, 'H1', 9, 1),
(872, 'H2', 9, 1),
(873, 'H3', 9, 1),
(874, 'H4', 9, 1),
(875, 'H5', 9, 1),
(876, 'H6', 9, 1),
(877, 'H7', 9, 1),
(878, 'H8', 9, 1),
(879, 'H9', 9, 1),
(880, 'H10', 9, 1),
(881, 'I1', 9, 1),
(882, 'I2', 9, 1),
(883, 'I3', 9, 1),
(884, 'I4', 9, 1),
(885, 'I5', 9, 1),
(886, 'I6', 9, 1),
(887, 'I7', 9, 1),
(888, 'I8', 9, 1),
(889, 'I9', 9, 1),
(890, 'I10', 9, 1),
(891, 'J1', 9, 1),
(892, 'J2', 9, 1),
(893, 'J3', 9, 1),
(894, 'J4', 9, 1),
(895, 'J5', 9, 1),
(896, 'J6', 9, 1),
(897, 'J7', 9, 1),
(898, 'J8', 9, 1),
(899, 'J9', 9, 1),
(900, 'J10', 9, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Boleto`
--

CREATE TABLE `Boleto` (
  `ID_Boleto` int(11) NOT NULL,
  `Tipo_Persona` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Costo` smallint(5) NOT NULL,
  `ID_Funcion` int(11) NOT NULL,
  `ID_Asiento` varchar(5) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Corte Dulceria`
--

CREATE TABLE `Corte Dulceria` (
  `Fecha_Corte_Dulc` datetime NOT NULL,
  `ID_Usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Corte Taquilla`
--

CREATE TABLE `Corte Taquilla` (
  `Fecha_Corte` datetime NOT NULL,
  `ID_Usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Detalles Venta Boleto`
--

CREATE TABLE `Detalles Venta Boleto` (
  `ID_VentaBoleto` int(11) NOT NULL,
  `ID_Boleto` int(11) NOT NULL,
  `Tipo` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Costo` smallint(5) NOT NULL,
  `Cantidad` smallint(5) NOT NULL,
  `Num_Sala` smallint(30) NOT NULL,
  `ID_Funcion` int(11) NOT NULL,
  `ID_Asiento` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Detalles Venta Dulceria`
--

CREATE TABLE `Detalles Venta Dulceria` (
  `ID_VentaDulceria` int(11) NOT NULL,
  `ID_Producto` int(11) NOT NULL,
  `Cantidad` smallint(5) NOT NULL,
  `Precio_Producto` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Funcion`
--

CREATE TABLE `Funcion` (
  `ID_Funcion` int(11) NOT NULL,
  `Num_Sala` smallint(30) NOT NULL,
  `ID_Peli` int(11) NOT NULL,
  `Nombre_Peli` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `Fecha_Peli` date NOT NULL,
  `Hora_Peli` time NOT NULL,
  `Tipo` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Pelicula`
--

CREATE TABLE `Pelicula` (
  `ID_Pelicula` int(11) NOT NULL,
  `Nombre` varchar(80) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Clasificacion` varchar(3) COLLATE utf8_unicode_ci NOT NULL,
  `Version` tinyint(1) NOT NULL,
  `Duracion` smallint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `Pelicula`
--

INSERT INTO `Pelicula` (`ID_Pelicula`, `Nombre`, `Clasificacion`, `Version`, `Duracion`) VALUES
(4, 'HARRY POTTER Y EL PRISIONERO DE AZKABAN', 'AA', 0, 20),
(6, 'HARRY POTTER Y LA ORDEN DEL FÉNIX', 'C', 1, 100),
(8, 'HARRY POTTER Y LAS RELIQUIAS DE LA MUERTE 1', 'AA', 0, 120),
(9, 'HARRY POTTER Y LAS RELIQUIAS DE LA MUERTE 2', 'A', 1, 10),
(10, 'Scooby-Doo 2: Monstruos sueltos', 'A', 0, 37),
(10012, 'No Manches Frida Maluma bEibi Edition', 'B', 0, 102),
(38712, 'Star Wars: El imperio coontrataca', 'B', 1, 124);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Producto Dulceria`
--

CREATE TABLE `Producto Dulceria` (
  `ID_Producto` int(11) NOT NULL,
  `Nombre_Producto` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Tamaño` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Precio` float NOT NULL,
  `Sabor` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Existencias` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Sala`
--

CREATE TABLE `Sala` (
  `Num_Sala` smallint(30) NOT NULL,
  `Cant_Asientos` smallint(250) NOT NULL DEFAULT '100',
  `Tipo` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `Sala`
--

INSERT INTO `Sala` (`Num_Sala`, `Cant_Asientos`, `Tipo`) VALUES
(1, 100, 'Estandar'),
(2, 100, 'Estandar'),
(3, 100, 'Estandar'),
(4, 100, 'Estandar'),
(5, 100, '3D'),
(6, 100, '3D'),
(7, 100, '4D'),
(8, 100, 'VIP'),
(9, 100, 'IMAX');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuario`
--

CREATE TABLE `Usuario` (
  `ID_Usuario` int(11) NOT NULL,
  `Admin` tinyint(1) NOT NULL,
  `Contrasena` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Telefono` int(12) NOT NULL,
  `Direccion` varchar(60) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `Usuario`
--

INSERT INTO `Usuario` (`ID_Usuario`, `Admin`, `Contrasena`, `Nombre`, `Telefono`, `Direccion`) VALUES
(31, 1, 'holaaa', 'fyuyt', 980, 'uytfuytf'),
(45, 0, '213', 'sssss', 2121, 'asdas'),
(420, 0, 'aber', 'inputpane', 3223, 'dfopjev'),
(1865021, 1, 'RonaldinhoSoccer', 'Oscar Ignacio Guajardo Hernandez', 18732428, 'Monterrey, Nuevo Leon'),
(1865023, 0, '213', 'sssss', 2121, 'asdas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Venta Boleto`
--

CREATE TABLE `Venta Boleto` (
  `ID_VentaBoleto` int(11) NOT NULL,
  `ID_Usuario` int(11) NOT NULL,
  `Fecha` datetime NOT NULL,
  `Costo Total` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `Venta Boleto`
--

INSERT INTO `Venta Boleto` (`ID_VentaBoleto`, `ID_Usuario`, `Fecha`, `Costo Total`) VALUES
(123, 45, '2020-06-16 00:00:00', 123);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Venta Dulceria`
--

CREATE TABLE `Venta Dulceria` (
  `ID_VentaDulceria` int(11) NOT NULL,
  `ID_Usuario` int(11) NOT NULL,
  `Fecha_VentaDulc` datetime NOT NULL,
  `Costo_Total_Dulc` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Asiento`
--
ALTER TABLE `Asiento`
  ADD PRIMARY KEY (`ID_Asiento`);

--
-- Indices de la tabla `Boleto`
--
ALTER TABLE `Boleto`
  ADD PRIMARY KEY (`ID_Boleto`);

--
-- Indices de la tabla `Corte Dulceria`
--
ALTER TABLE `Corte Dulceria`
  ADD PRIMARY KEY (`Fecha_Corte_Dulc`),
  ADD KEY `CD_fk_ID_User` (`ID_Usuario`);

--
-- Indices de la tabla `Corte Taquilla`
--
ALTER TABLE `Corte Taquilla`
  ADD PRIMARY KEY (`Fecha_Corte`),
  ADD KEY `CT_fk_Id_Usuario` (`ID_Usuario`);

--
-- Indices de la tabla `Detalles Venta Boleto`
--
ALTER TABLE `Detalles Venta Boleto`
  ADD KEY `dvd_fk_ID_Funcion` (`ID_Funcion`),
  ADD KEY `dvd_fk_ID_Venta_Boleto` (`ID_VentaBoleto`),
  ADD KEY `dvb_fk_boleto` (`ID_Boleto`),
  ADD KEY `dvd_fk_num_sala` (`Num_Sala`);

--
-- Indices de la tabla `Detalles Venta Dulceria`
--
ALTER TABLE `Detalles Venta Dulceria`
  ADD KEY `DVD_fk_ID_Producto` (`ID_Producto`),
  ADD KEY `ID_VentaDulceria` (`ID_VentaDulceria`);

--
-- Indices de la tabla `Funcion`
--
ALTER TABLE `Funcion`
  ADD PRIMARY KEY (`ID_Funcion`),
  ADD KEY `F_fk_ID_Peli` (`ID_Peli`),
  ADD KEY `F_fk_num_sala` (`Num_Sala`),
  ADD KEY `Nombre_Peli` (`Nombre_Peli`);

--
-- Indices de la tabla `Pelicula`
--
ALTER TABLE `Pelicula`
  ADD PRIMARY KEY (`ID_Pelicula`) USING BTREE;

--
-- Indices de la tabla `Producto Dulceria`
--
ALTER TABLE `Producto Dulceria`
  ADD PRIMARY KEY (`ID_Producto`);

--
-- Indices de la tabla `Sala`
--
ALTER TABLE `Sala`
  ADD PRIMARY KEY (`Num_Sala`);

--
-- Indices de la tabla `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`ID_Usuario`);

--
-- Indices de la tabla `Venta Boleto`
--
ALTER TABLE `Venta Boleto`
  ADD PRIMARY KEY (`ID_VentaBoleto`),
  ADD KEY `VB_fk_USERID` (`ID_Usuario`);

--
-- Indices de la tabla `Venta Dulceria`
--
ALTER TABLE `Venta Dulceria`
  ADD PRIMARY KEY (`ID_VentaDulceria`),
  ADD KEY `ID_Usuario` (`ID_Usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Asiento`
--
ALTER TABLE `Asiento`
  MODIFY `ID_Asiento` int(110) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=901;

--
-- AUTO_INCREMENT de la tabla `Boleto`
--
ALTER TABLE `Boleto`
  MODIFY `ID_Boleto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Funcion`
--
ALTER TABLE `Funcion`
  MODIFY `ID_Funcion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `Usuario`
--
ALTER TABLE `Usuario`
  MODIFY `ID_Usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1865024;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Corte Dulceria`
--
ALTER TABLE `Corte Dulceria`
  ADD CONSTRAINT `CD_fk_ID_User` FOREIGN KEY (`ID_Usuario`) REFERENCES `Usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Corte Taquilla`
--
ALTER TABLE `Corte Taquilla`
  ADD CONSTRAINT `CT_fk_Id_Usuario` FOREIGN KEY (`ID_Usuario`) REFERENCES `Usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Detalles Venta Boleto`
--
ALTER TABLE `Detalles Venta Boleto`
  ADD CONSTRAINT `dvb_fk_boleto` FOREIGN KEY (`ID_Boleto`) REFERENCES `Boleto` (`id_boleto`) ON DELETE RESTRICT ON UPDATE CASCADE,
  ADD CONSTRAINT `dvd_fk_ID_Funcion` FOREIGN KEY (`ID_Funcion`) REFERENCES `Funcion` (`id_funcion`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dvd_fk_ID_Venta_Boleto` FOREIGN KEY (`ID_VentaBoleto`) REFERENCES `Venta Boleto` (`id_ventaboleto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dvd_fk_num_sala` FOREIGN KEY (`Num_Sala`) REFERENCES `Funcion` (`num_sala`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Detalles Venta Dulceria`
--
ALTER TABLE `Detalles Venta Dulceria`
  ADD CONSTRAINT `DVD_fk_ID_Producto` FOREIGN KEY (`ID_Producto`) REFERENCES `Producto Dulceria` (`ID_Producto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `DVD_fk_ID_VentaDulceria` FOREIGN KEY (`ID_VentaDulceria`) REFERENCES `Venta Dulceria` (`id_ventadulceria`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Funcion`
--
ALTER TABLE `Funcion`
  ADD CONSTRAINT `F_fk_ID_Peli` FOREIGN KEY (`ID_Peli`) REFERENCES `Pelicula` (`ID_Pelicula`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `F_fk_num_sala` FOREIGN KEY (`Num_Sala`) REFERENCES `Sala` (`Num_Sala`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Venta Boleto`
--
ALTER TABLE `Venta Boleto`
  ADD CONSTRAINT `VB_fk_USERID` FOREIGN KEY (`ID_Usuario`) REFERENCES `Usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Venta Dulceria`
--
ALTER TABLE `Venta Dulceria`
  ADD CONSTRAINT `VD_fk_UserID` FOREIGN KEY (`ID_Usuario`) REFERENCES `Usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
