Console.WriteLine("Ingrese el nombre de un archivo: ");
var nom = Console.ReadLine();
var dict = new SortedDictionary<string, int>();
using var sr = new StreamReader(nom ?? "");
{
    string line;
    while (!sr.EndOfStream)
    {
        line = sr.ReadLine() ?? "";
        var lStr = line.Split(" ");
        foreach (var str in lStr)
        {
            if (dict.ContainsKey(str))
            {
                dict[str]++;
            }
            else
            {
                dict.Add(str, 1);
            }
        }
    }
}

foreach (var kV in dict)
{
    Console.WriteLine($"{kV.Key}: {kV.Value}");
}
Console.ReadKey();