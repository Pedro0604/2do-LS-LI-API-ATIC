namespace Aseguradora.Aplicacion.Entidades;

public class Poliza
{
    public int Id { get; set; }
    public int VehiculoId { get; set; }
    public double ValorAsegurado { get; set; }
    public double Franquicia { get; set; }
    public string? TipoDeCobertura { get; set; }
    public DateTime FechaInicioVigencia { get; set; }
    public DateTime FechaFinVigencia { get; set; }

    // Propiedad de navegación para los siniestros
    public List<Siniestro> Siniestros { get; set; } = new List<Siniestro>();
}