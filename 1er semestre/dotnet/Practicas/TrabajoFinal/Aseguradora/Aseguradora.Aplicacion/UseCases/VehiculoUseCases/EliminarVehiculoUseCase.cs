using Aseguradora.Aplicacion.Interfaces;

namespace Aseguradora.Aplicacion.UseCases;

public class EliminarVehiculoUseCase : VehiculoUseCase
{

    public EliminarVehiculoUseCase(IRepositorioVehiculo repositorio) : base(repositorio) { }

    public void Ejecutar(int id) => Repositorio.EliminarVehiculo(id);
}