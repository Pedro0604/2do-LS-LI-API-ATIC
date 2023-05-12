var lista = new List<object> { "hola", 7, 'A' };
string st = Get<string>(lista, 0);
int i = Get<int>(lista, 1);
char c = Get<char>(lista, 2);
Console.WriteLine($"{st} {i} {c}");
Console.ReadLine();

T Get<T>(List<Object> l, int n)
{
    return (T)l[n];
}