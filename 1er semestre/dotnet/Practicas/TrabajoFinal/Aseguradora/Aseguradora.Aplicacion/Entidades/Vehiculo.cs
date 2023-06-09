namespace Aseguradora.Aplicacion.Entidades;

public class Vehiculo
{
    public int Id { get; set; }
    public string? Dominio { get; set; }
    public string? Marca { get; set; }
    public int AñoFabricacion { get; set; }
    public int TitularId { get; set; }

    // Propiedad de navegación para las pólizas
    public List<Poliza> Polizas { get; set; } = new List<Poliza>();

    //Constructor para inicializar el Id en -1 por default
    private Vehiculo()
    {
        Id = -1;
    }

    //Constructor para inicializar las propiedades
    //que recibe obligatoriamente: dominio, marca, titularId
    //y opcionalmente: añoFabricacion
    public Vehiculo(string? dominio, string? marca, int titularId, int añoFabricacion = -1) : this()
    {
        this.Dominio = dominio;
        this.Marca = marca;
        this.AñoFabricacion = añoFabricacion;
        this.TitularId = titularId;
    }

    public override string ToString()
    {
        string st = $"Vehículo: | Id: {this.Id} - Dominio: {this.Dominio} - Marca:{this.Marca} - Id del titular: {this.TitularId}";
        st += this.AñoFabricacion != -1 ? $" - Año de fabricación: {this.AñoFabricacion}" : "";
        return st;
    }
}