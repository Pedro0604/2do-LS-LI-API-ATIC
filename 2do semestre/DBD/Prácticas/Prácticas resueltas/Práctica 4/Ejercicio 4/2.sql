SELECT pr.DNI,
    pr.matricula,
    p.apellido,
    p.nombre
FROM Profesor pr
    INNER JOIN Persona p ON p.DNI = pr.DNI
    INNER JOIN Profesor_Curso pc ON pc.DNI = pr.DNI
    INNER JOIN Curso c ON c.codigoCurso = pc.codigoCurso
WHERE c.duracion > 100
ORDER BY pr.DNI