namespace Aseguradora.Aplicacion;

public class Siniestro
{
    public int Id { get; set; }
    public int PolizaId { get; set; }
    public DateTime FechaIngreso { get; }
    public DateTime FechaOcurrencia { get; set; }
    public string? direccionSiniestro { get; set; }
    public string? Descripcion { get; set; }
}