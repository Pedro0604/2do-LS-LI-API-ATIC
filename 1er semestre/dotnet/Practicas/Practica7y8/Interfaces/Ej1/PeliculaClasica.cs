namespace Ej1;

class PeliculaClasica : Pelicula, IVendible
{

    public override void AlquilarA(Persona p)
    {
        Console.WriteLine("Alquilando película clásica a persona");
    }
    public override void DevueltaPor(Persona p)
    {
        Console.WriteLine("Película clásica devuelta por persona");
    }

    public void VenderA(Persona p)
    {
        Console.WriteLine("Vendiendo película clásica a persona");
    }
}