SELECT p.DNI,
    p.apellido,
    p.nombre,
    a.legajo
FROM Persona p
    INNER JOIN Alumno a ON a.DNI = p.DNI
    INNER JOIN Alumno_Curso ac ON ac.DNI = a.DNI
    INNER JOIN Curso c ON c.codigoCurso = ac.codigoCurso
WHERE c.nombre LIKE "%BD%"
    AND ac.anio = 2018
EXCEPT (
        SELECT p.DNI,
            p.apellido,
            p.nombre,
            a.legajo
        FROM Persona p
            INNER JOIN Alumno a ON a.DNI = p.DNI
            INNER JOIN Alumno_Curso ac ON ac.DNI = a.DNI
            INNER JOIN Curso c ON c.codigoCurso = ac.codigoCurso
        WHERE ac.anio = 2019
    ) -------------------
    --------------------
    --------------------
SELECT p.DNI,
    p.apellido,
    p.nombre,
    a.legajo
FROM Persona p
    INNER JOIN Alumno a ON a.DNI = p.DNI
    INNER JOIN Alumno_Curso ac ON ac.DNI = a.DNI
    INNER JOIN Curso c ON c.codigoCurso = ac.codigoCurso
WHERE c.nombre LIKE "%BD%"
    AND ac.anio = 2018
    AND p.DNI NOT IN(
        SELECT p.DNI
        FROM Persona p
            INNER JOIN Alumno a ON a.DNI = p.DNI
            INNER JOIN Alumno_Curso ac ON ac.DNI = a.DNI
            INNER JOIN Curso c ON c.codigoCurso = ac.codigoCurso
        WHERE ac.anio = 2019
    ) -------------------
    --------------------
    --------------------
SELECT p.DNI,
    p.apellido,
    p.nombre,
    a.legajo
FROM Persona p
    INNER JOIN Alumno a ON a.DNI = p.DNI
    INNER JOIN Alumno_Curso ac ON ac.DNI = a.DNI
    INNER JOIN Curso c ON c.codigoCurso = ac.codigoCurso
WHERE c.nombre LIKE "%BD%"
    AND ac.anio = 2018
    AND NOT EXISTS(
        SELECT *
        FROM Alumno_Curso ac
        WHERE ac.DNI = a.DNI
            AND ac.anio = 2019
    )