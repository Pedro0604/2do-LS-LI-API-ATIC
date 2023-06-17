using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;
using Aseguradora.Aplicacion.ClassUtils;

namespace Aseguradora.Aplicacion.UseCases;
public class ModificarSiniestroUseCase : SiniestroUseCase
{
    protected IRepositorioPoliza RepositorioPoliza { get; private set; }
    public ModificarSiniestroUseCase(IRepositorioSiniestro repositorio, IRepositorioPoliza repositorioPoliza) : base(repositorio) => RepositorioPoliza = repositorioPoliza;

    public Error Ejecutar(Siniestro siniestro)
    {
        Error error = new Error();
        var poliza = RepositorioPoliza.ListarPolizas().Where(p => p.Id == siniestro.PolizaId).SingleOrDefault();
        if (poliza != null)
        {
            if ((siniestro.FechaOcurrencia >= poliza.FechaInicioVigencia) && (siniestro.FechaOcurrencia <= poliza.FechaFinVigencia))
            {
                error = Repositorio.ModificarSiniestro(siniestro);
            }
            else
            {
                error.Mensaje = "La fecha de ocurrencia del siniestro no se encuentra dentro de la fecha de vigencia de la póliza correspondiente";
            }
        }
        else
        {
            error.Mensaje = "No hay ninguna póliza con Id " + siniestro.PolizaId;
        }
        return error;
    }
}