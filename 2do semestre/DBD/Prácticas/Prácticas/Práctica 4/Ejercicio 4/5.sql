SELECT p.DNI,
    p.apellido,
    p.nombre,
    pr.matricula
FROM Persona p
    INNER JOIN Profesor pr ON p.DNI = pr.DNI
WHERE (
        SELECT COUNT(*)
        FROM Titulo_Profesor tp
        WHERE tp.DNI = pr.DNI
    ) > 3
ORDER BY p.apellido,
    p.nombre