namespace Ej12;

class Cuenta
{
    private double _monto;
    private int _titularDNI;
    private string? _titularNombre;

    public Cuenta()
    {
        _titularNombre = "No especificado";
        _titularDNI = -1;
        _monto = 0;
    }

    public Cuenta(int titularDNI) : this()
    {
        _titularDNI = titularDNI;
    }

    public Cuenta(string titularNombre) : this()
    {
        _titularNombre = titularNombre;
    }
    public Cuenta(string titularNombre, int titularDNI) : this()
    {
        _titularNombre = titularNombre;
        _titularDNI = titularDNI;
    }

    public void Imprimir()
    {
        string st = $"Nombre: {_titularNombre}, DNI: ";
        st += _titularDNI == -1 ? "No especificado" : _titularDNI.ToString();
        st += $", Monto: {_monto}";
        Console.WriteLine(st);
    }

    public void Depositar(double monto)
    {
        _monto += monto;
    }
    public void Extraer(double monto)
    {
        if (_monto >= monto)
        {
            _monto -= monto;
        }
        else
        {
            Console.WriteLine("Operación cancelada, monto insuficiente");
        }
    }
}