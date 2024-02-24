SELECT p.DNI,
    p.apellido,
    p.nombre,
    SUM(c.Duracion) as cantHoras,
    AVG(c.duracion) as promedioHoras
FROM Persona p
    INNER JOIN Profesor pr ON p.DNI = pr.DNI
    INNER JOIN Profesor_Curso pc ON pc.DNI = pr.DNI
    INNER JOIN Curso c ON c.codigoCurso = pc.codigoCurso