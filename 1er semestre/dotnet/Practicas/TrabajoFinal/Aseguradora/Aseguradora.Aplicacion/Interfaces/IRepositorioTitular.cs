using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.Interfaces;
public interface IRepositorioTitular
{
    void AgregarTitular(Titular titular);
    Error EliminarTitular(int id);
    Error ModificarTitular(Titular titular);
    List<Titular> ListarTitulares();
    Titular? GetTitular(int id);
}