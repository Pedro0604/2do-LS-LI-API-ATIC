char GetLetter(long n)
{
    return (char)(65 + n - 10);
}

void ChangeBase(long n, long b)
{
    Stack<long> pila = new Stack<long>();
    while (n / b >= b)
    {
        pila.Push(n % b);
        n /= b;
    }
    pila.Push(n % b);
    int l = pila.Count + 1;
    Console.Write(n / b);
    l--;
    foreach (long x in pila)
    {
        if (l % 4 == 0)
        {
            Console.Write(' ');
        }
        l--;
        if (x < 10)
        {
            Console.Write(x);
        }
        else
        {
            Console.Write(GetLetter(x));
        }
    }
    Console.WriteLine();
}

ChangeBase(2_314_212_443, 35);
Console.ReadKey();