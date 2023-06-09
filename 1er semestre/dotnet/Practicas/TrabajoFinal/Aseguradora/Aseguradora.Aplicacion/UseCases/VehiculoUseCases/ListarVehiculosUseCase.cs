using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;

public class ListarVehiculosUseCase : VehiculoUseCase
{
    public ListarVehiculosUseCase(IRepositorioVehiculo repositorio) : base(repositorio) { }

    public List<Vehiculo> Ejecutar() => Repositorio.ListarVehiculos();
}