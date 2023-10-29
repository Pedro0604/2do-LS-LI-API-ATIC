SELECT nroTicket,
    total,
    fecha,
    hora
FROM Cliente c
    INNER JOIN factura f ON f.idCliente = c.idCliente
    INNER JOIN Detalle d ON d.idFactura = f.idFactura
    INNER JOIN Producto p ON d.idProducto = p.idProducto
WHERE c.nombre = 'Jorge Perez'
    AND p.nombre != "Z"