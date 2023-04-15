long FibRec(long n)
{
    if (n <= 2)
    {
        return 1;
    }
    else
    {
        return FibRec(n - 1) + FibRec(n - 2);
    }
}

long FibNotRec(long n)
{
    if (n <= 2)
    {
        return 1;
    }
    else
    {
        long num = 0L;
        long ant = 1L;
        long ant2 = 1L;
        for (long i = 2L; i < n; i++)
        {
            num = ant + ant2;
            ant2 = ant;
            ant = num;
        }
        return num;
    }
}

Console.WriteLine("Término: ");
long t = long.Parse(Console.ReadLine());
Console.WriteLine("Fibonnacci recursivo: " + FibRec(t));
Console.WriteLine("Fibonnacci not rec: " + FibNotRec(t));
Console.ReadKey();