using Aseguradora.Aplicacion.Entidades;
using Aseguradora.Aplicacion.ClassUtils;

namespace Aseguradora.Aplicacion.Interfaces;
public interface IRepositorioTitular
{
    Error AgregarTitular(Titular titular);
    Error EliminarTitular(int id);
    Error ModificarTitular(Titular titular);
    List<Titular> ListarTitulares();
    Titular? GetTitular(int id);
}