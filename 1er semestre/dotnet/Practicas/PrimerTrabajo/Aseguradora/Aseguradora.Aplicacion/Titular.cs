namespace Aseguradora.Aplicacion;

public class Titular : Persona
{
    public string? Direccion { get; set; }
    public string? CorreoElectronico { get; set; }
    public int VehiculoId { get; set; }
    public List<Vehiculo>? listaVehiculos { get; set; }

    public override string ToString()
    {
        return $"Tercero: | {base.ToString()} - Direccion: {this.Direccion} - Correo electronico: {this.CorreoElectronico} - Id del vehiculo: {this.VehiculoId} |";
    }
    public override string AStringParaTxt()
    {
        return $"{base.AStringParaTxt()}|{this.Direccion}|{this.CorreoElectronico}|{this.VehiculoId}";
    }
}