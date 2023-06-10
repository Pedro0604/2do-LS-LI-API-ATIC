namespace Aseguradora.Aplicacion.Entidades;

//Clase derivada de la clase Persona
public class Tercero : Persona
{
    public string? NombreAseguradora { get; set; }
    public int SiniestroId { get; set; }
}