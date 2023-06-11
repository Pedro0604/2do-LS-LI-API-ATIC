using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.Interfaces;
public interface IRepositorioTercero
{
    Error AgregarTercero(Tercero Tercero);
    Error EliminarTercero(int id);
    Error ModificarTercero(Tercero Tercero);
    List<Tercero> ListarTerceros();
    Tercero? GetTercero(int id);
}