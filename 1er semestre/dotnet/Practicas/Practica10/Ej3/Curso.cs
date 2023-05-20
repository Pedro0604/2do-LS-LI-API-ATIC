namespace Ej3;

class Curso
{
    public int Id { get; private set; }
    public string Titulo { get; private set; }
    public Curso(int id, string titulo)
    {
        Id = id;
        Titulo = titulo;
    }
}