using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;

public class GetTerceroUseCase : TerceroUseCase
{
    public GetTerceroUseCase(IRepositorioTercero repositorio) : base(repositorio) { }

    public Tercero? Ejecutar(int id) => Repositorio.GetTercero(id);
}