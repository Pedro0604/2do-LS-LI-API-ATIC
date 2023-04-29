namespace Aseguradora.Aplicacion;

public class Poliza
{
    public int Id { get; set; }
    public int VehiculoId { get; set; }
    public double ValorAsegurado { get; set; }
    public string? Franquicia { get; set; }
    public string? TipoDeCobertura { get; set; }
    public DateTime FechaInicioVigencia { get; set; }
    public DateTime FechaFinVigencia { get; set; }
}