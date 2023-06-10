using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;

public class GetVehiculoUseCase : VehiculoUseCase
{
    public GetVehiculoUseCase(IRepositorioVehiculo repositorio) : base(repositorio) { }

    public Vehiculo? Ejecutar(int id) => Repositorio.GetVehiculo(id);
}