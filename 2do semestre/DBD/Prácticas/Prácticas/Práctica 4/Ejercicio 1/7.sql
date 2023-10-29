SELECT nroTicket,
    total,
    fecha,
    hora,
    DNI
FROM Cliente c
    INNER JOIN factura f ON f.idCliente = c.idCliente
    INNER JOIN Detalle d ON d.idFactura = f.idFactura
    INNER JOIN Producto p ON d.idProducto = p.idProducto
WHERE p.nombre = 'prod38'
    OR f.fecha BETWEEN '2019-1-1' AND '2019-12-31';