using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;
using Microsoft.EntityFrameworkCore;

namespace Aseguradora.Repositorios;

public class RepositorioPoliza : IRepositorioPoliza
{
    public Error AgregarPoliza(Poliza poliza)
    {
        var error = new Error();
        using (var db = new AseguradoraContext())
        {
            var vehiculo = db.Vehiculos.Where(p => p.Id == poliza.VehiculoId).SingleOrDefault();
            if (vehiculo != null)
            {
                db.Add(poliza);
                db.SaveChanges();
            }
            else
            {
                error.Mensaje = "No hay ningún vehículo con Id " + poliza.VehiculoId;
            }
        }
        return error;
    }

    public List<Poliza> ListarPolizas()
    {
        var lista = new List<Poliza>();
        using (var db = new AseguradoraContext())
        {
            lista = db.Polizas.ToList();
        }
        return lista;
    }

    public Error ModificarPoliza(Poliza poliza)
    {
        var error = new Error();
        using (var db = new AseguradoraContext())
        {
            var polizaAModificar = db.Polizas.Where(p => p.Id == poliza.Id).SingleOrDefault();
            if (polizaAModificar != null)
            {
                var vehiculo = db.Vehiculos.Where(p => p.Id == poliza.VehiculoId).SingleOrDefault();
                if (vehiculo != null)
                {
                    polizaAModificar.FechaFinVigencia = poliza.FechaFinVigencia;
                    polizaAModificar.FechaInicioVigencia = poliza.FechaInicioVigencia;
                    polizaAModificar.Franquicia = poliza.Franquicia;
                    polizaAModificar.TipoDeCobertura = poliza.TipoDeCobertura;
                    polizaAModificar.ValorAsegurado = poliza.ValorAsegurado;
                    polizaAModificar.VehiculoId = poliza.VehiculoId;
                    db.SaveChanges();
                }
                else
                {
                    error.Mensaje = "No hay ningún vehículo con Id " + poliza.VehiculoId;
                }
            }
            else
            {
                error.Mensaje = "No hay ninguna póliza con Id " + poliza.Id;
            }
        }
        return error;
    }

    public Error EliminarPoliza(int id)
    {
        var error = new Error();
        using (var db = new AseguradoraContext())
        {
            // var polizaABorrar = db.Polizas.Where(p => p.Id == id).SingleOrDefault();
            // if (polizaABorrar != null)
            // {
            //     foreach (var siniestro in polizaABorrar.Siniestros)
            //     {
            //         foreach (var tercero in siniestro.Terceros)
            //         {
            //             db.Remove(tercero);
            //         }
            //         db.Remove(siniestro);
            //     }
            //     db.Remove(polizaABorrar);
            //     db.SaveChanges();
            // }

            // var polizaABorrar = db.Polizas.Where(p => p.Id == id).Include(p => p.Siniestros).SingleOrDefault();
            // if (polizaABorrar != null)
            // {
            //     polizaABorrar.Siniestros?.ToList().
            //     ForEach(siniestro =>
            //     {
            //         var siniestroABorrar = db.Siniestros.Where(s => s.Id == siniestro.Id).Include(s => s.Terceros).SingleOrDefault();
            //         if (siniestroABorrar != null)
            //         {
            //             siniestroABorrar.Terceros?.ToList().
            //             ForEach(tercero =>
            //             {
            //                 db.Remove(tercero);
            //             });
            //             db.Remove(siniestroABorrar);
            //         }
            //     });
            //     db.Remove(polizaABorrar);
            //     db.SaveChanges();
            // }

            var polizaABorrar = db.Polizas
            .Where(p => p.Id == id)
            .Include(p => p.Siniestros)
            .ThenInclude(s => s.Terceros)
            .SingleOrDefault();

            if (polizaABorrar != null)
            {
                foreach (var siniestro in polizaABorrar.Siniestros)
                {
                    db.RemoveRange(siniestro.Terceros);
                    db.Remove(siniestro);
                }
                db.Remove(polizaABorrar);
                db.SaveChanges();
            }
            else
            {
                error.Mensaje = "No hay ninguna póliza con Id " + id;
            }
        }
        return error;
    }

    public Poliza? GetPoliza(int id)
    {
        using (var db = new AseguradoraContext())
        {
            return db.Polizas.Where(t => t.Id == id).SingleOrDefault();
        }
    }
}