(
    SELECT especie,
        anios,
        calle,
        nro,
        nombreL
    FROM Arbol a
        INNER JOIN Localidad l ON a.codigoPostal = l.codigoPostal
        INNER JOIN Poda p ON p.nroArbol = a.nroArbol
        INNER JOIN Podador pdr ON pdr.DNI = p.DNI
    WHERE pdr.nombre = 'Juan'
        AND pdr.apellido = 'Perez'
)
INTERSECT
(
    SELECT especie,
        anios,
        calle,
        nro,
        nombreL
    FROM Arbol a
        INNER JOIN Localidad l ON a.codigoPostal = l.codigoPostal
        INNER JOIN Poda p ON p.nroArbol = a.nroArbol
        INNER JOIN Podador pdr ON pdr.DNI = p.DNI
    WHERE pdr.nombre = 'Jose'
        AND pdr.apellido = 'Garcia'
)