// See https://aka.ms/new-console-template for more information
Console.WriteLine("Introduzca una cadena de caracteres:");
string st = Console.ReadLine();
while (st.Length>0){
    Console.WriteLine("La cadena tiene "+st.Length+" caracteres.");
    Console.WriteLine("Introduzca otra cadena de caracteres:");
    st = Console.ReadLine();
}