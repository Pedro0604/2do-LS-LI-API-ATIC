(
    SELECT r.nombre,
        stock,
        precio
    FROM Repuesto r
        INNER JOIN Repuesto_Reparacion rr ON r.codRep = rr.codRep
        INNER JOIN Reparacion re ON rr.nroReparac = re.nroReparac
    WHERE re.fecha BETWEEN '2019-1-1' AND '2020-1-1'
)
EXCEPT(
        SELECT nombre,
            stock,
            precio
        FROM Repuesto r
            INNER JOIN Repuesto_Reparacion rr ON r.codRep = rr.codRep
            INNER JOIN Reparacion re ON rr.nroReparac = re.nroReparac
            INNER JOIN Tecnico t ON t.codTec = re.codTec
        WHERE t.nombreT = 'Jose Gonzales'
    )