namespace Aseguradora.Aplicacion.Entidades;

//Clase derivada de la clase Persona
public class Titular : Persona
{
    public string? Direccion { get; set; }
    public string? Email { get; set; }

    // Propiedad de navegación para los vehículos
    public List<Vehiculo> Vehiculos { get; set; } = new List<Vehiculo>();
}