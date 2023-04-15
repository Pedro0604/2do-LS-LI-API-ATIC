for (int i = 0; i < args.Length; i++)
{
    Console.WriteLine("Nombre: " + args[i]);
}

foreach (string name in args)
{
    Console.WriteLine("Nombre: " + name);
}
Console.ReadKey();