long FacNotRec(long n)
{
    long res = 1;
    for (long i = n; i > 1; i--)
    {
        res *= i;
    }
    return res;
}

long FacRec(long n)
{
    if (n <= 1)
    {
        return 1;
    }
    else
    {
        return n * FacRec(n - 1);
    }
}

long FacRecExpBodMethod(long n) => n <= 1 ? 1 : n * FacRecExpBodMethod(n - 1);

Console.WriteLine("Numero: ");
long num = long.Parse(Console.ReadLine());
Console.WriteLine("No recursivo: " + FacNotRec(num));
Console.WriteLine("Recursivo: " + FacRec(num));
Console.WriteLine("Recursivo expBodMeth: " + FacRecExpBodMethod(num));
Console.ReadKey();