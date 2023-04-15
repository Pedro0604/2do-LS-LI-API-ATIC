double[] GetDiagonalPrincipal(double[,] m)
{
    double[] d = new double[m.GetLength(0)];
    if (m.GetLength(0) != m.GetLength(1))
    {
        throw new ArgumentException("La matriz no es cuadrada");
    }
    else
    {
        for (int i = 0; i < m.GetLength(0); i++)
        {
            d[i] = m[i, i];
        }
    }
    return d;
}

double[] GetDiagonalSecundaria(double[,] m)
{
    double[] d = new double[m.GetLength(0)];
    if (m.GetLength(0) != m.GetLength(1))
    {
        throw new ArgumentException("La matriz no es cuadrada");
    }
    else
    {
        for (int i = 0; i < m.GetLength(0); i++)
        {
            d[i] = m[i, m.GetLength(0) - i - 1];
        }
    }
    return d;
}

void imprimirArray(double[] a)
{
    for (int i = 0; i < a.Length; i++)
    {
        Console.Write(a[i].ToString("00.00") + " ");
    }
    Console.WriteLine();
}

double[,] m = new double[,] { { 1.1123, 2, 3 }, { 6, 7, 8 }, { 13, 14, 15 } };

double[] dp = GetDiagonalPrincipal(m);
double[] ds = GetDiagonalSecundaria(m);

imprimirArray(dp);
imprimirArray(ds);
Console.ReadKey();