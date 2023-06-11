using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;
using Microsoft.EntityFrameworkCore;

namespace Aseguradora.Repositorios;

public class RepositorioSiniestro : IRepositorioSiniestro
{
    public Error AgregarSiniestro(Siniestro siniestro)
    {
        var error = new Error();
        using (var db = new AseguradoraContext())
        {
            var poliza = db.Polizas.Where(p => p.Id == siniestro.PolizaId).SingleOrDefault();
            if (poliza != null)
            {
                if ((siniestro.FechaOcurrencia >= poliza.FechaInicioVigencia) && (siniestro.FechaOcurrencia <= poliza.FechaFinVigencia))
                {
                    db.Add(siniestro);
                    db.SaveChanges();
                }
                else
                {
                    error.Mensaje = "La fecha de ocurrencia del siniestro no se encuentra dentro de la fecha de vigencia de la póliza correspondiente";
                }
            }
            else
            {
                error.Mensaje = "No hay ninguna póliza con Id " + siniestro.PolizaId;
            }
        }
        return error;
    }

    public List<Siniestro> ListarSiniestros()
    {
        var lista = new List<Siniestro>();
        using (var db = new AseguradoraContext())
        {
            lista = db.Siniestros.ToList();
        }
        return lista;
    }

    public Error ModificarSiniestro(Siniestro siniestro)
    {
        var error = new Error();
        using (var db = new AseguradoraContext())
        {
            var siniestroAModificar = db.Siniestros.Where(s => s.Id == siniestro.Id).SingleOrDefault();
            if (siniestroAModificar != null)
            {
                var poliza = db.Polizas.Where(p => p.Id == siniestro.PolizaId).SingleOrDefault();
                if (poliza != null)
                {
                    if ((siniestro.FechaOcurrencia >= poliza.FechaInicioVigencia) && (siniestro.FechaOcurrencia <= poliza.FechaFinVigencia))
                    {
                        siniestroAModificar.Descripcion = siniestro.Descripcion;
                        siniestroAModificar.DireccionSiniestro = siniestro.DireccionSiniestro;
                        siniestroAModificar.FechaOcurrencia = siniestro.FechaOcurrencia;
                        siniestroAModificar.PolizaId = siniestro.PolizaId;
                        db.SaveChanges();
                    }
                    else
                    {
                        error.Mensaje = "La fecha de ocurrencia del siniestro no se encuentra dentro de la fecha de vigencia de la póliza correspondiente";
                    }
                }
                else
                {
                    error.Mensaje = "No hay ninguna póliza con Id " + siniestro.PolizaId;
                }
            }
            else
            {
                error.Mensaje = "No hay ningún siniestro con Id " + siniestro.Id;
            }
        }
        return error;
    }

    public Error EliminarSiniestro(int id)
    {
        var error = new Error();
        using (var db = new AseguradoraContext())
        {
            // var siniestroABorrar = db.Siniestros.Where(s => s.Id == id).SingleOrDefault();
            // if (siniestroABorrar != null)
            // {
            //     foreach (var tercero in siniestroABorrar.Terceros)
            //     {
            //         db.Remove(tercero);
            //     }
            //     db.Remove(siniestroABorrar);
            //     db.SaveChanges();
            // }

            var siniestroABorrar = db.Siniestros.Where(s => s.Id == id).Include(s => s.Terceros).SingleOrDefault();
            if (siniestroABorrar != null)
            {
                db.RemoveRange(siniestroABorrar.Terceros);
                db.Remove(siniestroABorrar);
                db.SaveChanges();
            }
            else
            {
                error.Mensaje = "No hay ningún siniestro con Id " + id;
            }
        }
        return error;
    }

    public Siniestro? GetSiniestro(int id)
    {
        using (var db = new AseguradoraContext())
        {
            return db.Siniestros.Where(t => t.Id == id).SingleOrDefault();
        }
    }
}
