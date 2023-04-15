namespace EJ5;

public class Hora
{
    int _dias, _horas, _minutos;
    double _segundos;
    public Hora(int dias, int horas, int minutos, int segundos)
    {
        _minutos = segundos / 60;
        _segundos = segundos % 60;
        _minutos += minutos;
        _horas = _minutos / 60;
        _minutos %= 60;
        _horas += horas;
        _dias = _horas / 24;
        _horas %= 24;
        _dias += dias;
    }

    public Hora(double dias)
    {
        _dias = (int)Math.Truncate(dias);
        double h = 24 * (dias - Math.Truncate(dias));
        _horas = (int)h;
        double m = 60 * (h - Math.Truncate(h));
        _minutos = (int)m;
        double s = 60 * (m - Math.Truncate(m));
        _segundos = s;
    }

    public void Imprimir()
    {
        string st = $"{_dias} dia";
        st += _dias != 1 ? "s" : "";
        st += $", {_horas} hora";
        st += _horas != 1 ? "s" : "";
        st += $", {_minutos} minuto";
        st += _minutos != 1 ? "s" : "";
        if (_segundos == (int)_segundos)
        {
            st += $" y {_segundos.ToString("0")} segundo";
            st += _segundos != 1 ? "s" : "";
        }
        else
        {
            st += $" y {_segundos.ToString("0.000")} segundo";
            st += _segundos != 1 ? "s" : "";
        }
        Console.WriteLine(st);
    }
}