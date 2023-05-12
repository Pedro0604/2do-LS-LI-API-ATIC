string[] vector1 = CrearArreglo<string>("uno", "dos");
foreach (string st in vector1) Console.Write(st + " - ");
Console.WriteLine();
double[] vector2 = CrearArreglo<double>(1, 2.3, 4.1, 6.7);
foreach (double valor in vector2) Console.Write(valor + " - ");
Console.WriteLine();
var stb = new System.Text.StringBuilder();
var a = GetNuevoObjetoDelMismoTipo(stb);
var b = GetNuevoObjetoDelMismoTipo(17);
Console.WriteLine(a.GetType());
Console.WriteLine(b.GetType());

T[] CrearArreglo<T>(params T[] v)
{
    T[] v2 = new T[v.Length];
    for (int i = 0; i < v.Length; i++)
    {
        v2[i] = v[i];
    }
    return v2;
}

T GetNuevoObjetoDelMismoTipo<T>(T elem) where T : new()
{
    return new T();
}