int[] vector1 = new int[] { 1, 2, 3 };
bool[] vector2 = new bool[] { true, true, true };
string[] vector3 = new string[] { "uno", "dos", "tres" };
Set<int>(vector1, 110, 2);
Set<bool>(vector2, false, 1);
Set<string>(vector3, "Hola Mundo!", 0);
Imprimir(vector1);
Imprimir(vector2);
Imprimir(vector3);

void Set<T>(T[] v, T elem, int pos)
{
    v[pos] = elem;
}

void Imprimir<T>(T[] v)
{
    foreach (var elem in v)
    {
        Console.Write(elem + " ");
    }
    Console.WriteLine();
}