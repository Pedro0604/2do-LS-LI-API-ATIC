SELECT fecha,
    t.nombre,
    precio_total
FROM Reparacion re
    INNER JOIN Tecnico t ON t.codTec = re.codTec
WHERE re.nroReparac IN(
        SELECT rr.nroReparac
        FROM Repuesto_Reparacion rr
        GROUP BY rr.nroReparac
        HAVING COUNT(*) >= 10
    ) -------------------
    -------------------
    -------------------
SELECT fecha,
    t.nombre,
    precio_total
FROM Reparacion re
    INNER JOIN Tecnico t ON t.codTec = re.codTec
WHERE re.nroReparac IN(
        SELECT rr.nroReparac
        FROM Repuesto_Reparacion rr
        GROUP BY rr.nroReparac
        HAVING COUNT(*) >= 10
    )