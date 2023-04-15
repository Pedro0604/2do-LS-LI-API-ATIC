namespace Ej6;

public class Ecuacion2
{
    double _a, _b, _c;

    public Ecuacion2(double a, double b, double c)
    {
        _a = a;
        _b = b;
        _c = c;
    }

    public double GetDiscriminante()
    {
        return Math.Pow(_b, 2) - (4 * _a * _c);
    }

    public int GetCantidadDeRaices()
    {
        return this.GetDiscriminante() < 0 ? 0 : this.GetDiscriminante() == 0 ? 1 : 2;
    }

    public void ImprimirRaices()
    {
        string st;
        if (GetCantidadDeRaices() == 0)
        {
            st = "La ecuación no tiene soluciones reales.";
        }
        else
        {
            double solucion = (-_b + Math.Sqrt(this.GetDiscriminante())) / 2 * _a;
            if (GetCantidadDeRaices() == 1)
            {
                st = $"x={solucion}";
            }
            else
            {
                st = $"x1={solucion}";
                solucion = (-_b - Math.Sqrt(this.GetDiscriminante())) / 2 * _a;
                st += $"\nx2={solucion}";
            }
        }
        Console.WriteLine(st);
    }
}