namespace EJ4;

public class Hora
{
    int _dias, _horas, _minutos, _segundos;
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

    public string ToString()
    {
        string st = $"{_dias} dia";
        st += _dias != 1 ? "s" : "";
        st += $", {_horas} hora";
        st += _horas != 1 ? "s" : "";
        st += $", {_minutos} minuto";
        st += _minutos != 1 ? "s" : "";
        st += $" y {_segundos} segundo";
        st += _segundos != 1 ? "s" : "";
        return st;
    }

    public void Imprimir()
    {
        Console.WriteLine(this.ToString());
    }
}