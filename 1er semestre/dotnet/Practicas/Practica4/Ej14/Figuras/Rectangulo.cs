namespace Figuras;
public class Rectangulo
{
    double _base, _altura;

    public Rectangulo(double bas, double altura)
    {
        _base = bas;
        _altura = altura;
    }

    public double GetArea()
    {
        return _base * _altura;
    }
}