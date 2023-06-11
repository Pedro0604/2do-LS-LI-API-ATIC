using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;
using Microsoft.EntityFrameworkCore;

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
                vehiculoAModificar.Dominio = vehiculo.Dominio;
                vehiculoAModificar.AñoFabricacion = vehiculo.AñoFabricacion;
                vehiculoAModificar.Marca = vehiculo.Marca;
                vehiculoAModificar.TitularId = vehiculo.TitularId;
                db.SaveChanges();
            }
        }
    }

    public void EliminarVehiculo(int id)
    {
        using (var db = new AseguradoraContext())
        {
            // var vehiculoABorrar = db.Vehiculos.Where(v => v.Id == id).SingleOrDefault();
            // if (vehiculoABorrar != null)
            // {
            //     foreach (var poliza in vehiculoABorrar.Polizas)
            //     {
            //         foreach (var siniestro in poliza.Siniestros)
            //         {
            //             foreach (var tercero in siniestro.Terceros)
            //             {
            //                 db.Remove(tercero);
            //             }
            //             db.Remove(siniestro);
            //         }
            //         db.Remove(poliza);
            //     }
            //     db.Remove(vehiculoABorrar);
            //     db.SaveChanges();
            // }

            // var vehiculoABorrar = db.Vehiculos.Where(v => v.Id == id).Include(v => v.Polizas).SingleOrDefault();
            // if (vehiculoABorrar != null)
            // {
            //     vehiculoABorrar.Polizas?.ToList().
            //     ForEach(poliza =>
            //     {
            //         var polizaABorrar = db.Polizas.Where(p => p.Id == poliza.Id).Include(p => p.Siniestros).SingleOrDefault();
            //         if (polizaABorrar != null)
            //         {
            //             polizaABorrar.Siniestros?.ToList().
            //             ForEach(siniestro =>
            //             {
            //                 var siniestroABorrar = db.Siniestros.Where(s => s.Id == siniestro.Id).Include(s => s.Terceros).SingleOrDefault();
            //                 if (siniestroABorrar != null)
            //                 {
            //                     siniestroABorrar.Terceros?.ToList().
            //                     ForEach(tercero =>
            //                     {
            //                         db.Remove(tercero);
            //                     });
            //                     db.Remove(siniestroABorrar);
            //                 }
            //             });
            //             db.Remove(polizaABorrar);
            //         }
            //     });
            //     db.Remove(vehiculoABorrar);
            //     db.SaveChanges();
            // }

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
        }
    }

    public Vehiculo? GetVehiculo(int id)
    {
        using (var db = new AseguradoraContext())
        {
            return db.Vehiculos.Where(t => t.Id == id).SingleOrDefault();
        }
    }
}
