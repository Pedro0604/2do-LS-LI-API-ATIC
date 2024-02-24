INSERT INTO Club
VALUES(
        1234,
        "Estrella de Berisso",
        1921,
        (
            SELECT codigoCiudad
            FROM Ciudad
            WHERE nombre = "Berisso"
        )
    )