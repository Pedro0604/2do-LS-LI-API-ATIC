SELECT cl.nombre
FROM Club cl
EXCEPT(
        SELECT cl.nombre
        FROM Club cl
            INNER JOIN ClubJugador cj ON cl.codigoClub = cj.codigoClub
            INNER JOIN Jugador j ON cj.DNI = j.DNI
            INNER JOIN Ciudad c ON cl.codigoCiudad = j.codigoCiudad
        WHERE c.nombre = "Mar del Plata"
    )