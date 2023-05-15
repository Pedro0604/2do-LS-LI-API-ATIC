// See https://aka.ms/new-console-template for more information
Console.WriteLine("Ingrese su nombre:");
string st = Console.ReadLine();
if (st=="Juan"){
    Console.WriteLine("Hola Amigo");
}
else if(st=="María"){
    Console.WriteLine("Buen día señora");
}
else if(st=="Alberto"){
    Console.WriteLine("Hola "+st);
}
else if(st!=""){
    Console.WriteLine("Buen día "+st);
}
else{
    Console.WriteLine("Buen día mundo");
}
Console.ReadKey(false);

switch (st)
{
    case "Juan":Console.WriteLine("Hola Amigo");
        break;
    case "María":Console.WriteLine("Buen día señora");
        break;
    case "Alberto":Console.WriteLine("Hola Alberto");
        break;
    case "":Console.WriteLine("Buen día mundo");
        break;
    default:
        Console.WriteLine("Buen día "+st);
        break;
}

Console.ReadKey(false);