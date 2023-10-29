SELECT t.nombre,
    especialidad
FROM Tecnico t
EXCEPT(
        SELECT DISTINCT t.nombre,
            especialidad
        FROM Tecnico t
            INNER JOIN Reparacion r ON r.codTec = t.codTec
    )
ORDER BY t.nombre