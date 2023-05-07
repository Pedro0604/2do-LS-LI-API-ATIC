namespace Aseguradora.Aplicacion;

public abstract class Persona
{
    public int Id { get; set; }
    public int DNI { get; set; }
    public string? Apellido { get; set; }
    public string? Nombre { get; set; }
    public int Telefono { get; set; }

    public Persona() { }
    public Persona(string[] infoPersona)
    {
        try
        {
            Id = int.Parse(infoPersona[0]);
            DNI = int.Parse(infoPersona[1]);
            Apellido = infoPersona[2];
            Nombre = infoPersona[3];
            Telefono = int.Parse(infoPersona[4]);
        }
        catch
        {
            Console.WriteLine("El formato de la cadena enviada no corresponde con el de un " + this.GetType().Name);
        }
    }

    public override string ToString()
    {
        return $"Id: {this.Id} - DNI: {this.DNI} - Apellido:{this.Apellido} - Nombre: {this.Nombre} - Telefono: {this.Telefono}";
    }

    public virtual string AStringParaTxt()
    {
        return $"{this.Id}|{this.DNI}|{this.Apellido}|{this.Nombre}|{this.Telefono}";
    }
}