namespace Aseguradora.Aplicacion;
public interface IRepositorioVehiculo
{
    void AgregarVehiculo(Vehiculo vehiculo);
    bool EliminarVehiculo(Vehiculo vehiculo);
    bool ModificarVehiculo(Vehiculo vehiculo);
    List<Vehiculo> ListarVehiculos();
}