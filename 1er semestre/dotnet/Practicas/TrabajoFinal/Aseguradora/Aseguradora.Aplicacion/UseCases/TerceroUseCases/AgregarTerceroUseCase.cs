using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;

public class AgregarTerceroUseCase : TerceroUseCase
{

    public AgregarTerceroUseCase(IRepositorioTercero repositorio) : base(repositorio) { }

    public Error Ejecutar(Tercero tercero) => Repositorio.AgregarTercero(tercero);
}