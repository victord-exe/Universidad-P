--tipo celular
BEGIN
  InsertarTipoTelefono('celular', 1);
  InsertarTipoTelefono('residencia', 2);
  InsertarTipoTelefono('familiar mas cercano', 3);
  InsertarTipoTelefono('conyugue', 4);
END;
/

--tipo correo
BEGIN
InsertarTipoCorreo('academico', 1);
InsertarTipoCorreo('laboral', 2);
InsertarTipoCorreo('personal', 3);
END;
/
--tipo prestamo
BEGIN
InsertarTipoPrestamo('personal', 1);
InsertarTipoPrestamo('hipoteca', 2);
InsertarTipoPrestamo('auto', 3);
InsertarTipoPrestamo('garantizado con ahorros', 4);
END;
/

DECLARE
    v_cod_sucursal Sucursal.cod_sucursal%TYPE;
    v_nombre_sucursal Sucursal.nombre_sucursal%TYPE;
    v_montoprestamo Sucursal.montoprestamo%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('ingresar codigo sucursal');
    v_cod_sucursal := &cod_sucursal;
    DBMS_OUTPUT.PUT_LINE('ingresar nombre sucursal');
    v_nombre_sucursal := &nombre_sucursal;
    DBMS_OUTPUT.PUT_LINE('ingresar monto prestamo');
    v_montoprestamo := &montoprestamo;

    BEGIN
        InsertarSucursal(
          p_cod_sucursal => v_cod_sucursal,
          p_nombre_sucursal => v_nombre_sucursal,
          p_montoprestamo => v_montoprestamo
        );

        DBMS_OUTPUT.PUT_LINE('Sucursal insertada correctamente');
        COMMIT;
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            -- de clave primaria duplicada
            DBMS_OUTPUT.PUT_LINE('La clave primaria ya existe. No se puede insertar.');
        WHEN OTHERS THEN
            -- Maneja otras excepciones
            DBMS_OUTPUT.PUT_LINE('Ocurrió un error al insertar la sucursal');
            ROLLBACK;
    END;
END;
/


-- cliente

DECLARE
    v_cedula Cliente.cedula%TYPE;
    v_nombre Cliente.nombre%TYPE;
    v_apellido Cliente.apellido%TYPE;
    v_sexo Cliente.sexo%TYPE;
    v_fecha_nacimiento Cliente.fecha_nacimiento%TYPE;
    v_email Email.email%TYPE;
    v_tipo_correo Tipo_Email.tipo_email%TYPE;
    v_telefono Telefono.telefono%TYPE;
    v_tipo_telefono Tipo_Telefono.tipo_telefono%TYPE;
    v_profesion Profesion.profesion%TYPE;
    v_sucursal_nombre Sucursal.nombre_sucursal%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('ingrese la cedula');
    v_cedula := &cedula;
    DBMS_OUTPUT.PUT_LINE('ingrese el nombre');
    v_nombre := &nombre;
    DBMS_OUTPUT.PUT_LINE('ingrese el apellido');
    v_apellido := &apellido;
    DBMS_OUTPUT.PUT_LINE('ingrese el sexo M o F');
    v_sexo := &sexo;
    DBMS_OUTPUT.PUT_LINE('ingrese la fecha de nacimiento "DD-MM-YYYY"');
    v_fecha_nacimiento := TO_DATE('&fecha_nacimiento', 'DD-MM-YYYY');
    DBMS_OUTPUT.PUT_LINE('ingrese el correo');
    v_email := &email;
    DBMS_OUTPUT.PUT_LINE('ingrese el tipo de correo');
    v_tipo_correo := &tipo_correo;
    DBMS_OUTPUT.PUT_LINE('ingrese el telefono');
    v_telefono := &telefono;
    DBMS_OUTPUT.PUT_LINE('ingrese el tipo de telefono');
    v_tipo_telefono := &tipo_telefono;
    DBMS_OUTPUT.PUT_LINE('ingrese la profesion');
    v_profesion := &profesion;
    DBMS_OUTPUT.PUT_LINE('ingrese la sucursal');
    v_sucursal_nombre := &sucursal_nombre;

    InsertarCliente(
        p_cedula => v_cedula,
        p_nombre => v_nombre,
        p_apellido => v_apellido,
        p_sexo => v_sexo,
        p_fecha_nacimiento => v_fecha_nacimiento,
        p_email => v_email,
        p_tipo_correo => v_tipo_correo,
        p_telefono => v_telefono,
        p_tipo_telefono => v_tipo_telefono,
        p_profesion => v_profesion,
        p_sucursal => v_sucursal_nombre
    );

    DBMS_OUTPUT.PUT_LINE('Cliente insertado correctamente');
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Ocurrió un error al insertar el cliente');
        ROLLBACK;
END;
/


-- prestamo

DECLARE
    v_cliente_cedula Cliente.cedula%TYPE;
    v_tipo_prestamo_id Tipo_Prestamo.tipo_prestamo%TYPE;
    v_fecha_aprobado Prestamo.fecha_aprobado%TYPE;
    v_monto_aprobado Prestamo.monto_aprobado%TYPE;
    v_tasa_interes Prestamo.tasa_interes%TYPE;
    v_letra_mensual Prestamo.letra_mensual%TYPE;
    v_monto_pagado Prestamo.monto_pagado%TYPE;
    v_fecha_pago Prestamo.fecha_pago%TYPE;
    v_nombre_sucursal Sucursal.nombre_sucursal%TYPE;
    v_usuario Prestamo.usuario%TYPE;

BEGIN
    DBMS_OUTPUT.PUT_LINE('ingrese la cedula');
    v_cliente_cedula := &cliente_cedula;
    DBMS_OUTPUT.PUT_LINE('ingrese el tipo de prestamo');
    v_tipo_prestamo_id := &tipo_prestamo_id;
    DBMS_OUTPUT.PUT_LINE('ingrese la cedula');
    v_fecha_aprobado := TO_DATE('&fecha_aprobado', 'DD-MM-YYYY');
    DBMS_OUTPUT.PUT_LINE('ingrese el monto aprobado');
    v_monto_aprobado := &monto_aprobado;
    DBMS_OUTPUT.PUT_LINE('ingrese el interes');
    v_tasa_interes := &tasa_interes;
    DBMS_OUTPUT.PUT_LINE('ingrese la letra mensual');
    v_letra_mensual := &letra_mensual;
    DBMS_OUTPUT.PUT_LINE('ingrese la fecha de pago');
    v_fecha_pago := TO_DATE('&fecha_pago', 'DD-MM-YYYY');
    DBMS_OUTPUT.PUT_LINE('ingrese el nombre de la sucursal');
    v_nombre_sucursal := '&nombre_sucursal';
    DBMS_OUTPUT.PUT_LINE('ingrese el usuario');
    v_usuario := '&usuario';

    InsertarPrestamo(
        p_cliente_cedula => v_cliente_cedula,
        p_tipo_prestamo => v_tipo_prestamo,
        p_fecha_aprobado => v_fecha_aprobado,
        p_monto_aprobado => v_monto_aprobado,
        p_tasa_interes => v_tasa_interes,
        p_letra_mensual => v_letra_mensual,
        p_fecha_pago => v_fecha_pago,
        p_nombre_sucursal => v_nombre_sucursal,
        p_usuario => v_usuario,
    );

    DBMS_OUTPUT.PUT_LINE('Préstamo insertado correctamente');
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Ocurrió un error al insertar el préstamo');
        ROLLBACK;
END;
/

-- transacpagos

DECLARE
    v_monto_pago Transacpagos.monto_pago%TYPE;
    v_estado Transacpagos.estado%TYPE;
    v_usuario Transacpagos.usuario%TYPE;
    v_nombre_sucursal Sucursal.nombre_sucursal%TYPE;
    v_cliente_cedula Cliente.cedula%TYPE;
    v_prestamo Prestamo.numero_prestamo%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('ingrese el monto pagado');
    v_monto_pago := &monto_pago;
    DBMS_OUTPUT.PUT_LINE('ingrese el usuario');
    v_usuario := '&usuario';
    DBMS_OUTPUT.PUT_LINE('ingrese el nombre de  la sucursal');
    v_nombre_sucursal := '&nombre_sucursal';
    DBMS_OUTPUT.PUT_LINE('ingrese la ceduladel cliente');
    v_cliente_cedula := &cliente_cedula;
    DBMS_OUTPUT.PUT_LINE('ingrese el numero de prestamo');
    v_prestamo := &prestamo;

    InsertarPagosRecibidos(
        p_monto_pago => v_monto_pago,
        p_usuario => v_usuario,
        p_sucursal => v_nombre_sucursal,
        p_cliente_cedula => v_cliente_cedula,
        p_prestamo => v_prestamo
    );

    DBMS_OUTPUT.PUT_LINE('Pago recibido insertado correctamente');
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- otras excepciones
        DBMS_OUTPUT.PUT_LINE('Ocurrió un error al insertar el pago recibido');
        -- para mantener la integridad de los datos
        ROLLBACK;
END;
/

BEGIN
ActualizarPagosRecibo();
END;