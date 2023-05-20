namespace Ej3;

class Examen
{
    public int AlumnoId { get; private set; }
    public double Nota { get; private set; }
    public int CursoId { get; private set; }
    public Examen(int alumnoId, double nota, int cursoId)
    {
        AlumnoId = alumnoId;
        CursoId = cursoId;
        Nota = nota;
    }
}