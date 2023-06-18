using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;
using Aseguradora.Aplicacion.ClassUtils;

namespace Aseguradora.Repositorios;

public class RepositorioSiniestro : IRepositorioSiniestro
{
    public void AgregarSiniestro(Siniestro siniestro)
    {
        using (var db = new AseguradoraContext())
        {
            db.Add(siniestro);
            db.SaveChanges();
        }
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
                siniestroAModificar.Descripcion = siniestro.Descripcion;
                siniestroAModificar.DireccionSiniestro = siniestro.DireccionSiniestro;
                siniestroAModificar.FechaOcurrencia = siniestro.FechaOcurrencia;
                siniestroAModificar.PolizaId = siniestro.PolizaId;
                db.SaveChanges();
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
            var siniestroABorrar = db.Siniestros.Where(s => s.Id == id).SingleOrDefault();

            if (siniestroABorrar != null)
            {
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
