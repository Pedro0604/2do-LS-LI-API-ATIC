namespace Aseguradora.Aplicacion.Entidades;

public class Vehiculo
{
    public int Id { get; set; }
    public string? Dominio { get; set; }
    public string? Marca { get; set; }
    public int AñoFabricacion { get; set; }
    public int TitularId { get; set; } = 1;

    // Propiedad de navegación para las pólizas
    public List<Poliza> Polizas { get; set; } = new List<Poliza>();
}