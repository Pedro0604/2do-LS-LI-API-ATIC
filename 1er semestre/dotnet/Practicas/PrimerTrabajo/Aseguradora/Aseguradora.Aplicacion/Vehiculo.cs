namespace Aseguradora.Aplicacion;

public class Vehiculo
{
    public int Id { get; set; }
    public string? Dominio { get; set; }
    public string? Marca { get; set; }
    public int AñoFabricacion { get; set; }
    public int TitularId { get; set; }
}