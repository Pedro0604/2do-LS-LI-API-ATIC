namespace Aseguradora.Aplicacion.Entidades;

public class Titular : Persona
{
    public string? Direccion { get; set; }
    public string? Email { get; set; }
    public List<Vehiculo> ListaVehiculos { get; set; } = new List<Vehiculo>();

    protected Titular() { }

    //Constructor para inicializar las propiedades
    //que recibe obligatoriamente: dni, apellido y nombre
    //y opcionalmente: direccion y email
    //Llama al constructor de su clase base
    public Titular(int dni, string? apellido, string? nombre, string? telefono = "", string? direccion = "", string? email = "") : base(dni, apellido, nombre, telefono)
    {
        this.Direccion = direccion;
        this.Email = email;
    }

    public override string ToString()
    {
        string st = $"Titular: | {base.ToString()}";
        st += this.Direccion != "" ? $" - Dirección: {this.Direccion}" : "";
        st += this.Email != "" ? $" - Correo electrónico: {this.Email}" : "";
        return st;
    }
}