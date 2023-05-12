namespace Ej7;

public class Persona
{
    public Persona() { }

    public Persona(string nombre, int edad)
    {
        Nombre = nombre;
        Edad = edad;
    }

    public string? Nombre { get; set; }
    public int Edad { get; set; }
}