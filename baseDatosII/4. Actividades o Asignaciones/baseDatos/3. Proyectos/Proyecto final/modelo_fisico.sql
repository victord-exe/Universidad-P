------------

/*
integrantes:
Victor Rodriguez el de cedula 20
Alejandro Mosquera
Diego Navarro
Eladio Gonzales
Jose Delgado
*/
🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸🛸

-- cuando se expiden un dron de una central
/*
la empresa de envios de productos farmaceuticos con drones cistica desea levantar una base de datos para llevar un registro de
sus operaciones de envios, la empresa quere registrar sus drones con los siguientes datos: 
codigo de dron, marca, modelo, año de fabricacion, disponibillidad ('Y': disponible, 'N': no disponible), capacidad de carga y velocidad promedio.
tambien desea guardar los siguientes datos de las farmacias que solicitan envios:
codigo de farmacia, ruc, nombre, correo, coordenadas decimales (latitud, longitud) y telefonos.
de los envios realizados se desan guardar los siguientes datos:
el codigo del envio, que dron lo realiza, que farmacia pide el envio, la ubicacion de la entrega(longitud, latitud),
peso, la distancia, el precio del envio, la fecha y hora de cuando sale de la farmacia, fecha y hora de entrega al cliente final,
el tiempo de entrega se toma de las fechas y hora de envio y entrega.

la distancia se calculara tomando el punto inicial y el punto final utilizando la formula de Haversine

El precio sera:
    para distancias menores a 2km: $5
    para distancias entre 2 y 5km: $10
    para distancias entre 5 y 10km: $15
    para distancias entre 10 y 20km: $20
    para distancias superiores a 20km: $35

cistica cuenta con centrales en lugares estrategicos de donde salen y a donde llegan drones, las ctrales tienen cod_central, nombre, longitud y latitud.

tambien la empresa cuenta con un personal del que desea registrar estos datos:
codigo de personal, nombre, apellido, cedula, fecha de nacimiento, sexo, los telefonos para cada tipo de personal y codigo de horario.
el personal de mecanicos trajaba en las centrales,
un mecanico trabaja en una central y en una central trabajan muchas mecanicos.
los supervisores de drones trabajan remotamente monitoreando los envios
un supervisor monitorea varios envios pero un envio solo puede ser monitoriado por un supervisor.

la empresa tiene 3 tipos de  horario:
-matutino: 5:00 A.M. - 1:00 P.M.
-vespertino: 1:00 P.M. - 9:00 P.M.
-nocturno: 9:00 P.M - 5:00 A.M.

se quiere tener un control de como es movimiento de los drones entre las diferentes centrales,
se tiene que tener en cuenta que los drones pueden salir de una central y llegar a otra
y se quiere registrar cuando un dron sale de que central y cuando llega a una central,
las centrales son las que detectan cuando un dron llega y sale independientemente de si
se pide un envio o no, para reforzar la seguridad o si se quiere cambiar un dron de central.

ademas cistica desea tener registro para cada farmacia las sumas y el promedio del: precio, peso y distancia de los envios

*/

-------------
DROP USER proyectof CASCADE;
------------
CREATE USER proyectof identified by 123;
GRANT CONNECT TO proyectof;
GRANT RESOURCE TO proyectof;
CONN proyectof
123
---------------A
CREATE TABLE Horarios (
    cod_horario VARCHAR2(4) NOT NULL,
    hora_inicio DATE NOT NULL, -- hora y minuto HH24, MIN
    hora_final DATE NOT NULL, -- hora y minuto HH24, MIN
    tipo_turno VARCHAR2(25) NOT NULL, -- matutino, vespertino, nocturno
    CONSTRAINT HORARIO_cod_horario_pk PRIMARY KEY (cod_horario)
);



CREATE SEQUENCE cod_central_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE Central(
    cod_central NUMBER NOT NULL,
    nombre VARCHAR2(25) UNIQUE,
    longitud_central VARCHAR2(50) NOT NULL,
    latitud_central VARCHAR2(50) NOT NULL,
    CONSTRAINT CENTRAL_cond_central_pk PRIMARY KEY (cod_central)
);


CREATE SEQUENCE cod_personal_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE Personal (
    cod_personal NUMBER,
    nombre VARCHAR2(50) NOT NULL,
    apellido VARCHAR2(50) NOT NULL,
    cedula VARCHAR2(10) UNIQUE NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    sexo CHAR NOT NULL,
    cod_horario_personal VARCHAR2(4) NOT NULL,
    CONSTRAINT PERSONAL_cod_horario_p_fk FOREIGN KEY (cod_horario_personal) REFERENCES Horarios(cod_horario),
    CONSTRAINT PERSONAL_id_personal_pk PRIMARY KEY(cod_personal)
);

CREATE TABLE Mecanico (
    cod_mecanico NUMBER NOT NULL,
    cod_central_mecanico NUMBER NOT NULL,
    FOREIGN KEY (cod_mecanico) REFERENCES Personal(cod_personal),
    CONSTRAINT MECANICO_cod_central_FK FOREIGN KEY (cod_central_mecanico) REFERENCES Central(cod_central),
    CONSTRAINT MECANICO_cod_PERSONAL_PK PRIMARY KEY(cod_mecanico)
);

CREATE TABLE Supervisor (
    cod_supervisor NUMBER PRIMARY KEY,
    FOREIGN KEY (cod_supervisor) REFERENCES Personal(cod_personal)
);


CREATE TABLE Telefono_Mecanico(
    cod_mecanico_tel NUMBER NOT NULL,
    telefono_mecanico VARCHAR2(25) NOT NULL,
    CONSTRAINT TELEFONO_MECANICO_cod_mec_fk FOREIGN KEY (cod_mecanico_tel)
        REFERENCES Mecanico(cod_mecanico),
    CONSTRAINT Telefono_Mecanico_telefono_pk PRIMARY KEY (telefono_mecanico, cod_mecanico_tel)
);


CREATE TABLE Telefono_Supervisor(
    cod_supervisor_tel NUMBER NOT NULL,
    telefono_supervisor VARCHAR2(25) NOT NULL,
    CONSTRAINT TEL_SUP_cod_sup_fk FOREIGN KEY (cod_supervisor_tel) REFERENCES Supervisor(cod_supervisor),
    CONSTRAINT TEL_SUP_telefono_sup_PK PRIMARY KEY (telefono_supervisor, cod_supervisor_tel)
);


CREATE SEQUENCE cod_farmacia_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE Farmacia(
    cod_farmacia NUMBER NOT NULL,
    ruc VARCHAR2(40) NOT NULL,
    nombre VARCHAR2(35) NOT NULL,
    correo VARCHAR2(55) NOT NULL UNIQUE,
    longitud_farmacia Number(8,6) NOT NULL,
    latitud_farmacia Number(8,6) NOT NULL,
    CONSTRAINT FARMACIA_cod_farmacia PRIMARY KEY (cod_farmacia)
);


CREATE TABLE Farmacia_Telefono(
    telefono_farmacia VARCHAR2(25),
    cod_farmacia_tel NUMBER NOT NULL,
    CONSTRAINT FARMACIA_TEL_cod_farmacia FOREIGN KEY (cod_farmacia_tel) REFERENCES Farmacia(cod_farmacia),
    CONSTRAINT FARMACIA_PK PRIMARY KEY (telefono_farmacia, cod_farmacia_tel)
);


CREATE SEQUENCE cod_dron_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE Dron(
    cod_dron NUMBER NOT NULL,
    marca VARCHAR2(50) NOT NULL,
    modelo VARCHAR2(50) NOT NULL,
    fecha_fabricacion DATE NOT NULL,
    disponibilidad CHAR NOT NULL,
    capacidad_carga NUMBER NOT NULL, --en kilogramos
    velocidad_promedio NUMBER NOT NULL, -- en km/h ??
    CONSTRAINT DRON_cod_dron_pk PRIMARY KEY (cod_dron)
);


CREATE SEQUENCE cod_envio_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE Envio(
    cod_envio NUMBER NOT NULL,
    precio NUMBER NOT NULL,
    distancia NUMBER(4,2) NOT NULL, -- kilometros
    fecha_envio TIMESTAMP(2), -- de cuando sale de la farmacia
    fecha_entrega TIMESTAMP(2), --de cuando se entrega al cliente
    peso NUMBER NOT NULL, --en kilogramos del paquete que se envia
    latitud_final Number(8,6) NOT NULL, -- <-- para la ubicacion final de la entrega
    longitud_final Number(8,6) NOT NULL,-- <-- para la ubicacion final de la entrega
    cod_farmacia_envio NUMBER NOT NULL,
    cod_supervisor_envio NUMBER NOT NULL,
    cod_dron_envio NUMBER NOT NULL,
    tiempo_entrega INTERVAL DAY TO SECOND,     --calcular
    CONSTRAINT ENVIO_cod_envio_pk PRIMARY KEY(cod_envio),
    CONSTRAINT ENVIO_cod_farm_envio_fk FOREIGN KEY (cod_farmacia_envio)
        REFERENCES Farmacia(cod_farmacia),
    CONSTRAINT ENVIO_cod_sup_envio_fk FOREIGN KEY (cod_supervisor_envio)
        REFERENCES Supervisor(cod_supervisor),
    CONSTRAINT ENVIO_cod_dron_envio_fk FOREIGN KEY(cod_dron_envio)
        REFERENCES Dron(cod_dron)
);

CREATE TABLE ExpideDronCentral (
    dron NUMBER NOT NULL,
    central NUMBER NOT NULL,
    fecha_salida_central TIMESTAMP(2) NOT NULL,
    CONSTRAINT EXPDRONCENT_dron_FK FOREIGN KEY (dron) REFERENCES Dron(cod_dron),
    CONSTRAINT EXPDRONCENT_central_FK FOREIGN KEY (central) REFERENCES Central(cod_central),
    CONSTRAINT EXPDRONCENT_PK PRIMARY KEY (dron, central, fecha_salida_central)
);

CREATE TABLE RecibeDronCentral (
    dron NUMBER NOT NULL,
    central NUMBER NOT NULL,
    fecha_llegada_central TIMESTAMP(2) NOT NULL,
    CONSTRAINT RECDRONCENT_dron_FK FOREIGN KEY (dron) REFERENCES Dron(cod_dron),
    CONSTRAINT RECDRONCENT_central_FK FOREIGN KEY (central) REFERENCES Central(cod_central),
    CONSTRAINT RECDRONCENT_PK PRIMARY KEY (dron, central, fecha_llegada_central)
);

CREATE SEQUENCE cod_control_mov_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE ControlMovimiento(
    cod_control_movimiento NUMBER NOT NULL,
    dron NUMBER NOT NULL,
    central_salida NUMBER NOT NULL,
    central_llegada NUMBER,
    fecha_salida TIMESTAMP(2) NOT NULL,
    fecha_llegada TIMESTAMP(2),
    CONSTRAINT CONTROL_central_llegada_FK FOREIGN KEY(Central_llegada)
        REFERENCES Central(cod_central),
    CONSTRAINT CONTROL_central_salida_FK FOREIGN KEY(Central_salida)
        REFERENCES Central(cod_central),
    CONSTRAINT CONTROL_cod_dron_ctrl_Fk FOREIGN KEY(dron)
        REFERENCES Dron(cod_dron),
    CONSTRAINT CONTROL_cod_control_PK PRIMARY KEY(cod_control_movimiento)
);

CREATE SEQUENCE cod_control_envio_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE ControlEnvio (
    cod_control_envio NUMBER NOT NULL,
    cod_farmacia_ctrl NUMBER NOT NULL,
    precio_promedio NUMBER,
    distancia_promedio NUMBER,
    peso_promedio NUMBER,
    suma_precio NUMBER,
    suma_distancia NUMBER,
    suma_peso NUMBER,
    CONSTRAINT CONTROLENVIO_farmacia_FK FOREIGN KEY (cod_farmacia_ctrl) 
        REFERENCES Farmacia(cod_farmacia),
    CONSTRAINT CONTROLENVIO_cod_control_PK PRIMARY KEY(cod_control_envio, cod_farmacia_ctrl)
);
