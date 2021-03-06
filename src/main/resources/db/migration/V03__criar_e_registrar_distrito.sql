CREATE TABLE Distrito (
	idDistrito BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nombDistrito VARCHAR(50) NOT NULL,
	idProvincia BIGINT(20) NOT NULL,
    FOREIGN KEY (idProvincia) REFERENCES Provincia (idProvincia) ON DELETE RESTRICT ON UPDATE CASCADE  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;