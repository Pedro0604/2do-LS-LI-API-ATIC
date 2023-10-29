SELECT especie,
    anios,
    calle,
    nro,
    nombreL
FROM Arbol a
    INNER JOIN Localidad l ON a.codigoPostal = l.codigoPostal
WHERE EXISTS(
        SELECT *
        FROM PODA p
        WHERE p.fecha BETWEEN '2017-1-1' AND '2018-1-1'
            AND p.nroArbol = a.nroArbol
    )
    AND NOT EXISTS(
        SELECT *
        FROM PODA p
        WHERE p.fecha BETWEEN '2018-1-1' AND '2019-1-1'
            AND p.nroArbol = a.nroArbol
    )