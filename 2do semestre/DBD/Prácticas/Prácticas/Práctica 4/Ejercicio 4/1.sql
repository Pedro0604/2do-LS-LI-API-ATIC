SELECT a.DNI,
    a.legajo,
    p.apellido,
    p.nombre
FROM Alumno a
    INNER JOIN Persona p ON p.DNI = a.DNI
WHERE a.anio_ingreso < 2014