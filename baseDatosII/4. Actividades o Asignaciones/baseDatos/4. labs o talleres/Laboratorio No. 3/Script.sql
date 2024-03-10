create user Victor identified by 123;
grant connect to victor;
grant resource to victor;
connect victor;

/* Creating tables */

create table Actores(
    id_actor number not null,
    actor varchar(25) not null,
    CONSTRAINT actor_pk primary key (id_actor)
);

create table Generos(
    genero varchar(25) not null,
    id_genero number not null,
    CONSTRAINT genero_pk primary key (id_genero)
);

create table Peliculas(
    pelicula varchar(25) not null,
    id_pelicula number not null,
    pel_id_genero number not null,
    CONSTRAINT pelicula_pk primary key (id_pelicula),
    CONSTRAINT pelicula_fk foreign key (pel_id_genero)
        references Generos(id_genero)
);

create table Peliculas_Actores(
    peliact_id_actor number not null,
    peliact_id_pelicula number not null,
    personaje varchar(25),
    papel varchar(25),
    CONSTRAINT peliculas_actores_actor_fk foreign key (peliact_id_actor)
        REFERENCES Actores(id_actor),
    CONSTRAINT peliculas_actores_pelicula_fk foreign key (peliact_id_pelicula)
        REFERENCES Peliculas(id_pelicula),
    CONSTRAINT peliculas_actores_pk primary key (peliact_id_actor, peliact_id_pelicula)
);

/* Inserción de datos*/

insert into Generos(id_genero, genero)
values(1, 'Ficcion');
insert into Generos(id_genero, genero)
values(2, 'Romance');

insert into Peliculas(id_pelicula, pelicula, pel_id_genero)
values(1234, 'Volver al futuro', 1);
insert into Peliculas(id_pelicula, pelicula, pel_id_genero)
values(2345, 'La boda de mi mejor amigo', 2);
insert into Peliculas(id_pelicula, pelicula, pel_id_genero)
values(4507, 'Hombres de negro 2', 1);

INSERT ALL
INTO Actores(id_actor, actor) VALUES (1, 'Michael J Fox')
INTO Actores(id_actor, actor) VALUES (2, 'Christopher Lee Thompson')
INTO Actores(id_actor, actor) VALUES (3, 'Julia Roberts')   
INTO Actores(id_actor, actor) VALUES (4, 'Dermont Mulroney')
INTO Actores(id_actor, actor) VALUES (5, 'Cameron Diaz')
INTO Actores(id_actor, actor) VALUES (6, 'Tommy Lee Jones')
INTO Actores(id_actor, actor) VALUES (7, 'Will Smith')
INTO Actores(id_actor, actor) VALUES (8, 'RIP Torn')
SELECT * FROM dual;

INSERT ALL
INTO Peliculas_Actores (peliact_id_pelicula, peliact_id_actor) VALUES (1234, 1)
INTO Peliculas_Actores (peliact_id_pelicula, peliact_id_actor) VALUES (1234, 2)
INTO Peliculas_Actores (peliact_id_pelicula, peliact_id_actor) VALUES (2345, 3)
INTO Peliculas_Actores (peliact_id_pelicula, peliact_id_actor) VALUES (2345, 4)
INTO Peliculas_Actores (peliact_id_pelicula, peliact_id_actor) VALUES (2345, 5)
INTO Peliculas_Actores (peliact_id_pelicula, peliact_id_actor) VALUES (4507, 6)
INTO Peliculas_Actores (peliact_id_pelicula, peliact_id_actor) VALUES (4507, 7)
INTO Peliculas_Actores (peliact_id_pelicula, peliact_id_actor) VALUES (4507, 8)
Select * from dual;



grant create view to victor;

/* creating views*/

create view vista_info_peliculas as
    (
    select p.pelicula, g.genero
    from Peliculas p
    inner join Generos g on p.pel_id_genero = g.id_genero
    );

select 
    vip.pelicula, vip.genero, id_pelicula
FROM
    vista_info_peliculas vip inner join Peliculas_Actores pel, Peliculas p
     on vip.id_pel = p.peliact_id_actor;

select vip.pelicula Peliculas,vip.genero genero, 
FROM peliculas p,
vista_info_peliculas vip inner join Peliculas_Actores on p.id_pelicula = pel.peliact_id_pelicula;   


--LAB 2

/* 1. Desarolle un bloque anonimo PL/SQL para la captura de la data de la base de datos del lab 1 */

    set serveroutput on


    
    
DECLARE
    --para la tabla Generos
    v_generos_nombre Generos.genero%TYPE;
    v_generos_id Generos.id_genero%TYPE NOT NULL := 1;

    --para la tabla Peliculas
    v_peliculas_id Peliculas.id_pelicula%TYPE NOT NULL := 1;
    v_peliculas_nombre Peliculas.pelicula%TYPE;

    --para la tabla actores
    v_actores_nombre Actores.actor%TYPE;
    v_actores_id Actores.id_actor%TYPE NOT NULL := 1;

    --para la tabla peliculas_actores
    v_p_a_id_actor Peliculas_Actores.peliact_id_actor%TYPE;
    v_p_a_id_pelicula Peliculas_Actores.peliact_id_pelicula%TYPE;

    v_variablecontrol INT := 1;

BEGIN
    -- Insercion de generos: 
    v_generos_nombre := 'Ficcion';
    INSERT INTO Generos (id_genero, genero) VALUES (v_generos_id, v_generos_nombre);

    v_generos_id := v_generos_id + 1;
    v_generos_nombre := 'Romance';
    INSERT INTO Generos (id_genero, genero) VALUES (v_generos_id, v_generos_nombre);


    --Insercion de peliculas
    v_generos_id := 1;
    v_peliculas_nombre := 'Volver al futuro';
    v_peliculas_id := 1234;
    INSERT INTO Peliculas (pelicula, id_pelicula, pel_id_genero) VALUES (v_peliculas_nombre, v_peliculas_id, v_generos_id);

    v_generos_id := 2;
    v_peliculas_nombre := 'La boda de mi mejor amigo';
    v_peliculas_id := 2345;
    INSERT INTO Peliculas (pelicula, id_pelicula, pel_id_genero) VALUES (v_peliculas_nombre, v_peliculas_id, v_generos_id);

    v_generos_id := 1;
    v_peliculas_nombre := 'Hombres de negro 2';
    v_peliculas_id := 4507;
    INSERT INTO Peliculas (pelicula, id_pelicula, pel_id_genero) VALUES (v_peliculas_nombre, v_peliculas_id, v_generos_id);

    --Insercion de actores
    v_actores_nombre := 'Michael J Fox';
    v_actores_id := 1;
    INSERT INTO Actores (id_actor, actor) VALUES (v_actores_id, v_actores_nombre);

    v_actores_nombre := 'Christopher Lee Thompson';
    v_actores_id := 2;
    INSERT INTO Actores (id_actor, actor) VALUES (v_actores_id, v_actores_nombre);

    v_actores_nombre := 'Julia Roberts';
    v_actores_id := 3;
    INSERT INTO Actores (id_actor, actor) VALUES (v_actores_id, v_actores_nombre);

    v_actores_nombre := 'Dermont Mulroney';
    v_actores_id := 4;
    INSERT INTO Actores (id_actor, actor) VALUES (v_actores_id, v_actores_nombre);

    v_actores_nombre := 'Cameron Diaz';
    v_actores_id := 5;
    INSERT INTO Actores (id_actor, actor) VALUES (v_actores_id, v_actores_nombre);

    v_actores_nombre := 'Tomy Lee Jones';
    v_actores_id := 6;
    INSERT INTO Actores (id_actor, actor) VALUES (v_actores_id, v_actores_nombre);

    v_actores_nombre := 'Will Smith';
    v_actores_id := 7;
    INSERT INTO Actores (id_actor, actor) VALUES (v_actores_id, v_actores_nombre);

    v_actores_nombre := 'Rip Torn';
    v_actores_id := 8;
    INSERT INTO Actores (id_actor, actor) VALUES (v_actores_id, v_actores_nombre);

    --Insercion de peliculas_actores
    v_p_a_id_actor := 1;
    v_p_a_id_pelicula := 1234;
    INSERT INTO peliculas_actores (peliact_id_actor, peliact_id_pelicula) VALUES (v_p_a_id_actor, v_p_a_id_pelicula);

    v_p_a_id_actor := 2;
    v_p_a_id_pelicula := 1234;
    INSERT INTO peliculas_actores (peliact_id_actor, peliact_id_pelicula) VALUES (v_p_a_id_actor, v_p_a_id_pelicula);

    v_p_a_id_actor := 3;
    v_p_a_id_pelicula := 2345;
    INSERT INTO peliculas_actores (peliact_id_actor, peliact_id_pelicula) VALUES (v_p_a_id_actor, v_p_a_id_pelicula);

    v_p_a_id_actor := 4;
    v_p_a_id_pelicula := 2345;
    INSERT INTO peliculas_actores (peliact_id_actor, peliact_id_pelicula) VALUES (v_p_a_id_actor, v_p_a_id_pelicula);

    v_p_a_id_actor := 5;
    v_p_a_id_pelicula := 2345;
    INSERT INTO peliculas_actores (peliact_id_actor, peliact_id_pelicula) VALUES (v_p_a_id_actor, v_p_a_id_pelicula);

    v_p_a_id_actor := 6;
    v_p_a_id_pelicula := 4507;
    INSERT INTO peliculas_actores (peliact_id_actor, peliact_id_pelicula) VALUES (v_p_a_id_actor, v_p_a_id_pelicula);

    v_p_a_id_actor := 7;
    v_p_a_id_pelicula := 4507;
    INSERT INTO peliculas_actores (peliact_id_actor, peliact_id_pelicula) VALUES (v_p_a_id_actor, v_p_a_id_pelicula);

    v_p_a_id_actor := 8;
    v_p_a_id_pelicula := 4507;
    INSERT INTO peliculas_actores (peliact_id_actor, peliact_id_pelicula) VALUES (v_p_a_id_actor, v_p_a_id_pelicula);

    EXCEPTIONS

    WHEN OTHER THEN
        DBMS_OUTPUT.PUT_LINE('ERROR INESPERADO');

END;


/*Desarrolle un bloque anónimo que capture (&captura) el nombre de una ciudad
española y mande a línea de comando el nombre del equipo que representa la ciudad. 
El ejercicio será para 3 ciudades. Utilice la estructura del CASE por la estructura de 
control IF-THEN-ELSE. No se permiten las mismas ciudades por equipo.
*/
DECLARE
    ciudad NVARCHAR2(15) := 'Valencia';
    equipo NVARCHAR2(20);
    control NUMBER := 0;
BEGIN
    WHILE control < 3 LOOP

        CASE ciudad
        WHEN 'Madrid' THEN
            equipo := 'Real Madrid';
        WHEN 'Barcelona' THEN
            equipo := 'F.C. Barcelona';
        WHEN 'Valencia' THEN
            equipo := 'O porto furbo clu';
        ELSE
            equipo := 'Ciudad no registrada';
        END CASE;

        DBMS_OUTPUT.PUT_LINE('El equipo de ' || ciudad || ' es ' || equipo);
        control := control + 1;
    END LOOP;
END;
/




/* 
Desarrolle un bloque anónimo que cargue en una relación o tabla de base de datos
llamada estudiante con el número de estudiante, cedula, nombre y calificación final. 
Luego que realice una consulta a esta tabla de estudiante para mostrar en la línea de 
comando el nombre del estudiante con la calificación final obtenida.
*/

DECLARE
    p_no_estudiante Estudiante.no_estudiante%TYPE := 123;
    p_cedula Estudiante.cedula%TYPE := '1234567890';
    p_nombre Estudiante.nombre%TYPE := 'Nombre del Estudiante';
    p_calificacion_final Estudiante.calificacionFinal%TYPE := 95;
BEGIN
    INSERT INTO Estudiante
        (no_estudiante, cedula, nombre, calificacionFinal)
    VALUES
        (p_no_estudiante, p_cedula, p_nombre, p_calificacion_final);

    SELECT nombre, calificacionFinal INTO p_nombre, p_calificacion_final
    FROM Estudiante
    WHERE no_estudiante = 123; 
    DBMS_OUTPUT.PUT_LINE(p_nombre || ' ' || p_calificacion_final);
END;
/


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

    v_id_cliente Ahorros.id_cliente%TYPE := 2056;
    v_nombre Ahorros.nombre%TYPE;
    v_apellido Ahorros.apellido%TYPE;
    v_tipo_ahorro Ahorros.tipoAhorro%TYPE := 1;
    v_saldo_ahorrado Ahorros.saldoAhorrado%TYPE := 0;
    v_tasa_interes Ahorros.tasaInteres%TYPE := 0;
    v_interes_ganado Ahorros.interesGanado%TYPE := 0;

BEGIN
    SELECT
        saldoAhorrado, tasaInteres, nombre, apellido
        
    INTO 
        v_saldo_ahorrado, v_tasa_interes, v_nombre, v_apellido
    FROM 
        Ahorros
    WHERE 
        id_cliente = v_id_cliente AND tipoAhorro = v_tipo_ahorro;
        
    v_interes_ganado := (v_saldo_ahorrado * v_tasa_interes)/100;

    UPDATE Ahorros SET interesGanado =  v_interes_ganado
    WHERE id_cliente = v_id_cliente;

    SELECT
        interesGanado
    INTO
        v_interes_ganado
    FROM
        Ahorros
    WHERE id_cliente = v_id_cliente and tipoAhorro = v_tipo_ahorro;

    DBMS_OUTPUT.PUT_LINE('El cliente ' || v_id_cliente || ' ' || v_nombre || ' ' || v_apellido || ' ahorro ' || v_saldo_ahorrado || ' y gano ' || v_interes_ganado );

EXCEPTION
    WHEN no_data_found THEN
        DBMS_OUTPUT.PUT_LINE('No se encontró el cliente');
    WHEN others THEN
        DBMS_OUTPUT.PUT_LINE('Error inesperado');
END



/* Desarrolle */
