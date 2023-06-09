namespace Aseguradora.Aplicacion;
public interface IRepositorioTitular
{
    void AgregarTitular(Titular titular);
    void EliminarTitular(int id);
    void ModificarTitular(Titular titular);
    List<Titular> ListarTitulares();
    List<string> ListarTitularesConSusVehiculos();
}