namespace Aseguradora.Aplicacion;

public class ModificarVehiculoUseCase
{
    private readonly IRepositorioVehiculo _repositorio;

    public ModificarVehiculoUseCase(IRepositorioVehiculo repositorio) => this._repositorio = repositorio;

    public void Ejecutar(Vehiculo vehiculo) => _repositorio.ModificarVehiculo(vehiculo);
}