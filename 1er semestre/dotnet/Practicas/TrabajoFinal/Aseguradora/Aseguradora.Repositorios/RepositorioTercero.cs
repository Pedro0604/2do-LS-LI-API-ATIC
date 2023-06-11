using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;
using Microsoft.EntityFrameworkCore;

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

    public void ModificarTercero(Tercero tercero)
    {
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
        }
    }

    public void EliminarTercero(int id)
    {
        using (var db = new AseguradoraContext())
        {
            var terceroABorrar = db.Terceros.Where(t => t.Id == id).SingleOrDefault();
            if (terceroABorrar != null)
            {
                db.Remove(terceroABorrar);
                db.SaveChanges();
            }
        }
    }

    public Tercero? GetTercero(int id)
    {
        using (var db = new AseguradoraContext())
        {
            return db.Terceros.Where(t => t.Id == id).SingleOrDefault();
        }
    }
}
