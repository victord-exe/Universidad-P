              /*
integrantes:
Victor Rodriguez el de cedula 20
Alejandro Mosquera
Diego Navarro
Eladio Gonzales
Jose Delgado
*/                                         
------------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------                         FUNCIONES                                         ------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------

--funcion para calcular el tiempo recorrido despues de entregar el envio al cliente final
CREATE OR REPLACE FUNCTION calcularTiempoEntrega(
    p_fecha_envio IN Envio.fecha_envio%TYPE,
    p_fecha_entrega IN Envio.fecha_entrega%TYPE
) RETURN INTERVAL DAY TO SECOND IS
    v_tiempo_entrega INTERVAL DAY TO SECOND;
BEGIN
    v_tiempo_entrega := p_fecha_entrega - p_fecha_envio;
    RETURN v_tiempo_entrega;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error al calcular el tiempo de entrega.' || SQLERRM);
END calcularTiempoEntrega;
/

-- distancia aproximada
CREATE OR REPLACE FUNCTION RADIANS(degrees IN NUMBER)
 RETURN NUMBER IS
BEGIN
    RETURN degrees * 3.14159 / 180; -- Fórmula para convertir grados a radianes
END;
/
CREATE OR REPLACE FUNCTION calcularDistancia (
    P_latitud_inicial IN Farmacia.latitud_farmacia%TYPE,
    P_longitud_inicial IN Farmacia.longitud_farmacia%TYPE,
    P_latitud_final IN Envio.latitud_final%TYPE,
    P_longitud_final IN Envio.longitud_final%TYPE
) RETURN NUMBER IS
    earth_radius CONSTANT NUMBER := 6371; -- Radio de la Tierra en kilómetros
    d_lat NUMBER := RADIANS(P_latitud_final - P_latitud_inicial);
    d_lon NUMBER := RADIANS(P_longitud_final - P_longitud_inicial);
    a NUMBER;
    c NUMBER;
    distancia NUMBER;
BEGIN
    a := SIN(d_lat / 2) * SIN(d_lat / 2) +
         COS(RADIANS(P_latitud_inicial)) * COS(RADIANS(P_latitud_final)) *
         SIN(d_lon / 2) * SIN(d_lon / 2);
    c := 2 * ATAN2(SQRT(a), SQRT(1 - a));
    distancia := earth_radius * c;
    RETURN ROUND(distancia, 2);
EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('ERROR AL CALCULAR LA DISTANCIA' || SQLERRM);

END;
/

CREATE or REPLACE FUNCTION calcularPrecio(
  p_distancia IN Envio.distancia%TYPE
)
RETURN NUMBER IS
v_precio Envio.precio%TYPE;
BEGIN
IF p_distancia < 2 THEN
  v_precio := 5;
  ELSIF p_distancia BETWEEN 2 AND 5 THEN
  v_precio := 10;
  ELSIF p_distancia BETWEEN 5 AND 10 THEN
  v_precio := 15;
  ELSIF p_distancia BETWEEN 10 AND 20 THEN
  v_precio := 20;
  ELSE
  v_precio := 35;
END IF;
RETURN v_precio;
EXCEPTION
  WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('ERROR AL CALCULAR EL PRECIO' || SQLERRM);
END calcularPrecio;
/


-------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------                 Insertar Horario                                         -----------------------
-------------------------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE insertarHorario (
  p_cod_horario IN Horarios.cod_horario%TYPE,
  p_hora_inicio IN Horarios.hora_inicio%TYPE,
  p_hora_final IN Horarios.hora_final%TYPE,
  p_tipo_turno IN Horarios.tipo_turno%TYPE
) AS
BEGIN
INSERT INTO Horarios (cod_horario, hora_inicio, hora_final, tipo_turno) VALUES
(p_cod_horario, p_hora_inicio, p_hora_final, p_tipo_turno);
    DBMS_OUTPUT.PUT_LINE('Horario Insertado existosamente');

EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
  DBMS_OUTPUT.PUT_LINE('ya existe ese codigo de horario');
  WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('ERROR AL INSERTAR HORARIOS');
COMMIT;
END insertarHorario;
/

-------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------                 Insertar Central                                         -----------------------
-------------------------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE insertarCentral(
    p_nombre IN Central.nombre%TYPE,
    p_longitud_central IN Central.longitud_central%TYPE,
    p_latitud_central IN Central.latitud_central%TYPE
) AS
BEGIN
    INSERT INTO Central(
        cod_central,
        nombre,
        longitud_central,
        latitud_central
    ) VALUES (
        cod_central_seq.NEXTVAL,
        p_nombre,
        p_longitud_central,
        p_latitud_central
    );
    DBMS_OUTPUT.PUT_LINE('central Insertada existosamente');

EXCEPTION
WHEN DUP_VAL_ON_INDEX THEN
  DBMS_OUTPUT.PUT_LINE('ya existe ese codigo de central');
  WHEN OTHERS THEN
  DBMS_OUTPUT.PUT_LINE('ERROR AL INSERTAR CENTRAL');
COMMIT;
END insertarCentral;
/

-------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------                 Insertar Meecanico                                         ----------------------
-------------------------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE insertarMecanico (
    p_nombre IN Personal.nombre%TYPE,
    p_apellido IN Personal.apellido%TYPE,
    p_cedula IN Personal.cedula%TYPE,
    p_fecha_nacimiento IN Personal.fecha_nacimiento%TYPE,
    p_sexo IN Personal.sexo%TYPE,
    p_cod_horario_personal IN Personal.cod_horario_personal%TYPE,
    p_central_nombre IN Central.nombre%TYPE,
    p_telefono_mecanico IN Telefono_Mecanico.telefono_mecanico%TYPE
) IS
    v_cod_personal Personal.cod_personal%TYPE;
    v_cod_central Central.cod_central%TYPE;
BEGIN
SELECT cod_central INTO v_cod_central
   FROM Central WHERE nombre = p_central_nombre;

    
    INSERT INTO Personal (
        cod_personal,
        nombre,
        apellido,
        cedula,
        fecha_nacimiento,
        sexo,
        cod_horario_personal
    ) VALUES (
        cod_personal_seq.NEXTVAL,
        p_nombre,
        p_apellido,
        p_cedula,
        p_fecha_nacimiento,
        p_sexo,
        p_cod_horario_personal
    ) RETURNING cod_personal INTO v_cod_personal;


    INSERT INTO Mecanico (
        cod_mecanico,
        cod_central_mecanico
    ) VALUES (
        v_cod_personal,
        v_cod_central
    );

    INSERT INTO Telefono_Mecanico (
        cod_mecanico_tel,
        telefono_mecanico
    ) VALUES (
        v_cod_personal,
        p_telefono_mecanico
    );
    DBMS_OUTPUT.PUT_LINE('Mecanico Insertado existosamente');

EXCEPTION
  WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('no se encontro un valor: ' || SQLERRM);
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('ya existe ese codigo de mecanico: ');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('ERROR AL INSERTAR MECANICO' || SQLERRM);
COMMIT;
END insertarMecanico;
/



-------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------                 Insertar Supervisor                                         ---------------------
-------------------------------------------------------------------------------------------------------------------------------------------------



CREATE OR REPLACE PROCEDURE insertarSupervisor (
    p_nombre IN Personal.nombre%TYPE,
    p_apellido IN Personal.apellido%TYPE,
    p_cedula IN Personal.cedula%TYPE,
    p_fecha_nacimiento IN Personal.fecha_nacimiento%TYPE,
    p_sexo IN Personal.sexo%TYPE,
    p_cod_horario_personal IN Personal.cod_horario_personal%TYPE,
    p_telefono_supervisor IN Telefono_Supervisor.telefono_supervisor%TYPE
) IS
  v_cod_personal Personal.cod_personal%TYPE;
BEGIN

    INSERT INTO Personal (
        cod_personal,
        nombre,
        apellido,
        cedula,
        fecha_nacimiento,
        sexo,
        cod_horario_personal
    ) VALUES (
        cod_personal_seq.NEXTVAL,
        p_nombre,
        p_apellido,
        p_cedula,
        p_fecha_nacimiento,
        p_sexo,
        p_cod_horario_personal
    ) RETURNING cod_personal INTO v_cod_personal;

    INSERT INTO Supervisor (
        cod_supervisor
    ) VALUES (
        v_cod_personal
    );

    INSERT INTO Telefono_Supervisor(
      cod_supervisor_tel,
      telefono_supervisor
    ) VALUES (
      v_cod_personal,
      p_telefono_supervisor
    );
    DBMS_OUTPUT.PUT_LINE('Supervisor Insertado existosamente');

EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('ya existe ese codigo de supervisor');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('ERROR AL INSERTAR SUPREVISOR' || SQLERRM);
COMMIT;
END insertarSupervisor;
/

-------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------                 Insertar Farmacia                                         -----------------------
-------------------------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE insertarFarmacia(
  p_ruc IN Farmacia.ruc%TYPE,
  p_nombre IN Farmacia.nombre%TYPE,
  p_correo IN Farmacia.correo%TYPE,
  p_longitud_farmacia IN Farmacia.longitud_farmacia%TYPE,
  p_latitud_farmacia IN Farmacia.latitud_farmacia%TYPE,
  p_telefono_farmacia IN Farmacia_Telefono.telefono_farmacia%TYPE
) IS
  v_cod_farmacia Farmacia.cod_farmacia%TYPE;
BEGIN
  INSERT INTO Farmacia(
    cod_farmacia,
    ruc,
    nombre,
    correo,
    longitud_farmacia,
    latitud_farmacia
  ) VALUES (
    cod_farmacia_seq.NEXTVAL,
    p_ruc,
    p_nombre,
    p_correo,
    p_longitud_farmacia,
    p_latitud_farmacia
  ) RETURNING cod_farmacia INTO v_cod_farmacia;

  INSERT INTO Farmacia_Telefono(
    telefono_farmacia,
    cod_farmacia_tel
  ) VALUES (
    p_telefono_farmacia,
    v_cod_farmacia
  );
    DBMS_OUTPUT.PUT_LINE('Farmacia Insertada existosamente');
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('ya existe ese codigo de farmacia');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('ERROR AL INSERTAR FARMACIA');
COMMIT;
END insertarFarmacia;
/

-------------------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------                 Insertar Dron                                         -------------------------
-------------------------------------------------------------------------------------------------------------------------------------------------


CREATE OR REPLACE PROCEDURE insertarDron(
    p_marca IN Dron.marca%TYPE,
    p_modelo IN Dron.modelo%TYPE,
    p_fecha_fabricacion IN Dron.fecha_fabricacion%TYPE,
    p_disponibilidad IN Dron.disponibilidad%TYPE,
    p_capacidad_carga IN Dron.capacidad_carga%TYPE,
    p_velocidad_promedio IN Dron.velocidad_promedio%TYPE
) AS
BEGIN
    INSERT INTO Dron(
        cod_dron,
        marca,
        modelo,
        fecha_fabricacion,
        disponibilidad,
        capacidad_carga,
        velocidad_promedio
    ) VALUES (
        cod_dron_seq.NEXTVAL,
        p_marca,
        p_modelo,
        p_fecha_fabricacion,
        p_disponibilidad,
        p_capacidad_carga,
        p_velocidad_promedio
    );

    DBMS_OUTPUT.PUT_LINE('Dron Insertado existosamente');

EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('ya existe ese codigo de dron');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('ERROR AL INSERTAR DRON');
COMMIT;
END insertarDron;
/

------------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------                      Insertar un envio                                         ------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE InsertarEnvio(
    p_peso IN Envio.peso%TYPE,
    p_latitud_final IN Envio.latitud_final %TYPE, --latitud final de la entrega
    p_longitud_final IN Envio.longitud_final %TYPE,-- longitud final de la entrega
    p_cod_farmacia_envio IN Farmacia.cod_farmacia%TYPE,
    p_cod_supervisor_envio IN Supervisor.cod_supervisor%TYPE,
    p_cod_dron_envio IN Dron.cod_dron%TYPE
) IS
    v_latitud_incial Farmacia.latitud_farmacia%TYPE;
    v_longitud_incial Farmacia.longitud_farmacia%TYPE;
    v_distancia Envio.distancia%TYPE;
    v_precio Envio.precio%TYPE;
BEGIN
    SELECT
      latitud_farmacia,
      longitud_farmacia
    INTO
      v_latitud_incial,
      v_longitud_incial
    FROM Farmacia
    WHERE cod_farmacia = p_cod_farmacia_envio;

    v_distancia := calcularDistancia(
      v_latitud_incial,
      v_longitud_incial,
      p_latitud_final,
      p_longitud_final
    );

    v_precio := calcularPrecio(
      v_distancia
    );
    
    INSERT INTO Envio (
        cod_envio,
        precio,
        distancia,
        peso,
        latitud_final,
        longitud_final,
        cod_farmacia_envio,
        cod_supervisor_envio,
        cod_dron_envio
    ) VALUES (
        cod_envio_seq.NEXTVAL,
        v_precio,
        v_distancia,
        p_peso,
        p_latitud_final,  
        p_longitud_final,
        p_cod_farmacia_envio,
        p_cod_supervisor_envio,
        p_cod_dron_envio
    );
    DBMS_OUTPUT.PUT_LINE('envio Insertado existosamente');

EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('ya existe ese codigo de envio');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('ERROR AL INSERTAR ENVIO' || SQLERRM);
COMMIT;
END InsertarEnvio;
/

------------------------------------------------------------------------------------------------------------------------------------------------
----------------------                      Insertar cuando el dron llega a una farmacia                                         ---------------
------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE llegaFarmacia (
    p_cod_envio IN Envio.cod_envio%TYPE
) IS
BEGIN
    UPDATE Envio
    SET fecha_envio = SYSDATE
    WHERE cod_envio = p_cod_envio;

    DBMS_OUTPUT.PUT_LINE('Fecha de llegada a la farmacia actualizada exitosamente');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se encontró un envío con el código: ' || p_cod_envio);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error al actualizar la fecha de envío.');
COMMIT;
END llegaFarmacia;
/


------------------------------------------------------------------------------------------------------------------------------------------------
----------------                      Insertar cuando el dron entrega el pedido al cliente                                         -------------
------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE entregaPedido(
  p_cod_envio IN Envio.cod_envio%TYPE
) IS
BEGIN
  UPDATE Envio
  SET fecha_entrega = SYSDATE
  WHERE cod_envio = p_cod_envio;

  DBMS_OUTPUT.PUT_LINE('Fecha de entrega al cliente actualizada exitosamente');

EXCEPTION
  WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('No se encontro un envio con el codigo: ' || p_cod_envio);
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error al actualizar la fecha de envio.' );
COMMIT;
END entregaPedido;
/

------------------------------------------------------------------------------------------------------------------------------------------------
----------------                      Insertar cuando el dron sale de una central                                         -------------
------------------------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE expedirDron(
  p_dron Dron.cod_dron%TYPE,
  p_central Central.cod_central%TYPE
) IS
v_fecha_salida_central ExpideDronCentral.fecha_salida_central%TYPE;
BEGIN
v_fecha_salida_central := SYSDATE;
INSERT INTO ExpideDronCentral (
  dron,
  central,
  fecha_salida_central
) VALUES (
  p_dron,
  p_central,
  v_fecha_salida_central
);
    DBMS_OUTPUT.PUT_LINE('registro de salida de dron de la central '||p_central||' insertado correctamente');

EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('ya existe ese codigo de ExpidedronCentral');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('ERROR AL INSERTAR EN EXPIDE_DRON_CENTRAL');
COMMIT;
END expedirDron;
/

------------------------------------------------------------------------------------------------------------------------------------------------
----------------                      Insertar cuando el dron llega a una central                                         -------------
------------------------------------------------------------------------------------------------------------------------------------------------
CREATE or REPLACE PROCEDURE recibirDron(
  p_dron Dron.cod_dron%TYPE,
  p_central Central.cod_central%TYPE
) IS
v_fecha_llegada_central RecibeDronCentral.fecha_llegada_central%TYPE;
BEGIN
v_fecha_llegada_central := SYSDATE;
INSERT INTO RecibeDronCentral (
  dron,
  central,
  fecha_llegada_central
) VALUES (
  p_dron,
  p_central,
  v_fecha_llegada_central
);
    DBMS_OUTPUT.PUT_LINE('registro de llegada de dron de la central '||p_central||' insertado correctamente');

EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('ya existe ese codigo de RecibeDronCentral');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('ERROR AL INSERTAR EN RECIBE_DRON_CENTRAL');
COMMIT;
END recibirDron;
/

------------------------------------------------------------------------------------------------------------------------------------------------
----------------                      Insertar para controlar envios                                         -------------
------------------------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE actualizarControlEnvios AS
  CURSOR c_enviosPromedios IS
    SELECT
      cod_farmacia_envio as cod_farmacia,
      AVG(precio) as precio_promedio,
      AVG(distancia) as distancia_promedio,
      AVG(peso) as peso_promedio,
      SUM(precio) as suma_precio,
      SUM(distancia) as suma_distancia,
      SUM(peso) as suma_peso
    FROM Envio
    GROUP BY cod_farmacia_envio;
BEGIN
  FOR r_enviosPromedio IN c_enviosPromedios LOOP
    UPDATE ControlEnvio
    SET
      precio_promedio = r_enviosPromedio.precio_promedio,
      distancia_promedio = r_enviosPromedio.distancia_promedio,
      peso_promedio = r_enviosPromedio.peso_promedio,
      suma_precio = r_enviosPromedio.suma_precio,
      suma_distancia = r_enviosPromedio.suma_distancia,
      suma_peso = r_enviosPromedio.suma_peso
    WHERE cod_farmacia_ctrl = r_enviosPromedio.cod_farmacia;

  END LOOP;
      DBMS_OUTPUT.PUT_LINE('datos de envio por farmacia actualizados con exito');
EXCEPTION
 WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('ERROR, NO SE ENCONTRÓ INFORMACIÓN');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('ERROR AL INSERTAR EN RECIBE_DRON_CENTRAL');
COMMIT;
END actualizarControlEnvios;
/
