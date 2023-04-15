string? st = null, st1 = "Hola1", st2 = null, st3 = "Hola3", st4 = null;

// if (st1 == null)
// {
//     if (st2 == null)
//     {
//         st = st3;
//     }
//     else
//     {
//         st = st2;
//     }
// }
// else
// {
//     st = st1;
// }
// if (st4 == null)
// {
//     st4 = "valor por defecto";
// }
st = st1 ?? st2 ?? st3;
st4 ??= "valor por defecto";
Console.WriteLine(st);
Console.WriteLine(st1);
Console.WriteLine(st2);
Console.WriteLine(st3);
Console.WriteLine(st4);
Console.ReadKey();