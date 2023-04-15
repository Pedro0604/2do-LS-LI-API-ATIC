namespace Ej1;

class Cuenta
{
    double _saldo;
    int _idCuenta;
    static int s_id = 0, s_cantDep = 0, s_cantExt = 0, s_cantOpDeneg = 0;
    static double s_totDep = 0, s_totExt = 0, s_totSaldo = 0;
    static List<Cuenta> s_cuentas = new List<Cuenta>();

    public static List<Cuenta> Cuentas
    {
        get
        {
            return new List<Cuenta>(s_cuentas);
        }
    }

    public Cuenta()
    {
        _saldo = 0;
        _idCuenta = ++s_id;
        s_cuentas.Add(this);
        Console.WriteLine("Se creó la cuenta Id=" + _idCuenta);
    }

    public Cuenta Depositar(double monto)
    {
        _saldo += monto;
        s_cantDep++;
        s_totDep += monto;
        s_totSaldo += monto;
        Console.WriteLine($"Se depositó {monto} en la cuenta {_idCuenta} (Saldo={_saldo})");
        return this;
    }
    public Cuenta Extraer(double monto)
    {
        if (_saldo >= monto)
        {
            _saldo -= monto;
            s_cantExt++;
            s_totExt += monto;
            s_totSaldo -= monto;
            Console.WriteLine($"Se extrajo {monto} de la cuenta {_idCuenta} (Saldo={_saldo})");

        }
        else
        {
            s_cantOpDeneg++;
            Console.WriteLine("Operación denegada - Saldo insuficiente");
        }
        return this;
    }
    public static void ImprimirDetalle()
    {
        Console.WriteLine(string.Format("{0,-16} {1,-2}", "CUENTAS CREADAS:", s_id));
        Console.WriteLine(string.Format("{0,-16} {1,-2} - {2,-17}   {3,-4}", "DEPÓSITOS: ", s_cantDep, "Total depositado:", s_totDep));
        Console.WriteLine(string.Format("{0,-16} {1,-2} - {2,-17}   {3,-4}", "EXTRACCIONES: ", s_cantExt, "Total extraído:", s_totExt));
        Console.WriteLine(string.Format("{0,-16} {1,-2} - {2,-17}   {3,-4}", "", "", "Saldo:", s_totSaldo));
        Console.WriteLine($"* Se denegaron {s_cantOpDeneg} extracciones por falta de fondos");
    }
}