// See https://aka.ms/new-console-template for more information
Console.WriteLine("Introduzca dos cadenas separadas por un espacio: ");
string st = Console.ReadLine();
int i = 0;
bool eq = true;
while(!st[i].Equals(' ') && eq){
    if(!st[i].Equals(st[st.Length-(i+1)])){
        eq=false;
    }
    i++;
}
if(eq){
    Console.WriteLine("Son simetricas");
}
else{
    Console.WriteLine("No son simetricas");
}
Console.ReadKey(false);