double[,] m = new double[,] { { 1.1123, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 } };

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

ImprimirMatrizConFormato(m, "00.00");
Console.ReadKey();