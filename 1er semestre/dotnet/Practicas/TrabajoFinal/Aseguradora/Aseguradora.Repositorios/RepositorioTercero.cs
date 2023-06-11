using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;
using Microsoft.EntityFrameworkCore;

namespace Aseguradora.Repositorios;

public class RepositorioTercero : IRepositorioTercero
{
    public Error AgregarTercero(Tercero tercero)
    {
        var error = new Error();
        using (var db = new AseguradoraContext())
        {
            var siniestro = db.Siniestros.Where(p => p.Id == tercero.SiniestroId).SingleOrDefault();
            if (siniestro != null)
            {
                db.Add(tercero);
                db.SaveChanges();
            }
            else
            {
                error.Mensaje = "No hay ningún siniestro con Id " + tercero.SiniestroId;
            }
        }
        return error;
    }

    public List<Tercero> ListarTerceros()
    {
        var lista = new List<Tercero>();
        using (var db = new AseguradoraContext())
        {
            lista = db.Terceros.ToList();
        }
        return lista;
    }

    public Error ModificarTercero(Tercero tercero)
    {
        var error = new Error();
        using (var db = new AseguradoraContext())
        {
            var terceroAModificar = db.Terceros.Where(t => t.Id == tercero.Id).SingleOrDefault();
            if (terceroAModificar != null)
            {
                var siniestro = db.Siniestros.Where(p => p.Id == tercero.SiniestroId).SingleOrDefault();
                if (siniestro != null)
                {
                    terceroAModificar.Nombre = tercero.Nombre;
                    terceroAModificar.Apellido = tercero.Apellido;
                    terceroAModificar.DNI = tercero.DNI;
                    terceroAModificar.NombreAseguradora = tercero.NombreAseguradora;
                    terceroAModificar.SiniestroId = tercero.SiniestroId;
                    terceroAModificar.Telefono = tercero.Telefono;
                    db.SaveChanges();
                }
                else
                {
                    error.Mensaje = "No hay ningún siniestro con Id " + tercero.SiniestroId;
                }
            }
            else
            {
                error.Mensaje = "No hay ningún tercero con Id " + tercero.Id;
            }
        }
        return error;
    }

    public Error EliminarTercero(int id)
    {
        var error = new Error();
        using (var db = new AseguradoraContext())
        {
            var terceroABorrar = db.Terceros.Where(t => t.Id == id).SingleOrDefault();
            if (terceroABorrar != null)
            {
                db.Remove(terceroABorrar);
                db.SaveChanges();
            }
            else
            {
                error.Mensaje = "No hay ningún tercero con Id " + id;
            }
        }
        return error;
    }

    public Tercero? GetTercero(int id)
    {
        using (var db = new AseguradoraContext())
        {
            return db.Terceros.Where(t => t.Id == id).SingleOrDefault();
        }
    }
}
