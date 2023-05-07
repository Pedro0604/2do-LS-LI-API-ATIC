namespace Aseguradora.Repositorios;

using System.Collections.Generic;
using Aseguradora.Aplicacion;

public class RepositorioTitular : IRepositorioTitular
{
    public readonly string _nombreRepositorio = "RepositorioPoliza.txt";
    public void AgregarTitular(Titular titular)
    {
        using var sw = new StreamWriter(_nombreRepositorio);
        sw.WriteLine(titular.AStringParaTxt());
    }

    public bool EliminarTitular(int id)
    {
        throw new NotImplementedException();
    }

    public List<Titular> ListarTitulares()
    {
        throw new NotImplementedException();
    }

    public List<string> ListarTitularesConSusVehiculos()
    {
        throw new NotImplementedException();
    }

    public bool ModificarTitular(Titular titular)
    {
        throw new NotImplementedException();
    }
}