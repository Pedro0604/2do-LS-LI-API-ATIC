namespace Ej1;

class Perro : IVendible, IAtendible, ILavable, INombrable, IComparable
{
    public string? Nombre { get; set; }
    public void VenderA(Persona p)
    {
        Console.WriteLine("Vendiendo perro a persona");
    }

    public void Atender()
    {
        Console.WriteLine("Atendiendo a perro");
    }
    public void Lavar()
    {
        Console.WriteLine("Lavando perro");
    }

    public void Secar()
    {
        Console.WriteLine("Secando perro");
    }

    public override string? ToString() => $"{Nombre} es un perro";

    // CompareTo ejercicio 4
    // public int CompareTo(object? obj)
    // {
    //     int result = 0;
    //     if (obj is INombrable nombrable)
    //     {
    //         result = this.Nombre.CompareTo(nombrable.Nombre);
    //     }
    //     return result;
    // }


    // CompareTo ejercicio 5
    public int CompareTo(object? obj)
    {
        int result = 0;
        if (obj is INombrable nombrable)
        {
            if (nombrable is Perro)
                result = this.Nombre.CompareTo(nombrable.Nombre);
            else if (nombrable is Persona)
                result = 1;
        }
        return result;
    }
}