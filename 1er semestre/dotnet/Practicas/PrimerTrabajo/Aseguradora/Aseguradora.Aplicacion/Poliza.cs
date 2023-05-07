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

    public override string ToString()
    {
        return $"Poliza: | Id: {this.Id} - Id del vehiculo: {this.VehiculoId} - Valor asegurado: {this.ValorAsegurado} - Franquicia: {this.Franquicia} - Tipo de cobertura: {this.TipoDeCobertura} - Fecha de inicio de cobertura: {this.FechaInicioVigencia} - Fecha de fin de cobertura: {this.FechaFinVigencia} |";
    }
    public string AStringParaTxt()
    {
        return $"{this.Id}|{this.VehiculoId}|{this.ValorAsegurado}|{this.Franquicia}|{this.TipoDeCobertura}|{this.FechaInicioVigencia}|{this.FechaFinVigencia}";
    }
}