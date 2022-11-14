-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: mysqlDawes:3306
-- Tiempo de generación: 10-11-2022 a las 08:21:33
-- Versión del servidor: 5.7.22
-- Versión de PHP: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tiendaOnlineCalzado`
--

-- --------------------------------------------------------

--Crear la base de datos
	CREATE database tiendaOnlineCalzado;

--
-- Estructura de tabla para la tabla `ARTICLES`
--

CREATE TABLE `ARTICLES` (
  `id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci DEFAULT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci,
  `price` decimal(5,2) DEFAULT NULL,
  `id_categoria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ARTICLES`
--

INSERT INTO `ARTICLES` (`id`, `name`, `description`, `price`, `id_categoria`) VALUES
(1, 'Vasijas', 'Vasija, como sinónimo de vaso o recipiente, es toda pieza cóncava, de diferentes tamaños y formas, y fabricada en distintos materiales', '12.25', 1),
(2, 'Platos decorativos', 'Existen muchos tipos de platos decorativos. Normalmente, el material que más se utiliza para la pared es la cerámica. Se trata de uno de los materiales más resistente en cuanto a platos. La mayoría de estos platos se pueden colgar fácilmente en la pared, y cuentan con estampados muy bonitos.', '18.00', 1),
(3, 'Sacos de cemento', 'Sacos de cemento de 25 Kilos', '20.00', 2),
(4, 'Cubos de cemento', 'Cubos de cemento de 5 Kilogramos', '5.00', 2),
(5, 'Azulejos de suelo', 'Azulejos para decorar el suelo de tu casa y te quede bien bonita, el precio es cuanto a los metros que compres', '5.00', 3),
(6, 'Azulejos de pared', 'Azulejos de pared para decorar tu vivienda y quede bien bonita, el precio es dependiente a los metros que compres', '2.50', 3),
(7, 'Ladrillos rojos', 'Ladrillos rojos mas resistentes para hacer grandes obras.', '7.50', 4),
(8, 'Ladrillos blancos', 'Ladrillos blancos para el interior de las casas', '12.50', 4),
(9, 'Hormigon blando', 'Hormigon blando es para reforzar las estructuras', '25.00', 5),
(10, 'Hormigon duro', 'El hormigon duro se utiliza para hacer las bases de nuestra vivienda y reforzar las vigas', '36.00', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `CATEGORIA`
--

CREATE TABLE `CATEGORIA` (
  `id` int(11) NOT NULL,
  `nombre` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci DEFAULT NULL,
  `descripcion` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `CATEGORIA`
--

INSERT INTO `CATEGORIA` (`id`, `nombre`, `descripcion`) VALUES
(1, 'Arcilla', 'La arcilla es una roca sedimentaria compuesta por agregados de silicatos de aluminio hidratados procedentes de la descomposición de rocas que contienen feldespato, como el granito'),
(2, 'Cemento', 'El cemento es un conglomerante formado a partir de una mezcla de caliza y arcilla calcinadas y posteriormente molidas, que tiene la propiedad de endurecerse después de ponerse en contacto con el agua'),
(3, 'Azulejos', 'Azulejo o ladrillo azulejo, ​​​ es una pieza alfarera de cerámica, similar a la baldosa, ​ de poco espesor y con una de sus caras vidriada. Presenta muy diversas formas geométricas, siendo las más abundantes el cuadrado y el rectangular'),
(4, 'Ladrillos', 'Un ladrillo es un material de construcción, normalmente cerámico y con forma ortoédrica, cuyas dimensiones más normales permiten que un operario lo pueda colocar con una sola mano. Los ladrillos se emplean en la construcción en general.'),
(5, 'Hormigon', 'El hormigón es una mezcla entre varios materiales hecho de cemento, arena, piedras. En el que a menudo, se usa como refuerzo con el acero.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `USUARIO`
--

CREATE TABLE `USUARIO` (
  `nickname` varchar(50) COLLATE utf8_general_mysql500_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8_general_mysql500_ci DEFAULT NULL,
  `apellidos` varchar(50) COLLATE utf8_general_mysql500_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_general_mysql500_ci DEFAULT NULL,
  `contrasena` varchar(50) COLLATE utf8_general_mysql500_ci DEFAULT NULL,
  `fecha_nac` date DEFAULT NULL,
  `genero` varchar(50) COLLATE utf8_general_mysql500_ci DEFAULT NULL,
  `es_admin` varchar(50) COLLATE utf8_general_mysql500_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Volcado de datos para la tabla `USUARIO`
--

INSERT INTO `USUARIO` (`nickname`, `nombre`, `apellidos`, `email`, `contrasena`, `fecha_nac`, `genero`, `es_admin`) VALUES
('antoniolora23', 'Antonio', 'Calzado', 'antonio23@gmail.com', '3e5f2ce4f1d29846c7c2478679be4f3d', '2002-05-02', 'M', '1'),
('antoniolora2332', 'Antonio', 'Calzado', 'antonio23@gmail.com', 'Antonio23', '2002-05-02', 'M', '1'),
('antoniolora23322', 'Antonio', 'Calzado', 'antonio232323@gmail.com', 'd9a7aee0d26f811fdac4f9f8d0cf3c0b', '2002-05-02', 'M', '1'),
('aswetland8', 'Ancell', 'Swetland', 'aswetland8@jiathis.com', 'd2e9f672b2560c52f2970015e038c132', '1994-09-06', 'M', '1'),
('ccovelle2', 'Camila', 'Covelle', 'ccovelle2@seattletimes.com', '253ab4ed52a3089589bec6c804b02e28', '2013-05-07', 'F', '0'),
('javielito', 'Javi', 'Guerras', 'elguerras@noaa.gov', 'abfde839bcd8f4e609b0d6eed93d64b1', '1979-03-08', 'M', '0'),
('lmcmoyer5', 'Lyman', 'McMoyer', 'lmcmoyer5@soup.io', 'be055d05f6bbb7374e9cc15975a99699', '2001-12-29', 'M', '1'),
('lrasp4', 'Leroi', 'Rasp', 'lrasp4@yellowbook.com', '6000c9b6f2feed7eefbd75adf16ea788', '2001-08-22', 'M', '1'),
('rminchella3', 'Rollie', 'Minchella', 'rminchella3@telegraph.co.uk', 'e1ca1a23bed59d68c479d09984f52b42', '2017-09-23', 'M', '1'),
('sandriulis7', 'Simon', 'Andriulis', 'sandriulis7@icq.com', '765a2805cf6262e1a3a2c81955b9dff0', '2010-12-03', 'M', '1'),
('sfedder1', 'Sonnie', 'Fedder', 'sfedder1@prnewswire.com', '815236005f54b502953912883a60ab5d', '1996-01-15', 'M', '1'),
('tlatour6', 'Tibold', 'Latour', 'tlatour6@nba.com', 'a8049398a6c34e7d1229c6393f17e770', '2019-09-03', 'M', '0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `USUARIO_ARTICLES`
--

CREATE TABLE `USUARIO_ARTICLES` (
  `name_usuario` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci NOT NULL,
  `id_article` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `USUARIO_ARTICLES`
--

INSERT INTO `USUARIO_ARTICLES` (`name_usuario`, `id_article`) VALUES
('antoniolora23322', 1),
('antoniolora23322', 2),
('antoniolora23322', 3),
('antoniolora23322', 4),
('antoniolora23322', 5),
('antoniolora23', 6),
('antoniolora23322', 6),
('antoniolora23322', 7),
('antoniolora23322', 8),
('antoniolora23322', 9),
('antoniolora23322', 10);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ARTICLES`
--
ALTER TABLE `ARTICLES`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_ARTICLES` (`id_categoria`);

--
-- Indices de la tabla `CATEGORIA`
--
ALTER TABLE `CATEGORIA`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `USUARIO`
--
ALTER TABLE `USUARIO`
  ADD PRIMARY KEY (`nickname`);

--
-- Indices de la tabla `USUARIO_ARTICLES`
--
ALTER TABLE `USUARIO_ARTICLES`
  ADD PRIMARY KEY (`name_usuario`,`id_article`),
  ADD KEY `FK1` (`id_article`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ARTICLES`
--
ALTER TABLE `ARTICLES`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `CATEGORIA`
--
ALTER TABLE `CATEGORIA`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ARTICLES`
--
ALTER TABLE `ARTICLES`
  ADD CONSTRAINT `FK_ARTICLES` FOREIGN KEY (`id_categoria`) REFERENCES `CATEGORIA` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `USUARIO_ARTICLES`
--
ALTER TABLE `USUARIO_ARTICLES`
  ADD CONSTRAINT `FK1` FOREIGN KEY (`id_article`) REFERENCES `ARTICLES` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK2` FOREIGN KEY (`name_usuario`) REFERENCES `USUARIO` (`nickname`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
