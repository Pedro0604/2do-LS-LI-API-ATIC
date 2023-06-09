using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

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

    public void ModificarVehiculo(Vehiculo vehiculo)
    {
        using (var db = new AseguradoraContext())
        {
            var vehiculoAModificar = db.Vehiculos.Where(v => v.Id == vehiculo.Id).SingleOrDefault();
            if (vehiculoAModificar != null)
            {
                vehiculoAModificar = vehiculo;
                db.SaveChanges();
            }
        }
    }

    public void EliminarVehiculo(int id)
    {
        using (var db = new AseguradoraContext())
        {
            var vehiculoABorrar = db.Vehiculos.Where(v => v.Id == id).SingleOrDefault();
            if (vehiculoABorrar != null)
            {
                foreach (var poliza in vehiculoABorrar.Polizas)
                {
                    foreach (var siniestro in poliza.Siniestros)
                    {
                        foreach (var tercero in siniestro.Terceros)
                        {
                            db.Remove(tercero);
                        }
                        db.Remove(siniestro);
                    }
                    db.Remove(poliza);
                }
                db.Remove(vehiculoABorrar);
                db.SaveChanges();
            }
        }
    }
}
