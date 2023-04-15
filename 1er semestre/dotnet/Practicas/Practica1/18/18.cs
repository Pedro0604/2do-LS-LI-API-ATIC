for (int i = 0; i <= 4; i++)
{
string st = i < 3 ? i == 2 ? "dos" : i == 1 ? "uno" : "< 1" : i < 4 ? "tres" : "> 3";
Console.WriteLine(st);
}