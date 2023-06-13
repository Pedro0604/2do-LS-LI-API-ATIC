namespace Aseguradora.Aplicacion.Entidades;

public class Siniestro
{
    public int Id { get; set; }
    public int PolizaId { get; set; } = 1;
    public DateTime FechaIngreso { get; set;} = DateTime.Now;
    public DateTime FechaOcurrencia { get; set; } = new DateTime(2018, 01, 01);
    public string? DireccionSiniestro { get; set; }
    public string? Descripcion { get; set; }

    // Propiedad de navegación para los terceros
    public List<Tercero> Terceros { get; set; } = new List<Tercero>();

    public Siniestro() { }
}