UPDATE Persona
SET estado_civil = "Divorciado"
WHERE DNI = (
        SELECT a.DNI
        FROM Alumno a
        WHERE a.legajo = '2020/09'
    )