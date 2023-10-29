SELECT razon_social, daireccion, telefono
FROM Agencia a
INNER JOIN Viaje v ON v.razon_social = a.razon_social
INNER JOIN Ciudad c ON c.codigoPostal = v.cpOrigen
INNER JOIN Cliente cl ON cl.DNI = v.DNI
WHERE c.nombreCiudad = 'La Plata' AND
cl.apellido = "Roma"
ORDER BY a.razon_social, cl.telefono

