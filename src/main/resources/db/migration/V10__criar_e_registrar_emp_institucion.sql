CREATE TABLE Emp_Institucion (
	idInstitucion BIGINT(20) NOT NULL,
	idEmpleado BIGINT(20) NOT NULL,

    fechaInicio DATE NOT NULL,
    fechaFin DATE NOT NULL,
	archivo VARCHAR(50),

    FOREIGN KEY (idInstitucion) REFERENCES Institucion (idInstitucion) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (idEmpleado) REFERENCES Empleado (idEmpleado) ON DELETE RESTRICT ON UPDATE CASCADE,
    PRIMARY KEY (idInstitucion, idEmpleado)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;