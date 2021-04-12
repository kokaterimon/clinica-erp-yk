CREATE TABLE Servicio (
	idServicio BIGINT(20) PRIMARY KEY AUTO_INCREMENT,    
    nombreServicio VARCHAR(50) NOT NULL,
    descripcion VARCHAR(50) NOT NULL,
    precioReferencia DECIMAL(5,2) NOT NULL,
    precio DECIMAL(5,2) NOT NULL,
    tiempoProceso VARCHAR(50) NOT NULL,    
    idTipoServicio BIGINT(20) NOT NULL,
    idTiempoProc BIGINT(20) NOT NULL,
    idMuestra BIGINT(20) NOT NULL,
    FOREIGN KEY (idTipoServicio) REFERENCES TipoServicio (idTipoServicio) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (idTiempoProc) REFERENCES TiempoProceso (idTiempoProc) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (idMuestra) REFERENCES Muestra (idMuestra) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;