using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.Interfaces;
public interface IRepositorioVehiculo
{
    Error AgregarVehiculo(Vehiculo vehiculo);
    Error EliminarVehiculo(int id);
    Error ModificarVehiculo(Vehiculo vehiculo);
    List<Vehiculo> ListarVehiculos();
    Vehiculo? GetVehiculo(int id);
}