namespace Ej9;

class Auto
{
    public string? Marca { get; set; }
    public int? Modelo { get; set; }
    public Auto()
    {
        Marca = "Renault";
        Modelo = 2007;
    }

    public Auto(string marca, int modelo)
    {
        Marca = marca;
        Modelo = modelo;
    }

    public string ToTextFile()
    {
        return $"{Marca}|{Modelo}";
    }

    public override string ToString()
    {
        return $"Auto {Marca} del año {Modelo}.";
    }
}