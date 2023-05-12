using Ej10;

var nom = "juan.juan";
var nom2 = "julio.julio";

// Console.WriteLine("Ingrese el nombre de un archivo: ");
// nom = Console.ReadLine();
// Console.WriteLine("Ingrese el nombre de otro archivo: ");
// nom2 = Console.ReadLine();
string text1;
string text2;
var l1 = new List<string>();
var l2 = new List<string>();
string[] lStr;
using var sr = new StreamReader(nom ?? "");
{
    text1 = sr.ReadToEnd();
    lStr = text1.Split(" ");
    foreach (var str in lStr)
    {
        l1.Add(str);
    }
}
using var sr2 = new StreamReader(nom2 ?? "");
{
    text2 = sr2.ReadToEnd();
    lStr = text2.Split(" ");
    foreach (var str in lStr)
    {
        l2.Add(str);
    }
}
List<string> lParabras = new(l1.Intersect(l2));
lParabras.Sort();
List<PalabraPosiciones> lPalPos = lParabras.ConvertAll(st =>
{
    var pos = new List<List<int>>();
    pos.Add(new());
    pos.Add(new());

    var index = text1.IndexOf(st);
    while (index != -1)
    {
        pos[0].Add(index);
        index = text1.IndexOf(st, index + st.Length);
    }

    index = text2.IndexOf(st);
    while (index != -1)
    {
        pos[1].Add(index);
        index = text2.IndexOf(st, index + st.Length);
    }

    return new PalabraPosiciones(st, pos);
});


foreach (var PalPos in lPalPos)
{
    Console.WriteLine($"Palabra: '{PalPos.Palabra}' -");
    for (int i = 0; i < PalPos.Posiciones.Count; i++)
    {
        Console.Write($"|--Posiciones en el Texto{i}:--> ");
        foreach (var pos in PalPos.Posiciones[i])
        {
            Console.Write(pos + " ");
        }
        Console.WriteLine();
    }
    Console.WriteLine();
}
Console.ReadKey();