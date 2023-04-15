Console.WriteLine("Ingrese un ano: ");
int n = int.Parse(Console.ReadLine());
string msg = "No es bisiesto";
if(n % 4 == 0){
    if(n % 100 != 0){
        msg = "Es bisiesto";
    }
    else{
        if(n % 400 == 0){ 
            msg = "Es bisiesto";
        }
    }
}
Console.WriteLine(msg);
Console.ReadKey();