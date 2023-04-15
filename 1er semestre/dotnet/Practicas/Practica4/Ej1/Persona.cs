namespace Ej1;

class Persona
{
    string _nombre;
    int _edad, _dni;

    public Persona(string nombre, int edad, int dni)
    {
        _nombre = nombre;
        _edad = edad;
        _dni = dni;
    }

    public string Imprimir()
    {
        return String.Format("{0,10} | {1,4} | {2,10}", _nombre, _edad, _dni);
    }

    public bool esMayorQue(Persona p)
    {
        return this._edad > p._edad;
    }
}