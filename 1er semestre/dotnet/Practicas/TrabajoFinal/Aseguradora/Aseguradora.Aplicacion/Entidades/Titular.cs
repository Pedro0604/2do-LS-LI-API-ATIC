namespace Aseguradora.Aplicacion.Entidades;

public class Titular : Persona
{
    public string? Direccion { get; set; }
    public string? Email { get; set; }

    // Propiedad de navegación para los vehículos
    public List<Vehiculo> Vehiculos { get; set; } = new List<Vehiculo>();

    public override string ToString()
    {
        string st = $"Titular: | {base.ToString()}";
        st += this.Direccion != "" ? $" - Dirección: {this.Direccion}" : "";
        st += this.Email != "" ? $" - Correo electrónico: {this.Email}" : "";
        return st;
    }
}