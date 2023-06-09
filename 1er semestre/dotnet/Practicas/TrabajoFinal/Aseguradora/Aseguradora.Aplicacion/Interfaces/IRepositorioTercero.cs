using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.Interfaces;
public interface IRepositorioTercero
{
    void AgregarTercero(Tercero Tercero);
    void EliminarTercero(int id);
    void ModificarTercero(Tercero Tercero);
    List<Tercero> ListarTerceros();
}