using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

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
            var siniestroABorrar = db.Siniestros.Where(s => s.Id == id).SingleOrDefault();
            if (siniestroABorrar != null)
            {
                foreach (var tercero in siniestroABorrar.Terceros)
                {
                    db.Remove(tercero);
                }
                db.Remove(siniestroABorrar);
                db.SaveChanges();
            }
        }
    }
}
