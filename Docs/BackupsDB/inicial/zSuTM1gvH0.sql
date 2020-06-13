-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 03-06-2020 a las 06:28:45
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
  `ID_Asiento` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Num_Sala` smallint(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Boleto`
--

CREATE TABLE `Boleto` (
  `ID_Boleto` int(11) NOT NULL,
  `Tipo` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
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
  `Tipo` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Costo` smallint(5) NOT NULL,
  `Cantidad` smallint(5) NOT NULL,
  `Num_Sala` smallint(30) NOT NULL,
  `ID_Funcion` int(11) NOT NULL,
  `ID_Asiento` varchar(5) COLLATE utf8_unicode_ci NOT NULL
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
(1, 'Harry Potter', 'B15', 1, 250);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Producto Dulceria`
--

CREATE TABLE `Producto Dulceria` (
  `ID_Producto` int(11) NOT NULL,
  `Tipo_Producto` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Tamaño` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Precio` float NOT NULL,
  `Sabor` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Existencias` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `Producto Dulceria`
--

INSERT INTO `Producto Dulceria` (`ID_Producto`, `Tipo_Producto`, `Tamaño`, `Precio`, `Sabor`, `Existencias`) VALUES
(1, 'Coca Cola', 'chica', 60.5, 'Cola', 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Sala`
--

CREATE TABLE `Sala` (
  `Num_Sala` smallint(30) NOT NULL,
  `Tipo` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `Cant_Asientos` smallint(250) NOT NULL,
  `Tipo_Asientos` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Pelicula` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
(1865021, 1, '31', 'Rogelio', 123, 'San Pedro'),
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
  ADD KEY `A_fk_Num_Sala` (`Num_Sala`),
  ADD KEY `ID_Asiento` (`ID_Asiento`);

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
  ADD KEY `DVB_fk_ID_Num_Sala` (`Num_Sala`),
  ADD KEY `DVB_fk_ID_Boleto` (`ID_Boleto`),
  ADD KEY `DVB_fk_ID_Funcion` (`ID_Funcion`),
  ADD KEY `ID_VentaBoleto` (`ID_VentaBoleto`),
  ADD KEY `A_fk_ID_Asiento` (`ID_Asiento`);

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
  ADD KEY `F_fk_num_sala` (`Num_Sala`);

--
-- Indices de la tabla `Pelicula`
--
ALTER TABLE `Pelicula`
  ADD PRIMARY KEY (`ID_Pelicula`);

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
-- AUTO_INCREMENT de la tabla `Funcion`
--
ALTER TABLE `Funcion`
  MODIFY `ID_Funcion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Usuario`
--
ALTER TABLE `Usuario`
  MODIFY `ID_Usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1865024;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Asiento`
--
ALTER TABLE `Asiento`
  ADD CONSTRAINT `A_fk_Num_Sala` FOREIGN KEY (`Num_Sala`) REFERENCES `Sala` (`num_sala`) ON DELETE CASCADE ON UPDATE CASCADE;

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
  ADD CONSTRAINT `A_fk_ID_Asiento` FOREIGN KEY (`ID_Asiento`) REFERENCES `Asiento` (`id_asiento`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `DVB_fk_ID_Boleto` FOREIGN KEY (`ID_Boleto`) REFERENCES `Boleto` (`id_boleto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `DVB_fk_ID_Funcion` FOREIGN KEY (`ID_Funcion`) REFERENCES `Funcion` (`id_funcion`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `DVB_fk_ID_Num_Sala` FOREIGN KEY (`Num_Sala`) REFERENCES `Sala` (`num_sala`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `DVD_fk_ID_Venta_Boleto` FOREIGN KEY (`ID_VentaBoleto`) REFERENCES `Venta Boleto` (`id_ventaboleto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Detalles Venta Dulceria`
--
ALTER TABLE `Detalles Venta Dulceria`
  ADD CONSTRAINT `DVD_fk_ID_Producto` FOREIGN KEY (`ID_Producto`) REFERENCES `Producto Dulceria` (`id_producto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `DVD_fk_ID_VentaDulceria` FOREIGN KEY (`ID_VentaDulceria`) REFERENCES `Venta Dulceria` (`id_ventadulceria`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Funcion`
--
ALTER TABLE `Funcion`
  ADD CONSTRAINT `F_fk_ID_Peli` FOREIGN KEY (`ID_Peli`) REFERENCES `Pelicula` (`ID_Pelicula`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `F_fk_num_sala` FOREIGN KEY (`Num_Sala`) REFERENCES `Sala` (`num_sala`) ON DELETE CASCADE ON UPDATE CASCADE;

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
