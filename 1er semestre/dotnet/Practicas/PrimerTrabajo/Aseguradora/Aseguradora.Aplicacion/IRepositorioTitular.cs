namespace Aseguradora.Aplicacion;
public interface IRepositorioTitular
{
    void AgregarTitular(Titular titular);
    bool EliminarTitular(int id);
    bool ModificarTitular(Titular titular);
    List<Titular> ListarTitulares();
    List<string> ListarTitularesConSusVehiculos();
}