(
    SELECT nombreP,
        descripcion,
        precio,
        SUM(d.cantidad) as cantVentas
    FROM Producto p
        LEFT JOIN Detalle d ON p.idProducto = d.idProducto
    GROUP BY p.idProducto,
        p.nombreP,
        p.descripcion,
        p.precio
    HAVING cantVentas IS NOT NULL
)
UNION
(
    SELECT nombreP,
        descripcion,
        precio,
        0 as cantVentas
    FROM Producto p
        LEFT JOIN Detalle d ON p.idProducto = d.idProducto
    GROUP BY p.idProducto,
        p.nombreP,
        p.descripcion,
        p.precio
    HAVING SUM(d.cantidad) IS NULL
)