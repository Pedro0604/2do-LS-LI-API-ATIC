using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;
using Aseguradora.Aplicacion.ClassUtils;

namespace Aseguradora.Aplicacion.UseCases;

public class AgregarPolizaUseCase : PolizaUseCase
{
    protected IRepositorioVehiculo RepositorioVehiculo { get; private set; }
    public AgregarPolizaUseCase(IRepositorioPoliza repositorio, IRepositorioVehiculo repositorioVehiculo) : base(repositorio) => RepositorioVehiculo = repositorioVehiculo;

    public Error Ejecutar(Poliza poliza)
    {
        Error error = new Error();
        var vehiculo = RepositorioVehiculo.ListarVehiculos().Where(p => p.Id == poliza.VehiculoId).SingleOrDefault();
        if (vehiculo != null)
        {
            Repositorio.AgregarPoliza(poliza);
        }
        else
        {
            error.Mensaje = "No hay ningún vehículo con Id " + poliza.VehiculoId;
        }
        return error;
    }
}