SELECT razon_social,
    direccion,
    telefono,
    email
FROM Agencia a
    INNER JOIN Viaje v ON v.razon_social = a.razon_social
WHERE v.fecha BETWEEN '2019-1-1' AND '2020-1-1'
    OR a.email LIKE "%@jmail.com"