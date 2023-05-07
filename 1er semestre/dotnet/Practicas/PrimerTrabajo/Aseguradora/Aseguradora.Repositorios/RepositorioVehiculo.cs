namespace Aseguradora.Repositorios;

using System.Collections.Generic;
using Aseguradora.Aplicacion;

public class RepositorioVehiculo : IRepositorioVehiculo
{
    public readonly string _nombreRepositorio = "RepositorioPoliza.txt";
    public void AgregarVehiculo(Vehiculo vehiculo)
    {
        using var sw = new StreamWriter(_nombreRepositorio);
        sw.WriteLine(vehiculo.AStringParaTxt());
    }

    public bool EliminarVehiculo(int id)
    {
        throw new NotImplementedException();
    }

    public List<Vehiculo> ListarVehiculos()
    {
        throw new NotImplementedException();
    }

    public bool ModificarVehiculo(Vehiculo vehiculo)
    {
        throw new NotImplementedException();
    }
}