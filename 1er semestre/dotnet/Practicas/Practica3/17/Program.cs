Console.WriteLine("Ingrese una operacion operación binaria: ");
string? op = Console.ReadLine();
byte opCode;
double prOp;
double secOp;
double res = 0;
while (op != "")
{
    opCode = 0;
    prOp = 0;
    secOp = 0;
    try
    {
        foreach (char c in op)
        {
            if (opCode == 0)
            {
                switch (c)
                {
                    case '+': opCode = 1; break;
                    case '-': opCode = 2; break;
                    case '*': opCode = 3; break;
                    case '/': opCode = 4; break;
                    default:
                        {
                            prOp *= 10;
                            prOp += int.Parse(c.ToString());
                            break;
                        }
                }
            }
            else
            {
                secOp *= 10;
                secOp += int.Parse(c.ToString());
            }
        }
        switch (opCode)
        {
            case 1: res = prOp + secOp; break;
            case 2: res = prOp - secOp; break;
            case 3: res = prOp * secOp; break;
            case 4: res = prOp / secOp; break;
            default: throw new InvalidOperationException("No se incluyó ninguna operación.");

        }
        Console.WriteLine(op + " = " + res);
        Console.WriteLine("Ingrese una operacion operación binaria: ");
        op = Console.ReadLine();
    }
    catch (Exception e)
    {
        Console.WriteLine(e.Message);
        Console.WriteLine("Ingrese una operacion operación binaria: ");
        op = Console.ReadLine();
    }
}