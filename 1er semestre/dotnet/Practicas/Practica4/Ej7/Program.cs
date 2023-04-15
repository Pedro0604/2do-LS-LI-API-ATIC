using Ej7;

Nodo n = new Nodo(7);
n.Insertar(8);
n.Insertar(10);
n.Insertar(3);
n.Insertar(1);
n.Insertar(5);
n.Insertar(14);
foreach (int i in n.GetInOrder())
{
    Console.Write(i + " ");
}
Console.WriteLine();
Console.WriteLine(n.GetAltura());
Console.WriteLine(n.GetCantNodos());
Console.WriteLine(n.GetValorMaximo());
Console.WriteLine(n.GetValorMinimo());
Console.ReadKey();