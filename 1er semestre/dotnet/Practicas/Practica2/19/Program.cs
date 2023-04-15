void Imprimir(params object[] v)
{
    foreach (object item in v)
    {
        Console.Write(item.ToString() + " ");
    }
}
Imprimir(1, "casa", 'A', 3.4);
Console.ReadKey();