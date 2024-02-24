SELECT r.nombre,
    stock,
    precio
FROM Repuesto r
WHERE stock > 0
    AND NOT EXISTS (
        SELECT *
        FROM Repuesto_Reparacion rr
            INNER JOIN Reparacion re ON re.nroReparac = rr.nroReparac
        WHERE rr.codRep = r.codRep
            AND re.precio_total > 10000
    )