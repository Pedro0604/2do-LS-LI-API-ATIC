double[][] GetArregloDeArreglo(double[,] m)
{
    double[][] aDeA = new double[m.GetLength(0)][];
    for (int i = 0; i < m.GetLength(0); i++)
    {
        aDeA[i] = new double[m.GetLength(1)];
        for (int j = 0; j < m.GetLength(1); j++)
        {
            aDeA[i][j] = m[i, j];
        }
    }
    return aDeA;
}

void ImprimirMatrizConFormato(double[,] m, string formatString)
{
    for (int i = 0; i < m.GetLength(0); i++)
    {
        for (int j = 0; j < m.GetLength(1); j++)
        {
            Console.Write(m[i, j].ToString(formatString) + " ");
        }
        Console.WriteLine();
    }
}

double[,] m = new double[,] { { 1.1123, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 } };

double[][] aDeA = GetArregloDeArreglo(m);

Console.WriteLine("Matriz: ");
ImprimirMatrizConFormato(m, "00.00");

Console.WriteLine("Arreglo de arreglos: ");

for (int i = 0; i < aDeA.Length; i++)
{
    for (int j = 0; j < aDeA[i].Length; j++)
    {
        Console.Write(aDeA[i][j].ToString("00.00") + " ");
    }
    Console.WriteLine();
}

Console.ReadKey();