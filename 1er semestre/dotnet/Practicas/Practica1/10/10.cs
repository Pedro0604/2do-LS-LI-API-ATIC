// See https://aka.ms/new-console-template for more information
Console.WriteLine("Hello, World!");
for (int i = 1; i <1000;i++){
    if(i % 17 == 0 || i % 29 == 0){
        Console.WriteLine("El numero "+i+" es múltiplo de 17 o de 29");
    }
}
Console.ReadKey();