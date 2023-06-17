using Aseguradora.Aplicacion.Entidades;
using Aseguradora.Aplicacion.ClassUtils;

namespace Aseguradora.Aplicacion.Interfaces;
public interface IRepositorioVehiculo
{
    void AgregarVehiculo(Vehiculo vehiculo);
    Error EliminarVehiculo(int id);
    Error ModificarVehiculo(Vehiculo vehiculo);
    List<Vehiculo> ListarVehiculos();
    Vehiculo? GetVehiculo(int id);
}