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
    estado BOOLEAN DEFAULT false,
    habitacion INT
);

CREATE TABLE Habitacion (
	OID_Hab INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    tipo ENUM ('Dormitorio', 'Estudio', 'Salon', 'Baño', 
				'Cocina', 'Patio', 'Azotea', 'Escalera', 'Otro'),
    planta INT NOT NULL
);

CREATE TABLE Sensor (
	OID_Sen INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    estado BOOLEAN DEFAULT false,
    habitacion INT
);

CREATE TABLE Permiso (
	OID_Per INT PRIMARY KEY AUTO_INCREMENT,
    alias VARCHAR(30),
    OID_Dis INT
);
/* - - - FIN TABLAS - - - */

/* - - - CLAVES FORANEAS - - - */
ALTER TABLE Dispositivo ADD CONSTRAINT fk_DisHab FOREIGN KEY (habitacion) REFERENCES Habitacion (OID_Hab)
	ON UPDATE RESTRICT
    ON DELETE SET NULL;
ALTER TABLE Sensor ADD CONSTRAINT fk_SenHab FOREIGN KEY (habitacion) REFERENCES Habitacion (OID_Hab)
	ON UPDATE RESTRICT
    ON DELETE SET NULL;
ALTER TABLE Permiso ADD CONSTRAINT fk_PerUsu FOREIGN KEY (alias) REFERENCES Usuario (alias)
	ON UPDATE RESTRICT
    ON DELETE CASCADE;
ALTER TABLE Permiso ADD CONSTRAINT fk_PerDis FOREIGN KEY (OID_Dis) REFERENCES Dispositivo (OID_Dis)
	ON UPDATE RESTRICT
    ON DELETE CASCADE;
/* - - - FIN CLAVES FORANEAS - - - */