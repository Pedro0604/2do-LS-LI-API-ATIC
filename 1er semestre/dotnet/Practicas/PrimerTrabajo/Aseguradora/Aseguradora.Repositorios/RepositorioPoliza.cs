namespace Aseguradora.Repositorios;

using Aseguradora.Aplicacion;

public class RepositorioPoliza : IRepositorioPoliza
{
    public readonly string _nombreRepositorio = "RepositorioPoliza.txt";
    public void AgregarPoliza(Poliza poliza)
    {
        using var sw = new StreamWriter(_nombreRepositorio, true);
        sw.WriteLine(poliza.AStringParaTxt());
    }

    public void EliminarPoliza(int id)
    {
        var list = ListarPolizas();
        if (list.RemoveAll(poliza => poliza.Id == id) == 0)
        {
            throw new Exception($"La poliza de id {id} no existe");
        }
        using var sw = new StreamWriter(_nombreRepositorio);
        foreach (var p in list)
        {
            sw.WriteLine(p.AStringParaTxt());
        }
    }

    public void ModificarPoliza(Poliza poliza)
    {
        var list = ListarPolizas();
        var index = list.FindIndex(p => p.Id == poliza.Id);
        if (index == -1)
        {
            throw new Exception($"La poliza de id {poliza.Id} no existe");
        }
        else
        {
            list[index] = poliza;
        }
        using var sw = new StreamWriter(_nombreRepositorio);
        foreach (var p in list)
        {
            sw.WriteLine(p.AStringParaTxt());
        }
    }

    public List<Poliza> ListarPolizas()
    {
        using var sr = new StreamReader(_nombreRepositorio);
        var list = new List<Poliza>();
        while (!sr.EndOfStream)
        {
            list.Add(new Poliza(sr.ReadLine() ?? ""));
        }
        return list;
    }
}