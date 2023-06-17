using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;
using Aseguradora.Aplicacion.ClassUtils;

namespace Aseguradora.Aplicacion.UseCases;

public class AgregarTerceroUseCase : TerceroUseCase
{
    protected IRepositorioSiniestro RepositorioSiniestro { get; private set; }
    public AgregarTerceroUseCase(IRepositorioTercero repositorio, IRepositorioSiniestro repositorioSiniestro) : base(repositorio) => RepositorioSiniestro = repositorioSiniestro;

    public Error Ejecutar(Tercero tercero)
    {
        Error error = new Error();
        var siniestro = RepositorioSiniestro.ListarSiniestros().Where(p => p.Id == tercero.SiniestroId).SingleOrDefault();
        if (siniestro != null)
        {
            Repositorio.AgregarTercero(tercero);
        }
        else
        {
            error.Mensaje = "No hay ningún siniestro con Id " + tercero.SiniestroId;
        }
        return error;
    }
}