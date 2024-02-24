SELECT nombre,
    apellido,
    direccion,
    telefono
FROM Cliente cl
WHERE NOT EXISTS(
        SELECT *
        FROM Agencia a
        WHERE NOT EXISTS (
                SELECT *
                FROM Viaje v
                WHERE v.razon_social = a.razon_social
                    AND v.DNI = cl.DNI
            )
    )