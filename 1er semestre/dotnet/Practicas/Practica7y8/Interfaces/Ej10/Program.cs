using Ej9;

void IngeresarAutosPorConsola(List<Auto> listaAutos)
{
    Auto aux;
    Console.Write("Ingrese la marca del auto: ");
    string? marca = Console.ReadLine();
    string? modelo;
    while (marca != "")
    {
        Console.Write("Ingrese el modelo del auto: ");
        modelo = Console.ReadLine();
        listaAutos.Add(new Auto(marca, int.Parse(modelo != "" ? modelo ?? "-1" : "-1")));
        Console.Write("Ingrese la marca del auto: ");
        marca = Console.ReadLine();
    }
}

void CargarAutosDesdeDisco(List<Auto> listaAutos)
{
    Auto aux;
    string[]? linea;
    using var sr = new StreamReader("Autos.txt");
    while (!sr.EndOfStream)
    {
        linea = sr.ReadLine()?.Split("|");
        listaAutos.Add(new Auto(linea[0], int.Parse(linea[1])));
    }
    Console.WriteLine("Lista cargada desde disco");
}

void GuardarAutosEnDisco(List<Auto> listaAutos)
{
    using var sw = new StreamWriter("Autos.txt");
    foreach (Auto a in listaAutos)
    {
        sw.WriteLine(a.ToTextFile());
    }
    Console.WriteLine("Lista guardada en disco");
}

void ListarAutosPorConsola(List<Auto> listaAutos)
{
    Console.WriteLine("Autos: ");
    foreach (Auto a in listaAutos)
    {
        Console.WriteLine(a);
    }
}

var listaAutos = new List<Auto>();

ConsoleKeyInfo tecla;
do
{
    Console.WriteLine("Menú de opciones");
    Console.WriteLine("================");
    Console.WriteLine("");
    Console.WriteLine("  1. Ingresar autos desde la consola");
    Console.WriteLine("  2. Cargar lista de autos desde el disco");
    Console.WriteLine("  3. Guardar lista de autos en el disco");
    Console.WriteLine("  4. Listar por consola");
    Console.WriteLine("  5. Salir");
    Console.Write("Ingrese su opción: ");
    tecla = Console.ReadKey();
    Console.WriteLine();
    switch (tecla.KeyChar)
    {
        case '1': IngeresarAutosPorConsola(listaAutos); break;
        case '2': CargarAutosDesdeDisco(listaAutos); break;
        case '3': GuardarAutosEnDisco(listaAutos); break;
        case '4': ListarAutosPorConsola(listaAutos); break;
    }
} while (tecla.KeyChar != '5');
