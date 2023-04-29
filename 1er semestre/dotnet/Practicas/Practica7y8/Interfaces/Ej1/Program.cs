using Ej1;

// Ejercicio 1
Console.WriteLine("Ejercicio 1: ");
Auto auto = new Auto();
Libro libro = new Libro();
Persona persona = new Persona();
Perro perro = new Perro();
Pelicula pelicula = new Pelicula();
Procesador.Alquilar(pelicula, persona);
Procesador.Alquilar(libro, persona);
Procesador.Atender(persona);
Procesador.Atender(perro);
Procesador.Devolver(pelicula, persona);
Procesador.Devolver(libro, persona);
Procesador.Lavar(auto);
Procesador.Reciclar(libro);
Procesador.Reciclar(auto);
Procesador.Secar(auto);
Procesador.Vender(auto, persona);
Procesador.Vender(perro, persona);

//Ejercicio 2
Console.WriteLine();
Console.WriteLine("Ejercicio 2: ");
Procesador.Lavar(perro);
Procesador.Secar(perro);
PeliculaClasica peliculaClasica = new PeliculaClasica();
Procesador.Alquilar(peliculaClasica, persona);
Procesador.Devolver(peliculaClasica, persona);
Procesador.Vender(peliculaClasica, persona);

//Ejercicio 3
Console.WriteLine();
Console.WriteLine("Ejercicio 3: ");
var lista = new List<object>() {
new Persona(),
new Auto()
};
foreach (IComercial c in lista)
{
    c.Importa();
}
foreach (IImportante i in lista)
{
    i.Importa();
}
(lista[0] as Persona)?.Importa();
(lista[1] as Auto)?.Importa();

//Ejercicio 4
Console.WriteLine();
Console.WriteLine("Ejercicio 4: ");
var vector = new INombrable[] {
new Persona() { Nombre = "Zulema" },
new Perro() { Nombre = "Sultán" },
new Persona() { Nombre = "Claudia" },
new Persona() { Nombre = "Carlos" },
new Perro() { Nombre = "Chopper" },
};
Array.Sort(vector); //debe ordenar por Nombre alfabéticamente
foreach (INombrable n in vector)
{
    Console.WriteLine($"{n.Nombre}: {n}");
}

//Ejercicio 5
Console.WriteLine();
Console.WriteLine("Ejercicio 5: ");
vector = new INombrable[] {
new Persona() {Nombre="Zulema"},
new Perro() {Nombre="Sultán"},
new Persona() {Nombre="Claudia"},
new Persona() {Nombre="Carlos"},
new Perro() {Nombre="Chopper"},
};
Array.Sort(vector); //debe ordenar por Nombre alfabéticamente
foreach (INombrable n in vector)
{
    Console.WriteLine($"{n.Nombre}: {n}");
}

//Ejercicio 5
Console.WriteLine();
Console.WriteLine("Ejercicio 5: ");
vector = new INombrable[] {
new Persona() {Nombre="Ana María"},
new Perro() {Nombre="Sultán"},
new Persona() {Nombre="Ana"},
new Persona() {Nombre="José Carlos"},
new Perro() {Nombre="Chopper"}
};
Array.Sort(vector, new ComparadorLongitudNombre());//ordena por longitud de Nombre
foreach (INombrable n in vector)
{
    Console.WriteLine($"{n.Nombre.Length}: {n.Nombre}");
}
