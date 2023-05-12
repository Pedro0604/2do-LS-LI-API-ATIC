namespace Ej10;

class PalabraPosiciones
{
    public PalabraPosiciones(string palabra, List<List<int>> posiciones)
    {
        Palabra = palabra;
        Posiciones = posiciones;
    }

    public string Palabra { private set; get; }
    public List<List<int>> Posiciones { private set; get; } = new List<List<int>>();


}