namespace Aseguradora.Aplicacion;

public class AgregarVehiculoUseCase
{
    private readonly IRepositorioVehiculo _repositorio;
    private static int s_ultimoId { get; set; }

    public AgregarVehiculoUseCase(IRepositorioVehiculo repositorio) => this._repositorio = repositorio;

    public void Ejecutar(Vehiculo vehiculo)
    {
        _repositorio.AgregarVehiculo(vehiculo);
    }
}