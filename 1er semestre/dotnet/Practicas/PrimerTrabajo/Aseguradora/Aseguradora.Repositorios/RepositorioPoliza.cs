namespace Aseguradora.Repositorios;

using Aseguradora.Aplicacion;

public class RepositorioPoliza : IRepositorioPoliza
{
    public readonly string _nombreRepositorio = "RepositorioPoliza.txt";
    public void AgregarPoliza(Poliza poliza)
    {
        using var sw = new StreamWriter(_nombreRepositorio);
        sw.WriteLine(poliza.AStringParaTxt());
    }

    public bool EliminarPoliza(int id)
    {
        throw new NotImplementedException();
    }

    public List<Poliza> ListarPolizas()
    {
        throw new NotImplementedException();
    }

    public bool ModificarPoliza(Poliza poliza)
    {
        throw new NotImplementedException();
    }
}