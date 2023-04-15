Console.WriteLine("Ingrese un entero: ");
long n = long.Parse(Console.ReadLine());
Console.WriteLine("El numero " + n + " es divisor de el numero " + n + ".");
for (long i = n/2; i > 0; i--){
    if(n % i == 0){
        Console.WriteLine("El numero " + i + " es divisor de el numero " + n + ".");
    }
    Console.WriteLine(i);
}
Console.ReadKey();