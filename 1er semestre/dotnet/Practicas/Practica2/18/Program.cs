void Swap(ref int x, ref int y)
{
    int aux = x;
    x = y;
    y = aux;
}

Console.WriteLine("Numero 1: ");
int num1 = int.Parse(Console.ReadLine());
Console.WriteLine("Numero 2: ");
int num2 = int.Parse(Console.ReadLine());
Swap(ref num1, ref num2);
Console.WriteLine("Numero 1: " + num1 + " Numero 2: " + num2);
Console.ReadKey();