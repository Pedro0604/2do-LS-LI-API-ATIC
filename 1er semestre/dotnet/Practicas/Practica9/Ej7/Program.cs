using Ej7;

var l = new List<Persona>();
l.Add(new Persona("Pedro", 19));
l.Add(new Persona("Lucia", 22));
l.Add(new Persona("Diana", 54));
l.Add(new Persona("Guillermo", 57));
l.Add(new Persona("Ulises", 8));
l.Add(new Persona("LuciaG", 19));
var lPar = l.ConvertAll(convert);
foreach (var p in lPar)
{
    Console.WriteLine("A: " + p.A + " - B: " + p.B);
}


var conv = convert;

Par<string?, int> convert(Persona p)
{
    return new Par<string?, int>(p.Nombre, p.Edad);
}