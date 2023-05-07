namespace Aseguradora.Aplicacion;
public interface IRepositorioVehiculo
{
    void AgregarVehiculo(Vehiculo vehiculo);
    bool EliminarVehiculo(int id);
    bool ModificarVehiculo(Vehiculo vehiculo);
    List<Vehiculo> ListarVehiculos();
}