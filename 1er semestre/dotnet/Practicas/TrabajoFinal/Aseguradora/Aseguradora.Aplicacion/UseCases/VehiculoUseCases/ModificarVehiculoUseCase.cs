using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;

public class ModificarVehiculoUseCase : VehiculoUseCase
{
    public ModificarVehiculoUseCase(IRepositorioVehiculo repositorio) : base(repositorio) { }

    public void Ejecutar(Vehiculo Vehiculo) => Repositorio.ModificarVehiculo(Vehiculo);
}