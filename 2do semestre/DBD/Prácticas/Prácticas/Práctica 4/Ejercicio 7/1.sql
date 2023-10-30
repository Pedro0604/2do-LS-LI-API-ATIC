SELECT DNI,
    nombre,
    apellido,
    direccion,
    email
FROM Integrante i
WHERE fec_nac BETWEEN '1980-1-1' AND '1990-12-31'
    AND codigoB IN(
        SELECT b.codigoB
        FROM Banda b
            INNER JOIN Recital r ON r.codigoB = b.codigoB
        WHERE r.fecha BETWEEN '2018-1-1' AND '2018-12-31'
    )