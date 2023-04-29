namespace Ej1;

class Libro : IAlquilable, IReciclable
{
    public void AlquilarA(Persona p)
    {
        Console.WriteLine("Alquilando libro a persona");
    }
    public void DevueltaPor(Persona p)
    {
        Console.WriteLine("Libro devuelto por persona");
    }
    public void Reciclar()
    {
        Console.WriteLine("Reciclando libro");
    }
}