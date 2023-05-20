using Ej3;

var alumnos = new List<Alumno>() {
 new Alumno(1,"Juan"),
 new Alumno(2,"Ana"),
 new Alumno(3,"Andrés"),
 new Alumno(4,"Paula"),
 new Alumno(5,"Sebastián"),
 new Alumno(6,"María"),
 new Alumno(7,"Camila"),
 new Alumno(8,"Iván"),
 new Alumno(9,"Raúl")
 };

var examenes = new List<Examen>() {
 new Examen(2,5,1),
 new Examen(4,7,5),
 new Examen(4,9,3),
 new Examen(3,10,4),
 new Examen(7,5,3),
 new Examen(2,8,4),
 new Examen(6,9,5),
 new Examen(9,7,1),
 new Examen(6,5,4),
 new Examen(9,1,4),
 new Examen(7,9,5)
 };

var cursos = new List<Curso>() {
 new Curso(1,"Inglés"),
 new Curso(2,"Matemática"),
 new Curso(3,"Historia"),
 new Curso(4,"Geografía"),
 new Curso(5,"Literatura"),
 new Curso(6,"Contabilidad"),
 };

alumnos.Join(examenes,
a => a.Id,
e => e.AlumnoId,
(a, e) => a.Nombre
).Distinct().OrderBy(a => a).ToList()
.ForEach(a => Console.WriteLine(a));

Console.WriteLine();

examenes.Join(cursos,
e => e.CursoId,
c => c.Id,
(e, c) => c.Titulo
).GroupBy(t => t).ToList()
.Select(
    g => new
    {
        Titulo = g.Key,
        Cantidad = g.Count()
    }
).OrderBy(c => c.Cantidad).ToList()
.ForEach(c => Console.WriteLine(c));

Console.WriteLine();

alumnos.Join(examenes,
a => a.Id,
e => e.AlumnoId,
(a, e) => new
{
    Alumno = a.Nombre,
    Curso = cursos.Where(c => c.Id == e.CursoId).SingleOrDefault()?.Titulo,
    Nota = e.Nota
}).ToList().ForEach(a => Console.WriteLine(a));

Console.WriteLine();

alumnos.Join(examenes,
a => a.Id,
e => e.AlumnoId,
(a, e) => new
{
    Alumno = a.Nombre,
    Curso = cursos.Where(c => c.Id == e.CursoId).SingleOrDefault()?.Titulo,
    Nota = e.Nota
}).Where(a => a.Nota >= 6).ToList().ForEach(a => Console.WriteLine(a));

Console.WriteLine();

alumnos.GroupJoin(examenes,
a => a.Id,
e => e.AlumnoId,
(a, exams) => new
{
    Nombre = a.Nombre,
    Examenes = exams
}).Where(a => a.Examenes.Count() == 0).ToList().ForEach(a => Console.WriteLine(a.Nombre));

Console.WriteLine();

alumnos.GroupJoin(examenes,
a => a.Id,
e => e.AlumnoId,
(a, exams) => new
{
    Nombre = a.Nombre,
    Examenes = exams
}).Where(a => a.Examenes.Count() > 0).Select(a => new
{
    Alumno = a.Nombre,
    Promedio = a.Examenes.Select(e => e.Nota).Average()
}).ToList().ForEach(a => Console.WriteLine(a));

