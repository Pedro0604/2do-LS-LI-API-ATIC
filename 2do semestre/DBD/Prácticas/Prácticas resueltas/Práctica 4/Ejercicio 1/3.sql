SELECT nombre,
    descripcion,
    precio,
    stock
FROM Producto p
    INNER JOIN Detalle d ON p.idProducto = d.idProducto
    INNER JOIN Factura f ON f.nroTicket = d.nroTicket
    INNER JOIN Cliente c ON c.idCliente = f.idCliente
WHERE c.DNI = '45789456'
    AND p.idProducto NOT IN (
        SELECT idProducto
        FROM Producto p
            INNER JOIN Detalle d ON p.idProducto = d.idProducto
            INNER JOIN Factura f ON f.nroTicket = d.nroTicket
            INNER JOIN Cliente c ON c.idCliente = f.idCliente
        WHERE c.apellido = 'Garcia'
    )