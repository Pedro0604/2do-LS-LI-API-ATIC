using Ej5;

Nodo<int> n = new Nodo<int>(7);
n.Insertar(3);
n.Insertar(1);
n.Insertar(5);
n.Insertar(12);
foreach (int elem in n.InOrder)
{
    Console.Write(elem + " ");
}
Console.WriteLine();
Console.WriteLine($"Altura: {n.Altura}");
Console.WriteLine($"Cantidad: {n.CantNodos}");
Console.WriteLine($"Mínimo: {n.ValorMinimo}");
Console.WriteLine($"Máximo: {n.ValorMaximo}");
Nodo<string> n2 = new Nodo<string>("hola");
n2.Insertar("Mundo");
n2.Insertar("XYZ");
n2.Insertar("ABC");
foreach (string? elem in n2.InOrder)
{
    Console.Write(elem + " ");
}
Console.WriteLine();
Console.WriteLine($"Altura: {n2.Altura}");
Console.WriteLine($"Cantidad: {n2.CantNodos}");
Console.WriteLine($"Mínimo: {n2.ValorMinimo}");
Console.WriteLine($"Máximo: {n2.ValorMaximo}");