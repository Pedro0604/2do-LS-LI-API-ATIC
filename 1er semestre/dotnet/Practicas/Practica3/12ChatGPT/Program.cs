
// Definir la clave repetitiva
int[] clave = { 5, 3, 9, 7 };

// Definir el mensaje a cifrar
string mensaje = "HOLA MUNDO";

// Cifrar el mensaje
string mensajeCifrado = Cifrar(mensaje, clave);
Console.WriteLine("Mensaje cifrado: " + mensajeCifrado);

// Descifrar el mensaje
string mensajeDescifrado = Descifrar(mensajeCifrado, clave);
Console.WriteLine("Mensaje descifrado: " + mensajeDescifrado);

Console.ReadKey();

static string Cifrar(string mensaje, int[] clave)
{
    Queue<int> colaClave = new Queue<int>(clave); // Crear una cola con la clave repetitiva
    string mensajeCifrado = "";
    foreach (char c in mensaje)
    {
        int valor = ObtenerValor(c); // Obtener el valor numérico del carácter
        int desplazamiento = colaClave.Dequeue(); // Obtener el siguiente valor de la clave y eliminarlo de la cola
        colaClave.Enqueue(desplazamiento); // Añadir el valor de vuelta al final de la cola
        valor += desplazamiento; // Aplicar el desplazamiento
        if (valor > 28) valor -= 28; // Si el valor resultante es mayor que 28, volver a empezar desde 1
        char cCifrado = ObtenerCaracter(valor); // Convertir el valor cifrado en el carácter correspondiente
        mensajeCifrado += cCifrado; // Añadir el carácter cifrado al mensaje cifrado
    }
    return mensajeCifrado;
}

static string Descifrar(string mensajeCifrado, int[] clave)
{
    Queue<int> colaClave = new Queue<int>(clave); // Crear una cola con la clave repetitiva
    string mensajeDescifrado = "";
    foreach (char c in mensajeCifrado)
    {
        int valorCifrado = ObtenerValor(c); // Obtener el valor numérico del carácter cifrado
        int desplazamiento = colaClave.Dequeue(); // Obtener el siguiente valor de la clave y eliminarlo de la cola
        colaClave.Enqueue(desplazamiento); // Añadir el valor de vuelta al final de la cola
        int valor = valorCifrado - desplazamiento; // Aplicar el desplazamiento inverso
        if (valor < 1) valor += 28; // Si el valor resultante es menor que 1, volver a empezar desde 28
        char cDescifrado = ObtenerCaracter(valor); // Convertir el valor descifrado en el carácter correspondiente
        mensajeDescifrado += cDescifrado; // Añadir el carácter descifrado al mensaje descifrado
    }
    return mensajeDescifrado;
}

static int ObtenerValor(char c)
{
    // Convertir el carácter en el valor numérico correspondiente según la tabla de valores
    switch (c)
    {
        case ' ': return 28;
        case 'Ñ': return 15;
        default: return ((int)c - 64) < 15 ? (int)c - 64 : (int)c - 64 + 1;
    }
}

static char ObtenerCaracter(int valor)
{
    // Convertir el valor numérico en el carácter correspondiente según la tabla de valores
    switch (valor)
    {
        case 28: return ' ';
        case 15: return 'Ñ';
        default: return (char)(valor - (valor > 15 ? 1 : 0) + 64);
    }
}
