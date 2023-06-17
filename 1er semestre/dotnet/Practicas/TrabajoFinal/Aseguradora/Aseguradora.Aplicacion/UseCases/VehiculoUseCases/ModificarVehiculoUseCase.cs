using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;
using Aseguradora.Aplicacion.ClassUtils;

namespace Aseguradora.Aplicacion.UseCases;

public class ModificarVehiculoUseCase : VehiculoUseCase
{
    protected IRepositorioTitular RepositorioTitular { get; private set; }
    public ModificarVehiculoUseCase(IRepositorioVehiculo repositorio, IRepositorioTitular repositorioTitular) : base(repositorio) => RepositorioTitular = repositorioTitular;

    public Error Ejecutar(Vehiculo vehiculo)
    {
        var error = new Error();
        var titular = RepositorioTitular.ListarTitulares().Where(p => p.Id == vehiculo.TitularId).SingleOrDefault();
        if (titular != null)
        {
            Repositorio.ModificarVehiculo(vehiculo);
        }
        else
        {
            error.Mensaje = "No hay ningún titular con Id " + vehiculo.TitularId;
        }
        return error;
    }
}