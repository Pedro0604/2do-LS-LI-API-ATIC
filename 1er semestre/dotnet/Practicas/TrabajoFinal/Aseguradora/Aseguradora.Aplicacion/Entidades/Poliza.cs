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

    //Constructor para inicializar el Id en -1 por default
    private Poliza()
    {
        Id = -1;
    }

    //Constructor para inicializar las propiedades
    //que recibe obligatoriamente: vehiculoId, valorAsegurado, fecha de inicio de vigencia y fecha de fin de vigencia
    //y opcionalmente: franquicia y tipoDeCobertura
    public Poliza(int vehiculoId, double valorAsegurado, DateTime fIniV, DateTime fFinV, double franquicia = -1, string? tipoDeCobertura = "") : this()
    {
        this.VehiculoId = vehiculoId;
        this.ValorAsegurado = valorAsegurado;
        this.Franquicia = franquicia;
        this.TipoDeCobertura = tipoDeCobertura;
        this.FechaInicioVigencia = fIniV;
        this.FechaFinVigencia = fFinV;
    }

    public override string ToString()
    {
        string st = $"Póliza: | Id: {this.Id} - Id del vehículo: {this.VehiculoId} - Valor asegurado: {this.ValorAsegurado} - Fecha de inicio de cobertura: {this.FechaInicioVigencia.ToShortDateString()} - Fecha de fin de cobertura: {this.FechaFinVigencia.ToShortDateString()}";
        st += this.Franquicia != -1 ? $" - Franquicia: {this.Franquicia}" : "";
        st += this.TipoDeCobertura != "" ? $" - Tipo de cobertura: {this.TipoDeCobertura}" : "";
        return st;
    }
}