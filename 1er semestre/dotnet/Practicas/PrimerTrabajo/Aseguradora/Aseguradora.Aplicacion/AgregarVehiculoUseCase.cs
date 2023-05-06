namespace Aseguradora.Aplicacion;

public class AgregarVehiculoUseCase
{
    private readonly IRepositorioVehiculo _repositorio;

    public AgregarVehiculoUseCase(IRepositorioVehiculo repositorio) => this._repositorio = repositorio;

    public void Ejecutar(Vehiculo vehiculo) => _repositorio.AgregarVehiculo(vehiculo);
}