SELECT nombre
FROM Club c
WHERE NOT EXISTS(
        SELECT *
        FROM ClubJugador cj
            INNER JOIN Jugador j ON cj.dni = j.dni
            INNER JOIN Ciudad ci ON j.codigoCiudad = ci.codigoCiudad
        WHERE cj.codigoClub = c.codigoClub
            AND ci.nombre = "Berisso"
    )