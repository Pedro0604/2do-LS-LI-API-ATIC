SELECT nombre,
    apellido,
    direccion,
    telefono
FROM Cliente cl
    INNER JOIN Viaje v ON v.DNI = cl.DNI
GROUP BY cl.DNI,
    cl.nombre,
    cl.apellido,
    cl.direccion,
    cl.telefono
HAVING COUNT(*) >= 10;