namespace Ej1;

class Auto : IVendible, ILavable, IReciclable, IComercial, IImportante
{
    public void VenderA(Persona p)
    {
        Console.WriteLine("Vendiendo auto a persona");
    }
    public void Lavar()
    {
        Console.WriteLine("Lavando auto");
    }
    public void Secar()
    {
        Console.WriteLine("Secando auto");
    }
    public void Reciclar()
    {
        Console.WriteLine("Reciclando auto");
    }
    void IComercial.Importa()
    {
        Console.WriteLine("Auto que se vende al exterior");
    }
    void IImportante.Importa()
    {
        Console.WriteLine("Auto importante");
    }
    public void Importa()
    {
        Console.WriteLine("Metodo Importar() de la clase Auto");
    }
}