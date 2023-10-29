SELECT fecha,
    hora,
    cl.DNI,
    cl.nombre,
    cl.apellido,
    cl.telefono,
    cl.daireccion,
    origen.nombreCiudad,
    destino.nombreCiudad
FROM Viaje v
    INNER JOIN Cliente cl ON cl.DNI = v.DNI
    INNER JOIN Ciudad origen ON origen.codigoPostal = v.cpOrigen
    INNER JOIN Ciudad destino ON destino.codigoPostal = v.cpDestino
WHERE v.fecha BETWEEN '2019-1-1' AND '2019-2-1'
    AND v.descripcion LIKE "%demorado%"