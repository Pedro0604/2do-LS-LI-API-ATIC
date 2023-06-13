namespace Aseguradora.Aplicacion.Entidades;

public class Siniestro
{
    public int Id { get; set; }
    public int PolizaId { get; set; }
    public DateTime FechaIngreso { get; set;}
    public DateTime FechaOcurrencia { get; set; }
    public string? DireccionSiniestro { get; set; }
    public string? Descripcion { get; set; }

    // Propiedad de navegación para los terceros
    public List<Tercero> Terceros { get; set; } = new List<Tercero>();

    public Siniestro() { }
}