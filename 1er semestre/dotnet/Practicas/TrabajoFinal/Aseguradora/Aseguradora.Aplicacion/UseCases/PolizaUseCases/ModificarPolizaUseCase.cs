using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;
using Aseguradora.Aplicacion.ClassUtils;

namespace Aseguradora.Aplicacion.UseCases;

public class ModificarPolizaUseCase : PolizaUseCase
{
    protected IRepositorioVehiculo RepositorioVehiculo { get; private set; }
    public ModificarPolizaUseCase(IRepositorioPoliza repositorio, IRepositorioVehiculo repositorioVehiculo) : base(repositorio) => RepositorioVehiculo = repositorioVehiculo;

    public Error Ejecutar(Poliza poliza)
    {
        Error error = new Error();
        var vehiculo = RepositorioVehiculo.ListarVehiculos().Where(p => p.Id == poliza.VehiculoId).SingleOrDefault();
        if (vehiculo != null)
        {
            if (poliza.FechaInicioVigencia <= poliza.FechaFinVigencia)
            {
                error = Repositorio.ModificarPoliza(poliza);
            }
            else
            {
                error.Mensaje = "La fecha de inicio de vigencia de la póliza no puede ser menor que la fecha de finalización";
            }
        }
        else
        {
            error.Mensaje = "No hay ningún vehículo con Id " + poliza.VehiculoId;
        }
        return error;
    }
}