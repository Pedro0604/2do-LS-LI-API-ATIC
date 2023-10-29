Select j.nombre,
    apellido,
    edad,
    COUNT(*)
FROM Jugador j
    INNER JOIN ClubJugador cj ON j.DNI = cj.DNI
GROUP BY cj.codigoClub,
    j.nombre,
    apellido,
    edad