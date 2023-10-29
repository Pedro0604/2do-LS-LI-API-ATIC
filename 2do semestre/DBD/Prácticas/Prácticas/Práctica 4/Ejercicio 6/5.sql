SELECT r.nombre,
    stock,
    COUNT(DISTINCT re.codTec) as cantTecnicos
FROM Repuesto r
    LEFT JOIN Repuesto_Reparacion rr ON rr.codRep = r.codRep
    INNER JOIN Reparacion re ON re.nroReparac = rr.nroReparac
GROUP BY r.codRep,
    r.nombre,
    stock