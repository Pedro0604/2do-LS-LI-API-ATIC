namespace Aseguradora.Aplicacion;

public class Tercero : Persona
{
    public string? NombreAseguradora { get; set; }
    public int SiniestroId { get; set; }

    public override string ToString()
    {
        return "Tercero: | " + base.ToString() + " - Nombre de la aseguradora: " + this.NombreAseguradora + " - Id del siniestro: " + this.SiniestroId + " |";
    }
}