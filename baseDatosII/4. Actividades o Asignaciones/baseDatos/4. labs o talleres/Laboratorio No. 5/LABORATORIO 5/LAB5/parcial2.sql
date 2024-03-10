
/*
Escribir un bloque anonimo PLSQL que permita rellenar la tabla AVION con los 
datos del Modelo de IBERIA A320-205. El avión dispone de 3 pisos de asientos,
numerados de 1 a 3. En el piso 1 habrá que asignar desde el asiento 1 al asiento 216
a la clase turista. En el piso 2, habrá que asignar de asiento 217 a 236 a la clase
ejecutiva y del asiento 237 al 277 a la primera clase. En el piso 3 se asignan
los asientos de la 278 al 288 ala tripulación. Inicialmente
Todos los asientos están disponibles

Para las clases, 1='Triupulacion', 2='Clase ejecutiva', 3='Primera clase' y 4='Clase
Turista'. Para disponible (S=si y n=no)

La relacion de base de datos tiene la siguiente estructura
AVION(piso number, asiento number, clase number, disponible char)
La primary key(piso, asiento, clase)



piso 1: 1-216 turista
piso 2: 217-236 ejecutiva
piso 3: 237-277 primera clase
piso 4: 278-288 tripulacion


*/

DECLARE
  v_asiento Avion.asiento%TYPE;
  v_disponible Avion.disponible%TYPE;
  
BEGIN
    v_disponible := 'S';

    --tripulacion
    FOR v_asiento IN 1..3 LOOP

        FOR v_asiento IN 278..288 LOOP
        INSERT INTO AVION (piso, asiento, clase, disponible)
            VALUES (3, v_asiento, 1, v_disponible);
        END LOOP;

        --ejecutiva
        FOR v_asiento IN 217..236 LOOP
        INSERT INTO AVION (piso, asiento, clase, disponible)
            VALUES (2, v_asiento, 2, v_disponible);
        END LOOP;

        --primera clase
        FOR v_asiento IN 237..277 LOOP
        INSERT INTO AVION (piso, asiento, clase, disponible)
            VALUES (3, v_asiento, 3, v_disponible);
        END LOOP;

        --Turista
        FOR asiento IN 1..216 LOOP
        INSERT INTO AVION (piso, asiento, clase, disponible)
            VALUES (1, v_asiento, 4, v_disponible);
        END LOOP;

  END FOR;

  COMMIT;

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
    WHEN OTHERS THEN
        ROLLBACK;

END;
/

SELECT * FROM AVION;


-----------------------------------------------------
--ejercicio 2

CREATE TABLE Colaboradores (
    id_colaborador NUMBER NOT NULL PRIMARY KEY,
    cedula VARCHAR2(15),
    nombre VARCHAR2(15),
    apellido VARCHAR2(15),
    salario_mensual NUMBER(15, 2),
    fecha_ingreso DATE,
    status CHAR(1) CHECK (status IN ('A', 'E', 'V'))
);

CREATE TABLE SalarioQuincenal (
    id_transaccion NUMBER NOT NULL PRIMARY KEY,
    id_colaborador NUMBER,
    salario_quincenal NUMBER(15, 2),
    seguro_social NUMBER(15, 2),
    seguro_educativo NUMBER(15, 2), 
    salario_neto_quincenal NUMBER(12, 2),
    fecha_de_pago DATE,
    FOREIGN KEY (id_colaborador) REFERENCES Colaboradores(id_colaborador)
);


CREATE OR REPLACE PROCEDURE CapturarColaborador (
    p_id_colaborador NUMBER,
    p_cedula VARCHAR2,
    p_nombre VARCHAR2,
    p_apellido VARCHAR2,
    p_salario_mensual NUMBER,
    p_fecha_ingreso DATE,
    p_status CHAR
) IS
BEGIN
    INSERT INTO Colaboradores (
        id_colaborador, cedula, nombre, apellido,
        salario_mensual, fecha_ingreso, status
    ) VALUES (
        p_id_colaborador, p_cedula, p_nombre, p_apellido,
        p_salario_mensual, p_fecha_ingreso, p_status
    );
    
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Colaborador capturado exitosamente.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error al capturar el colaborador.');
END CapturarColaborador;
/


--Invocacion
BEGIN
    CapturarColaborador(1, '123456789', 'Juan', 'Perez', 5000.00, SYSDATE, 'A');
END;
/


CREATE OR REPLACE PROCEDURE CalcularSalarioQuincenal (
    p_id_colaborador NUMBER,
    p_fecha_de_pago DATE
) IS
    v_salario_mensual NUMBER;
    v_seguro_social NUMBER;
    v_seguro_educativo NUMBER;
    v_salario_neto_quincenal NUMBER;
BEGIN
    -- Obtener información del colaborador
    SELECT salario_mensual
    INTO v_salario_mensual
    FROM Colaboradores
    WHERE id_colaborador = p_id_colaborador;

    -- Verificar si el colaborador está activo
    IF v_salario_mensual IS NULL THEN
        RAISE_APPLICATION_ERROR(-20001, 'Colaborador no encontrado.');
    END IF;

    -- Verificar si el colaborador está activo
    SELECT COUNT(*)
    INTO v_status
    FROM Colaboradores
    WHERE id_colaborador = p_id_colaborador AND status = 'A';

    IF v_status = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'El colaborador no está activo.');
    END IF;

    -- Calcular deducciones y salario neto
    v_seguro_social := 0.0975 * v_salario_mensual;
    v_seguro_educativo := 0.0125 * v_salario_mensual;
    v_salario_neto_quincenal := v_salario_mensual - v_seguro_social - v_seguro_educativo;

    -- Insertar datos en la tabla de salario quincenal
    INSERT INTO SalarioQuincenal (
        id_transaccion, id_colaborador, salario_quincenal,
        seguro_social, seguro_educativo, salario_neto_quincenal, fecha_de_pago
    ) VALUES (
        SEQ_SALARIO_QUINCENAL.NEXTVAL, p_id_colaborador, v_salario_mensual,
        v_seguro_social, v_seguro_educativo, v_salario_neto_quincenal, p_fecha_de_pago
    );

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Salario quincenal calculado exitosamente.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error al calcular el salario quincenal.');
END CalcularSalarioQuincenal;
/



--Invocacion
BEGIN
    CalcularSalarioQuincenal(1, SYSDATE);
END;
/
