SELECT p.DNI,
    p.apellido,
    p.nombre,
    p.genero,
    p.fecha_nacimiento
FROM Persona p
    INNER JOIN Alumno a ON a.DNI = p.DNI
    INNER JOIN Alumno_Curso ac ON ac.DNI = a.DNI
    INNER JOIN Curso c ON c.codigoCurso = ac.codigoCurso
WHERE c.nombre = "Diseño de Bases de Datos"
    AND ac.anio = 2019