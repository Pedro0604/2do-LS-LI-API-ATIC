SELECT persona_Alumno.DNI,
    persona_Alumno.apellido,
    persona_Alumno.nombre,
    ac.calificacion
FROM Persona persona_Alumno
    INNER JOIN Alumno a ON a.DNI = persona_Alumno.DNI
    INNER JOIN Alumno_Curso ac ON ac.DNI = a.DNI
    INNER JOIN Profesor_Curso pc ON pc.codigoCurso = ac.codigoCurso
    INNER JOIN Profesor pr ON pc.DNI = pr.DNI
    INNER JOIN Persona persona_Profesor ON persona_Profesor.DNI = pr.DNI
WHERE ac.calificacion > 9
    AND persona_Profesor.nombre = "Juan Garcia"
ORDER BY persona_Alumno.apellido