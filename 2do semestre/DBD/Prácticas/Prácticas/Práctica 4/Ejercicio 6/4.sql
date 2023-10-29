SELECT DISTINCT t.nombre,
    especialidad
FROM Tecnico t
    INNER JOIN Reparacion r ON r.codTec = t.codTec
WHERE r.fecha BETWEEN '2018-1-1' AND '2019-1-1'
    AND NOT EXISTS(
        SELECT *
        FROM Reparacion r2
        WHERE r2.codTec = t.codTec
            AND r2.fecha NOT BETWEEN '2018-1-1' AND '2019-1-1'
    )