
CREATE TABLE persona (
  cedula integer NOT NULL,
  nombre varchar(20) NOT NULL,
  primerapellido varchar(20) NOT NULL,
  segundoapellido varchar(20) NOT NULL,
  telefonoCasa varchar(20) DEFAULT NULL,
  telefonoMovil varchar(20) NOT NULL
) ;



INSERT INTO persona (cedula, nombre, primerapellido, segundoapellido, telefonoCasa, telefonoMovil) VALUES
(1097405178, 'David', 'Perez', 'Alvarado', '3108986616', '00');


CREATE TABLE prestamo (
  NumPrestamo integer NOT NULL,
  CC_Solicitante integer NOT NULL,
  Cantidad double NOT NULL,
  fecha_de_Solicitud date NOT NULL,
  estadoDeAprobacion integer NOT NULL,
  fecha_de_devolucion date NOT NULL,
  Valor_Cuota double NOT NULL,
  Cantidad_cuotas integer NOT NULL,
  Cuotas_pagadas integer NOT NULL,
  Proxima_Cuota date NOT NULL,
  Fecha_Entrega date NOT NULL,
  Saldo_Pendiente double NOT NULL
) ;


--
ALTER TABLE persona
  ADD PRIMARY KEY (cedula);

ALTER TABLE prestamo
  ADD PRIMARY KEY (NumPrestamo),
  ADD KEY CC_Solicitante (CC_Solicitante);


ALTER TABLE prestamo
  ADD CONSTRAINT prestamo_ibfk_1 FOREIGN KEY (CC_Solicitante) REFERENCES persona (cedula);
COMMIT;


