using Ej8;

void ImprimirArray(double[] a)
{
    for (int i = 0; i < a.Length; i++)
    {
        Console.Write(a[i].ToString("00.00") + " ");
    }
    Console.WriteLine();
    Console.WriteLine();
}

double[,] m = new double[,] { { 1.1123, 2, 3 }, { 6, 7, 8 }, { 11, 12, 13 } };
Matriz matriz = new Matriz(m);
Console.WriteLine("Matriz: ");
matriz.Imprimir();
Console.WriteLine("Matriz con formato: ");
matriz.Imprimir("00.00");
double[][] aDeA = matriz.getArregloDeArreglo();
Console.WriteLine("Arreglo de arreglos: ");
for (int i = 0; i < aDeA.Length; i++)
{
    for (int j = 0; j < aDeA[i].Length; j++)
    {
        Console.Write(aDeA[i][j].ToString("00.00") + " ");
    }
    Console.WriteLine();
}
Console.WriteLine();
Console.WriteLine("Fila 1: ");
ImprimirArray(matriz.GetFila(1));
Console.WriteLine("Columna 1: ");
ImprimirArray(matriz.GetColumna(1));
Console.WriteLine("Diagonal principal: ");
ImprimirArray(matriz.GetDiagonalPrincipal());
Console.WriteLine("Diagonal secundaria: ");
ImprimirArray(matriz.GetDiagonalSecundaria());
matriz.sumarle(matriz);
Console.WriteLine("Suma: ");
matriz.Imprimir("00.00");
matriz.restarle(new Matriz(m));
Console.WriteLine("Resta: ");
matriz.Imprimir("00.00");
matriz.multiplicarPor(matriz);
Console.WriteLine("Multiplicación: ");
matriz.Imprimir("00.00");
Console.ReadKey();