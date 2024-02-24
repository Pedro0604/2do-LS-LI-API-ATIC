SELECT COUNT(*)
FROM Agencia a
    INNER JOIN Viaje v ON v.razon_social = a.razon_social
    INNER JOIN Ciudad c ON c.codigoPostal = v.cpDestino
WHERE razon_social = "TAXI Y"
    AND c.nombreCiudad = "Villa Elisa"