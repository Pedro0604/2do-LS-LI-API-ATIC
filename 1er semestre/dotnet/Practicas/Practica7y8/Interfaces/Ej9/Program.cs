Console.ForegroundColor = (ConsoleColor)13;
Console.Write("Ingrese un texto: ");
string texto = String.Empty;
string? linea = Console.ReadLine();
while (linea != "")
{
    texto += linea + "\n";
    linea = Console.ReadLine();
}

Console.Write("Ingrese el nombre del archivo donde se guardara el texto: ");
string? nombreArchivo = Console.ReadLine();
if (nombreArchivo != null && nombreArchivo != "" && !nombreArchivo.Contains('/') && !nombreArchivo.Contains('\\') && !nombreArchivo.Contains(':') && !nombreArchivo.Contains('*') && !nombreArchivo.Contains('?') && !nombreArchivo.Contains('"') && !nombreArchivo.Contains('<') && !nombreArchivo.Contains('>') && !nombreArchivo.Contains('|') && nombreArchivo.EndsWith(".txt"))
{
    using var sw = new StreamWriter(nombreArchivo);
    sw.Write(texto);
    Console.Beep(2000, 1000);
    Console.ForegroundColor = (ConsoleColor)10;
    Console.WriteLine("Guardado del archivo exitoso");
}
else
{
    Console.Beep(500, 1000);
    Console.ForegroundColor = (ConsoleColor)12;
    Console.WriteLine("Nombre de archivo incorrecto");
}
Console.ReadKey();
