namespace Aseguradora.Aplicacion;

public class EliminarVehiculoUseCase
{
    private readonly IRepositorioVehiculo _repositorio;

    public EliminarVehiculoUseCase(IRepositorioVehiculo repositorio) => this._repositorio = repositorio;

    public void Ejecutar(int id) => _repositorio.EliminarVehiculo(id);
}