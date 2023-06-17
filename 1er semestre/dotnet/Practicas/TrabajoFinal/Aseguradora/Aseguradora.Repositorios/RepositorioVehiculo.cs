using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;
using Aseguradora.Aplicacion.ClassUtils;

namespace Aseguradora.Repositorios;

public class RepositorioVehiculo : IRepositorioVehiculo
{
    public void AgregarVehiculo(Vehiculo vehiculo)
    {
        using (var db = new AseguradoraContext())
        {
            db.Add(vehiculo);
            db.SaveChanges();
        }
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
                vehiculoAModificar.Dominio = vehiculo.Dominio;
                vehiculoAModificar.AñoFabricacion = vehiculo.AñoFabricacion;
                vehiculoAModificar.Marca = vehiculo.Marca;
                vehiculoAModificar.TitularId = vehiculo.TitularId;
                db.SaveChanges();
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
            .SingleOrDefault();

            if (vehiculoABorrar != null)
            {
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
