(
    (
        SELECT nombre,
            apellido,
            DNI,
            telefono,
            direccion
        FROM Cliente c
            INNER JOIN Factura f ON f.idCliente = c.idCliente
            INNER JOIN Detalle d ON d.nroTicket = f.nroTicket
            INNER JOIN Producto p ON p.idProducto = d.idProducto
        WHERE p.nombre = 'prod1'
    )
    INTERSECT
    (
        SELECT nombre,
            apellido,
            DNI,
            telefono,
            direccion
        FROM Cliente c
            INNER JOIN Factura f ON f.idCliente = c.idCliente
            INNER JOIN Detalle d ON d.nroTicket = f.nroTicket
            INNER JOIN Producto p ON p.idProducto = d.idProducto
        WHERE p.nombre = 'prod2'
    )
)
EXCEPT (
        SELECT nombre,
            apellido,
            DNI,
            telefono,
            direccion
        FROM Cliente c
            INNER JOIN Factura f ON f.idCliente = c.idCliente
            INNER JOIN Detalle d ON d.nroTicket = f.nroTicket
            INNER JOIN Producto p ON p.idProducto = d.idProducto
        WHERE p.nombre = 'prod3'
    )