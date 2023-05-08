namespace Aseguradora.Aplicacion;

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

    //Constructor que recibe un array de string con la información de la persona con el formato que tienen los repositorios
    public Persona(string[] infoPersona)
    {
        try
        {
            //Se setean las propiedades de la Persona
            Id = int.Parse(infoPersona[0]);
            DNI = int.Parse(infoPersona[1]);
            Apellido = infoPersona[2];
            Nombre = infoPersona[3];
            Telefono = infoPersona[4];
        }
        catch
        {
            Console.WriteLine("El formato de la cadena enviada no corresponde con el de un " + this.GetType().Name);
        }
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
        st += this.Telefono != "" ? $" - Telefono: {this.Telefono}" : "";
        return st;
    }

    //Se transforma la Persona en un string con el formato que tienen los repositorios
    public virtual string AStringParaTxt()
    {
        return $"{this.Id}|{this.DNI}|{this.Apellido}|{this.Nombre}|{this.Telefono}";
    }
}