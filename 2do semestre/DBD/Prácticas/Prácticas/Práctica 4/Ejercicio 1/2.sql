SELECT nombre,
    apellido,
    DNI telefono,
    direccion
FROM Cliente c
    INNER JOIN Factura f ON f.idCliente = c.idCliente
EXCEPT(
        SELECT nombre,
            apellido,
            DNI telefono,
            direccion
        FROM Cliente c
            INNER JOIN Factura f ON f.idCliente = c.idCliente
        WHERE f.fecha < '2017-01-01'
            OR f.fecha > '2017-12-31'
    )