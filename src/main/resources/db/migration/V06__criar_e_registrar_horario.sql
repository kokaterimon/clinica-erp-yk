CREATE TABLE Horario (
	idHorario  BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    idEmpleado BIGINT(20) NOT NULL,
    diaInicio DATE NOT NULL,
    diaFin DATE NOT NULL,
    horaEntrada TIME NOT NULL,
    horaSalida TIME NOT NULL,    
    FOREIGN KEY (idEmpleado) REFERENCES Empleado (idEmpleado) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;