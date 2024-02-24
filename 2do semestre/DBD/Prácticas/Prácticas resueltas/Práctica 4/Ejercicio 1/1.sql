SELECT nombre,
    apellido,
    DNI,
    telefono,
    direccion
FROM Cliente
WHERE apellido LIKE "Pe%"
ORDER BY DNI;