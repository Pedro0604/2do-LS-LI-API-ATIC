SELECT razon_social,
    direccion,
    telefono,
    COUNT(*) AS cantViajes
FROM Agencia a
    INNER JOIN Viaje v ON v.razon_social = a.razon_social
GROUP BY razon_social,
    direccion,
    telefono
HAVING COUNT(*) >= ALL(
        SELECT COUNT(*)
        FROM Agencia a
            INNER JOIN Viaje v ON v.razon_social = a.razon_social
        GROUP BY razon_social,
            direccion,
            telefono
    )