SELECT DNI,
    nombre,
    apellido
FROM Jugador j
WHERE j.DNI IN(
        SELECT DNI
        FROM Jugador j
            INNER JOIN ClubJugador cj ON j.DNI = cj.DNI
            INNER JOIN Club c ON cj.codigoClub = c.codigoClub
        WHERE c.nombre = "Gimnasia y Esgrima La Plata"
    )