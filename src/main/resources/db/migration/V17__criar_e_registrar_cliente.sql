CREATE TABLE Cliente (
	idCliente BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    direccion VARCHAR(50),
    telefono VARCHAR(50),
    email VARCHAR(50),
    tipoCliente INT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;