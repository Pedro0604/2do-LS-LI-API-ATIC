SELECT nombre,
    descripcion,
    precio,
    stock
FROM Producto p
    INNER JOIN Detalle d ON p.idProducto = d.idProducto
    INNER JOIN Factura f ON f.nroTicket = d.nroTicket
    INNER JOIN Cliente c ON c.idCliente = f.idCliente
EXCEPT (
        SELECT nombre,
            descripcion,
            precio,
            stock
        FROM Producto p
            INNER JOIN Detalle d ON p.idProducto = d.idProducto
            INNER JOIN Factura f ON f.nroTicket = d.nroTicket
            INNER JOIN Cliente c ON c.idCliente = f.idCliente
        WHERE c.telefono LIKE '221%'
    )
ORDER BY nombre;