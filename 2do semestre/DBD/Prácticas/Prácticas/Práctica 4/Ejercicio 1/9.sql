SELECT DISTINCT f.nroTicket,
    total,
    fecha,
    hora
FROM Cliente c
    INNER JOIN factura f ON f.idCliente = c.idCliente
    INNER JOIN Detalle d ON d.nroTicket = f.nroTicket
    INNER JOIN Producto p ON d.idProducto = p.idProducto
WHERE c.nombre = 'Jorge'
    AND c.apellido = 'Pérez'
    AND f.nroTicket NOT IN(
        SELECT d2.nroTicket
        FROM Detalle d2
            INNER JOIN Producto p2 ON d2.idProducto = p2.idProducto
        WHERE p2.nombreP = 'Z'
    )