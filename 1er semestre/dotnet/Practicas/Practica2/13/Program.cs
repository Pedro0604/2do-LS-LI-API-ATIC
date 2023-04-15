for (Meses mes = Meses.Diciembre; mes >= Meses.Enero; mes--)
{
    Console.WriteLine(mes);
}
Console.WriteLine("Texto: ");
string st = Console.ReadLine();
bool esMes = false;
for (Meses mes = Meses.Enero; mes <= Meses.Diciembre; mes++)
{
    if (mes.ToString().ToLower() == st.ToLower())
    {
        esMes = true;
    }
}
if (esMes)
{
    Console.WriteLine("El texto ingresado es un mes.");
}
else
{
    Console.WriteLine("El texto ingresado no es un mes.");
}

Console.ReadKey();





enum Meses
{
    Enero, Febrero, Marzo, Abril, Mayo, Junio, Julio, Agosto, Septiembre, Octubre, Noviembre, Diciembre
}