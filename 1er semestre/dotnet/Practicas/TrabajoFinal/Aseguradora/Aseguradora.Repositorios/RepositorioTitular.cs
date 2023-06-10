using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;
using Microsoft.EntityFrameworkCore;

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
            // var titularABorrar = db.Titulares.Where(t => t.Id == id).Include(t => t.Vehiculos).SingleOrDefault();
            // if (titularABorrar != null)
            // {
            //     titularABorrar.Vehiculos?.ToList()
            //     .ForEach(vehiculo =>
            //     {
            //         var vehiculoABorrar = db.Vehiculos.Where(v => v.Id == vehiculo.Id).Include(v => v.Polizas).SingleOrDefault();
            //         if (vehiculoABorrar != null)
            //         {
            //             vehiculoABorrar.Polizas?.ToList().
            //             ForEach(poliza =>
            //             {
            //                 var polizaABorrar = db.Polizas.Where(p => p.Id == poliza.Id).Include(p => p.Siniestros).SingleOrDefault();
            //                 if (polizaABorrar != null)
            //                 {
            //                     polizaABorrar.Siniestros?.ToList().
            //                     ForEach(siniestro =>
            //                     {
            //                         var siniestroABorrar = db.Siniestros.Where(s => s.Id == siniestro.Id).Include(s => s.Terceros).SingleOrDefault();
            //                         if (siniestroABorrar != null)
            //                         {
            //                             siniestroABorrar.Terceros?.ToList().
            //                             ForEach(tercero =>
            //                             {
            //                                 db.Remove(tercero);
            //                             });
            //                             db.Remove(siniestroABorrar);
            //                         }
            //                     });
            //                     db.Remove(polizaABorrar);
            //                 }
            //             });
            //             db.Remove(vehiculoABorrar);
            //         }
            //     });
            //     db.Remove(titularABorrar);
            //     db.SaveChanges();
            // }
            
            var titularABorrar = db.Titulares
            .Where(t => t.Id == id)
            .Include(t => t.Vehiculos)
            .ThenInclude(v => v.Polizas)
            .ThenInclude(p => p.Siniestros)
            .ThenInclude(s => s.Terceros)
            .SingleOrDefault();

            if (titularABorrar != null)
            {
                foreach (var vehiculo in titularABorrar.Vehiculos)
                {
                    foreach (var poliza in vehiculo.Polizas)
                    {
                        foreach (var siniestro in poliza.Siniestros)
                        {
                            db.RemoveRange(siniestro.Terceros);
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
