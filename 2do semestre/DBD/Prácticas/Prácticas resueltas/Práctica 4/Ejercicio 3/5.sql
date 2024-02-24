SELECT cl.nombre,
    AVG(j.edad)
FROM CLub cl
    INNER JOIN ClubJugador cj ON cl.codigoClub = cj.codigoClub
    INNER JOIN Jugador j ON cj.dni = j.dni
WHERE cj.hasta IS NULL
    OR cj.hasta > now()
GROUP BY cl.codigoClub,
    cl.nombre