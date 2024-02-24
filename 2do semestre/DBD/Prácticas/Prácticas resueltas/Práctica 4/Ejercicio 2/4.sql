SELECT DNI,
    nombre,
    apellido,
    telefono,
    direccion
FROM Cliente c
EXCEPT(
        SELECT DNI,
            nombre,
            apellido,
            telefono,
            direccion
        FROM Cliente c
            INNER JOIN Viaje v ON v.DNI = c.direccion
            INNER JOIN Ciudad c ON c.codigoPostal = v.cpDestino
        WHERE c.nombre != 'Coronel Brandsen'
    )