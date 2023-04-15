int sum = 0;
Console.Write("Ingrese un numero: ");
string st = Console.ReadLine();
while (st != "")
{
    try
    {
        int n = int.Parse(st);
        sum += n;
        Console.WriteLine("Suma: " + sum);
        Console.Write("Ingrese un numero: ");
        st = Console.ReadLine();
    }
    catch (Exception e)
    {
        Console.WriteLine(e.Message);
        Console.Write("Ingrese un numero: ");
        st = Console.ReadLine();
    }
}