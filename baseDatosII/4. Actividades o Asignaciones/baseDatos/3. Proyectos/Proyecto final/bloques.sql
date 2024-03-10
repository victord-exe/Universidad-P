/*
integrantes:
Victor Rodriguez el de cedula 20
Alejandro Mosquera
Diego Navarro
Eladio Gonzales
Jose Delgado
*/

SET SERVEROUTPUT ON;
set linesize 3000;
-------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------                 Bloques Anonimos                                         -----------------------
-------------------------------------------------------------------------------------------------------------------------------------------------


-------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------                 Bloque para insertar horarios                                         -----------------------
-------------------------------------------------------------------------------------------------------------------------------------------------
DECLARE
    v_cod_horario Horarios.cod_horario%TYPE;
    v_hora_inicio Horarios.hora_inicio%TYPE;
    v_hora_final Horarios.hora_final%TYPE;
    v_tipo_turno Horarios.tipo_turno%TYPE;
BEGIN
    v_cod_horario := 'H01';
    v_hora_inicio := TO_DATE('5:00', 'HH24:MI:SS');
    v_hora_final := TO_DATE('13:00', 'HH24:MI:SS');
    v_tipo_turno := 'Matutino';

    insertarHorario(v_cod_horario, v_hora_inicio, v_hora_final, v_tipo_turno);
    
    v_cod_horario := 'H02';
    v_hora_inicio := TO_DATE('13:00', 'HH24:MI:SS');
    v_hora_final := TO_DATE('21:00', 'HH24:MI:SS');
    v_tipo_turno := 'Vespertino';

    insertarHorario(v_cod_horario, v_hora_inicio, v_hora_final, v_tipo_turno);

        
    v_cod_horario := 'H03';
    v_hora_inicio := TO_DATE('21:00', 'HH24:MI:SS');
    v_hora_final := TO_DATE('5:00', 'HH24:MI:SS');
    v_tipo_turno := 'Nocturno';

    insertarHorario(v_cod_horario, v_hora_inicio, v_hora_final, v_tipo_turno);
    
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error en el bloque anonimo al insertar el horario: PK EXISTENTE');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error en el bloque anonimo al insertar el horario.' || SQLERRM);
END;
/

--------------------------------------------------------------------------------------------------------------------
-----------------------------------                 Bloque para insertar Central                                         -----------------------
-------------------------------------------------------------------------------------------------------------------------------------------------

DECLARE
    v_nombre Central.nombre%TYPE;
    v_latitud_central Central.latitud_central%TYPE;
    v_longitud_central Central.longitud_central%TYPE;
BEGIN

-- codigo central 1
    v_nombre := 'Obarrio';
    v_latitud_central := '8.987362';
    v_longitud_central := '-79.520006';

    insertarCentral(v_nombre, v_latitud_central, v_longitud_central);

-- codigo central 2

    v_nombre := 'Condado del Rey';
    v_latitud_central := '9.032362';
    v_longitud_central := '-79.523426';

    insertarCentral(v_nombre, v_latitud_central, v_longitud_central);

-- codigo central 3

    v_nombre := 'San fransico';
    v_latitud_central := '8.988345';
    v_longitud_central := '-79.506384';

    insertarCentral(v_nombre, v_latitud_central, v_longitud_central);

    -- codigo central 4

    v_nombre := 'El dorado';
    v_latitud_central := '9.008742';
    v_longitud_central := '79.534653';

    insertarCentral(v_nombre, v_latitud_central, v_longitud_central);


EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error en el bloque anonimo al insertar la central: PK EXISTENTE');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error en el bloque anonimo al insertar la central.' || SQLERRM);
END;
/



*/
DECLARE
    v_nombre Personal.nombre%TYPE;
    v_apellido Personal.apellido%TYPE;
    v_cedula Personal.cedula%TYPE;
    v_fecha_nacimiento Personal.fecha_nacimiento%TYPE;
    v_sexo Personal.sexo%TYPE;
    v_cod_horario_personal Personal.cod_horario_personal%TYPE;
    v_central_nombre Central.nombre%TYPE;
    v_telefono_mecanico Telefono_Mecanico.telefono_mecanico%TYPE;
BEGIN

    v_nombre := 'Ana'; -- codigo de personal 1
    v_apellido := 'Garcia';
    v_cedula := '8-888-8888';
    v_fecha_nacimiento := TO_DATE('02/03/2003','DD/MM/YYYY');
    v_sexo := 'F';
    v_cod_horario_personal := 'H01';
    v_central_nombre := 'Obarrio';
    v_telefono_mecanico := '61123456';

    insertarMecanico(v_nombre, v_apellido, v_cedula, v_fecha_nacimiento, v_sexo, v_cod_horario_personal, v_central_nombre, v_telefono_mecanico);

    v_nombre := 'Pedro';-- codigo de personal 2
    v_apellido := 'Rodríguez';
    v_cedula := '4-444-4444';
    v_fecha_nacimiento := TO_DATE('10/09/1985', 'DD/MM/YYYY');
    v_sexo := 'M';
    v_cod_horario_personal := 'H02';
    v_central_nombre := 'Condado del Rey';
    v_telefono_mecanico := '62234567';

    insertarMecanico(v_nombre, v_apellido, v_cedula, v_fecha_nacimiento, v_sexo, v_cod_horario_personal, v_central_nombre, v_telefono_mecanico);


    v_nombre := 'María';-- codigo de personal 3
    v_apellido := 'Martínez';
    v_cedula := '1-111-1111';
    v_fecha_nacimiento := TO_DATE('15/11/1998', 'DD/MM/YYYY');
    v_sexo := 'F';
    v_cod_horario_personal := 'H03';
    v_central_nombre := 'San fransico';
    v_telefono_mecanico := '63345678';

    insertarMecanico(v_nombre, v_apellido, v_cedula, v_fecha_nacimiento, v_sexo, v_cod_horario_personal, v_central_nombre, v_telefono_mecanico);


    v_nombre := 'Carlos';-- codigo de personal 4
    v_apellido := 'Pérez';
    v_cedula := '5-555-5555';
    v_fecha_nacimiento := TO_DATE('20/03/1992', 'DD/MM/YYYY');
    v_sexo := 'M';
    v_cod_horario_personal := 'H01';
    v_central_nombre := 'El dorado';
    v_telefono_mecanico := '64456789';

    insertarMecanico(v_nombre, v_apellido, v_cedula, v_fecha_nacimiento, v_sexo, v_cod_horario_personal, v_central_nombre, v_telefono_mecanico);


    v_nombre := 'Luisa';-- codigo de personal 5
    v_apellido := 'Gómez';
    v_cedula := '7-777-7777';
    v_fecha_nacimiento := TO_DATE('25/07/1989', 'DD/MM/YYYY');
    v_sexo := 'F';
    v_cod_horario_personal := 'H02';
    v_central_nombre := 'Obarrio';
    v_telefono_mecanico := '65567890';
    
    insertarMecanico(v_nombre, v_apellido, v_cedula, v_fecha_nacimiento, v_sexo, v_cod_horario_personal, v_central_nombre, v_telefono_mecanico);

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error en el bloque anonimo al insertar el mecanico: PK EXISTENTE');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error en el bloque anonimo al insertar el mecanico.' || SQLERRM);
END;
/

-------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------                 Bloque para insertar Supervisor                                         -----------------------
-------------------------------------------------------------------------------------------------------------------------------------------------


DECLARE
    v_nombre Personal.nombre%TYPE;
    v_apellido Personal.apellido%TYPE;
    v_cedula Personal.cedula%TYPE;
    v_fecha_nacimiento Personal.fecha_nacimiento%TYPE;
    v_sexo Personal.sexo%TYPE;
    v_cod_horario_personal Personal.cod_horario_personal%TYPE;
    v_telefono_supervisor Telefono_Supervisor.telefono_supervisor%TYPE;
BEGIN
    v_nombre := 'Jorge';-- codigo de personal 6
    v_apellido := 'Castro';
    v_cedula := '8-972-1616';
    v_fecha_nacimiento := TO_DATE('12/06/1980', 'DD/MM/YYYY');
    v_sexo := 'M';
    v_cod_horario_personal := 'H02';
    v_telefono_supervisor := '68563478';
    insertarSupervisor(v_nombre, v_apellido, v_cedula, v_fecha_nacimiento, v_sexo, v_cod_horario_personal, v_telefono_supervisor);

    v_nombre := 'Sofía';-- codigo de personal 7
    v_apellido := 'López';
    v_cedula := '8-972-1617';
    v_fecha_nacimiento := TO_DATE('23/09/1975', 'DD/MM/YYYY');
    v_sexo := 'F';
    v_cod_horario_personal := 'H03';
    v_telefono_supervisor := '68563479';
    insertarSupervisor(v_nombre, v_apellido, v_cedula, v_fecha_nacimiento, v_sexo, v_cod_horario_personal, v_telefono_supervisor);

    v_nombre := 'Eduardo';-- codigo de personal 8
    v_apellido := 'Gutiérrez';
    v_cedula := '8-972-1618';
    v_fecha_nacimiento := TO_DATE('15/02/1988', 'DD/MM/YYYY');
    v_sexo := 'M';
    v_cod_horario_personal := 'H01';
    v_telefono_supervisor := '68563480';
    insertarSupervisor(v_nombre, v_apellido, v_cedula, v_fecha_nacimiento, v_sexo, v_cod_horario_personal, v_telefono_supervisor);
    
    v_nombre := 'Laura';-- codigo de personal 9
    v_apellido := 'Pérez';
    v_cedula := '8-972-1619';
    v_fecha_nacimiento := TO_DATE('20/10/1990', 'DD/MM/YYYY');
    v_sexo := 'F';
    v_cod_horario_personal := 'H02';
    v_telefono_supervisor := '68563481';

    insertarSupervisor(v_nombre, v_apellido, v_cedula, v_fecha_nacimiento, v_sexo, v_cod_horario_personal, v_telefono_supervisor);
      
    v_nombre := 'Manuel';-- codigo de personal 10
    v_apellido := 'Ramírez';
    v_cedula := '8-972-1620';
    v_fecha_nacimiento := TO_DATE('05/03/1987', 'DD/MM/YYYY');
    v_sexo := 'M';
    v_cod_horario_personal := 'H03';
    v_telefono_supervisor := '68563482';

    insertarSupervisor(v_nombre, v_apellido, v_cedula, v_fecha_nacimiento, v_sexo, v_cod_horario_personal, v_telefono_supervisor);
    EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error en el bloque anonimo al insertar el supervisor: PK EXISTENTE');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error en el bloque anonimo al insertar el supervisor.' || SQLERRM);
END;
/

-------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------                 Bloque para insertar Farmacia                                         -----------------------
-------------------------------------------------------------------------------------------------------------------------------------------------

DECLARE
    v_ruc Farmacia.ruc%TYPE;
    v_nombre Farmacia.nombre%TYPE;
    v_correo Farmacia.correo%TYPE;
    v_longitud_farmacia Farmacia.longitud_farmacia%TYPE;
    v_latitud_farmacia Farmacia.latitud_farmacia%TYPE;
    v_telefono_farmacia Farmacia_Telefono.telefono_farmacia%TYPE;
BEGIN
     v_ruc := '123-456-789012-3';
    v_nombre := 'Farmacias Arrocha';
    v_correo := 'farrochaobarrio@arrocha.com'; --  <------- esta farmacia es de obarrio con codigo 1
    v_latitud_farmacia := 8.986067;
    v_longitud_farmacia := -79.517493;
    v_telefono_farmacia := '360-4391';

    insertarFarmacia(v_ruc, v_nombre, v_correo, v_longitud_farmacia, v_latitud_farmacia, v_telefono_farmacia);

     v_ruc := '123-436-742312-3';
    v_nombre := 'Farma Value';
    v_correo := 'farmavaluecangrejo@farmavalue.com'; --  <------- esta farmacia es del cangrejo con codigo 2
    v_latitud_farmacia := 8.989840;
    v_longitud_farmacia := -79.524381;
    v_telefono_farmacia := '302-3830';

    insertarFarmacia(v_ruc, v_nombre, v_correo, v_longitud_farmacia, v_latitud_farmacia, v_telefono_farmacia);

    v_ruc := '411-191-912411-1';
    v_nombre := 'Metro Plus';
    v_correo := 'metroplussf@metrops.com';--  <------- esta farmacia es de san fransisco con codigo 3
    v_latitud_farmacia := 8.989556;
    v_longitud_farmacia := -79.504941;
    v_telefono_farmacia := '226-6527';

    insertarFarmacia(v_ruc, v_nombre, v_correo, v_longitud_farmacia, v_latitud_farmacia, v_telefono_farmacia);

     v_ruc := '793-486-769312-3';
    v_nombre := 'Farmacias El Javillo';
    v_correo := 'eljavilloviaisrrael@javillo.com';--  <------- esta farmacia es de via isrrael con codigo 4
    v_latitud_farmacia := 8.987670;
    v_longitud_farmacia := -79.505263;
    v_telefono_farmacia := '301-4019';

    insertarFarmacia(v_ruc, v_nombre, v_correo, v_longitud_farmacia, v_latitud_farmacia, v_telefono_farmacia);

    v_ruc := '793-486-769312-3';
    v_nombre := 'Farmaias El Javillo';
    v_correo := 'eljavilloviaporras@javillo.com';--  <------- esta farmacia es de via porras con codigo 5
    v_latitud_farmacia := 8.996377;
    v_longitud_farmacia := -79.510362;
    v_telefono_farmacia := '301-4087';

    insertarFarmacia(v_ruc, v_nombre, v_correo, v_longitud_farmacia, v_latitud_farmacia, v_telefono_farmacia);

    v_ruc := '411-191-912411-1';
    v_nombre := 'Metro Plus';
    v_correo := 'metroplusdorado@metrop.com';--  <------- esta farmacia es del dorado con codigo 6
    v_latitud_farmacia := 9.006436;
    v_longitud_farmacia := -79.5339301;
    v_telefono_farmacia := '395-3491';

    insertarFarmacia(v_ruc, v_nombre, v_correo, v_longitud_farmacia, v_latitud_farmacia, v_telefono_farmacia);

    v_ruc := '123-456-789012-3';
    v_nombre := 'Farmacias Arrocha';
    v_correo := 'arrocha5mayo@metrop.com';--  <------- esta farmacia es de la 5 de mayo con codigo 7
    v_latitud_farmacia := 8.959030;
    v_longitud_farmacia := -79.541246;
    v_telefono_farmacia := '395-3433';
        

    insertarFarmacia(v_ruc, v_nombre, v_correo, v_longitud_farmacia, v_latitud_farmacia, v_telefono_farmacia);

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error en el bloque anonimo al insertar la farmacia: PK EXISTENTE');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error en el bloque anonimo al insertar la farmacia.' || SQLERRM);
END;
/

-------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------                 Bloque para insertar Dron                                         -----------------------
-------------------------------------------------------------------------------------------------------------------------------------------------

DECLARE
    v_marca Dron.marca%TYPE;
    v_modelo Dron.modelo%TYPE;
    v_fecha_fabricacion Dron.fecha_fabricacion%TYPE;
    v_disponibilidad Dron.disponibilidad%TYPE;
    v_capacidad_carga Dron.capacidad_carga%TYPE;
    v_velocidad_promedio Dron.velocidad_promedio%TYPE;
BEGIN
--codigo de dron 1
    v_marca := 'DJI';
    v_modelo := 'Phantom 4 Pro';
    v_fecha_fabricacion := TO_DATE('01/01/2023', 'DD/MM/YYYY');
    v_disponibilidad := 'Y';
    v_capacidad_carga := 25;
    v_velocidad_promedio := 70;

    insertarDron(v_marca, v_modelo, v_fecha_fabricacion, v_disponibilidad, v_capacidad_carga, v_velocidad_promedio);

--codigo de dron 2

    v_marca := 'Parrot';
    v_modelo := 'Anafi';
    v_fecha_fabricacion := TO_DATE('01/01/2023', 'DD/MM/YYYY');
    v_disponibilidad := 'Y';
    v_capacidad_carga := 30;
    v_velocidad_promedio := 65;

    insertarDron(v_marca, v_modelo, v_fecha_fabricacion, v_disponibilidad, v_capacidad_carga, v_velocidad_promedio);

--codigo de dron 3

    v_marca := 'Autel Robotics';
    v_modelo := 'EVO II Pro';
    v_fecha_fabricacion := TO_DATE('02/01/2023', 'DD/MM/YYYY');
    v_disponibilidad := 'Y';
    v_capacidad_carga := 30;
    v_velocidad_promedio := 72;

    insertarDron(v_marca, v_modelo, v_fecha_fabricacion, v_disponibilidad, v_capacidad_carga, v_velocidad_promedio);

--codigo de dron 4

    v_marca := 'Yuneec';
    v_modelo := 'Typhoon H Plus';
    v_fecha_fabricacion := TO_DATE('02/01/2023', 'DD/MM/YYYY');
    v_disponibilidad := 'Y';
    v_capacidad_carga := 28;
    v_velocidad_promedio := 68;

    insertarDron(v_marca, v_modelo, v_fecha_fabricacion, v_disponibilidad, v_capacidad_carga, v_velocidad_promedio);

--codigo de dron 5

    v_marca := 'Skydio';
    v_modelo := 'X2';
    v_fecha_fabricacion := TO_DATE('02/01/2023', 'DD/MM/YYYY');
    v_disponibilidad := 'Y';
    v_capacidad_carga := 20;
    v_velocidad_promedio := 75;

    insertarDron(v_marca, v_modelo, v_fecha_fabricacion, v_disponibilidad, v_capacidad_carga, v_velocidad_promedio);

--codigo de dron 6

    v_marca := 'Ehang';
    v_modelo := 'Ghostdrone 2.0 VR';
    v_fecha_fabricacion := TO_DATE('05/01/2023', 'DD/MM/YYYY');
    v_disponibilidad := 'Y';
    v_capacidad_carga := 22;
    v_velocidad_promedio := 68;

    insertarDron(v_marca, v_modelo, v_fecha_fabricacion, v_disponibilidad, v_capacidad_carga, v_velocidad_promedio);

--codigo de dron 7

    v_marca := 'Hubsan';
    v_modelo := 'H501S X4';
    v_fecha_fabricacion := TO_DATE('05/01/2023', 'DD/MM/YYYY');
    v_disponibilidad := 'Y';
    v_capacidad_carga := 28;
    v_velocidad_promedio := 60;

    insertarDron(v_marca, v_modelo, v_fecha_fabricacion, v_disponibilidad, v_capacidad_carga, v_velocidad_promedio);

--codigo de dron 8

    v_marca := 'Walkera';
    v_modelo := 'Voyager 4';
    v_fecha_fabricacion := TO_DATE('05/01/2023', 'DD/MM/YYYY');
    v_disponibilidad := 'Y';
    v_capacidad_carga := 26;
    v_velocidad_promedio := 71;

    insertarDron(v_marca, v_modelo, v_fecha_fabricacion, v_disponibilidad, v_capacidad_carga, v_velocidad_promedio);

--codigo de dron 9

    v_marca := 'PowerVision';
    v_modelo := 'PowerEye';
    v_fecha_fabricacion := TO_DATE('06/01/2023', 'DD/MM/YYYY');
    v_disponibilidad := 'Y';
    v_capacidad_carga := 32;
    v_velocidad_promedio := 67;

    insertarDron(v_marca, v_modelo, v_fecha_fabricacion, v_disponibilidad, v_capacidad_carga, v_velocidad_promedio);

--codigo de dron 10

    v_marca := 'Holy Stone';
    v_modelo := 'HS100';
    v_fecha_fabricacion := TO_DATE('06/01/2023', 'DD/MM/YYYY');
    v_disponibilidad := 'Y';
    v_capacidad_carga := 21;
    v_velocidad_promedio := 63;

    insertarDron(v_marca, v_modelo, v_fecha_fabricacion, v_disponibilidad, v_capacidad_carga, v_velocidad_promedio);

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error al insertar el dron en el intento : PK EXISTENTE');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error en el bloque anónimo: ' || SQLERRM);
    COMMIT;
END;
/



-------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------                 Bloque para insertar envio                                         -----------------------
-------------------------------------------------------------------------------------------------------------------------------------------------

DECLARE
    v_peso Envio.peso%TYPE;
    v_latitud_final Envio.latitud_final %TYPE;
    v_longitud_final Envio.longitud_final %TYPE;
    v_cod_farmacia_envio Farmacia.cod_farmacia%TYPE;
    v_cod_supervisor_envio Supervisor.cod_supervisor%TYPE;
    v_cod_dron_envio Dron.cod_dron%TYPE;
BEGIN
--codigo de envio 1
    v_peso := 8; --kg
    v_latitud_final := 9.006621;
    v_longitud_final := -79.507535;
    v_cod_farmacia_envio := 5; --via porras
    v_cod_supervisor_envio := 10;
    v_cod_dron_envio := 1;
    InsertarEnvio(v_peso, v_latitud_final,v_longitud_final, v_cod_farmacia_envio, v_cod_supervisor_envio, v_cod_dron_envio);

    --codigo de envio 2
    v_peso := 2; --kg
    v_latitud_final := 8.994058;
    v_longitud_final := -79.512674;
    v_cod_farmacia_envio := 3; --san francisco
    v_cod_supervisor_envio := 6;
    v_cod_dron_envio := 2;
    InsertarEnvio(v_peso, v_latitud_final,v_longitud_final, v_cod_farmacia_envio, v_cod_supervisor_envio, v_cod_dron_envio);

    --codigo de envio 3
    v_peso := 20; --kg
    v_latitud_final := 8.972314;
    v_longitud_final := -79.535070;
    v_cod_farmacia_envio := 5; --via porras
    v_cod_supervisor_envio := 7;
    v_cod_dron_envio := 3;
    InsertarEnvio(v_peso, v_latitud_final,v_longitud_final, v_cod_farmacia_envio, v_cod_supervisor_envio, v_cod_dron_envio);

    --codigo de envio 4
    v_peso := 8; --kg
    v_latitud_final := 8.958054;
    v_longitud_final := -79.549735;
    v_cod_farmacia_envio := 7; -- 5 de mayo
    v_cod_supervisor_envio := 8;
    v_cod_dron_envio := 4;
    InsertarEnvio(v_peso, v_latitud_final,v_longitud_final, v_cod_farmacia_envio, v_cod_supervisor_envio, v_cod_dron_envio);

    --codigo de envio 5
    v_peso := 7; --kg
    v_latitud_final := 8.994674;
    v_longitud_final := -79.531869;
    v_cod_farmacia_envio := 2; -- el cangrejo
    v_cod_supervisor_envio := 9;
    v_cod_dron_envio := 5;
    InsertarEnvio(v_peso, v_latitud_final,v_longitud_final, v_cod_farmacia_envio, v_cod_supervisor_envio, v_cod_dron_envio);

    --codigo de envio 6
    v_peso := 15; --kg
    v_latitud_final := 9.008344;
    v_longitud_final := -79.538909;
    v_cod_farmacia_envio := 6;-- el dorado
    v_cod_supervisor_envio := 10;
    v_cod_dron_envio := 6;
    InsertarEnvio(v_peso, v_latitud_final,v_longitud_final, v_cod_farmacia_envio, v_cod_supervisor_envio, v_cod_dron_envio);

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error en el bloque anonimo al insertar el envio: PK EXISTENTE');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error en el bloque anonimo al insertar el envio.' || SQLERRM);
END;
/


-------------------------------------------------------------------------------------------------------------------------------------------------
----------------------                 Bloque para insertar cuando se expide un dron                            ----------------------
-------------------------------------------------------------------------------------------------------------------------------------------------

DECLARE
    v_dron Dron.cod_dron%TYPE;
    v_central Central.cod_central%TYPE;
BEGIN
    v_dron := 1;
    v_central := 1;
    expedirDron(
        p_dron => v_dron,
        p_central => v_central
    );

        v_dron := 2;
    v_central := 2;
    expedirDron(
        p_dron => v_dron,
        p_central => v_central
    );

        v_dron := 3;
    v_central := 3;
    expedirDron(
        p_dron => v_dron,
        p_central => v_central
    );

        v_dron := 4;
    v_central := 1;
    expedirDron(
        p_dron => v_dron,
        p_central => v_central
    );
        v_dron := 5;
    v_central := 3;
    expedirDron(
        p_dron => v_dron,
        p_central => v_central
    );

        v_dron := 6;
    v_central := 4;
    expedirDron(
        p_dron => v_dron,
        p_central => v_central
    );
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('bloque anonimo, ya existe ese codigo de ExpideDronCentral');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error en el bloque anonimo la salida de un dron de una central.');
END;
/


-------------------------------------------------------------------------------------------------------------------------------------------------
----------------------                 Bloque para insertar cuando el dron llega a una farmacia                            ----------------------
-------------------------------------------------------------------------------------------------------------------------------------------------

DECLARE
    v_fecha_envio Envio.fecha_envio%TYPE;
    v_cod_envio Envio.cod_envio%TYPE;
BEGIN
    v_cod_envio := 1;
    llegaFarmacia(
        p_cod_envio => v_cod_envio
    );
        v_cod_envio := 2;
    llegaFarmacia(
        p_cod_envio => v_cod_envio
    );
        v_cod_envio := 3;
    llegaFarmacia(
        p_cod_envio => v_cod_envio
    );
        v_cod_envio := 4;
    llegaFarmacia(
        p_cod_envio => v_cod_envio
    );
        v_cod_envio := 5;
    llegaFarmacia(
        p_cod_envio => v_cod_envio
    );
        v_cod_envio := 6;
    llegaFarmacia(
        p_cod_envio => v_cod_envio
    );
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se encontro un envio en la actualizacion');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error en el bloque anonimo al insertar cuando un dron llega a la farmacia.');
END;
/

-------------------------------------------------------------------------------------------------------------------------------------------------
----------------------                 Bloque para insertar cuando el dron entrega un pedido                            ----------------------
-------------------------------------------------------------------------------------------------------------------------------------------------

DECLARE
    v_cod_envio Envio.cod_envio%TYPE;
BEGIN
    v_cod_envio := 1;
    entregaPedido(
        p_cod_envio => v_cod_envio
    );
    v_cod_envio := 2;
    entregaPedido(
        p_cod_envio => v_cod_envio
    );
    v_cod_envio := 3;
    entregaPedido(
        p_cod_envio => v_cod_envio
    );
    v_cod_envio := 4;
    entregaPedido(
        p_cod_envio => v_cod_envio
    );
    v_cod_envio := 5;
    entregaPedido(
        p_cod_envio => v_cod_envio
    );
    v_cod_envio := 6;
    entregaPedido(
        p_cod_envio => v_cod_envio
    );
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se encontro un envio en la actualizacion');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error en el bloque anonimo al insertar la entrega de un envio.');
END;
/



-------------------------------------------------------------------------------------------------------------------------------------------------
----------------------                 Bloque para insertar cuando se recibe un dron                            ----------------------
-------------------------------------------------------------------------------------------------------------------------------------------------

DECLARE
    v_dron Dron.cod_dron%TYPE;
    v_central Central.cod_central%TYPE;
BEGIN
    v_dron := 1;
    v_central := 2;
    recibirDron(
        p_dron => v_dron,
        p_central => v_central
    );
    v_dron := 2;
    v_central := 1;
    recibirDron(
        p_dron => v_dron,
        p_central => v_central
    );
    v_dron := 3;
    v_central := 3;
    recibirDron(
        p_dron => v_dron,
        p_central => v_central
    );
    v_dron := 4;
    v_central := 3;
    recibirDron(
        p_dron => v_dron,
        p_central => v_central
    );
    v_dron := 5;
    v_central := 4;
    recibirDron(
        p_dron => v_dron,
        p_central => v_central
    );
    v_dron := 6;
    v_central := 4;
    recibirDron(
        p_dron => v_dron,
        p_central => v_central
    );
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('bloque anonimo, ya existe ese codigo de RecibeDronCentral');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error en el bloque anonimo al llegar un dron a una central.');
END;
/
---------------------------------------------------------------------
-------------------------control_envios-----------------------------
--------------------------------------------------------------------
BEGIN
actualizarControlEnvios();
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('bloque anonimo, No se encontro un registro en la tabla contrl_envio');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error en el bloque anonimo al actualizar los datos de la tabla control_envios.');
END;
/


SELECT * FROM Horarios;
SELECT * FROM Central;
SELECT * FROM Personal;
SELECT * FROM Mecanico m;
SELECT * FROM Supervisor;
SELECT * FROM Telefono_Mecanico;
SELECT * FROM Telefono_Supervisor;
SELECT f.*, t.telefono_farmacia FROM Farmacia f join Farmacia_Telefono t on f.cod_farmacia = t.cod_farmacia_tel;
--SELECT * FROM Farmacia_Telefono;
SELECT * FROM Dron;
SELECT * FROM Envio;
SELECT * FROM ExpideDronCentral;
SELECT * FROM RecibeDronCentral;
SELECT * FROM ControlMovimiento;
SELECT * FROM ControlEnvio;

