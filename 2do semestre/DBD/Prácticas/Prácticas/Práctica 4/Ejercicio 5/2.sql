SELECT DISTINCT p.DNI,
    nombre,
    apellido,
    fnac,
    nombreL
FROM Podador p
    INNER JOIN Localidad l ON p.codigoPostalVive = l.codigoPostal
    INNER JOIN Poda poda ON poda.DNI = p.DNI
WHERE poda.fecha BETWEEN '2018-1-1' AND '2019-1-1'