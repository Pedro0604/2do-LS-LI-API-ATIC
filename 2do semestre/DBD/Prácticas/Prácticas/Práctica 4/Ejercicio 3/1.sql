SELECT nombre,
    anioFundacion
FROM Club c
EXCEPT(
        SELECT nombre,
            anioFundacion
        FROM Club c
            INNER JOIN Estadio e ON c.codigoClub = e.codigoClub
    )