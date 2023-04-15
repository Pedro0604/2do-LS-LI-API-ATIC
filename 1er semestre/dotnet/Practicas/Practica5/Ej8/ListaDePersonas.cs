namespace Ej8;
using Ej7;

class ListaDePersonas
{
    private List<Persona> lista = new List<Persona>();
    public void Agregar(Persona p)
    {
        lista.Add(p);
    }
    public Persona? this[int dni]
    {
        get
        {
            for (int i = 0; i < lista.Count; i++)
            {
                if (lista[i].DNI == dni) return lista[i];
            }
            return null;
        }
    }

    public List<string> this[char c]
    {
        get
        {
            List<string> result = new List<string>();
            for (int i = 0; i < lista.Count; i++)
            {
                if (lista[i].Nombre.ToCharArray()[0] == c) result.Add(lista[i].Nombre);
            }
            return result;
        }
    }
}
