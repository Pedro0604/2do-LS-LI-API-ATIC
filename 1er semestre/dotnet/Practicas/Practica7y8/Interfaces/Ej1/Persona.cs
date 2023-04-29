namespace Ej1;

class Persona : IAtendible, IComercial, IImportante, INombrable, IComparable
{
    public string? Nombre { get; set; }
    public void Atender()
    {
        Console.WriteLine("Atendiendo a persona");
    }
    void IComercial.Importa()
    {
        Console.WriteLine("Persona vendiendo al exterior");
    }
    void IImportante.Importa()
    {
        Console.WriteLine("Persona importante");
    }
    public void Importa()
    {
        Console.WriteLine("Metodo Importar() de la clase Persona");
    }

    public override string? ToString() => $"{Nombre} es una persona";


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
            if (nombrable is Persona)
                result = this.Nombre.CompareTo(nombrable.Nombre);
            else if (nombrable is Perro)
                result = -1;
        }
        return result;
    }
}