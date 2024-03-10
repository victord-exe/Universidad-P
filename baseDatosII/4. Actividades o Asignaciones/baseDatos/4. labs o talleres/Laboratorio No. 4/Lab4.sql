    |
/* Desarrolle un bloque anónimo que capture un numero entero y determine si este 
número es primo o no lo es, adicionalmente muestre el resultado en la línea de 
comando. */




CREATE TABLE Ahorros(
    id_cliente number not null,
    nombre NVARCHAR2(30) not null,
    apellido NVARCHAR2(30) not null,
    tipoAhorro number not null,
    descripcion NVARCHAR2(50),
    saldoAhorrado number(10, 2),
    tasaInteres number(10, 2),
    interesGanado number(10, 2),
    CONSTRAINT Ahorros_pk PRIMARY KEY(id_cliente, tipoAhorro)
);

INSERT INTO
    Ahorros(id_cliente, nombre, apellido, tipoAhorro, descripcion, saldoAhorrado, tasaInteres, interesGanado)
VALUES
    (2056, 'Juan', 'Perez', 1, 'Navidad', 500, 6, 0);
INSERT INTO
    Ahorros(idCliente, nombre, apellido, tipoAhorro, descripcion, saldoAhorrado, tasaInteres, interesGanado)
VALUES
    (2057, 'Juana', 'Díaz', 2, 'Corriente', 100, 2, 0);



DECLARE
    v_id_cliente Ahorros.id_cliente%TYPE;
    v_nombre Ahorros.nombre%TYPE;
    v_apellido Ahorros.apellido%TYPE;
    v_tipo_ahorro Ahorros.tipoAhorro%TYPE;
    v_descripcion Ahorros.descripcion%TYPE;
    v_saldo_ahorrado Ahorros.saldoAhorrado%TYPE;
    v_tasa_interes Ahorros.tasaInteres%TYPE;
    v_interes_ganado Ahorros.interesGanado%TYPE not null : =0;

BEGIN

        v_id_cliente := '&idCliente';
        v_nombre := '&nombre';
        v_apellido := '&apellido';
        v_tipo_ahorro := '&tipo_de_Ahorro';
        v_descripcion := '&descripcion';
        v_saldo_ahorrado := '&saldo';
        v_tasa_interes := '&tasa';

        INSERT INTO 
            Ahorros(id_Cliente, nombre, apellido, tipoAhorro, descripcion, saldoAhorrado, tasaInteres, interesGanado)
        VALUES
            (v_id_cliente, v_nombre, v_apellido, v_tipo_ahorro, v_descripcion, v_saldo_ahorrado, v_tasa_interes, v_interes_ganado);

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: VALORES DUPLICADOS');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR INESPERADO');
END;

--PRACTICA DEL 04/10

DECLARE

    CURSOR consulta IS
        SELECT
            *
        FROM 
            Ahorros;
           
    consulta_reg consulta%ROWTYPE;

    CREATE FUNCTION calcular_interesGanado(p_saldoAhorrado Ahorros.saldoAhorrado%TYPE, p_tasaInteres Ahorros.tasainteres)
    RETURN NUMBER IS
        v_interesGanado Ahorros.interesGanado%TYPE;
    BEGIN
        v_interesGanado := (p_saldoahorrado * p_tasainteres)/100;
    RETURN v_interesGanado;
    END calcular_interesGanado;

    CREATE FUNCTION actualizar_Tabla (v_interesGanado Ahorros.interesGanado%TYPE,
                                      v_id_Cliente Ahorros.id_Cliente%TYPE,
                                      v_tipoAhorro Ahorros.tipoAhorro%TYPE)
    RETURN NVARCHAR2 IS
    
    BEGIN
        UPDATE Ahorros SET interesGanado = v_interesGanado 
            WHERE id_cliente = v_id_cliente
            AND tipoAhorro = v_tipoAhorro;



BEGIN
    OPEN consulta;

        FETCH consulta
            INTO consulta_reg;
        WHILE consulta%FOUND LOOP
            consulta_reg.interesGanado := calcular_interesGanado(consulta_reg.saldoAhorrado, consulta_reg.tasaInteres);

            UPDATE Ahorros SET interesGanado =  consulta_reg.interesGanado
                WHERE id_cliente = consulta_reg.id_cliente AND
                    tipoAhorro = consulta_reg.tipoAhorro;

            DBMS_OUTPUT.PUT_LINE('El cliente ' || consulta_reg.id_cliente || ' ' || consulta_reg.nombre || ' ' || consulta_reg.apellido ||
                                 ' ahorro ' || consulta_reg.saldoahorrado || ' y gano ' || consulta_reg.interesganado );
            FETCH consulta INTO consulta_reg;
        end loop;
    
    CLOSE consulta;

 EXCEPTION
     WHEN no_data_found THEN
         DBMS_OUTPUT.PUT_LINE('No se encontró el cliente');
     WHEN others THEN
         DBMS_OUTPUT.PUT_LINE('Error inesperado');
--Hacen falta excepciones 
COMMIT;
END;



/* Desarrolle