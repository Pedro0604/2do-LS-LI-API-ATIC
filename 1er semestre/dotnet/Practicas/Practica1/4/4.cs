// See https://aka.ms/new-console-template for more information
Console.WriteLine("Ingrese su nombre:");
string st = Console.ReadLine();
if (st==""){
    Console.WriteLine("Hola Mundo");
}
else {
    Console.WriteLine("Hola " + st);
}
Console.ReadKey(false);