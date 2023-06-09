namespace Aseguradora.Aplicacion.Entidades;

//Clase base de Titular y Tercero
public abstract class Persona
{
    public int Id { get; set; }
    public int DNI { get; set; }
    public string? Apellido { get; set; }
    public string? Nombre { get; set; }
    public string? Telefono { get; set; }

    //Constructor para inicializar el Id en -1 por default
    protected Persona()
    {
        Id = -1;
    }

    //Constructor para inicializar las propiedades
    //que recibe obligatoriamente: dni, apellido y nombre
    //y opcionalmente: telefono
    public Persona(int dni, string? apellido, string? nombre, string? telefono = "") : this()
    {
        this.DNI = dni;
        this.Apellido = apellido;
        this.Nombre = nombre;
        this.Telefono = telefono;
    }

    public override string ToString()
    {
        string st = $"Id: {this.Id} - DNI: {this.DNI} - Apellido: {this.Apellido} - Nombre: {this.Nombre}";
        st += this.Telefono != "" ? $" - Teléfono: {this.Telefono}" : "";
        return st;
    }
}