namespace Aseguradora.Aplicacion.Entidades;

public class Poliza
{
    public int Id { get; set; }
    public int VehiculoId { get; set; } = 1;
    public double ValorAsegurado { get; set; }
    public double Franquicia { get; set; }
    public string? TipoDeCobertura { get; set; }
    public DateTime FechaInicioVigencia { get; set; } = new DateTime(2010, 1, 1);
    public DateTime FechaFinVigencia { get; set; } = new DateTime(2024, 6, 19);

    // Propiedad de navegación para los siniestros
    public List<Siniestro> Siniestros { get; set; } = new List<Siniestro>();
}