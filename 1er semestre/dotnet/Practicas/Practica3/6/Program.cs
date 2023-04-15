double[,]? Suma(double[,] A, double[,] B)
{
    if (A.GetLength(0) != B.GetLength(0) || A.GetLength(1) != B.GetLength(1))
    {
        return null;
    }
    else
    {
        double[,] s = new double[A.GetLength(0), A.GetLength(1)];
        for (int i = 0; i < A.GetLength(0); i++)
        {
            for (int j = 0; j < A.GetLength(1); j++)
            {
                s[i, j] = A[i, j] + B[i, j];
            }
        }
        return s;
    }
}

double[,]? Resta(double[,] A, double[,] B)
{
    if (A.GetLength(0) != B.GetLength(0) || A.GetLength(1) != B.GetLength(1))
    {
        return null;
    }
    else
    {
        double[,] r = new double[A.GetLength(0), A.GetLength(1)];
        for (int i = 0; i < A.GetLength(0); i++)
        {
            for (int j = 0; j < A.GetLength(1); j++)
            {
                r[i, j] = A[i, j] - B[i, j];
            }
        }
        return r;
    }
}

double[,] Multiplicacion(double[,] A, double[,] B)
{
    if (A.GetLength(1) != B.GetLength(0))
    {
        throw new ArgumentException("Invalid");
    }
    else
    {
        double[,] m = new double[A.GetLength(0), B.GetLength(1)];
        for (int i = 0; i < A.GetLength(0); i++)
        {
            for (int j = 0; j < A.GetLength(1); j++)
            {
                double aux = 0;
                for (int k = 0; k < A.GetLength(0); k++)
                {
                    aux += A[i, k] * B[k, j];
                }
                m[i, j] = aux;
            }
        }
        return m;
    }
}

double[,] m = new double[,] { { 1.1123, 2, 3 }, { 6, 7, 8 }, { 11, 12, 13 } };

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
    Console.WriteLine();
}

double[,]? suma = Suma(m, m);
double[,]? resta = Resta(m, m);
double[,] mult = Multiplicacion(m, m);

ImprimirMatrizConFormato(suma, "00.00");
ImprimirMatrizConFormato(resta, "00.00");
ImprimirMatrizConFormato(mult, "00.00");

Console.ReadKey();