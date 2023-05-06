namespace Aseguradora.Aplicacion;

public class Vehiculo
{
    public int Id { get; set; }
    public string? Dominio { get; set; }
    public string? Marca { get; set; }
    public int AñoFabricacion { get; set; }
    public int TitularId { get; set; }

    public override string ToString()
    {
        return "Vehiculo: | Id: " + this.Id + " - Dominio: " + this.Dominio + " - Marca:" + this.Marca + " - Año de fabricación: " + this.AñoFabricacion + " - Id del titular: " + this.TitularId + " |";
    }
}