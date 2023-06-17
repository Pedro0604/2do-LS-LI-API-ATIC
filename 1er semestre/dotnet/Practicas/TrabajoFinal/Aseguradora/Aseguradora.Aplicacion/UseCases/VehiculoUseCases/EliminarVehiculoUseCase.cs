using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.ClassUtils;

namespace Aseguradora.Aplicacion.UseCases;

public class EliminarVehiculoUseCase : VehiculoUseCase
{

    public EliminarVehiculoUseCase(IRepositorioVehiculo repositorio) : base(repositorio) { }

    public Error Ejecutar(int id) => Repositorio.EliminarVehiculo(id);
}