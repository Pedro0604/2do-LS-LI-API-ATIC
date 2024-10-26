using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;
using Aseguradora.Aplicacion.ClassUtils;

namespace Aseguradora.Repositorios;

public class RepositorioPoliza : IRepositorioPoliza
{
    public void AgregarPoliza(Poliza poliza)
    {
        using (var db = new AseguradoraContext())
        {
            db.Add(poliza);
            db.SaveChanges();
        }
    }

    public List<Poliza> ListarPolizas()
    {
        var lista = new List<Poliza>();
        using (var db = new AseguradoraContext())
        {
            lista = db.Polizas.ToList();
        }
        return lista;
    }

    public Error ModificarPoliza(Poliza poliza)
    {
        var error = new Error();
        using (var db = new AseguradoraContext())
        {
            var polizaAModificar = db.Polizas.Where(p => p.Id == poliza.Id).SingleOrDefault();
            if (polizaAModificar != null)
            {
                polizaAModificar.FechaFinVigencia = poliza.FechaFinVigencia;
                polizaAModificar.FechaInicioVigencia = poliza.FechaInicioVigencia;
                polizaAModificar.Franquicia = poliza.Franquicia;
                polizaAModificar.TipoDeCobertura = poliza.TipoDeCobertura;
                polizaAModificar.ValorAsegurado = poliza.ValorAsegurado;
                polizaAModificar.VehiculoId = poliza.VehiculoId;
                db.SaveChanges();
            }
            else
            {
                error.Mensaje = "No hay ninguna póliza con Id " + poliza.Id;
            }
        }
        return error;
    }

    public Error EliminarPoliza(int id)
    {
        var error = new Error();
        using (var db = new AseguradoraContext())
        {
            var polizaABorrar = db.Polizas.Where(p => p.Id == id).SingleOrDefault();

            if (polizaABorrar != null)
            {
                db.Remove(polizaABorrar);
                db.SaveChanges();
            }
            else
            {
                error.Mensaje = "No hay ninguna póliza con Id " + id;
            }
        }
        return error;
    }

    public Poliza? GetPoliza(int id)
    {
        using (var db = new AseguradoraContext())
        {
            return db.Polizas.Where(t => t.Id == id).SingleOrDefault();
        }
    }
}