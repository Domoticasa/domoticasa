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

CREATE TABLE Sensor (
	OID_Dis INT PRIMARY KEY AUTO_INCREMENT,
    	nombre VARCHAR(30) NOT NULL,
    	valor SMALLINT DEFAULT 0
);
/* - - - FIN TABLAS - - - */

/* - - - COMPONENTES - - - */
insert into usuario (alias, pass)
values ("admin", "admin");

insert into dispositivo (nombre, estado)
values 	("12", 0),
		("l1", 0),
		("l0", 0);

insert into sensor (nombre, valor)
values 	("A0", 0),
	("A1", 0),
	("A2", 0);
/* - - - FIN COMPONENTES - - - */