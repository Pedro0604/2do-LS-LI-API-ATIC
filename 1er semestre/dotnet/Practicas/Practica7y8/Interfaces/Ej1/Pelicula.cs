namespace Ej1;

class Pelicula : IAlquilable
{

    public virtual void AlquilarA(Persona p)
    {
        Console.WriteLine("Alquilando película a persona");
    }
    public virtual void DevueltaPor(Persona p)
    {
        Console.WriteLine("Película devuelta por persona");
    }
}