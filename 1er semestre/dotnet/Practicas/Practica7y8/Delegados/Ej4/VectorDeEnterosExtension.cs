namespace Ej4;
static class VectorDeEnterosExtension
{
    public static void Print(this int[] vector, string leyenda)
    {
        string st = leyenda;
        if (vector.Length > 0)
        {
            foreach (int n in vector) st += n + ", ";
            st = st.Substring(0, st.Length - 2);
        }
        Console.WriteLine(st);
    }
    public static int[] Seleccionar(this int[] vector, FuncionEntera f)
    {
        int[] vectorReturn = new int[vector.Length];
        for (int i = 0; i < vector.Length; i++)
            vectorReturn[i] = f(vector[i]);
        return vectorReturn;
    }

    public static int[] Donde(this int[] vector, Predicado p)
    {
        int[] vectorReturn = new int[vector.Length];
        int cantElem = 0;
        for (int i = 0; i < vector.Length; i++)
        {
            if (p(vector[i]))
            {
                vectorReturn[cantElem] = vector[i];
                cantElem++;
            }
        }
        Array.Resize(ref vectorReturn, cantElem);
        return vectorReturn;
    }
}