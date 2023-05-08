namespace Aseguradora.Aplicacion;

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

    //Constructor que recibe un string con la información de la Poliza con el formato que tienen los repositorios
    public Poliza(string strFromText)
    {
        try
        {
            //Se transforma el string en un string[], separandolo por el caracter '|'
            string[] infoPoliza = strFromText.Split('|');

            //Se setean las propiedades de la Poliza
            Id = int.Parse(infoPoliza[0]);
            VehiculoId = int.Parse(infoPoliza[1]);
            ValorAsegurado = double.Parse(infoPoliza[2]);
            Franquicia = double.Parse(infoPoliza[3]);
            TipoDeCobertura = infoPoliza[4];
            string[] fIniV = infoPoliza[5].Split("/");
            FechaInicioVigencia = new DateTime(int.Parse(fIniV[0]), int.Parse(fIniV[1]), int.Parse(fIniV[2]));
            string[] fFinV = infoPoliza[6].Split("/");
            FechaInicioVigencia = new DateTime(int.Parse(fFinV[0]), int.Parse(fFinV[1]), int.Parse(fFinV[2]));
        }
        catch
        {
            Console.WriteLine("El formato de la cadena enviada no corresponde con el de una póliza");
        }
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
        string st = $"Poliza: | Id: {this.Id} - Id del vehiculo: {this.VehiculoId} - Valor asegurado: {this.ValorAsegurado} - Fecha de inicio de cobertura: {this.FechaInicioVigencia.ToShortDateString()} - Fecha de fin de cobertura: {this.FechaFinVigencia.ToShortDateString()}";
        st += this.Franquicia != -1 ? $" - Franquicia: {this.Franquicia}" : "";
        st += this.TipoDeCobertura != "" ? $" - Tipo de cobertura: {this.TipoDeCobertura}" : "";
        return st;
    }

    //Se transforma la Poliza en un string con el formato que tienen los repositorios
    public string AStringParaTxt()
    {
        return $"{this.Id}|{this.VehiculoId}|{this.ValorAsegurado}|{this.Franquicia}|{this.TipoDeCobertura}|{this.FechaInicioVigencia.ToShortDateString()}|{this.FechaFinVigencia.ToShortDateString()}";
    }
}