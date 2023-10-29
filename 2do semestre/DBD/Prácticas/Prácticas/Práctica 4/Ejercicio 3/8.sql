SELECT j.nombre, apellido
FROM Jugador j
WHERE NOT EXISTS(
    SELECT *
    FROM Club cl
    WHERE NOT EXISTS(
        SELECT *
        FROM ClubJugador cj
        WHERE cj.codigoClub = cl.codigoClub
            AND cj.DNI = j.DNI
    )
)