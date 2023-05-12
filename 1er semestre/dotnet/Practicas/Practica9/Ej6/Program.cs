using Ej6;
Nodo<int> nodo1 = new Nodo<int>(5);
Agregar(nodo1, 1, 10, 3, 4, 56, 22, 31, 0, 15, 14);
Imprimir(nodo1);
Nodo<string> nodo2 = new Nodo<string>("hola");
Agregar(nodo2, "Mundo", "XYZ", "ABC", "nada");
Imprimir(nodo2);

void Agregar<T>(Nodo<T> nodo, params T[] vElem) where T : IComparable
{
    foreach (T elem in vElem)
    {
        nodo.Insertar(elem);
    }
}

void Imprimir<T>(Nodo<T> n) where T : IComparable
{
    foreach (T? elem in n.InOrder)
    {
        Console.Write(elem + " ");
    }
    Console.WriteLine();
    Console.WriteLine($"Altura: {n.Altura}");
    Console.WriteLine($"Cantidad: {n.CantNodos}");
    Console.WriteLine($"Mínimo: {n.ValorMinimo}");
    Console.WriteLine($"Máximo: {n.ValorMaximo}");
}