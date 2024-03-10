/*
integrantes:
Victor Rodriguez el de cedula 20
Alejandro Mosquera
Diego Navarro
Eladio Gonzales
Jose Delgado
*/

CREATE OR REPLACE TRIGGER t_expide_dron_central
AFTER INSERT ON ExpideDronCentral
FOR EACH ROW
BEGIN
INSERT INTO ControlMovimiento (
  cod_control_movimiento,
  dron,
  central_salida,
  fecha_salida
  ) VALUES (
    cod_control_mov_seq.NEXTVAL,
    :new.dron,
    :new.central,
    :new.fecha_salida_central
  );
  EXCEPTION
  WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('no se encontraron valores en el trigger t_expide_dron_central');
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('ya existe ese codigo de control_movimientos');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('ERROR AL INSERTAR CONTROL_MOVIMIENTO');
  END t_expide_dron_central;
/

CREATE OR REPLACE TRIGGER t_recibe_dron_central
AFTER INSERT ON RecibeDronCentral
FOR EACH ROW
BEGIN
UPDATE ControlMovimiento
    SET
        central_llegada = :new.central,
        fecha_llegada = :new.fecha_llegada_central
    WHERE dron = :new.dron AND central_llegada IS NULL AND fecha_llegada IS NULL;
EXCEPTION
WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('no se encontraron valores en el trigger t_recibe_dron_central');
END t_recibe_dron_central;
/

    CREATE OR REPLACE TRIGGER t_insertar_control_envio
    AFTER INSERT ON Farmacia
    FOR EACH ROW
    BEGIN
    INSERT INTO ControlEnvio (
      cod_control_envio,
      cod_farmacia_ctrl
    ) VALUES (
      cod_control_envio_seq.NEXTVAL,
      :new.cod_farmacia
    );
    EXCEPTION
      WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('ya existe ese codigo de control_envio');
      WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR AL INSERTAR CONTROL_ENVIO' || SQLERRM);
    END t_insertar_control_envio;
    /

CREATE OR REPLACE TRIGGER t_tiempoEntrega
  BEFORE UPDATE OF fecha_entrega ON Envio
  FOR EACH ROW
  BEGIN
   :NEW.tiempo_entrega := calcularTiempoEntrega(:NEW.fecha_envio, :NEW.fecha_entrega);
EXCEPTION
 WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('ERROR AL INSERTAR CONTROL_ENVIO' || SQLERRM);
END t_tiempoEntrega;
/

