using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.Interfaces;
public interface IRepositorioTitular
{
    void AgregarTitular(Titular titular);
    void EliminarTitular(int id);
    void ModificarTitular(Titular titular);
    List<Titular> ListarTitulares();
}