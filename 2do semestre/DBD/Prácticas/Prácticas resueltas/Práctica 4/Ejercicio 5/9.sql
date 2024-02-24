SELECT nombre,
    descripcion,
    cantHabitantes,
    COUNT(*) as cantArboles
FROM Localidad l
    INNER JOIN Arbol a ON a.codigoPostal = l.codigoPostal
GROUP BY l.codigoPostal,
    nombre,
    descripcion,
    cantHabitantes
HAVING COUNT(*) < 100