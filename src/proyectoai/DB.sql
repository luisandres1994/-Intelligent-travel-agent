DROP TABLESPACE AGENTES INCLUDING CONTENTS AND DATAFILES;
CREATE TABLESPACE AGENTES DATAFILE 'AGENTES.DBF' SIZE 5M;

DROP USER AGENTE CASCADE;
CREATE USER AGENTE IDENTIFIED BY 123456
DEFAULT TABLESPACE AGENTES
QUOTA UNLIMITED ON AGENTES;



GRANT CONNECT, CREATE SESSION, CREATE VIEW, CREATE TABLE, ALTER SESSION, CREATE SEQUENCE, RESOURCE TO AGENTE;

GRANT SELECT ANY TABLE TO AGENTE;


DISCONN
CONNECT AGENTE/123456;

CREATE TABLE transporte
(
	id NUMBER PRIMARY KEY,
	descripcion VARCHAR(101),
	precio FLOAT,
	destino VARCHAR(21),
        cant_perso NUMBER,
	tipo VARCHAR(21)
);

CREATE TABLE alojamiento
(
	id NUMBER PRIMARY KEY,
	tipo VARCHAR(21),
	precio FLOAT,
        tipo_destino VARCHAR(21),
	destino VARCHAR(21),
	nombre VARCHAR(101),
        cant_perso NUMBER
);

CREATE TABLE turista
(
	cod number PRIMARY KEY,
	precio float,
	destino VARCHAR(21),
	actividades VARCHAR(101),
	cant_perso NUMBER
);

