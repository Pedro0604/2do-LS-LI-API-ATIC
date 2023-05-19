var listaMultiplosDeCinco = Enumerable.Range(100, 101).Where(x => x % 5 == 0).ToList();
var listaPrimosMenoresACien = Enumerable.Range(2, 10000000).Where(x =>
{
    bool esPrimo = true;
    for (int i = 2; i <= Math.Sqrt(x); i++)
    {
        esPrimo = esPrimo && x % i != 0;
    }
    return esPrimo;
}).ToList();
var listaPotenciasDeDos = Enumerable.Range(0, 11).Select(x => Math.Pow(2, x)).ToList();
var sumaPotenciasDeDos = listaPotenciasDeDos.Sum();
var PromedioPotenciasDeDos = listaPotenciasDeDos.Average();
var listaNCuadradoConUltimoDigito6 = Enumerable.Range(1, 20).Select(x => Math.Pow(x, 2)).Where(x => x % 10 == 6).ToList();
var listaNombresDeLaSemanaConU = Enumerable.Range(0, 7).Select(x => (DayOfWeek)x).Where(x => x.ToString().Contains("u")).ToList();


ImprimirLista(listaMultiplosDeCinco);
ImprimirLista(listaPrimosMenoresACien);
ImprimirLista(listaPotenciasDeDos);
Console.WriteLine(sumaPotenciasDeDos);
Console.WriteLine(PromedioPotenciasDeDos);
ImprimirLista(listaNCuadradoConUltimoDigito6);
ImprimirLista(listaNombresDeLaSemanaConU);

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