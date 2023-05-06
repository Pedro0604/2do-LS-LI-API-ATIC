namespace Aseguradora.Aplicacion;

public class EliminarVehiculoUseCase
{
    private readonly IRepositorioVehiculo _repositorio;

    public EliminarVehiculoUseCase(IRepositorioVehiculo repositorio) => this._repositorio = repositorio;

    public void Ejecutar(Vehiculo vehiculo) => _repositorio.EliminarVehiculo(vehiculo);
}