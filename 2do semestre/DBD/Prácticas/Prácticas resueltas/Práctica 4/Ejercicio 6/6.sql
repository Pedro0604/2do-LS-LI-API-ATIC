(
    SELECT t.nombre as nomMax,
        especialidad as espMax,
        COUNT(*) as cantReparaciones
    FROM Tecnico t
        INNER JOIN Reparacion r ON r.codTec = t.codTec
    GROUP BY t.codTec,
        t.nombre,
        especialidad
    HAVING COUNT(*) >= ALL(
            SELECT COUNT(*)
            FROM Tecnico t
                INNER JOIN Reparacion r ON r.codTec = t.codTec
            GROUP BY t.codTec
        )
)
UNION
(
    SELECT t.nombre as nomMin,
        especialidad as espMin,
        COUNT(*) as cantReparaciones
    FROM Tecnico t
        INNER JOIN Reparacion r ON r.codTec = t.codTec
    GROUP BY t.codTec,
        t.nombre,
        especialidad
    HAVING COUNT(*) <= ALL(
            SELECT COUNT(*)
            FROM Tecnico t
                INNER JOIN Reparacion r ON r.codTec = t.codTec
            GROUP BY t.codTec
        )
)