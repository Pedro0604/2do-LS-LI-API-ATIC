namespace Aseguradora.Aplicacion;

public class Vehiculo
{
    public int Id { get; set; }
    public string? Dominio { get; set; }
    public string? Marca { get; set; }
    public int AñoFabricacion { get; set; }
    public int TitularId { get; set; }

    public Vehiculo() { }

    public Vehiculo(string strFromText)
    {
        try
        {
            var infoVehiculo = strFromText.Split('|');
            Id = int.Parse(infoVehiculo[0]);
            Dominio = infoVehiculo[1];
            Marca = infoVehiculo[2];
            AñoFabricacion = int.Parse(infoVehiculo[3]);
            TitularId = int.Parse(infoVehiculo[4]);
        }
        catch
        {
            Console.WriteLine("El formato de la cadena enviada no corresponde con el de un vehiculo");
        }
    }

    public override string ToString()
    {
        return $"Vehiculo: | Id: {this.Id} - Dominio: {this.Dominio} - Marca:{this.Marca} - Año de fabricación: {this.AñoFabricacion} - Id del titular: {this.TitularId}";
    }
    public string AStringParaTxt()
    {
        return $"{this.Id}|{this.Dominio}|{this.Marca}|{this.AñoFabricacion}|{this.TitularId}";
    }
}