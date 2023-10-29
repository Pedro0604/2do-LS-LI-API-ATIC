SELECT precio_total,
    fecha
FROM Reparacion re
WHERE EXISTS(
        SELECT *
        FROM Repuesto_Reparacion
        WHERE rr.nroReparac = re.nroReparac
            AND rr.precio BETWEEN 1000 AND 5000
    )