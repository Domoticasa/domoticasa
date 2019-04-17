DROP DATABASE IF EXISTS Domoticasa;
CREATE SCHEMA Domoticasa;
USE Domoticasa;

/* - - - TABLAS - - - */
CREATE TABLE Usuario (
	alias VARCHAR(30) PRIMARY KEY,
	pass VARCHAR(30) NOT NULL
);

CREATE TABLE Dispositivo (
	OID_Dis INT PRIMARY KEY AUTO_INCREMENT,
    	nombre VARCHAR(30) NOT NULL,
    	estado BOOLEAN DEFAULT false
);
/* - - - FIN TABLAS - - - */