using Aseguradora.Aplicacion.Interfaces;

namespace Aseguradora.Aplicacion.UseCases;

public class EliminarTerceroUseCase: TerceroUseCase
{

    public EliminarTerceroUseCase(IRepositorioTercero repositorio):base(repositorio){}

    public void Ejecutar(int id) => Repositorio.EliminarTercero(id);
}