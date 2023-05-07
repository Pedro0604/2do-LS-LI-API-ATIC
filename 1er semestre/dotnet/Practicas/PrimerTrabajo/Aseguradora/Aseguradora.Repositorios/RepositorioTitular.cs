namespace Aseguradora.Repositorios;

using System.Collections.Generic;
using Aseguradora.Aplicacion;

public class RepositorioTitular : IRepositorioTitular
{
    public readonly string _nombreRepositorio = "RepositorioTitular.txt";
    public void AgregarTitular(Titular titular)
    {
        using var sw = new StreamWriter(_nombreRepositorio, true);
        sw.WriteLine(titular.AStringParaTxt());
    }

    public void EliminarTitular(int id)
    {
        var list = ListarTitulares();
        if (list.RemoveAll(titular => titular.Id == id) == 0)
        {
            throw new Exception($"El titular de id {id} no existe");
        }
        using var sw = new StreamWriter(_nombreRepositorio);
        foreach (var t in list)
        {
            sw.WriteLine(t.AStringParaTxt());
        }
    }

    public void ModificarTitular(Titular titular)
    {
        var list = ListarTitulares();
        var index = list.FindIndex(t => t.DNI == titular.DNI);
        if (index == -1)
        {
            throw new Exception($"La titular de DNI {titular.DNI} no existe");
        }
        else
        {
            list[index] = titular;
        }
        using var sw = new StreamWriter(_nombreRepositorio);
        foreach (var t in list)
        {
            sw.WriteLine(t.AStringParaTxt());
        }
    }

    public List<Titular> ListarTitulares()
    {
        using var sr = new StreamReader(_nombreRepositorio);
        var list = new List<Titular>();
        while (!sr.EndOfStream)
        {
            list.Add(new Titular(sr.ReadLine() ?? ""));
        }
        return list;
    }

    public List<string> ListarTitularesConSusVehiculos()
    {
        var list = ListarTitulares();
        var listTitConV = new List<string>();
        string? st;
        foreach (Titular t in list)
        {
            st = "";
            st += t.ToString() + " - Vehiculos: [";
            foreach (Vehiculo v in t.ListaVehiculos)
            {
                st += v.ToString() + "; ";
            }
            st += "]";
            listTitConV.Add(st);
        }
        return listTitConV;
    }
}