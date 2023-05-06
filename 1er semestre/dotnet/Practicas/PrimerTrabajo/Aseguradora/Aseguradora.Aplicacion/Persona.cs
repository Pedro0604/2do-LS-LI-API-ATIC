namespace Aseguradora.Aplicacion;

public abstract class Persona
{
    public int Id { get; set; }
    public int DNI { get; set; }
    public string? Apellido { get; set; }
    public string? Nombre { get; set; }
    public int Telefono { get; set; }

    public override string ToString()
    {
        return "Id: " + this.Id + " - DNI: " + this.DNI + " - Apellido:" + this.Apellido + " - Nombre: " + this.Nombre + " - Telefono: " + this.Telefono;
    }
}