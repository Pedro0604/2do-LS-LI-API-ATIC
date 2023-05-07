namespace Aseguradora.Aplicacion;

public class Siniestro
{
    public int Id { get; set; }
    public int PolizaId { get; set; }
    public DateTime FechaIngreso { get; }
    public DateTime FechaOcurrencia { get; set; }
    public string? DireccionSiniestro { get; set; }
    public string? Descripcion { get; set; }

    public override string ToString()
    {
        return $"Siniestro: | Id: {this.Id} - Id de la poliza: {this.PolizaId} - Fecha de ingreso: {this.FechaIngreso} - Fecha de ocurrencia: {this.FechaOcurrencia} - Dirección del siniestro: {this.DireccionSiniestro} - Descripcion del siniestro: {this.Descripcion} |";
    }
}