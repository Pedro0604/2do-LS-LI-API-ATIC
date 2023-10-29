SELECT nombre,
    descripcion,
    precio,
    SUM(d.cantidad) as cantVentas
FROM Producto p
    LEFT JOIN Detalle d ON p.idProducto = d.idProducto
GROUP BY p.idProducto,
    p.nombre,
    p.descripcion,
    p.precio