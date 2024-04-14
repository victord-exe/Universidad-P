

CREATE TABLE Cliente (
  cliente_id NUMBER CONSTRAINT CLIENTE_cliente_id_PK PRIMARY KEY,
  cedula VARCHAR2(25) NOT NULL,
  nombre VARCHAR2(25) NOT NULL,
  apellido VARCHAR2(25) NOT NULL,
  sexo CHAR NOT NULL,
  fecha_nacimiento DATE NOT NULL,
  edad NUMBER NOT NULL,
  sucursal NUMBER NOT NULL,
 CONSTRAINT CLIENTE_SUCURSAL_FK FOREIGN KEY (sucursal) REFERENCES Sucursal(cod_sucursal)
)
CREATE TABLE Profesion (
  profesion_id NUMBER CONSTRAINT PREFESION_profesion_id_PK PRIMARY KEY,
  profesion VARCHAR2(25) NOT NULL,
  cliente NUMBER NOT NULL,
   CONSTRAINT PROFESION_cliente_FK FOREIGN KEY (cliente) REFERENCES Cliente(cliente_id)
)

CREATE TABLE Tipo_Email (
  tipo_email_id NUMBER CONSTRAINT TIPO_tipo_id_PK PRIMARY KEY,
  tipo_email VARCHAR2(25) NOT NULL
)

CREATE TABLE Email (
  email VARCHAR2(25) NOT NULL UNIQUE,
  cliente NUMBER NOT NULL,
  tipo_email NUMBER NOT NULL,
  CONSTRAINT EMAIL_cliente_fK FOREIGN KEY (cliente) REFERENCES Cliente(cliente_id),
  CONSTRAINT EMAIL_tipo_FK FOREIGN KEY (tipo_email) REFERENCES Tipo_Email(tipo_email_id),
  CONSTRAINT EMAIL_email_id_PK PRIMARY KEY (email, cliente)
);


CREATE TABLE Tipo_Telefono (
  tipo_telefono_id NUMBER CONSTRAINT TIPOTELEFONO_id_pk PRIMARY KEY,
  tipo_telefono varchar2(25) NOT NULL
)

CREATE TABLE Telefono (
  telefono VARCHAR2(25) NOT NULL,
  cliente NUMBER NOT NULL,
  tipo_telefono NUMBER NOT NULL,
  CONSTRAINT TELEFONO_telefono_id_PK PRIMARY KEY(telefono, cliente),
  CONSTRAINT Telefono_tipo_telefono FOREIGN KEY (tipo_telefono) REFERENCES Tipo_Telefono(tipo_telefono_id)
)

CREATE TABLE Tipo_Prestamo (
  tipo_prestamo_id NUMBER CONSTRAINT TIPO_PRESTAMO_id_PK PRIMARY KEY,
  tipo_prestamo VARCHAR2(50) NOT NULL
)

CREATE TABLE Prestamo (
    numero_prestamo NUMBER NOT NULL,
    cliente NUMBER NOT NULL,
    tipo_prestamo NUMBER NOT NULL,
    fecha_aprobado DATE NOT NULL,
    monto_aprobado NUMBER NOT NULL,
    tasa_interes NUMBER NOT NULL,
    letra_mensual NUMBER NOT NULL,
    monto_pagado NUMBER NOT NULL,
    fecha_pago DATE NOT NULL,
    sucursal NUMBER NOT NULL,
    CONSTRAINT PRESTAMO_numero_prestamo_pk PRIMARY KEY (numero_prestamo),
    CONSTRAINT PRESTAMO_cliente_id_fk FOREIGN KEY (cliente) REFERENCES Cliente(cliente_id),
    CONSTRAINT PRESTAMO_tipo_prestamo_fk FOREIGN KEY (tipo_prestamo) REFERENCES Tipo_Prestamo(tipo_prestamo_id),
    CONSTRAINT PRESTAMO_SUCURSAL_FK FOREIGN KEY (sucursal) REFERENCES Sucursal(cod_sucursal)
);

  CREATE TABLE transacpagos (
    transaccion_id NUMBER CONSTRAINT TRANSACPAGOS_transaccion_id_PK PRIMARY KEY,
    fecha_transaccion DATE NOT NULL,
    monto_pago NUMBER NOT NULL,
    estado char NOT NULL,
    fecha_insercion TIMESTAMP(3) NOT NULL,
    usuario varchar2(25) NOT NULL,
    sucursal NUMBER NOT NULL,
    cliente NUMBER NOT NULL,
    prestamo NUMBER NOT NULL,
  CONSTRAINT TRANSACPAGOS_sucursal_FK FOREIGN KEY (sucursal) REFERENCES Sucursal(cod_sucursal),
  CONSTRAINT TRANSACPAGOS_cliente_FK FOREIGN KEY (cliente) REFERENCES Cliente(cliente_id),
  CONSTRAINT TRANSACPAGOS_tipo_prestamo_FK FOREIGN KEY (prestamo) REFERENCES Tipo_Prestamo(tipo_prestamo_id)
  );

CREATE SEQUENCE profesion_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE cliente_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE prestamo_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE transaccion_id_seq START WITH 1 INCREMENT BY 1;



CREATE TABLE Sucursal (
  cod_sucursal NUMBER CONSTRAINT SUCURSAL_cod_sucursal_id_PK PRIMARY KEY,
  nombre_sucursal VARCHAR2(25) NOT NULL UNIQUE,
  montoprestamo NUMBER NOT NULL
)

ALTER TABLE Clientes
ADD (
   edad NUMBER,
   cod_sucursal_c NUMBER,
   CONSTRAINT CLIENTES_cod_sucursal_c_FK FOREIGN KEY (cod_sucursal_c) REFERENCES Sucursal(cod_sucursal)
);


ALTER TABLE Prestamo(
  ADD(
  cod_sucursal_p NUMBER,
    --el _P alfinal del atributo quiere decir que es el atributo de la tabla Prestamos
  saldo_actual NUMBER NOT NULL,
  interes_pagado NUMBER NOT NULL,
  fecha_modificacion TIMESTAMP(3),
  usuario varchar2(25) NOT NULL,

  CONSTRAINT PRESTAMO_cod_sucursal_p_FK FOREIGN KEY (cod_sucursal_p) REFERENCES Sucursal(cod_sucursal)
  )
);
