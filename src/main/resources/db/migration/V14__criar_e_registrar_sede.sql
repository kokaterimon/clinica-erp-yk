CREATE TABLE Sede (
	idSede BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nombreSede VARCHAR(50) NOT NULL,
    direccion VARCHAR(50),
    telefono VARCHAR(50) NOT NULL,
    idEmpresa BIGINT(20) NOT NULL,
    FOREIGN KEY (idEmpresa) REFERENCES Empresa (idEmpresa) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;