SELECT r.nombre,
    stock,
    precio
FROM Repuesto r
WHERE NOT EXISTS(
        SELECT *
        FROM Reparacion re
        WHERE NOT EXISTS(
                SELECT *
                FROM Repuesto_Reparacion rr
                WHERE rr.codRep = r.codRep
                    AND rr.nroReparac = re.nroReparac
            )
    )