namespace Aseguradora.Repositorios;

using System.Collections.Generic;
using Aseguradora.Aplicacion;

public class RepositorioVehiculo : IRepositorioVehiculo
{
    public readonly string _nombreRepositorio = "RepositorioVehiculo.txt";
    public void AgregarVehiculo(Vehiculo vehiculo)
    {
        using var sw = new StreamWriter(_nombreRepositorio, true);
        sw.WriteLine(vehiculo.AStringParaTxt());
        var listarTit = new ListarTitularesUseCase(new RepositorioTitular());
        var lTit = listarTit.Ejecutar();
        var titular = lTit.Find(t => t.Id == vehiculo.TitularId);
        if (titular == null)
        {
            throw new Exception($"El titular del vehiculo, con Id {vehiculo.TitularId} no existe");
        }
        else
        {
            titular.ListaVehiculos.Add(vehiculo);
        }
    }

    public void EliminarVehiculo(int id)
    {
        var list = ListarVehiculos();
        if (list.RemoveAll(vehiculo => vehiculo.Id == id) == 0)
        {
            throw new Exception($"El vehiculo de id {id} no existe");
        }
        using var sw = new StreamWriter(_nombreRepositorio);
        foreach (var v in list)
        {
            sw.WriteLine(v.AStringParaTxt());
        }
    }

    public void ModificarVehiculo(Vehiculo vehiculo)
    {
        var list = ListarVehiculos();
        var index = list.FindIndex(v => v.Id == vehiculo.Id);
        if (index == -1)
        {
            throw new Exception($"La vehiculo de id {vehiculo.Id} no existe");
        }
        else
        {
            list[index] = vehiculo;
        }
        using var sw = new StreamWriter(_nombreRepositorio);
        foreach (var v in list)
        {
            sw.WriteLine(v.AStringParaTxt());
        }
    }

    public List<Vehiculo> ListarVehiculos()
    {
        using var sr = new StreamReader(_nombreRepositorio);
        var list = new List<Vehiculo>();
        while (!sr.EndOfStream)
        {
            list.Add(new Vehiculo(sr.ReadLine() ?? ""));
        }
        return list;
    }
}