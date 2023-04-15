Console.WriteLine("Ingrese un entero: ");
int n = int.Parse(Console.ReadLine());
n *= 365;
int dig;
while (n != 0){
    Console.WriteLine("num: " + n);
    dig = n % 10;
    Console.WriteLine(dig + " ");
    n /= 10;
}
Console.ReadKey();