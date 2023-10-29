Select DNI,
    apellido,
    nombre,
    SUM(f.total) as montoTotal
FROM Cliente c
    INNER JOIN Factura f ON c.idCliente = f.idCliente
    INNER JOIN Detalle d ON f.idFactura = d.idFactura
    INNER JOIN Producto p ON d.idProducto = p.idProducto
GROUP BY f.nroTicket,
    c.DNI,
    c.apellido,
    c.nombre
HAVING montoTotal > 10000000