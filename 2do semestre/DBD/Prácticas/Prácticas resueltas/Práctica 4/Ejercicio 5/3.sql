SELECT especie,
    anios,
    calle,
    nro,
    nombreL
FROM Arbol a
    INNER JOIN Localidad l ON a.codigoPostal = l.codigoPostal
WHERE NOT EXISTS(
        SELECT *
        FROM Poda p
        WHERE p.nroArbol = a.nroArbol
    )