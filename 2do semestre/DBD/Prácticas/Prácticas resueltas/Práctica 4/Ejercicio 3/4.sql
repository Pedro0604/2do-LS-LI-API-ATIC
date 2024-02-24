SELECT DNI,
    nombre,
    apellido
FROM Jugador j
Where j.edad > 29
    AND j.DNI IN(
        SELECT DNI
        FROM Jugador j
            INNER JOIN ClubJugador cj ON j.DNI = cj.DNI
            INNER JOIN Club cl ON cj.codigoClub = cl.codigoClub
            INNER JOIN Ciudad c ON c.codigoCiudad = cl.codigoCiudad
        WHERE c.nombre = "Cordoba"
    )