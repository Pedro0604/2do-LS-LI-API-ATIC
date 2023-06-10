using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;
using Microsoft.EntityFrameworkCore;

namespace Aseguradora.Repositorios;

public class RepositorioSiniestro : IRepositorioSiniestro
{
    public bool AgregarSiniestro(Siniestro siniestro)
    {
        using (var db = new AseguradoraContext())
        {
            var poliza = db.Polizas.Where(p => p.Id == siniestro.PolizaId).SingleOrDefault();
            if (poliza != null)
            {
                if ((siniestro.FechaOcurrencia >= poliza.FechaInicioVigencia) && (siniestro.FechaOcurrencia <= poliza.FechaFinVigencia))
                {
                    db.Add(siniestro);
                    db.SaveChanges();
                    return true;
                }
            }
        }
        return false;
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

    public void ModificarSiniestro(Siniestro siniestro)
    {
        using (var db = new AseguradoraContext())
        {
            var siniestroAModificar = db.Siniestros.Where(s => s.Id == siniestro.Id).SingleOrDefault();
            if (siniestroAModificar != null)
            {
                siniestroAModificar = siniestro;
                db.SaveChanges();
            }
        }
    }

    public void EliminarSiniestro(int id)
    {
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
        }
    }

    public Siniestro? GetSiniestro(int id)
    {
        using (var db = new AseguradoraContext())
        {
            return db.Siniestros.Where(t => t.Id == id).SingleOrDefault();
        }
    }
}
