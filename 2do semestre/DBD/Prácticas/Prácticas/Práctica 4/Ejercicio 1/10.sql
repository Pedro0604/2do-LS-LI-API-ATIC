Select DNI,
    apellido,
    nombre,
    SUM(f.total) as montoTotal
FROM Cliente c
    INNER JOIN Factura f ON c.idCliente = f.idCliente
GROUP BY f.idCliente,
    c.DNI,
    c.apellido,
    c.nombre
HAVING montoTotal > 10000000