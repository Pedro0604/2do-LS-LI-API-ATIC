(
    SELECT especie
    FROM Arbol a
        INNER JOIN Localidad l ON a.codigoPostal = l.codigoPostal
    WHERE l.nombreL = "La Plata"
)
INTERSECT
(
    SELECT especie
    FROM Arbol a
        INNER JOIN Localidad l ON a.codigoPostal = l.codigoPostal
    WHERE l.nombreL = "Salta"
)