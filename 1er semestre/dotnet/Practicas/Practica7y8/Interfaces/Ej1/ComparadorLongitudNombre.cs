namespace Ej1;

public class ComparadorLongitudNombre : System.Collections.IComparer
{
    public int Compare(object? x, object? y)
    {
        int result = 0;
        if ((x is INombrable xNombrable) && (y is INombrable yNombrable))
        {
            result = xNombrable.Nombre.Length - yNombrable.Nombre.Length;
        }
        return result;
    }
}