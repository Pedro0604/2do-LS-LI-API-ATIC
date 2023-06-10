namespace Aseguradora.Aplicacion.Entidades;

//Clase base de Titular y Tercero
public abstract class Persona
{
    public int Id { get; set; }
    public int DNI { get; set; }
    public string? Apellido { get; set; }
    public string? Nombre { get; set; }
    public string? Telefono { get; set; }

    public override string ToString()
    {
        string st = $"Id: {this.Id} - DNI: {this.DNI} - Apellido: {this.Apellido} - Nombre: {this.Nombre}";
        st += this.Telefono != "" ? $" - Teléfono: {this.Telefono}" : "";
        return st;
    }
}