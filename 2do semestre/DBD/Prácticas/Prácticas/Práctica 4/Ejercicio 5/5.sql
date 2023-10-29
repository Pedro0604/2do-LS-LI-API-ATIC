SELECT pdr.DNI,
    nombre,
    apellido,
    fnac,
    nombreL
FROM Podador pdr
    INNER JOIN Localidad l ON l.codigoPostal = pdr.codigoPostalVive
WHERE pdr.apellido LIKE 'ata%'
    AND EXISTS (
        SELECT *
        FROM Poda p
        WHERE p.DNI = pdr.DNI
            AND p.fecha BETWEEN '2018-1-1' AND '2019-1-1'
    )
ORDER BY pdr.apellido,
    pdr.nombre