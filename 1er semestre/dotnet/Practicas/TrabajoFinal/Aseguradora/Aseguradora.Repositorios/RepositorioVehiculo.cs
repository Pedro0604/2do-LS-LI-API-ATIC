using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;
using Microsoft.EntityFrameworkCore;

namespace Aseguradora.Repositorios;

public class RepositorioVehiculo : IRepositorioVehiculo
{
    public Error AgregarVehiculo(Vehiculo vehiculo)
    {
        var error = new Error();
        using (var db = new AseguradoraContext())
        {
            var titular = db.Titulares.Where(p => p.Id == vehiculo.TitularId).SingleOrDefault();
            if (titular != null)
            {
                db.Add(vehiculo);
                db.SaveChanges();
            }
            else
            {
                error.Mensaje = "No hay ningún titular con Id " + vehiculo.TitularId;
            }
        }
        return error;
    }

    public List<Vehiculo> ListarVehiculos()
    {
        var lista = new List<Vehiculo>();
        using (var db = new AseguradoraContext())
        {
            lista = db.Vehiculos.ToList();
        }
        return lista;
    }

    public Error ModificarVehiculo(Vehiculo vehiculo)
    {
        var error = new Error();
        using (var db = new AseguradoraContext())
        {
            var vehiculoAModificar = db.Vehiculos.Where(v => v.Id == vehiculo.Id).SingleOrDefault();
            if (vehiculoAModificar != null)
            {
                var titular = db.Titulares.Where(p => p.Id == vehiculo.TitularId).SingleOrDefault();
                if (titular != null)
                {
                    vehiculoAModificar.Dominio = vehiculo.Dominio;
                    vehiculoAModificar.AñoFabricacion = vehiculo.AñoFabricacion;
                    vehiculoAModificar.Marca = vehiculo.Marca;
                    vehiculoAModificar.TitularId = vehiculo.TitularId;
                    db.SaveChanges();
                }
                else
                {
                    error.Mensaje = "No hay ningún titular con Id " + vehiculo.TitularId;
                }
            }
            else
            {
                error.Mensaje = "No hay ningún vehículo con Id " + vehiculo.Id;
            }
        }
        return error;
    }

    public Error EliminarVehiculo(int id)
    {
        var error = new Error();
        using (var db = new AseguradoraContext())
        {
            var vehiculoABorrar = db.Vehiculos
            .Where(v => v.Id == id)
            .Include(v => v.Polizas)
            .ThenInclude(p => p.Siniestros)
            .ThenInclude(s => s.Terceros)
            .SingleOrDefault();

            if (vehiculoABorrar != null)
            {
                foreach (var poliza in vehiculoABorrar.Polizas)
                {
                    foreach (var siniestro in poliza.Siniestros)
                    {
                        db.RemoveRange(siniestro.Terceros);
                        db.Remove(siniestro);
                    }
                    db.Remove(poliza);
                }
                db.Remove(vehiculoABorrar);
                db.SaveChanges();
            }
            else
            {
                error.Mensaje = "No hay ningún vehículo con Id " + id;
            }
        }
        return error;
    }

    public Vehiculo? GetVehiculo(int id)
    {
        using (var db = new AseguradoraContext())
        {
            return db.Vehiculos.Where(t => t.Id == id).SingleOrDefault();
        }
    }
}
