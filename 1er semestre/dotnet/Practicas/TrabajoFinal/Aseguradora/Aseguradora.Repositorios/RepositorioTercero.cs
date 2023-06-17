using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;
using Aseguradora.Aplicacion.ClassUtils;

namespace Aseguradora.Repositorios;

public class RepositorioTercero : IRepositorioTercero
{
    public void AgregarTercero(Tercero tercero)
    {
        using (var db = new AseguradoraContext())
        {
            db.Add(tercero);
            db.SaveChanges();
        }
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
            var terceroABorrar = db.Terceros
            .Where(t => t.Id == id)
            .SingleOrDefault();

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
