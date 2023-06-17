using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;
using Aseguradora.Aplicacion.ClassUtils;

namespace Aseguradora.Repositorios;

public class RepositorioTitular : IRepositorioTitular
{
    public void AgregarTitular(Titular titular)
    {
        using (var db = new AseguradoraContext())
        {
            db.Add(titular);
            db.SaveChanges();
        }
    }

    public List<Titular> ListarTitulares()
    {
        var lista = new List<Titular>();
        using (var db = new AseguradoraContext())
        {
            lista = db.Titulares.ToList();
        }
        return lista;
    }

    public Error ModificarTitular(Titular titular)
    {
        var error = new Error();
        using (var db = new AseguradoraContext())
        {
            var titularAModificar = db.Titulares.Where(t => t.Id == titular.Id).SingleOrDefault();
            if (titularAModificar != null)
            {
                titularAModificar.Nombre = titular.Nombre;
                titularAModificar.Apellido = titular.Apellido;
                titularAModificar.Direccion = titular.Direccion;
                titularAModificar.DNI = titular.DNI;
                titularAModificar.Email = titular.Email;
                titularAModificar.Telefono = titular.Telefono;
                db.SaveChanges();
            }
            else
            {
                error.Mensaje = "No hay ningún titular con Id " + titular.Id;
            }
        }
        return error;
    }

    public Error EliminarTitular(int id)
    {
        var error = new Error();
        using (var db = new AseguradoraContext())
        {
            var titularABorrar = db.Titulares
            .Where(t => t.Id == id)
            .SingleOrDefault();

            if (titularABorrar != null)
            {
                db.Remove(titularABorrar);
                db.SaveChanges();
            }
            else
            {
                error.Mensaje = "No hay ningún titular con Id " + id;
            }
        }
        return error;
    }

    public Titular? GetTitular(int id){
        using (var db = new AseguradoraContext())
        {
            return db.Titulares.Where(t => t.Id == id).SingleOrDefault();
        }
    }
}
