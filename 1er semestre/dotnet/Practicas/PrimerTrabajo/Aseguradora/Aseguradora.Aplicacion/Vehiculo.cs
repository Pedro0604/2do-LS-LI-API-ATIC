namespace Aseguradora.Aplicacion;

public class Vehiculo
{
    public int Id { get; set; }
    public string? Dominio { get; set; }
    public string? Marca { get; set; }
    public int AñoFabricacion { get; set; }
    public int TitularId { get; set; }

    //Constructor para inicializar el Id en -1 por default
    public Vehiculo()
    {
        Id = -1;
    }

    //Constructor que recibe un string con la información del Vehiculo con el formato que tienen los repositorios
    public Vehiculo(string strFromText, char c = '|')
    {
        try
        {
            //Se transforma el string en un string[], separandolo por el caracter '|'
            string[] infoVehiculo = strFromText.Split(c);
            //Se setean las propiedades del Vehiculo
            Id = int.Parse(infoVehiculo[0]);
            Dominio = infoVehiculo[1];
            Marca = infoVehiculo[2];
            AñoFabricacion = int.Parse(infoVehiculo[3]);
            TitularId = int.Parse(infoVehiculo[4]);
        }
        catch
        {
            Console.WriteLine("El formato de la cadena enviada no corresponde con el de un vehículo");
        }
    }

    //Constructor para inicializar las propiedades
    //que recibe obligatoriamente: dominio, marca, titularId
    //y opcionalmente: añoFabricacion
    public Vehiculo(string? dominio, string? marca, int titularId, int añoFabricacion = -1) : this()
    {
        this.Dominio = dominio;
        this.Marca = marca;
        this.AñoFabricacion = añoFabricacion;
        this.TitularId = titularId;
    }

    public override string ToString()
    {
        string st = $"Vehículo: | Id: {this.Id} - Dominio: {this.Dominio} - Marca:{this.Marca} - Id del titular: {this.TitularId}";
        st += this.AñoFabricacion != -1 ? $" - Año de fabricación: {this.AñoFabricacion}" : "";
        return st;
    }

    //Se transforma el Vehiculo en un string con el formato que tienen los repositorios
    public string AStringParaTxt(char c = '|')
    {
        return $"{this.Id}{c}{this.Dominio}{c}{this.Marca}{c}{this.AñoFabricacion}{c}{this.TitularId}";
    }
}