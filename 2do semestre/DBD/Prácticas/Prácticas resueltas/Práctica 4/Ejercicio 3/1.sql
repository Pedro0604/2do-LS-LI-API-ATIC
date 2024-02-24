SELECT c.nombre,
    anioFundacion
FROM Club c
    INNER JOIN Ciudad ciu ON ciu.codigoCiudad = c.codigoCiudad
WHERE ciu.nombre = 'La Plata'
    AND c.codigoClub NOT IN(
        SELECT e.codigoClub
        FROM Estadio e
    )