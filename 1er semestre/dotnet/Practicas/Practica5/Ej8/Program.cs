using Ej8;
using Ej7;

ListaDePersonas l = new ListaDePersonas();
l.Agregar(new Persona(45613899, "Pedro"));
l.Agregar(new Persona(43254929, "Lucia S"));
l.Agregar(new Persona(44858290, "Lucia G"));
l.Agregar(new Persona(17815854, "Guillermo"));
l.Agregar(new Persona(20645867, "Diana"));
int dni = int.Parse(Console.ReadLine());
while (dni != 0)
{
    Console.WriteLine("Dni: " + dni + " - Persona: " + l[dni]?.Nombre);
    dni = int.Parse(Console.ReadLine());
}

char c = Console.ReadLine().ToCharArray()[0];
while (c != 'z')
{
    Console.WriteLine("Personas con la inicial " + c + ":");
    foreach (string st in l[c])
    {
        Console.WriteLine(st);
    }
    c = Console.ReadLine().ToCharArray()[0];
}