bool esPrimo(int n)
{
    for (int i = 2; i <= Math.Sqrt(n); i++)
    {
        if (n % i == 0)
        {
            return false;
        }
    }
    return true;
}


Console.WriteLine(esPrimo(int.Parse(args[0])));
Console.ReadKey();