namespace Ej7;

class Persona
{
    public string? Nombre { get; set; }
    public char Sexo { get; set; }
    public int DNI { get; set; }
    public DateTime FechaNacimiento { get; set; }
    public int? Edad { get; }

    public object this[int i]
    {
        get
        {
            return i == 0 ? Nombre : i == 1 ? Sexo : i == 2 ? DNI : i == 3 ? FechaNacimiento : null;
        }
        set
        {
            if (i == 0) Nombre = (string)value;
            else if (i == 1) Sexo = (char)value;
            else if (i == 2) DNI = (int)value;
            else if (i == 3) FechaNacimiento = (DateTime)value;
        }
    }
}