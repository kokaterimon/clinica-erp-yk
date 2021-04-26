CREATE TABLE Empleado (
	idEmpleado BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	dni VARCHAR(50) NOT NULL,
	direccion VARCHAR(50),
	nombres VARCHAR(50),
	apellidos VARCHAR(50),
	telefono VARCHAR(50),
	salario VARCHAR(50),
	fechaNacimiento DATE,
	fechaInicio DATE,
	fechaFin DATE,
	estado VARCHAR(50),
	idDistrito BIGINT(20) NOT NULL,
	FOREIGN KEY (idDistrito) REFERENCES Distrito (idDistrito) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

