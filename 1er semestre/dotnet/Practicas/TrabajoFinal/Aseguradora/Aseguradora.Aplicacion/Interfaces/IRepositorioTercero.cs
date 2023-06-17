using Aseguradora.Aplicacion.Entidades;
using Aseguradora.Aplicacion.ClassUtils;

namespace Aseguradora.Aplicacion.Interfaces;
public interface IRepositorioTercero
{
    void AgregarTercero(Tercero Tercero);
    Error EliminarTercero(int id);
    Error ModificarTercero(Tercero Tercero);
    List<Tercero> ListarTerceros();
    Tercero? GetTercero(int id);
}