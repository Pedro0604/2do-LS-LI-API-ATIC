(
    SELECT r.nombre,
        stock,
        COUNT(DISTINCT re.codTec) as cantTecnicos
    FROM Repuesto r
        INNER JOIN Repuesto_Reparacion rr ON rr.codRep = r.codRep
        INNER JOIN Reparacion re ON re.nroReparac = rr.nroReparac
    GROUP BY r.codRep,
        r.nombre,
        stock
)
UNION
(
    SELECT r.nombre,
        stock,
        0 as cantTecnicos
    FROM Repuesto r
    WHERE r.codRep NOT IN(
            SELECT rr.codRep
            FROM Repuesto_Reparacion
        )
)