-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-02-2019 a las 06:30:07
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `prestamos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `cedula` int(11) NOT NULL,
  `nombre` char(20) NOT NULL,
  `primerapellido` char(20) NOT NULL,
  `segundoapellido` char(20) NOT NULL,
  `telefonoCasa` char(20) DEFAULT NULL,
  `telefonoMovil` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`cedula`, `nombre`, `primerapellido`, `segundoapellido`, `telefonoCasa`, `telefonoMovil`) VALUES
(1097405178, 'David', 'Perez', 'Alvarado', '3108986616', '00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `NumPrestamo` int(11) NOT NULL,
  `CC_Solicitante` int(11) NOT NULL,
  `Cantidad` double NOT NULL,
  `fecha_de_Solicitud` date NOT NULL,
  `estadoDeAprobacion` int(11) NOT NULL,
  `fecha_de_devolucion` date NOT NULL,
  `Valor_Cuota` double NOT NULL,
  `Cantidad_cuotas` int(11) NOT NULL,
  `Cuotas pagadas` int(11) NOT NULL,
  `Proxima_Cuota` date NOT NULL,
  `Fecha_Entrega` date NOT NULL,
  `Saldo_Pendiente` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `prestamo`
--

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`cedula`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`NumPrestamo`),
  ADD KEY `CC_Solicitante` (`CC_Solicitante`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`CC_Solicitante`) REFERENCES `persona` (`cedula`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
