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

    public Poliza() { }

    public Poliza(string strFromText)
    {
        try
        {
            var infoPoliza = strFromText.Split('|');
            Id = int.Parse(infoPoliza[0]);
            VehiculoId = int.Parse(infoPoliza[1]);
            ValorAsegurado = int.Parse(infoPoliza[2]);
            Franquicia = infoPoliza[3];
            TipoDeCobertura = infoPoliza[4];
            var fIniV = infoPoliza[5].Split("/");
            FechaInicioVigencia = new DateTime(int.Parse(fIniV[0]), int.Parse(fIniV[1]), int.Parse(fIniV[2]));
            var fFinV = infoPoliza[6].Split("/");
            FechaInicioVigencia = new DateTime(int.Parse(fFinV[0]), int.Parse(fFinV[1]), int.Parse(fFinV[2]));
        }
        catch
        {
            Console.WriteLine("El formato de la cadena enviada no corresponde con el de una póliza");
        }
    }

    public override string ToString()
    {
        return $"Poliza: | Id: {this.Id} - Id del vehiculo: {this.VehiculoId} - Valor asegurado: {this.ValorAsegurado} - Franquicia: {this.Franquicia} - Tipo de cobertura: {this.TipoDeCobertura} - Fecha de inicio de cobertura: {this.FechaInicioVigencia.ToShortDateString()} - Fecha de fin de cobertura: {this.FechaFinVigencia.ToShortDateString()}";
    }
    public string AStringParaTxt()
    {
        return $"{this.Id}|{this.VehiculoId}|{this.ValorAsegurado}|{this.Franquicia}|{this.TipoDeCobertura}|{this.FechaInicioVigencia.ToShortDateString()}|{this.FechaFinVigencia.ToShortDateString()}";
    }
}