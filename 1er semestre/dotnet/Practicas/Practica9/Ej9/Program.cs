Console.WriteLine("Ingrese el nombre de un archivo: ");
var nom = Console.ReadLine();
Console.WriteLine("Ingrese el nombre de otro archivo: ");
var nom2 = Console.ReadLine();
var set = new SortedSet<string>();
var set2 = new SortedSet<string>();
string line;
string[] lStr;
using var sr = new StreamReader(nom ?? "");
{
    while (!sr.EndOfStream)
    {
        line = sr.ReadLine() ?? "";
        lStr = line.Split(" ");
        foreach (var str in lStr)
        {
            set.Add(str);
        }
    }
}
using var sr2 = new StreamReader(nom2 ?? "");
{
    while (!sr2.EndOfStream)
    {
        line = sr2.ReadLine() ?? "";
        lStr = line.Split(" ");
        foreach (var str in lStr)
        {
            set2.Add(str);
        }
    }
}

foreach (var str in set.Intersect(set2))
{
    Console.Write($"{str} -");
}
Console.ReadKey();