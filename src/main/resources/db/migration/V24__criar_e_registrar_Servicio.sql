CREATE TABLE Servicio (
	idServicio BIGINT(20) PRIMARY KEY AUTO_INCREMENT,    
    nombreServicio VARCHAR(50),
    descripcion VARCHAR(50),
    precioReferencia DECIMAL(5,2),
    precio DECIMAL(5,2),
    tiempoProceso VARCHAR(50),    
    idTipoServicio BIGINT(20) NOT NULL,
    idTiempoProc BIGINT(20) NOT NULL,
    idMuestra BIGINT(20) NOT NULL,
    FOREIGN KEY (idTipoServicio) REFERENCES TipoServicio (idTipoServicio) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (idTiempoProc) REFERENCES TiempoProceso (idTiempoProc) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (idMuestra) REFERENCES Muestra (idMuestra) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;