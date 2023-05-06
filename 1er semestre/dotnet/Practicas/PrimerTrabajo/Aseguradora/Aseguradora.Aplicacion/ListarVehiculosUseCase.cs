namespace Aseguradora.Aplicacion;

public class ListarVehiculosUseCase
{
    private readonly IRepositorioVehiculo _repositorio;

    public ListarVehiculosUseCase(IRepositorioVehiculo repositorio) => this._repositorio = repositorio;

    public List<Vehiculo> Ejecutar() => _repositorio.ListarVehiculos();
}