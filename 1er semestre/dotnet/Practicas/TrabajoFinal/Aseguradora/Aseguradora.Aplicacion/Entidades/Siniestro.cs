namespace Aseguradora.Aplicacion.Entidades;

public class Siniestro
{
    public int Id { get; set; }
    public int PolizaId { get; set; }
    public DateTime FechaIngreso { get; }
    public DateTime FechaOcurrencia { get; set; }
    public string? DireccionSiniestro { get; set; }
    public string? Descripcion { get; set; }

    // Propiedad de navegación para los terceros
    public List<Tercero> Terceros { get; set; } = new List<Tercero>();

    //Constructor para inicializar el Id en -1 por default
    private Siniestro()
    {
        FechaIngreso = DateTime.Now;
        Id = -1;
    }

    //Constructor para inicializar las propiedades
    //que recibe obligatoriamente: polizaId y fechaOcurrencia
    //y opcionalmente: direccionSiniestro y descripcion
    public Siniestro(int polizaId, DateTime fechaOcurrencia, string? direccionSiniestro = "", string? descripcion = "") : this()
    {
        this.PolizaId = polizaId;
        this.FechaOcurrencia = fechaOcurrencia;
        this.DireccionSiniestro = direccionSiniestro;
        this.Descripcion = descripcion;
    }

    public override string ToString()
    {
        string st = $"Siniestro: | Id: {this.Id} - Id de la poliza: {this.PolizaId} - Fecha de ingreso: {this.FechaIngreso.ToShortDateString()} - Fecha de ocurrencia: {this.FechaOcurrencia.ToShortDateString()}";
        st += this.DireccionSiniestro != "" ? $" - Dirección del siniestro: {this.DireccionSiniestro}" : "";
        st += this.Descripcion != "" ? $" - Descripción del siniestro: {this.Descripcion}" : "";
        return st;
    }
}