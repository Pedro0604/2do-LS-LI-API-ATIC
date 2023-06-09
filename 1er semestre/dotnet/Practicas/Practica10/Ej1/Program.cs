var listaMultiplosDeCinco = Enumerable.Range(100, 101).Where(x => x % 5 == 0).ToList();
var listaPrimosMenoresACien = Enumerable.Range(2, 100000).Where(x =>
{
    for (int i = 2; i <= Math.Sqrt(x); i++)
    {
        if (x % i == 0) return false;
    }
    return true;
}).ToList();

var listaPotenciasDeDos = Enumerable.Range(0, 11).Select(x => Math.Pow(2, x)).ToList();
var sumaPotenciasDeDos = listaPotenciasDeDos.Sum();
var PromedioPotenciasDeDos = listaPotenciasDeDos.Average();
var listaNCuadradoConUltimoDigito6 = Enumerable.Range(1, 20).Select(x => Math.Pow(x, 2)).Where(x => x % 10 == 6).ToList();
var listaNombresDeLaSemanaConU = Enumerable.Range(0, 7).Select(x => (DayOfWeek)x).Where(x => x.ToString().Contains("u")).ToList();


ImprimirLista(listaMultiplosDeCinco);
DateTime inicio = DateTime.Now;
ImprimirLista(listaPrimosMenoresACien);
Console.WriteLine("Cantidad: " + listaPrimosMenoresACien.Count);
double mlseg = (DateTime.Now - inicio).TotalMilliseconds;
Console.WriteLine("Tiempo total: " + mlseg);
ImprimirLista(listaPotenciasDeDos);
Console.WriteLine(sumaPotenciasDeDos);
Console.WriteLine(PromedioPotenciasDeDos);
ImprimirLista(listaNCuadradoConUltimoDigito6);
ImprimirLista(listaNombresDeLaSemanaConU);
Sumatoria();

void ImprimirLista<T>(List<T> l)
{
    string st = "";
    foreach (T item in l)
    {
        st += item + " - ";
    }
    st = st.Remove(st.Length - 3);
    Console.WriteLine(st);
}

void Sumatoria()
{
    long cant = 0;
    for (long i = 2; i <= 100000; i++)
    {
        cant += (long)Math.Floor(Math.Sqrt(i)) - 2;
    }
    Console.WriteLine("");
    Console.WriteLine("Cant: " + cant);
}