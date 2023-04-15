void FacNotRec(long n, out long fnr)
{
    fnr = 1;
    for (long i = n; i > 1; i--)
    {
        fnr *= i;
    }
}

void FacRec(long n, out long fr)
{
    if (n <= 1)
    {
        fr = 1;
    }
    else
    {
        long r;
        FacRec(n - 1, out r);
        fr = n * r;
    }
}

Console.WriteLine("Numero: ");
long num = long.Parse(Console.ReadLine());
long res;
FacNotRec(num, out res);
Console.WriteLine("No recursivo: " + res);
FacRec(num, out res);
Console.WriteLine("Recursivo: " + res);
Console.ReadKey();