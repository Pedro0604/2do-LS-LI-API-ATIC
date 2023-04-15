using Ej1;

List<Persona> IngresarDatos()
{
    List<Persona> listP = new List<Persona>();
    string? line;
    while ((line = Console.ReadLine()) != null)
    {
        string[] stArr = line.Split(',');
        string name = stArr[0];
        int age = int.Parse(stArr[1]);
        int dni = int.Parse(stArr[2]);
        Persona p = new Persona(name, age, dni);
        listP.Add(p);
    }
    return listP;
}

Persona getMenor(List<Persona> listP)
{
    Persona minP = new Persona("", 9999999, -1);
    foreach (Persona p in listP)
    {
        if (minP.esMayorQue(p))
            minP = p;
    }
    return minP;
}

List<Persona> listP = new List<Persona>();

Console.SetIn(new StreamReader("Nombres.txt"));

listP = IngresarDatos();

Console.WriteLine(String.Format("{0,3}| {1,9} | {2,4} | {3,10}", "Nro", "Nombre", "Edad", "DNI"));
Console.WriteLine("----------------------------------");
for (int i = 0; i < listP.Count; i++)
{
    Console.WriteLine(i + 1 + ") |" + listP[i].Imprimir());
}

Console.WriteLine();
Console.WriteLine("La persona mas joven es:");
Console.WriteLine(String.Format("{1,10} | {2,4} | {3,10}", "Nro", "Nombre", "Edad", "DNI"));
Console.WriteLine("------------------------------");
Console.WriteLine(getMenor(listP).Imprimir());


Console.ReadKey();