CREATE TABLE Cliente (
	idCliente BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    direccion VARCHAR(50) NOT NULL,
    telefono VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    idTipoCliente BIGINT(20) NOT NULL,
    FOREIGN KEY (idTipoCliente) REFERENCES TipoCliente (idTipoCliente) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;