using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;

public class EliminarTerceroUseCase: TerceroUseCase
{

    public EliminarTerceroUseCase(IRepositorioTercero repositorio):base(repositorio){}

    public Error Ejecutar(int id) => Repositorio.EliminarTercero(id);
}