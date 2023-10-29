(
    SELECT pdr.DNI,
        apellido,
        nombre,
        telefono,
        fnac
    FROM Podador pdr
)
EXCEPT(
        SELECT pdr.DNI,
            apellido,
            nombre,
            telefono,
            fnac
        FROM Podador pdr
            INNER JOIN Poda p ON p.DNI = pdr.DNI
            INNER JOIN Arbol a ON a.nroArbol = p.nroArbol
        WHERE a.especie != 'Coníferas'
    )