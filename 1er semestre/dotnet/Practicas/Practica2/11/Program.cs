Console.WriteLine("Cadena: ");
string st;
st = Console.ReadLine();
string[] words = st.Split();
foreach (string word in words)
{
    Console.WriteLine(word);
}
Console.ReadKey();