using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

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

    public void ModificarTitular(Titular titular)
    {
        using (var db = new AseguradoraContext())
        {
            var titularAModificar = db.Titulares.Where(t => t.Id == titular.Id).SingleOrDefault();
            if (titularAModificar != null)
            {
                titularAModificar = titular;
                db.SaveChanges();
            }
        }
    }

    public void EliminarTitular(int id)
    {
        using (var db = new AseguradoraContext())
        {
            var titularABorrar = db.Titulares.Where(t => t.Id == id).SingleOrDefault();
            if (titularABorrar != null)
            {
                foreach (var vehiculo in titularABorrar.Vehiculos)
                {
                    foreach (var poliza in vehiculo.Polizas)
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
                    db.Remove(vehiculo);
                }
                db.Remove(titularABorrar);
                db.SaveChanges();
            }
        }
    }

    public List<string> ListarTitularesConSusVehiculos()
    {
        var lista = new List<string>();
        using (var db = new AseguradoraContext())
        {
            lista = null;
        }
        return lista;
    }
}
