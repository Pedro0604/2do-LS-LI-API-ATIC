namespace Aseguradora.Aplicacion.Entidades;

//Clase derivada de la clase Persona
public class Tercero : Persona
{
    public string? NombreAseguradora { get; set; }
    public int SiniestroId { get; set; }

    protected Tercero() { }

    //Constructor para inicializar las propiedades
    //que recibe obligatoriamente: dni, apellido, nombre y siniestroId
    //y opcionalmente: telefono y nombreAseguradora
    //Llama al constructor de su clase base
    public Tercero(int dni, string? apellido, string? nombre, int siniestroId, string? telefono = "", string? nombreAseguradora = "") : base(dni, apellido, nombre, telefono)
    {
        this.NombreAseguradora = nombreAseguradora;
        this.SiniestroId = siniestroId;
    }

    public override string ToString()
    {
        string st = $"Tercero: | {base.ToString()} - Id del siniestro: {this.SiniestroId}";
        st += this.NombreAseguradora != "" ? $" - Nombre de la aseguradora: {this.NombreAseguradora}" : "";
        return st;
    }
}