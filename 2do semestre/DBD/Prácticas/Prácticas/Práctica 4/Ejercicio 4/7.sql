(
    SELECT c.nombre as nom_max,
        c.descripcion as desc_max
    FROM Curso c
        INNER JOIN Alumno_Curso ac ON ac.codigoCurso = c.codigoCurso
    WHERE ac.anio = 2019
    GROUP BY c.codigoCurso,
        c.nombre,
        c.descripcion
    HAVING COUNT(*) >= ALL(
            SELECT COUNT(*)
            FROM Alumno_Curso ac
            WHERE ac.anio = 2019
            GROUP BY ac.codigoCurso
        )
)
UNION
(
    SELECT c.nombre as nom_min,
        c.descripcion as desc_min
    FROM Curso c
        INNER JOIN Alumno_Curso ac ON ac.codigoCurso = c.codigoCurso
    WHERE ac.anio = 2019
    GROUP BY c.codigoCurso,
        c.nombre,
        c.descripcion
    HAVING COUNT(*) <= ALL(
            SELECT COUNT(*)
            FROM Alumno_Curso ac
            WHERE ac.anio = 2019
            GROUP BY ac.codigoCurso
        )
)