using Ej1;

Del1 d1 = delegate (int x) { Console.WriteLine(x); };
d1(10);

Del2 d2 = x => Console.WriteLine(x.Length);
d2(new int[] { 2, 4, 6, 8 });

Del3 d3 = x =>
{
    int sum = 0;
    for (int i = 1; i <= x; i++)
    {
        sum += i;
    }
    return sum;
};
int resultado = d3(10);
Console.WriteLine(resultado);

Del4 d4 = new Del4(LongitudPar);
Console.WriteLine(d4("hola mundo"));
bool LongitudPar(string st)
{
    return st.Length % 2 == 0;
}
